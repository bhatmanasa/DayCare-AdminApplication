/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.daycare.immunization;

import edu.neu.csye6200.daycare.student.Student;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author anjali
 */
public class ImzReminder {
    
    private long daysLeftForPolio;
    private long daysLeftForHib;
    private long daysLeftForMMR;
    private long daysLeftForHepa;
    private long daysLeftForDtap;
    private long daysLEftForVaricella;
    
    public ImzReminder getReminder(Immunization imz){
        ImzReminder ir = new ImzReminder();
        System.out.println("Polio date is  " + imz.getPolioDate());
        ir.setDaysLeftForPolio(getDiff(imz.getPolioDate()));
        ir.setDaysLeftForDtap(getDiff(imz.getDtapDate()));
        ir.setDaysLeftForHib(getDiff(imz.getHibDate()));
        ir.setDaysLeftForHepa(getDiff(imz.getHepaDate()));
        ir.setDaysLeftForMMR(getDiff(imz.getMmrDate()));
        ir.setDaysLEftForVaricella(getDiff(imz.getVarDate()));
        
        return ir;
    }
    
    private long getDiff(Date date){
        if(date==null){
            return 0;
        }
        //current date :
        LocalDate currDate = java.time.LocalDate.now();
        //convert LocaLocalDatelDate to Date:
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date currentDate = Date.from(currDate.atStartOfDay(defaultZoneId).toInstant());
        
        long diffInMillies = Math.abs(currentDate.getTime() - date.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        System.out.println("Difference is " + (365- diff));
        return 365-diff;
    }


    public long getDaysLeftForPolio() {
        return daysLeftForPolio;
    }

    public void setDaysLeftForPolio(long daysLeftForPolio) {
        this.daysLeftForPolio = daysLeftForPolio;
    }

    public long getDaysLeftForHib() {
        return daysLeftForHib;
    }

    public void setDaysLeftForHib(long daysLeftForHib) {
        this.daysLeftForHib = daysLeftForHib;
    }

    public long getDaysLeftForMMR() {
        return daysLeftForMMR;
    }

    public void setDaysLeftForMMR(long daysLeftForMMR) {
        this.daysLeftForMMR = daysLeftForMMR;
    }

    public long getDaysLeftForHepa() {
        return daysLeftForHepa;
    }

    public void setDaysLeftForHepa(long daysLeftForHepa) {
        this.daysLeftForHepa = daysLeftForHepa;
    }

    public long getDaysLeftForDtap() {
        return daysLeftForDtap;
    }

    public void setDaysLeftForDtap(long daysLeftForDtap) {
        this.daysLeftForDtap = daysLeftForDtap;
    }

    public long getDaysLEftForVaricella() {
        return daysLEftForVaricella;
    }

    public void setDaysLEftForVaricella(long daysLEftForVaricella) {
        this.daysLEftForVaricella = daysLEftForVaricella;
    }
    
}
