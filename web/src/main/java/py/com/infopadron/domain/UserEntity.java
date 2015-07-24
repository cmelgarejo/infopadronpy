package py.com.infopadron.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "users", schema = "profile")
@SequenceGenerator(name = "users_id_seq", sequenceName = "profile.users_id_seq")
public class UserEntity extends SodepEntity {

  private Long id;

  private String mail;
  private String name;
  private String lastname;
  private String password;
  private String state;
  private RoleType role;

  private String userCellphone;

  public UserEntity() {
  }

  public UserEntity(Long sellerId) {
    setId(sellerId);
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "users_id_seq")
  @Column(name = "id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  // @NotNull
  @Basic
  @Column(name = "mail")
  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  @Basic
  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(name = "lastname")
  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  @Basic
  @Column(name = "password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Basic
  @Column(name = "state")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @Basic
  @Enumerated(EnumType.STRING)
  @Column(name = "role")
  public RoleType getRole() {
    return role;
  }

  public void setRole(RoleType role) {
    this.role = role;
  }

  @Transient
  public String getFullname() {
    return lastname + ", " + name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    UserEntity that = (UserEntity) o;

    if (!id.equals(that.id))
      return false;
    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null)
      return false;
    if (mail != null ? !mail.equals(that.mail) : that.mail != null)
      return false;
    if (name != null ? !name.equals(that.name) : that.name != null)
      return false;
    if (password != null ? !password.equals(that.password) : that.password != null)
      return false;
    if (role != null ? !role.equals(that.role) : that.role != null)
      return false;
    if (state != null ? !state.equals(that.state) : that.state != null)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    Long result = id != null ? id.hashCode() : 0L;
    result = 31 * result + (mail != null ? mail.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    result = 31 * result + (state != null ? state.hashCode() : 0);
    result = 31 * result + (role != null ? role.hashCode() : 0);
    return result.intValue();
  }

  @Basic
  @Column(name = "user_cellphone")
  public String getUserCellphone() {
    return userCellphone;
  }

  public void setUserCellphone(String userCellphone) {
    this.userCellphone = userCellphone;
  }
}
