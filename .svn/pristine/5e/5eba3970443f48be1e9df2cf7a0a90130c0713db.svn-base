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
@Table(name = "proj_tech_dtl")
@XmlRootElement
public class ProjectTechnologyDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proj_tech_id")
    private Long projectTechnologyId;

    @Basic(optional = false)
    @JoinColumn(name = "proj_id", referencedColumnName = "proj_id")
    @ManyToOne(optional = false)
    private Project projectId;

    @Basic(optional = false)
    @JoinColumn(name = "tech_id", referencedColumnName = "tech_id")
    @ManyToOne(optional = false)
    private TechnologyMaster technologyId;

    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Column(name = "lst_modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedOn;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "lst_modified_by")
    private Long lastModifiedBy;

    public ProjectTechnologyDetail() {
    }

    public ProjectTechnologyDetail(Long projTechId) {
        this.projectTechnologyId = projTechId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Long getProjectTechnologyId() {
        return projectTechnologyId;
    }

    public void setProjectTechnologyId(Long projectTechnologyId) {
        this.projectTechnologyId = projectTechnologyId;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public TechnologyMaster getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(TechnologyMaster technologyId) {
        this.technologyId = technologyId;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectTechnologyId != null ? projectTechnologyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectTechnologyDetail)) {
            return false;
        }
        ProjectTechnologyDetail other = (ProjectTechnologyDetail) object;
        if ((this.projectTechnologyId == null && other.projectTechnologyId != null) || (this.projectTechnologyId != null && !this.projectTechnologyId.equals(other.projectTechnologyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProjectTechnologyDetail{" + "projectTechnologyId=" + projectTechnologyId + ", projectId=" + projectId + ", technologyId=" + technologyId + ", createdOn=" + createdOn + ", lastModifiedOn=" + lastModifiedOn + ", isActive=" + isActive + ", createdBy=" + createdBy + ", lastModifiedBy=" + lastModifiedBy + '}';
    }

}
