/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.daycare.student;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author anjali
 */
public class RenewalReminder {
    
    private long daysLeftForRegistrationRenewal;

    public long getDaysLeftForRegistrationRenewal() {
        return daysLeftForRegistrationRenewal;
    }

    public void setDaysLeftForRegistrationRenewal(long daysLeftForRegistrationRenewal) {
        this.daysLeftForRegistrationRenewal = daysLeftForRegistrationRenewal;
    }
    
     public RenewalReminder getReminder(Student s){
        RenewalReminder r = new RenewalReminder();
        r.setDaysLeftForRegistrationRenewal(getDiff(s.getRegistrationDate()));
        
        return r;
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
    
}
