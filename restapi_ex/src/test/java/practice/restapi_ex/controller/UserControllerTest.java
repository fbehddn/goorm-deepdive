package practice.restapi_ex.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import practice.restapi_ex.dto.UserDto;
import practice.restapi_ex.entity.User;
import practice.restapi_ex.repository.UserRepository;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    @Autowired
    private TestRestTemplate restTemplate; //REST 요청을 테스트하기위한 TestRestTemplate

    @Autowired
    private UserRepository userRepository; // 실제 DB와 상호작용하는 JPA 레포지토리

    @BeforeEach
    void setUp() {
        System.out.println("[테스트 준비] 데이터베이스의 모든 사용자 데이터 삭제");
        userRepository.deleteAll(); //테스트 전 데이터 초기화
    }

    //사용자 생성(등록) API 메서드
    @Test
    void testCreateUser() {
        // 1. 테스트할 사용자 DTO 생성
        System.out.println("[테스트] 새로운 사용자 Tom 을 생성 준비");
        UserDto userDto = new UserDto();
        userDto.setName("Tom");
        userDto.setEmail("tom@gmail.com");

        // 2. HTTP 요청을 위한 HttpEntity 생성
        System.out.println("[테스트] HttpEntity 생성하여 사용자 데이터 준비");
        HttpEntity<UserDto> request = new HttpEntity<>(userDto);

        // 3. Rest API 호출 - POST 요청
        System.out.println("[테스트] /user 경로로 POST 요청을 보내기");
        ResponseEntity<User> response = restTemplate.exchange("/user", HttpMethod.POST, request, User.class);

        // 4. 응답 상태 및 내용 검증
        System.out.println("[검증] 응답 상태 코드 : " + response.getStatusCode());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getName()).isEqualTo(userDto.getName());
        assertThat(response.getBody().getEmail()).isEqualTo(userDto.getEmail());

        System.out.println("[성공] 사용자 생성 테스트 성공");
    }
}