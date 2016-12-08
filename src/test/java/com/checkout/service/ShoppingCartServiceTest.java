package com.checkout.service;


import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author deejay
 *
 */
public class ShoppingCartServiceTest {

	private ShoppingCartService shoppingCartService;
	
	@Before
	public void setUp() throws Exception {
		shoppingCartService = new ShoppingCartService();
	}
	
    @Test
    public void shouldReturn205ForShopping() throws IOException, ParseException {
    	// Given
    	List<String> items = Arrays.asList("Apple", "Apple", "Orange", "Apple");
        
        // When we call the service to total the items
    	String checkout = shoppingCartService.checkout(items);
    	
    	// Then
    	assertEquals("Invalid shopping cart", "[Apple, Apple, Orange, Apple] => £2.05", checkout);
    }
    
    @Test
    public void shouldReturn085ForShopping() throws IOException, ParseException {
    	// Given
    	List<String> items = Arrays.asList("Orange", "Apple");
        
        // When we call the service to total the items
    	String checkout = shoppingCartService.checkout(items);
    	
    	// Then
    	assertEquals("Invalid shopping cart", "[Orange, Apple] => £0.85", checkout);
    }
    
    @Test
    public void shouldReturn110ForShopping() throws IOException, ParseException {
    	// Given
    	List<String> items = Arrays.asList("Orange", "Apple", "Orange");
        
        // When we call the service to total the items
    	String checkout = shoppingCartService.checkout(items);
    	
    	// Then
    	assertEquals("Invalid shopping cart", "[Orange, Apple, Orange] => £1.10", checkout);
    }
    
    @Test
    public void shouldReturnInvalidItem() throws IOException, ParseException {
    	// Given
    	List<String> items = Arrays.asList("Apple", "Pear", "Orange");
        
        // When we call the service to total the items
    	String checkout = shoppingCartService.checkout(items);
    	
    	// Then
    	assertEquals("Invalid shopping cart", "[Pear] is not a valid shopping cart item", checkout);
    }
    
}