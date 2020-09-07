package com.ecommerce.shop.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecommerce.shop.dal.StoreRepository;
import com.ecommerce.shop.model.Store;
import com.ecommerce.shop.service.StoreService;
import com.ecommerce.shop.service.StoreServiceImpl;

//https://www.baeldung.com/spring-boot-testing
@RunWith(SpringRunner.class)
public class StoreServiceImplTest {

	@TestConfiguration
    static class StoreServiceImplTestContextConfiguration {
 
        @Bean
        public StoreService storeService() {
            return new StoreServiceImpl();
        }
    }
 
    @Autowired
    private StoreService storeService;
 
    @MockBean
    private StoreRepository storeRepository;
    
    @Before
    public void setUp() {
        Store store = new Store();
        store.setName("Test Store");
        store.setStoreId("101");
        
        Optional<Store> opStore = Optional.of(store);
        Mockito.when(storeRepository.findById("101"))
          .thenReturn(opStore);
    }
    
    @Test
    public void whenValidId_thenStoreShouldBeFound() {
    	System.out.println("Running test : whenValidId_thenStoreShouldBeFound");
        String id = "101";
        Store store = storeService.getStore(id);
        System.out.println("Store :" + store);
       assertEquals(id, store.getStoreId());
     }
}
