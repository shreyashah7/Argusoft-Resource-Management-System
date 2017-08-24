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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

/**
 *
 * @author brijesh
 */
@Entity
@Table(name = "tsk_mst")
@Indexed
public class TaskMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tsk_id")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
    private String taskId;
    @JoinColumn(name = "proj_id", referencedColumnName = "proj_id", nullable = false)
    @ManyToOne(optional = false)
    private Project projectId;

    @Column(name = "tsk_nm")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
    private String taskName;
    @Column(name = "tsk_desc")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
    @Type(type = "org.hibernate.type.StringClobType")
    private String taskDescription;

    @Column(name = "assigned_to")
    private Long assignedTo;

    @Column(name = "strt_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "end_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "actual_end_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualEndDate;

    @Column(name = "tsk_duration")
    private String taskDuration;
    @Column(name = "tsk_priority")
    private Long taskPriority;
    @Column(name = "tsk_progrs")
    private String taskProgress;
    @Column(name = "tsk_sttus")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
    private String taskStatus;
    @JoinColumn(name = "parent_task_id", referencedColumnName = "tsk_id")
    @ManyToOne
    private TaskMaster parentTaskId;
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
    @Column(name = "milestone_id")
    private Long milestoneId;

    public Long getMilestoneId() {
        return milestoneId;
    }

    public void setMilestoneId(Long milestoneId) {
        this.milestoneId = milestoneId;
    }

    public TaskMaster() {
    }

    public TaskMaster(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Long getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Long assignedTo) {
        this.assignedTo = assignedTo;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(Date actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTaskDuration() {
        return taskDuration;
    }

    public void setTaskDuration(String taskDuration) {
        this.taskDuration = taskDuration;
    }

    public Long getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(Long taskPriority) {
        this.taskPriority = taskPriority;
    }

    public String getTaskProgress() {
        return taskProgress;
    }

    public void setTaskProgress(String taskProgress) {
        this.taskProgress = taskProgress;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public TaskMaster getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(TaskMaster parentTaskId) {
        this.parentTaskId = parentTaskId;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskId != null ? taskId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaskMaster)) {
            return false;
        }
        TaskMaster other = (TaskMaster) object;
        if ((this.taskId == null && other.taskId != null) || (this.taskId != null && !this.taskId.equals(other.taskId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TaskMaster{" + "taskId=" + taskId + ", projectId=" + projectId + ", taskName=" + taskName + ", taskDescription=" + taskDescription + ", assignedTo=" + assignedTo + ", startDate=" + startDate + ", endDate=" + endDate + ", taskDuration=" + taskDuration + ", taskPriority=" + taskPriority + ", taskProgress=" + taskProgress + ", taskStatus=" + taskStatus + ", parentTaskId=" + parentTaskId + ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", lastModifiedOn=" + lastModifiedOn + ", lastModifiedBy=" + lastModifiedBy + ", isActive=" + isActive + '}';
    }

}
