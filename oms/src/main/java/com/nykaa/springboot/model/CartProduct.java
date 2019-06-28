package com.nykaa.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CartProduct{
	@Id @GeneratedValue(strategy=GenerationType.AUTO) long id;
	private String pid;
	
	@ManyToOne
	@JoinColumn(name="userName")
	private Cart cart;
	
	public CartProduct() {
		
	}
	public CartProduct(Long id,String pid) {
		this.id=id;
		this.pid=pid;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}

	
}
