package com.flab.item.domain.dto.request;

import com.flab.item.domain.enums.ItemStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemRequest {

    @NotBlank(message = "{NotBlank.itemRequest.name}")
    private String name;

    @Min(value = 100, message = "{Min.itemRequest.price}")
    @NotNull(message = "{NotNull.itemRequest.price}")
    private Integer price;

    @NotBlank(message = "{NotBlank.itemRequest.description}")
    private String description;

    private Long userId;

    @Min(value = 1, message = "{Min.itemRequest.stack}")
    @NotNull(message = "{NotNull.itemRequest.stack}")
    private Integer stack;

    private Long storeId;

    private ItemStatus itemStatus;
}
