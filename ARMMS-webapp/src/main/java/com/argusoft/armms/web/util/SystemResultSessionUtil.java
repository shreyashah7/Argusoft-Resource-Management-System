/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.util;

import com.argusoft.armms.core.ProjectService;
import com.argusoft.armms.model.Project;
import com.argusoft.armms.web.databean.ActivityDataBean;
import com.argusoft.armms.web.databean.FolderDataBean;
import com.argusoft.armms.web.databean.MasterActivityDataBean;
import com.argusoft.armms.web.databean.ProjectDataBean;
import com.argusoft.armms.web.databean.ProjectResourceDataBean;
import com.argusoft.armms.web.databean.TaskDataBean;
import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.imageio.ImageIO;

/**
 * for the data to be stored in session scope in system
 *
 * @author shreya
 */
@ManagedBean(name = "systemResultSessionUtil")
@SessionScoped
public class SystemResultSessionUtil implements Serializable {

    private Boolean active;
    private Long id;
    private Long userId;
    private String userName;
    private Long techId;
    private Date projectMilestone_createdOn;
    private Long projectMilestone_createdBy;
    private Long projectMilestone_milestoneId;
    private Long projectMilestone_projectId;
    private Long projectId;
    private Long projectsId;
    private Long projectRolesId;
    private String result;
    private String projectResult;
    private String imageFilePath;
    private String activityId;
    private String activityType;
    private Long SvnDetailId;
    private Long notificationId;
    private List<FolderDataBean> dataList = new ArrayList();
    private Long projectIdForSvnRepository;
    private Long roleIdToUpdate;
    private Long projectIdForProjectSummary;
    private String taskIdForTaskView;
    private List<ActivityDataBean> activityDataBeanList;
    private List<MasterActivityDataBean> masterActivityDataBean;
    private Long permissionIDToRemove;
    private String roleNameToRemove;
    private String checkFlag;
    private String searchString;
    private List<ProjectDataBean> userProjects;
    private Long selectedProjectId;
    private Long watchId;
    private Long commentId;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
    

    public List<ProjectDataBean> getUserProjects() {
        return userProjects;
    }

    public void setUserProjects(List<ProjectDataBean> userProjects) {
        this.userProjects = userProjects;
    }

    public Long getWatchId() {
        return watchId;
    }

    public void setWatchId(Long watchId) {
        this.watchId = watchId;
    }

    public Long getSelectedProjectId() {
        return selectedProjectId;
    }

    public void setSelectedProjectId(Long selectedProjectId) {
        this.selectedProjectId = selectedProjectId;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
    private Long roleMemberId;

    public Long getRoleMemberId() {
        return roleMemberId;
    }

    public void setRoleMemberId(Long roleMemberId) {
        this.roleMemberId = roleMemberId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPermissionIDToRemove() {
        return permissionIDToRemove;
    }

    public String getRoleNameToRemove() {
        return roleNameToRemove;
    }

    public Long getProjectRolesId() {
        return projectRolesId;
    }

    public void setProjectRolesId(Long projectRolesId) {
        this.projectRolesId = projectRolesId;
    }

    public void setRoleNameToRemove(String roleNameToRemove) {
        this.roleNameToRemove = roleNameToRemove;
    }

    public void setPermissionIDToRemove(Long permissionIDToRemove) {
        this.permissionIDToRemove = permissionIDToRemove;
    }

    public String getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(String checkFlag) {
        this.checkFlag = checkFlag;
    }

    public Long getProjectIdForProjectSummary() {
        return projectIdForProjectSummary;
    }

    public void setProjectIdForProjectSummary(Long projectIdForProjectSummary) {
        this.projectIdForProjectSummary = projectIdForProjectSummary;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getProjectIdForSvnRepository() {
        return projectIdForSvnRepository;
    }

    public List<ActivityDataBean> getActivityDataBeanList() {
        return activityDataBeanList;
    }

    public void setActivityDataBeanList(List<ActivityDataBean> activityDataBeanList) {
        this.activityDataBeanList = activityDataBeanList;
    }

    public List<MasterActivityDataBean> getMasterActivityDataBean() {
        return masterActivityDataBean;
    }

    public void setMasterActivityDataBean(List<MasterActivityDataBean> masterActivityDataBean) {
        this.masterActivityDataBean = masterActivityDataBean;
    }

    public void setProjectIdForSvnRepository(Long projectIdForSvnRepository) {
        this.projectIdForSvnRepository = projectIdForSvnRepository;
    }

    public List<FolderDataBean> getDataList() {
        return dataList;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public void setDataList(List<FolderDataBean> dataList) {
        this.dataList = dataList;
    }

    public Long getSvnDetailId() {
        return SvnDetailId;
    }

    public void setSvnDetailId(Long SvnDetailId) {
        this.SvnDetailId = SvnDetailId;
    }

    public String getImageFilePath() {
        return imageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String success) {
        this.result = success;
    }

    public String getProjectResult() {
        return projectResult;
    }

    public void setProjectResult(String projectResult) {
        this.projectResult = projectResult;
    }

    public Long getTechId() {
        return techId;
    }

    public void setTechId(Long techId) {
        this.techId = techId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectMilestone_projectId() {
        return projectMilestone_projectId;
    }

    public void setProjectMilestone_projectId(Long projectMilestone_projectId) {
        this.projectMilestone_projectId = projectMilestone_projectId;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getProjectMilestone_createdOn() {
        return projectMilestone_createdOn;
    }

    public void setProjectMilestone_createdOn(Date projectMilestone_createdOn) {
        this.projectMilestone_createdOn = projectMilestone_createdOn;
    }

    public Long getProjectMilestone_createdBy() {
        return projectMilestone_createdBy;
    }

    public void setProjectMilestone_createdBy(Long projectMilestone_createdBy) {
        this.projectMilestone_createdBy = projectMilestone_createdBy;
    }

    public Long getProjectMilestone_milestoneId() {
        return projectMilestone_milestoneId;
    }

    public void setProjectMilestone_milestoneId(Long projectMilestone_milestoneId) {
        this.projectMilestone_milestoneId = projectMilestone_milestoneId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public Long getProjectsId() {
        return projectsId;
    }

    public void setProjectsId(Long projectsId) {
        this.projectsId = projectsId;
    }

    public String getTaskIdForTaskView() {
        return taskIdForTaskView;
    }

    public void setTaskIdForTaskView(String taskIdFrorTaskView) {
        this.taskIdForTaskView = taskIdFrorTaskView;
    }

    public void drawImage(OutputStream out, Object data) throws IOException {

        if ((data instanceof String) && data != null) {
            String imageName = data.toString();

            BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);

            if (imageName == null || imageName.trim().length() <= 0) {
//                System.out.println("Image Name not found");
            } else {

                System.out.println("File Found ");
                String extension = imageName.substring(imageName.lastIndexOf(".") + 1);
                System.out.println("extension+++++" + extension);
                java.io.File file = new java.io.File(imageName);
                System.out.println("++++file name++" + imageName);
                if (file != null && file.exists()) {
                    img = ImageIO.read(file);
                    ImageIO.write(img, extension, out);
                } else {
                    System.out.println("file not found....");
                }
            }
        } else {
        }
    }

    @Override
    public String toString() {
        return "SystemResultSessionUtil{" + '}';
    }

    public Long getRoleIdToUpdate() {
        return roleIdToUpdate;
    }

    public void setRoleIdToUpdate(Long roleIdToUpdate) {
        this.roleIdToUpdate = roleIdToUpdate;
    }

}
