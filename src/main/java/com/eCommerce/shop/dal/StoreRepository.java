package com.ecommerce.shop.dal;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.shop.model.Store;

@Repository
public interface StoreRepository extends MongoRepository<Store, String>{

	public List<Store> findByCreatedBy(String createdBy);
}
