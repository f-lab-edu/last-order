package com.flab.favorite.dto;

import com.flab.favorite.domain.Favorite;
import com.flab.store.domain.Store;
import lombok.Getter;

@Getter
public class SearchFavoriteResponse {

    private final Long storeId;

    private final String storeName;

    private final double reviewScore;

    private final String description;

    public SearchFavoriteResponse(Favorite favorite, Store store) {
        this.storeId = favorite.getStoreId();
        this.storeName = store.getStoreName();
        this.reviewScore = store.getReviewScore();
        this.description = store.getDescription();
    }

}
