package com.teracode;

import java.util.Set;

public class Subject {
	
	protected String name;
	protected String code;
	protected Set<Student> students;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getCode() {
		return code;
	}

	public void setCode(String subjectCode) {
		this.code = subjectCode;
	}
	
	public void subscribeStudent(Student student) {
		if(this.students.contains(student)) {
			throw new IllegalArgumentException("student already subscribed");
		}
		this.students.add(student);
	}

	public void unSubscribeStudent(Student student) {
		if(!this.students.contains(student)) {
			throw new IllegalArgumentException("student is not subscribed");
		}
		this.students.remove(student);
		
	}

	public Set<Student> getStudents() {
		return students;
	}

	@Override
	public int hashCode() {
		return this.code.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		
		return code.equals(other.code);
			
	}
	
}
