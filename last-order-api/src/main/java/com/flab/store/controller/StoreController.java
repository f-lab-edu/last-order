package com.flab.store.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
public class StoreController {

    @GetMapping("/search")
    public ResponseEntity<Void> searchStore() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search-favorite")
    public ResponseEntity<Void> searchStoreFavorite() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addStore(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("update")
    public ResponseEntity<Void> updateStore(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteStore(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
