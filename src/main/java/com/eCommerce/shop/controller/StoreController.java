package com.ecommerce.shop.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shop.dto.StoreDto;
import com.ecommerce.shop.model.Store;
import com.ecommerce.shop.service.StoreService;

@RestController
public class StoreController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/store")
	@ResponseStatus(HttpStatus.CREATED)
	public StoreDto create(@RequestBody StoreDto storeDto) {
		LOG.debug("Create Store");
		Store store = convertToEntity(storeDto);
		store = storeService.createStore(store);
		return convertToDto(store);
	}
	
	@GetMapping("/store/{id}")
	@ResponseStatus(HttpStatus.OK)
	public StoreDto get(@PathVariable("id") String id) {
		Store store = storeService.getStore(id);
		return convertToDto(store);
	}
	
	@GetMapping("/mystores")
	@ResponseStatus(HttpStatus.OK)
	public List<StoreDto> getMyStores() {
		List<Store> stores = storeService.getMyStores();
		return convertToDtos(stores);
		
	}
	
	private StoreDto convertToDto(Store store) {
		return modelMapper.map(store, StoreDto.class);
        
    }
	
	private List<StoreDto> convertToDtos(List<Store> stores) {
		return stores.stream().map(this::convertToDto).collect(Collectors.toList());
    }
	
	private Store convertToEntity(StoreDto storeDto) {
		return modelMapper.map(storeDto, Store.class);
        
    }
}
