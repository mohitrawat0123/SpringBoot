package com.nykaa.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nykaa.springboot.model.Cart;

public interface CartRepository extends JpaRepository<Cart,String>{

}
