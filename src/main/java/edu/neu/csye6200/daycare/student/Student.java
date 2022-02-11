package edu.neu.csye6200.daycare.student;

import edu.neu.csye6200.daycare.person.Person;
import static edu.neu.csye6200.daycare.student.StudentGroup.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;
/* Student data present in Student.csv File
 * It has below records:
 * Record 1 : StudentID - 100 series : {101,102,103,.....}
 * Record 2 : TeacherID - 200 series : {201,202,203,....} 
 * Record 3 : Class ID (based on age group of students)
              A: 6-12 months; B: 13-24 months; C: 25-35 months;
              D: 36-47 months; E: 48-59 months; F:60 and above
 * Record 4 : Age
 * Record 5 : Name 
 * Record 6 : Sex
 * Record 7 : ParentName
 * Record 8 : Address 
 * Record 9 : PhoneNumber
 * Record 10 : RegistrationDate
 */
    public class Student extends Person {
        private int studentID;
        private StudentGroup groupID;
        private int teacherID;
        private String classID;
        private String parentsName;
        private String address;
        private String phoneNumber;
        private Date registrationDate;
        //private String registrationDate;
  
        public Student () {
	super();
         } 
              
        public Student (String csvData) throws ParseException {
            
	Scanner Studentscan = new Scanner(csvData);
	Studentscan.useDelimiter(",");
        this.setStudentID(Studentscan.nextInt());
        this.setTeacherID(Studentscan.nextInt());
        this.setClassID(Studentscan.next()); 
        this.setGroupID(Studentscan.nextInt());   
        this.setAge(Studentscan.nextInt());
        this.setName(Studentscan.next());
        this.setSex(Studentscan.next());      
        this.setParentsName(Studentscan.next());
        this.setAddress(Studentscan.next());
        this.setPhoneNumber(Studentscan.next());
        String date =Studentscan.next();
        System.out.println("date is " + date);
        
        LocalDate currDate = java.time.LocalDate.now();
        //convert LocaLocalDatelDate to Date:
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date currentDate = Date.from(currDate.atStartOfDay(defaultZoneId).toInstant());
        //Date regDate = new SimpleDateFormat("dd/MM/yyyy").parse("19/08/2020");
        this.setRegistrationDate(currentDate); 
	Studentscan.close();
        }       
        public StudentGroup getGroupID() {
            return groupID;
        }

        public void setGroupID(int age) {
            if(age>=6 && age<=12)
                this.groupID = GROUP_A;
            else if(age>=13 && age<=24)
                this.groupID = GROUP_B;
            else if(age>=25 && age<=35)
                this.groupID = GROUP_C;
            else if(age>=36 && age<=47)
                this.groupID = GROUP_D;
            else if(age>=48 && age<=59)
                this.groupID = GROUP_E;
            else if(age>=60)
                 this.groupID = GROUP_F;
        }

        public int getStudentID() {
            return studentID;
        }

        public void setStudentID(int studentID) {
            this.studentID = studentID;
        }

        public int getTeacherID() {
            return teacherID;
        }

        public void setTeacherID(int teacherID) {
            this.teacherID = teacherID;
        }

        public String getClassID() {
            return classID;
        }

        public void setClassID(String classID) {
            this.classID = classID;
        }

        public String getParentsName() {
            return parentsName;
        }

        public void setParentsName(String parentsName) {
            this.parentsName = parentsName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
        
        public Date getRegistrationDate() {
        
            return registrationDate;
        }

        public void setRegistrationDate(Date registrationDate) {
            this.registrationDate = registrationDate;
        }

        @Override
        public String toString() {
            return this.getStudentID() + "," + this.getTeacherID() + "," +this.getClassID()+","+ this.getGroupID() + "," + this.getAge()
                    +","+this.getName()+","+this.getSex()+","+this.getParentsName()+","+this.getAddress()+","+
                    this.getPhoneNumber()+","+this.getRegistrationDate();
        }
    }
