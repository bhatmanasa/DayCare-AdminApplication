package edu.neu.csye6200.daycare.student;

import edu.neu.csye6200.daycare.CsvReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.csv.CSVRecord;

public class StudentCsvReader {

    public String getStudentData(String inputID) {
        //Open the student.csv file
        //Get all the items
        //return where id matches else return empty string
        System.out.println("Reading data from csv file...");
        CsvReader reader = new CsvReader();
        CSVRecord info = reader.readFromFile("StudentID",inputID,"student.csv");
        Student student = new Student();
        if(info == null) {
            System.out.println("STUDENT NOT FOUND");
            return "STUDENT NOT FOUND";
        }

        //StudentID,TeacherID,ClassID,Age,Name,Sex,ParentsName,Address,PhoneNumber,RegistrationDate
        student.setClassID(info.get("ClassID"));
        student.setAddress(info.get("Address"));
        student.setParentsName(info.get("ParentsName"));
        student.setPhoneNumber(info.get("PhoneNumber"));
        student.setName(info.get("Name"));
        student.setSex(info.get("Sex"));

        //convert string to date
        String date = info.get("RegistrationDate");
        try{
        Date regDate = new Date(date);
        
        student.setRegistrationDate(regDate);
        }catch(Exception e){
            System.out.println("Cannot read date"+e);
        }
        
        //convert int to string for StudentID,TeacherID,Age
        String studentID = info.get("StudentID");
        int s_id = Integer.parseInt(studentID);
        student.setStudentID(s_id);

        String teacherID = info.get("TeacherID");
        int t_id = Integer.parseInt(teacherID);
        student.setTeacherID(t_id);

        String studentAge = info.get("Age");
        int s_age = Integer.parseInt(studentAge);
        student.setAge(s_age);
        
        System.out.println("Student Found");
        return getStudentDetails(student);
    }

    private String getStudentDetails(Student student) {
        String studentDetails =  "Student name: " + student.getName()+
                "\nAge: " + student.getAge()+ " months" +
                "\nSex: " +student.getSex()+
                "\nTeacherID: " + student.getTeacherID()+
                "\nClassID: "+student.getClassID()+
                "\nParent's Name: "+student.getParentsName()+
                "\nAddress: " + student.getAddress()+
                "\nPhone number: " + student.getPhoneNumber()+
                "\nRegistration Date: "+ student.getRegistrationDate();
        
                //add immunization details

        System.out.println(studentDetails);
        return studentDetails;

    }
    
    public Student getStudent(String inputID) {
        CsvReader reader = new CsvReader();
        CSVRecord info = reader.readFromFile("StudentID",inputID,"student.csv");
        Student s = new Student();
        if(info == null) {
            System.out.println("STUDENT DETAIL NOT FOUND");
            return null;
        }
        String date = info.get("RegistrationDate");

        try{
            
            if(date != null && !date.isEmpty()) {
                System.out.println(date);
                Date P_Date = new Date(date);
                s.setRegistrationDate(P_Date);
            }
        }catch(Exception e){
            System.out.println("Date failed" + e.getMessage());
        }
        return s;
    }
    
    public RenewalReminder getRenewalReminder(Student stuDetail){
        RenewalReminder ir = new RenewalReminder();
        return ir.getReminder(stuDetail);
}
}
