package com.nykaa.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nykaa.springboot.model.Product;

public interface ProductRepository extends JpaRepository<Product,String> {

}
