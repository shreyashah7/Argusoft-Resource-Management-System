/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.transformerbean;

import com.argusoft.armms.core.EmailNotificationService;
import com.argusoft.armms.core.NotificationService;
import com.argusoft.armms.core.ProjectService;
import com.argusoft.armms.core.TaskCommentService;
import com.argusoft.armms.core.TaskService;
import com.argusoft.armms.core.UserSkillsService;
import com.argusoft.armms.core.WatcherService;
import com.argusoft.armms.model.EmailNotification;
import com.argusoft.armms.model.Project;
import com.argusoft.armms.model.ProjectMilestone;
import com.argusoft.armms.model.ProjectResourceDetail;
import com.argusoft.armms.model.ProjectTechnologyDetail;
import com.argusoft.armms.model.SystemNotificationMaster;
import com.argusoft.armms.model.TaskAttachment;
import com.argusoft.armms.model.TaskDeclineDetail;
import com.argusoft.armms.model.TaskMaster;
import com.argusoft.armms.model.TaskComment;
import com.argusoft.armms.model.TaskTechnologyDetail;
import com.argusoft.armms.model.TaskTechnologyDetailPK;
import com.argusoft.armms.model.TaskTrack;
import com.argusoft.armms.model.TechnologyMaster;
import com.argusoft.armms.model.UserSkillSet;
import com.argusoft.armms.model.Watcher;
import com.argusoft.armms.web.databean.FileUploadDataBean;
import com.argusoft.armms.web.databean.ProjectMilestoneDataBean;
import com.argusoft.armms.web.databean.TaskAttachmentDataBean;
import com.argusoft.armms.web.databean.TaskCommentDataBean;
import com.argusoft.armms.web.databean.TaskDataBean;
import com.argusoft.armms.web.databean.TaskDeclineDataBean;
import com.argusoft.armms.web.databean.TaskTrackDataBean;
import com.argusoft.armms.web.databean.TechnologyDataBean;
import com.argusoft.armms.web.databean.WatcherDataBean;
import com.argusoft.armms.web.reports.databean.EmployeePerformanceDataBean;
import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import com.argusoft.armms.web.usermanagement.databean.UserDataBean;
import com.argusoft.armms.web.usermanagement.databean.UserSkillDataBean;
import com.argusoft.armms.web.usermanagement.transformerbean.UserTransformerBean;
import com.argusoft.armms.web.util.SystemConstantUtil;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.generic.database.common.GenericDao;
import com.argusoft.generic.database.exception.GenericDatabaseException;
import com.argusoft.usermanagement.common.core.UMSystemConfigurationService;
import com.argusoft.usermanagement.common.core.UMUserService;
import com.argusoft.usermanagement.common.database.UMUserDao;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import com.argusoft.usermanagement.common.model.UMSystemConfiguration;
import com.argusoft.usermanagement.common.model.UMUser;
import com.google.common.collect.HashBiMap;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import org.apache.avro.generic.GenericData;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.CollectionUtils;

/**
 * Transformer Bean for SVN
 *
 * @author ravi
 */
@ManagedBean(name = "taskTransformerBean")
@RequestScoped
@EnableAsync
public class TaskTransformerBean {

    String task = "Task";

    private static final Logger LOGGER = Logger.getLogger(NotificationTransformerBean.class.getName());

    @ManagedProperty(value = "#{taskDataBean}")
    private TaskDataBean taskDataBean;
    @ManagedProperty(value = "#{taskCommentDataBean}")
    private TaskCommentDataBean taskCommentDataBean;
    @ManagedProperty(value = "#{watcherDataBean}")
    private WatcherDataBean watcherDataBean;
    @ManagedProperty(value = "#{taskDeclineDataBean}")
    private TaskDeclineDataBean taskDeclineDataBean;
    @ManagedProperty("#{taskService}")
    private TaskService taskService;
    @ManagedProperty(value = "#{projectService}")
    private ProjectService projectService;
    @ManagedProperty(value = "#{taskCommentService}")
    private TaskCommentService taskCommentService;
    @ManagedProperty(value = "#{userService}")
    private UMUserService userService;
    @ManagedProperty(value = "#{emailNotificationService}")
    private EmailNotificationService emailNotificationService;
    @ManagedProperty("#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;
    @ManagedProperty("#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;
    @ManagedProperty(value = "#{systemConfigurationService}")
    private UMSystemConfigurationService systemConfigurationService;
    @ManagedProperty(value = "#{loginDataBean}")
    private LoginDataBean loginDataBean;
    @ManagedProperty(value = "#{notificationService}")
    private NotificationService notificationService;
    @ManagedProperty(value = "#{watcherService}")
    private WatcherService watcherService;
    @ManagedProperty(value = "#{userSkillsService}")
    private UserSkillsService userSkillsService;
    @ManagedProperty(value = "#{technologyTransformBean}")
    private TechnologyTransformBean technologyTransformBean;
    @ManagedProperty(value = "#{employeePerformanceDataBean}")
    private EmployeePerformanceDataBean employeePerformanceDataBean;
    @ManagedProperty(value = "#{projectMilestoneTransformerBean}")
    private ProjectMilestoneTransformerBean projectMilestoneTransformerBean;
    @ManagedProperty(value = "#{userTransformerBean}")
    private UserTransformerBean userTransformerBean;
    @ManagedProperty(value = "#{systemConfigurationService}")
    private UMSystemConfigurationService uMSystemConfigurationService;

    public UMSystemConfigurationService getuMSystemConfigurationService() {
        return uMSystemConfigurationService;
    }

    public void setuMSystemConfigurationService(UMSystemConfigurationService uMSystemConfigurationService) {
        this.uMSystemConfigurationService = uMSystemConfigurationService;
    }

    public TaskCommentService getTaskCommentService() {
        return taskCommentService;
    }

    public void setTaskCommentService(TaskCommentService taskCommentService) {
        this.taskCommentService = taskCommentService;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public TaskCommentDataBean getTaskCommentDataBean() {
        return taskCommentDataBean;
    }

    public void setTaskCommentDataBean(TaskCommentDataBean taskCommentDataBean) {
        this.taskCommentDataBean = taskCommentDataBean;
    }

    public UserTransformerBean getUserTransformerBean() {
        return userTransformerBean;
    }

    public void setUserTransformerBean(UserTransformerBean userTransformerBean) {
        this.userTransformerBean = userTransformerBean;
    }

    public WatcherDataBean getWatcherDataBean() {
        return watcherDataBean;
    }

    public void setWatcherDataBean(WatcherDataBean watcherDataBean) {
        this.watcherDataBean = watcherDataBean;
    }

    public ProjectMilestoneTransformerBean getProjectMilestoneTransformerBean() {
        return projectMilestoneTransformerBean;
    }

    public void setProjectMilestoneTransformerBean(ProjectMilestoneTransformerBean projectMilestoneTransformerBean) {
        this.projectMilestoneTransformerBean = projectMilestoneTransformerBean;
    }

    public WatcherService getWatcherService() {
        return watcherService;
    }

    public void setWatcherService(WatcherService watcherService) {
        this.watcherService = watcherService;
    }

    public UserSkillsService getUserSkillsService() {
        return userSkillsService;
    }

    public void setUserSkillsService(UserSkillsService userSkillsService) {
        this.userSkillsService = userSkillsService;
    }

    public EmailNotificationService getEmailNotificationService() {
        return emailNotificationService;
    }

    public void setEmailNotificationService(EmailNotificationService emailNotificationService) {
        this.emailNotificationService = emailNotificationService;
    }

    public EmployeePerformanceDataBean getEmployeePerformanceDataBean() {
        return employeePerformanceDataBean;
    }

    public SystemResultSessionUtil getSystemResultSessionUtil() {
        return systemResultSessionUtil;
    }

    public void setSystemResultSessionUtil(SystemResultSessionUtil systemResultSessionUtil) {
        this.systemResultSessionUtil = systemResultSessionUtil;
    }

    public void setEmployeePerformanceDataBean(EmployeePerformanceDataBean employeePerformanceDataBean) {
        this.employeePerformanceDataBean = employeePerformanceDataBean;
    }

    public TechnologyTransformBean getTechnologyTransformBean() {
        return technologyTransformBean;
    }

    public void setTechnologyTransformBean(TechnologyTransformBean technologyTransformBean) {
        this.technologyTransformBean = technologyTransformBean;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public TaskDeclineDataBean getTaskDeclineDataBean() {
        return taskDeclineDataBean;
    }

    public void setTaskDeclineDataBean(TaskDeclineDataBean taskDeclineDataBean) {
        this.taskDeclineDataBean = taskDeclineDataBean;
    }

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    public UMUserService getUserService() {
        return userService;
    }

    public void setUserService(UMUserService userService) {
        this.userService = userService;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public TaskDataBean getTaskDataBean() {
        return taskDataBean;
    }

    public void setTaskDataBean(TaskDataBean taskDataBean) {
        this.taskDataBean = taskDataBean;
    }

    public UMSystemConfigurationService getSystemConfigurationService() {
        return systemConfigurationService;
    }

    public void setSystemConfigurationService(UMSystemConfigurationService systemConfigurationService) {
        this.systemConfigurationService = systemConfigurationService;
    }

    public LoginDataBean getLoginDataBean() {
        return loginDataBean;
    }

    public void setLoginDataBean(LoginDataBean loginDataBean) {
        this.loginDataBean = loginDataBean;
    }

    /**
     * retrieve list of Tasks of particular user between start time and end time
     *
     * @author ravi
     * @param userId user id
     * @param startTime start time
     * @param endTime end time
     * @return list of tasks
     */
    public List<TaskDataBean> retrieveTasksForIntervalById(long userId, Calendar startTime, Calendar endTime) {
        List<TaskMaster> taskMasters = taskService.retrieveTasksForIntervalById(userId, startTime, endTime);
        List<TaskMaster> newTaskMasters = new ArrayList<>();
        for (TaskMaster taskMaster : taskMasters) {
            if (taskMaster.getStartDate() != null && taskMaster.getEndDate() != null) {
                newTaskMasters.add(taskMaster);
            }
        }
        List<TaskDataBean> taskDataBeans = new ArrayList<>();
        for (Iterator<TaskMaster> taskMaster = newTaskMasters.iterator(); taskMaster.hasNext();) {
            TaskMaster taskMasterElement = taskMaster.next();
            TaskDataBean taskDataBean = new TaskDataBean();
            taskDataBean.setStatus(taskMasterElement.getTaskStatus());
            taskDataBean.setTaskId(taskMasterElement.getTaskId());
            taskDataBean.setActualEndDate(taskMasterElement.getActualEndDate());
            if (taskMasterElement.getTaskName() != null) {
                taskDataBean.setTaskName(taskMasterElement.getTaskName());
            } else {
                taskDataBean.setTaskName("Not Specified");
            }

            taskDataBean.setStartDate(taskMasterElement.getStartDate());
            taskDataBean.setEndDate(taskMasterElement.getEndDate());

            if (taskMasterElement.getTaskDescription() != null) {
                taskDataBean.setTaskDescription(taskMasterElement.getTaskDescription());
            } else {
                taskDataBean.setTaskDescription("Not Specified");
            }

            if (taskMasterElement.getProjectId().getProjectAlias() != null) {
                taskDataBean.setProjectAlias(taskMasterElement.getProjectId().getProjectAlias());
            } else {
                taskDataBean.setProjectAlias("Not Specified");
            }

            taskDataBeans.add(taskDataBean);
        }
        return taskDataBeans;
    }

    /**
     * retrieve list of Tasks of particular user between start time and end time
     *
     * @author ravi
     * @param userId user id
     * @param startTime start time
     * @param endTime end time
     * @return list of tasks
     */
    public List<TaskDataBean> retrieveTasksForIntervalByIdForGantt(long userId, Calendar startTime, Calendar endTime) {
        List<TaskMaster> taskMasters = taskService.retrieveTasksForIntervalByIdForGantt(userId, startTime, endTime);
        List<TaskMaster> newTaskMasters = new ArrayList<>();
        for (TaskMaster taskMaster : taskMasters) {
            if (taskMaster.getStartDate() != null && taskMaster.getEndDate() != null) {
                newTaskMasters.add(taskMaster);
            }
        }
        List<TaskDataBean> taskDataBeans = new ArrayList<>();
        for (Iterator<TaskMaster> taskMaster = newTaskMasters.iterator(); taskMaster.hasNext();) {
            TaskMaster taskMasterElement = taskMaster.next();
            TaskDataBean taskDataBean = new TaskDataBean();
            taskDataBean.setStatus(taskMasterElement.getTaskStatus());
            taskDataBean.setTaskId(taskMasterElement.getTaskId());
            taskDataBean.setActualEndDate(taskMasterElement.getActualEndDate());
            if (taskMasterElement.getTaskName() != null) {
                taskDataBean.setTaskName(taskMasterElement.getTaskName());
            } else {
                taskDataBean.setTaskName("Not Specified");
            }

            taskDataBean.setStartDate(taskMasterElement.getStartDate());
            taskDataBean.setEndDate(taskMasterElement.getEndDate());

            if (taskMasterElement.getTaskDescription() != null) {
                taskDataBean.setTaskDescription(taskMasterElement.getTaskDescription());
            } else {
                taskDataBean.setTaskDescription("Not Specified");
            }

            if (taskMasterElement.getProjectId().getProjectAlias() != null) {
                taskDataBean.setProjectAlias(taskMasterElement.getProjectId().getProjectAlias());
            } else {
                taskDataBean.setProjectAlias("Not Specified");
            }

            taskDataBeans.add(taskDataBean);
        }
        return taskDataBeans;
    }

    /**
     * Retrieve All Tasks Of Project
     *
     * @author Brijesh
     * @param projectId
     * @return List Of TaskDataBean object
     */
    public List<TaskDataBean> retrieveTaskByProjectId(Long projectId) {

        List<TaskMaster> taskMasters = taskService.retrieveAllTaskOfProject(projectId);
        List<TaskDataBean> taskDataBeans = new ArrayList<>();
        for (TaskMaster taskDataBean : taskMasters) {
            TaskDataBean taskDataBean1 = new TaskDataBean();
            taskDataBean1.setTaskId(taskDataBean.getTaskId());
            taskDataBean1.setTaskName(taskDataBean.getTaskName());
            taskDataBeans.add(taskDataBean1);
        }

        return taskDataBeans;
    }

    /**
     * convert TaskDataBean To TaskMasterModel
     *
     * @author Brijesh
     * @param taskDataBean, taskMaster
     * @return taskMaster object
     */
    public TaskMaster convertTaskDataBeanToTaskMasterModel(TaskDataBean taskDataBean, TaskMaster taskMaster) {
        if (taskMaster == null) {
            taskMaster = new TaskMaster();
        }

        if (taskMaster.getTaskId() == null) {
            taskMaster.setTaskId(taskDataBean.getTaskId());
        }
        if (taskDataBean.getTaskName() != null) {
            taskMaster.setTaskName(taskDataBean.getTaskName());
        }
        if (taskDataBean.getTaskDescription() != null) {
            taskMaster.setTaskDescription(taskDataBean.getTaskDescription());
        }
        if (taskDataBean.getDuration() != null) {
            taskMaster.setTaskDuration(taskDataBean.getDuration());
        }
        if (taskDataBean.getStatus() != null) {
            taskMaster.setTaskStatus(taskDataBean.getStatus());
        }
        if (taskDataBean.getPriority() != null) {
            taskMaster.setTaskPriority(taskDataBean.getPriority());
        }
        if (taskDataBean.getStartDate() != null) {
            taskMaster.setStartDate(taskDataBean.getStartDate());
        }
        if (taskDataBean.getEndDate() != null) {
            taskMaster.setEndDate(taskDataBean.getEndDate());
        }
        if (taskDataBean.getActualEndDate() != null) {
            taskMaster.setActualEndDate(taskDataBean.getActualEndDate());
        }
        if (taskDataBean.getAssignedTo() != null) {
            taskMaster.setAssignedTo(taskDataBean.getAssignedTo());
        }
        if (loginDataBean.getId() != null) {
            taskMaster.setLastModifiedBy(loginDataBean.getId());
        }
        if (taskDataBean.getMilestoneId() != null) {
            taskMaster.setMilestoneId(taskDataBean.getMilestoneId());
        }
        taskMaster.setTaskProgress(String.valueOf(taskDataBean.getTaskProgress()));

        return taskMaster;
    }

    /**
     * convertTaskDataBean To SystemNotificationMasterModel
     *
     * @author Brijesh
     * @return SystemNotificationMaster object
     */
    public SystemNotificationMaster convertTaskDataBeanToSystemNotificationMasterModel(TaskDataBean taskDataBean, SystemNotificationMaster systemNotificationMaster) {
        if (systemNotificationMaster == null) {
            systemNotificationMaster = new SystemNotificationMaster();
        }
        String taskId = taskService.retrieveLastTaskIdOfProject(taskDataBean.getProjectId());
        if (taskDataBean.getEndDate() != null) {
            systemNotificationMaster.setExpiryDate(taskDataBean.getEndDate());
            systemNotificationMaster.setNotificationOnDate(taskDataBean.getEndDate());

        }
        systemNotificationMaster.setAssignedTo(taskDataBean.getAssignedTo());
        systemNotificationMaster.setFeatureId(taskId);
        systemNotificationMaster.setFeatureType("Task");
        systemNotificationMaster.setNotificationSubject(taskDataBean.getTaskName() + " is ending today.");
        systemNotificationMaster.setNotificationOnDate(taskDataBean.getEndDate());

        return systemNotificationMaster;
    }

    /**
     * add Task Information in Task Master Table
     *
     * @author Brijesh
     * @param taskDataBean Object
     */
    public String addTask(TaskDataBean taskDataBean, List<FileUploadDataBean> taskAttachmentList) throws GenericDatabaseException, UMUserManagementException {

        TaskMaster taskMaster = new TaskMaster();
        Project project = projectService.retrieveProjectById(taskDataBean.getProjectId());
        if (taskDataBean.getParentTask() != null) {
            TaskMaster parentTask = taskService.retrieveTaskByTaskId(taskDataBean.getParentTask());
            taskMaster.setParentTaskId(parentTask);
        }
        String taskId = taskService.retrieveLastTaskIdOfProject(taskDataBean.getProjectId());

        if (taskId == null) {
            taskMaster.setTaskId(project.getProjectAlias() + "-" + 1);
        } else {
            Long id = Long.valueOf(taskId.substring(taskId.lastIndexOf("-") + 1));
            Long newId = id + 1;
            taskMaster.setTaskId(project.getProjectAlias() + "-" + newId);
        }
        taskMaster.setCreatedBy(loginDataBean.getId());
        taskMaster.setProjectId(project);
        taskMaster = this.convertTaskDataBeanToTaskMasterModel(taskDataBean, taskMaster);
        taskService.addTask(taskMaster);
        if (taskAttachmentList != null && !taskAttachmentList.isEmpty()) {
            this.addTaskAttachment(taskAttachmentList, taskMaster.getTaskId());
        }
        if (taskDataBean.getTaskTechnologies() != null && !taskDataBean.getTaskTechnologies().isEmpty()) {
            this.addTaskTechnology(taskDataBean.getTaskTechnologies(), taskMaster);
        }

        Long assignToId = null;
        String assignToName = null;
        String assignedByName = null;
        String projectUrl = null;
        if (taskDataBean.getAssignedTo() != null) {
            Map<GenericDao.QueryOperators, Object> criteria = new HashMap<>();
            Map<String, Object> in = new HashMap<>();
            Map<String, Object> equal = new HashMap<>();
            List<Long> toList = new ArrayList<>();
            toList.add(taskMaster.getAssignedTo());
            toList.add(taskMaster.getCreatedBy());
            in.put(UMUserDao.ID, toList);
            criteria.put(GenericDao.QueryOperators.IN, in);
            List<UMUser> userDetails = userService.retrieveUsers(null, criteria, null);
            String[] to = new String[1];
            if (userDetails != null && !userDetails.isEmpty()) {
                if (!taskMaster.getAssignedTo().equals(taskMaster.getCreatedBy())) {
                    for (UMUser umUser : userDetails) {

                        if (umUser.getId().equals(taskMaster.getAssignedTo())) {
                            assignToId = umUser.getId();
                            if (umUser.getFirstName() != null && umUser.getLastName() != null) {
                                assignToName = umUser.getFirstName() + " " + umUser.getLastName();
                            } else {
                                assignToName = "N/A";
                            }
                            to[0] = umUser.getEmailAddress();
                        } else if (umUser.getId().equals(taskMaster.getCreatedBy())) {
                            if (umUser.getFirstName() != null && umUser.getLastName() != null) {
                                assignedByName = umUser.getFirstName() + " " + umUser.getLastName();
                            } else {
                                assignedByName = "N/A";
                            }

                        }
                    }
                } else if (taskMaster.getAssignedTo().equals(taskMaster.getCreatedBy())) {
                    assignToId = userDetails.get(0).getId();
                    to[0] = userDetails.get(0).getEmailAddress();
                    if (userDetails.get(0).getFirstName() != null && userDetails.get(0).getLastName() != null) {
                        assignToName = userDetails.get(0).getFirstName() + " " + userDetails.get(0).getLastName();
                        assignedByName = userDetails.get(0).getFirstName() + " " + userDetails.get(0).getLastName();
                    } else {
                        assignToName = "N/A";
                        assignedByName = "N/A";
                    }
                }
            }

            EmailNotification emailNotification = emailNotificationService.retrieveEmailNotificationByUserId(assignToId);
            if (emailNotification != null) {
                if (emailNotification.getTaskAllocationMail()) {
                    String startDate, endDate, taskPriority;

                    if (taskMaster.getStartDate() != null) {
                        startDate = taskMaster.getStartDate().toString();
                    } else {
                        startDate = "N/A";
                    }
                    if (taskMaster.getEndDate() != null) {
                        endDate = taskMaster.getEndDate().toString();
                    } else {
                        endDate = "N/A";
                    }
                    switch (taskMaster.getTaskPriority().toString()) {
                        case "1":
                            taskPriority = "High";
                            break;
                        case "2":
                            taskPriority = "Medium";
                            break;
                        case "3":
                            taskPriority = "Low";
                        default:
                            taskPriority = "N/A";
                    }

                    UMSystemConfiguration systemConfiguration = uMSystemConfigurationService.retrieveSystemConfigurationByKey("PROJ_URL");
                    if (systemConfiguration.getKeyValue() != null) {
                        projectUrl = "\"" + systemConfiguration.getKeyValue() + "\"";

                    } else {
                        projectUrl = " ";

                    }

                    String subject = "[" + taskMaster.getTaskId() + "]" + " (" + taskMaster.getTaskStatus() + ") " + taskMaster.getTaskName();
                    String message = " <ul> <li> Assigee :" + assignToName + "</li><li> Project Name :" + project.getProjectAlias() + "</li><li> Task Name :" + taskMaster.getTaskName() + "</li><li> Status :" + taskMaster.getTaskStatus() + "</li><li> Priority :" + taskPriority + "</li><li> StartDate :" + startDate + "</li><li> EndDate :" + endDate + "</li><li> Assigned By :" + assignedByName + "</li></ul>" + "<p><a href=" + projectUrl + ">" + projectUrl + "</a></p>";

                    String from = loginDataBean.getEmailId();
                    userTransformerBean.sendMail(subject, message, from, to);
                }
            }

        }
        if (!taskDataBean.getWatcherList().isEmpty()) {
            this.addWatchers(taskDataBean.getWatcherList(), taskMaster);
        }
        if (taskDataBean.getAssignedTo() != null) {
            SystemNotificationMaster systemNotificationMaster = new SystemNotificationMaster();
            systemNotificationMaster = this.convertTaskDataBeanToSystemNotificationMasterModel(taskDataBean, systemNotificationMaster);
            systemNotificationMaster.setIsActive(Boolean.TRUE);
            notificationService.createNotification(systemNotificationMaster);
        }

        return SystemConstantUtil.SUCCESS;
    }

    /**
     * getTasksByProjectIdAndUserId method retrieves the list of task
     * corresponding to a particular project & particular user
     *
     * @author Shifa
     */
    public List<TaskDataBean> retrieveTasksByUserIdAndProjectId(Long projectId, long userId) throws UMUserManagementException {
        List<TaskMaster> taskdetail = taskService.retrieveTaskByUserIdAndProjectId(projectId, userId);
        List<TaskDataBean> tasklistDataBeans = new ArrayList<>();
        List<TaskTrack> track = taskService.retrieveCurrentTaskTrack(Boolean.TRUE);
        Map<String, TaskTrack> taskMap = new HashMap<>();
        for (TaskTrack trk : track) {
            taskMap.put((trk.getTaskId()), trk);
        }

        List<TaskTrack> allTrack = taskService.retrieveAllTaskTrack();
        Map<String, List<TaskTrack>> userMap = new HashMap();
        for (TaskTrack trcks : allTrack) {
            if (userMap.containsKey(trcks.getTaskId())) {
                userMap.get(trcks.getTaskId()).add(trcks);
            } else {
                List<TaskTrack> tasktracking = new ArrayList<>();
                tasktracking.add(trcks);
                userMap.put(trcks.getTaskId(), tasktracking);
            }
        }
        long totaltaskduration = 0;
        Map<Long, String> projectName = new HashMap();
        List<Project> allProjectList = projectService.getAllProjects();
        for (Project project : allProjectList) {
            projectName.put(project.getProjectId(), project.getProjectName());
        }
        List<UMUser> userlist = userService.getAllActiveUsers();
        Map<Long, String> userListMap = new HashMap<>();
        for (UMUser userobj : userlist) {
            StringBuffer name = new StringBuffer();
            name.append(userobj.getFirstName());
            if (userobj.getLastName() != null) {
                name.append(" ").append(userobj.getLastName());
            }
            userListMap.put(userobj.getId(), name.toString());
        }
        for (TaskMaster task : taskdetail) {
            TaskDataBean taskDataBean = new TaskDataBean();
            taskDataBean.setProjectId(task.getProjectId().getProjectId());

            taskDataBean.setProjectName(projectName.get(task.getProjectId().getProjectId()));
            taskDataBean.setTaskId(task.getTaskId());
            taskDataBean.setTaskDescription(task.getTaskDescription());
            taskDataBean.setTaskPriority(task.getTaskPriority());
            taskDataBean.setStartDate(task.getStartDate());
            taskDataBean.setEndDate(task.getEndDate());
            taskDataBean.setCreatedBy(task.getCreatedBy());
            taskDataBean.setTaskAssignedBy(userListMap.get(task.getCreatedBy()));
            List<TaskDeclineDetail> taskDeclineDetail = taskService.retrieveTaskDeclineDetailByTaskId(task.getTaskId());
            if (!CollectionUtils.isEmpty(taskDeclineDetail) && taskDeclineDetail.size() > 0) {
                taskDataBean.setDisabledDeclineBtn(true);
            }
            if (task.getTaskStatus().equalsIgnoreCase(SystemConstantUtil.IN_PROGRESS)) {
                TaskTrack track_obj = taskMap.get(task.getTaskId());

                if (track_obj != null) {
                    taskDataBean.setStatus(SystemConstantUtil.START);
                } else {
                    taskDataBean.setStatus(SystemConstantUtil.STOP);
                }
            } else {
                taskDataBean.setStatus(task.getTaskStatus());
            }

            TaskTrack tsk_track = taskMap.get(task.getTaskId());
            if (tsk_track != null) {
                taskDataBean.setTaskTrackId(tsk_track.getTaskTrackId());
                taskDataBean.setStartTime(tsk_track.getStartTime());
                taskDataBean.setEndTime(tsk_track.getEndTime());

            }
            List<TaskTrack> trackListBytaskId = userMap.get(task.getTaskId());
            long duration = 0;

            if (!CollectionUtils.isEmpty(trackListBytaskId) && trackListBytaskId.size() > 0) {
                for (TaskTrack ttrack : trackListBytaskId) {
                    if (ttrack.getEndTime() != null && ttrack.getStartTime() != null) {
                        duration = duration + ((ttrack.getEndTime().getTime()) - (ttrack.getStartTime().getTime()));
                    }
                }
                String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(duration),
                        TimeUnit.MILLISECONDS.toMinutes(duration) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duration)),
                        TimeUnit.MILLISECONDS.toSeconds(duration) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
                totaltaskduration = totaltaskduration + duration;
                taskDataBean.setDuration(hms);
            }

            tasklistDataBeans.add(taskDataBean);

        }
        String total_hms = String.format("%02dhr%02dmin%02ds", TimeUnit.MILLISECONDS.toHours(totaltaskduration),
                TimeUnit.MILLISECONDS.toMinutes(totaltaskduration) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(totaltaskduration)),
                TimeUnit.MILLISECONDS.toSeconds(totaltaskduration) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(totaltaskduration)));
        systemResultViewUtil.setTotaltaskduration(totaltaskduration);
        systemResultViewUtil.setTotalWork(total_hms);
        return tasklistDataBeans;

    }

    /**
     * changeStatus method for changing the status(Start/Stop) of project &
     * calculates total time correspondingly.
     *
     * @author Shifa public List<Long> getTaskTechnology() { return
     * taskTechnology; }
     *
     * public void setTaskTechnology(List<Long> taskTechnology) {
     * this.taskTechnology = taskTechnology; }
     * @param taskDataBean takes object of class TaskDataBean
     */
    public void changeStatus(String id, String status) {
        TaskMaster taskMasters = taskService.retrieveTaskByTaskId(id);

        taskMasters.setTaskStatus(status);

        taskService.updateTask(taskMasters);
    }

    /**
     * completeTask method for storing the completion time of the project
     *
     * @param taskdatabean takes object of class TaskDataBean
     * @author Shifa
     * @throws
     * com.argusoft.usermanagement.common.exception.UMUserManagementException
     */
    public String completeTask(TaskDataBean taskdatabean) {
        try {
            TaskMaster tm = taskService.retrieveTaskByTaskId(taskdatabean.getTaskId());
            tm.setTaskStatus(SystemConstantUtil.COMPLETED);

            taskService.updateTask(tm);
            //   Mail sending
            //   Mail sending
            List<UMUser> userlist = userService.getAllActiveUsers();
            Map<Long, String> userListMap = new HashMap<>();
            try {
                for (UMUser userobj : userlist) {
                    StringBuffer name = new StringBuffer();
                    name.append(userobj.getFirstName());
                    if (userobj.getLastName() != null) {
                        name.append(" ").append(userobj.getLastName());
                    }
                    userListMap.put(userobj.getId(), name.toString());
                }

                String username = userListMap.get(tm.getAssignedTo());
                Date today = new Date();
                String message = "Task " + taskdatabean.getTaskId() + " is completed by " + username + " on " + today;
                Long projectManangerId = tm.getCreatedBy();
                String[] to = new String[1];
                UMUser userDetail = userService.getUserbyId(projectManangerId, false, false, false, false);
                String emailidcheck = userDetail.getEmailAddress();
                String from = loginDataBean.getEmailId();
                to[0] = emailidcheck;

                userTransformerBean.sendMail("Task Complete Notification", message, from, to);
                // For watchers
                List<WatcherDataBean> watchersListByTaskId = retrieveWatcherListByTaskId(taskdatabean.getTaskId());
                for (WatcherDataBean watcherDataBean1 : watchersListByTaskId) {
                }
                List<Long> watcherLists = new ArrayList<>();
                for (WatcherDataBean watcherDataBean2 : watchersListByTaskId) {
                    watcherLists.add(watcherDataBean2.getWatcherId());
                }
                List<UMUser> watcherList = userService.retrieveUsersByUserList(watcherLists, null, null, null, Boolean.TRUE);
                for (UMUser userListVar : watcherList) {

                    EmailNotification emailNotification = emailNotificationService.retrieveEmailNotificationByUserId(loginDataBean.getId());
                    if (emailNotification != null) {
                        if (emailNotification.getWatchMail() == Boolean.TRUE) {

                            String[] tos = new String[1];
                            if (watcherList != null && !(watcherList.isEmpty())) {
                                tos[0] = userListVar.getEmailAddress();
                            }
                            Date today1 = new Date();
                            String message1 = "Task " + taskdatabean.getTaskId() + " is completed by " + username + " on " + today1;
                            String from1 = loginDataBean.getEmailId();
                            userTransformerBean.sendMail("Task Complete Notification", message1, from1, tos);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return SystemConstantUtil.SUCCESS;
        } catch (Exception e) {
            return SystemConstantUtil.FAILURE;
        }
    }

    /**
     * storeDateAndTime for storing date & time while starting,stopping or
     * completing the task
     *
     * @author Shifa
     */
    public void storeDateAndTime(String taskid, String status, TaskDataBean taskDataBean) {
        TaskTrack tracktask = new TaskTrack();

        tracktask.setTaskId(taskid);
        Project project = projectService.retrieveProjectById(taskDataBean.getProjectId());
        if (status.equalsIgnoreCase(SystemConstantUtil.STOP)) {
            Long trackid = taskDataBean.getTaskTrackId();
            TaskTrack tasktrackobj = taskService.retrieveTaskTrackById(trackid);
            tasktrackobj.setEndTime(new Date());
            tasktrackobj.setProjectId(project);
            taskService.updateTaskTrack(tasktrackobj);
        } else if (status.equalsIgnoreCase(SystemConstantUtil.COMPLETED)) {
            Long trackid = taskDataBean.getTaskTrackId();
            TaskTrack tasktrackobj = taskService.retrieveTaskTrackById(trackid);
            tasktrackobj.setEndTime(new Date());
            tasktrackobj.setProjectId(project);
            taskService.updateTaskTrack(tasktrackobj);
        } else {
            tracktask.setStartTime(new Date());
            tracktask.setProjectId(project);
            taskService.addTaskTrack(tracktask);
        }

    }

    /**
     * addDeclineReason method for adding the reason for declining a task.
     *
     * @author Shifa
     */
    public String addDeclineReason() {
        try {
            List<TaskDeclineDetail> taskDeclineList = taskService.retrieveTaskDeclineDetailByTaskId(systemResultViewUtil.getTaskidForTaskDecline());
            if (taskDeclineList.size() > 0) {
                return SystemConstantUtil.DECLINE;
            } else {
                TaskDeclineDetail taskdecline = new TaskDeclineDetail();
                taskdecline.setCreatedOn(new Date());
                taskdecline.setDeclineDate(new Date());
                taskdecline.setDeclineReason(taskDeclineDataBean.getDeclineReason());
                taskdecline.setIsActive(Boolean.TRUE);
                taskdecline.setUserId(loginDataBean.getId());
                TaskMaster tm = taskService.retrieveTaskByTaskId(systemResultViewUtil.getTaskidForTaskDecline());
                taskdecline.setTaskId(tm);
                //   Mail sending
                List<UMUser> userlist = userService.getAllActiveUsers();
                Map<Long, String> userListMap = new HashMap<>();
                try {
                    for (UMUser userobj : userlist) {
                        StringBuffer name = new StringBuffer();
                        name.append(userobj.getFirstName());
                        if (userobj.getLastName() != null) {
                            name.append(" ").append(userobj.getLastName());
                        }
                        userListMap.put(userobj.getId(), name.toString());
                    }

                    String username = userListMap.get(taskdecline.getUserId());
                    Date today = new Date();
                    String message = "Task " + taskdecline.getTaskId().getTaskId() + " is declined by " + username + " on " + today;
                    Long projectManangerId = tm.getCreatedBy();
                    String[] to = new String[1];
                    UMUser userDetail = userService.getUserbyId(projectManangerId, false, false, false, false);
                    String emailidcheck = userDetail.getEmailAddress();
                    String from = loginDataBean.getEmailId();
                    to[0] = emailidcheck;

                    userTransformerBean.sendMail("Task Decline Notification", message, from, to);
                    // For watchers
                    List<WatcherDataBean> watchersListByTaskId = retrieveWatcherListByTaskId(taskdecline.getTaskId().getTaskId());

                    List<Long> watcherLists = new ArrayList<>();
                    for (WatcherDataBean watcherDataBean2 : watchersListByTaskId) {
                        watcherLists.add(watcherDataBean2.getWatcherId());
                    }
                    List<UMUser> watcherList = userService.retrieveUsersByUserList(watcherLists, null, null, null, Boolean.TRUE);
                    for (UMUser userListVar : watcherList) {

                        EmailNotification emailNotification = emailNotificationService.retrieveEmailNotificationByUserId(loginDataBean.getId());
                        if (emailNotification != null) {
                            if (emailNotification.getWatchMail() == Boolean.TRUE) {

                                String[] tos = new String[1];
                                if (watcherList != null && !(watcherList.isEmpty())) {
                                    tos[0] = userListVar.getEmailAddress();
                                }
                                Date today1 = new Date();
                                String message1 = "Task " + taskdecline.getTaskId().getTaskId() + " is declined by " + username + " on " + today1;
                                String from1 = loginDataBean.getEmailId();
                                userTransformerBean.sendMail("Task Decline Notification", message1, from1, tos);
//
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //Notification entry for the user
                SystemNotificationMaster tasknotification = new SystemNotificationMaster();
                tasknotification.setAssignedTo(loginDataBean.getId());
                tasknotification.setCreatedOn(new Date());
                tasknotification.setFeatureId(tm.getTaskId());
                tasknotification.setFeatureType(task);
                tasknotification.setIsActive(true);
                tasknotification.setNotificationOnDate(new Date());
                tasknotification.setNotificationSubject("Task-" + tm.getTaskId() + ":" + tm.getTaskName() + " is declined now");

                //Notification Entry for the projectManager
                SystemNotificationMaster tasknotification_for_manager = new SystemNotificationMaster();
                TaskMaster taskForNotification = taskService.retrieveTaskByTaskId(tm.getTaskId());
                UMUser user = userService.getUserbyId(taskForNotification.getAssignedTo(), false, false, false, false);
                tasknotification_for_manager.setAssignedTo(taskForNotification.getCreatedBy());
                tasknotification_for_manager.setCreatedOn(new Date());
                tasknotification_for_manager.setFeatureId(tm.getTaskId());
                tasknotification_for_manager.setFeatureType(task);
                tasknotification_for_manager.setIsActive(true);
                tasknotification_for_manager.setNotificationOnDate(new Date());

                tasknotification_for_manager.setNotificationSubject("Task-" + tm.getTaskId() + ":" + tm.getTaskName() + " is declined by " + user.getFirstName());
                Long result = null;
                Long notification_result1 = null;
                Long notification_result2 = null;
                try {

                    result = taskService.addTaskDeclineDetail(taskdecline);
                    notification_result1 = notificationService.createNotification(tasknotification);
                    notification_result2 = notificationService.createNotification(tasknotification_for_manager);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return SystemConstantUtil.SUCCESS;
            }
        } catch (Exception e) {
            return SystemConstantUtil.FAILURE;
        }

    }

    /**
     * getTotalHour method calculates total time taken by each project for their
     * completion.
     *
     * @author Shifa
     */
    public void retrieveTotalHourForProject(Long userId) {

        List<TaskMaster> taskdetail = taskService.retrieveTaskByUserId(userId);

        Calendar cal = Calendar.getInstance();
        int cal_value = cal.get(Calendar.DAY_OF_WEEK);
        Date startdate = new Date();
        Date enddate = new Date();

        if (cal_value == 0 || cal_value == 1) {
            cal.set(Calendar.HOUR, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            startdate = cal.getTime();
            cal.set(Calendar.HOUR, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            enddate = cal.getTime();

        }
        if (cal_value > 1) {
            cal.set(Calendar.HOUR, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            enddate = cal.getTime();
            int a = cal_value - 1;

            cal.add(Calendar.DAY_OF_MONTH, -a);
            cal.set(Calendar.HOUR, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);

            startdate = cal.getTime();
        }
        List<TaskTrack> allTrack = taskService.retrieveAllTaskTrack();
        Map<String, List<TaskTrack>> taskandtrackmap = new HashMap();
        for (TaskTrack trcks : allTrack) {
            if (taskandtrackmap.containsKey(trcks.getTaskId())) {
                taskandtrackmap.get(trcks.getTaskId()).add(trcks);
            } else {
                List<TaskTrack> tasktracking = new ArrayList<>();
                tasktracking.add(trcks);
                taskandtrackmap.put(trcks.getTaskId(), tasktracking);
            }
        }
        Map<String, Long> uMap = new HashMap();
        for (TaskMaster task : taskdetail) {
            List<TaskTrack> trackListBytaskId = taskandtrackmap.get(task.getTaskId());
            long duration = 0;

            if (!CollectionUtils.isEmpty(trackListBytaskId) && trackListBytaskId.size() > 0) {
                for (TaskTrack ttrack : trackListBytaskId) {
                    if (ttrack.getEndTime() != null && ttrack.getStartTime() != null) {
                        if ((ttrack.getStartTime().compareTo(startdate) >= 0) && (ttrack.getEndTime().compareTo(enddate) <= 0)) {
                            duration = duration + ((ttrack.getEndTime().getTime()) - (ttrack.getStartTime().getTime()));
                        }

                        taskDataBean.setInLongduration(duration);

                    }
                }

                long dur = duration;
                if (uMap.containsKey(task.getProjectId().getProjectAlias())) {
                    dur = dur + uMap.get(task.getProjectId().getProjectAlias());

                    uMap.put(task.getProjectId().getProjectAlias(), dur);
                } else {
                    uMap.put(task.getProjectId().getProjectAlias(), duration);

                }

            }
            List<SelectItem> projectMapList = new ArrayList<>();
            for (Map.Entry<String, Long> entry : uMap.entrySet()) {
                String long1 = entry.getKey();
                Long long2 = entry.getValue();
                projectMapList.add(new SelectItem(long1, String.valueOf(long2)));
            }
            systemResultViewUtil.setProjectMapList(projectMapList);
        }
    }

    /**
     * checkDueDate method checks if today is the due date for a task or not &
     * returns the boolean value
     *
     * @author Shifa
     * @param taskDataBean takes object of class TaskDataBean
     * @return a boolean value
     */
    public Boolean checkDueDate(TaskDataBean taskDataBean) {
        Boolean flag = false;
        TaskMaster taskmaster = taskService.retrieveTaskByTaskId(taskDataBean.getTaskId());
        Date today = new Date();
        Date duedate = taskmaster.getEndDate();
        if (duedate != null) {
            if (today.compareTo(duedate) >= 0) {
                flag = true;
            } else {
                flag = false;
            }
        }
        return flag;
    }

    /**
     * add Task Attachment Detail
     *
     * @author Brijesh
     * @param taskDataBean TaskId
     */
    public void addTaskAttachment(List<FileUploadDataBean> taskAttachmentList, String TaskId) {
        System.out.println("--task attachments--" + taskAttachmentList);

        for (FileUploadDataBean fileUploadDataBean : taskAttachmentList) {
            TaskAttachment taskAttachment = new TaskAttachment();
            taskAttachment.setTaskId(TaskId);
            taskAttachment.setAttachmentPath(fileUploadDataBean.getFilePath());
            taskAttachment.setTaskAttachmentName(fileUploadDataBean.getFileName());
            taskAttachment.setUploadedBy(loginDataBean.getId());
            taskService.addTaskAttachment(taskAttachment);
        }
    }

    /**
     * retrieve Technologies which was used in Project
     *
     * @author Brijesh
     * @return List of technologyDatabean object
     */
    public List<TechnologyDataBean> retrieveTechnologiesByProjectId(Long projectId) {
        String technologyType = "T";
        List<ProjectTechnologyDetail> listOfTechnologiesOfProject = projectService.retrieveTechnologies(projectId);

        if (listOfTechnologiesOfProject != null && !listOfTechnologiesOfProject.isEmpty()) {

            List<Long> techIds = new ArrayList<>();
            for (ProjectTechnologyDetail projectTechnologyDetail : listOfTechnologiesOfProject) {
                techIds.add(projectTechnologyDetail.getTechnologyId().getTechnologyId());
            }
            List<TechnologyMaster> technologyMastersList = userSkillsService.retrieveTechnologiesByTechnologyListAndTechnologyType(techIds, technologyType);
            List<TechnologyDataBean> technologyList = new ArrayList();
            for (TechnologyMaster technologyMaster : technologyMastersList) {
                TechnologyDataBean technologyDataBean = new TechnologyDataBean();
                technologyDataBean = technologyTransformBean.convertTechnologyModelToTechnologyDataBean(technologyMaster);
                technologyList.add(technologyDataBean);
            }
            return technologyList;
        }
        return null;
    }

    /**
     * Technology used in Task are added in Task Technology Detail
     *
     * @author Brijesh
     * @param listOfTechnology taskMaster
     */
    public void addTaskTechnology(List<Long> listOfTechnology, TaskMaster taskMaster) {
        System.out.println("====insode add technology method====");
        List<TechnologyMaster> technologyMastersList = userSkillsService.retrieveTechnologiesByTechnologylist(listOfTechnology);

        for (TechnologyMaster technologyMaster : technologyMastersList) {
            TaskTechnologyDetail taskTechnologyDetail = new TaskTechnologyDetail();
            TaskTechnologyDetailPK taskTechnologyDetailPK = new TaskTechnologyDetailPK();
            taskTechnologyDetailPK.setTask_mstr(taskMaster);
            taskTechnologyDetailPK.setTech_mst(technologyMaster);
            taskTechnologyDetail.setCreatedBy(loginDataBean.getId());
            taskTechnologyDetail.setLastModifiedBy(loginDataBean.getId());
            taskTechnologyDetail.setTaskTechnologyDetailPK(taskTechnologyDetailPK);
            taskService.addTaskTechnology(taskTechnologyDetail);

        }
    }

    public void addWatchers(List<Long> listOfWatcher, TaskMaster taskMasterObj) throws UMUserManagementException {
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
        List<UMUser> watcherList = userService.retrieveUsersByUserList(listOfWatcher, null, null, null, Boolean.TRUE);
        if (watcherList != null && !(watcherList.isEmpty())) {
            for (UMUser users : watcherList) {
                Watcher watcherElement = new Watcher();
                watcherElement.setWatcherId(users.getId());
                watcherElement.setCreatedBy(loginDataBean.getId());
                watcherElement.setLstModifiedBy(loginDataBean.getId());
                watcherElement.setLstModifiedOn(Calendar.getInstance().getTime());
                watcherElement.setTaskId(taskMasterObj);
                watcherService.addWatcher(watcherElement);

                SystemNotificationMaster systemNoticMasterVar = new SystemNotificationMaster();
                systemNoticMasterVar.setAssignedTo(watcherElement.getWatcherId());
                systemNoticMasterVar.setExpiryDate(Calendar.getInstance().getTime());
                systemNoticMasterVar.setFeatureId(watcherElement.getWatchId().toString());
                systemNoticMasterVar.setFeatureType("Watcher");
                systemNoticMasterVar.setNotificationOnDate(Calendar.getInstance().getTime());
                systemNoticMasterVar.setNotificationSubject("You are added as watcher for the task- " + watcherElement.getTaskId().getTaskId());
                systemNoticMasterVar.setIsActive(Boolean.TRUE);
                notificationService.createNotification(systemNoticMasterVar);

                Long assignToId = null;
                String assignToName = null;
                String assignedByName = null;

                assignToId = taskMasterObj.getAssignedTo();
                assignToName = userMap.get(taskMasterObj.getAssignedTo());
                if (loginDataBean.getName() != null) {
                    assignedByName = userMap.get(taskMasterObj.getCreatedBy());
                } else {
                    assignedByName = "N/A";
                }

                EmailNotification emailNotification = emailNotificationService.retrieveEmailNotificationByUserId(watcherElement.getWatcherId());
                if (emailNotification != null) {
                    if (emailNotification.getWatchMail() == Boolean.TRUE) {
                        String startDate, endDate, taskPriority;
                        if (taskMasterObj.getStartDate() != null) {
                            startDate = taskMasterObj.getStartDate().toString();
                        } else {
                            startDate = "Not Available ";
                        }
                        if (taskMasterObj.getEndDate() != null) {
                            endDate = taskMasterObj.getEndDate().toString();
                        } else {
                            endDate = "Not Available ";
                        }
                        switch (taskMasterObj.getTaskPriority().toString()) {
                            case "1":
                                taskPriority = "High";
                                break;
                            case "2":
                                taskPriority = "Medium";
                                break;
                            case "3":
                                taskPriority = "Low";
                            default:
                                taskPriority = "Not Available";
                        }
                        String[] to = new String[1];
                        if (watcherList != null && !(watcherList.isEmpty())) {
                            to[0] = users.getEmailAddress();
                        }
                        String subject = "[" + taskMasterObj.getTaskId() + "]" + " (" + taskMasterObj.getTaskStatus() + ") " + taskMasterObj.getTaskName();
                        String message = "  <ul> <li> Assigee :" + assignToName + "</li><li> Task Name :" + taskMasterObj.getTaskName() + "</li><li> Status :" + taskMasterObj.getTaskStatus() + "</li><li> Priority :" + taskPriority + "</li><li> StartDate :" + startDate + "</li><li> EndDate :" + endDate + "</li><li> Assigned By :" + assignedByName + "</li></ul>";
                        String from = loginDataBean.getEmailId();
                        userTransformerBean.sendMail(subject, message, from, to);
                    }
                }
            }
        }
    }

    /**
     * retrieveTaskByProjectIdAndUserIdAndDates method retrieves the all task of
     * particular user and project for Employee performance report
     *
     * @return Returns the List of Object of Class EmployeePerformanceDataBean.
     * @author shreya
     * @throws
     * com.argusoft.usermanagement.common.exception.UMUserManagementException
     */
    public List<EmployeePerformanceDataBean> retrieveTaskByProjectIdAndUserIdAndDates() throws UMUserManagementException {

        UMSystemConfiguration sysObj = systemConfigurationService.retrieveSystemConfigurationByKey(SystemConstantUtil.EXCEEDED_DAYS);
        String exceed_days_value = null;
        Integer exceed_val = 0;
        long diffDays = 0l;

        if (sysObj != null) {
            exceed_days_value = sysObj.getKeyValue();
            exceed_val = Integer.parseInt(exceed_days_value);
        } else {
            exceed_val = SystemConstantUtil.EXCEEDED_DAYS_DEFAULT;
        }
        List<Long> projectIds = employeePerformanceDataBean.getProjectIds();
        LOGGER.log(Level.INFO, "projectIds : " + projectIds);

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
        systemResultSessionUtil.setUserName(userMap.get(systemResultViewUtil.getUserId()));
        List<TaskMaster> taskMasterList = taskService.retrieveTaskByProjectIdAndUserIdAndDates(systemResultViewUtil.getUserId(), projectIds, employeePerformanceDataBean.getStartDate(), employeePerformanceDataBean.getEndDate());
        List<EmployeePerformanceDataBean> employeeDataBeanList = new ArrayList();
        if (!CollectionUtils.isEmpty(taskMasterList)) {
            for (TaskMaster taskMasterElement : taskMasterList) {
                EmployeePerformanceDataBean empDataBeanVar = new EmployeePerformanceDataBean();
                empDataBeanVar.setTaskName(taskMasterElement.getTaskName());
                empDataBeanVar.setTaskStartDate(taskMasterElement.getStartDate());
                empDataBeanVar.setTaskActualEndDate(taskMasterElement.getActualEndDate());
                empDataBeanVar.setTaskStatus(taskMasterElement.getTaskStatus());
                empDataBeanVar.setProjectName(taskMasterElement.getProjectId().getProjectAlias());
                if (!(taskMasterElement.getActualEndDate() == null) && (taskMasterElement.getActualEndDate().after(taskMasterElement.getEndDate()))) {
                    long actualEndDate = taskMasterElement.getActualEndDate().getTime();
                    long endDate = taskMasterElement.getEndDate().getTime();
                    long diffTime = actualEndDate - endDate;
                    diffDays = diffTime / (1000 * 60 * 60 * 24);
                }
                if (taskMasterElement.getActualEndDate() == null) {
                    empDataBeanVar.setPerformance("In Progress");
                } else if (taskMasterElement.getActualEndDate().compareTo(taskMasterElement.getEndDate()) == 0) {
                    empDataBeanVar.setPerformance(SystemConstantUtil.ON_TIME);
                } else if (diffDays >= exceed_val) {
                    empDataBeanVar.setPerformance(SystemConstantUtil.TOO_LATE);
                } else if (taskMasterElement.getActualEndDate().compareTo(taskMasterElement.getEndDate()) == 1) {
                    empDataBeanVar.setPerformance(SystemConstantUtil.LATE);
                } else {
                    empDataBeanVar.setPerformance(SystemConstantUtil.EARLY);
                }
                employeeDataBeanList.add(empDataBeanVar);
            }
            LOGGER.log(Level.INFO, "employeeDataBeanList : " + employeeDataBeanList);
        }
        return employeeDataBeanList;
    }

    public List<TaskDataBean> retrieveInCompleteTaskByUserId() throws UMUserManagementException, GenericDatabaseException {
        Long userId = null;
        if (systemResultSessionUtil.getUserId() == loginDataBean.getId()) {
            userId = loginDataBean.getId();
        } else {
            userId = systemResultSessionUtil.getUserId();
        }
        UMUser user = userService.retrieveUserById(userId, null);
        List<Project> retieveAllActiveProjects = new ArrayList<>();
        List<Long> projectIds = new ArrayList<>();
        if (user.getType().equals("ROLE_SADMIN")) {
            retieveAllActiveProjects = projectService.retrieveActiveOrInactiveProjects(true);
        } else {
            retieveAllActiveProjects = projectService.retieveAllActiveProjectsOfUser(userId);
        }
        for (Project projectVar : retieveAllActiveProjects) {
            projectIds.add(projectVar.getProjectId());
        }
        if (projectIds != null && !(projectIds.isEmpty())) {
            List<TaskMaster> taskMasterList = taskService.retrieveIncompleteTask(userId);
            List<TaskDataBean> taskDataBeanList = new ArrayList<>();
            for (TaskMaster taskMasterVar : taskMasterList) {
                TaskDataBean taskDataBeanElement = new TaskDataBean();
                taskDataBeanElement = convertTaskMasterModelToTaskDataBean(taskDataBeanElement, taskMasterVar);
                taskDataBeanList.add(taskDataBeanElement);
            }
            return taskDataBeanList;
        } else {
            return null;
        }
    }

    public TaskDataBean convertTaskMasterModelToTaskDataBean(TaskDataBean taskDataBean, TaskMaster taskMaster) throws UMUserManagementException, GenericDatabaseException {

        taskDataBean.setTaskId(taskMaster.getTaskId());
        taskDataBean.setTaskName(taskMaster.getTaskName());
        taskDataBean.setProjectId(taskMaster.getProjectId().getProjectId());
        if (taskMaster.getProjectId().getProjectAlias() != null) {
            taskDataBean.setProjectAlias(taskMaster.getProjectId().getProjectAlias());
        } else {
            taskDataBean.setProjectAlias(taskMaster.getProjectId().getProjectName());
        }
        if (taskMaster.getMilestoneId() != null) {
            taskDataBean.setMilestoneId(taskMaster.getMilestoneId());
        }
        taskDataBean.setStatus(taskMaster.getTaskStatus());
        taskDataBean.setPriority(taskMaster.getTaskPriority());
        taskDataBean.setCreatedOn(taskMaster.getCreatedOn());
        taskDataBean.setAssignedTo(taskMaster.getAssignedTo());
        taskDataBean.setTaskDescription(taskMaster.getTaskDescription());
        if (taskMaster.getTaskDuration() != null) {
            taskDataBean.setDuration(taskMaster.getTaskDuration());
        }
        if (taskMaster.getStartDate() != null) {
            taskDataBean.setStartDate(taskMaster.getStartDate());
        }
        if (taskMaster.getEndDate() != null) {
            taskDataBean.setEndDate(taskMaster.getEndDate());
        }
        if (taskMaster.getActualEndDate() != null) {
            taskDataBean.setActualEndDate(taskMaster.getActualEndDate());
        }
        if (taskMaster.getLastModifiedOn() != null) {
            taskDataBean.setModifiedOn(taskMaster.getLastModifiedOn());
        }
        if (taskMaster.getTaskProgress() != null) {
            taskDataBean.setTaskProgress(Integer.parseInt(taskMaster.getTaskProgress()));
        } else {
            taskDataBean.setTaskProgress(0);
        }

        if (taskMaster.getProjectId() != null) {
            taskDataBean.setProjectId(taskMaster.getProjectId().getProjectId());
        }
        UMUser user;
        List<UMUser> uMUsers = userService.retrieveUsers(null, null, null);
        Map<Long, UMUser> mapOfUser = new HashMap<>();

        for (UMUser uMUser : uMUsers) {
            mapOfUser.put(uMUser.getId(), uMUser);
        }

        if (taskMaster.getAssignedTo() != null) {
            UMUser assignedToUser;
            assignedToUser = mapOfUser.get(taskMaster.getAssignedTo());
            taskDataBean.setAssignedTo(taskMaster.getAssignedTo());
            taskDataBean.setAssignedToName(assignedToUser.getFirstName() + " " + assignedToUser.getLastName());
        }

        if (taskMaster.getLastModifiedBy() != null) {
            UMUser lastModifiedByUser;
            lastModifiedByUser = mapOfUser.get(taskMaster.getLastModifiedBy());
            taskDataBean.setModifiedBy(taskMaster.getLastModifiedBy());
            taskDataBean.setModifiedByName(lastModifiedByUser.getFirstName() + " " + lastModifiedByUser.getLastName());
        }

        if (taskMaster.getCreatedBy() != null) {
            UMUser createdByUser;
            createdByUser = mapOfUser.get(taskMaster.getCreatedBy());
            taskDataBean.setCreatedBy(taskMaster.getCreatedBy());
            taskDataBean.setCreatedByName(createdByUser.getFirstName() + " " + createdByUser.getLastName());
        }
        return taskDataBean;
    }

    /**
     * Retrieve particular task's detail by task id
     *
     * @param taskId task id
     * @return
     * @throws UMUserManagementException
     */
    public TaskDataBean retrieveTaskById(String taskId) throws UMUserManagementException, GenericDatabaseException {
        TaskMaster task = taskService.retrieveTaskByTaskId(taskId);
        TaskDataBean taskDataBean = new TaskDataBean();
        if (task != null) {
            taskDataBean = convertTaskMasterModelToTaskDataBean(taskDataBean, task);
        }

        return taskDataBean;
    }

    /**
     * Retrieve particular task's attachment detail by task id
     *
     * @param taskId task id
     * @return
     * @throws UMUserManagementException
     */
    public List<TaskAttachmentDataBean> retrieveTaskAttachmentsById(String taskId) throws UMUserManagementException, GenericDatabaseException {

        List<TaskAttachment> taskAttachments = taskService.retrieveTaskAttachmentsByTaskId(taskId);
        List<TaskAttachmentDataBean> taskAttachmentDataBeans = new ArrayList<>();
        for (TaskAttachment taskAttachment : taskAttachments) {
            taskAttachmentDataBeans.add(convertTaskAttachmentModelToTaskAttachmentDataBean(taskAttachment));
        }
        return taskAttachmentDataBeans;

    }

    private TaskAttachmentDataBean convertTaskAttachmentModelToTaskAttachmentDataBean(TaskAttachment taskAttachment) throws UMUserManagementException, GenericDatabaseException {
        TaskAttachmentDataBean attachmentData = new TaskAttachmentDataBean();
        attachmentData.setCreatedOn(taskAttachment.getCreatedOn());
        attachmentData.setIsActive(taskAttachment.getIsActive());
        attachmentData.setTaskId(taskAttachment.getTaskId());
        attachmentData.setAttachmentPath(taskAttachment.getAttachmentPath());

        if (taskAttachment.getTaskAttachmentName() != null) {
            attachmentData.setTaskAttachmentName(taskAttachment.getTaskAttachmentName());
        } else {
            String path = taskAttachment.getAttachmentPath();
            String filename[] = path.split("/");
            attachmentData.setTaskAttachmentName(filename[filename.length - 1]);

        }

        UMUser user;

        if (taskAttachment.getUploadedBy() != null) {
            attachmentData.setUploadedBy(taskAttachment.getUploadedBy());
            user = userService.retrieveUserById(taskAttachment.getUploadedBy(), null);
            attachmentData.setUploadedByName(user.getFirstName() + " " + user.getLastName());
        }

        if (taskAttachment.getDeletedBy() != null) {
            attachmentData.setDeletedBy(taskAttachment.getDeletedBy());
            user = userService.retrieveUserById(taskAttachment.getUploadedBy(), null);
            attachmentData.setUploadedByName(user.getFirstName() + " " + user.getLastName());
        }

        if (taskAttachment.getDeletedOn() != null) {
            attachmentData.setDeletedOn(taskAttachment.getDeletedOn());
        }

        return attachmentData;

    }

    /**
     * retrieve Task with available filters
     *
     * @author ravi
     * @return list of TaskDataBean
     * @throws UMUserManagementException
     */
    public List<TaskDataBean> retrieveTaskWithFilters() throws UMUserManagementException, GenericDatabaseException {

        Date startDate = taskDataBean.getStartDate();
        Date endDate = taskDataBean.getEndDate();
        Long assignedTo = taskDataBean.getAssignedTo();
        Long taskPriority = taskDataBean.getTaskPriority();
        Long projectId = taskDataBean.getProjectId();
        String status = taskDataBean.getStatus();
        Long createdBy = taskDataBean.getCreatedBy();

        List<TaskMaster> taskMasters = taskService.retrieveTaskWithFilters(startDate, endDate, assignedTo, taskPriority, projectId, status, createdBy);

        List<TaskDataBean> taskDataBeans = new ArrayList();

//        for (TaskMaster taskMasterModel : taskMasters) {
//            System.out.println("taskMaster::" + taskMasterModel);
//        }
        List<Project> activeProjects = projectService.retrieveActiveOrInactiveProjects(true);

        Map<Long, String> projectMap = new HashMap<>();

        for (Project project : activeProjects) {
            if (project.getProjectAlias() != null) {
                projectMap.put(project.getProjectId(), project.getProjectAlias());
            }
            projectMap.put(project.getProjectId(), project.getProjectName());
        }

        for (TaskMaster taskMasterModel : taskMasters) {
            TaskDataBean taskData = new TaskDataBean();
            taskData = convertTaskMasterModelToTaskDataBean(taskData, taskMasterModel);
            Project project = taskMasterModel.getProjectId();
            taskData.setProjectAlias(projectMap.get(project.getProjectId()));
            taskDataBeans.add(taskData);

        }

        return taskDataBeans;

    }

    /**
     * @author ravi Updates the task according to taskDataBean
     */
    public void updateTask(TaskDataBean taskDataBean) throws UMUserManagementException {
        TaskMaster taskMaster = taskService.retrieveTaskByTaskId(taskDataBean.getTaskId());
        String oldTaskStatus = taskMaster.getTaskStatus();
        taskMaster = convertTaskDataBeanToTaskMasterModel(taskDataBean, taskMaster);
        String newTaskStatus = taskMaster.getTaskStatus();

        if (!oldTaskStatus.equalsIgnoreCase(newTaskStatus)) {
            if (newTaskStatus.equalsIgnoreCase("Resolved") && taskMaster.getActualEndDate() == null) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                taskMaster.setActualEndDate(calendar.getTime());
            }
        }
        taskService.updateTask(taskMaster);
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
        Long assignToId = null;
        String assignToName = null;
        String assignedByName = null;

        List<WatcherDataBean> watchersListByTaskId = retrieveWatcherListByTaskId(taskDataBean.getTaskId());
        for (WatcherDataBean watcherDataBean1 : watchersListByTaskId) {
            System.out.println("for email--------" + watcherDataBean1.getWatcherName());
        }
        List<Long> watcherLists = new ArrayList<>();
        for (WatcherDataBean watcherDataBean2 : watchersListByTaskId) {
            watcherLists.add(watcherDataBean2.getWatcherId());
        }
        List<UMUser> watcherList = userService.retrieveUsersByUserList(watcherLists, null, null, null, Boolean.TRUE);
        for (UMUser userListVar : watcherList) {
            assignToId = taskMaster.getAssignedTo();
            assignToName = userMap.get(taskMaster.getAssignedTo());
            if (loginDataBean.getName() != null) {
                assignedByName = userMap.get(taskMaster.getCreatedBy());
            } else {
                assignedByName = "N/A";
            }

            EmailNotification emailNotification = emailNotificationService.retrieveEmailNotificationByUserId(userListVar.getId());
            if (emailNotification != null) {
                System.out.println("emailNotification.getWatchMail()---" + emailNotification.getWatchMail());
                if (emailNotification.getWatchMail() == Boolean.TRUE) {
                    System.out.println("inside....??????");
                    String startDate, endDate, taskPriority;
                    if (taskMaster.getStartDate() != null) {
                        startDate = taskMaster.getStartDate().toString();
                    } else {
                        startDate = "Not Available ";
                    }
                    if (taskMaster.getEndDate() != null) {
                        endDate = taskMaster.getEndDate().toString();
                    } else {
                        endDate = "Not Available ";
                    }
                    switch (taskMaster.getTaskPriority().toString()) {
                        case "1":
                            taskPriority = "High";
                            break;
                        case "2":
                            taskPriority = "Medium";
                            break;
                        case "3":
                            taskPriority = "Low";
                        default:
                            taskPriority = "Not Available";
                    }
                    String[] to = new String[1];
                    if (watcherList != null && !(watcherList.isEmpty())) {
                        to[0] = userListVar.getEmailAddress();
                    }
                    String subject = "[" + taskMaster.getTaskId() + "]" + " (" + taskMaster.getTaskStatus() + ") " + taskDataBean.getTaskName();
                    String message = "  <ul> <li> Assigee :" + assignToName + "</li><li> Task Name :" + taskMaster.getTaskName() + "</li><li> Status :" + taskMaster.getTaskStatus() + "</li><li> Priority :" + taskPriority + "</li><li> StartDate :" + startDate + "</li><li> EndDate :" + endDate + "</li><li> Assigned By :" + assignedByName + "</li></ul>";
                    String from = loginDataBean.getEmailId();
                    userTransformerBean.sendMail(subject, message, from, to);
                }
            }
        }
    }

    /**
     * @author ravi Delete the task according to taskId in taskDataBean
     */
    public void deleteTask() {
        TaskMaster taskMaster = taskService.retrieveTaskByTaskId(taskDataBean.getTaskId());
        taskMaster.setIsActive(Boolean.FALSE);
        taskService.updateTask(taskMaster);
    }

    /**
     * Retrieve All Resources Of Project
     *
     * @author Brijesh
     * @param projectId
     * @return
     */
    public List<UserDataBean> retrieveResourcesOfProjectByProjectId(Long projectId) throws GenericDatabaseException {

        List<ProjectResourceDetail> projectResourceDetailsList = projectService.retrieveProjectResourceByProjectId(projectId);
        List<UserDataBean> userDataBeansList = new ArrayList<>();

        if (projectResourceDetailsList != null && !projectResourceDetailsList.isEmpty()) {

            List<Long> userIds = new ArrayList<>();
            for (ProjectResourceDetail projectResource : projectResourceDetailsList) {
                userIds.add(projectResource.getUserId());
            }
            Map<GenericDao.QueryOperators, Object> criteria = new HashMap<>();
            Map<String, Object> in = new HashMap<>();
            Map<String, Object> equal = new HashMap<>();
            in.put(UMUserDao.ID, userIds);
            criteria.put(GenericDao.QueryOperators.IN, in);
            equal.put(UMUserDao.IS_ACTIVE, Boolean.TRUE);
            criteria.put(GenericDao.QueryOperators.EQUAL, equal);
            List<UMUser> uMUsersList = userService.retrieveUsers(null, criteria, null);
            if (!CollectionUtils.isEmpty(uMUsersList)) {
                for (UMUser user : uMUsersList) {
                    UserDataBean userDataBeanObj = new UserDataBean();
                    userDataBeanObj.setFirstName(user.getFirstName());
                    userDataBeanObj.setLastName(user.getLastName());
                    userDataBeanObj.setEmailId(user.getEmailAddress());
                    userDataBeanObj.setPhoneNum(user.getMobileNumber());
                    userDataBeanObj.setRole(user.getType());
                    userDataBeanObj.setUserId(user.getId());
                    userDataBeanObj.setUserName(user.getUserId());
                    userDataBeanObj.setIsActive(user.getIsActive());
                    userDataBeansList.add(userDataBeanObj);
                }
            }
        }

        return userDataBeansList;
    }

    public List<TaskDataBean> retrieveTaskByUserId(Long userId) throws UMUserManagementException, GenericDatabaseException {

        List<TaskMaster> taskMasters = taskService.retrieveTaskWithFilters(null, null, userId, null, null, null, null);

        List<TaskDataBean> taskDataBeans = new ArrayList();

//        for (TaskMaster taskMasterModel : taskMasters) {
//            System.out.println("taskMaster::" + taskMasterModel);
//        }
        List<Project> activeProjects = projectService.retrieveActiveOrInactiveProjects(true);

        Map<Long, String> projectMap = new HashMap<>();

        for (Project project : activeProjects) {
            if (project.getProjectAlias() != null) {
                projectMap.put(project.getProjectId(), project.getProjectAlias());
            }
            projectMap.put(project.getProjectId(), project.getProjectName());
        }

        for (TaskMaster taskMasterModel : taskMasters) {
            TaskDataBean taskData = new TaskDataBean();
            taskData = convertTaskMasterModelToTaskDataBean(taskData, taskMasterModel);
            Project project = taskMasterModel.getProjectId();
            taskData.setProjectAlias(projectMap.get(project.getProjectId()));
            taskDataBeans.add(taskData);

        }

        return taskDataBeans;
    }

    public Long addTaskTrack(TaskTrackDataBean taskTrackDataBean) {

        TaskTrack taskTrack = new TaskTrack();
//        TaskMaster retrievedTask = taskService.retrieveTaskByTaskId(taskTrackDataBean.getTaskId());
//
//        if (retrievedTask != null) {
        Date today = new Date();
        taskTrack.setTaskId(taskTrackDataBean.getTaskId());
        taskTrack.setComment(taskTrackDataBean.getComments());
        taskTrack.setProjectId(new Project(taskTrackDataBean.getProjectId()));
        taskTrack.setDuration(taskTrackDataBean.getDuration());
        taskTrack.setLogBy(systemResultSessionUtil.getUserId());

        taskTrack.setTrackMode("L");

        if (taskTrackDataBean.getStartDate() != null) {
            taskTrack.setStartTime(taskTrackDataBean.getStartDate());
            taskTrack.setEndTime(taskTrackDataBean.getStartDate());
        } else {
            taskTrack.setStartTime(today);
            taskTrack.setEndTime(today);
        }
        taskTrack.setLogDate(today);
        taskTrack.setTrackMode("L");

        return taskService.addTaskTrack(taskTrack);
//        }
//        else{
//            
//        }

    }

    public List<ProjectMilestoneDataBean> retrieveMilestoneOfProject(Long projectId) throws UMUserManagementException {
        List<ProjectMilestone> milestoneList = projectService.retrieveMilestonesById(projectId);
        List<ProjectMilestoneDataBean> milestoneDataBeansList = projectMilestoneTransformerBean.convertMilestoneModelToDataBean(milestoneList);
        return milestoneDataBeansList;
    }

    private TaskTrackDataBean convertTaskTrackModelToTaskTrackDataBean(TaskTrack taskTrack) throws UMUserManagementException, GenericDatabaseException {
        TaskTrackDataBean taskTrackDataBean = new TaskTrackDataBean();
        taskTrackDataBean.setProjectAlias(taskTrack.getProjectId().getProjectAlias());

        if (taskTrack.getDuration() != null) {
            taskTrackDataBean.setDuration(taskTrack.getDuration());
        }

        if (taskTrack.getTaskId() != null) {
            taskTrackDataBean.setTaskId(taskTrack.getTaskId());
        }

        if (taskTrack.getLogDate() != null) {
            taskTrackDataBean.setLogDate(taskTrack.getLogDate());
        }

        if (taskTrack.getStartTime() != null) {
            taskTrackDataBean.setStartDate(taskTrack.getStartTime());
        }

        if (taskTrack.getEndTime() != null) {
            taskTrackDataBean.setEndDate(taskTrack.getEndTime());
        }

        if (taskTrack.getComment() != null) {
            taskTrackDataBean.setComments(taskTrack.getComment());
        } else {
            taskTrackDataBean.setComments("N/A");
        }
//        System.out.println("user++++"+taskTrack.getLogBy());
        UMUser user;
        List<UMUser> uMUsers = userService.retrieveUsers(null, null, null);
        Map<Long, UMUser> mapOfUser = new HashMap<>();

        for (UMUser uMUser : uMUsers) {
            mapOfUser.put(uMUser.getId(), uMUser);
        }
        if (taskTrack.getLogBy() != null) {
            UMUser logBy = mapOfUser.get(taskTrack.getLogBy());
            if (logBy != null) {
                taskTrackDataBean.setLoggedByName(logBy.getFirstName());
            }
        }

        return taskTrackDataBean;

    }

    public List<TaskTrackDataBean> retrieveTaskTrackDetailsByUserAndProjectId(Long userId, Long projectId) throws UMUserManagementException, GenericDatabaseException {
        List<TaskTrack> taskTracks = taskService.retrieveTaskTrackDetailsByUserAndProjectId(userId, projectId);
        List<TaskTrackDataBean> taskTrackDataBeans = new ArrayList<>();
        for (TaskTrack taskTrack : taskTracks) {
            TaskTrackDataBean taskTrackDataBean = convertTaskTrackModelToTaskTrackDataBean(taskTrack);
            taskTrackDataBeans.add(taskTrackDataBean);
        }
        return taskTrackDataBeans;
    }

    public List<WatcherDataBean> retrieveWatcherListByTaskId(String taskId) throws UMUserManagementException {
        List<Watcher> watcherList = watcherService.retrieveWatcherByTaskId(taskId);
        TaskMaster taskMasterElement = taskService.retrieveTaskByTaskId(taskId);
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
        List<WatcherDataBean> watcherDataBeans = new ArrayList<>();
        for (Watcher watcherVar : watcherList) {
            WatcherDataBean watcherDataBeanElement = new WatcherDataBean();
            watcherDataBeanElement.setWatcherId(watcherVar.getWatcherId());
            watcherDataBeanElement.setWatchId(watcherVar.getWatchId());
            watcherDataBeanElement.setWatcherName(userMap.get(watcherVar.getWatcherId()));
            watcherDataBeans.add(watcherDataBeanElement);
        }
        return watcherDataBeans;
    }

    public void addWatcherList(List<Long> watchers, String taskId) throws UMUserManagementException {
        TaskMaster taskMasteElement = taskService.retrieveTaskByTaskId(taskId);
        this.addWatchers(watchers, taskMasteElement);
    }

    public void deleteWatcherList() {
        Watcher watcher = watcherService.retrieveWatcherById(systemResultSessionUtil.getWatchId());
        watcherService.deleteWatcher(watcher);
    }

    public void addCommentForTask(String taskId) {
        TaskComment taskComment = new TaskComment();
        TaskMaster tm = taskService.retrieveTaskByTaskId(taskId);
        taskComment.setTaskId(tm);
        taskComment.setDescription(taskCommentDataBean.getDescription());
        taskComment.setIsActive(Boolean.TRUE);
        taskComment.setCreatedBy(loginDataBean.getId());
        taskComment.setCreatedOn(new Date());
        taskCommentService.addComment(taskComment);
        taskCommentDataBean.setDescription(null);
    }

    public List<TaskCommentDataBean> retrivecommentByTaskId(String taskId) throws UMUserManagementException {
        List<TaskComment> taskCommentList = taskCommentService.retrieveTaskCommentByTaskId(taskId);

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
        List<TaskCommentDataBean> commentDataBeans = new ArrayList<>();
        for (TaskComment comment : taskCommentList) {
            TaskCommentDataBean commentDataBean = new TaskCommentDataBean();
            commentDataBean.setDescription(comment.getDescription());
            commentDataBean.setTaskId(taskId);
            commentDataBean.setName(userMap.get(comment.getCreatedBy()));
            commentDataBean.setCommentId(comment.getId());
            commentDataBeans.add(commentDataBean);
        }
        return commentDataBeans;
    }

    public TaskCommentDataBean editComment(Long taskCommentId) {
        TaskComment taskcomment = new TaskComment();
        taskcomment = taskCommentService.retrieveTaskCommentByCommentId(taskCommentId);
        taskCommentDataBean.setDescription(taskcomment.getDescription());
        return taskCommentDataBean;
    }

    public List<UserDataBean> retrieveSkillsOfUsersForProject(List<Long> userIds, List<Long> techIds, List<Long> projectTechList) throws GenericDatabaseException {
        List<UserSkillSet> userSkillSets = userSkillsService.retrieveSkillsOfUsersForProject(userIds, techIds);
        List<UserDataBean> userDataBeansList = new ArrayList<>();

        if (userSkillSets != null && !userSkillSets.isEmpty()) {

            List<Long> userId = new ArrayList<>();

            Map<Long, List<UserSkillSet>> userSkillsMap = new HashMap();

            for (UserSkillSet skillSet : userSkillSets) {
                userId.add(skillSet.getUserId());
                if (userSkillsMap.containsKey(skillSet.getUserId())) {
                    List<UserSkillSet> userSkillSet = userSkillsMap.get(skillSet.getUserId());
                    userSkillSet.add(skillSet);
                    userSkillsMap.put(skillSet.getUserId(), userSkillSet);
                } else {
                    List<UserSkillSet> userSkillSet = new ArrayList<>();
                    userSkillSet.add(skillSet);
                    userSkillsMap.put(skillSet.getUserId(), userSkillSet);
                }
            }
            Map<GenericDao.QueryOperators, Object> criteria = new HashMap<>();
            Map<String, Object> in = new HashMap<>();
            Map<String, Object> equal = new HashMap<>();
            in.put(UMUserDao.ID, userId);
            criteria.put(GenericDao.QueryOperators.IN, in);
            equal.put(UMUserDao.IS_ACTIVE, Boolean.TRUE);
            criteria.put(GenericDao.QueryOperators.EQUAL, equal);
            List<UMUser> uMUsersList = userService.retrieveUsers(null, criteria, null);
            if (!CollectionUtils.isEmpty(uMUsersList)) {
                for (UMUser user : uMUsersList) {
                    UserDataBean userDataBeanObj = new UserDataBean();
                    userDataBeanObj.setFirstName(user.getFirstName());
                    userDataBeanObj.setLastName(user.getLastName());
                    userDataBeanObj.setEmailId(user.getEmailAddress());
                    userDataBeanObj.setPhoneNum(user.getMobileNumber());
                    userDataBeanObj.setRole(user.getType());
                    userDataBeanObj.setUserId(user.getId());
                    userDataBeanObj.setUserName(user.getUserId());
                    userDataBeanObj.setIsActive(user.getIsActive());

                    List<UserSkillDataBean> userSkillDataBeans = new ArrayList<>();
                    Double experience = 0d;

                    if (userSkillsMap.containsKey(user.getId())) {
                        List<UserSkillSet> Skills = userSkillsMap.get(user.getId());
                        for (UserSkillSet userSkillSet : Skills) {
                            System.out.println(userSkillSet.getUserId() + ":" + userSkillSet.getTechnologyId() + ":" + userSkillSet.getExperience());
                            UserSkillDataBean userSkillDataBean = new UserSkillDataBean(userSkillSet.getTechnologyId().getTechnologyId(), userSkillSet.getExperience());
                            userSkillDataBean.setTechname(userSkillSet.getTechnologyId().getTechnologyName());
                            experience = experience + userSkillSet.getExperience();
                            userSkillDataBeans.add(userSkillDataBean);
                        }
                    }
                    userDataBeanObj.setExpList(userSkillDataBeans);
                    userDataBeanObj.setTotalExperience(experience);
                    userDataBeanObj.setUsefulTechnologies(projectTechList);
                    userDataBeansList.add(userDataBeanObj);
                }
            }
        }
        return userDataBeansList;
    }

}
