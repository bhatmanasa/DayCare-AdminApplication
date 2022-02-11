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

public abstract class TeacherFactory {
	public abstract Teacher getObject();

//	public abstract Teacher getObject(String csvData);
	public abstract Teacher getObject(String name, String agegroup);

	public abstract Teacher getObject(int age) ;
	
}