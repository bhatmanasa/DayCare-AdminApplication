/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.daycare.teacher;
import edu.neu.csye6200.daycare.CsvWriter;

/**
 *
 * @author Manasa
 */
public class TeacherCsvWriter {

    //Writes into Teacher.csv file the csvData passed as input parameter.
    public void writeToFile(String csvData) {

        CsvWriter csvWriter = new CsvWriter();
        System.out.println("csv data"+csvData);
        if(csvData!=""){
        csvWriter.writeToFile(csvData, "Teacher.csv");
        }
    }
}
