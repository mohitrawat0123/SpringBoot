package com.nykaa.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.nykaa.springboot.model.CartProduct;
import com.nykaa.springboot.repository.CartProductRepository;

@Controller
public class CartProductController {
	@Autowired
	private CartProductRepository cpr;
	
	@CrossOrigin
	@PostMapping("/aTC/prod")
	@ResponseStatus(HttpStatus.OK)
	public void addProd(@RequestBody CartProduct cp) {
		cpr.save(cp);
	}
	
}
