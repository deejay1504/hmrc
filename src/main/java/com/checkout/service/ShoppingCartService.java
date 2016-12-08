package com.checkout.service;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.checkout.util.Constants;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ShoppingCartService {
	
	private HashMap<String, Double> itemMap;
	
	public ShoppingCartService() throws JsonParseException, JsonMappingException, IOException {
		itemMap = new ObjectMapper().readValue(Constants.getItemJson(), new TypeReference<Map<String, Double>>(){});
	}
	
	public String checkout(List<String> items) {
		List<String> invalidItems = checkValidItems(items);
		if (invalidItems.size() > 0) {
			return MessageFormat.format(Constants.INVALID_CHECKOUT_ITEM, invalidItems.toString());
		}
		
		long orangesCount = items.stream().filter(i -> i.equalsIgnoreCase(Constants.ORANGE)).count();
		long applesCount = items.stream().filter(i -> i.equalsIgnoreCase(Constants.APPLE)).count();
		
		Double total = new Double(0);
		total = total + (orangesCount * itemMap.get(Constants.ORANGE));
		total = total + (applesCount * itemMap.get(Constants.APPLE));
		return MessageFormat.format(Constants.CHECKOUT_TOTAL, items.toString(), Constants.DF.format(total));
	}
	
	private List<String> checkValidItems(List<String> items) {
		return items.stream().filter(i -> (!i.equalsIgnoreCase(Constants.ORANGE) && !i.equalsIgnoreCase(Constants.APPLE))).collect(Collectors.toList());
	}
	
}