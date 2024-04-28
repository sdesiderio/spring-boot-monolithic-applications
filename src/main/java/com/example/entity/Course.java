package com.example.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name="course")
@Entity
public class Course implements Serializable {

	private static final long serialVersionUID = -5849716222279449461L;

	@Id
	private String title;
	
	private String language;
	
	@JsonBackReference
	@OneToMany(mappedBy="course")
	private List<ReviewV1> reviews;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<ReviewV1> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewV1> reviews) {
		this.reviews = reviews;
	}

	protected Course() {
		
	}

	public Course(String title, String language) {
		
		this.title = title;
		this.language = language;
	}

	

}
