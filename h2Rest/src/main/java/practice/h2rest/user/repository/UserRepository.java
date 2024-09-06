package practice.h2rest.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.h2rest.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
