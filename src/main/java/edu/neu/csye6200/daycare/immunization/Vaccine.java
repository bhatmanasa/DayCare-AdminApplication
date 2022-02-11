/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.daycare.immunization;

/**
 *
 * @author anjali
 */
public class Vaccine {

    public Vaccine(VaccineName vaccineName, int dosage) {
        this.vaccineName = vaccineName;
        this.dosage = dosage;
    }
    
    private VaccineName vaccineName;
    private int dosage;
    
    public enum VaccineName {
        HIB,
        DTAP,
        POLIO,
        HEPATITIS,
        MMR,
        VARICELLA
    }

    public VaccineName getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(VaccineName vaccineName) {
        this.vaccineName = vaccineName;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }
    
}
