package com.onlinestore.store.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Document(collection = "items")
public class Item {
    @NotNull @Id
    private String itemId;
    @NotNull
    private String itemName;
    @NotNull
    private int itemQty;

    public Item(String itemId, String itemName, int itemQty) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemQty = itemQty;
    }
}
