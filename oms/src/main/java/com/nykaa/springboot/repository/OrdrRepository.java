package com.nykaa.springboot.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nykaa.springboot.model.Ordr;

public interface OrdrRepository extends JpaRepository<Ordr,String>{

	public ArrayList<Ordr> findByUserName(String userName);
	
}
