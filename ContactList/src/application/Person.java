package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
	
	private SimpleStringProperty firstname;
	private SimpleStringProperty lastname;
	private SimpleStringProperty number;
			
			
	public Person(String firstname, String lastname, String number) {
		this.firstname = new SimpleStringProperty(firstname);
		this.lastname = new SimpleStringProperty(lastname);
		this.number = new SimpleStringProperty(number);
	}
	    
	public StringProperty firstName() {
		return firstname;
	}
	
	public String getFirstName() {
		return firstName().get();
	}
	
	public StringProperty lastName() {
		return lastname;
	}
	
	public String getLastName() {
		return lastName().get();
	}
	
	public StringProperty number() {
		return number;
	}
	
	public String getNumber() {
		return number().get();
	}
	
	public void setName(String name) {
		firstName().set(name);
	}
	
	public void setLastName(String lastname) {
		lastName().set(lastname);
	}
	
	public void setNumber(String number) {
		number().set(number);
	}
}
