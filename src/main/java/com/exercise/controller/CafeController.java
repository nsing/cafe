package com.exercise.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.exercise.service.CafeService;

import java.util.List;
import com.exercise.model.Product;

/**
 * Handles requests for Cafe service.
 */
@Controller
public class CafeController {
	
	@Autowired
	private CafeService cafeService;

	private static final Logger logger = LoggerFactory.getLogger(CafeController.class);
	
	@RequestMapping(value = CafeRestURIConstants.GET_CAFES, method = RequestMethod.GET)
	public @ResponseBody List<String> getAllCafes() {
		logger.info("Start getCafes.");
		return cafeService.getCafes();
	}
	
	@RequestMapping(value = CafeRestURIConstants.GET_CAFE_PRODUCTS, method = RequestMethod.GET)
	public @ResponseBody List<Product> getCafeProducts(@PathVariable("id") String cafeName) {
		logger.info("Start getCafeProducts. ID="+cafeName);
		return cafeService.getCafeProducts(cafeName);
	}


}
