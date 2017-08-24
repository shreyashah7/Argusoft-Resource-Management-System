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
@Table(name = "tech_mst")

public class TechnologyMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tech_id")
    private Long technologyId;
    @Basic(optional = false)
    @Column(name = "tech_nm")
    private String technologyName;

    @Column(name = "tech_desc")
    private String technologyDesc;
    @Basic(optional = false)
    @Column(name = "tech_type", length = 5)
    private String techType;
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

    public TechnologyMaster() {
    }

    public TechnologyMaster(Long techId) {
        this.technologyId = techId;
    }

    public TechnologyMaster(Long techId, String techDesc) {
        this.technologyId = techId;
        this.technologyDesc = techDesc;
    }

    public Long getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(Long technologyId) {
        this.technologyId = technologyId;
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    public String getTechnologyDesc() {
        return technologyDesc;
    }

    public void setTechnologyDesc(String technologyDesc) {
        this.technologyDesc = technologyDesc;
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

    public String getTechType() {
        return techType;
    }

    public void setTechType(String techType) {
        this.techType = techType;
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
        hash += (technologyId != null ? technologyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TechnologyMaster)) {
            return false;
        }
        TechnologyMaster other = (TechnologyMaster) object;
        if ((this.technologyId == null && other.technologyId != null) || (this.technologyId != null && !this.technologyId.equals(other.technologyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return "com.argusoft.armms.model.TechMst[ techId=" + technologyId + " ]";
    }

}
