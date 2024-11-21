package com.delivery.api.domain.token.service;

import com.delivery.api.common.error.ErrorCode;
import com.delivery.api.common.exception.ApiException;
import com.delivery.api.domain.token.Interface.TokenHelperInterface;
import com.delivery.api.domain.token.model.TokenDto;
import java.util.HashMap;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * tokenHelper 만을 참조하여 도메인 로직에만 기여
 * user 참조 X
 */
@Service
@RequiredArgsConstructor
public class TokenService {
    private final TokenHelperInterface tokenHelperInterface;

    // access token 발행
    public TokenDto issueAccessToken(Long userId) {
        var data = new HashMap<String, Object>();
        data.put("userId", userId);
        return tokenHelperInterface.issueAccessToken(data);
    }

    // refresh token 발행
    public TokenDto issueRefreshToken(Long userId) {
        var data = new HashMap<String, Object>();
        data.put("userId", userId);
        return tokenHelperInterface.issueRefreshToken(data);
    }

    // token validation
    public Long validationToken(String token) {
        var map = tokenHelperInterface.validationTokenWithThrow(token);

        var userId = map.get("userId");

        Objects.requireNonNull(userId, () -> {
            throw new ApiException(ErrorCode.NULL_POINT);
        }); // null 아니면 userId, null 예외 반환

        return Long.parseLong(userId.toString());
    }
}
