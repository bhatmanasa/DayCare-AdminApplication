package edu.neu.csye6200.daycare.student;

import edu.neu.csye6200.daycare.CsvWriter;


public class StudentCsvWriter {

    public void writeToFile(String csvData) {

        //Create a file students.csv if it doesn't exist already
        // Write this new line to the student.csv
        CsvWriter csvWriter = new CsvWriter();
        csvWriter.writeToFile("\n"+csvData, "student.csv");

    }
}
