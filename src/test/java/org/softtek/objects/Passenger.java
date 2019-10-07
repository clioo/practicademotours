package org.softtek.objects;

public class Passenger extends Person {
	public Passenger() {
		//initialize the parent class, in this case, Person
		super();		
	}
	public Passenger(String firstName, String lastName) {
		super(firstName, lastName);
	}
}
