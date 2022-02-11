/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.daycare.immunization;

import static edu.neu.csye6200.daycare.immunization.Vaccine.VaccineName.*;
import edu.neu.csye6200.daycare.student.StudentGroup;
import static edu.neu.csye6200.daycare.student.StudentGroup.*;
import java.util.*;

/**
 *
 * @author anjali
 */
public class ImzMapper {
    
    private static ImzMapper imz = null;
    
    private ImzMapper() {
        constructMap();
    }
    
    public static synchronized ImzMapper getInstance() {
        if(imz == null) {
            imz = new ImzMapper();
        }
        return imz;
    }
    
    private static Map<StudentGroup, List<Vaccine>> map = new HashMap<>();
    
    
    //Storage for vaccine details
    private static void constructMap() {
        Vaccine v1 = new Vaccine(HIB, 4);
        Vaccine v2 = new Vaccine(DTAP, 4);
        Vaccine v3 = new Vaccine(POLIO,3);
        Vaccine v4 = new Vaccine(HEPATITIS,3);
        Vaccine v5 = new Vaccine(MMR,1);
        Vaccine v6 = new Vaccine(VARICELLA,1);
        
        Vaccine v7 = new Vaccine(DTAP, 5);
        Vaccine v8 = new Vaccine(POLIO,4);
        Vaccine v9 = new Vaccine(HEPATITIS,3);
        Vaccine vTen = new Vaccine(MMR,2);
        Vaccine v11 = new Vaccine(VARICELLA,2);
              
        List<Vaccine> listA = new ArrayList<>();// for <2 years
        listA.add(v1);
        listA.add(v2);
        listA.add(v3);
        listA.add(v4);
        listA.add(v5);
        listA.add(v6);
        
        List<Vaccine> listB = new ArrayList<>();// for rest of the groups
        listB.add(v7);
        listB.add(v8);
        listB.add(v9);
        listB.add(vTen);
        listB.add(v11);
        
        map.put(GROUP_A, listA);
        map.put(GROUP_B, listA);
        
        map.put(GROUP_C,listB);
        map.put(GROUP_D,listB);
        map.put(GROUP_E,listB);
        map.put(GROUP_F,listB);
 
    }
    
    public List<Vaccine> mapToDosage(StudentGroup groupID){
        return map.get(groupID);
    }
    
}
