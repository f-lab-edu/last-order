package com.flab.store.service;

import com.flab.store.domain.Store;
import com.flab.store.dto.request.AddStoreRequest;
import com.flab.store.dto.request.UpdateStoreRequest;
import com.flab.store.dto.response.StoreResponse;

import java.util.List;

public interface StoreService {

    Store searchStoreInfo();

    List<Store> searchAllMyStore();

    StoreResponse addStore(AddStoreRequest request);

    StoreResponse updateStore(UpdateStoreRequest request);

    Void deleteStore(Long storeId);

    String openStore();

    String closeStore();

}
