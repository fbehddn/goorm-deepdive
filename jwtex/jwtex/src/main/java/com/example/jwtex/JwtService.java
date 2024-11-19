package com.example.jwtex;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Jwts.SIG;
import io.jsonwebtoken.security.Keys;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    private static final String secretKey = "SpringSecurityKey_P@ssword_https://Spring.io";

    //토큰 생성
    public String createToken(Map<String, Object> claims, LocalDateTime expiresAt) {
        byte[] secretKeyBytes = Base64.getEncoder().encode(secretKey.getBytes());
        SecretKey key = Keys.hmacShaKeyFor(secretKeyBytes);
        Date _expireAt = Date.from(expiresAt.atZone(ZoneId.systemDefault()).toInstant());

        return Jwts.builder()
                .signWith(key, SIG.HS256)
                .claims(claims)
                .expiration(_expireAt)
                .compact();
    }
}
