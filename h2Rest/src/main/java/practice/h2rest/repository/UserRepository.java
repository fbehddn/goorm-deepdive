package practice.h2rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.h2rest.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
