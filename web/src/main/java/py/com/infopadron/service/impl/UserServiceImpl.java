package py.com.infopadron.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.com.infopadron.domain.UserEntity;
import py.com.infopadron.domain.UserState;
import py.com.infopadron.dto.UserDTO;
import py.com.infopadron.dto.UserProfileDTO;
import py.com.infopadron.repository.UserRepository;
import py.com.infopadron.service.UserService;

import javax.annotation.Resource;
import javax.persistence.EntityExistsException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  private static final Logger logger = LoggerFactory.getLogger(UserService.class);
  private static final int PASSWORD_GEN_LENGTH = 10;

  @Resource
  private UserRepository userRepository;




  private boolean isUserInState(Long userId, UserState state) {
    UserEntity userEntity = userRepository.findOne(userId);
    String currentState = userEntity.getState();
    if (state.toString().equals(currentState)) {
      return true;
    } else {
      return false;
    }
  }




public UserEntity findById(Long id) {
	// TODO Auto-generated method stub
	return null;
}




public UserEntity findByMail(String email) {
	// TODO Auto-generated method stub
	return null;
}




public List<UserEntity> findAll() {
	// TODO Auto-generated method stub
	return null;
}




public UserEntity saveUser(UserEntity user) {
	// TODO Auto-generated method stub
	return null;
}




public void deleteById(Long id) {
	// TODO Auto-generated method stub
	
}




public void disableUser(Long adminUserId, Long userIdToDisable, UserState state) {
	// TODO Auto-generated method stub
	
}




public List<UserDTO> findUsersByTrader(Long userId) {
	// TODO Auto-generated method stub
	return null;
}




public void changeTraderState(Long userId, Long traderIdTodisable,
		UserState suspendedByAdmin) {
	// TODO Auto-generated method stub
	
}




public void updateUser(Long userId, UserDTO userDTO) {
	// TODO Auto-generated method stub
	
}




public UserEntity saveUser(Long currentUserId, UserDTO userDTO) {
	// TODO Auto-generated method stub
	return null;
}




public void deleteUser(Long userId, Long userToDelete) {
	// TODO Auto-generated method stub
	
}




public UserEntity saveUserProfile(UserProfileDTO userProfileDto) {
	// TODO Auto-generated method stub
	return null;
}




public UserEntity saveUserProfileUpdate(UserProfileDTO userProfileDto) {
	// TODO Auto-generated method stub
	return null;
}




public Boolean validateUniqueEmail(String email) {
	// TODO Auto-generated method stub
	return null;
}




public void updateUserTrader(Long userId, UserProfileDTO userProfileDTO) {
	// TODO Auto-generated method stub
	
}




public boolean isUserActive(Long userId) {
	// TODO Auto-generated method stub
	return false;
}




public boolean isUserSuspended(Long userId) {
	// TODO Auto-generated method stub
	return false;
}




public String resetPassword(String email) {
	// TODO Auto-generated method stub
	return null;
}

}
