package com.exercise.dao;

import java.math.BigDecimal;
import java.util.Arrays;

import com.exercise.model.Product;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

/**
 * Cafe Dao
 * 
 * Contains static data for the application
 */
@Component
public class CafeDao {
	private String[] drinkSizes = {"Small", "Medium", "Large"};
	private String[] drinkNoSizes = {};
	private BigDecimal[] neroCoffeePrices = {new BigDecimal("3.00"), new BigDecimal("2.75"), new BigDecimal("2.50")};
	private BigDecimal[] neroChocoloatePrices = {new BigDecimal("2.75"), new BigDecimal("2.50"), new BigDecimal("2.25")};
	private BigDecimal[] costaCoffeePrices = {new BigDecimal("2.50"), new BigDecimal("2.25"), new BigDecimal("2.00")};
	private BigDecimal[] costaCakePrices = {new BigDecimal("3.25"), new BigDecimal("3.00"), new BigDecimal("2.75")};
	private BigDecimal[] costaChocoCakeprices = {new BigDecimal("2.25")};
	private BigDecimal[] costaStrawBryCakeprices = {new BigDecimal("2.00")};
	private BigDecimal[] costaVanilaCakePrices = {new BigDecimal("1.75")};
	private List<Product> neroProducts = new ArrayList<Product>();
	private List<Product> costaProducts = new ArrayList<Product>();
	private List<String> cafes = new ArrayList<String>();
	
	public CafeDao() {
		cafes.add("Nero");
		cafes.add("Costa");
		neroProducts.add(new Product("Nero Coffee", Arrays.asList(drinkSizes), Arrays.asList(neroCoffeePrices)));
		neroProducts.add(new Product("Nero Hot Chocolate", Arrays.asList(drinkSizes), Arrays.asList(neroChocoloatePrices)));
		costaProducts.add(new Product("Costa Coffee", Arrays.asList(drinkSizes), Arrays.asList(costaCoffeePrices)));
		costaProducts.add(new Product("Costa Chocolate", Arrays.asList(drinkSizes), Arrays.asList(costaCakePrices)));
		costaProducts.add(new Product("Costa Chocolate Cake", Arrays.asList(drinkNoSizes), Arrays.asList(costaChocoCakeprices)));
		costaProducts.add(new Product("Costa Strawberry Cake", Arrays.asList(drinkNoSizes), Arrays.asList(costaStrawBryCakeprices)));
		costaProducts.add(new Product("Costa Vanila Cake", Arrays.asList(drinkNoSizes), Arrays.asList(costaVanilaCakePrices)));
	}
	
	public List<Product> getCafeProducts(String cafeName) {
		if(cafeName.equals("Nero")) {
			return neroProducts;
		}
		else if(cafeName.equals("Costa")) {
			return costaProducts;
		}
		else {
			return new ArrayList<Product>();
		}
	}
	
	public List<String> getCafes() {
		return cafes;
	}

}
