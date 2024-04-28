package com.example.entity;

import java.io.Serializable;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Cache(region = "academyCache", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Academy implements Serializable{

	private static final long serialVersionUID = 4235168958229018375L;
	
	@Id
	private String code;
	
	private String title;
	
	private String location;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	protected Academy() {
		
	}

	public Academy(String code, String title, String location) {
		
		this.code = code;
		this.title = title;
		this.location = location;
	}
	
	
	
	

}
