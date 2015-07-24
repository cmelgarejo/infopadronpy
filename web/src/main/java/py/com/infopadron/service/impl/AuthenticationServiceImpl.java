package py.com.infopadron.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import py.com.infopadron.domain.UserEntity;
import py.com.infopadron.domain.UserState;
import py.com.infopadron.security.AuthenticationValidation;
import py.com.infopadron.service.AuthenticationService;
import py.com.infopadron.repository.UserRepository;

import javax.annotation.Resource;

/**
 * Created by humber on 11/02/14.
 */
// FIXME Eliminate the duplication of message and code in this class
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

  private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

  @Resource
  private UserRepository userRepository;

  
  public AuthenticationValidation checkCredentials(String email, String password) {

	  //FIXME Decrypt password here
	  
    UserEntity user = userRepository.findOneByMailAndPassword(email, password);
    if (user == null) {
      logger.error("Bad credentials for '" + email + "'");
      return new AuthenticationValidation(false, null, "Error de usuario o contraseña. Por favor ingrese los valores correctos. '" + email + "'");
    }

    if (UserState.SUSPENDED_BY_ADMIN.toString().equals(user.getState())) {
      logger.info("User: " + user.getMail() +" "+user.getFullname()+ " is suspended by admin");
      return new AuthenticationValidation(false, UserState.SUSPENDED_BY_ADMIN, "Para continuar utilizando la aplicación por favor comuníquese con Agriket: soporte@agriket.com");
    }

    if (UserState.WAITING_FOR_APPROVAL.toString().equals(user.getState())) {
      logger.info("User: " + user.getMail() +" "+user.getFullname()+ " is still waiting for registration approval");
      return new AuthenticationValidation(false, UserState.WAITING_FOR_APPROVAL, "Su cuenta todavía está en espera de aprobación");
    }

    return new AuthenticationValidation();

  }

 
  public AuthenticationValidation checkUserState(String email) {

    UserEntity user = userRepository.findOneByMail(email);

    if (UserState.SUSPENDED_BY_ADMIN.toString().equals(user.getState())) {
      logger.info("User: " + user.getMail() +" "+user.getFullname()+ " is suspended by admin");
      return new AuthenticationValidation(false, UserState.SUSPENDED_BY_ADMIN, "Para continuar utilizando la aplicación por favor comuníquese con Agriket: soporte@agriket.com");
    }

    if (UserState.WAITING_FOR_APPROVAL.toString().equals(user.getState())) {
      logger.info("User: " + user.getMail() +" "+user.getFullname()+ " is still waiting for registration approval");
      return new AuthenticationValidation(false, UserState.WAITING_FOR_APPROVAL, "Su cuenta todavía está en espera de aprobación");
    }

    return new AuthenticationValidation();

  }

}
