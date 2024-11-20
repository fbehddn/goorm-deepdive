package com.example.jwtex;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Jwts.SIG;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import javax.crypto.SecretKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JwtService {
    private static final String secretKey = "SpringSecurityKey_P@ssword_https://Spring.io";

    //토큰 생성
    public String createToken(Map<String, Object> claims, LocalDateTime expiresAt) {
        byte[] secretKeyBytes = Base64.getEncoder().encode(secretKey.getBytes());
        //임의로 만든 암호키로 key를 설정
        SecretKey key = Keys.hmacShaKeyFor(secretKeyBytes);

        //token 의 expire 시간을 변환
        Date _expireAt = Date.from(expiresAt.atZone(ZoneId.systemDefault()).toInstant());

        return Jwts.builder()
                .signWith(key, SIG.HS256)
                .claims(claims)
                .expiration(_expireAt)
                .compact();
    }

    //토큰 검증
    public void validationToken(String token) {
        byte[] secretKeyBytes = Base64.getEncoder().encode(secretKey.getBytes());
        SecretKey key = Keys.hmacShaKeyFor(secretKeyBytes);

        JwtParser parser = Jwts.parser()
                .verifyWith(key)
                .build();

        try {
            var result = parser.parseClaimsJws(token);
            result.getPayload().forEach((key1, value1) -> log.info("key: {}, value: {}", key1, value1));
        } catch (Exception e) {
            if (e instanceof SignatureException) {
                throw new RuntimeException("Invalid JWT token");
            } else if (e instanceof ExpiredJwtException) {
                throw new RuntimeException("Expired JWT token");
            } else {
                throw new JwtException("Invalid JWT token");
            }
        }
    }
}
