package com.flab.item.domain.dto.request;

import lombok.Getter;

@Getter
public class ItemRequest {

    private String name;

    private Integer price;

    private String description;

    private Long userId;

    private Integer stack;

    private Long storeId;
}
