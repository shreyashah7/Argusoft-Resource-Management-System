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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author shreya
 */
@Entity
@Table(name = "proj_roles")
public class ProjectRoles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proj_role_id", nullable = false)
    private Long projectRoleId;

    @Column(name = "proj_role_name")
    private String projectRoleName;

    @Column(name = "proj_role_desc")
    private String projectRoleDescription;

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

    public ProjectRoles() {
    }

    public ProjectRoles(Long projectRoleId, String projectRoleName, String projectRoleDescription, Date createdOn, Long createdBy, Date lastModifiedOn, Long lastModifiedBy, Boolean isActive, Boolean isArchive) {
        this.projectRoleId = projectRoleId;
        this.projectRoleName = projectRoleName;
        this.projectRoleDescription = projectRoleDescription;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastModifiedOn = lastModifiedOn;
        this.lastModifiedBy = lastModifiedBy;
        this.isActive = isActive;
        this.isArchive = isArchive;
    }

    public Long getProjectRoleId() {
        return projectRoleId;
    }

    public void setProjectRoleId(Long projectRoleId) {
        this.projectRoleId = projectRoleId;
    }

    public String getProjectRoleName() {
        return projectRoleName;
    }

    public void setProjectRoleName(String projectRoleName) {
        this.projectRoleName = projectRoleName;
    }

    public String getProjectRoleDescription() {
        return projectRoleDescription;
    }

    public void setProjectRoleDescription(String projectRoleDescription) {
        this.projectRoleDescription = projectRoleDescription;
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
    
    
}
