package com.flab.favorite.controller;

import com.flab.favorite.domain.Favorite;
import com.flab.favorite.dto.SearchFavoriteResponse;
import com.flab.favorite.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/favorite")
@RequiredArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;

    @GetMapping
    public List<SearchFavoriteResponse> searchAllMyFavorite() {
        return favoriteService.searchAllMyFavorite();
    }

    @PostMapping("/add/{storeId}")
    public void addFavorite(@PathVariable Long storeId){
        favoriteService.addFavorite(storeId);
    }

    @DeleteMapping("/delete/{favoriteId}")
    public void deleteFavorite(@PathVariable Long favoriteId){
        favoriteService.deleteFavorite(favoriteId);
    }
}
