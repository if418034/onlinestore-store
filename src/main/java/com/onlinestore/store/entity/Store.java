package com.onlinestore.store.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Document(collection = "stores")
public class Store {
    @NotNull @Id
    private String storeId;
    @NotNull
    private String storeName;
    @DBRef
    private List<Item> items;
}
