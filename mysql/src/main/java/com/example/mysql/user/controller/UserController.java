package com.example.mysql.user.controller;

import com.example.mysql.user.db.UserEntity;
import com.example.mysql.user.db.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserRepository userRepository;

    // http://localhost:8080/api/user/find-all
    @GetMapping("/find-all")
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    // http://localhost:8080/api/user/name?name=내이름
    @GetMapping("/name")
    public void autoSave(@RequestParam String name) {
        UserEntity user = UserEntity.builder()
                .name(name)
                .build();

        userRepository.save(user);
    }
}
