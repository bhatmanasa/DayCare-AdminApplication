/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.daycare;

import edu.neu.csye6200.daycare.opensource.library.FileResource;

public class CsvWriter {

// This method will write into fileName the passed csvData if not null.

    public void writeToFile(String csvData, String fileName) {

        //Create a file students.csv if it doesn't exist already
        // Write this new line to the student.csv
        try {
            FileResource fileResource = new FileResource(fileName, true);
            System.out.println("csvData in write to file"+csvData);
            fileResource.write("\n" + csvData);

        } catch (Exception e) {
            System.out.println("Exception while writing into file");
        }
    }
}
