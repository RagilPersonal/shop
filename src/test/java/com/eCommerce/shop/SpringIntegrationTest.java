package com.ecommerce.shop;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(classes = ShopApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class SpringIntegrationTest {
	
	static String BASE_URL = "http://localhost";
	
	@LocalServerPort
	private int port;
	
    @Autowired
    protected RestTemplate restTemplate;

    Object getRestObject(String url, Class cls) throws IOException {
    	
    	//port=8080;
    	url = BASE_URL+":"+port+url;
    	System.out.println("GET Request ->"+ url);
    	return restTemplate.getForObject(url , cls);
    }

    void executePost() throws IOException {
        
    }

   
}
