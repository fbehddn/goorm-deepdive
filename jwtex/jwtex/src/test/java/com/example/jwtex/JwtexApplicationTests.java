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
        LocalDateTime expireAt = LocalDateTime.now().plusSeconds(30);

        var jwtToken = jwtService.createToken(claims, expireAt);
        System.out.println(jwtToken);
    }

    @Test
    void tokenValidation() {
        var token = "ey1hbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo3Nzc3LCJleHAiOjE3MzIwNjIzNjN9.01t_1D8FOsuwFe2rnAfSgLwtim15qCJXNoVV4CfIPkc";
        jwtService.validationToken(token);
    }
}
