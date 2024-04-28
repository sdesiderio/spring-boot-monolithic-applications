package com.example.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = 8780069507437220517L;

	@Id
	@Column(name="passport_number")
	private String passportNumber;

	private String name;

	@Column(name="experience_years")
	private int experienceYears;

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}

	protected Employee() {

	}

	public Employee(String passportNumber, String name, int experienceYears) {
		
		this.passportNumber = passportNumber;
		this.name = name;
		this.experienceYears = experienceYears;
	}

	
}
