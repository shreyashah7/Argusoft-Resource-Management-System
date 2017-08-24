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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author shifa
 */
@Entity
@Table(name = "user_skill_exp")

public class UserSkillExperience implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "user_skill_exp_id")
    private Long userSkillExperienceId;
    @Basic(optional = false)
    @Column(name = "user_id")
    private Long userId;
    @JoinColumn(name = "user_skill_set_id", referencedColumnName = "user_skill_set_id")
    @ManyToOne(optional = false)
    private UserSkillSet userSkillSetId;

    @JoinColumn(name = "proj_id", referencedColumnName = "proj_id")
    @ManyToOne(optional = false)
    private Project projectId;
    @Basic(optional = false)
    @Column(name = "proj_nm")
    private String projectName;
    @Basic(optional = false)
    @Column(name = "org_nm")
    private String organizationName;
    @Basic(optional = false)
    @Column(name = "start_dt")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_dt")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ttl_duration")
    private Double totalDuration;
    @Basic(optional = false)
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Basic(optional = false)
    @Column(name = "created_by")
    private Long createdBy;
    @Basic(optional = false)
    @Column(name = "lst_modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedOn;
    @Basic(optional = false)
    @Column(name = "lst_modified_by")
    private Long lastModifiedBy;
    @Basic(optional = false)
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "is_archive")
    private Boolean isArchive;

    public UserSkillExperience() {
    }

    public UserSkillExperience(Long userSkillExpId) {
        this.userSkillExperienceId = userSkillExpId;
    }

    public Long getUserSkillExperienceId() {
        return userSkillExperienceId;
    }

    public void setUserSkillExperienceId(Long userSkillExperienceId) {
        this.userSkillExperienceId = userSkillExperienceId;
    }

    public UserSkillSet getUserSkillSetId() {
        return userSkillSetId;
    }

    public void setUserSkillSetId(UserSkillSet userSkillSetId) {
        this.userSkillSetId = userSkillSetId;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
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

    public Double getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(Double totalDuration) {
        this.totalDuration = totalDuration;
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

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
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
        int hash = 0;
        hash += (userSkillExperienceId != null ? userSkillExperienceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserSkillExperience)) {
            return false;
        }
        UserSkillExperience other = (UserSkillExperience) object;
        if ((this.userSkillExperienceId == null && other.userSkillExperienceId != null) || (this.userSkillExperienceId != null && !this.userSkillExperienceId.equals(other.userSkillExperienceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.argusoft.armms.model.UserSkillExp[ userSkillExpId=" + userSkillExperienceId + " ]";
    }

}
