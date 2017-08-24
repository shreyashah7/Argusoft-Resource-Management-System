/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rajkumar
 * @since 04-MAR-2014
 */
@Entity
@Table(name = "proj_rsrc_dtl")
public class ProjectResourceDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proj_rsrc_dtl_id")
    private Long projectResourceDetailId;

    @Basic(optional = false)
    @JoinColumn(name = "proj_id", referencedColumnName = "proj_id")
    @ManyToOne(optional = false)
    private Project projectId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "project_role_id")
    private Long projectRoleId;

    @Column(name = "strt_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "end_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "lst_modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedOn;

    @Column(name = "lst_modified_by")
    private Long lastModifiedBy;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_archive")
    private Boolean isArchive;

    public ProjectResourceDetail() {
    }

    public Long getProjectRoleId() {
        return projectRoleId;
    }

    public void setProjectRoleId(Long projectRoleId) {
        this.projectRoleId = projectRoleId;
    }

    public ProjectResourceDetail(Long projectResourceDetailId) {
        this.projectResourceDetailId = projectResourceDetailId;
    }

    public Long getProjectResourceDetailId() {
        return projectResourceDetailId;
    }

    public void setProjectResourceDetailId(Long projectResourceDetailId) {
        this.projectResourceDetailId = projectResourceDetailId;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
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

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Boolean isIsArchive() {
        return isArchive;
    }

    public void setIsArchive(Boolean isArchive) {
        this.isArchive = isArchive;
    }

    @Override
    public String toString() {
        return "ProjectResourceDetail{" + "projectResourceDetailId=" + projectResourceDetailId + ", projectId=" + projectId + ", userId=" + userId + ", startDate=" + startDate + ", endDate=" + endDate + ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", lastModifiedOn=" + lastModifiedOn + ", lastModifiedBy=" + lastModifiedBy + ", isActive=" + isActive + ", isArchive=" + isArchive + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.projectResourceDetailId != null ? this.projectResourceDetailId.hashCode() : 0);
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
        final ProjectResourceDetail other = (ProjectResourceDetail) obj;
        if (this.projectResourceDetailId != other.projectResourceDetailId && (this.projectResourceDetailId == null || !this.projectResourceDetailId.equals(other.projectResourceDetailId))) {
            return false;
        }
        return true;
    }

}
