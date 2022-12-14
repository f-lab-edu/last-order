package com.flab.store.controller;

import com.flab.store.dto.request.AddStoreRequest;
import com.flab.store.dto.request.UpdateStoreRequest;
import com.flab.store.dto.response.StoreResponse;
import com.flab.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/searchStoreInfo/{storeId}")
    public StoreResponse searchStoreInfo(@PathVariable Long storeId) {
        return storeService.searchStoreInfo(storeId);
    }

    @GetMapping("/searchAllMyStore/{ownerId}")
    public List<StoreResponse> searchAllMyStore(@PathVariable Long ownerId) {
        return storeService.searchAllMyStore(ownerId);
    }

    @PostMapping("/add")
    public Long addStore(@Valid @RequestBody AddStoreRequest request) {
        return storeService.addStore(request);
    }

    @PatchMapping("/update")
    public Long updateStore(@Valid @RequestBody UpdateStoreRequest request) {
        return storeService.updateStore(request);
    }

    @DeleteMapping("/{storeId}")
    public void deleteStore(@PathVariable Long storeId) {
        storeService.deleteStore(storeId);
    }

    @PostMapping("/open")
    public void openStore(@PathVariable Long storeId) {
        storeService.openStore(storeId);
    }

    @PostMapping("/close")
    public void closeStore(@PathVariable Long storeId) {
        storeService.closeStore(storeId);
    }
}
