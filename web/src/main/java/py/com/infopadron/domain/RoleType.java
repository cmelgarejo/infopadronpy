package py.com.infopadron.domain;

/**
 * Enumarated type to manage the types of roles.
 * 
 * 
 * @author rodrigo
 *
 */
public enum RoleType {

  ROOT, // Can do administration stuff on the overall system.
  ADMIN, // Can admin only client's accounts.
  USER; // Just a regular user.

  public String toString() {
    return this.name();
  }

  public Boolean isAdmin() {
    switch (this) {
    case ADMIN:
      return true;
    }
    return false;
  }

  public Boolean isUser() {
    if (this == USER)
      return true;
    return false;
  }

  public Boolean isRoot() {
    switch (this) {
    case ROOT:
      return true;
    }
    return false;
  }

}
