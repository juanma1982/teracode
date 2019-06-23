package com.teracode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class School {
	
	protected List<Student> students;
	protected Set<Subject> subjects;
	
	private static final School instance = new School();
	
	private School() {
		this.students = new ArrayList<Student>();
		this.subjects = new HashSet<Subject>();
	}
	
	public static School getInstance() {
		return instance;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}
	
	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void addSubjects(Subject subject) {
		if(this.subjects.contains(subject)) {
			throw new IllegalArgumentException(subject.getName()+" already not exists");
		}
		this.subjects.add(subject);
	}
	

	public void subscribeToSubject(Subject subject,Student student) {
		Subject selected = obtainSubject(subject);
		selected.subscribeStudent(student);
	}

	
	public void unSubscribeToSubject(Subject subject,Student student) {
		Subject selected = obtainSubject(subject);
		selected.unSubscribeStudent(student);
		
	}
	private Subject obtainSubject(Subject subject) {
		if(!this.subjects.contains(subject)) {
			throw new IllegalArgumentException(subject.getName()+" does not exists");
		}
		Subject selected=null;
		for (Subject current : this.subjects) {
		    if (current.equals(subject)) {
		    	selected =  current;
		    	break;
		    }
		}
		return selected;
	}
	
	/**
	 * Point A
	 * @author Juan Manuel Rodríguez
	 * @return returns a list of all students grouped by the first letter of
			   their last name.
	 */
	public Map<String,List<Student>> listStudentsGroupedByFirstLastNameLetter(){
		
		Map<String,List<Student>> returnMap = new HashMap<String,List<Student>>();
		for (Student student : students) {
			String firstletter =  String.valueOf(student.getLastName().charAt(0)).toUpperCase();
			List<Student> currentList = returnMap.get(firstletter);
			if ( currentList == null) {
				returnMap.put(firstletter, new ArrayList<Student>());
				currentList = returnMap.get(firstletter);
			}
			currentList.add(student);
		}
		return returnMap;
	}
	
	/**
	 * Point B
	 * @author Juan Manuel Rodríguez
	 * @return returns a list of students taking a (given) subject.
	 */
	public List<Student> getStudentsInSubject(Subject subject){
		Subject selected = obtainSubject(subject);		
		List<Student> subjectList = new ArrayList<Student>();
		subjectList.addAll(selected.getStudents());
		
		return subjectList;
	}

	

	
}
