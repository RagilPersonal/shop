package com.ecommerce.shop.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ecommerce.shop.ShopApplication;
import com.ecommerce.shop.model.Store;
import com.ecommerce.shop.service.StoreService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = ShopApplication.class)
@AutoConfigureMockMvc 
@EnableAutoConfiguration(exclude=SecurityAutoConfiguration.class)
//@WebMvcTest(StoreController.class)
public class StoreControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private StoreService storeService;
	
	@Before
    public void setUp() {
        Store store = new Store();
        store.setName("Test Store");
        store.setStoreId("101");
               
        Mockito.when(storeService.getStore("101"))
          .thenReturn(store);
    }
    
    @Test
    public void whenValidId_thenReturnStore() throws Exception {
    	System.out.println("Running test : whenValidId_thenReturnStore");
        String id = "101";
               
       mvc.perform(get("/store/"+id)
    		      .contentType(MediaType.APPLICATION_JSON))
    		      .andExpect(status().isOk())
    		     // .andExpect(jsonPath("$", hasSize(1)))
    		      .andExpect(jsonPath("storeId", is(id)));
     }
	
}
