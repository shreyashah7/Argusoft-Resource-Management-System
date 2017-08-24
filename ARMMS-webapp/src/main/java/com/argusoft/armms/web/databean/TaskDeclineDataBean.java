/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.argusoft.armms.web.databean;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author shifa
 */
@ManagedBean(name = "taskDeclineDataBean")
@RequestScoped
public class TaskDeclineDataBean {

    /**
     * Creates a new instance of taskDeclineDataBean
     */
private Date createdOn;
private Date declinedDate;
private String declineReason;
private Boolean isActive;
private long userid;
private long taskid;

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getDeclinedDate() {
        return declinedDate;
    }

    public void setDeclinedDate(Date declinedDate) {
        this.declinedDate = declinedDate;
    }

    public String getDeclineReason() {
        return declineReason;
    }

    public void setDeclineReason(String declineReason) {
        this.declineReason = declineReason;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getTaskid() {
        return taskid;
    }

    public void setTaskid(long taskid) {
        this.taskid = taskid;
    }

    @Override
    public String toString() {
        return "TaskDeclineDataBean{" + "createdOn=" + createdOn + ", declinedDate=" + declinedDate + ", declineReason=" + declineReason + ", isActive=" + isActive + ", userid=" + userid + ", taskid=" + taskid + '}';
    }

}
