package com.nykaa.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private String pid;
	private	String des;	
	private String price;
	public Product() {
		
	}
	public Product(String pid,String des,String price) {
		this.pid=pid;
		this.des=des;
		this.price=price;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
