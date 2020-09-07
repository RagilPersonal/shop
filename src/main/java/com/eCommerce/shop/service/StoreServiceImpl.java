package com.ecommerce.shop.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shop.context.LoginContext;
import com.ecommerce.shop.dal.StoreRepository;
import com.ecommerce.shop.model.Store;
import com.ecommerce.shop.user.Principal;


@Service
public class StoreServiceImpl implements StoreService {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Override
	public Store createStore(Store store) {
		Principal principal = LoginContext.getPrincipal();
		store.setCreatedBy(principal.getId());
		LOG.debug("Repository (Store) : " + storeRepository);
		return storeRepository.save(store);
	}

	@Override
	public Store getStore(String id) {
		// TODO Auto-generated method stub
		Optional<Store> store = storeRepository.findById(id);
		if(store.isPresent()) return store.get();
		return null;
	}
	
	@Override
	public List<Store> getMyStores() {
		
		Principal principal = LoginContext.getPrincipal();
		return this.storeRepository.findByCreatedBy(principal.getId());
	}

}
