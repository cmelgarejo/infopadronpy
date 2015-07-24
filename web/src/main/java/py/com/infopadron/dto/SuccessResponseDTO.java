package py.com.infopadron.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * Created by Willynx 
 */
public class SuccessResponseDTO {
  private boolean success;
  @JsonInclude(NON_EMPTY)
  private String message;
  @JsonInclude(NON_EMPTY)
  private Map<String, Object> attributes;

  public SuccessResponseDTO(boolean success, String message, Map<String, Object> attributes) {
    this.success = success;
    this.message = message;
    this.attributes = attributes;
  }

  public SuccessResponseDTO() {
    this.success = true;
    this.attributes = new HashMap<String, Object>();
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Map<String, Object> getAttributes() {
    return attributes;
  }

  public void setAttributes(Map<String, Object> attributes) {
    this.attributes = attributes;
  }
}
