package practice.restapi_ex.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import practice.restapi_ex.entity.User;

import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {
    private static final Logger logger = Logger.getLogger(UserRepositoryTest.class.getName());

    @Autowired
    private UserRepository userRepository;

    //사용자 저장 및 조회 테스트
    @Test
    void testSaveAndFindById() {
        System.out.println("테스트 시작: User 저장 후 조회 테스트");
        // 1. 새로운 사용자 엔티티 생성
        User user = new User();
        user.setName("Tom");
        user.setEmail("tom@gmail.com");

        // 2. 레포지토리를 통해 사용자 저장
        User savedUser = userRepository.save(user);
        System.out.println("데이터 저장 완료: " + user.getName() + "(이메일: " + user.getEmail() + ")");

        // 3. 저장된 사용자가 잘 조회되는지 검증
        User foundUser = userRepository.findById(savedUser.getId()).orElse(null);

        // 로그 출력: 데이터 조회 결과
        if (foundUser != null) {
            logger.info(String.format("데이터 조회 성공: %s (이메일: %s)", foundUser.getName(), foundUser.getEmail()));
        } else {
            logger.info(String.format("데이터 조회 실패: ID %d", user.getId()));
        }

        assertThat(foundUser.getName()).isEqualTo(savedUser.getName());
        assertThat(foundUser.getEmail()).isEqualTo(savedUser.getEmail());

        logger.info("테스트 종료: User 저장 후 테스트 종료");
    }
}
