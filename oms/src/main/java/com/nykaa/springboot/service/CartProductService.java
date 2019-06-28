package com.nykaa.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nykaa.springboot.model.CartProduct;
import com.nykaa.springboot.repository.CartProductRepository;

@Service
public class CartProductService {
	@Autowired
	private CartProductRepository cpr;
	
	public void add(CartProduct cp) {
		cpr.save(cp);
	}
}
