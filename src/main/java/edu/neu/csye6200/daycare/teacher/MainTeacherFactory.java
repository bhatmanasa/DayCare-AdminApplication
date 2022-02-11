/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.daycare.teacher;

/**
 *
 * @author Manasa
 */

public class MainTeacherFactory extends TeacherFactory{
	private static TeacherFactory instance;
	
	public MainTeacherFactory(){
		instance = null;
	}
	
	public static TeacherFactory getInstance() {
		if (instance == null) {
			
			instance = new MainTeacherFactory();
        }
		return instance;
	}
	@Override
	public Teacher getObject() {
		
        	return new AllocTeacher();
	}

	@Override
	public Teacher getObject(int age) {
		return new AllocTeacher(age);
	}

	@Override
	public Teacher getObject(String name, String agegroup) {
		return null;
	}

/*	@Override
	public Teacher getObject(String csvData) {
    	return new PreCareTeacher1(csvData);
	}
	*/
}
