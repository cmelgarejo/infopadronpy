package py.com.infopadron.dto;



public class UserProfileDTO {

  /**
   * Every property with the prefix 'trader' refers to trader's info. The rest
   * refers to the user.
   * 
   */

  // These are also trader's properties
  private String ruc;
  private String address;

  /**
   * This is the only exception of an user property that has the 'user' prefix.
   */
  private String userFullname;
  private Long userId;
  private String name;
  private String lastname;
  private String userCellphone;
  private String mail;




  public String getMail() {
    return mail;
  }

  public void setMail(String userMail) {
    this.mail = userMail;
  }

  public String getUserFullname() {
    return userFullname;
  }

  public void setUserFullname(String userFullname) {
    this.userFullname = userFullname;
  }

  public void setRuc(String ruc) {
    this.ruc = ruc;
  }

  public String getRuc() {
    return this.ruc;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getAddress() {
    return this.address;
  }

  public void setUserId(Long id) {
    this.userId = id;
  }

  public Long getUserId() {
    return this.userId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getLastname() {
    return this.lastname;
  }

  public void setUserCellphone(String userCellphone) {
    this.userCellphone = userCellphone;
  }

  public String getUserCellphone() {
    return this.userCellphone;
  }


}
