/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.daycare.gui;
import edu.neu.csye6200.daycare.classroom.ClassRoom;
import edu.neu.csye6200.daycare.teacher.Teacher;
import edu.neu.csye6200.daycare.teacher.TeacherFactory;

/**
 *
 * @author Manasa
 */

/* This Class will instantiate factory design pattern object.
* 1. Allocate Student to class based on its age
* 2. Allocate Teacher to the Student based on teacher availability.
* 3. Update Class and Teacher file.
*/
public class AllocateClass extends ClassRoom {

private TeacherFactory   teachFact = null;
private Teacher teacher = null;
static String[] TeachList = null;
    
    
public AllocateClass() {
}

public TeacherFactory getTeachFact() {
		return teachFact;
	}

public void setTeachFact(TeacherFactory teachFact) {
		this.teachFact = teachFact;
	}

public Teacher getTeacher() {
    System.out.println("db#4");
		return teacher;
	}

public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}