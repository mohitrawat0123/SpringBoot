package com.nykaa.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nykaa.springboot.model.Cart;
import com.nykaa.springboot.repository.CartRepository;

@RestController
public class CartController {
	@Autowired
	private CartRepository cr;
	
	@PostMapping("/aTC")
	@ResponseStatus(HttpStatus.OK)
	public void addToCart(@RequestBody Cart crt ) {
		cr.save(crt);
	}
	
	

}
