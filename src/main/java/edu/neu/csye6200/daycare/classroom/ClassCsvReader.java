/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.daycare.classroom;

import edu.neu.csye6200.daycare.CsvReader;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author Manasa
 */

public class ClassCsvReader {

//Fetches the class record for the passed ClassId.    
    public String getClassData(String inputID) {

        System.out.println("Reading data from ClassRoom csv file...");
        CsvReader reader = new CsvReader();
        CSVRecord info = reader.readFromFile("ClassID",inputID,"ClassRoom.csv");
        ClassRoom cObj = new ClassRoom();
        if(info == null) {
            System.out.println("Class not Found!");
            return "Class not Found!";
        }
        
        cObj.setClassId (info.get("ClassID"));
        cObj.setTeacherSize(Integer.parseInt(info.get("TeacherSize")));
        cObj.setStudentSize(Integer.parseInt(info.get("StudentSize")));
        cObj.setAgeGroup(info.get("AgeGroup"));
        
 
        return getClassDetails(cObj);
    }

    private String getClassDetails(ClassRoom t) {
        String classDetails =  "Class ID: " + t.getClassId()+
                "\nAge-Group: " + t.getAgeGroup()+
                "\nStudentSize: " + t.getStudentSize()+
                "\nTeacher Size: "+t.getTeacherSize();

        System.out.println(classDetails);
        return classDetails;

    }
    /*Fetch the Student Size for the passed ClassID
    * Input: ClassId 
    * Output: Student Size (int)
    */

     public int getClassStudentSize(String inputID) {

        CsvReader reader = new CsvReader();
        CSVRecord info = reader.readFromFile("ClassID",inputID,"ClassRoom.csv");
        ClassRoom cObj = new ClassRoom();
        if(info == null) {
            System.out.println("Class NOT FOUND");
        }

        cObj.setStudentSize(Integer.parseInt(info.get("StudentSize")));        
 
        return cObj.getStudentSize();
    }
    /*Fetch the Teacher Size for the passed ClassID
    * Input: ClassId 
    * Output: Teacher Size (int)
    */     
    public int getClassTeacherSize(String inputID) {
        CsvReader reader = new CsvReader();
        CSVRecord info = reader.readFromFile("ClassID",inputID,"ClassRoom.csv");
        ClassRoom cObj = new ClassRoom();
        if(info == null) {
            System.out.println("Class NOT FOUND");
        }

        cObj.setTeacherSize(Integer.parseInt(info.get("TeacherSize")));
         
        return cObj.getTeacherSize();
    }
    
}
