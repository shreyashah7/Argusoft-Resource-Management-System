/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.databean;

import java.io.Serializable;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * For storing details of a day
 * @author ravi
 */
@ManagedBean(name = "calDataBean")
@ViewScoped
public class CalDataBean implements Serializable {

    Calendar calendar=Calendar.getInstance();            
    int month=calendar.get(Calendar.MONTH);
    int year=calendar.get(Calendar.YEAR);
    int day;
    int noOfWeeks;

    public int getNoOfWeeks() {
        return noOfWeeks;
    }

    public void setNoOfWeeks(int noOfWeeks) {
        this.noOfWeeks = noOfWeeks;
    }

    
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        calendar.set(Calendar.MONTH, month);
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        calendar.set(Calendar.YEAR, year);
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

}
