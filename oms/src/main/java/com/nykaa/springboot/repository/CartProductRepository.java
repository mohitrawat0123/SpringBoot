package com.nykaa.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nykaa.springboot.model.CartProduct;

public interface CartProductRepository extends JpaRepository<CartProduct,String>{
	public List<CartProduct> findByCartUserName(String userName);
}
