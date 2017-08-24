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
@Table(name = "system_notification_master")
public class SystemNotificationMaster implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long notificationId;
    
    @Column(name = "assigned_to", nullable = false)
    private Long assignedTo;
    
    @Column(name = "feature_id", nullable = false)
    private String featureId;
    
    @Column(name = "feature_type", nullable = false, length = 10)
    private String featureType;
    
    @Basic(optional = false)
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    
    @Basic(optional = false)
    @Column(name = "is_active")
    private boolean isActive;
    
    @Basic(optional = false)
    @Column(name = "is_archive")
    private boolean isArchive;
    
    @Column(name = "ntfction_on_date")
    @Temporal(TemporalType.DATE)
    private Date notificationOnDate;
    
    @Column(name = "expiry_date")
    @Temporal(TemporalType.DATE)
    private Date expiryDate;
    
    @Column(name = "lst_modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedOn;
    
    @Column(name = "notification_subject")
    private String notificationSubject;
    
    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

    public Long getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Long assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getFeatureType() {
        return featureType;
    }

    public void setFeatureType(String featureType) {
        this.featureType = featureType;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean getIsArchive() {
        return isArchive;
    }

    public void setIsArchive(boolean isArchive) {
        this.isArchive = isArchive;
    }

    public Date getNotificationOnDate() {
        return notificationOnDate;
    }

    public void setNotificationOnDate(Date notificationOnDate) {
        this.notificationOnDate = notificationOnDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public String getNotificationSubject() {
        return notificationSubject;
    }

    public void setNotificationSubject(String notificationSubject) {
        this.notificationSubject = notificationSubject;
    }

    @Override
    public String toString() {
        return "SystemNotificationMaster{" + "notificationId=" + notificationId + ", assignedTo=" + assignedTo + ", featureId=" + featureId + ", featureName=" + featureType + ", createdOn=" + createdOn + ", isActive=" + isActive + ", isArchive=" + isArchive + ", expiryDate=" + expiryDate + ", lastModifiedOn=" + lastModifiedOn + ", notificationSubject=" + notificationSubject + '}';
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notificationId != null ? notificationId.hashCode() : 0);
        return hash;
    }

    @Override
     public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SystemNotificationMaster)) {
            return false;
        }
        SystemNotificationMaster other = (SystemNotificationMaster) object;
        if ((this.notificationId == null && other.notificationId != null) || (this.notificationId != null && !this.notificationId.equals(other.notificationId))) {
            return false;
        }
        return true;
    }
    
    
}
