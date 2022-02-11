/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.daycare;

import edu.neu.csye6200.daycare.opensource.library.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author anjali,Manasa
 */
public class CsvReader {
    public CSVRecord readFromFile(String idName,String inputID,String fileName) {
        try {
            FileResource fr = new FileResource(fileName);
            CSVParser parser = fr.getCSVParser();

            for(CSVRecord r : parser) {
                if (r.get(idName).equals(inputID)) {
                    return r;
                }
            }
            return null;

        } catch (Exception e) {
            System.out.println("Exception while reading file"+e);
            throw e;
        }
    }
  
    /*This method will return Highest TeacherID
    *from the file Teacher.csv.
    *Input: Teacher.csv file
    *Output: int(TeacherId)
    */
   public int getId(String fileName) {
            int currentValue = 0;
            int maxValues = 0;
        try {
            FileResource fr = new FileResource(fileName);
            CSVParser parser = fr.getCSVParser();
            
        //Fetches the highest teacher Id    
            for(CSVRecord r : parser) {
                
            if (r.get("TeacherID").isEmpty()!= true){
            
            currentValue = Integer.parseInt(r.get("TeacherID"));
            if(currentValue > maxValues) {
                maxValues = currentValue;
             }           
            }
            }
           if(maxValues> 0){
                return maxValues;
           }else{
               
           // Teacher record starts with 200 series...
           
               maxValues = 200;
               return maxValues;
           }            

        } catch (Exception e) {
            System.out.println("Exception while reading file"+e);
        }
        return maxValues;
    }
   
    
    
}
