package com.sistemi.informativi.document;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "employee")
public class Employee {

	@MongoId
	private String passportNumber;

	private String name;

	private int level;

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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Employee(String passportNumber, String name, int level) {
		this.passportNumber = passportNumber;
		this.name = name;
		this.level = level;
	}

	protected Employee() {

	}

}
