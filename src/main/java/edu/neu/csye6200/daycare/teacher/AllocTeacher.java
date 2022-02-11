package edu.neu.csye6200.daycare.teacher;

import edu.neu.csye6200.daycare.DayCare;
import edu.neu.csye6200.daycare.opensource.library.FileResource;
import edu.neu.csye6200.daycare.student.Student;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
/**
 *
 * @author Manasa
 */

/* AllocTeacher will allocate 
* Teacher to Student based on age group and availability.
 */

public class AllocTeacher extends Teacher{	

public AllocTeacher(int age) {
	super(age);
}
public AllocTeacher() {
	super();
}


/* Reads from file Teacher.csv and returns Tlist - that contains details of each teacher
 * in different lines comma separated values.
 * Input : null
 * Output: List<String> With PreCare teacher details.
 */

public List<String> getTeacherDetails(int age){
	List<String> Tlist = new ArrayList<String>();
    TeacherCsvReader tcsv = new TeacherCsvReader();
    List<String> tlst = new ArrayList<String>(tcsv.getTeacherList(age, "Teacher.csv"));
    return Tlist;
}

    public void add(String addTlist, Student t) {
    try {
        Scanner scan = new Scanner(addTlist);
        scan.useDelimiter(",");
        System.out.println("Not student issue reached inside add");
        int teacherID2 =scan.nextInt();
        String tname2 = scan.next();
        int tAge2 = scan.nextInt();
       String tSex2 = scan.next();
         String tJDate2 = scan.next();
         String teachClassId2 = scan.next();
         String teachAgeGroup2 = scan.next();
          int teachStudSize2 = scan.nextInt();
        scan.close();  
        
        //Update Student Size in Teacher File
        System.out.println("Updating teacher size"+teacherID2);
        DayCare dc = DayCare.getInstance();
        dc.updateTeacherStudent(teacherID2);
        
        //Add  New Student Record
        
           System.out.println("Updating new student");
        String studentString = t.getStudentID()+","+teacherID2+","+teachClassId2+","+t.getAge()+","+
                t.getAge()+","+t.getName()+","+t.getSex()+","+
                t.getParentsName()+","+t.getAddress()+","+t.getPhoneNumber()+","+t.getRegistrationDate() ;

        System.out.println("New Student added:"+studentString);
        System.out.println("teacherid="+teacherID2+"classid="+teachClassId2);
        Student obj = new Student(studentString);
        dc.addStudent(obj);
        
        //Updating ClassRoom studentSize
        System.out.println("Updating Class size");
        dc.updateClassStudent(teachClassId2);

    } catch (ParseException ex) {
        Logger.getLogger(AllocTeacher.class.getName()).log(Level.SEVERE, null, ex);
    }

	}


// Remove Teacher from the file.

	public void remove() {
	  /* Read the Teacher File .csv for the given teacher id and remove the line from file.
	   */
	}
	
// Show all teachers for given age group
@Override
   public void showall() {
            String showTeacher = "";
            TeacherCsvReader tcsv = new TeacherCsvReader();
            List<String> showTlist = new ArrayList<String>(tcsv.getTeacherList(this.getAge(), "Teacher.csv"));
	       System.out.println("\nTeacher details are :\n"); 
			for (String i: showTlist){
				Scanner showscan = new Scanner(i);
				showscan.useDelimiter(",");
				   System.out.println("TeacherID: "+showscan.nextInt()
                                           +", Teacher name:"+showscan.next()
                                           +", Age: "+showscan.nextInt()+
                                           ", Sex: "+showscan.next()+
                                           ", Joining Date :"+showscan.next()+
                                           ", ClassID: "+showscan.next()+
                                           ", AgeGroup: "+showscan.next()+
                                           ", StudentSize: "+showscan.nextInt());
                                  
			}
		    
	}	
	
/* Checks the availability of teacher 
 * based on Student teacher ratio file - StudentRatio.csv
 * returns TeacherList that is available in a String.
 * 
 * Input: void.
 * Output : String containing available Teacher data comma separated .
 */

public String checkTeacher() {
   String availTeacher = null;
   String Ratiolist = null;
   int studentAllowed =0 ;
        try {
            FileResource fr = new FileResource("Ratio.csv");
            CSVParser parser = fr.getCSVParser();
           
           for(CSVRecord r : parser) {
            if((age >= 6) && (age <=12)){    
                if (r.get("AgeGroup").equalsIgnoreCase("6-12 months")){
                   studentAllowed = Integer.parseInt(r.get("StudentRatio"));          
                 }
            }else if((age >= 13) && (age <=24)){
                if (r.get("AgeGroup").equalsIgnoreCase("13-24 months")){
                    studentAllowed = Integer.parseInt(r.get("StudentRatio"));
                  }                
            }else if((age >= 25) && (age <=35)){
                if (r.get("AgeGroup").equalsIgnoreCase("25-35 months")){
                  studentAllowed = Integer.parseInt(r.get("StudentRatio"));
                }
            }else if((age >= 36) && (age <=47)){
                if (r.get("AgeGroup").equalsIgnoreCase("36-47 months")){
                   studentAllowed = Integer.parseInt(r.get("StudentRatio"));
                }
            }else if((age >= 48) && (age <=59)){
                if (r.get("AgeGroup").equalsIgnoreCase("48-59 months")){
                   studentAllowed = Integer.parseInt(r.get("StudentRatio"));
                }
            }else{
                if (r.get("AgeGroup").equalsIgnoreCase("60 months-above")){
                      studentAllowed = Integer.parseInt(r.get("StudentRatio"));
                }
            }
           }
        } catch (Exception e) {
            System.out.println("Exception while reading Ratio file"+e);
        }
	System.out.println("Max Students groups allowed : "+studentAllowed);
            TeacherCsvReader tcsv2 = new TeacherCsvReader();
            List<String> addTlist = new ArrayList<String>(tcsv2.getTeacherList(age, "Teacher.csv"));
	       

	
   boolean breakLoop = false;
     while (!breakLoop) {
      for (String i: addTlist) {   
  		Scanner Teacherscan = new Scanner(i);
  		Teacherscan.useDelimiter(",");
        int teacherID =Teacherscan.nextInt();
        String tname = Teacherscan.next();
        int tAge = Teacherscan.nextInt();
       String tSex = Teacherscan.next();
         String tJDate = Teacherscan.next();
         String teachClassId = Teacherscan.next();
         String teachAgeGroup = Teacherscan.next();
          int teachStudSize = Teacherscan.nextInt();

  		Teacherscan.close();
                
		if((teachStudSize < studentAllowed) &&(!breakLoop)){
			availTeacher = i;
			breakLoop = true ;
		}
    	  }
      breakLoop = true;
      }
     System.out.println("availableteacher:\n"+availTeacher);
      return availTeacher;
	}

}
	
