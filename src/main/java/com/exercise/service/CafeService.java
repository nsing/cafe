package com.exercise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exercise.model.Product;
import com.exercise.dao.CafeDao;

/**
 * Cafe Service 
 */
@Component
public class CafeService {

	@Autowired
	private CafeDao cafeDao;
	
	public List<Product> getCafeProducts(String cafeName) {
		return cafeDao.getCafeProducts(cafeName);
	}
	
	public List<String> getCafes() {
		return cafeDao.getCafes();
	}

}
