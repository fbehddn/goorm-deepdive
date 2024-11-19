package com.example.jwtex;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Objects;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JwtexApplicationTests {
    @Autowired
    private JwtService jwtService;

    @Test
    void contextLoads() {
    }

    @Test
    void tokenCreate() {
        var claims = new HashMap<String, Object>();
        claims.put("user_id", 7777);
        LocalDateTime expireAt = LocalDateTime.now().plusMinutes(10);

        var jwtToken = jwtService.createToken(claims, expireAt);
        System.out.println(jwtToken);
    }

    @Test
    void tokenValidation() {

    }

}
