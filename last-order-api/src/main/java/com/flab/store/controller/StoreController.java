package com.flab.store.controller;

import com.flab.store.domain.Store;
import com.flab.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
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
    public List<Store> addStore() {
        return storeService.addStore();
    }

    @PatchMapping("/update")
    public Store updateStore() {
        return storeService.updateStore();
    }

    @DeleteMapping
    public Boolean deleteStore() {
        return storeService.deleteStore();
    }

    @PostMapping("/open")
    public String openStore(){
        return storeService.openStore();
    }
    @PostMapping("/close")
    public String closeStore(){
        return storeService.closeStore();
    }
}
