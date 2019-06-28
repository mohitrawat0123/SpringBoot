package com.nykaa.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrdrProduct{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
	long id;
	
	private String pid;
	
	@ManyToOne
	@JoinColumn(name="oid")
	private Ordr o;
	public OrdrProduct() {
		
	}
	
	public OrdrProduct(long id,String pid) {
		this.id=id;
		this.pid=pid;
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

	public Ordr getO() {
		return o;
	}

	public void setO(Ordr o) {
		this.o = o;
	}


	
}
