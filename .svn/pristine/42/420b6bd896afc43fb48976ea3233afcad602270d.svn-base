/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.servicebean;

import com.argusoft.armms.web.databean.ProjectDataBean;
import com.argusoft.armms.web.databean.SvnDataBean;
import com.argusoft.armms.web.transformerbean.ProjectTransformerBean;
import com.argusoft.armms.web.transformerbean.SvnTransformerBean;
import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.generic.database.exception.GenericDatabaseException;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * Service Bean For SVN
 *
 * @author ravi
 */
@ManagedBean(name = "svnServiceBean")
@RequestScoped
public class SvnServiceBean {

    @ManagedProperty("#{svnDataBean}")
    private SvnDataBean taskDataBean;

    @ManagedProperty("#{svnTransformerBean}")
    private SvnTransformerBean svnTransformerBean;

    @ManagedProperty("#{projectDataBean}")
    private ProjectDataBean projectDataBean;

    @ManagedProperty("#{projectTransformerBean}")
    private ProjectTransformerBean projectTransformerBean;

    @ManagedProperty("#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;

    @ManagedProperty("#{loginDataBean}")
    private LoginDataBean loginDataBean;

    @ManagedProperty("#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;

    public SystemResultSessionUtil getSystemResultSessionUtil() {
        return systemResultSessionUtil;
    }

    public void setSystemResultSessionUtil(SystemResultSessionUtil systemResultSessionUtil) {
        this.systemResultSessionUtil = systemResultSessionUtil;
    }

    public LoginDataBean getLoginDataBean() {
        return loginDataBean;
    }

    public void setLoginDataBean(LoginDataBean loginDataBean) {
        this.loginDataBean = loginDataBean;
    }

    public SvnDataBean getTaskDataBean() {
        return taskDataBean;
    }

    public void setTaskDataBean(SvnDataBean taskDataBean) {
        this.taskDataBean = taskDataBean;
    }

    public SvnTransformerBean getSvnTransformerBean() {
        return svnTransformerBean;
    }

    public void setSvnTransformerBean(SvnTransformerBean svnTransformerBean) {
        this.svnTransformerBean = svnTransformerBean;
    }

    public ProjectDataBean getProjectDataBean() {
        return projectDataBean;
    }

    public void setProjectDataBean(ProjectDataBean projectDataBean) {
        this.projectDataBean = projectDataBean;
    }

    public ProjectTransformerBean getProjectTransformerBean() {
        return projectTransformerBean;
    }

    public void setProjectTransformerBean(ProjectTransformerBean projectTransformerBean) {
        this.projectTransformerBean = projectTransformerBean;
    }

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    /**
     * retrieves all active projects of particular user and update the database.
     *
     * @author ravi
     * @throws UMUserManagementException
     */
    public void populateRepository() throws UMUserManagementException, GenericDatabaseException {
        
        List<ProjectDataBean> ActiveProjectsOfUser=new ArrayList<>();
        
        if (loginDataBean.getRole().equals("ROLE_SADMIN")) {
            ActiveProjectsOfUser = projectTransformerBean.retrieveAllActiveAndInActiveProjects(Boolean.TRUE);            
        } else {
            ActiveProjectsOfUser = projectTransformerBean.retrieveAllActiveProjectsOfUser(loginDataBean.getId());
        }
        systemResultSessionUtil.setUserProjects(ActiveProjectsOfUser);
       

        if (!ActiveProjectsOfUser.isEmpty()) {
            if (systemResultSessionUtil.getSelectedProjectId() != null) {
                systemResultSessionUtil.setProjectIdForSvnRepository(systemResultSessionUtil.getSelectedProjectId());
            }
        }
    }

    /**
     * @author ravi retrieves the projectId from systemResultSessionUtil and
     * sets the details in systemResultViewUtil svnDataList
     */
    public void populateSvnDataList() {
        Long projectId = systemResultSessionUtil.getProjectIdForSvnRepository();
        if (projectId != null) {
            systemResultSessionUtil.setSelectedProjectId(projectId);
            systemResultViewUtil.setSvnDataList(svnTransformerBean.retrieveSvnDataByProjectId(projectId));

        } else {
            systemResultSessionUtil.setSelectedProjectId(null);
            systemResultViewUtil.setSvnDataList(new ArrayList<SvnDataBean>());
        }
    }

    /**
     * @author ravi retrieves the task id from systemResultSessionUtil and sets
     * the details in systemResultViewUtil svnDataList
     */
    public void populateSvnDataListForTask() {
        String taskId = systemResultSessionUtil.getTaskIdForTaskView();
        if (taskId != null) {
            systemResultViewUtil.setSvnDataList(svnTransformerBean.retrieveSvnDataByTaskId(taskId));
        }
    }

}
