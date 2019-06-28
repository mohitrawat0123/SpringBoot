package com.nykaa.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ordr {
	@Id @GeneratedValue(strategy=GenerationType.AUTO) long oid;
	private String userName;
	
	public Ordr() {
		
	}
	public Ordr(long oid,String userName) {
		this.oid=oid;
		this.userName=userName;
	}
	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
