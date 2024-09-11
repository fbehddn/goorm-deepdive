package practice.restapi_ex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.restapi_ex.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
