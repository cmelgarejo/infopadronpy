package py.com.infopadron.domain;

public enum UserState {
  ACTIVE, INACTIVE, SUSPENDED_BY_ADMIN, WAITING_FOR_APPROVAL;

  public String toString() {
    return this.name();
  }
}
