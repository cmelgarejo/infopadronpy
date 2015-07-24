package py.com.infopadron.security;

import java.io.Serializable;

import py.com.infopadron.domain.UserEntity;



/**
 * A class that is used to store information about a logged user It leaves in a
 * session as an attribute
 */
public class UserCurrentInfo implements Serializable {

  private static final long serialVersionUID = -5900154335461105339L;

  private String email;
  private Long userId;
  private Long selectedSiloId;
  private String traderName;
  private Long traderId;
  private Boolean seller;
  private Boolean buyer;

  private Boolean root;

  private Boolean admin;
  private String session;

  public Boolean getSeller() {
    return seller;
  }

  public void setSeller(Boolean seller) {
    this.seller = seller;
  }

  public Boolean getBuyer() {
    return buyer;
  }

  public void setBuyer(Boolean buyer) {
    this.buyer = buyer;
  }

  public Long getTraderId() {
    return traderId;
  }

  public void setTraderId(Long traderId) {
    this.traderId = traderId;
  }

  public String getTraderName() {
    return traderName;
  }

  public void setTraderName(String traderName) {
    this.traderName = traderName;
  }

  private UserCurrentInfo() {

  }

  public static UserCurrentInfo fromUserEntity(UserEntity userEntity) {
    UserCurrentInfo userCurrentInfo = new UserCurrentInfo();
    userCurrentInfo.setEmail(userEntity.getMail());
    userCurrentInfo.setUserId(userEntity.getId());

    // The user role
    userCurrentInfo.setRoot(userEntity.getRole().isRoot());
    userCurrentInfo.setAdmin(userEntity.getRole().isAdmin());

    return userCurrentInfo;
  }

  public void setAdmin(Boolean admin) {
    this.admin = admin;
  }

  public Boolean getAdmin() {
    return this.admin;
  }

  public void setRoot(Boolean root) {
    this.root = root;
  }

  public Boolean getRoot() {
    return this.root;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getSelectedSiloId() {
    return selectedSiloId;
  }

  public void setSelectedSiloId(Long selectedSiloId) {
    this.selectedSiloId = selectedSiloId;
  }

public String getSession() {
	return session;
}

public void setSession(String session) {
	this.session = session;
}
  
  
  
  
}
