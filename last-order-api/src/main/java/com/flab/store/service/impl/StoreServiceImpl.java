package com.flab.store.service.impl;

import com.flab.store.StoreRepository;
import com.flab.store.domain.Store;
import com.flab.store.domain.enums.StoreStatus;
import com.flab.store.dto.request.AddStoreRequest;
import com.flab.store.dto.request.UpdateStoreRequest;
import com.flab.store.dto.response.StoreResponse;
import com.flab.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

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
    public StoreResponse addStore(AddStoreRequest request) {
        Store store = Store.builder()
                .storeName(request.getStoreName())
                .minimumOrderAmount(request.getMinimumOrderAmount())
                .address(request.getAddress())
                .description(request.getDescription())
                .ownerId(request.getOwnerId())
                .storeStatus(StoreStatus.CLOSE)
                .reviewCount(0)
                .reviewScore(0)
                .build();

        storeRepository.save(store);

        return StoreResponse.from(store);
    }

    @Override
    public StoreResponse updateStore(UpdateStoreRequest request) {
        var store = storeRepository.findById(request.getId()).orElseThrow(() -> {
            throw new RuntimeException();
        });
        store.updateStore(request);
        storeRepository.save(store);

        return StoreResponse.from(store);
    }

    @Override
    public Boolean deleteStore() {
        HashMap<Long, Store> storeMap = new HashMap<>();
        Store store = Store.builder()
                .id(1L)
                .storeName("BBQ")
                .minimumOrderAmount(15000)
                .address("서울시 강남구 역삼동")
                .description("치킨")
                .ownerId(1L)
                .build();
        storeMap.put(1L, store);

        return storeMap.remove(1L) != null;
    }

    @Override
    public String openStore() {
        HashMap<Long, Store> storeMap = new HashMap<>();
        Store store = Store.builder()
                .storeStatus(StoreStatus.CLOSE)
                .build();
        storeMap.put(1L, store);
        storeMap.get(1L).setStoreStatus(StoreStatus.OPEN);

        return storeMap.get(1L).getStoreStatus().name();
    }

    @Override
    public String closeStore() {
        HashMap<Long, Store> storeMap = new HashMap<>();
        Store store = Store.builder()
                .storeStatus(StoreStatus.OPEN)
                .build();
        storeMap.put(1L, store);
        storeMap.get(1L).setStoreStatus(StoreStatus.CLOSE);

        return storeMap.get(1L).getStoreStatus().name();
    }
}
