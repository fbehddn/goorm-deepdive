package com.delivery.api.account;

import com.delivery.api.account.model.AccountMeResponse;
import com.delivery.api.common.api.Api;
import com.delivery.api.common.error.UserErrorCode;
import com.delivery.db.account.AccountRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountApiController {
    private final AccountRepository accountRepository;

    // http://localhost:8080/api/account/me
    @GetMapping("/me")
    public Api<AccountMeResponse> me() {
        var response =  AccountMeResponse.builder()
                .name("홍길동")
                .email("hong@gmail.com")
                .registeredAt(LocalDateTime.now())
                .build();

        //강제 예외 발생
        var str = "안녕하세요";
        var age = Integer.parseInt(str);

        return Api.OK(response);
//        return Api.ERROR(UserErrorCode.USER_NOT_FOUND, "홍길동 이라는 사용자 없음");
    }
}
