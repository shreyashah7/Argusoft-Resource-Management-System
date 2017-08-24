
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
@Table(name = "tsk_dcln_dtl")
@XmlRootElement
public class TaskDeclineDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tsk_dcln__dtl_id")
    private Long taskDeclineDetailId;

    @JoinColumn(name = "tsk_id", referencedColumnName = "tsk_id", nullable = false)
    @ManyToOne(optional = false)
    private TaskMaster taskId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "tsk_assgn_dt")
    @Temporal(TemporalType.DATE)
    private Date taskAssignDate;

    @Column(name = "dcln_rsn")
    private String declineReason;

    @Column(name = "dcln_dt")
    @Temporal(TemporalType.DATE)
    private Date declineDate;

    @Column(name = "created_on")
    @Temporal(TemporalType.DATE)
    private Date createdOn;

    @Column(name = "ntfction_fr")
    private Long notificationFor;

    @Column(name = "rspnd_by")
    private Long respondBy;

    @Column(name = "rspnd_sttus")
    private String respondStatus;

    @Column(name = "rspnd_on")
    @Temporal(TemporalType.DATE)
    private Date respondOn;

    @Column(name = "is_active")
    private Boolean isActive;

    public TaskDeclineDetail() {
    }

    public TaskDeclineDetail(Long taskDeclineDetailId) {
        this.taskDeclineDetailId = taskDeclineDetailId;
    }

    public Long getTaskDeclineDetailId() {
        return taskDeclineDetailId;
    }

    public void setTaskDeclineDetailId(Long taskDeclineDetailId) {
        this.taskDeclineDetailId = taskDeclineDetailId;
    }

    public TaskMaster getTaskId() {
        return taskId;
    }

    public void setTaskId(TaskMaster taskId) {
        this.taskId = taskId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getNotificationFor() {
        return notificationFor;
    }

    public void setNotificationFor(Long notificationFor) {
        this.notificationFor = notificationFor;
    }

    public Long getRespondBy() {
        return respondBy;
    }

    public void setRespondBy(Long respondBy) {
        this.respondBy = respondBy;
    }

    public Date getTaskAssignDate() {
        return taskAssignDate;
    }

    public void setTaskAssignDate(Date taskAssignDate) {
        this.taskAssignDate = taskAssignDate;
    }

    public String getDeclineReason() {
        return declineReason;
    }

    public void setDeclineReason(String declineReason) {
        this.declineReason = declineReason;
    }

    public Date getDeclineDate() {
        return declineDate;
    }

    public void setDeclineDate(Date declineDate) {
        this.declineDate = declineDate;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getRespondStatus() {
        return respondStatus;
    }

    public void setRespondStatus(String respondStatus) {
        this.respondStatus = respondStatus;
    }

    public Date getRespondOn() {
        return respondOn;
    }

    public void setRespondOn(Date respondOn) {
        this.respondOn = respondOn;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}
