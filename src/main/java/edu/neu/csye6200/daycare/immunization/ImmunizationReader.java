/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.daycare.immunization;

import edu.neu.csye6200.daycare.CsvReader;
import edu.neu.csye6200.daycare.student.Student;
import edu.neu.csye6200.daycare.student.StudentGroup;
import java.util.Date;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author anjali
 */
public class ImmunizationReader {
    
    public ImmunizationReader(){
    }
    
    public Immunization getImzData(String inputID) {
        //Open the imz.csv file
        //Get all the items
        //return where id matches else return empty string
        System.out.println("Reading data from imz.csv...");
        CsvReader reader = new CsvReader();
        CSVRecord info = reader.readFromFile("StudentID",inputID,"imz.csv");
        Immunization imzDetail = new Immunization();
        if(info == null) {
            System.out.println("IMMUNIZATION DETAIL NOT FOUND");
            return null;
        }

        //StudentId,groupID,PolioStatus,PolioDate,MaxPolioDoses,PolioDoesDone,RemainingPolioDoses
        
        //convert String to enum
        String grpID = info.get("GroupID");
        StudentGroup groupID_enum = StudentGroup.valueOf(grpID);
        imzDetail.setGroupID(groupID_enum);
        
        //convert String to boolean
        String s1 = info.get("PolioStatus");
        Boolean b1 = Boolean.parseBoolean(s1);
        imzDetail.setPolioStatus(b1);
        imzDetail.setDtapStatus(Boolean.parseBoolean(info.get("DtapStatus")));
        imzDetail.setHibStatus(Boolean.parseBoolean(info.get("HibStatus")));
        imzDetail.setHepaStatus(Boolean.parseBoolean(info.get("HepaStatus")));
        imzDetail.setMmrStatus(Boolean.parseBoolean(info.get("MmrStatus")));
        imzDetail.setVarStatus(Boolean.parseBoolean(info.get("VarStatus")));
       
        //convert String to date
        String p_date = info.get("PolioDate");
        String d_date = info.get("DtapDate");
        String hib_date = info.get("HibDate");
        String hepa_date = info.get("HepaDate");
        String m_date = info.get("MmrDate");
        String v_date = info.get("VarDate");
        
        try{
            
            if(p_date != null && !p_date.isEmpty()) {
                System.out.println(p_date);
                Date P_Date = new Date(p_date);
                imzDetail.setPolioDate(P_Date);
            }
        
            if(!"null".equals(d_date)) {
                System.out.println("d_date "+ d_date);
                Date D_Date = new Date(d_date);
                imzDetail.setDtapDate(D_Date);
                
            }
        
            if(!"null".equals(hib_date)){
                System.out.println("hib_date " + hib_date);
                Date Hib_Date = new Date(hib_date);
                imzDetail.setHibDate(Hib_Date);
            }
        
            if(!"null".equals(hepa_date)) {
                System.out.println("hepa_date " + hepa_date);
                Date Hepa_Date = new Date(hepa_date);
                imzDetail.setHepaDate(Hepa_Date);
            }
        
            if(!"null".equals(m_date)) {
                System.out.println("m_date " + m_date);
                Date M_Date = new Date(m_date);
                imzDetail.setMmrDate(M_Date);
            }
        
            if(!"null".equals(v_date)) {
                System.out.println("v_date " + v_date);
                Date V_Date = new Date(v_date);
                imzDetail.setVarDate(V_Date);
            }
        }catch(Exception e){
            System.out.println("Date failed" + e.getMessage());
        }
        
        //convert String to int
        String maxPDoses = info.get("MaxPolioDoses");
        int max_PDoses = Integer.parseInt(maxPDoses);
        imzDetail.setMaxPolioDoses(max_PDoses);
        imzDetail.setMaxDtapDoses(Integer.parseInt(info.get("MaxDtapDoses")));
        imzDetail.setMaxHibDoses(Integer.parseInt(info.get("MaxHibDoses")));
        imzDetail.setMaxHepaDoses(Integer.parseInt(info.get("MaxHepaDoses")));
        imzDetail.setMaxMmrDoses(Integer.parseInt(info.get("MaxMmrDoses")));
        imzDetail.setMaxVarDoses(Integer.parseInt(info.get("MaxVarDoses")));
        
        //convert String to int
        String p_done = info.get("PolioDoesDone");
        int p_dosesDone = Integer.parseInt(p_done);
        imzDetail.setPolioDosesDone(p_dosesDone);
        imzDetail.setDtapDosesDone(Integer.parseInt(info.get("DtapDosesDone")));
        imzDetail.setHibDosesDone(Integer.parseInt(info.get("HibDosesDone")));
        imzDetail.setHepaDosesDone(Integer.parseInt(info.get("HepaDosesDone")));
        imzDetail.setMmrDosesDone(Integer.parseInt(info.get("MmrDosesDone")));
        imzDetail.setVarDosesDone(Integer.parseInt(info.get("VarDosesDone")));
        
        //convert String to int
        String p_rem = info.get(6);
        int p_remDoses = Integer.parseInt(p_rem);
        imzDetail.setRemainingPolioDoses(p_remDoses);
        imzDetail.setRemainingDtapDoses(Integer.parseInt(info.get("RemDtapDoses")));
        imzDetail.setRemainingHibDoses(Integer.parseInt(info.get("RemHibDoses")));
        imzDetail.setRemainingHepaDoses(Integer.parseInt(info.get("RemHepaDoses")));
        imzDetail.setRemainingMmrDoses(Integer.parseInt(info.get("RemMmrDoses")));
        imzDetail.setRemainingVarDoses(Integer.parseInt(info.get("RemVarDoses")));

        System.out.println("Immunization Details Found");
        return imzDetail;
    }

    public ImzReminder getImzReminder(Immunization imzDetail){
        ImzReminder ir = new ImzReminder();
        return ir.getReminder(imzDetail);
    }
}
