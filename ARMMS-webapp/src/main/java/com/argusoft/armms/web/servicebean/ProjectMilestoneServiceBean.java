/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.servicebean;

import com.argusoft.armms.model.ProjectMilestone;
import com.argusoft.armms.web.databean.ProjectMilestoneDataBean;
import com.argusoft.armms.web.transformerbean.ProjectMilestoneTransformerBean;
import com.argusoft.armms.web.usermanagement.databean.MessageDataBean;
import com.argusoft.armms.web.util.SystemConstantUtil;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author rajkumar
 */
@ManagedBean(name = "projectMilestoneServiceBean")
@RequestScoped
public class ProjectMilestoneServiceBean {

    @ManagedProperty("#{projectMilestoneTransformerBean}")
    private ProjectMilestoneTransformerBean projectMilestoneTransformerBean;

    @ManagedProperty("#{projectMilestoneDataBean}")
    private ProjectMilestoneDataBean projectMilestoneDataBean;

    @ManagedProperty("#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;

    @ManagedProperty("#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;

    @ManagedProperty("#{messageDataBean}")
    private MessageDataBean messageDataBean;

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    public ProjectMilestoneDataBean getProjectMilestoneDataBean() {
        return projectMilestoneDataBean;
    }

    public void setProjectMilestoneDataBean(ProjectMilestoneDataBean projectMilestoneDataBean) {
        this.projectMilestoneDataBean = projectMilestoneDataBean;
    }

    public ProjectMilestoneTransformerBean getProjectMilestoneTransformerBean() {
        return projectMilestoneTransformerBean;
    }

    public void setProjectMilestoneTransformerBean(ProjectMilestoneTransformerBean projectMilestoneTransformerBean) {
        this.projectMilestoneTransformerBean = projectMilestoneTransformerBean;
    }

    public MessageDataBean getMessageDataBean() {
        return messageDataBean;
    }

    public void setMessageDataBean(MessageDataBean messageDataBean) {
        this.messageDataBean = messageDataBean;
    }

    public SystemResultSessionUtil getSystemResultSessionUtil() {
        return systemResultSessionUtil;
    }

    public void setSystemResultSessionUtil(SystemResultSessionUtil systemResultSessionUtil) {
        this.systemResultSessionUtil = systemResultSessionUtil;
    }

    public void initprojectNames() {

        systemResultViewUtil.setProjectNames(projectMilestoneTransformerBean.retrieveAllProjects());

    }

    public void initprojectMilestoneDetails() throws UMUserManagementException {

        systemResultViewUtil.setProjectMilestoneDetails(projectMilestoneTransformerBean.retrieveAllMilestones(true));
        systemResultViewUtil.setShowDropdown(!projectMilestoneTransformerBean.retrieveAllMilestones(null).isEmpty());
//
//        if (!systemResultViewUtil.isShowDropdown()) {
//            messageDataBean.setIsSuccess(Boolean.FALSE);
//            messageDataBean.setMessage("Milestone not found");
//        }

    }

    public void showAllMilestones() throws UMUserManagementException {
        if ((SystemConstantUtil.ACTIVE).equals(systemResultViewUtil.getShowMilestoneType())) {
            systemResultViewUtil.setProjectMilestoneDetails(projectMilestoneTransformerBean.retrieveAllMilestones(true));
        } else if ((SystemConstantUtil.INACTIVE).equals(systemResultViewUtil.getShowMilestoneType())) {
            systemResultViewUtil.setProjectMilestoneDetails(projectMilestoneTransformerBean.retrieveAllMilestones(false));
        } else if ((SystemConstantUtil.SHOWALL).equals(systemResultViewUtil.getShowMilestoneType())) {
            systemResultViewUtil.setProjectMilestoneDetails(projectMilestoneTransformerBean.retrieveAllMilestones(null));
        }

    }

    public void addProjectMilestone() throws UMUserManagementException {
        try {
            projectMilestoneTransformerBean.addProjectMilestone();
            messageDataBean.setIsSuccess(Boolean.TRUE);
            messageDataBean.setMessage("Milestone Added successfully.");
            systemResultViewUtil.setShowDropdown(true);
            showAllMilestones();
        } catch (Exception e) {
            messageDataBean.setIsSuccess(Boolean.FALSE);
            messageDataBean.setMessage("Milestone not added!!");
        }
    }

    public String setEditable(ProjectMilestone projectMilestone) {
        projectMilestoneDataBean.setProjectId(projectMilestone.getProjectId().getProjectId());
        projectMilestoneDataBean.setMilestoneName(projectMilestone.getMilestoneName());
        return "editProjectMilestone";

    }

    public void deleteRecord(ProjectMilestone projectMilestone) {
        projectMilestoneTransformerBean.deleteRecord(projectMilestone);
    }

    public void getProjectDetails() {
        projectMilestoneTransformerBean.getProjectMilestone();

    }

    public void updateProjectMilestone() throws UMUserManagementException {
        try {
            projectMilestoneTransformerBean.updateProjectMilestone();
            messageDataBean.setIsSuccess(Boolean.TRUE);
            messageDataBean.setMessage("Milestone updated successfully.");
            showAllMilestones();
        } catch (Exception e) {
            messageDataBean.setIsSuccess(Boolean.FALSE);
            messageDataBean.setMessage("Milestone not updated!!");
        }
    }

    public void setActiveInactive(ProjectMilestoneDataBean projectMilestoneListForStatus) throws UMUserManagementException {
        if (projectMilestoneListForStatus.getStatus().equalsIgnoreCase("Active")) {
            projectMilestoneListForStatus.setStatus("InActive");
        } else {
            projectMilestoneListForStatus.setStatus("Active");
        }

        systemResultSessionUtil.setProjectMilestone_milestoneId(projectMilestoneListForStatus.getProjectMilestoneId());
        systemResultSessionUtil.setProjectMilestone_createdOn(projectMilestoneListForStatus.getCreatedOn());
        systemResultSessionUtil.setProjectMilestone_createdBy(projectMilestoneListForStatus.getCreatedBy());
        try {
            projectMilestoneTransformerBean.setActiveInactive(projectMilestoneListForStatus);
            messageDataBean.setIsSuccess(Boolean.TRUE);
            messageDataBean.setMessage("Status changed successfully");
        } catch (Exception e) {
            messageDataBean.setIsSuccess(Boolean.FALSE);
            messageDataBean.setMessage("Error while changing status");
        }
        this.showAllMilestones();
    }
}
