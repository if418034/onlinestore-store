package com.onlinestore.store.service;

import com.onlinestore.store.entity.Item;
import com.onlinestore.store.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ItemService {
    private ItemRepo itemRepo;

    @Autowired
    public void setItemRepo(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public Map saveNewItem(Item newItem) {
        Optional<Item> checkItemId = itemRepo.findById(newItem.getItemId());
        Map<String, Object> response = new LinkedHashMap<>();
        if(checkItemId.isPresent()) {
            response.put("responseCode", "01");
            response.put("responseMessage", "Item ID already exists");
            return response;
        }
        itemRepo.save(newItem);
        response.put("responseCode", "00");
        response.put("responseMessage", "Success saving item with ID" + newItem.getItemId());
        return response;
    }

    public List<Item> getAllItem() {
        return itemRepo.findAll();
    }
}
