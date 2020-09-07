package com.ecommerce.shop.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.ecommerce.shop.model.Store;

public interface StoreService {

	public Store createStore(@RequestBody Store store);
	public Store getStore(String id);
	public List<Store> getMyStores();
}
