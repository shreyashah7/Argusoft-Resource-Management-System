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
 * @author niharika
 * @since 24-MAR-2014
 */
@Entity
@Table(name = "email_notification")
public class EmailNotification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "email_ntfction_id", nullable = false)
    private Long emailNotificationId;
    @Column(name = "tsk_allctn_mail")
    private Boolean taskAllocationMail;
    @Column(name = "assgnd_tsk_updt_mail")
    private Boolean assignedTaskUpdateMail;
    @Column(name = "tsk_deadline_warng_mail")
    private Boolean taskDeadlineWarningMail;
    @Column(name = "tsk_end_remndr_mail")
    private Boolean taskEndRemainderMail;
    @Column(name = "proj_assgnd_mail")
    private Boolean projectAssignedMail;
    @Column(name = "watch_mail")
    private Boolean watchMail;
    @Column(name = "lst_modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedOn;
    @Column(name = "userid")
    @Basic(optional = false)
    private Long user;
    @Column(name = "lst_modified_by")
    private Long lastModifiedBy;

    public EmailNotification() {
    }

    public EmailNotification(Long emailNotificationId, Boolean taskAllocationMail, Boolean assignedTaskUpdateMail, Boolean taskDeadlineWarningMail, Boolean taskEndRemainderMail, Boolean projectAssignedMail, Boolean watchMail, Date lastModifiedOn, Long user, Long lastModifiedBy) {
        this.emailNotificationId = emailNotificationId;
        this.taskAllocationMail = taskAllocationMail;
        this.assignedTaskUpdateMail = assignedTaskUpdateMail;
        this.taskDeadlineWarningMail = taskDeadlineWarningMail;
        this.taskEndRemainderMail = taskEndRemainderMail;
        this.projectAssignedMail = projectAssignedMail;
        this.watchMail = watchMail;
        this.lastModifiedOn = lastModifiedOn;
        this.user = user;
        this.lastModifiedBy = lastModifiedBy;
    }

    public Long getEmailNotificationId() {
        return emailNotificationId;
    }

    public void setEmailNotificationId(Long emailNotificationId) {
        this.emailNotificationId = emailNotificationId;
    }

    public Boolean getTaskAllocationMail() {
        return taskAllocationMail;
    }

    public void setTaskAllocationMail(Boolean taskAllocationMail) {
        this.taskAllocationMail = taskAllocationMail;
    }

    public Boolean getAssignedTaskUpdateMail() {
        return assignedTaskUpdateMail;
    }

    public void setAssignedTaskUpdateMail(Boolean assignedTaskUpdateMail) {
        this.assignedTaskUpdateMail = assignedTaskUpdateMail;
    }

    public Boolean getTaskDeadlineWarningMail() {
        return taskDeadlineWarningMail;
    }

    public void setTaskDeadlineWarningMail(Boolean taskDeadlineWarningMail) {
        this.taskDeadlineWarningMail = taskDeadlineWarningMail;
    }

    public Boolean getTaskEndRemainderMail() {
        return taskEndRemainderMail;
    }

    public void setTaskEndRemainderMail(Boolean taskEndRemainderMail) {
        this.taskEndRemainderMail = taskEndRemainderMail;
    }

    public Boolean getProjectAssignedMail() {
        return projectAssignedMail;
    }

    public void setProjectAssignedMail(Boolean projectAssignedMail) {
        this.projectAssignedMail = projectAssignedMail;
    }

    public Boolean getWatchMail() {
        return watchMail;
    }

    public void setWatchMail(Boolean watchMail) {
        this.watchMail = watchMail;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailNotificationId != null ? emailNotificationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailNotification)) {
            return false;
        }
        EmailNotification other = (EmailNotification) object;
        if ((this.emailNotificationId == null && other.emailNotificationId != null) || (this.emailNotificationId != null && !this.emailNotificationId.equals(other.emailNotificationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.argusoft.armms.model.EmailNotification[ emailNotifiationId=" + emailNotificationId + " ]";
    }

}
