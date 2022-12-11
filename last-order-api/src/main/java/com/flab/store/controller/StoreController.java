package com.flab.store.controller;

import com.flab.store.domain.Store;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {


    @GetMapping("/searchStoreInfo")
    public Store searchStoreInfo() {
        HashMap<Long, Store> storeMap = new HashMap<>();

        return Store.builder()
                .id(1L)
                .storeName("BBQ")
                .minimumOrderAmount(15000)
                .address("서울시 강남구 역삼동")
                .description("치킨")
                .ownerId(1L)
                .build();
    }

    @GetMapping("/searchAllMyStore")
    public List<Store> searchAllMyStore() {
        List<Store> storeList = new ArrayList<>();
        Store store = Store.builder()
                .id(1L)
                .storeName("BBQ")
                .minimumOrderAmount(15000)
                .address("서울시 강남구 역삼동")
                .description("치킨")
                .ownerId(1L)
                .build();

        Store store2 = Store.builder()
                .id(2L)
                .storeName("Mcdonald")
                .minimumOrderAmount(15000)
                .address("서울시 강남구 역삼동")
                .description("Burger")
                .ownerId(1L)
                .build();
        storeList.add(store);
        storeList.add(store2);
        return storeList;
    }

    @PostMapping("/add")
    public List<Store> addStore() {
        List<Store> storeList = new ArrayList<>();
        Store store = Store.builder()
                .id(1L)
                .storeName("BBQ")
                .minimumOrderAmount(15000)
                .address("서울시 강남구 역삼동")
                .description("치킨")
                .ownerId(1L)
                .build();
        storeList.add(store);

        return storeList;
    }

    @PatchMapping("/update")
    public Store updateStore() {
        HashMap<Long,Store> storeMap = new HashMap<>();
        Store store = Store.builder()
                .storeName("BBQ")
                .minimumOrderAmount(15000)
                .address("서울시 강남구 역삼동")
                .description("치킨")
                .build();
        storeMap.put(1L,store);

        storeMap.get(1L).setStoreName("Mcdonald");
        storeMap.get(1L).setDescription("Hamburger");
        return storeMap.get(1L);
    }

    @DeleteMapping
    public Boolean deleteStore() {
        HashMap<Long,Store> storeMap = new HashMap<>();
        Store store = Store.builder()
                .id(1L)
                .storeName("BBQ")
                .minimumOrderAmount(15000)
                .address("서울시 강남구 역삼동")
                .description("치킨")
                .ownerId(1L)
                .build();
        storeMap.put(1L,store);

        return storeMap.remove(1L) != null;
    }

    @PostMapping("/open")
    public String openStore(){
        HashMap<Long,Store> storeMap = new HashMap<>();
        Store store = Store.builder()
                .storeStatus(Store.StoreStatus.CLOSE)
                .build();
        storeMap.put(1L,store);
        storeMap.get(1L).setStoreStatus(Store.StoreStatus.OPEN);

        return storeMap.get(1L).getStoreStatus().name();
    }
    @PostMapping("/close")
    public String closeStore(){
        HashMap<Long,Store> storeMap = new HashMap<>();
        Store store = Store.builder()
                .storeStatus(Store.StoreStatus.OPEN)
                .build();
        storeMap.put(1L,store);
        storeMap.get(1L).setStoreStatus(Store.StoreStatus.CLOSE);

        return storeMap.get(1L).getStoreStatus().name();
    }
}
