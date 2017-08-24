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

/**
 * This class is to perform allocation of resources to project.
 *
 * @author niharika
 */
@ManagedBean(name = "projectResourceDataBean")
@RequestScoped
public class ProjectResourceDataBean {

    private Long projectId;
    private String projectName;
    private String userName;
    private List<Long> userIds;
    private Long userId;
    private String technologyName;
    private Long techId;
    private String toolName;
    public String[] server;
    private Long userIdRetrieve;
    private Date createdOn;
    private Date lstModifiedOn;
    private String createdBy;
    private String lstModifiedBy;
    private Long projectTechId;
    private Long id;
    private String name;
    private String resourceDesc;
    private List<Long> techIds;
    private List<Long> toolIds;
    private List<Long> browserIds;
    private List<Long> osIds;
    private List<Long> serverIds;
    private Long roleType;
    private Long projectResourceId;
    private String roleName;
    private String assignedBy;

    public String getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getProjectResourceId() {
        return projectResourceId;
    }

    public void setProjectResourceId(Long projectResourceId) {
        this.projectResourceId = projectResourceId;

    }

    public Long getRoleType() {
        return roleType;
    }

    public void setRoleType(Long roleType) {
        this.roleType = roleType;
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProjectTechId() {
        return projectTechId;
    }

    public void setProjectTechId(Long projectTechId) {
        this.projectTechId = projectTechId;
    }

    public Long getTechId() {
        return techId;
    }

    public void setTechId(Long techId) {
        this.techId = techId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getLstModifiedOn() {
        return lstModifiedOn;
    }

    public void setLstModifiedOn(Date lstModifiedOn) {
        this.lstModifiedOn = lstModifiedOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLstModifiedBy() {
        return lstModifiedBy;
    }

    public void setLstModifiedBy(String lstModifiedBy) {
        this.lstModifiedBy = lstModifiedBy;
    }

    public Long getUserIdRetrieve() {
        return userIdRetrieve;
    }

    public void setUserIdRetrieve(Long userIdRetrieve) {
        this.userIdRetrieve = userIdRetrieve;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String[] getServer() {
        return server;
    }

    public void setServer(String[] server) {
        this.server = server;
    }

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public List<Long> getTechIds() {
        return techIds;
    }

    public void setTechIds(List<Long> techIds) {
        this.techIds = techIds;
    }

    public List<Long> getToolIds() {
        return toolIds;
    }

    public void setToolIds(List<Long> toolIds) {
        this.toolIds = toolIds;
    }

    public List<Long> getBrowserIds() {
        return browserIds;
    }

    public void setBrowserIds(List<Long> browserIds) {
        this.browserIds = browserIds;
    }

    public List<Long> getOsIds() {
        return osIds;
    }

    public void setOsIds(List<Long> osIds) {
        this.osIds = osIds;
    }

    public List<Long> getServerIds() {
        return serverIds;
    }

    public void setServerIds(List<Long> serverIds) {
        this.serverIds = serverIds;
    }

    

    
    @Override
    public String toString() {
        return "ProjectResourceDataBean{" + "projectId=" + projectId + ", projectName=" + projectName + ", userName=" + userName + ", userId=" + userId + ", technologyName=" + technologyName + ", techId=" + techId + ", toolName=" + toolName + ", server=" + server + '}';
    }

}
