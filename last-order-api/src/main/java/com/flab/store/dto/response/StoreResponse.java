package com.flab.store.dto.response;

import com.flab.store.domain.Store;
import com.flab.store.domain.enums.StoreStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StoreResponse {
    private Long id;

    private String storeName;

    private String address;

    private String description;

    private Integer minimumOrderAmount;

    private Integer reviewCount;

    private Integer reviewScore;

    private StoreStatus storeStatus;

    private Long ownerId;

    public static StoreResponse from(Store store){
        return new StoreResponse(
                store.getId(),
                store.getStoreName(),
                store.getAddress(),
                store.getDescription(),
                store.getMinimumOrderAmount(),
                store.getReviewCount(),
                store.getReviewScore(),
                store.getStoreStatus(),
                store.getOwnerId()
        );
    }
}
