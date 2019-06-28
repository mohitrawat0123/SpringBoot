package com.nykaa.springboot.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nykaa.springboot.model.OrdrProduct;

public interface OrdersProductRepository extends JpaRepository<OrdrProduct,Long>{

	ArrayList<OrdrProduct> findByO_Oid(long oid);

}
