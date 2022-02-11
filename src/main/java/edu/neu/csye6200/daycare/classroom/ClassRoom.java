/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.daycare.classroom;

/**
 *
 * @author Manasa
 */


/* ClassRoom data present in ClassRoom.csv File
 * It has below records:
 * Record 1 : Class ID - (A,B,C,D,E,F}
 * Record 2 : TeacherSize
 * Record 3 : StudentSize 
 * Record 4 : AgeGroup - in months
 */
public class ClassRoom {
private String classId;
private int teacherSize;
private int studentSize;
private String ageGroup;
	
    
public String getClassId() {
    return classId;
	}

public void setClassId(String classId) {
    this.classId = classId;
	}

public int getTeacherSize() {
    return teacherSize;
	}

public void setTeacherSize(int teacherSize) {
    this.teacherSize = teacherSize;
	}

public int getStudentSize() {
    return studentSize;
	}

public void setStudentSize(int studentSize) {
    this.studentSize = studentSize;
	}

public String getAgeGroup() {
	return ageGroup;
	}

public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}

@Override
public String toString() {
    return this.getClassId()+ "," + this.getTeacherSize()+ "," + this.getStudentSize()+ "," + this.getAgeGroup();
        }

}