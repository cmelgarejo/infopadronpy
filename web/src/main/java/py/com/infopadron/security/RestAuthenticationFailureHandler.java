package py.com.infopadron.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import py.com.infopadron.exception.UserSuspendedException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by humber on 12/02/14.
 */
public class RestAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
    if (exception != null) {
      if (exception instanceof UserSuspendedException) {
        response.sendError(HttpServletResponse.SC_FORBIDDEN, exception.getMessage());
        logger.info("");
        
      } else {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, exception.getMessage());
      }
    } else {
      response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Bad credentials");
    }

  }
}
