package com.flab.review.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @GetMapping("/my-review")
    public ResponseEntity<Void> myReview() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addReview(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("update")
    public ResponseEntity<Void> updateReview(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteReview(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
