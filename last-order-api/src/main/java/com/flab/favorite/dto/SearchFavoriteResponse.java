package com.flab.favorite.dto;

import com.flab.favorite.domain.Favorite;
import com.flab.store.domain.Store;
import lombok.Getter;

@Getter
public class SearchFavoriteResponse {

    private Long storeId;

    private String storeName;

    private double reviewScore;

    private String description;

    public SearchFavoriteResponse(Favorite favorite) {
        this.storeId = favorite.getStoreId();
    }

    public void setFavoriteInfo(Store store) {
        this.storeName = store.getStoreName();
        this.reviewScore = store.getReviewScore();
        this.description = store.getDescription();
    }

}
