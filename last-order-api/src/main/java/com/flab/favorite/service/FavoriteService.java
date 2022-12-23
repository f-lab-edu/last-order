package com.flab.favorite.service;

import com.flab.favorite.domain.Favorite;
import com.flab.favorite.dto.SearchFavoriteResponse;
import com.flab.favorite.exception.AlreadyFavoriteException;
import com.flab.favorite.exception.FavoriteNotExistException;
import com.flab.favorite.repository.FavoriteRepository;
import com.flab.store.StoreRepository;
import com.flab.store.domain.Store;
import com.flab.store.exception.StoreNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    private final StoreRepository storeRepository;

    public Long addFavorite(Long storeId) {
        checkStore(storeId);
        if(favoriteRepository.existsByUserIdAndStoreId(1L, storeId)){
            throw new AlreadyFavoriteException();
        }
        Favorite favorite = Favorite.builder()
                .userId(1L)
                .storeId(storeId)
                .build();

        return favoriteRepository.save(favorite).getId();
    }

    public void deleteFavorite(Long favoriteId) {
        Favorite favorite = favoriteRepository.findById(favoriteId).orElseThrow(() -> new FavoriteNotExistException());
        favoriteRepository.delete(favorite);
    }

    public List<SearchFavoriteResponse> searchAllMyFavorite(){
        List<SearchFavoriteResponse> favoriteResponseList = favoriteRepository.findAllByUserId(1L).stream().map(SearchFavoriteResponse::new).collect(Collectors.toList());
        for (SearchFavoriteResponse searchFavoriteResponse : favoriteResponseList) {
            searchFavoriteResponse.setFavoriteInfo(checkStore(searchFavoriteResponse.getStoreId()));
        }
        return favoriteResponseList;
    }

    private Store checkStore(Long storeId) {
        return storeRepository.findById(storeId).orElseThrow(() -> new StoreNotExistException());
    }

}
