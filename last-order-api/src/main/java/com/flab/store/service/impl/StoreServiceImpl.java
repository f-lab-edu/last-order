package com.flab.store.service.impl;

import com.flab.store.domain.Store;
import com.flab.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{

    @Override
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

    @Override
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

    @Override
    public List<Store> addStore(){
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

    @Override
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

    @Override
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

    @Override
    public String openStore() {
        HashMap<Long,Store> storeMap = new HashMap<>();
        Store store = Store.builder()
                .storeStatus(Store.StoreStatus.CLOSE)
                .build();
        storeMap.put(1L,store);
        storeMap.get(1L).setStoreStatus(Store.StoreStatus.OPEN);

        return storeMap.get(1L).getStoreStatus().name();
    }

    @Override
    public String closeStore() {
        HashMap<Long,Store> storeMap = new HashMap<>();
        Store store = Store.builder()
                .storeStatus(Store.StoreStatus.OPEN)
                .build();
        storeMap.put(1L,store);
        storeMap.get(1L).setStoreStatus(Store.StoreStatus.CLOSE);

        return storeMap.get(1L).getStoreStatus().name();
    }
}
