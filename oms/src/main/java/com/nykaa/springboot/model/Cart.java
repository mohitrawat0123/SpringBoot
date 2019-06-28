package com.nykaa.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {
	@Id
	private String userName;
	public Cart() {
		
	}
	public Cart(String userName) {
		this.userName=userName;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
		
	
}
