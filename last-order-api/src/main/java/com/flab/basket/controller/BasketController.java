package com.flab.basket.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basket")
public class BasketController {

    @GetMapping("/search")
    public ResponseEntity<Void> searchBasket() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addBasket(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("update")
    public ResponseEntity<Void> updateBasket(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteBasket(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
