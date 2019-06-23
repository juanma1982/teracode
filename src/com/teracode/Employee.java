package com.teracode;

import com.teracode.interfaces.Iwork;

public class Employee extends Person implements Iwork {

	@Override
	public void work() {
		System.out.println("I'm working");
		
	}

}
