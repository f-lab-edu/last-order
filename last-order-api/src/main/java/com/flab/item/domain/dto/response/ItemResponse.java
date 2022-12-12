package com.flab.item.domain.dto.response;

import com.flab.item.domain.Item;
import lombok.Getter;

@Getter
public class ItemResponse {

    private String name;

    private Integer price;

    private String description;

    private Integer stack;

    private String storeName;

    public ItemResponse(Item item) {
        this.name = item.getName();
        this.description = item.getDescription();
        this.price = item.getPrice();
        this.stack = item.getStack();
    }
}
