/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.transformerbean;

import com.argusoft.armms.core.NotificationService;
import com.argusoft.armms.core.ProjectService;
import com.argusoft.armms.core.TaskService;
import com.argusoft.armms.core.WatcherService;
import com.argusoft.armms.model.Project;
import com.argusoft.armms.model.SystemNotificationMaster;
import com.argusoft.armms.model.TaskMaster;
import com.argusoft.armms.model.Watcher;
import com.argusoft.armms.web.databean.NotificationDataBean;
import com.argusoft.armms.web.databean.ProjectDataBean;
import com.argusoft.armms.web.databean.TaskDataBean;
import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import com.argusoft.armms.web.usermanagement.databean.UserDataBean;
import static com.argusoft.armms.web.util.SystemConstantUtil.PROJECT;
import static com.argusoft.armms.web.util.SystemConstantUtil.TASK;
import static com.argusoft.armms.web.util.SystemConstantUtil.WATCHER;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.usermanagement.common.core.UMUserService;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import com.argusoft.usermanagement.common.model.UMUser;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.apache.commons.collections.CollectionUtils;

/**
 * methods for notifications in the system
 *
 * @author shreya
 */
@ManagedBean(name = "notificationTransformerBean")
@RequestScoped
public class NotificationTransformerBean {

    private static final Logger LOGGER = Logger.getLogger(NotificationTransformerBean.class.getName());

    @ManagedProperty(value = "#{loginDataBean}")
    private LoginDataBean loginDataBean;

    @ManagedProperty(value = "#{userDataBean}")
    private UserDataBean userDataBean;

    @ManagedProperty(value = "#{projectDataBean}")
    private ProjectDataBean projectDataBean;

    @ManagedProperty(value = "#{notificationDataBean}")
    private NotificationDataBean notificationDataBean;

    @ManagedProperty(value = "#{taskDataBean}")
    private TaskDataBean taskDataBean;

    @ManagedProperty(value = "#{notificationService}")
    private NotificationService notificationService;

    @ManagedProperty(value = "#{userService}")
    private UMUserService userService;

    @ManagedProperty(value = "#{watcherService}")
    private WatcherService watcherService;

    @ManagedProperty(value = "#{taskService}")
    private TaskService taskService;

    @ManagedProperty(value = "#{projectService}")
    private ProjectService projectService;

    @ManagedProperty("#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;

    @ManagedProperty("#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;

    public ProjectDataBean getProjectDataBean() {
        return projectDataBean;
    }

    public void setProjectDataBean(ProjectDataBean projectDataBean) {
        this.projectDataBean = projectDataBean;
    }

    public LoginDataBean getLoginDataBean() {
        return loginDataBean;
    }

    public void setLoginDataBean(LoginDataBean loginDataBean) {
        this.loginDataBean = loginDataBean;
    }

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    public WatcherService getWatcherService() {
        return watcherService;
    }

    public void setWatcherService(WatcherService watcherService) {
        this.watcherService = watcherService;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public NotificationDataBean getNotificationDataBean() {
        return notificationDataBean;
    }

    public void setNotificationDataBean(NotificationDataBean notificationDataBean) {
        this.notificationDataBean = notificationDataBean;
    }

    public SystemResultSessionUtil getSystemResultSessionUtil() {
        return systemResultSessionUtil;
    }

    public void setSystemResultSessionUtil(SystemResultSessionUtil systemResultSessionUtil) {
        this.systemResultSessionUtil = systemResultSessionUtil;
    }

    public UMUserService getUserService() {
        return userService;
    }

    public TaskDataBean getTaskDataBean() {
        return taskDataBean;
    }

    public void setTaskDataBean(TaskDataBean taskDataBean) {
        this.taskDataBean = taskDataBean;
    }

    public void setUserService(UMUserService userService) {
        this.userService = userService;
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public UserDataBean getUserDataBean() {
        return userDataBean;
    }

    public void setUserDataBean(UserDataBean userDataBean) {
        this.userDataBean = userDataBean;
    }

    /**
     * retrieveAllNotificationsByUserId method retrieves the
     * SystemNotificationMaster Object, by calling
     * retrieveAllNotificationsByUserId method of its service. It calls the
     * service of notification which uses userId and onDate as param.
     *
     * @return Returns the List of Object of Class NotificationDataBean.
     */
    public List<NotificationDataBean> retrieveAllNotificationsByUserId() throws UMUserManagementException {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.HOUR, 0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.MILLISECOND, 0);
        List<NotificationDataBean> notificationDataBeanList = new ArrayList<>();
        List<String> taskIDs = new ArrayList<>();
        List<Long> projectsIDs = new ArrayList<>();
        List<Long> userIds = new ArrayList<>();
        List<Long> watcherIds = new ArrayList<>();
        List<SystemNotificationMaster> systemNotificationMasterList = notificationService.retrieveAllNotificationsByUserId(loginDataBean.getId(), instance.getTime(), null, null);
        if (!CollectionUtils.isEmpty(systemNotificationMasterList)) {
            for (SystemNotificationMaster systemNotificationMasterElement : systemNotificationMasterList) {
                String featureType = systemNotificationMasterElement.getFeatureType();
                String featureId = systemNotificationMasterElement.getFeatureId();
                switch (featureType) {
                    case TASK:
                        taskIDs.add(featureId);
                        break;
                    case PROJECT:
                        projectsIDs.add(Long.parseLong(featureId));
                        break;
                    case WATCHER:
                        watcherIds.add(Long.parseLong(featureId));
                        break;
                    default:
                        userIds.add(Long.parseLong(featureId));
                        break;
                }
            }
            Map<String, TaskMaster> taskMap = new HashMap<>();
            Map<Long, Project> projectMap = new HashMap<>();
            Map<Long, UMUser> userMap = new HashMap<>();
            Map<Long, Watcher> watcherMap = new HashMap<>();
            if (!CollectionUtils.isEmpty(taskIDs)) {
                List<TaskMaster> taskList = taskService.retrieveAllTaskByIds("taskId", taskIDs);
                for (TaskMaster taskobj : taskList) {
                    taskMap.put(taskobj.getTaskId(), taskobj);
                }
            }
            if (!CollectionUtils.isEmpty(projectsIDs)) {
                List<Project> projectList = projectService.retrieveAllProjectByIds("projectId", projectsIDs);
                for (Project projobj : projectList) {
                    projectMap.put(projobj.getProjectId(), projobj);
                }
            }
            if (!CollectionUtils.isEmpty(userIds)) {
                List<UMUser> userList = userService.retrieveUsersByUserList(userIds, null, null, null, Boolean.TRUE);
                for (UMUser userobj : userList) {
                    userMap.put(userobj.getId(), userobj);
                }
            }
            if (!CollectionUtils.isEmpty(watcherIds)) {
                List<Watcher> watchList = watcherService.retrieveAllWatcherByIds("watchId", watcherIds);
                for (Watcher watcherObj : watchList) {
                    watcherMap.put(watcherObj.getWatchId(), watcherObj);
                }
            }
            for (SystemNotificationMaster systemNotificationMasterElement : systemNotificationMasterList) {
                NotificationDataBean notificationDataBeanElement = new NotificationDataBean();
                notificationDataBeanElement.setNotificationId(systemNotificationMasterElement.getNotificationId());
                String featureId = systemNotificationMasterElement.getFeatureId();
                switch (systemNotificationMasterElement.getFeatureType()) {
                    case TASK:
                        if (!taskMap.isEmpty()) {
                            notificationDataBeanElement.setFeatureName((taskMap.get((featureId))).getTaskName());
                            notificationDataBeanElement.setFeatureDesc((taskMap.get((featureId))).getTaskDescription());
                        }
                        break;
                    case PROJECT:
                        if (!projectMap.isEmpty()) {
                            notificationDataBeanElement.setFeatureName((projectMap.get(Long.parseLong(featureId))).getProjectName());
                            notificationDataBeanElement.setFeatureDesc((projectMap.get(Long.parseLong(featureId))).getProjectDescription());
                        }
                        break;
                    case WATCHER:
                        if (!watcherMap.isEmpty()) {
                            notificationDataBeanElement.setFeatureName("Watcher");
                            notificationDataBeanElement.setFeatureDesc("Watcher for" + (watcherMap.get(Long.parseLong(featureId))).getTaskId().getTaskDescription());
                        }
                    default:
                        if (!userMap.isEmpty()) {
                            notificationDataBeanElement.setFeatureName((userMap.get(Long.parseLong(featureId))).getFirstName());
                        }
                        break;
                }
                notificationDataBeanElement.setFeatureType(systemNotificationMasterElement.getFeatureType());
                notificationDataBeanElement.setIsActive(systemNotificationMasterElement.getIsActive());
                notificationDataBeanElement.setLastModifiedOn(systemNotificationMasterElement.getLastModifiedOn());
                notificationDataBeanElement.setNotificationOnDate(systemNotificationMasterElement.getNotificationOnDate());
                notificationDataBeanElement.setNotificationSubject(systemNotificationMasterElement.getNotificationSubject());
                notificationDataBeanList.add(notificationDataBeanElement);
            }
        }
        return notificationDataBeanList;
    }

    /**
     * displayNotificationById uses retrieveNotificationById which returns the
     * Object of class SystemNotificationMaster.
     *
     * @param notificationId is given to service method retrieveNotificationById
     * @throws
     * com.argusoft.usermanagement.common.exception.UMUserManagementException
     */
    public void displayNotificationById(Long notificationId) throws UMUserManagementException {
        SystemNotificationMaster displayNotification = notificationService.retrieveNotificationById(notificationId);
        notificationDataBean.setFeatureType(displayNotification.getFeatureType());
        LOGGER.log(Level.INFO, "feature name : " + displayNotification.getFeatureType());
        switch (displayNotification.getFeatureType()) {
            case TASK:
                TaskMaster taskMasterObj = taskService.retrieveTaskByTaskId(displayNotification.getFeatureId());
                taskDataBean.setTaskId(taskMasterObj.getTaskId());
                if(taskMasterObj.getTaskName() != null){
                   taskDataBean.setTaskName(taskMasterObj.getTaskName()); 
                }else{
                    taskDataBean.setTaskName("N/A");
                }
                if (taskMasterObj.getTaskDescription() != null) {
                    taskDataBean.setTaskDescription(taskMasterObj.getTaskDescription());
                } else {
                    taskDataBean.setTaskDescription("N/A");
                }
                taskDataBean.setAssignedTo(taskMasterObj.getAssignedTo());
                taskDataBean.setStartDate(taskMasterObj.getStartDate());
                taskDataBean.setEndDate(taskMasterObj.getEndDate());
                taskDataBean.setProjectName(taskMasterObj.getProjectId().getProjectName());
                break;
            case WATCHER:
                Watcher watcherObj = watcherService.retrieveWatcherById(Long.parseLong(displayNotification.getFeatureId()));
                
                TaskMaster taskMasterObjs = taskService.retrieveTaskByTaskId(watcherObj.getTaskId().getTaskId());
                taskDataBean.setTaskId(taskMasterObjs.getTaskId());
                if(taskMasterObjs.getTaskName() != null){
                   taskDataBean.setTaskName(taskMasterObjs.getTaskName()); 
                }else{
                    taskDataBean.setTaskName("N/A");
                }
                if (taskMasterObjs.getTaskDescription() != null) {
                    taskDataBean.setTaskDescription(taskMasterObjs.getTaskDescription());
                } else {
                    taskDataBean.setTaskDescription("N/A");
                }
                taskDataBean.setAssignedTo(taskMasterObjs.getAssignedTo());
                taskDataBean.setStartDate(taskMasterObjs.getStartDate());
                taskDataBean.setEndDate(taskMasterObjs.getEndDate());
                taskDataBean.setProjectName(taskMasterObjs.getProjectId().getProjectName());
                break;
            case PROJECT:
                Project projectObj = projectService.retrieveProjectById(Long.parseLong(displayNotification.getFeatureId()));
                projectDataBean.setProjectId(projectObj.getProjectId());
                if(projectObj.getProjectName() != null){
                    projectDataBean.setProjectName(projectObj.getProjectName());
                }else{
                    projectDataBean.setProjectName("N/A");
                }
                if(projectObj.getProjectDescription() != null){
                    projectDataBean.setProjectDescription(projectObj.getProjectDescription());
                }else{
                    projectDataBean.setProjectDescription("N/A");
                }
                projectDataBean.setCreatedOn(projectObj.getCreatedOn());
                projectDataBean.setProjectPriority(projectObj.getProjectPriority());
                projectDataBean.setStartDate(projectObj.getStartDate());
                projectDataBean.setEstimatedEndDate(projectObj.getEstimatedEndDate());
                break;
            default:
                UMUser userObj = userService.getUserbyId(Long.parseLong(displayNotification.getFeatureId()), false, false, false, false);
                userDataBean.setUserId(userObj.getId());
                userDataBean.setUserName(userObj.getFirstName() + "" + userObj.getLastName());
                userDataBean.setIsActive(userObj.getIsActive());
                userDataBean.setEmailId(userObj.getEmailAddress());
                userDataBean.setPhoneNum(userObj.getMobileNumber());
                break;
        }
    }

    /**
     * deActivateNotificationById uses retrieveNotificationById which returns
     * the Object of class SystemNotificationMaster. It sets the
     * SystemNotificationMaster's isActive field as inactive and removes the
     * notification from page.
     */
    public void deActivateNotificationById() {
        Long notificationId = systemResultSessionUtil.getNotificationId();
        SystemNotificationMaster systemNotificationMasterVar = notificationService.retrieveNotificationById(notificationId);
        if (systemNotificationMasterVar != null) {
            systemNotificationMasterVar.setIsActive(Boolean.FALSE);
            notificationService.updateNotification(systemNotificationMasterVar);
        }

    }
}
