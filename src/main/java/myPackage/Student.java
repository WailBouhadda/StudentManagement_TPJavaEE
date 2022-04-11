package myPackage;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {

	
	 int id;
	 String lastName;
	 String firstName;
	 int age;
	 String cne;
	 
	public Student() {
		
		id = this.id;
		lastName = this.lastName;
		firstName = this.firstName;
		age = this.age;
		cne = this.cne;	
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	public String getCne() {
		return cne;
	}
	
	public void setCne(String cne) {
		this.cne = cne;
	}

	
}
