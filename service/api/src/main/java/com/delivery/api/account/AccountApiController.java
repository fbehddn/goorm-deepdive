package com.delivery.api.account;

import com.delivery.api.account.model.AccountMeResponse;
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
    public AccountMeResponse me() {
        return AccountMeResponse.builder()
                .name("홍길동")
                .email("hong@gmail.com")
                .registeredAt(LocalDateTime.now())
                .build();
    }
}
