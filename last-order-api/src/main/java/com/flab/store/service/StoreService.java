package com.flab.store.service;

import com.flab.store.domain.Store;

import java.util.List;

public interface StoreService {

    Store searchStoreInfo();

    List<Store> searchAllMyStore();

    List<Store> addStore();

    Store updateStore();

    Boolean deleteStore();

    String openStore();

    String closeStore();

}
