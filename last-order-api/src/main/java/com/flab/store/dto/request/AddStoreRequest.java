package com.flab.store.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class AddStoreRequest {
    @NotBlank
    private String storeName;
    @NotBlank
    private String address;
    @NotBlank
    private String description;
    @NotBlank
    private Integer minimumOrderAmount;
    @NotNull
    private Long ownerId;
}
