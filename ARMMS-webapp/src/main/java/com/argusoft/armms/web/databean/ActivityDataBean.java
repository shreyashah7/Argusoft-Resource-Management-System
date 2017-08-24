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
 * for collecting various list from the all the table of db for displaying latest updates block.
 * @author shreya
 */
@ManagedBean(name = "activityDataBean")
@RequestScoped
public class ActivityDataBean {

    private String activityId;
    private String activityName;
    private Date startDate;
    private Date endDate;
    private String activityDesc;
    private Date createdOn;
    private Long createdBy;
    private String createdByName;
    private Long lastModifiedBy;
    private String lastModifiedByName;
    private Date lastModifiedOn;
    private Long assignedTo;
    private String assignedToName;
    private String activityType;
    private Long projectId;
    private String projectName;
    private Date createdOrModifiedOn;
    private String createdOrModifiedByName;
    private Long createdOrModifiedBy;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getCreatedOrModifiedByName() {
        return createdOrModifiedByName;
    }

    public void setCreatedOrModifiedByName(String createdOrModifiedByName) {
        this.createdOrModifiedByName = createdOrModifiedByName;
    }

    public Long getCreatedOrModifiedBy() {
        return createdOrModifiedBy;
    }

    public void setCreatedOrModifiedBy(Long createdOrModifiedBy) {
        this.createdOrModifiedBy = createdOrModifiedBy;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getCreatedOrModifiedOn() {
        return createdOrModifiedOn;
    }

    public void setCreatedOrModifiedOn(Date createdOrModifiedOn) {
        this.createdOrModifiedOn = createdOrModifiedOn;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Long assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getAssignedToName() {
        return assignedToName;
    }

    public void setAssignedToName(String assignedToName) {
        this.assignedToName = assignedToName;
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastModifiedByName() {
        return lastModifiedByName;
    }

    public void setLastModifiedByName(String lastModifiedByName) {
        this.lastModifiedByName = lastModifiedByName;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    @Override
    public String toString() {
        return "ActivityDataBean{" + "activityId=" + activityId + ", activityName=" + activityName + ", activityDesc=" + activityDesc + ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", createdByName=" + createdByName + ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedByName=" + lastModifiedByName + ", lastModifiedOn=" + lastModifiedOn + ", assignedTo=" + assignedTo + ", assignedToName=" + assignedToName + ", activityType=" + activityType + ", projectId=" + projectId + ", createdOrModifiedOn=" + createdOrModifiedOn + '}';
    }

}
