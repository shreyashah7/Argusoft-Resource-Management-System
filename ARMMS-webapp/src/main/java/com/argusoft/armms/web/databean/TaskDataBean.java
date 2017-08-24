/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.databean;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.swing.text.StyledEditorKit;

/**
 * for storing details regarding task
 *
 * @author ravi
 */
@ManagedBean(name = "taskDataBean")
@RequestScoped
public class TaskDataBean implements Comparable<TaskDataBean> {

    private boolean disabledDeclineBtn = false;

    private Long projectId;
    private String projectName;
    private String ProjectAlias;
    private String taskId;
    private Long assignedTo;
    private String assignedToName;
    private Date startDate;
    private String expr;
    private Date endDate;
    private String taskDescription;
    private String taskName;
    private String declineReason;
    private Long taskPriority;
    private Long createdBy;
    private String decline = "Decline";
    private String taskAssignedBy;
    private String status;
    private Long taskTrackId;
    private Date startTime;
    private Date endTime;
    private String duration;
    private Boolean markAsComplete;
    private Long inLongduration;
    private Long projectDuration;
    private Date modifiedOn;
    private Long modifiedBy;
    private Date actualEndDate;
    private String taskUiDesc;
    private Date dueDate;
    private Long priority;
    private String parentTask;
    private Boolean flag;
    private String attchmentPath;
    private String attachmentFileName;
    private List<Long> taskTechnologies;
    private List<Long> watcherList;
    private String modifiedByName;
    private String createdByName;
    private String AssignedToName;
    private int taskProgress;
    private Date createdOn;
    private Long milestoneId;
    private String sendTo;
    private String show;
    private Boolean Continue;

    public Boolean getContinue() {
        return Continue;
    }

    public void setContinue(Boolean Continue) {
        this.Continue = Continue;
    }

    public String getExpr() {
        return expr;
    }

    public void setExpr(String expr) {
        this.expr = expr;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public Long getMilestoneId() {
        return milestoneId;
    }

    public void setMilestoneId(Long milestoneId) {
        this.milestoneId = milestoneId;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public boolean isDisabledDeclineBtn() {
        return disabledDeclineBtn;
    }

    public void setDisabledDeclineBtn(boolean disabledDeclineBtn) {
        this.disabledDeclineBtn = disabledDeclineBtn;
    }

    public String getAttachmentFileName() {
        return attachmentFileName;
    }

    public void setAttachmentFileName(String attachmentFileName) {
        this.attachmentFileName = attachmentFileName;
    }

    public String getAttchmentPath() {
        return attchmentPath;
    }

    public void setAttchmentPath(String attchmentPath) {
        this.attchmentPath = attchmentPath;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getMarkAsComplete() {
        return markAsComplete;
    }

    public Long getProjectDuration() {
        return projectDuration;
    }

    public void setProjectDuration(Long projectDuration) {
        this.projectDuration = projectDuration;
    }

    public Long getInLongduration() {
        return inLongduration;
    }

    public void setInLongduration(Long inLongduration) {
        this.inLongduration = inLongduration;
    }

    public void setMarkAsComplete(Boolean markAsComplete) {
        this.markAsComplete = markAsComplete;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDeclineReason() {
        return declineReason;
    }

    public void setDeclineReason(String declineReason) {
        this.declineReason = declineReason;
    }

    public Long getTaskTrackId() {
        return taskTrackId;
    }

    public String getParentTask() {
        return parentTask;
    }

    public void setParentTask(String parentTask) {
        this.parentTask = parentTask;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskTrackId(Long taskTrackId) {
        this.taskTrackId = taskTrackId;
    }

    public Date getStartTime() {
        return startTime;
//        System.out.println("++++task name++" + taskName);
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDecline() {
        return decline;
    }

    public void setDecline(String decline) {
        this.decline = decline;
    }

    public String getTaskAssignedBy() {
        return taskAssignedBy;
    }

    public void setTaskAssignedBy(String taskAssignedBy) {
        this.taskAssignedBy = taskAssignedBy;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTaskUiDesc() {
        return taskUiDesc;
    }

    public void setTaskUiDesc(String taskUiDesc) {
        this.taskUiDesc = taskUiDesc;
    }

    public Long getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(Long taskPriority) {
        this.taskPriority = taskPriority;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;

    }

    public String getProjectAlias() {
        return ProjectAlias;

    }

    public void setProjectAlias(String ProjectAlias) {
        this.ProjectAlias = ProjectAlias;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Long getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Long assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getAssignedToName() {
        return assignedToName;
    }

    public void setAssignedToName(String assignedToName) {
        this.assignedToName = assignedToName;

    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public List<Long> getWatcherList() {
        return watcherList;
    }

    public void setWatcherList(List<Long> watcherList) {
        this.watcherList = watcherList;
    }

    public Date getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(Date actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    @Override
    public int compareTo(TaskDataBean compareTaskDataBean) {
        Date compareStartDate = ((TaskDataBean) compareTaskDataBean).getStartDate();
       
        //ascending order
        return this.startDate.compareTo(compareStartDate);
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public String getModifiedByName() {
        return modifiedByName;
    }

    public void setModifiedByName(String ModifiedByName) {
        this.modifiedByName = ModifiedByName;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String CreatedByName) {
        this.createdByName = CreatedByName;
    }

    public int getTaskProgress() {
        return taskProgress;
    }

    public void setTaskProgress(int taskProgress) {
        this.taskProgress = taskProgress;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public List<Long> getTaskTechnologies() {
        return taskTechnologies;
    }

    public void setTaskTechnologies(List<Long> taskTechnologies) {
        this.taskTechnologies = taskTechnologies;
    }

    @Override
    public String toString() {
        return "TaskDataBean{" + "projectId=" + projectId + ", ProjectAlias=" + ProjectAlias + ", taskId=" + taskId + ", assignedTo=" + assignedTo + ", startDate=" + startDate + ", endDate=" + endDate + ", taskDescription=" + taskDescription + ", taskName=" + taskName + ", taskPriority=" + taskPriority + ", createdBy=" + createdBy + ", projectName=" + projectName + ", taskAssignedBy=" + taskAssignedBy + ", status=" + status + '}';
    }

}
