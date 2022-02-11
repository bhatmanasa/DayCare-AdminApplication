/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.daycare.teacher;

import edu.neu.csye6200.daycare.CsvReader;
import edu.neu.csye6200.daycare.opensource.library.FileResource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
/**
 *
 * @author Manasa
 */
public class TeacherCsvReader {
    
    //Fetchs Teacher record for the passed TeacherID.
    public String getTeacherData(String inputID) {

        CsvReader reader = new CsvReader();
        CSVRecord info = reader.readFromFile("TeacherID",inputID,"Teacher.csv");
        Teacher t = new Teacher();
        if(info == null) {
            System.out.println("Teacher Not Found!");
            return "Teacher Not Found!";
        }

        t.setTeacherId(Integer.parseInt(info.get("TeacherID")));
        t.setTname(info.get(1));
        t.setAge(Integer.parseInt(info.get("Age")));
        t.setTsex(info.get(3));
        t.setJoiningDate(info.get("JoiningDate"));
        t.setClassId(info.get("ClassID"));
        t.setAgeGroup(info.get("AgeGroup"));
        t.setStudentSize(Integer.parseInt(info.get("StudentSize")));  
        
        System.out.println("Teacher Found");
        return getTeacherDetails(t);
    }

    private String getTeacherDetails(Teacher t) {
        String tDetails =  "Teacher name: " + t.getTname()+
                "\nAge: " + t.getAge()+
                "\nSex: " +t.getTsex()+
                "\nTeacherID: " + t.getTeacherId()+
                "\nClassID: "+t.getClassId()+
                "\nAge-Group in Class: " + t.getAgeGroup()+
                "\nJoining Date: "+ t.getJoiningDate();
        
        System.out.println(tDetails);
        return tDetails;

    }
 
    //Provides the Highest Teacher ID from the Teacher.csv file.
    public int getLastestTeacherId(){
        
        CsvReader reader = new CsvReader();
        int info = reader.getId("Teacher.csv");
     
        return info;
    }
    
    /*Reads the file Teacher.csv and provides String of Teachers that have 
    * annual review in near future.
    */
       public String getAlerts(String fileName) {
           
            String joinDate;
            String alertmsg="";
        try {
            FileResource fr = new FileResource(fileName);
            CSVParser parser = fr.getCSVParser();
              
            for(CSVRecord r : parser) {
  
            if (r.get("TeacherID").isEmpty()!= true){
            
            joinDate = (r.get("JoiningDate"));
            SimpleDateFormat myFormat = new SimpleDateFormat("dd/M/yy"); 
            Date objdate = myFormat.parse(joinDate);
            Date present = new Date();
            long difference = present.getTime() - objdate.getTime();
	    float daysBetween = (difference / (1000*60*60*24));
            
            
            if((daysBetween > 365)) {
                float yearWorked = (daysBetween/365);
                alertmsg+=("ID: "+r.get("TeacherID")+
                        " is up for review!!!\n");
                alertmsg+=("Review:- Teacher ID: "+r.get("TeacherID")+", Name:"+r.get("TeacherName")+
                        "has worked for "+yearWorked+" years with our DayCare\n and currently has "+r.get("StudentSize")+" students of age group"+r.get("AgeGroup")+".\n");
                
             }           
            }
            }
           if(alertmsg!=""){
                return alertmsg;
           }else{
           
               alertmsg="No annual review coming up in near future!!!";
               return alertmsg;
           }
            

        } catch (Exception e) {
            System.out.println("Exception while reading file"+e);
        }
        return alertmsg;
    }
    //Fetches teacher list for the given file name
    public List<String> getTeacherList(int age, String fileName) {
	 List<String> Tlist = new ArrayList<String>();
	try {
            FileResource fr = new FileResource(fileName);
            CSVParser parser = fr.getCSVParser();
           for(CSVRecord r : parser) {
            if (r.get("TeacherID").isEmpty()!= true){
            if((age >= 6) && (age <=12)){    
                if (r.get("AgeGroup").equalsIgnoreCase("6-12 months")){
                   Tlist.add(r.get(0)+","+r.get(1)+","+r.get(2)+","+r.get(3)+","+r.get(4)+","+r.get(5)+","+r.get(6)+","+r.get(7));          
                 }
            }else if((age >= 13) && (age <=24)){
                if (r.get("AgeGroup").equalsIgnoreCase("13-24 months")){
                   Tlist.add(r.get(0)+","+r.get(1)+","+r.get(2)+","+r.get(3)+","+r.get(4)+","+r.get(5)+","+r.get(6)+","+r.get(7));          
                 }                
            }else if((age >= 25) && (age <=35)){
                if (r.get("AgeGroup").equalsIgnoreCase("25-35 months")){
                   Tlist.add(r.get(0)+","+r.get(1)+","+r.get(2)+","+r.get(3)+","+r.get(4)+","+r.get(5)+","+r.get(6)+","+r.get(7));          
                 }
            }else if((age >= 36) && (age <=47)){
                if (r.get("AgeGroup").equalsIgnoreCase("36-47 months")){
                   Tlist.add(r.get(0)+","+r.get(1)+","+r.get(2)+","+r.get(3)+","+r.get(4)+","+r.get(5)+","+r.get(6)+","+r.get(7));          
                 }
            }else if((age >= 48) && (age <=59)){
                if (r.get("AgeGroup").equalsIgnoreCase("48-59 months")){
                   Tlist.add(r.get(0)+","+r.get(1)+","+r.get(2)+","+r.get(3)+","+r.get(4)+","+r.get(5)+","+r.get(6)+","+r.get(7));          
                 }
            }else{
                if (r.get("AgeGroup").equalsIgnoreCase("60 months-above")){
                   Tlist.add(r.get(0)+","+r.get(1)+","+r.get(2)+","+r.get(3)+","+r.get(4)+","+r.get(5)+","+r.get(6)+","+r.get(7));          
                 }
            }
           }
           }
        } catch (Exception e) {
            System.out.println("Exception while reading file"+e);

    }
        return Tlist;
    }
}
