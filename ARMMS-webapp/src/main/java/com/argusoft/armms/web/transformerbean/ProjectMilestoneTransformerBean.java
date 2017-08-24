/*
 * To change this license header, choose License Headers in ProjectMaster Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.transformerbean;

import com.argusoft.armms.core.ProjectService;
import com.argusoft.armms.model.Project;
import com.argusoft.armms.model.ProjectMilestone;
import com.argusoft.armms.model.TaskMaster;
import com.argusoft.armms.web.databean.ProjectDataBean;
import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import com.argusoft.armms.web.databean.ProjectMilestoneDataBean;
import com.argusoft.armms.web.databean.TaskDataBean;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.usermanagement.common.core.UMSystemConfigurationService;
import com.argusoft.usermanagement.common.core.UMUserService;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import com.argusoft.usermanagement.common.model.UMSystemConfiguration;
import com.argusoft.usermanagement.common.model.UMUser;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author rajkumar
 */
@ManagedBean(name = "projectMilestoneTransformerBean")
@RequestScoped
public class ProjectMilestoneTransformerBean {

    @ManagedProperty(value = "#{projectService}")
    private ProjectService projectService;

    @ManagedProperty("#{projectMilestoneDataBean}")
    private ProjectMilestoneDataBean projectMilestoneDataBean;

    @ManagedProperty("#{loginDataBean}")
    private LoginDataBean loginDataBean;

    @ManagedProperty("#{userService}")
    private UMUserService userService;

    @ManagedProperty("#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;
    
    @ManagedProperty("#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;
    
     @ManagedProperty(value = "#{systemConfigurationService}")
    private UMSystemConfigurationService systemConfigurationService;

    public UMUserService getUserService() {
        return userService;
    }

    public void setUserService(UMUserService userService) {
        this.userService = userService;
    }

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    public UMSystemConfigurationService getSystemConfigurationService() {
        return systemConfigurationService;
    }

    public void setSystemConfigurationService(UMSystemConfigurationService systemConfigurationService) {
        this.systemConfigurationService = systemConfigurationService;
    }

    public SystemResultSessionUtil getSystemResultSessionUtil() {
        return systemResultSessionUtil;
    }

    public void setSystemResultSessionUtil(SystemResultSessionUtil systemResultSessionUtil) {
        this.systemResultSessionUtil = systemResultSessionUtil;
    }

    public ProjectMilestoneDataBean getProjectMilestoneDataBean() {
        return projectMilestoneDataBean;
    }

    public void setProjectMilestoneDataBean(ProjectMilestoneDataBean projectMilestoneDataBean) {
        this.projectMilestoneDataBean = projectMilestoneDataBean;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public LoginDataBean getLoginDataBean() {
        return loginDataBean;
    }

    public void setLoginDataBean(LoginDataBean loginDataBean) {
        this.loginDataBean = loginDataBean;
    }

    public List<ProjectDataBean> retrieveAllProjects() {

        List<Project> projectList = projectService.retrieveProjects();
        List<ProjectDataBean> projectListDataBean = new ArrayList<>();

        for (Project projectMaster : projectList) {
            ProjectDataBean projectDataBean = new ProjectDataBean();

            projectDataBean.setProjectId(projectMaster.getProjectId());
            projectDataBean.setProjectName(projectMaster.getProjectAlias());

            projectListDataBean.add(projectDataBean);
        }
        return projectListDataBean;

    }

    public List<ProjectMilestoneDataBean> retrieveAllMilestones(Boolean activeMilestones) throws UMUserManagementException {

        List<ProjectMilestone> projectMilestones;
        if (activeMilestones != null) {
            if (activeMilestones == true) {
                projectMilestones = projectService.retrieveActiveOrInactiveProjectMilestones(true);
            } else {
                projectMilestones = projectService.retrieveActiveOrInactiveProjectMilestones(false);
            }
        } else {
            projectMilestones = projectService.retrieveActiveOrInactiveProjectMilestones(null);
        }
        return(convertMilestoneModelToDataBean(projectMilestones));
    }

    public List<ProjectMilestoneDataBean> convertMilestoneModelToDataBean(List<ProjectMilestone> projectMilestones) throws UMUserManagementException {
        
        List<UMUser> userlist = userService.getAllActiveUsers();

        Map<Long, String> userMap = new HashMap<>();
        for (UMUser userobj : userlist) {
            StringBuffer name = new StringBuffer();
            name.append(userobj.getFirstName());
            if (userobj.getLastName() != null) {
                name.append(" ").append(userobj.getLastName());
            }
            userMap.put(userobj.getId(), name.toString());
        }
        
        List<ProjectMilestoneDataBean> projectMilestoneDataBeans;
        projectMilestoneDataBeans = new ArrayList<>();
        for (ProjectMilestone master : projectMilestones) {
            ProjectMilestoneDataBean projectMilestone = new ProjectMilestoneDataBean();
            projectMilestone.setProjectMilestoneId(master.getProjectMilestoneId());
            projectMilestone.setProjectId(master.getProjectId().getProjectId());
            projectMilestone.setProjectAlias(master.getProjectId().getProjectAlias());
            projectMilestone.setMilestoneName(master.getMilestoneName());
            projectMilestone.setMilestoneDesc(master.getMilestoneDescription());
            projectMilestone.setCreatedOn(master.getCreatedOn());
            projectMilestone.setCreatedByName(userMap.get(master.getCreatedBy()));
            projectMilestone.setActualEndDate(master.getActualEndDate());
            projectMilestone.setCreatedBy(master.getCreatedBy());
            projectMilestone.setIsActive(master.getIsActive());
            projectMilestone.setLastModifiedBy(master.getLastModifiedBy());
            projectMilestone.setMilestoneEndDate(master.getEndDate());
            projectMilestone.setMilestoneStartDate(master.getStartDate());

            if (master.getIsActive() == true) {
                projectMilestone.setStatus("InActive");
            } else if (master.getIsActive() == false) {
                projectMilestone.setStatus("Active");
            }

            projectMilestoneDataBeans.add(projectMilestone);
        }
        return projectMilestoneDataBeans;
    }

    /**
     * Add new milestone to project
     *
     * @throws UMUserManagementException
     */
    public void addProjectMilestone() throws UMUserManagementException {

        ProjectMilestone projectMilestone = new ProjectMilestone();

        Project project = new Project();

        project.setProjectId(projectMilestoneDataBean.getProjectId());

        projectMilestone.setProjectId(project);
        projectMilestone.setMilestoneName(projectMilestoneDataBean.getMilestoneName());
        projectMilestone.setMilestoneDescription(projectMilestoneDataBean.getMilestoneDesc());
        projectMilestone.setStartDate(projectMilestoneDataBean.getMilestoneStartDate());
        projectMilestone.setEndDate(projectMilestoneDataBean.getMilestoneEndDate());

        projectMilestone.setCreatedBy(loginDataBean.getId());

        projectService.addMilestoneToProject(projectMilestone);

        projectMilestoneDataBean.setProjectId(null);
        projectMilestoneDataBean.setMilestoneName(null);
        projectMilestoneDataBean.setMilestoneDesc(null);
        projectMilestoneDataBean.setMilestoneStartDate(null);
        projectMilestoneDataBean.setMilestoneEndDate(null);
    }

    public void deleteRecord(ProjectMilestone projectMilestone) {
        projectService.deleteMilestone(projectMilestone);
    }

    /**
     * Get the details of milestone to edit
     */
    public void getProjectMilestone() {
        ProjectMilestone result = projectService.retrieveProjectMilestoneById(systemResultSessionUtil.getProjectMilestone_milestoneId());
        projectMilestoneDataBean.setProjectId(result.getProjectId().getProjectId());
        projectMilestoneDataBean.setMilestoneName(result.getMilestoneName());
        projectMilestoneDataBean.setMilestoneDesc(result.getMilestoneDescription());

        projectMilestoneDataBean.setMilestoneStartDate(result.getStartDate());
        projectMilestoneDataBean.setMilestoneEndDate(result.getEndDate());
        projectMilestoneDataBean.setIsActive(result.getIsActive());
        projectMilestoneDataBean.setActualEndDate(result.getActualEndDate());
        projectMilestoneDataBean.setLastModifiedBy(result.getLastModifiedBy());

        if (result.getIsActive() == true) {
            projectMilestoneDataBean.setStatus("Active");
        } else {
            projectMilestoneDataBean.setStatus("InActive");
        }
        systemResultSessionUtil.setProjectMilestone_createdBy(result.getCreatedBy());
        systemResultSessionUtil.setProjectMilestone_createdOn(result.getCreatedOn());
        systemResultSessionUtil.setProjectMilestone_milestoneId(result.getProjectMilestoneId());
    }

    /**
     * Update milestone details with new details
     *
     * @throws UMUserManagementException
     */
    public void updateProjectMilestone() throws UMUserManagementException {
        ProjectMilestone projectMilestone = convertMilestoneDataBeanToProjectMilestone(projectMilestoneDataBean);

        projectService.updateProjectMilestone(projectMilestone);
    }

    public void setActiveInactive(ProjectMilestoneDataBean milestoneToEdit) throws UMUserManagementException {

        ProjectMilestone projectMilestone = convertMilestoneDataBeanToProjectMilestone(milestoneToEdit);

        projectService.updateProjectMilestone(projectMilestone);
    }

    public ProjectMilestone convertMilestoneDataBeanToProjectMilestone(ProjectMilestoneDataBean projectMilestoneListForStatus) {
        ProjectMilestone projectMilestone = new ProjectMilestone();

        if (projectMilestoneListForStatus.getStatus() != null) {
            if ("InActive".equals(projectMilestoneListForStatus.getStatus())) {
                projectMilestone.setIsActive(Boolean.TRUE);
            } else {
                projectMilestone.setIsActive(Boolean.FALSE);
            }
        } else {

            projectMilestone.setIsActive(projectMilestoneListForStatus.isIsActive());
        }

        Project project = new Project();
        project.setProjectId(projectMilestoneListForStatus.getProjectId());

        projectMilestone.setProjectId(project);
        projectMilestone.setProjectMilestoneId(systemResultSessionUtil.getProjectMilestone_milestoneId());
        projectMilestone.setMilestoneName(projectMilestoneListForStatus.getMilestoneName());
        projectMilestone.setMilestoneDescription(projectMilestoneListForStatus.getMilestoneDesc());
        projectMilestone.setStartDate(projectMilestoneListForStatus.getMilestoneStartDate());
        projectMilestone.setEndDate(projectMilestoneListForStatus.getMilestoneEndDate());

        projectMilestone.setActualEndDate(projectMilestoneListForStatus.getActualEndDate());
        projectMilestone.setCreatedOn(systemResultSessionUtil.getProjectMilestone_createdOn());
        projectMilestone.setIsArchive(Boolean.FALSE);
        projectMilestone.setLastModifiedOn(Calendar.getInstance().getTime());
        projectMilestone.setCreatedBy(systemResultSessionUtil.getProjectMilestone_createdBy());

        projectMilestone.setLastModifiedBy(loginDataBean.getId());

        systemResultSessionUtil.setProjectMilestone_milestoneId(null);
        systemResultSessionUtil.setProjectMilestone_createdBy(null);
        systemResultSessionUtil.setProjectMilestone_createdOn(null);

        return projectMilestone;
    }

}
