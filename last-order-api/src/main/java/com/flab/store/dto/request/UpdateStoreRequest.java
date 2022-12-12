package com.flab.store.dto.request;

import lombok.Getter;

@Getter
public class UpdateStoreRequest {
    private Long id;

    private String storeName;

    private String address;

    private String description;

    private Integer minimumOrderAmount;

    private Long ownerId;
}
