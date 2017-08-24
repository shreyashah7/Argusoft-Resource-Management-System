/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.databean;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author brijesh
 */
@ManagedBean(name = "projectRolesDataBean")
@RequestScoped
public class ProjectRolesDataBean {

    private Long projectRolesId;
    private String projectRolesName;
    private String projectRolesDescription;
    private Date createdOn;
    private Long createdBy;
    private Boolean isActive;
    private String status;

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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getProjectRolesId() {
        return projectRolesId;
    }

    public void setProjectRolesId(Long projectRolesId) {
        this.projectRolesId = projectRolesId;
    }

    public String getProjectRolesName() {
        return projectRolesName;
    }

    public void setProjectRolesName(String projectRolesName) {
        this.projectRolesName = projectRolesName;
    }

    public String getProjectRolesDescription() {
        return projectRolesDescription;
    }

    public void setProjectRolesDescription(String projectRolesDescription) {
        this.projectRolesDescription = projectRolesDescription;
    }

    @Override
    public String toString() {
        return "ProjectRolesDataBean{" + "projectRolesId=" + projectRolesId + ", projectRolesName=" + projectRolesName + ", projectRolesDescription=" + projectRolesDescription + ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", isActive=" + isActive + ", status=" + status + '}';
    }

   
}
