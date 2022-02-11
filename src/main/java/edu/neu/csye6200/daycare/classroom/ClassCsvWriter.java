/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.daycare.classroom;

import edu.neu.csye6200.daycare.CsvWriter;

/**
 *
 * @author Manasa
 */
public class ClassCsvWriter {

    // This method will write into ClassRoom.csv the passed csvData.
    public void writeToFile(String csvData) {

        CsvWriter csvWriter = new CsvWriter();
        csvWriter.writeToFile(csvData, "ClassRoom.csv");

    }
}