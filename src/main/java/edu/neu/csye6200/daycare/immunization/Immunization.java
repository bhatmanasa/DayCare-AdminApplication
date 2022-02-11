package edu.neu.csye6200.daycare.immunization;
import edu.neu.csye6200.daycare.immunization.Vaccine.*;
import static edu.neu.csye6200.daycare.immunization.Vaccine.VaccineName.*;
import edu.neu.csye6200.daycare.student.StudentGroup;
import java.util.*;

public class Immunization {
    int StudentID;
    private StudentGroup groupID;
    
    boolean polioStatus; //info from user
    Date polioDate; //info from user
    private int maxPolioDoses; 
    private int polioDosesDone; //info from user
    private int remainingPolioDoses; 

    boolean hibStatus;
    Date hibDate;
    private int maxHibDoses;
    private int hibDosesDone;
    private int remainingHibDoses;
    
    boolean dtapStatus;
    Date dtapDate;
    private int maxDtapDoses;
    private int dtapDosesDone;
    private int remainingDtapDoses;
    
    boolean hepaStatus;
    Date hepaDate;
    private int maxHepaDoses;
    private int hepaDosesDone;
    private int remainingHepaDoses;
    
    boolean mmrStatus;
    Date mmrDate;
    private int maxMmrDoses;
    private int mmrDosesDone;
    private int remainingMmrDoses;
    
    boolean varStatus;
    Date varDate;
    private int maxVarDoses;
    private int varDosesDone;
    private int remainingVarDoses;
    
    public void setMaxVarDoses(){
        ImzMapper imz = ImzMapper.getInstance();
        System.out.println(this.getGroupID());
        List<Vaccine> vaccines = imz.mapToDosage(this.getGroupID());
        System.out.println(vaccines);
        for(Vaccine v : vaccines) {
            if(VARICELLA == v.getVaccineName()) {
                this.maxVarDoses =  v.getDosage();
            }
        }
    }
    
    public void setMaxMmrDoses(){
        ImzMapper imz = ImzMapper.getInstance();
        System.out.println(this.getGroupID());
        List<Vaccine> vaccines = imz.mapToDosage(this.getGroupID());
        System.out.println(vaccines);
        for(Vaccine v : vaccines) {
            if(MMR == v.getVaccineName()) {
                this.maxMmrDoses =  v.getDosage();
            }
        }
    }
    
    public void setMaxHepaDoses(){
        ImzMapper imz = ImzMapper.getInstance();
        System.out.println(this.getGroupID());
        List<Vaccine> vaccines = imz.mapToDosage(this.getGroupID());
        System.out.println(vaccines);
        for(Vaccine v : vaccines) {
            if(HEPATITIS == v.getVaccineName()) {
                this.maxHepaDoses =  v.getDosage();
            }
        }
    }
    
    public void setMaxDtapDoses(){
        ImzMapper imz = ImzMapper.getInstance();
        System.out.println(this.getGroupID());
        List<Vaccine> vaccines = imz.mapToDosage(this.getGroupID());
        System.out.println(vaccines);
        for(Vaccine v : vaccines) {
            if(DTAP == v.getVaccineName()) {
                this.maxDtapDoses =  v.getDosage();
            }
        }
    }
    
    public void setMaxHibDoses(){
        ImzMapper imz = ImzMapper.getInstance();
        System.out.println(this.getGroupID());
        List<Vaccine> vaccines = imz.mapToDosage(this.getGroupID());
        System.out.println(vaccines);
        for(Vaccine v : vaccines) {
            if(HIB == v.getVaccineName()) {
                this.maxHibDoses =  v.getDosage();
            }
        }
    }

    public boolean isHibStatus() {
        return hibStatus;
    }

    public void setHibStatus(boolean hibStatus) {
        this.hibStatus = hibStatus;
    }

    public Date getHibDate() {
        return hibDate;
    }

    public void setHibDate(Date hibDate) {
        this.hibDate = hibDate;
    }

    public int getMaxHibDoses() {
        return maxHibDoses;
    }

    public void setMaxHibDoses(int maxHibDoses) {
        this.maxHibDoses = maxHibDoses;
    }

    public int getHibDosesDone() {
        return hibDosesDone;
    }

    public void setHibDosesDone(int hibDosesDone) {
        this.hibDosesDone = hibDosesDone;
    }

    public int getRemainingHibDoses() {
        return remainingHibDoses;
    }

    public void setRemainingHibDoses(int remainingHibDoses) {
        this.remainingHibDoses = remainingHibDoses;
    }

    public boolean getDtapStatus() {
        return dtapStatus;
    }

    public void setDtapStatus(boolean dtapStatus) {
        this.dtapStatus = dtapStatus;
    }

    public Date getDtapDate() {
        return dtapDate;
    }

    public void setDtapDate(Date dtapDate) {
        this.dtapDate = dtapDate;
    }

    public int getMaxDtapDoses() {
        return maxDtapDoses;
    }

    public void setMaxDtapDoses(int maxDtapDoses) {
        this.maxDtapDoses = maxDtapDoses;
    }

    public int getDtapDosesDone() {
        return dtapDosesDone;
    }

    public void setDtapDosesDone(int dtapDosesDone) {
        this.dtapDosesDone = dtapDosesDone;
    }

    public int getRemainingDtapDoses() {
        return remainingDtapDoses;
    }

    public void setRemainingDtapDoses(int remainingDtapDoses) {
        this.remainingDtapDoses = remainingDtapDoses;
    }

    public boolean isHepaStatus() {
        return hepaStatus;
    }

    public void setHepaStatus(boolean hepaStatus) {
        this.hepaStatus = hepaStatus;
    }

    public Date getHepaDate() {
        return hepaDate;
    }

    public void setHepaDate(Date hepaDate) {
        this.hepaDate = hepaDate;
    }

    public int getMaxHepaDoses() {
        return maxHepaDoses;
    }

    public void setMaxHepaDoses(int maxHepaDoses) {
        this.maxHepaDoses = maxHepaDoses;
    }

    public int getHepaDosesDone() {
        return hepaDosesDone;
    }

    public void setHepaDosesDone(int hepaDosesDone) {
        this.hepaDosesDone = hepaDosesDone;
    }

    public int getRemainingHepaDoses() {
        return remainingHepaDoses;
    }

    public void setRemainingHepaDoses(int remainingHepaDoses) {
        this.remainingHepaDoses = remainingHepaDoses;
    }

    public boolean isMmrStatus() {
        return mmrStatus;
    }

    public void setMmrStatus(boolean mmrStatus) {
        this.mmrStatus = mmrStatus;
    }

    public Date getMmrDate() {
        return mmrDate;
    }

    public void setMmrDate(Date mmrDate) {
        this.mmrDate = mmrDate;
    }

    public int getMaxMmrDoses() {
        return maxMmrDoses;
    }

    public void setMaxMmrDoses(int maxMmrDoses) {
        this.maxMmrDoses = maxMmrDoses;
    }

    public int getMmrDosesDone() {
        return mmrDosesDone;
    }

    public void setMmrDosesDone(int mmrDosesDone) {
        this.mmrDosesDone = mmrDosesDone;
    }

    public int getRemainingMmrDoses() {
        return remainingMmrDoses;
    }

    public void setRemainingMmrDoses(int remainingMmrDoses) {
        this.remainingMmrDoses = remainingMmrDoses;
    }

    public boolean isVarStatus() {
        return varStatus;
    }

    public void setVarStatus(boolean varStatus) {
        this.varStatus = varStatus;
    }

    public Date getVarDate() {
        return varDate;
    }

    public void setVarDate(Date varDate) {
        this.varDate = varDate;
    }

    public int getMaxVarDoses() {
        return maxVarDoses;
    }

    public void setMaxVarDoses(int maxVarDoses) {
        this.maxVarDoses = maxVarDoses;
    }

    public int getVarDosesDone() {
        return varDosesDone;
    }

    public void setVarDosesDone(int varDosesDone) {
        this.varDosesDone = varDosesDone;
    }

    public int getRemainingVarDoses() {
        return remainingVarDoses;
    }

    public void setRemainingVarDoses(int remainingVarDoses) {
        this.remainingVarDoses = remainingVarDoses;
    }
    
    
    
    public int getPolioDosesDone() {
        return polioDosesDone;
    }

    public void setPolioDosesDone(int polioDosesDone) {
        this.polioDosesDone = polioDosesDone;
    }
    
    public void setMaxPolioDoses(){
        ImzMapper imz = ImzMapper.getInstance();
        System.out.println(this.getGroupID());
        List<Vaccine> vaccines = imz.mapToDosage(this.getGroupID());
        for(Vaccine v : vaccines) {
            if(POLIO == v.getVaccineName()) {
                System.out.println("Polio max dosage " + v.getDosage());
                this.maxPolioDoses =  v.getDosage();
            }
        }
    }
    
    public void setMaxPolioDoses(int maxPolioDoses) {
        this.maxPolioDoses = maxPolioDoses;
    }

    public int getRemainingPolioDoses() {
        return remainingPolioDoses;
    }

    public void setRemainingPolioDoses(int remainingPolioDoses) {
        this.remainingPolioDoses = remainingPolioDoses;
    }
    
    public int getMaxPolioDoses(){
        return this.maxPolioDoses;
    }
    
    public StudentGroup getGroupID() {
        return groupID;
    }

    public void setGroupID(StudentGroup groupID) {
        this.groupID = groupID;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        StudentID = studentID;
    }

    public boolean getPolioStatus() {
        return polioStatus;
    }

    public void setPolioStatus(boolean polioStatus) {
        this.polioStatus = polioStatus;
    }

    public boolean getTbStatus() {
        return hibStatus;
    }

    public void setTbStatus(boolean tbStatus) {
        this.hibStatus = tbStatus;
    }

    public Date getPolioDate() {
        return polioDate;
    }

    public void setPolioDate(Date polioDate) {
        this.polioDate = polioDate;
    }

    public Date getTbDate() {
        return hibDate;
    }

    public void setTbDate(Date tbDate) {
        this.hibDate = tbDate;
    }
    
    

    @Override
    public String toString(){
        return this.getStudentID()+","
                +this.getGroupID()+","
                +this.getPolioStatus()+","
                +this.getPolioDate()+","
                +this.getMaxPolioDoses() +","
                +this.getPolioDosesDone()+","
                +this.getRemainingPolioDoses()+","
                +this.getDtapStatus()+","
                +this.getDtapDate()+","
                +this.getMaxDtapDoses()+","
                +this.getDtapDosesDone()+","
                +this.getRemainingDtapDoses()+","
                +this.isHepaStatus() + "," 
                +this.getHepaDate()+","
                +this.getMaxHepaDoses()+","
                +this.getHepaDosesDone()+","
                +this.getRemainingHepaDoses()+","
                +this.isHibStatus()+","
                +this.getHibDate()+","
                +this.getMaxHibDoses()+","
                +this.getHepaDosesDone()+","
                +this.getRemainingHibDoses()+","
                +this.isMmrStatus()+","
                +this.getMmrDate()+","
                +this.getMaxMmrDoses()+","
                +this.getMmrDosesDone()+","
                +this.getRemainingMmrDoses()+","
                +this.isVarStatus()+","
                +this.getVarDate()+","
                +this.getMaxVarDoses()+","
                +this.getVarDosesDone()+","
                +this.getRemainingVarDoses();
                        
                
    }
}
