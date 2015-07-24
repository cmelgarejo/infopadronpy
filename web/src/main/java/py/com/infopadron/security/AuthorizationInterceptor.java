package py.com.infopadron.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import py.com.infopadron.service.UserService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AuthorizationInterceptor implements HandlerInterceptor {
  private static final Logger logger = LoggerFactory.getLogger(AuthorizationInterceptor.class);

  @Autowired
  private UserService userService;

 
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

    SessionManager sm = new SessionManager(request);
    UserCurrentInfo user = sm.getUser();

    if (user != null) {
      if (userService.isUserSuspended(user.getUserId())) {
        // User is suspended
        int responseStatus = HttpServletResponse.SC_FORBIDDEN;
        logger.debug("User is suspended. Requesting: " + request.getRequestURI() + " and responding with HTTP " + responseStatus);

        response.setStatus(responseStatus);
        return false;
      }
    }

    return true;
  }

  
  public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

  }

  
  public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

  }
}
