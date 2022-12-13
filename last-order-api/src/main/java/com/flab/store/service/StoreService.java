package com.flab.store.service;

import com.flab.store.StoreRepository;
import com.flab.store.domain.Store;
import com.flab.store.domain.enums.StoreStatus;
import com.flab.store.dto.request.AddStoreRequest;
import com.flab.store.dto.request.UpdateStoreRequest;
import com.flab.store.dto.response.StoreResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreResponse searchStoreInfo(Long storeId) {
        HashMap<Long, Store> storeMap = new HashMap<>();

        Store store = Store.builder()
                .id(1L)
                .storeName("BBQ")
                .minimumOrderAmount(15000)
                .address("서울시 강남구 역삼동")
                .description("치킨")
                .ownerId(1L)
                .build();
        return StoreResponse.from(store);
    }

    public List<StoreResponse> searchAllMyStore(Long ownerId) {
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

        List<StoreResponse> responses = new ArrayList<>();
        for (Store store1 : storeList) {
            responses.add(StoreResponse.from(store1));
        }
        return responses;
    }

    public Long addStore(AddStoreRequest request) {
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

        return storeRepository.save(store).getId();
    }

    public Long updateStore(UpdateStoreRequest request) {
        var store = storeRepository.findById(request.getId()).orElseThrow(() -> {
            throw new RuntimeException();
        });
        store.updateStore(request);
        return storeRepository.save(store).getId();
    }

    public void deleteStore(Long storeId) {
        storeRepository.deleteById(storeId);
    }

    public void openStore(Long ownerId) {
        HashMap<Long, Store> storeMap = new HashMap<>();
        Store store = Store.builder()
                .storeStatus(StoreStatus.CLOSE)
                .build();
        storeMap.put(1L, store);

    }

    public void closeStore(Long storeId) {
        HashMap<Long, Store> storeMap = new HashMap<>();
        Store store = Store.builder()
                .storeStatus(StoreStatus.OPEN)
                .build();
        storeMap.put(1L, store);
        storeMap.get(1L).setStoreStatus(StoreStatus.CLOSE);

    }
}
