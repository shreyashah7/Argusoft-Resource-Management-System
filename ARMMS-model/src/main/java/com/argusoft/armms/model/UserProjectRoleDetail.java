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

/**
 *
 * @author brijesh
 */
@Entity
@Table(name = "usr_prjct_role_dtl")
public class UserProjectRoleDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usr_prjct_role_id")
    private Long userProjectRoleId;
    @Column(name = "assigned_to")
    private Long assignedTo;
    @JoinColumn(name = "proj_id", referencedColumnName = "proj_id")
    @ManyToOne(optional = false)
    private Project projectId;
    @Column(name = "project_role_id")
    private Long projectRoleId;
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

    public Long getUserProjectRoleId() {
        return userProjectRoleId;
    }

    public void setUserProjectRoleId(Long userProjectRoleId) {
        this.userProjectRoleId = userProjectRoleId;
    }

    public Long getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Long assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public Long getProjectRoleId() {
        return projectRoleId;
    }

    public void setProjectRoleId(Long projectRoleId) {
        this.projectRoleId = projectRoleId;
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

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Boolean isIsActive() {
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
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.userProjectRoleId != null ? this.userProjectRoleId.hashCode() : 0);
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
        final UserProjectRoleDetail other = (UserProjectRoleDetail) obj;
        if (this.userProjectRoleId != other.userProjectRoleId && (this.userProjectRoleId == null || !this.userProjectRoleId.equals(other.userProjectRoleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserProjectRoleDetail{" + "userProjectRoleId=" + userProjectRoleId + ", assignedTo=" + assignedTo + ", projectId=" + projectId + ", projectRoleId=" + projectRoleId + ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", lastModifiedOn=" + lastModifiedOn + ", lastModifiedBy=" + lastModifiedBy + ", isActive=" + isActive + ", isArchive=" + isArchive + '}';
    }

   

}
