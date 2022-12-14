package com.onlinestore.store.controller;

import com.onlinestore.store.entity.Item;
import com.onlinestore.store.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ItemController {
    private ItemService itemService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/item")
    public Map saveNewItem(@RequestBody Item item) {
        return  itemService.saveNewItem(item);
    }

    @GetMapping("/allItem")
    public List<Item> getAllItem() {
        return itemService.getAllItem();
    }
}
