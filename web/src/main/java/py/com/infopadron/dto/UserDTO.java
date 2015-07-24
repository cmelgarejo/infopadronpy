package py.com.infopadron.dto;

import py.com.infopadron.domain.RoleType;



public class UserDTO {
  private Long id;

  private String mail;
  private String name;
  private String lastname;
  private String password;
  private String state;
  private RoleType role;
  private String userCellphone;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public RoleType getRole() {
    return role;
  }

  public void setRole(RoleType role) {
    this.role = role;
  }

  public String getUserCellphone() {
    return userCellphone;
  }

  public void setUserCellphone(String userCellphone) {
    this.userCellphone = userCellphone;
  }
}
