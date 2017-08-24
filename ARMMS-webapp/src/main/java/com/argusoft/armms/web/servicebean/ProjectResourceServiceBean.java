/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.servicebean;

import com.argusoft.armms.web.databean.ProjectResourceDataBean;
import com.argusoft.armms.web.transformerbean.ProjectResourceTransformerBean;
import com.argusoft.armms.web.usermanagement.databean.MessageDataBean;
import com.argusoft.armms.web.util.SystemConstantUtil;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.generic.database.exception.GenericDatabaseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * This class is to perform allocation of resources to project.
 *
 * @author niharika
 */
@ManagedBean(name = "projectResourceServiceBean")
@RequestScoped
public class ProjectResourceServiceBean {

    @ManagedProperty("#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;
    @ManagedProperty("#{projectResourceTransformerBean}")
    private ProjectResourceTransformerBean projectResourceTransformerBean;
    @ManagedProperty("#{projectResourceDataBean}")
    private ProjectResourceDataBean projectResourceDataBean;
    @ManagedProperty("#{messageDataBean}")
    private MessageDataBean messageDataBean;
    @ManagedProperty("#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;

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

    public ProjectResourceTransformerBean getProjectResourceTransformerBean() {
        return projectResourceTransformerBean;
    }

    public void setProjectResourceTransformerBean(ProjectResourceTransformerBean projectResourceTransformerBean) {
        this.projectResourceTransformerBean = projectResourceTransformerBean;
    }

    public ProjectResourceDataBean getProjectResourceDataBean() {
        return projectResourceDataBean;
    }

    public void setProjectResourceDataBean(ProjectResourceDataBean projectResourceDataBean) {
        this.projectResourceDataBean = projectResourceDataBean;
    }

    public MessageDataBean getMessageDataBean() {
        return messageDataBean;
    }

    public void setMessageDataBean(MessageDataBean messageDataBean) {
        this.messageDataBean = messageDataBean;
    }

    public void cleanDataBean() {
        projectResourceDataBean.setBrowserIds(null);
        projectResourceDataBean.setTechIds(null);
        projectResourceDataBean.setToolIds(null);
        projectResourceDataBean.setUserIds(null);
        projectResourceDataBean.setOsIds(null);
        projectResourceDataBean.setServerIds(null);
        projectResourceDataBean.setProjectId(null);
        systemResultViewUtil.setProjectId(null);
        systemResultViewUtil.setRoleType(null);

    }

    public void init() {
        if (systemResultViewUtil.getProjectId() == null || !systemResultViewUtil.getProjectId().equals(systemResultSessionUtil.getSelectedProjectId())) {
            systemResultViewUtil.setProjectId(systemResultSessionUtil.getSelectedProjectId());
        }

    }

    /**
     * addResourcesToProject adds the selected resources to project.
     */
    public void addResourcesToProject() throws GenericDatabaseException {
        List<Long> techid = new ArrayList<>();
        List<Long> userIds = projectResourceDataBean.getUserIds();
        //merging Ids of browser,server,OS,tools and technology into one list techid.
        techid.addAll(projectResourceDataBean.getBrowserIds());
        techid.addAll(projectResourceDataBean.getOsIds());
        techid.addAll(projectResourceDataBean.getServerIds());
        techid.addAll(projectResourceDataBean.getTechIds());
        techid.addAll(projectResourceDataBean.getToolIds());
        String result = projectResourceTransformerBean.addResourcesToProject(projectResourceDataBean, userIds, null);

        this.cleanDataBean();
        if (result.equalsIgnoreCase(SystemConstantUtil.FAILURE)) {
            messageDataBean.setIsSuccess(Boolean.FALSE);
            messageDataBean.setMessage("Please select resources first.");
        } else if (result.equalsIgnoreCase(SystemConstantUtil.SUCCESS)) {
            messageDataBean.setMessage("Resources successfully allocated to project.");
            messageDataBean.setIsSuccess(Boolean.TRUE);
        }

    }

    /**
     * @author Brijesh Patel
     * @throws GenericDatabaseException
     */
    public void retrieveProjectResources() throws GenericDatabaseException {
        if (systemResultViewUtil.getProjectId() != null && systemResultViewUtil.getRoleType() != null && !systemResultViewUtil.getRoleType().equals(-1l)) {
            systemResultViewUtil.setAllProjectResources(projectResourceTransformerBean.retrieveResourcesOfProjectByRoleType(systemResultViewUtil.getProjectId(), systemResultViewUtil.getRoleType()));
        } else if (systemResultViewUtil.getProjectId() != null && !systemResultViewUtil.getProjectId().equals(-1l) && (systemResultViewUtil.getRoleType() == null || systemResultViewUtil.getRoleType().equals(-1l))) {
            this.retrieveAllProjectResources();
        } else if (systemResultViewUtil.getProjectId() != null && systemResultViewUtil.getProjectId().equals(-1l)) {
            systemResultViewUtil.setAllProjectResources(null);
            systemResultViewUtil.setProjectResourceList(null);
            this.cleanDataBean();
        }
    }

    /**
     * @author Niharika
     */
    public void assignResourcesOfProject() throws GenericDatabaseException {

        List<Long> techid = new ArrayList<Long>();
        if (projectResourceDataBean.getBrowserIds() != null) {
            techid.addAll(projectResourceDataBean.getBrowserIds());
        }
        if (projectResourceDataBean.getOsIds() != null) {
            techid.addAll(projectResourceDataBean.getOsIds());
        }
        if (projectResourceDataBean.getServerIds() != null) {
            techid.addAll(projectResourceDataBean.getServerIds());
        }
        if (projectResourceDataBean.getTechIds() != null) {
            techid.addAll(projectResourceDataBean.getTechIds());
        }
        if (projectResourceDataBean.getToolIds() != null) {
            techid.addAll(projectResourceDataBean.getToolIds());
        }
        String result = projectResourceTransformerBean.assignResourcesOfProject(systemResultViewUtil.getProjectId(), projectResourceDataBean.getUserIds(), techid, systemResultViewUtil.getRoleType());
        this.cleanDataBean();
        if (result.equalsIgnoreCase(SystemConstantUtil.FAILURE)) {
            messageDataBean.setIsSuccess(Boolean.FALSE);
            messageDataBean.setMessage("Please select resources first.");
        } else if (result.equalsIgnoreCase(SystemConstantUtil.SUCCESS)) {
            messageDataBean.setMessage("Resources and roles assigned successfully.");
            messageDataBean.setIsSuccess(Boolean.TRUE);
        }
    }

    /**
     * @author Brijesh Patel
     */
    public void retrieveProjectResourceById() {
        ProjectResourceDataBean projectResource = projectResourceTransformerBean.retrieveProjectResourceById(projectResourceDataBean.getProjectResourceId());
        projectResourceDataBean.setProjectResourceId(projectResource.getProjectResourceId());
        projectResourceDataBean.setRoleType(projectResource.getRoleType());
    }

    /**
     * @author Brijesh Patel
     * @throws GenericDatabaseException
     */
    public void updateProjectResourceById() throws GenericDatabaseException {
        projectResourceTransformerBean.updateProjectResourceById(projectResourceDataBean);
        this.retrieveAllProjectResources();
        messageDataBean.setMessage("Role Assigned successfully");
        messageDataBean.setIsSuccess(Boolean.TRUE);
    }

    /**
     * @author Brijesh Patel
     */
    public void retrieveAllProjectRoles() {
        systemResultViewUtil.setProjectRolesDataBeanList(projectResourceTransformerBean.retrieveAllProjectRoles());
    }

    /**
     * @author Brijesh Patel
     * @throws GenericDatabaseException
     */
    public void retrieveAllProjectResources() throws GenericDatabaseException {
        systemResultViewUtil.setProjectResourceList(projectResourceTransformerBean.retrieveAllResourcesOfProject(systemResultViewUtil.getProjectId()));
        projectResourceTransformerBean.retrieveAllTechnologiesOfProject(systemResultViewUtil.getProjectId());
    }
}
