package py.com.infopadron.exception;

import org.springframework.security.core.AuthenticationException;

/**
 *
 * This exception is thrown when the user is suspended by the ROOT user
 *
 *
 */
public class UserSuspendedException extends AuthenticationException {
  public UserSuspendedException(String msg, Throwable t) {
    super(msg, t);
  }

  public UserSuspendedException(String msg) {
    super(msg);
  }
}
