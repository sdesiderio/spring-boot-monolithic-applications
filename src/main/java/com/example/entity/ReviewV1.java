package com.example.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name="review")
@Entity
public class ReviewV1 implements Serializable {

	private static final long serialVersionUID = 8677461993931034727L;
	
	@Id
	private String code;
	
	private String location;
	
	@JsonManagedReference
	@ManyToOne
	private Course course;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	protected ReviewV1() {
		
	}

	public ReviewV1(String code, String location) {
		
		this.code = code;
		this.location = location;
	}
	
	
	

}
