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
 * @author brijesh
 */
@Entity
@Table(name = "tsk_atchment")
@XmlRootElement
public class TaskAttachment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tsk_atchmnt_id")
    private Long taskAttachmentId;
    
    @Basic(optional = false)
    @Column(name = "tsk_id")
    private String taskId;
    
    @Column(name = "tsk_atchmnt_nm")
    private String taskAttachmentName;
    @Column(name = "atchmnt_path")
    private String attachmentPath;
    @Column(name = "created_on")
    @Temporal(TemporalType.DATE)
    private Date createdOn;

    @Column(name = "uploaded_by")
    private Long uploadedBy;

    @Column(name = "deleted_on")
    @Temporal(TemporalType.DATE)
    private Date deletedOn;
    @Column(name = "deleted_by")
    private Long deletedBy;
    @Column(name = "is_active")
    private Boolean isActive;

    public TaskAttachment() {
    }

    public TaskAttachment(Long taskAttachmentId) {
        this.taskAttachmentId = taskAttachmentId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }   
    
    public Long getTaskAttachmentId() {
        return taskAttachmentId;
    }

    public void setTaskAttachmentId(Long taskAttachmentId) {
        this.taskAttachmentId = taskAttachmentId;
    }

    public String getTaskAttachmentName() {
        return taskAttachmentName;
    }

    public void setTaskAttachmentName(String taskAttachmentName) {
        this.taskAttachmentName = taskAttachmentName;
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Long getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(Long uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public Long getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Long deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Date getDeletedOn() {
        return deletedOn;
    }

    public void setDeletedOn(Date deletedOn) {
        this.deletedOn = deletedOn;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskAttachmentId != null ? taskAttachmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaskAttachment)) {
            return false;
        }
        TaskAttachment other = (TaskAttachment) object;
        if ((this.taskAttachmentId == null && other.taskAttachmentId != null) || (this.taskAttachmentId != null && !this.taskAttachmentId.equals(other.taskAttachmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.argusoft.armms.model.TskAtchment[ tskAtchmntId=" + taskAttachmentId + " ]";
    }

}
