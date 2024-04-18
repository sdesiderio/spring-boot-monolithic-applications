package com.sistemi.informativi.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review implements Serializable{

	private static final long serialVersionUID = -8706518067564184141L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String location;
	
	/*
	 * Hibernate di default creerà all'interno
	 * della tabella review una FK denominondola
	 * con la seguente naming convention:
	 * 
	 * nomedellavariabileusata_nomedellapkusatanell'EntityPadre
	 * (nel nostro esempio Hibernate la chiamerà course_id)
	 */
	@ManyToOne
	private Course course;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	
	protected Review() {
		
	}

	public Review(String location, Course course) {
		
		this.location = location;
		this.course = course;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", location=" + location + "]";
	}
	
	
	

}
