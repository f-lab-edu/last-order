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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    private final StoreRepository storeRepository;

    public Favorite addFavorite(Long storeId) {
        getStore(storeId).orElseThrow(() -> new StoreNotExistException());
        if(favoriteRepository.existsByUserIdAndStoreId(1L, storeId)){
            throw new AlreadyFavoriteException();
        }
        Favorite favorite = Favorite.builder()
                .userId(1L)
                .storeId(storeId)
                .build();

        return favoriteRepository.save(favorite);
    }

    public void deleteFavorite(Long favoriteId) {
        favoriteRepository.delete(favoriteRepository.findById(favoriteId).orElseThrow(() -> new FavoriteNotExistException()));
    }

    public List<SearchFavoriteResponse> searchAllMyFavorite(){
        return favoriteRepository.findAllByUserId(1L).stream().map(favorite -> {
            Store store = getStore(favorite.getStoreId()).orElseThrow(() -> new StoreNotExistException());
            return new SearchFavoriteResponse(favorite, store);}).collect(Collectors.toList());

    }

    private Optional<Store> getStore(Long storeId) {
        return storeRepository.findById(storeId);
    }
}
