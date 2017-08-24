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
 * @author shifa
 */
@Entity
@Table(name = "task_comment")
@XmlRootElement
public class TaskComment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comment_id")
    private Long id;
    @JoinColumn(name = "tsk_id", referencedColumnName = "tsk_id", nullable = false)
    @ManyToOne(optional = false)
    private TaskMaster taskId;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "desciption")
    private String description;
    @Basic(optional = false)
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Basic(optional = false)
    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date LastModifiedOn;

    @Column(name = "modified_by")
    private Long LastModifiedBy;

    public TaskComment() {
    }

    public TaskComment(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TaskMaster getTaskId() {
        return taskId;
    }

    public void setTaskId(TaskMaster taskId) {
        this.taskId = taskId;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return LastModifiedOn;
    }

    public void setLastModifiedOn(Date LastModifiedOn) {
        this.LastModifiedOn = LastModifiedOn;
    }

    public Long getLastModifiedBy() {
        return LastModifiedBy;
    }

    public void setLastModifiedBy(Long LastModifiedBy) {
        this.LastModifiedBy = LastModifiedBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaskComment)) {
            return false;
        }
        TaskComment other = (TaskComment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TaskComment{" + "id=" + id + ", taskId=" + taskId + ", isActive=" + isActive + ", description=" + description + ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", LastModifiedOn=" + LastModifiedOn + ", LastModifiedBy=" + LastModifiedBy + '}';
    }

}
