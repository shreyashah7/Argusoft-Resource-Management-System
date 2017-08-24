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
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author shreya
 */
@Entity
@Table(name = "watcher")
@Indexed
public class Watcher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long watchId;
    
    @Column(name = "watcher_id")
    private Long watcherId;
    
    @JoinColumn(name = "tsk_id", referencedColumnName = "tsk_id", nullable = false)
    @ManyToOne(optional = false)
    private TaskMaster taskId;
    
    @Basic(optional = false)
    @Column(name = "is_active")
    private Boolean isActive;
    
    @Basic(optional = false)
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    
    @Basic(optional = false)
    @Column(name = "created_by")
    private Long createdBy;
    
    @Column(name = "modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date LstModifiedOn;
    
    @Column(name = "modified_by")
    private Long LstModifiedBy;

    public Long getWatchId() {
        return watchId;
    }

    public void setWatchId(Long watchId) {
        this.watchId = watchId;
    }

    public Long getWatcherId() {
        return watcherId;
    }

    public void setWatcherId(Long watcherId) {
        this.watcherId = watcherId;
    }

    public TaskMaster getTaskId() {
        return taskId;
    }

    public void setTaskId(TaskMaster taskId) {
        this.taskId = taskId;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
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

    public Date getLstModifiedOn() {
        return LstModifiedOn;
    }

    public void setLstModifiedOn(Date LstModifiedOn) {
        this.LstModifiedOn = LstModifiedOn;
    }

    public Long getLstModifiedBy() {
        return LstModifiedBy;
    }

    public void setLstModifiedBy(Long LstModifiedBy) {
        this.LstModifiedBy = LstModifiedBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (watchId != null ? watchId.hashCode() : 0);
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
        final Watcher other = (Watcher) obj;
        if (this.watchId != other.watchId && (this.watchId == null || !this.watchId.equals(other.watchId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Watcher{" + "watchId=" + watchId + ", watcherId=" + watcherId + ", taskId=" + taskId + ", isActive=" + isActive + ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", LstModifiedOn=" + LstModifiedOn + ", LstModifiedBy=" + LstModifiedBy + '}';
    }

   
    
    
    
}
