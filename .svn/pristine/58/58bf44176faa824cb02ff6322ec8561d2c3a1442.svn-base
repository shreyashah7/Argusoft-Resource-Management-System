/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.transformerbean;

import com.argusoft.armms.core.ProjectService;
import com.argusoft.armms.model.ProjectRoles;
import com.argusoft.armms.web.databean.ProjectRolesDataBean;
import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import com.argusoft.armms.web.util.SystemConstantUtil;
import static com.argusoft.armms.web.util.SystemConstantUtil.ACTIVE;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author shreya
 */
@ManagedBean(name = "projectRolesTransformerBean")
@RequestScoped
public class ProjectRolesTransformerBean {

    @ManagedProperty("#{loginDataBean}")
    private LoginDataBean loginDataBean;

    @ManagedProperty("#{projectRolesDataBean}")
    private ProjectRolesDataBean projectRolesDataBean;

    @ManagedProperty(value = "#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;

    @ManagedProperty(value = "#{projectService}")
    private ProjectService projectService;

    @ManagedProperty(value = "#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;

    public LoginDataBean getLoginDataBean() {
        return loginDataBean;
    }

    public void setLoginDataBean(LoginDataBean loginDataBean) {
        this.loginDataBean = loginDataBean;
    }

    public SystemResultSessionUtil getSystemResultSessionUtil() {
        return systemResultSessionUtil;
    }

    public void setSystemResultSessionUtil(SystemResultSessionUtil systemResultSessionUtil) {
        this.systemResultSessionUtil = systemResultSessionUtil;
    }

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public ProjectRolesDataBean getProjectRolesDataBean() {
        return projectRolesDataBean;
    }

    public void setProjectRolesDataBean(ProjectRolesDataBean projectRolesDataBean) {
        this.projectRolesDataBean = projectRolesDataBean;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public ProjectRoles convertProjectRolesDataBeanToProjectRolesModel(ProjectRolesDataBean projectRolesDataBean, ProjectRoles projectRoles) {
        if (projectRoles == null) {
            projectRoles = new ProjectRoles();
        }
        try {
            projectRoles.setProjectRoleName(projectRolesDataBean.getProjectRolesName());
            projectRoles.setProjectRoleDescription(projectRolesDataBean.getProjectRolesDescription());
            projectRoles.setLastModifiedOn(Calendar.getInstance().getTime());
            projectRoles.setLastModifiedBy(loginDataBean.getId());
            if (projectRolesDataBean.getStatus() != null) {
                if (projectRolesDataBean.getStatus().equalsIgnoreCase(ACTIVE)) {
                    projectRoles.setIsActive(Boolean.TRUE);
                } else {
                    projectRoles.setIsActive(Boolean.FALSE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return projectRoles;
    }

    public ProjectRolesDataBean convertProjectRolesModelToProjectRolesDataBean(ProjectRoles projectRoles) {
        ProjectRolesDataBean projectRolesDataBean = new ProjectRolesDataBean();
        try {
            projectRolesDataBean.setProjectRolesId(projectRoles.getProjectRoleId());
            projectRolesDataBean.setProjectRolesName(projectRoles.getProjectRoleName());
            projectRolesDataBean.setProjectRolesDescription(projectRoles.getProjectRoleDescription());
            projectRolesDataBean.setCreatedOn(projectRoles.getCreatedOn());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return projectRolesDataBean;
    }

    public Long createRolesOfProject(ProjectRolesDataBean projectRolesDataBean) {
        ProjectRoles projectRoles = new ProjectRoles();
        projectRoles.setCreatedBy(loginDataBean.getId());
        projectRoles = convertProjectRolesDataBeanToProjectRolesModel(projectRolesDataBean, projectRoles);
        projectRoles.setIsActive(Boolean.TRUE);
        Long projectRolesId = projectService.createRolesOfProject(projectRoles);
        return projectRolesId;
    }

    public List<ProjectRolesDataBean> retrieveAllRolesOfProject(Boolean status) {
        List<ProjectRolesDataBean> projectRolesDataBeanList = new ArrayList<>();
        List<ProjectRoles> projectRolesList = projectService.retrieveAllRolesOfProject(status);
        for (ProjectRoles projectRolesElement : projectRolesList) {
            ProjectRolesDataBean projectRolesDataBeanVar = new ProjectRolesDataBean();
            projectRolesDataBeanVar = convertProjectRolesModelToProjectRolesDataBean(projectRolesElement);
            projectRolesDataBeanVar.setIsActive(projectRolesElement.getIsActive());
            if (projectRolesElement.getIsActive()) {
                projectRolesDataBeanVar.setStatus(SystemConstantUtil.ACTIVE);
            } else {
                projectRolesDataBeanVar.setStatus(SystemConstantUtil.INACTIVE);
            }
            projectRolesDataBeanList.add(projectRolesDataBeanVar);
        }
        return projectRolesDataBeanList;
    }

    public void updateRolesOfProject(ProjectRolesDataBean projectRolesDataBean) {
        ProjectRoles projectRoles = projectService.retrieveRoleOfProjectById(systemResultSessionUtil.getProjectRolesId());
        projectRoles = convertProjectRolesDataBeanToProjectRolesModel(projectRolesDataBean, projectRoles);
        projectRoles.setProjectRoleId(systemResultSessionUtil.getProjectRolesId());
        projectService.updateRolesOfProject(projectRoles);
        systemResultSessionUtil.setProjectRolesId(null);
    }

    public ProjectRolesDataBean retrieveRoleOfProjectById(Long projectRoleId) {
        ProjectRoles projectRoles = projectService.retrieveRoleOfProjectById(projectRoleId);
        systemResultSessionUtil.setProjectRolesId(projectRoles.getProjectRoleId());
        projectRolesDataBean.setProjectRolesName(projectRoles.getProjectRoleName());
        projectRolesDataBean.setProjectRolesDescription(projectRoles.getProjectRoleDescription());
        projectRolesDataBean.setProjectRolesId(projectRoles.getProjectRoleId());
        if (projectRoles.getIsActive().equals(Boolean.FALSE)) {
            projectRolesDataBean.setStatus(SystemConstantUtil.INACTIVE);
        } else {
            projectRolesDataBean.setStatus(SystemConstantUtil.ACTIVE);
        }
        return projectRolesDataBean;
    }

}
