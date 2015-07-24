package py.com.infopadron.service;

import py.com.infopadron.domain.UserEntity;
import py.com.infopadron.domain.UserState;
import py.com.infopadron.dto.UserDTO;
import py.com.infopadron.dto.UserProfileDTO;

import java.util.List;


public interface UserService {

  UserEntity findById(Long id);

  UserEntity findByMail(String email);

  List<UserEntity> findAll();

  UserEntity saveUser(UserEntity user);

  void deleteById(Long id);



  void disableUser(Long adminUserId, Long userIdToDisable, UserState state);



  List<UserDTO> findUsersByTrader(Long userId);

  public void changeTraderState(Long userId, Long traderIdTodisable, UserState suspendedByAdmin);

  public void updateUser(Long userId, UserDTO userDTO);

  /**
   * Creates a new user entity having an instance of {@link UserDTO}.
   * 
   * @param currentUserId
   * 
   * @param userDTO
   * @return
   */
  public UserEntity saveUser(Long currentUserId, UserDTO userDTO);

  /**
   * Deletes ther user <code>userToDelte</code>
   * 
   * @param userId
   * @param userToDelete
   */
  public void deleteUser(Long userId, Long userToDelete);

  /**
   * Saves a new profiles wich contains trader's info and also an designed
   * responsible user.
   * 
   * @param userProfileDto
   * @param siloDto
   * @return
   */
  public UserEntity saveUserProfile(UserProfileDTO userProfileDto);
  public UserEntity saveUserProfileUpdate(UserProfileDTO userProfileDto);

  /**
   * Validates if <code>mail</code> already belongs to another user.
   * 
   * @param email
   * @return
   */
  public Boolean validateUniqueEmail(String email);

  public void updateUserTrader(Long userId, UserProfileDTO userProfileDTO);

  public boolean isUserActive(Long userId);

  boolean isUserSuspended(Long userId);

  String resetPassword(String email);
}
