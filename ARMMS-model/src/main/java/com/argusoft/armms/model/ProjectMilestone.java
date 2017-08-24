/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.argusoft.armms.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rajkumar
 * @since 04-MAR-2014
 */
@Entity
@Table(name = "proj_mlstn")
@XmlRootElement

public class ProjectMilestone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proj_mlstn_id")
    private Long projectMilestoneId;
    
    @Basic(optional = false)
    @JoinColumn(name = "proj_id",referencedColumnName = "proj_id")
    @ManyToOne()
    private Project projectId;
    
    @Basic(optional = false)
    @Column(name = "mlstn_nm")
    private String milestoneName;
    
    @Column(name = "mlstn_desc")
    private String milestoneDescription;
    
    @Basic(optional = false)
    @Column(name = "strt_dt")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    
    @Column(name = "end_dt")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    
    @Column(name = "actual_end_dt")
    @Temporal(TemporalType.DATE)
    private Date actualEndDate;
    
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
  
    @Column(name = "is_active")
    private Boolean isActive;
    
    @Column(name = "is_archive")
    private Boolean isArchive;
    
    @Column(name = "lst_modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedOn;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "lst_modified_by")
    private Long lastModifiedBy;
    
    public ProjectMilestone() {
    }

    public ProjectMilestone(Long projMlstnId) {
        this.projectMilestoneId = projMlstnId;
    }

    public Long getProjectMilestoneId() {
        return projectMilestoneId;
    }

    public void setProjectMilestoneId(Long projectMilestoneId) {
        this.projectMilestoneId = projectMilestoneId;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public String getMilestoneName() {
        return milestoneName;
    }

    public void setMilestoneName(String milestoneName) {
        this.milestoneName = milestoneName;
    }

    public String getMilestoneDescription() {
        return milestoneDescription;
    }

    public void setMilestoneDescription(String milestoneDescription) {
        this.milestoneDescription = milestoneDescription;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(Date actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

  

    

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
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

    public Boolean getIsArchive() {
        return isArchive;
    }

    public void setIsArchive(Boolean isArchive) {
        this.isArchive = isArchive;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectMilestoneId != null ? projectMilestoneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectMilestone)) {
            return false;
        }
        ProjectMilestone other = (ProjectMilestone) object;
        if ((this.projectMilestoneId == null && other.projectMilestoneId != null) || (this.projectMilestoneId != null && !this.projectMilestoneId.equals(other.projectMilestoneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.argusoft.armms.model.ProjectMilestone[ projMlstnId=" + projectMilestoneId + " ]";
    }
    
}
