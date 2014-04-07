package com.exercise.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 * Represents a cafe product/item/menu item
 */
public class Product {
	/*
	 * Name of the product
	 */
	private String name;
	
	/*
	 * Product is sized or not
	 */
	private boolean sized;
	
	/*
	 * Product sizes
	 */
	private List<String> sizes;
	
	/*
	 * Product prices
	 */
	private List<BigDecimal> prices; 

	/**
	 * Constructor 
	 * 
	 * @param name
	 * @param sizes
	 * @param prices
	 */
	public Product(String name, List<String> sizes,
			List<BigDecimal> prices) {
		this.name = name;
		this.prices = Collections.unmodifiableList(prices);
		this.sizes = Collections.unmodifiableList(sizes);
		if(sizes.size() == 0) {
			this.sized = false;
		}
		else {
			this.sized = true;
		}
	}
	
	//Getters:	
	public String getName() {
		return name;
	}

	public List<BigDecimal> getPrices() {
		return prices;
	}

	public List<String> getSizes() {
		return sizes;
	}

	public boolean isSized() {
		return sized;
	}

}
