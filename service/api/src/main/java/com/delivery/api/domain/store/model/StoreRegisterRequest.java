package com.delivery.api.domain.store.model;

import com.delivery.db.store.enums.StoreCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreRegisterRequest {
    private String name;
    private String address;
    private StoreCategory storeCategory;
    private String thumbnailUrl;
    private BigDecimal minimumAmount;
    private BigDecimal minimumDeliveryAmount;
    private String phoneNumber;
}