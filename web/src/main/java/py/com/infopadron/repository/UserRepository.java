package py.com.infopadron.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import py.com.infopadron.domain.UserEntity;

import java.util.List;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
  UserEntity findOneByMail(String email);

  UserEntity findOneByMailAndPassword(String email, String Password);

  List<UserEntity> findAllByMail(String email);

}
