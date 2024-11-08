package com.delivery.api.account.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
//@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class) // registeredAt -> registered_at , config 에서 전역으로 설정
public class AccountMeResponse {
    private String email;
    private String name;
    private LocalDateTime registeredAt;
}
