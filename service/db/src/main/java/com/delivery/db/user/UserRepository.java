package com.delivery.db.user;

import com.delivery.db.user.enums.UserStatus;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // select * from user where id = ? and status = ? order by id desc limit 1
    Optional<UserEntity> findFirstByIdAndStatusOrderByIdDesc(Long id, UserStatus status);

    // select * from user where email = ? and password = ? and status order by id desc limit 1
    Optional<UserEntity> findFirstByEmailAndPasswordAndStatusOrderByIdDesc(String email, String password,
                                                                           UserStatus status);
}
