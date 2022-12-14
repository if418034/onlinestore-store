package com.onlinestore.store.service;

import com.onlinestore.store.entity.Store;
import com.onlinestore.store.repo.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StoreService {
    private StoreRepo storeRepo;

    @Autowired
    public void setStoreRepo(StoreRepo storeRepo) {
        this.storeRepo = storeRepo;
    }

    public Map newStore(Store store) {
        Map<String, Object> response = new LinkedHashMap<>();
        Optional<Store> checkStoreId = storeRepo.findById(store.getStoreId());
        if(checkStoreId.isPresent()) {
            response.put("responseCode", "01");
            response.put("responseMessage", "Store ID already exists");
            return response;
        }
        response.put("responseCode", "00");
        response.put("responseMessage", "Success saving store with store name " + store.getStoreName());
        storeRepo.save(store);
        return response;
    }

    public List<Store> getAllStore() {
        return storeRepo.findAll();
    }
}
