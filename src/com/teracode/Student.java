package com.teracode;

import java.util.HashSet;
import java.util.Set;

import com.teracode.interfaces.IStudy;

public class Student extends Person implements IStudy {

	protected Set<Subject> subjects;
	
	public Student() {
		this.subjects = new HashSet<Subject>();
	}
	
	@Override
	public void study() {
		System.out.println("I'm studing");
		
	}
	
	@Override
	public int hashCode() {
		return this.DNI.intValue();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return DNI.equals(other.DNI);
	}


}
