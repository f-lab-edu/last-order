package com.flab.favorite.controller;

import com.flab.favorite.domain.Favorite;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {

    @GetMapping("/search")
    public ResponseEntity<List<Favorite>> searchFavorite() {
        List<Favorite> favorites = new ArrayList<>();
        return new ResponseEntity<>(favorites, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addFavorite(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteFavorite(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
