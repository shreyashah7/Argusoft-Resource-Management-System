/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.databean;

import com.argusoft.armms.model.Project;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Pattern;

/**
 *
 * @author shifa
 */
@ManagedBean(name = "projectDataBean")
@RequestScoped
public class ProjectDataBean implements Serializable {

    /**
     * Creates a new instance of ProjectDataBean
     */
    private Long projectId;
    private String messageProjectSummary;
    private String projectAlias;
    private String projectName;
    private String projectDescription;
    private Long overBooked, underbooked, normal, unavailable;
    private String projectPriority;
    private Long assignedTo;
    private String assignedToName;
    private String ProjectManagerName;
    private Date startDate;
    private String message;
    private Boolean isSuccess;
    private Date actualEndDate;
    private Date estimatedEndDate;
    private String status;
    private Date createdOn;
    private Long createdBy;
    private String createdByName;
    private Boolean isActive;
    private Boolean isArchive;
    private List<Project> projectmaster;
    
    // by Shifa for chart
    private Double Completion;
    private String Project;
    //by ravi
    private String SvnUrl;

    public String getMessageProjectSummary() {
        return messageProjectSummary;
    }

    public void setMessageProjectSummary(String messageProjectSummary) {
        this.messageProjectSummary = messageProjectSummary;
    }

    public Double getCompletion() {
        return Completion;
    }

    public void setCompletion(Double Completion) {
        this.Completion = Completion;
    }

    public String getProject() {
        return Project;
    }

    public void setProject(String Project) {
        this.Project = Project;
    }

    public List<Project> getProjectmaster() {
        return projectmaster;
    }

    public void setProjectmaster(List<Project> projectmaster) {
        this.projectmaster = projectmaster;
    }

    public ProjectDataBean() {

    }

    public String getAssignedToName() {
        return assignedToName;
    }

    public void setAssignedToName(String assignedToName) {
        this.assignedToName = assignedToName;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsArchive() {
        return isArchive;
    }

    public void setIsArchive(Boolean isArchive) {
        this.isArchive = isArchive;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProjectManagerName() {
        return ProjectManagerName;
    }

    public void setProjectManagerName(String ProjectManagerName) {
        this.ProjectManagerName = ProjectManagerName;
    }

    public Boolean isIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Date getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(Date actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectAlias() {
        return projectAlias;
    }

    public void setProjectAlias(String projectAlias) {
        this.projectAlias = projectAlias;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectPriority() {
        return projectPriority;
    }

    public void setProjectPriority(String projectPriority) {
        this.projectPriority = projectPriority;
    }

    public Long getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Long assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEstimatedEndDate() {
        return estimatedEndDate;
    }

    public void setEstimatedEndDate(Date estimatedEndDate) {
        this.estimatedEndDate = estimatedEndDate;
    }

    public String getSvnUrl() {
        return SvnUrl;
    }

    public void setSvnUrl(String SvnUrl) {
        this.SvnUrl = SvnUrl;
    }

    public Long getOverBooked() {
        return overBooked;
    }

    public void setOverBooked(Long overBooked) {
        this.overBooked = overBooked;
    }

    public Long getUnderbooked() {
        return underbooked;
    }

    public void setUnderbooked(Long underbooked) {
        this.underbooked = underbooked;
    }

    public Long getNormal() {
        return normal;
    }

    public void setNormal(Long normal) {
        this.normal = normal;
    }

    public Long getUnavailable() {
        return unavailable;
    }

    public void setUnavailable(Long unavailable) {
        this.unavailable = unavailable;
    }

    @Override
    public String toString() {
        return "ProjectDataBean{" + "projectId=" + projectId + ", messageProjectSummary=" + messageProjectSummary + ", projectAlias=" + projectAlias + ", projectName=" + projectName + ", projectDescription=" + projectDescription + ", overBooked=" + overBooked + ", underbooked=" + underbooked + ", normal=" + normal + ", unavailable=" + unavailable + ", projectPriority=" + projectPriority + ", assignedTo=" + assignedTo + ", assignedToName=" + assignedToName + ", ProjectManagerName=" + ProjectManagerName + ", startDate=" + startDate + ", message=" + message + ", isSuccess=" + isSuccess + ", actualEndDate=" + actualEndDate + ", estimatedEndDate=" + estimatedEndDate + ", status=" + status + ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", createdByName=" + createdByName + ", isActive=" + isActive + ", isArchive=" + isArchive + ", projectmaster=" + projectmaster + ", Completion=" + Completion + ", Project=" + Project + ", SvnUrl=" + SvnUrl + '}';
    }

}
