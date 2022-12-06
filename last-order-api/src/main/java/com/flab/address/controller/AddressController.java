package com.flab.address.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/address")
public class AddressController {

    @GetMapping("/search")
    public ResponseEntity<Void> searchAddress() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addAddress(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("update")
    public ResponseEntity<Void> updateAddress(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteAddress(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
