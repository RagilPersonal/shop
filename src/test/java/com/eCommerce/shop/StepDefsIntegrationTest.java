package com.ecommerce.shop;

import static org.junit.Assert.assertEquals;

import com.ecommerce.shop.dto.StoreDto;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefsIntegrationTest extends SpringIntegrationTest {

	/* StoreDto storeDto;
	  
	 @When("^the client calls \"([^\"]*)\"$")
	    public void the_clinet_issue_get(String getUrl) throws Throwable {
		    System.out.println("Executing Cucumber test - the_clinet_issue_get");
		    storeDto = (StoreDto)getRestObject(getUrl, StoreDto.class);
		   // assertEquals("Store Id is incorrect ", storeDto.getStoreId(), "104");
	       
	    }
	 
	 @Then("^the client receives store with Id \"([^\"]*)\" and name \"([^\"]*)\"$")
	    public void clinet_get_store(String id, String name) throws Throwable {
		 System.out.println("Executing Cucumber test - clinet_get_store");
		    //StoreDto storeDto = (StoreDto)getRestObject("/store/100", StoreDto.class);
		    assertEquals("Store Id is incorrect ", storeDto.getStoreId(), id);
		    assertEquals("Store Id is incorrect ", storeDto.getName(), name);
	       
	    }
	 
	 @And("^the client receives proper response code$")
	    public void clinet_get_valid_code() throws Throwable {
		    System.out.println("Executing Cucumber test - clinet_get_valid_code");
		    //StoreDto storeDto = (StoreDto)getRestObject("/store/100", StoreDto.class);
		    assertEquals("Store Id is incorrect ", storeDto.getStoreId(), "104");
	       
	    }*/
}
