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
@Table(name = "tsk_trck")
@XmlRootElement

public class TaskTrack implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tsk_trck_id")
    private Long taskTrackId;

    @Column(name="tsk_id")
    private String taskId;

    @Column(name = "strt_tm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Column(name = "end_tm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Column(name = "trck_mode")
    private String trackMode;
    
    @Column(name = "log_date")
    @Temporal(TemporalType.DATE)
    private Date logDate;
    
    @JoinColumn(name = "proj_id", referencedColumnName = "proj_id", nullable = false)
    @ManyToOne(optional = false)
    private Project projectId;
    
    @Column(name = "comment")    
    private String comment;

    @Column(name = "duration")    
    private String duration;
    
    @Column(name = "logged_by")
    private Long logBy;

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }    

    public TaskTrack() {
    }

    public TaskTrack(Long taskTrackId) {
        this.taskTrackId = taskTrackId;
    }

    public Long getTaskTrackId() {
        return taskTrackId;
    }

    public void setTaskTrackId(Long taskTrackId) {
        this.taskTrackId = taskTrackId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTrackMode() {
        return trackMode;
    }

    public void setTrackMode(String trackMode) {
        this.trackMode = trackMode;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }        

    public Long getLogBy() {
        return logBy;
    }

    public void setLogBy(Long logBy) {
        this.logBy = logBy;
    }        

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskTrackId != null ? taskTrackId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaskTrack)) {
            return false;
        }
        TaskTrack other = (TaskTrack) object;
        if ((this.taskTrackId == null && other.taskTrackId != null) || (this.taskTrackId != null && !this.taskTrackId.equals(other.taskTrackId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.argusoft.armms.model.TaskTrack[ taskTrackId=" + taskTrackId + " ]";
    }

}
