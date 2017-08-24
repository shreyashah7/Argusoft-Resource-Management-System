/*
 * To change this license header, choose License Headers in ProjectMaster Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.databean;

import java.util.Date;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.Pattern;

/**
 *
 * @author rajkumar
 */
@ManagedBean(name = "projectMilestoneDataBean")
@RequestScoped
public class ProjectMilestoneDataBean {

    private Long projectMilestoneId;
    private Long projectId;
    private String milestoneName = "";
    private String milestoneDesc = "";
    private Date milestoneStartDate;
    private Date milestoneEndDate;
    private boolean isEditable = false;
    private boolean isActive;
    private Date actualEndDate;
    private Date createdOn;
    private Long createdBy;
    private String createdByName;
    private Long lastModifiedBy;
    private String lastModifiedByName;
    private String status;
    private String projectAlias;

    public String getProjectAlias() {
        return projectAlias;
    }

    public void setProjectAlias(String projectAlias) {
        this.projectAlias = projectAlias;
    }        
    
    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
    
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public String getLastModifiedByName() {
        return lastModifiedByName;
    }

    public void setLastModifiedByName(String lastModifiedByName) {
        this.lastModifiedByName = lastModifiedByName;
    }

    public Long getProjectMilestoneId() {
        return projectMilestoneId;
    }

    public void setProjectMilestoneId(Long projectMilestoneId) {
        this.projectMilestoneId = projectMilestoneId;
    }

    public Date getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(Date actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isIsEditable() {
        return isEditable;
    }

    public void setIsEditable(boolean isEditable) {
        this.isEditable = isEditable;
    }

    public Date getMilestoneStartDate() {
        return milestoneStartDate;
    }

    public void setMilestoneStartDate(Date milestoneStartDate) {
        this.milestoneStartDate = milestoneStartDate;
    }

    public Date getMilestoneEndDate() {
        return milestoneEndDate;
    }

    public void setMilestoneEndDate(Date milestoneEndDate) {
        this.milestoneEndDate = milestoneEndDate;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getMilestoneName() {
        return milestoneName;
    }

    public void setMilestoneName(String milestoneName) {
        this.milestoneName = milestoneName;
    }

    public String getMilestoneDesc() {
        return milestoneDesc;
    }

    public void setMilestoneDesc(String milestoneDesc) {
        this.milestoneDesc = milestoneDesc;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.projectId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProjectMilestoneDataBean other = (ProjectMilestoneDataBean) obj;
        if (!Objects.equals(this.projectId, other.projectId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProjectMilestoneDataBean{" + "projectMilestoneId=" + projectMilestoneId + ", projectId=" + projectId + ", milestoneName=" + milestoneName + ", milestoneDesc=" + milestoneDesc + ", milestoneStartDate=" + milestoneStartDate + ", milestoneEndDate=" + milestoneEndDate + ", isEditable=" + isEditable + ", isActive=" + isActive + ", actualEndDate=" + actualEndDate + ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", lastModifiedBy=" + lastModifiedBy + ", status=" + status + '}';
    }
    
}
