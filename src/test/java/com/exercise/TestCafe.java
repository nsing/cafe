package com.exercise;

import java.util.List;
import java.util.LinkedHashMap;
import org.springframework.web.client.RestTemplate;

/**
 * For testing the RESTful webservices  
 */
public class TestCafe {

	public static final String SERVER_URI = "http://localhost:8080/CafeSite-1.0";
	
	public static void main(String args[]){
		System.out.println("*****");
		testGetCafes();
		System.out.println("*****");
		testGetCafeProducts();
	}

	private static void testGetCafes() {
		RestTemplate restTemplate = new RestTemplate();
		List<String> cafes = restTemplate.getForObject(SERVER_URI+"/rest/cafes", List.class);
		System.out.println(cafes.size());
		for(String cafe: cafes){
			System.out.println("Cafe ="+cafe);
		}
	}

	private static void testGetCafeProducts() {
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap> products = restTemplate.getForObject(SERVER_URI+"/rest/cafe/Costa/products", List.class);
        for(LinkedHashMap product : products){
            System.out.println("Name="+product.get("name"));
        }
	}

}
