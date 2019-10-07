package org.softtek.objects;

import org.softtek.utils.AttributesGenerator;

public class Person {
	private String firstName;
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*
	 * If you don't send parameters, it generates random attributes to the person
	 */
	public Person() {
		AttributesGenerator attributesGenerator = new AttributesGenerator();
		this.firstName = attributesGenerator.generateFirstName();
		this.lastName = attributesGenerator.generateLastName();
	}
	
	/*
	 * if you send parameters, it sets the attributes you called.
	 */
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
