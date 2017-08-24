/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.databean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * for storing Details of a particular Day (for Calendar)
 * @author ravi
 */
public class DayDataBean implements Serializable {

    private Date date;
    private String task;
//    private String show = "FALSE";
    private Boolean show = Boolean.FALSE;
    private List<TaskDataBean> taskDataBeans;

    public List<TaskDataBean> getTaskDataBeans() {
        return taskDataBeans;
    }

    public void setTaskDataBeans(List<TaskDataBean> taskDataBeans) {
        this.taskDataBeans = taskDataBeans;
    }

//    public String getShow() {
//        return show;
//    }
//
//    public void setShow(String show) {
//        this.show = show;
//    }
    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

}
