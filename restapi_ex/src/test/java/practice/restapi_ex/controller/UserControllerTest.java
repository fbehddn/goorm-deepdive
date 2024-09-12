package practice.restapi_ex.controller;

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

    // exp 미션
    // 사용자 조회 API 테스트
    // : 데이터베이스에 미리 저장한 사용자를 조회하는 API 를 호출
    //  올바르게 조회되었는지 검증

    @Test
    void testGetUserById() {
        // 1. 테스트할 사용자 DTO 생성
        System.out.println("[테스트 준비] 데이터베이스에 초기 데이터 세팅하기");
        UserDto userDto = new UserDto();
        userDto.setName("Tom");
        userDto.setEmail("tom@gmail.com");

        // 2. User 객체로 변환하여 DB에 저장
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        userRepository.save(user);

        // 3. 사용자 조회 API 호출
        ResponseEntity<User> response = restTemplate.getForEntity(
                "/user/" + user.getId(),
                User.class);

        // 4. 응답상태 및 내용검증
        System.out.println("[검증] 응답 상태 코드 : " + response.getStatusCode());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getName()).isEqualTo(userDto.getName());
        assertThat(response.getBody().getEmail()).isEqualTo(userDto.getEmail());

        System.out.println("[성공] 사용자 조회 테스트 성공");
    }
}