package py.com.infopadron.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import py.com.infopadron.service.AuthenticationService;
import py.com.infopadron.security.UserCurrentInfo;

public class SecurityHelper {

  private static final Logger logger = LoggerFactory.getLogger(SecurityHelper.class);

  public static Boolean checkUserState(UserCurrentInfo user, AuthenticationService authService) {
    logger.debug("Checking state of current user : " + user.getEmail());
    AuthenticationValidation checkUserState = authService.checkUserState(user.getEmail());
    logger.info("SesionIniciada Email:" + user.getEmail()+" Trader: "+ user.getTraderName() +" Seller: "+ user.getSeller() +" Buyer: "+ user.getBuyer()+" Estado: "+checkUserState.getSuccess());
    return checkUserState.getSuccess();
  }

}
