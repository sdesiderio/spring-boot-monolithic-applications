package com.example.dto;

import java.io.Serializable;

public class ActutatorDTO implements Serializable{
	
	private static final long serialVersionUID = -9003841775707340007L;
	
	private String metric;
	private String type;
	private boolean isActive;
	
	
	public String getMetric() {
		return metric;
	}
	public void setMetric(String metric) {
		this.metric = metric;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	protected ActutatorDTO() {
		
	}
	
	public ActutatorDTO(String metric, String type, boolean isActive) {
		
		this.metric = metric;
		this.type = type;
		this.isActive = isActive;
	}
	
	
	

}
