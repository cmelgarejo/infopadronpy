package py.com.infopadron.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import py.com.infopadron.domain.UserState;
import py.com.infopadron.exception.UserSuspendedException;
import py.com.infopadron.service.AuthenticationService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


@Component
public class MainAuthenticationProvider implements AuthenticationProvider {

  private static final Logger logger = LoggerFactory.getLogger(MainAuthenticationProvider.class);

  @Autowired
  private AuthenticationService authService;

 
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    Assert.isInstanceOf(UsernamePasswordAuthenticationToken.class, authentication, "Only UsernamePasswordAuthenticationToken is supported");

    final UsernamePasswordAuthenticationToken userToken = (UsernamePasswordAuthenticationToken) authentication;
    String mail = userToken.getName();
    String password = (String) authentication.getCredentials();

    
    AuthenticationValidation checkCredentials = authService.checkCredentials(mail, password);
    if (checkCredentials.getSuccess()) {

      String roles[] = new String[] { "ROLE_USER" };
      logger.debug("Authenticated: " + mail);
      UsernamePasswordAuthenticationToken authenticatedUser = createSuccessfulAuthentication(mail, password, null, roles);

      return authenticatedUser;
    } else {
      if (UserState.SUSPENDED_BY_ADMIN.equals(checkCredentials.getUserState())) {
        throw new UserSuspendedException(checkCredentials.getMessage());
      } else {
        // throw new BadCredentialsException("Bad credentials for '" + mail +
        // "'");
        throw new BadCredentialsException(checkCredentials.getMessage());
      }
    }
  }

  protected UsernamePasswordAuthenticationToken createSuccessfulAuthentication(String mail, String password, Object details, String[] authoritiesList) {

    Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    for (String authority : authoritiesList) {
      authorities.add(new SimpleGrantedAuthority(authority));
    }
    Collection<GrantedAuthority> unmodifiableCollection = Collections.unmodifiableCollection(authorities);
    UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(mail, password, unmodifiableCollection);
    result.setDetails(details);
    

    return result;
  }

  
  public boolean supports(Class<? extends Object> authentication) {
    return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
  }

}