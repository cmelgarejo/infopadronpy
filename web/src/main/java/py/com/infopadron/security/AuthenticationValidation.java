package py.com.infopadron.security;

import py.com.infopadron.domain.UserState;

public class AuthenticationValidation {

  private String message;
  private Boolean success = true;

  public UserState getUserState() {
    return userState;
  }

  public void setUserState(UserState userState) {
    this.userState = userState;
  }

  private UserState userState;

  public AuthenticationValidation(boolean success, UserState userState, String message) {
    this.message = message;
    this.userState = userState;
    this.success = success;
  }

  public AuthenticationValidation() {
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Boolean getSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

}
