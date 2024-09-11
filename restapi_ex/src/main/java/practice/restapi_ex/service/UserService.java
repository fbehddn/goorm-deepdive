package practice.restapi_ex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import practice.restapi_ex.dto.UserDto;
import practice.restapi_ex.entity.User;
import practice.restapi_ex.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //사용자 생성 : 사용자 등록 :
    @Transactional
    public User createUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());

        return userRepository.save(user);
    }

    //사용자 정보 조회
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    //사용자 정보 업데이트
    //트랜잭션 전파수준, 격리수준 설정
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ) //업데이트 할 때마다 새로운 트랜잭션 생성
    public User updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        return userRepository.save(user);
    }
}
