/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.daycare;

import edu.neu.csye6200.daycare.immunization.Immunization;
import edu.neu.csye6200.daycare.immunization.ImmunizationReader;
import edu.neu.csye6200.daycare.immunization.ImmunizationWriter;
import edu.neu.csye6200.daycare.immunization.ImzReminder;
import edu.neu.csye6200.daycare.student.Student;
import edu.neu.csye6200.daycare.student.StudentCsvReader;
import edu.neu.csye6200.daycare.student.StudentCsvWriter;
import java.util.Date;
import edu.neu.csye6200.daycare.classroom.ClassCsvReader;
import edu.neu.csye6200.daycare.classroom.ClassCsvWriter;
import edu.neu.csye6200.daycare.classroom.ClassRoom;
import edu.neu.csye6200.daycare.opensource.library.FileResource;
import edu.neu.csye6200.daycare.student.RenewalReminder;
import edu.neu.csye6200.daycare.student.Student;
import edu.neu.csye6200.daycare.student.StudentCsvReader;
import edu.neu.csye6200.daycare.student.StudentCsvWriter;
import edu.neu.csye6200.daycare.teacher.Teacher;
import edu.neu.csye6200.daycare.teacher.TeacherCsvReader;
import edu.neu.csye6200.daycare.teacher.TeacherCsvWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
/**
 *
 * @author anjali, Manasa
 */
public class DayCare {
    
    private DayCare(){
    }
    
    private static DayCare dayCare = new DayCare();
    
    public static synchronized DayCare getInstance(){
        return dayCare;
    }

    public void addStudent(Student student) {
        System.out.println("Inside day care add student method........");
        StudentCsvWriter studentCsvWriter = new StudentCsvWriter();
        studentCsvWriter.writeToFile(student.toString());
    }

    public String searchStudent(String studentId) {
        StudentCsvReader studentCsvReader = new StudentCsvReader();
        String studentDetails = studentCsvReader.getStudentData(studentId);
        
        ImmunizationReader imzReader = new ImmunizationReader();
        Immunization imzDetails = imzReader.getImzData(studentId);
        
        String allDetails = "";
        if (imzDetails == null){
            System.out.println("IMMUNIZATION DETAIL IS NULL");
            allDetails = studentDetails;
        }
        System.out.println("#1");
        System.out.println(imzDetails);
        
        allDetails = studentDetails + getImzDetails(imzDetails);
        
        return allDetails;
    }
    
    public ImzReminder getImzReminder(String studentId) {
        ImmunizationReader imzReader = new ImmunizationReader();
        Immunization imz = imzReader.getImzData(studentId);
        
        ImzReminder imzReminder = new ImzReminder();
        System.out.println("days left for polio " + imzReminder.getReminder(imz).getDaysLeftForPolio());
        return imzReminder.getReminder(imz);
    }
    
    public RenewalReminder getRenewalreminder(String id){
        StudentCsvReader reader = new StudentCsvReader();
        Student s = reader.getStudent(id);
        
        RenewalReminder rr = new RenewalReminder();
        return rr.getReminder(s);
    //this should return a RenewalReminder object
    }
    
    public void addImmzDetails(Immunization imz){
        //read imz file if empty add header line
        System.out.println("Inside day care " + imz.getRemainingPolioDoses());
        ImmunizationWriter imzW = new ImmunizationWriter();
        imzW.writeToFile(imz.toString());
    }
    
    private String getImzDetails(Immunization imz) {
        
        String imzDetails="";
        
        if (imz==null){
            System.out.println("Reached imz=null");
            imzDetails = ", IMMUNIZATION DETAIL NOT FOUND";
            return imzDetails;
        }
        
        imzDetails =  "\n"+"\nImmunization Details:"+
                "\nGroup ID: " + imz.getGroupID()+
                "\nPolio Status: " + imz.getPolioStatus()+
                "\nPolio Date " + imz.getPolioDate()+
                "\nMax Polio Doses: " + imz.getMaxPolioDoses()+
                "\nPolio doses given: "+imz.getPolioDosesDone()+
                "\nPolio doses remaining "+imz.getRemainingPolioDoses()+
                
                "\n\nDtap Status: " + imz.getDtapStatus()+
                "\nDtap Date " +imz.getDtapDate()+
                "\nMax Dtap Doses: " + imz.getMaxDtapDoses()+
                "\nDtap doses given: "+imz.getDtapDosesDone()+
                "\nDtap doses remaining "+imz.getRemainingDtapDoses()+
                
                "\n\nHepatitis-B Status: " + imz.isHepaStatus()+
                "\nHepatitis-B Date " +imz.getHepaDate()+
                "\nMax Hepatitis-B Doses: " + imz.getMaxHepaDoses()+
                "\nHepatitis-B doses given: "+imz.getHepaDosesDone()+
                "\nHepatitis-B doses remaining "+imz.getRemainingHepaDoses()+
                
                "\n\nMmr Status: " + imz.isMmrStatus()+
                "\nMmr Date " +imz.getMmrDate()+
                "\nMax Mmr Doses: " + imz.getMaxMmrDoses()+
                "\nMmr doses given: "+imz.getMmrDosesDone()+
                "\nMmr doses remaining "+imz.getRemainingMmrDoses()+
                
                "\n\nVaricella Status: " + imz.isVarStatus()+
                "\nVaricella Date " +imz.getVarDate()+
                "\nMax Varicella Doses: " + imz.getVarDosesDone()+
                "\nVaricella doses given: "+imz.getVarDosesDone()+
                "\nVaricella doses remaining "+imz.getRemainingVarDoses()+
        
                "\n\nHib Status: " + imz.isHibStatus() +
                "\nHib Date " +imz.getHibDate()+
                "\nMax Hib Doses: " + imz.getMaxHibDoses()+
                "\nHib doses given: "+imz.getHibDosesDone()+
                "\nHib doses remaining "+imz.getRemainingHibDoses();
        
        
          
        System.out.println(imzDetails);
        return imzDetails;

    }
    //Adds Teacher data into Teacher.csv file    
    public void addTeacher(Teacher teacher) {
         TeacherCsvWriter tCsvWriter = new TeacherCsvWriter();
        tCsvWriter.writeToFile(teacher.toString());
    }

//Searches Teacher reacord based on the input Teacher ID.
    public String searchTeacher(String teacherId) {
        TeacherCsvReader tCsvReader = new TeacherCsvReader();
        String tDetails = tCsvReader.getTeacherData(teacherId);
        
        return tDetails;
    }
    
    public void updateTeacherStudent (int teacherId){
     String tempFile = "temp.csv";
      File teacherFile = new File("Teacher.csv");
      File newFile = new File(tempFile);
          try {
      FileWriter fw = new FileWriter(tempFile,true);       
      BufferedWriter buffer = new BufferedWriter(fw);
      PrintWriter pwrite = new PrintWriter(buffer);
     
      TeacherCsvReader tCsvReader = new TeacherCsvReader();
      //fetching highest teacher id
      int teachid = (tCsvReader.getLastestTeacherId());
        pwrite.println("TeacherID,TeacherName,Age,Sex,JoiningDate,ClassID,AgeGroup,StudentSize");
        //Starting teacher id = 201.

        for(int i = 201;i<(teachid+1);i++){ 
           CsvReader reader = new CsvReader();
           CSVRecord r = reader.readFromFile("TeacherID",Integer.toString(i),"Teacher.csv");
        
          int tempTeachId = Integer.parseInt(r.get("TeacherID"));
          String tempTeachName = r.get(1);
          String tempTeachAge = r.get("Age");
          String tempTeachSex = r.get(3);
          String tempTeachDate = r.get("JoiningDate");
          String tempTeachClassId = r.get("ClassID");
          String tempTeachAgeGroup = r.get("AgeGroup");
          int tempTeachStudSize = Integer.parseInt(r.get("StudentSize"));

       
      // Update teacher StudentSize   
          if(tempTeachId==teacherId){
              pwrite.println(tempTeachId+","+tempTeachName+","+tempTeachAge+","+tempTeachSex
                      +","+tempTeachDate+","+tempTeachClassId+","+tempTeachAgeGroup+","+(tempTeachStudSize+1));
              System.out.println("Reachedhere"+(tempTeachId+","+tempTeachName+","+tempTeachAge+","+tempTeachSex
                      +","+tempTeachDate+","+tempTeachClassId+","+tempTeachAgeGroup+","+(tempTeachStudSize+1)));
          }else{
                  pwrite.println(tempTeachId+","+tempTeachName+","+tempTeachAge+","+tempTeachSex
                      +","+tempTeachDate+","+tempTeachClassId+","+tempTeachAgeGroup+","+(tempTeachStudSize));
          }
        }
      pwrite.flush();
      pwrite.close();
      
     //Remove the old Teacher.csv file and replace with the temp file. 
      teacherFile.delete();
      File f = new File("Teacher.csv");
      newFile.renameTo(f);
     }    catch(Exception e){
     }   
    }

//Adds Class record in ClassRoom.csv file.    
    public void addClass (ClassRoom cObj) {
        ClassCsvWriter classCsvWriter = new ClassCsvWriter();
        classCsvWriter.writeToFile(cObj.toString());
    }

//Searches Class record based on the ClassID passed.    
    public String searchClass(String classId) {
        ClassCsvReader cCsvReader = new ClassCsvReader(); 
        String classDetails = cCsvReader.getClassData(classId);

        return classDetails;
    }
    
/* Updates the Teacher Size in ClassRoom.csv file 
  * when new teacher gets enrolled
  */          
    public void updateClassTeacher (String classId){
      String tempFile = "temp.csv";
      File classFile = new File("ClassRoom.csv");
      File newFile = new File(tempFile);
      String[] classList = {"A","B","C","D","E","F"};
    
    try{
      FileWriter fw = new FileWriter(tempFile,true);       
      BufferedWriter buffer = new BufferedWriter(fw);
      PrintWriter pwrite = new PrintWriter(buffer);
      
        pwrite.println("ClassID,TeacherSize,StudentSize,AgeGroup");
        for(String i: classList){ 
           CsvReader reader = new CsvReader();
           CSVRecord info = reader.readFromFile("ClassID",i,"ClassRoom.csv");
        
          String tempClassId = info.get("ClassID");
          int tempTeachSize = Integer.parseInt(info.get("TeacherSize"));
          int tempStudSize =  Integer.parseInt(info.get("StudentSize"));
          String tempagegp = info.get("AgeGroup");
          String agegp = (info.get("AgeGroup"));
          
      // Update teacher Size for the newly recuited Teacher's ClassId.    
          if(tempClassId.equals(classId)){
              pwrite.println(tempClassId+","+(tempTeachSize+1)+","+tempStudSize+","+tempagegp);
          }else{
             pwrite.println(tempClassId+","+(tempTeachSize)+","+tempStudSize+","+tempagegp); 
          }
        }
      pwrite.flush();
      pwrite.close();
      
     //Remove the old ClassRoom.csv file and replace with the temp file. 
      classFile.delete();
      File f = new File("ClassRoom.csv");
      newFile.renameTo(f);
     }    catch(Exception e){
     }   
    }
    
    //Update the student size in ClassRoom.csv when new student gets enrolled.
    public void updateClassStudent (String classId){
      String tempFile = "temp.csv";
      File classFile = new File("ClassRoom.csv");
      File newFile = new File(tempFile);
      String[] classList = {"A","B","C","D","E","F"};
    
    try{
      FileWriter fw = new FileWriter(tempFile,true);       
      BufferedWriter buffer = new BufferedWriter(fw);
      PrintWriter pwrite = new PrintWriter(buffer);
      
        pwrite.println("ClassID,TeacherSize,StudentSize,AgeGroup");
        for(String i: classList){ 
           CsvReader reader = new CsvReader();
           CSVRecord info = reader.readFromFile("ClassID",i,"ClassRoom.csv");
        
          String tempClassId = info.get("ClassID");
          int tempTeachSize = Integer.parseInt(info.get("TeacherSize"));
          int tempStudSize =  Integer.parseInt(info.get("StudentSize"));
          String tempagegp = info.get("AgeGroup");
          String agegp = (info.get("AgeGroup"));
          
      // Update teacher Size for the newly recuited Teacher's ClassId.    
          if(tempClassId.equals(classId)){
              pwrite.println(tempClassId+","+tempTeachSize+","+(tempStudSize+1)+","+tempagegp);
          }else{
             pwrite.println(tempClassId+","+(tempTeachSize)+","+tempStudSize+","+tempagegp); 
          }
        }
      pwrite.flush();
      pwrite.close();
      
     //Remove the old ClassRoom.csv file and replace with the temp file. 
      classFile.delete();
      File f = new File("ClassRoom.csv");
      newFile.renameTo(f);
     }    catch(Exception e){
     }   
    }
}

