package com.checkout.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;

public class Constants {
	
	public static final String getItemJson() throws IOException {
		return new String(Files.readAllBytes(Paths.get("src/main/resources/itemsAndPrices.json")));
	}
	
	public static final String APPLE = "apple";
	
	public static final String ORANGE = "orange";
	
	public static final DecimalFormat DF = new DecimalFormat("0.00");
	
	public static final String CHECKOUT_TOTAL = "{0} => £{1}";
	
	public static final String INVALID_CHECKOUT_ITEM = "{0} is not a valid shopping cart item";

}
