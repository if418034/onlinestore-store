package com.onlinestore.store.controller;

import com.onlinestore.store.entity.Store;
import com.onlinestore.store.service.StoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class StoreController {
    private StoreService storeService;

    public void setStoreService(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/store")
    public Map saveNewStore(Store store) {
        return storeService.newStore(store);
    }

    @GetMapping("/stores")
    public List<Store> getAllStore() {
        return storeService.getAllStore();
    }
}
