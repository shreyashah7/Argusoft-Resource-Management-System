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
 * @author shifa
 */
@Entity
@Table(name = "user_skill_set")

public class UserSkillSet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_skill_set_id")
    private Long userSkillSetId;
    @Column(name = "user_id")
    @Basic(optional = false)
    private Long userId;
    @JoinColumn(name = "tech_id", referencedColumnName = "tech_id")
    @ManyToOne(optional = false)
    private TechnologyMaster technologyId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "experience")
    private Double experience;
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "created_by")
    @Basic(optional = false)
    private Long createdBy;
    @Column(name = "lst_modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedOn;
    @Column(name = "lst_modified_by")
    @Basic(optional = false)
    private Long lastModifiedBy;
    @Column(name = "is_active")
    private Boolean isActive;

    public UserSkillSet() {
    }

    public UserSkillSet(Long userSkillSetId) {
        this.userSkillSetId = userSkillSetId;
    }

    public Long getUserSkillSetId() {
        return userSkillSetId;
    }

    public void setUserSkillSetId(Long userSkillSetId) {
        this.userSkillSetId = userSkillSetId;
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

    public TechnologyMaster getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(TechnologyMaster technologyId) {
        this.technologyId = technologyId;
    }

    public Double getExperience() {
        return experience;
    }

    public void setExperience(Double experience) {
        this.experience = experience;
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

    public Boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userSkillSetId != null ? userSkillSetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserSkillSet)) {
            return false;
        }
        UserSkillSet other = (UserSkillSet) object;
        if ((this.userSkillSetId == null && other.userSkillSetId != null) || (this.userSkillSetId != null && !this.userSkillSetId.equals(other.userSkillSetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.argusoft.armms.model.UserSkillSet[ userSkillSetId=" + userSkillSetId + " ]";
    }

}
