package com.flab.store.controller;

import com.flab.store.domain.Store;
import com.flab.store.dto.request.AddStoreRequest;
import com.flab.store.dto.request.UpdateStoreRequest;
import com.flab.store.dto.response.StoreResponse;
import com.flab.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/searchStoreInfo")
    public Store searchStoreInfo() {
        return storeService.searchStoreInfo();
    }

    @GetMapping("/searchAllMyStore")
    public List<Store> searchAllMyStore() {
        return storeService.searchAllMyStore();
    }

    @PostMapping("/add")
    public ResponseEntity<StoreResponse> addStore(@Valid @RequestBody AddStoreRequest request) {
        return new ResponseEntity<>(storeService.addStore(request), HttpStatus.CREATED);
    }

    @PatchMapping("/update")
    public ResponseEntity<StoreResponse> updateStore(@Valid @RequestBody UpdateStoreRequest request) {
        return new ResponseEntity<>(storeService.updateStore(request), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteStore(@RequestParam Long storeId) {
        return new ResponseEntity<>(storeService.deleteStore(storeId),HttpStatus.OK);
    }

    @PostMapping("/open")
    public String openStore() {
        return storeService.openStore();
    }

    @PostMapping("/close")
    public String closeStore() {
        return storeService.closeStore();
    }
}
