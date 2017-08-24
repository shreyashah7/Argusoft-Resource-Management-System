/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shreya
 */
@Entity
@Table(name = "tsk_tech_dtl")
@XmlRootElement
public class TaskTechnologyDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TaskTechnologyDetailPK taskTechnologyDetailPK;
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "created_by")
    private Long createdBy;
    @Column(name = "lst_modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lstModifiedOn;
    @Column(name = "lst_modified_by")
    private Long lastModifiedBy;
    @Column(name = "is_active")
    private Boolean isActive;

    public TaskTechnologyDetail() {
    }

    public TaskTechnologyDetail(TaskTechnologyDetailPK taskTechnologyDetailPK) {
        this.taskTechnologyDetailPK = taskTechnologyDetailPK;
    }

    public TaskTechnologyDetailPK getTskTechDtlPK() {
        return taskTechnologyDetailPK;
    }

    public void setTskTechDtlPK(TaskTechnologyDetailPK taskTechnologyDetailPK) {
        this.taskTechnologyDetailPK = taskTechnologyDetailPK;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    
    public Date getLstModifiedOn() {
        return lstModifiedOn;
    }

    public void setLstModifiedOn(Date lstModifiedOn) {
        this.lstModifiedOn = lstModifiedOn;
    }

    public TaskTechnologyDetailPK getTaskTechnologyDetailPK() {
        return taskTechnologyDetailPK;
    }

    public void setTaskTechnologyDetailPK(TaskTechnologyDetailPK taskTechnologyDetailPK) {
        this.taskTechnologyDetailPK = taskTechnologyDetailPK;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskTechnologyDetailPK != null ? taskTechnologyDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaskTechnologyDetail)) {
            return false;
        }
        TaskTechnologyDetail other = (TaskTechnologyDetail) object;
        if ((this.taskTechnologyDetailPK == null && other.taskTechnologyDetailPK != null) || (this.taskTechnologyDetailPK != null && !this.taskTechnologyDetailPK.equals(other.taskTechnologyDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.argusoft.armms.model.TskTechDtl[ tskTechDtlPK=" + taskTechnologyDetailPK + " ]";
    }

}
