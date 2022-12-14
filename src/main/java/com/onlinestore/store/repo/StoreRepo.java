package com.onlinestore.store.repo;

import com.onlinestore.store.entity.Store;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepo extends MongoRepository<Store, String> {
}
