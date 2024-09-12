package practice.restapi_ex.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import practice.restapi_ex.dto.UserDto;
import practice.restapi_ex.entity.User;
import practice.restapi_ex.repository.UserRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks //유저서비스를 테스트하고 있다고 명시, userService 구현체는 생성이 되고, @Mock 의 필드는 실제 구현체가 아닌, 테스트용 값을 선언
    private UserService userService;

    @Mock //가상의 객체를 사용하여 실제 구현체와 상호작용을 시뮬레이션.
    private UserRepository userRepository;

    //사용자 생성: 사용자 등록
    @Test
    void testCreateUser() {
        // 1. 테스트용 UserDto 준비
        UserDto userDto = new UserDto();
        userDto.setName("Tom");
        userDto.setEmail("tom@gmail.com");

        // 2. Mockito를 사용. 리포지토리의 save 메서드를 mocking (흉내내겠다)
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        when(userRepository.save(any(User.class))).thenReturn(user);

        // 3. 서비스 메서드 호출 및 결과 검증
        User createdUser = userService.createUser(userDto);
        assertEquals(userDto.getName(), createdUser.getName());

        // 4. 리포지토리의 save 메서드가 호출되었는지 확인
        verify(userRepository, times(1)).save(any(User.class));

    }
}
