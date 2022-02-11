/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.daycare.teacher;

import edu.neu.csye6200.daycare.person.Person;
import edu.neu.csye6200.daycare.student.Student;
import java.util.Scanner;
/**
 *
 * @author Manasa
 */


/* Teacher data present in Teacher.csv File
 * It has below records:
 * Record 1 : Teacher ID - 200 series : {201,202,203,.....}
 * Record 2 : Name
 * Record 3 : Age 
 * Record 4 : Sex
 * Record 5 : Joining Date
 * Record 6 : Class ID (based on age group of students)
              A: 6-12 months; B: 13-24 months; C: 25-35 months;
              D: 36-47 months; E: 48-59 months; F:60 and above
 * Record 7 : Age-Group of Students allocated - in months
 * Record 8 : Student Size
 */
public class Teacher extends Person{
private int teacherId;
private String tname;
private int tage;
private String tsex; 
private String  joiningDate;
private String classId;
private String ageGroup;
private int studentSize;
        
public Teacher () {
  super();
  //Test
} 
                
public Teacher (String csvData) {
	Scanner tscan = new Scanner(csvData);
	tscan.useDelimiter(",");
        this.setTeacherId(tscan.nextInt());
        this.setTname(tscan.next());
        this.setTage(tscan.nextInt());
        this.setTsex(tscan.next());
        this.setJoiningDate(tscan.next());
        this.setClassId(tscan.next());
        this.setAgeGroup(tscan.next());
        this.setStudentSize(tscan.nextInt());
	tscan.close();
         } 

	public Teacher(int age) {
	this.age = age;
     }
        public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public int getTage() {
		return tage;
	}

	public void setTage(int tage) {
		this.tage = tage;
	}

	public String getTsex() {
		return tsex;
	}

	public void setTsex(String tsex) {
		this.tsex = tsex;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}

	public int getStudentSize() {
		return studentSize;
	}

	public void setStudentSize(int studentSize) {
		this.studentSize = studentSize;
	}

        @Override
        public String toString() {
            return this.getTeacherId()+ "," + this.getTname() + "," + this.getTage() + "," + this.getTsex()
                    +","+this.getJoiningDate()+","+this.getClassId()+","+this.getAgeGroup()+","+this.getStudentSize();
        }
	      
        public void add(String addTlist, Student tStudent){
            //problem 2
            System.out.println("db#3");
        }
	
	public void remove(){
        
        }
	
	public void showall(){

        }
	
	public String checkTeacher(){
            System.out.println("db#5");
            // problem 3
            return null;
        }
	
}