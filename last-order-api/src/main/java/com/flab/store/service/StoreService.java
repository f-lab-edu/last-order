package com.flab.store.service;

import com.flab.store.StoreRepository;
import com.flab.store.domain.Store;
import com.flab.store.dto.request.AddStoreRequest;
import com.flab.store.dto.request.UpdateStoreRequest;
import com.flab.store.dto.response.StoreResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.flab.store.domain.enums.StoreStatus.*;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreResponse searchStoreInfo(Long storeId) {
        var store = storeRepository.findById(storeId).orElseThrow(() -> {
            throw new RuntimeException();
        });

        return StoreResponse.from(store);
    }

    public List<StoreResponse> searchAllMyStore(Long ownerId) {
        List<Store> storeList = storeRepository.findAllByOwnerId(ownerId);
        List<StoreResponse> response = new ArrayList<>();
        for (Store store : storeList) {
            response.add(StoreResponse.from(store));
        }
        return response;
    }

    public Long addStore(AddStoreRequest request) {
        Store store = Store.builder()
                .storeName(request.getStoreName())
                .minimumOrderAmount(request.getMinimumOrderAmount())
                .address(request.getAddress())
                .description(request.getDescription())
                .ownerId(request.getOwnerId())
                .storeStatus(CLOSE)
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

    public void openStore(Long storeId) {
        var store = storeRepository.findById(storeId).orElseThrow(()->{
            throw new RuntimeException();
        });
        store.setStoreStatus(OPEN);
        storeRepository.save(store);
    }

    public void closeStore(Long storeId) {
        var store = storeRepository.findById(storeId).orElseThrow(()->{
            throw new RuntimeException();
        });
        store.setStoreStatus(CLOSE);
        storeRepository.save(store);
    }
}
