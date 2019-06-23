package com.teracode;

import java.util.Calendar;
import java.util.Date;

public abstract class Person {
	protected String firstName;
	protected String lastName;
	protected String gender;
	protected Date birthDate;
	protected Integer DNI;
	
	
	public String getName() {
		return firstName;
	}
	public void setName(String name) {
		this.firstName = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirth() {
		return birthDate;
	}
	public void setBirth(Date birth) {
		this.birthDate = birth;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getAge() throws Exception {
		Calendar now = Calendar.getInstance();
		Calendar dob = Calendar.getInstance();
		dob.setTime(this.birthDate);
		if (dob.after(now)) {
		  throw new Exception("Birthdate is in the future");
		}
		int year1 = now.get(Calendar.YEAR);
		int year2 = dob.get(Calendar.YEAR);
		int age = year1 - year2;
		int month1 = now.get(Calendar.MONTH);
		int month2 = dob.get(Calendar.MONTH);
		if (month2 > month1) {
		  age--;
		} else if (month1 == month2) {
		  int day1 = now.get(Calendar.DAY_OF_MONTH);
		  int day2 = dob.get(Calendar.DAY_OF_MONTH);
		  if (day2 > day1) {
		    age--;
		  }
		}
		return age;
	}
	public Integer getDNI() {
		return DNI;
	}
	public void setDNI(Integer dNI) {
		DNI = dNI;
	}
	

}
