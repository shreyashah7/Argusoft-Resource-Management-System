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
 * @author shreya
 */
@Entity
@Table(name = "proj_attachment")
@XmlRootElement
public class ProjectAttachment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proj_atchmnt_id")
    private Long projectAttachmentId;

    @Basic(optional = false)
    @JoinColumn(name = "proj_id", referencedColumnName = "proj_id")
    @ManyToOne()
    private Project projectId;

    @Column(name = "proj_atchmnt_nm")
    private String projectAttachmentName;

    @Column(name = "proj_atchmnt_path")
    private String projectAttachmentPath;

    @Column(name = "created_on")
     @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Column(name = "uploaded_by")
    private Long uploadedBy;

    @Column(name = "lst_modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lstModifiedOn;

    @Column(name = "lst_modified_by")
    private Long lstModifiedBy;

    @Column(name = "is_active")
    private Boolean isActive;
    
    @Column(name = "proj_attchmnt_size")
    private Long projectAttachmentSize;

    public ProjectAttachment() {
    }

    public ProjectAttachment(Long projectAttachmentId, Project projectId, String projectAttachmentName, String projectAttachmentPath, Date createdOn, Long uploadedBy, Date lstModifiedOn, Long lstModifiedBy, Boolean isActive, Long projectAttachmentSize) {
        this.projectAttachmentId = projectAttachmentId;
        this.projectId = projectId;
        this.projectAttachmentName = projectAttachmentName;
        this.projectAttachmentPath = projectAttachmentPath;
        this.createdOn = createdOn;
        this.uploadedBy = uploadedBy;
        this.lstModifiedOn = lstModifiedOn;
        this.lstModifiedBy = lstModifiedBy;
        this.isActive = isActive;
        this.projectAttachmentSize = projectAttachmentSize;
    }

    public Long getProjectAttachmentSize() {
        return projectAttachmentSize;
    }

    public void setProjectAttachmentSize(Long projectAttachmentSize) {
        this.projectAttachmentSize = projectAttachmentSize;
    }

    

    public Long getProjectAttachmentId() {
        return projectAttachmentId;
    }

    public void setProjectAttachmentId(Long projectAttachmentId) {
        this.projectAttachmentId = projectAttachmentId;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public String getProjectAttachmentName() {
        return projectAttachmentName;
    }

    public void setProjectAttachmentName(String projectAttachmentName) {
        this.projectAttachmentName = projectAttachmentName;
    }

    public String getProjectAttachmentPath() {
        return projectAttachmentPath;
    }

    public void setProjectAttachmentPath(String projectAttachmentPath) {
        this.projectAttachmentPath = projectAttachmentPath;
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

    public Date getLstModifiedOn() {
        return lstModifiedOn;
    }

    public void setLstModifiedOn(Date lstModifiedOn) {
        this.lstModifiedOn = lstModifiedOn;
    }

    public Long getLstModifiedBy() {
        return lstModifiedBy;
    }

    public void setLstModifiedBy(Long lstModifiedBy) {
        this.lstModifiedBy = lstModifiedBy;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "ProjectAttachment{" + "projectAttachmentId=" + projectAttachmentId + ", projectId=" + projectId + ", projectAttachmentName=" + projectAttachmentName + ", projectAttachmentPath=" + projectAttachmentPath + ", createdOn=" + createdOn + ", uploadedBy=" + uploadedBy + ", lstModifiedOn=" + lstModifiedOn + ", lstModifiedBy=" + lstModifiedBy + ", isActive=" + isActive + '}';
    }

}
