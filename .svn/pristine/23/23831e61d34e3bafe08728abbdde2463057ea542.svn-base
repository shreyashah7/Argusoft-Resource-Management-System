/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.servicebean;

import com.argusoft.armms.model.Project;
import com.argusoft.armms.web.databean.FileUploadDataBean;
import com.argusoft.armms.web.databean.ProjectDataBean;
import com.argusoft.armms.web.databean.ProjectMilestoneDataBean;
import com.argusoft.armms.web.databean.TaskAttachmentDataBean;
import com.argusoft.armms.web.databean.TaskCommentDataBean;
import com.argusoft.armms.web.databean.TaskDataBean;
import com.argusoft.armms.web.databean.TaskTrackDataBean;
import com.argusoft.armms.web.databean.TechnologyDataBean;
import com.argusoft.armms.web.databean.WatcherDataBean;
import com.argusoft.armms.web.reports.databean.EmployeePerformanceDataBean;
import com.argusoft.armms.web.transformerbean.ProjectTransformerBean;
import com.argusoft.armms.web.transformerbean.TaskTransformerBean;
import com.argusoft.armms.web.usermanagement.transformerbean.UserTransformerBean;
import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import com.argusoft.armms.web.usermanagement.databean.MessageDataBean;
import com.argusoft.armms.web.usermanagement.databean.UserDataBean;
import com.argusoft.armms.web.util.SystemConstantUtil;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.generic.database.exception.GenericDatabaseException;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;
import org.springframework.util.CollectionUtils;

/**
 * Service bean for task
 *
 * @author ravi
 */
@ManagedBean(name = "taskServiceBean")
@RequestScoped
public class TaskServiceBean {

    @ManagedProperty("#{taskDataBean}")
    private TaskDataBean taskDataBean;
    @ManagedProperty(value = "#{messageDataBean}")
    private MessageDataBean messageDataBean;
    @ManagedProperty("#{loginDataBean}")
    private LoginDataBean loginDataBean;
    @ManagedProperty("#{notificationServiceBean}")
    private NotificationServiceBean notificationServiceBean;
    @ManagedProperty("#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;
    @ManagedProperty("#{taskTransformerBean}")
    private TaskTransformerBean taskTransformerBean;
    @ManagedProperty("#{projectTransformerBean}")
    private ProjectTransformerBean projectTransformerBean;
    @ManagedProperty("#{userTransformerBean}")
    private UserTransformerBean userTransformerBean;
    @ManagedProperty(value = "#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;
    @ManagedProperty("#{employeePerformanceDataBean}")
    private EmployeePerformanceDataBean employeePerformanceDataBean;
    @ManagedProperty("#{taskTrackDataBean}")
    private TaskTrackDataBean taskTrackDataBean;

    public TaskTrackDataBean getTaskTrackDataBean() {
        return taskTrackDataBean;
    }

    public void setTaskTrackDataBean(TaskTrackDataBean taskTrackDataBean) {
        this.taskTrackDataBean = taskTrackDataBean;
    }

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    public EmployeePerformanceDataBean getEmployeePerformanceDataBean() {
        return employeePerformanceDataBean;
    }

    public void setEmployeePerformanceDataBean(EmployeePerformanceDataBean employeePerformanceDataBean) {
        this.employeePerformanceDataBean = employeePerformanceDataBean;
    }

    public NotificationServiceBean getNotificationServiceBean() {
        return notificationServiceBean;
    }

    public void setNotificationServiceBean(NotificationServiceBean notificationServiceBean) {
        this.notificationServiceBean = notificationServiceBean;
    }

    public MessageDataBean getMessageDataBean() {
        return messageDataBean;
    }

    public void setMessageDataBean(MessageDataBean messageDataBean) {
        this.messageDataBean = messageDataBean;
    }

    public UserTransformerBean getUserTransformerBean() {
        return userTransformerBean;
    }

    public void setUserTransformerBean(UserTransformerBean userTransformerBean) {
        this.userTransformerBean = userTransformerBean;
    }

    public ProjectTransformerBean getProjectTransformerBean() {
        return projectTransformerBean;
    }

    public void setProjectTransformerBean(ProjectTransformerBean projectTransformerBean) {
        this.projectTransformerBean = projectTransformerBean;
    }

    public TaskDataBean getTaskDataBean() {
        return taskDataBean;
    }

    public void setTaskDataBean(TaskDataBean taskDataBean) {
        this.taskDataBean = taskDataBean;
    }

    public LoginDataBean getLoginDataBean() {
        return loginDataBean;
    }

    public void setLoginDataBean(LoginDataBean loginDataBean) {
        this.loginDataBean = loginDataBean;
    }

    public TaskTransformerBean getTaskTransformerBean() {
        return taskTransformerBean;
    }

    public void setTaskTransformerBean(TaskTransformerBean taskTransformerBean) {
        this.taskTransformerBean = taskTransformerBean;
    }

    public SystemResultSessionUtil getSystemResultSessionUtil() {
        return systemResultSessionUtil;
    }

    public void setSystemResultSessionUtil(SystemResultSessionUtil systemResultSessionUtil) {
        this.systemResultSessionUtil = systemResultSessionUtil;
    }

    /**
     * retrieve list of Tasks of particular user between start time and end time
     *
     * @author ravi
     * @param userIdForCalendar user id
     * @param startTime start time
     * @param endTime end time
     * @return list of tasks
     */
    public List<TaskDataBean> retrieveTasksForIntervalById(long userIdForCalendar, Calendar startTime, Calendar endTime) {
        return taskTransformerBean.retrieveTasksForIntervalById(userIdForCalendar, startTime, endTime);
    }

    /**
     * retrieve list of Tasks of particular user between start time and end time
     *
     * @author ravi
     * @param userIdForCalendar user id
     * @param startTime start time
     * @param endTime end time
     * @return list of tasks
     */
    public List<TaskDataBean> retrieveTasksForIntervalByIdForGantt(long userIdForCalendar, Calendar startTime, Calendar endTime) {
        return taskTransformerBean.retrieveTasksForIntervalByIdForGantt(userIdForCalendar, startTime, endTime);
    }

    /**
     * Retrieve No of Active Project and No of Active Users and set into
     * SystemResultViewUtil to display on the page.
     *
     * @author Brijesh
     * @throws UMUserManagementException
     * @throws GenericDatabaseException
     */
    public void init() throws UMUserManagementException, GenericDatabaseException {
        //        systemResultViewUtil.setProjectList(projectTransformerBean.retieveAllActiveProjects());
        if (taskDataBean.getProjectId() == null || !taskDataBean.getProjectId().equals(systemResultSessionUtil.getSelectedProjectId())) {
            taskDataBean.setProjectId(systemResultSessionUtil.getSelectedProjectId());
            this.retrieveTaskAndTechnologiesAndResourcesOfProject();
        }

        if (systemResultSessionUtil.getResult() != null) {
            if (systemResultSessionUtil.getResult().equals(SystemConstantUtil.SUCCESS)) {
                messageDataBean.setMessage("Task Created successfully.");
                messageDataBean.setIsSuccess(Boolean.TRUE);
            } else {
                messageDataBean.setMessage("Unexpected error occured!");
                messageDataBean.setIsSuccess(Boolean.FALSE);
            }

        }
        systemResultSessionUtil.setResult(null);
    }

    /**
     * Retrieve All Task And Technologies Of selected Project and set into
     * SystemResultViewUtil to display.
     *
     * @author Brijesh
     */
    public void retrieveTaskAndTechnologiesAndResourcesOfProject() throws GenericDatabaseException, UMUserManagementException {
        if (taskDataBean.getProjectId() != null) {
            systemResultSessionUtil.setSelectedProjectId(taskDataBean.getProjectId());
            systemResultViewUtil.setTaskDataBeanList(taskTransformerBean.retrieveTaskByProjectId(taskDataBean.getProjectId()));
            systemResultViewUtil.setTechnologyList(taskTransformerBean.retrieveTechnologiesByProjectId(taskDataBean.getProjectId()));
            systemResultViewUtil.setUserList(taskTransformerBean.retrieveResourcesOfProjectByProjectId(taskDataBean.getProjectId()));
            systemResultViewUtil.setMilestoneList(this.retrieveMilestonesOfProject(taskDataBean.getProjectId()));
        } else {
            System.out.println("=====insdie else =====" + taskDataBean.getProjectId());
            systemResultViewUtil.setTaskDataBeanList(null);
            systemResultViewUtil.setTechnologyList(null);
            systemResultViewUtil.setUserList(null);
            systemResultViewUtil.setMilestoneList(null);
        }
    }

    public List<UserDataBean> populateUserListBySkills() throws GenericDatabaseException, UMUserManagementException {
        List<UserDataBean> skillwiseUsers = new ArrayList<>();
        List<Long> taskTechnologies;
        taskTechnologies = taskDataBean.getTaskTechnologies();
        List<TechnologyDataBean> projectTechList = systemResultViewUtil.getTechnologyList();
        List<UserDataBean> userList = taskTransformerBean.retrieveResourcesOfProjectByProjectId(systemResultSessionUtil.getSelectedProjectId());
        List<Long> userIds = new ArrayList<>();
        List<Long> techIds = new ArrayList<>();
        for (UserDataBean userData : userList) {
            userIds.add(userData.getUserId());
        }
        for (TechnologyDataBean tech : projectTechList) {
            techIds.add(tech.getTechId());
        }

        Map<Long, UserDataBean> mapOfSkilledUsers = new LinkedHashMap<>();

        if (taskTechnologies != null && !taskTechnologies.isEmpty()) {
            skillwiseUsers = taskTransformerBean.retrieveSkillsOfUsersForProject(userIds, taskTechnologies, techIds);

            if (skillwiseUsers != null && skillwiseUsers.size() > 0) {
                Collections.sort(skillwiseUsers, UserDataBean.Comparators.NAME_EXPERIENCE_AND_TECH);
            }

            for (UserDataBean user : skillwiseUsers) {
                mapOfSkilledUsers.put(user.getUserId(), user);
            }
        }

        Collections.sort(userList, UserDataBean.Comparators.FIRST_NAME);

        for (UserDataBean userData : userList) {
            if (mapOfSkilledUsers.containsKey(userData.getUserId())) {

            } else {
                userData.setTotalExperience(0d);
                userData.setUsefulTechnologies(taskTechnologies);
                userData.setExpList(new ArrayList());
                mapOfSkilledUsers.put(userData.getUserId(), userData);
            }
        }

        List<UserDataBean> skilledUsers = new ArrayList<>();

        for (Map.Entry<Long, UserDataBean> entry : mapOfSkilledUsers.entrySet()) {
            skilledUsers.add(entry.getValue());
        }

        systemResultViewUtil.setUserList(skilledUsers);
        return skillwiseUsers;

    }

    /**
     * showProjectDuration method calculates total time taken by each project
     * for their completion.
     *
     * @author Shifa
     * @throws com.argusoft.generic.database.exception.GenericDatabaseException
     */
    public void retrieveWatcherListForTask() throws GenericDatabaseException {
        Boolean flag = Boolean.FALSE;
        if (systemResultViewUtil.getProjectId() != null) {
            List<UserDataBean> userDataBeanList = taskTransformerBean.retrieveResourcesOfProjectByProjectId(systemResultViewUtil.getProjectId());
            List<WatcherDataBean> watcherDataBeanList = systemResultViewUtil.getListOfWatchers();
            List<UserDataBean> tempList = new ArrayList<>();
            for (UserDataBean userDataBeanVar : userDataBeanList) {
                for (WatcherDataBean watcherDataBean : watcherDataBeanList) {
                    if (userDataBeanVar.getUserId() != null && watcherDataBean.getWatcherId() != null) {
                        if (!(tempList.isEmpty())) {
                            if (!(userDataBeanVar.getUserId().equals(watcherDataBean.getWatcherId()))) {
                                if (!(tempList.contains(userDataBeanVar))) {
                                    flag = Boolean.FALSE;
                                } else {
                                    flag = Boolean.TRUE;
                                    break;
                                }
                                flag = Boolean.FALSE;
                            } else {
                                flag = Boolean.TRUE;
                                break;
                            }
                        } else {
                            if (!(userDataBeanVar.getUserId().equals(watcherDataBean.getWatcherId()))) {
                                flag = Boolean.FALSE;
                            } else {
                                flag = Boolean.TRUE;
                                break;
                            }
                        }
                    }
                }
                if (flag == Boolean.FALSE) {
                    tempList.add(userDataBeanVar);
                }
            }
            systemResultViewUtil.setUserList(tempList);
        }
    }

    /**
     * showProjectDuration method calculates total time taken by each project
     * for their completion.
     *
     * @author Shifa
     * @throws
     * com.argusoft.usermanagement.common.exception.UMUserManagementException
     */
    public void showProjectDuration() throws UMUserManagementException {
        taskTransformerBean.retrieveTotalHourForProject(loginDataBean.getId());

    }

    /**
     * showtaskByProjectIdAndUserId method retrieves the list of task
     * corresponding to a particular project & particular user
     *
     * @author Shifa
     */
    public void showTaskByProjectIdAndUserId() throws UMUserManagementException {
        systemResultViewUtil.setTaskForUserList(taskTransformerBean.retrieveTasksByUserIdAndProjectId(systemResultViewUtil.getProjectIdForTask(), loginDataBean.getId()));
        if (CollectionUtils.isEmpty(systemResultViewUtil.getTaskForUserList())) {
            messageDataBean.setIsSuccess(Boolean.FALSE);
            messageDataBean.setMessage("No Task Found.");
        }

    }

    /**
     * checkDueDate method checks if today is the due date for a task or not &
     * returns the boolean value
     *
     * @author Shifa
     * @param taskDataBean takes object of class TaskDataBean
     * @return a boolean value
     * @throws
     * com.argusoft.usermanagement.common.exception.UMUserManagementException
     */
    public Boolean checkDueDate(TaskDataBean taskDataBean) throws UMUserManagementException {
        Boolean flag = taskTransformerBean.checkDueDate(taskDataBean);
        systemResultViewUtil.setFlag(flag);
        if (flag != true) {
            this.changeStatus(taskDataBean);
        }
        return flag;
    }

    /**
     * changeStatus method for changing the status(Start/Stop) of project &
     * calculates total time correspondingly.
     *
     * @author Shifa
     * @param taskDataBean takes object of class TaskDataBean
     * @throws
     * com.argusoft.usermanagement.common.exception.UMUserManagementException
     */
    public void changeStatus(TaskDataBean taskDataBean) throws UMUserManagementException {

        List<TaskDataBean> taskList = systemResultViewUtil.getTaskForUserList();

        if (SystemConstantUtil.START.equalsIgnoreCase(taskDataBean.getStatus())) {
            taskDataBean.setStatus(SystemConstantUtil.STOP);

        } else {
            taskDataBean.setStatus(SystemConstantUtil.START);

        }

        taskTransformerBean.changeStatus(taskDataBean.getTaskId(), SystemConstantUtil.IN_PROGRESS);
        taskTransformerBean.storeDateAndTime(taskDataBean.getTaskId(), taskDataBean.getStatus(), taskDataBean);
        this.showTaskByProjectIdAndUserId();
        this.showProjectDuration();

    }

    /**
     * endTask method for marking your task as completed.
     *
     * @author Shifa
     * @throws
     * com.argusoft.usermanagement.common.exception.UMUserManagementException
     */
    public void endTask() throws UMUserManagementException {
        this.completeTask(systemResultViewUtil.getTaskDataBean());
    }

    /**
     * changeTaskStatus method for calling change status method with all the
     * values set in DataBean.
     *
     * @author Shifa
     * @throws
     * com.argusoft.usermanagement.common.exception.UMUserManagementException
     */
    public void changeTaskStatus() throws UMUserManagementException {
        this.changeStatus(systemResultViewUtil.getTaskDataBean());
    }

    /**
     * completeTask method for storing the completion time of the project
     *
     * @param taskdatabean takes object of class TaskDataBean
     * @author Shifa
     * @throws
     * com.argusoft.usermanagement.common.exception.UMUserManagementException
     */
    public void completeTask(TaskDataBean taskdatabean) throws UMUserManagementException {

        String result = taskTransformerBean.completeTask(taskdatabean);
        this.showProjectDuration();

        if (SystemConstantUtil.START.equalsIgnoreCase(taskdatabean.getStatus()) || "NA".equalsIgnoreCase(taskdatabean.getStatus())) {
            taskTransformerBean.storeDateAndTime(taskdatabean.getTaskId(), SystemConstantUtil.COMPLETED, taskdatabean);
        }
        if (SystemConstantUtil.SUCCESS.equals(result)) {
            messageDataBean.setIsSuccess(Boolean.TRUE);
            messageDataBean.setMessage("Your task has been marked as Completed");
            this.showTaskByProjectIdAndUserId();

        } else {
            messageDataBean.setIsSuccess(Boolean.FALSE);
            messageDataBean.setMessage("Could not mark your task as Completed");
        }

    }

    /**
     * addDeclineReason method for adding the reason for declining a task.
     *
     * @author Shifa
     */
    public void addDeclineReason() {
        try {
            String result = taskTransformerBean.addDeclineReason();
            this.showTaskByProjectIdAndUserId();
            if (SystemConstantUtil.SUCCESS.equalsIgnoreCase(result)) {
                messageDataBean.setIsSuccess(Boolean.TRUE);

                messageDataBean.setMessage("Your task decline notification has been sent to Project Manager ");
                notificationServiceBean.retrieveAllNotificationsByUserId();
            } else if (SystemConstantUtil.DECLINE.equalsIgnoreCase(result)) {
                messageDataBean.setIsSuccess(Boolean.TRUE);
                messageDataBean.setMessage("You can't decline a task more than one time");
            } else {
                messageDataBean.setIsSuccess(Boolean.FALSE);
                messageDataBean.setMessage("Failed to decine the task");
            }

        } catch (Exception e) {

        }
    }

    public void retrieveInCompleteTaskByUserId() throws UMUserManagementException, GenericDatabaseException {
        systemResultViewUtil.setTaskDataBeanList(taskTransformerBean.retrieveInCompleteTaskByUserId());
    }

    /**
     * Assign Task to User
     *
     * @author Brijesh
     * @throws IOException
     */
    public String addTask() throws GenericDatabaseException, UMUserManagementException {
        if (systemResultViewUtil.getTempTaskAttachmentList() != null && !CollectionUtils.isEmpty(systemResultViewUtil.getTempTaskAttachmentList())) {
            FileOutputStream outputStream = null;
            String filePath;
            String path;
            String fileName;

            try {
                path = SystemConstantUtil.FILE_PATH_DATA + taskDataBean.getTaskName() + File.separator;;
                Boolean result = new File(path).mkdirs();
                if (!CollectionUtils.isEmpty(systemResultViewUtil.getTempTaskAttachmentList())) {
                    for (FileUploadDataBean fileVar : systemResultViewUtil.getTempTaskAttachmentList()) {
                        fileName = getTimeStamp() + "-" + fileVar.getFileName();
                        filePath = path + fileName;
                        fileVar.setFilePath(filePath);
                        outputStream = new FileOutputStream(filePath);
                        fileVar.setFileName(fileVar.getFileName());
                        outputStream.write(fileVar.getFileData());
                        outputStream.close();
                    }

                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        systemResultSessionUtil.setResult(taskTransformerBean.addTask(taskDataBean, systemResultViewUtil.getTempTaskAttachmentList()));
        if (systemResultSessionUtil.getResult() != null) {
            if (systemResultSessionUtil.getResult().equals(SystemConstantUtil.SUCCESS)) {
                messageDataBean.setMessage("Task Created successfully.");
                messageDataBean.setIsSuccess(Boolean.TRUE);
            } else {
                messageDataBean.setMessage("Unexpected error occured!");
                messageDataBean.setIsSuccess(Boolean.FALSE);
            }

        }

        if (taskDataBean.getContinue()) {

            this.retrieveTaskAndTechnologiesAndResourcesOfProject();

            systemResultSessionUtil.setResult(null);
            this.resetTaskDataBean();
            systemResultViewUtil.setTempTaskAttachmentList(null);
            systemResultViewUtil.setTechnologyList(null);
            return null;

        } else {

            taskDataBean = new TaskDataBean();
            systemResultViewUtil.setTempTaskAttachmentList(null);
            systemResultViewUtil.setTechnologyList(null);
            this.resetTaskDataBean();
            return "pretty:ViewMultipleTask";
        }

    }

    public void resetTaskDataBean() {

        taskDataBean.setProjectId(null);
        taskDataBean.setMilestoneId(null);
        taskDataBean.setTaskName(null);
        taskDataBean.setStatus(null);
        taskDataBean.setParentTask(null);
        taskDataBean.setStartDate(null);
        taskDataBean.setEndDate(null);
        taskDataBean.setDuration(null);
        taskDataBean.setTaskTechnologies(null);
        taskDataBean.setAssignedTo(null);
        taskDataBean.setTaskDescription(null);
        taskDataBean.setPriority(null);
        taskDataBean.setWatcherList(null);

    }

    /**
     * Attach Document while Assigning Task
     *
     * @author Brijesh
     * @param event
     */
    public void fileUploadListener(FileUploadEvent event) throws Exception {

        UploadedFile item = event.getUploadedFile();
        systemResultViewUtil.setUploadedFile(item);
        systemResultViewUtil.setFileData(item.getData());
        systemResultViewUtil.setFileName(item.getName());
        systemResultViewUtil.setFileSize(item.getSize());

//        taskDataBean.setAttachmentFileName(systemResultViewUtil.getFileName());
    }

    public void addTaskAttachmentToList() {
        List<FileUploadDataBean> fileUploadDataBeans = systemResultViewUtil.getTempTaskAttachmentList();
        if (CollectionUtils.isEmpty(fileUploadDataBeans)) {
            fileUploadDataBeans = new ArrayList();
            FileUploadDataBean fileUploadVar = new FileUploadDataBean();
            fileUploadVar.setFileName(systemResultViewUtil.getFileName());
            fileUploadVar.setFileData(systemResultViewUtil.getFileData());
            fileUploadVar.setFileSize(systemResultViewUtil.getFileSize());
            fileUploadDataBeans.add(fileUploadVar);
            systemResultViewUtil.setTempTaskAttachmentList(fileUploadDataBeans);
        } else {
            FileUploadDataBean fileUploadVar = new FileUploadDataBean();
            fileUploadVar.setFileName(systemResultViewUtil.getFileName());
            fileUploadVar.setFileData(systemResultViewUtil.getFileData());
            fileUploadVar.setFileSize(systemResultViewUtil.getFileSize());
            fileUploadDataBeans.add(fileUploadVar);
            systemResultViewUtil.setTempTaskAttachmentList(fileUploadDataBeans);
        }

    }

    public void clearData() {
        systemResultViewUtil.setTempTaskAttachmentList(null);
    }

    public void deleteTaskAttachmentToList() {
        int index = systemResultViewUtil.getRowIndex();
        systemResultViewUtil.getTempTaskAttachmentList().remove(index);

    }

    public long getTimeStamp() {
        return System.currentTimeMillis();
    }

    public void retrieveTaskByProjectIdAndUserIdAndDates() throws UMUserManagementException {
        systemResultViewUtil.setEmployeePerformanceList(taskTransformerBean.retrieveTaskByProjectIdAndUserIdAndDates());
        systemResultViewUtil.setProjectNames(null);
        if (CollectionUtils.isEmpty(systemResultViewUtil.getEmployeePerformanceList())) {
            messageDataBean.setIsSuccess(Boolean.FALSE);
            messageDataBean.setMessage("No Data in the report");
        }
    }

    /**
     * Retrieve particular task's detail by task id in session util
     *
     * @author ravi
     * @throws UMUserManagementException
     */
    public void retrieveTaskById() throws UMUserManagementException, GenericDatabaseException {
        String taskId = systemResultSessionUtil.getTaskIdForTaskView();

        TaskDataBean retrievedTask = taskTransformerBean.retrieveTaskById(taskId);

        if (retrievedTask != null) {
            systemResultViewUtil.setTaskDataBean(retrievedTask);
        }

    }

    public String retrieveMilestoneById(Long id) {
        List<ProjectMilestoneDataBean> milestoneList = systemResultViewUtil.getMilestoneList();
        if (milestoneList != null && id != null) {
            for (ProjectMilestoneDataBean projectMilestone : milestoneList) {
                if (projectMilestone.getProjectMilestoneId() == id) {
                    return projectMilestone.getMilestoneName();
                }
            }
        }
        return "N/A";
    }

    public void retrieveUsersOfProjectByProjectId() throws GenericDatabaseException {
        systemResultViewUtil.setUserList(taskTransformerBean.retrieveResourcesOfProjectByProjectId(systemResultViewUtil.getTaskDataBean().getProjectId()));

    }

    /**
     * @author ravi Retrieve particular task's attachment detail by task id in
     * systemResultSessionUtil
     * @throws UMUserManagementException
     */
    public void retrieveTaskAttachmentsById() throws UMUserManagementException, GenericDatabaseException {
        String taskId = systemResultSessionUtil.getTaskIdForTaskView();
        List<TaskAttachmentDataBean> retrievedTaskAttachments = taskTransformerBean.retrieveTaskAttachmentsById(taskId);
        if (retrievedTaskAttachments != null) {
            systemResultViewUtil.setTaskAttachments(retrievedTaskAttachments);
        }
    }

    /**
     * @author ravi Retrieve all projects of current logged in user Retrieve all
     * Users and set into viewUtil ListofUser
     */
    public void populateMultipleTaskView() throws UMUserManagementException, GenericDatabaseException {
        List<ProjectDataBean> ActiveProjectsOfUser = projectTransformerBean.retrieveAllActiveProjectsOfUser(loginDataBean.getId());
        if (!ActiveProjectsOfUser.isEmpty()) {
            systemResultViewUtil.setListOfProjects(ActiveProjectsOfUser);
        }
        List<UserDataBean> users = new ArrayList<>();
        try {
            users = userTransformerBean.retrieveUsers();
        } catch (UMUserManagementException | GenericDatabaseException ex) {
            Logger.getLogger(TaskServiceBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        systemResultViewUtil.setListOfUsers(users);

    }

    /**
     * @author ravi Retrieve all active projects with filters applied on it.
     */
    public void retrieveTaskWithFilters() throws GenericDatabaseException {
        List<TaskDataBean> taskDataBeans = new ArrayList<>();
        try {
            taskDataBeans = taskTransformerBean.retrieveTaskWithFilters();
        } catch (UMUserManagementException ex) {
            Logger.getLogger(TaskServiceBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        systemResultViewUtil.setTaskDataBeanList(taskDataBeans);
    }

    /**
     * @author ravi Updates the task according to taskDataBean in viewUtil
     */
    public void updateTask() {
        try {
            TaskDataBean taskData = systemResultViewUtil.getTaskDataBean();
            taskTransformerBean.updateTask(taskData);
            messageDataBean.setIsSuccess(Boolean.TRUE);
            messageDataBean.setMessage("Task updated successfully.");
        } catch (Exception e) {
            messageDataBean.setIsSuccess(Boolean.FALSE);
            messageDataBean.setMessage("Task not updated!!");
        }

    }

    /**
     * @author ravi Delete the task according to taskId in taskDataBean
     */
    public void deleteTask() throws GenericDatabaseException {
        try {
            taskTransformerBean.deleteTask();
            this.retrieveTaskWithFilters();
            this.showTaskByProjectIdAndUserId();
            this.showProjectDuration();
            messageDataBean.setIsSuccess(Boolean.TRUE);
            messageDataBean.setMessage("Task Deleted successfully.");
        } catch (Exception e) {
            messageDataBean.setIsSuccess(Boolean.FALSE);
            messageDataBean.setMessage("Task not Deleted!!");
        }
        retrieveTaskWithFilters();
    }

    public void retrieveTaskByUser() throws UMUserManagementException, GenericDatabaseException {
        Long userId = systemResultSessionUtil.getUserId();
        List<TaskDataBean> retrievedTasks = taskTransformerBean.retrieveTaskByUserId(userId);
        systemResultViewUtil.setTaskDataBeanList(retrievedTasks);

        Map map = new HashMap<>();

        for (TaskDataBean taskData : retrievedTasks) {
            String taskName = taskData.getTaskName();
            String taskId = taskData.getTaskId();
            String key = taskId + " : " + taskName;
            map.put(key, taskData);
        }

        systemResultViewUtil.setMapOfTasksForUser(map);
    }

    public void clearTaskTrackDataBean() {
        taskTrackDataBean.setTaskId("");
        taskTrackDataBean.setTaskKey("");
        taskTrackDataBean.setCurrentDate(null);
        taskTrackDataBean.setDuration("");
        taskTrackDataBean.setProjectId(null);
        taskTrackDataBean.setComments("");
        taskTrackDataBean.setStartDate(null);

    }

    public void addTaskTrack() {
        Map mapOfTasksForUser = systemResultViewUtil.getMapOfTasksForUser();
        TaskDataBean selectedtask = (TaskDataBean) mapOfTasksForUser.get(taskTrackDataBean.getTaskKey().trim());
        Long trackId = null;

        if (selectedtask != null) {
//            System.out.println("in if");
//            System.out.println("selected Task:::" + selectedtask.getTaskId());
            taskTrackDataBean.setTaskId(selectedtask.getTaskId());
            taskTrackDataBean.setProjectId(selectedtask.getProjectId());
//            System.out.println("selected Task:::" + selectedtask.getTaskId());
            trackId = taskTransformerBean.addTaskTrack(taskTrackDataBean);
            if (trackId == null) {
                messageDataBean.setIsSuccess(Boolean.FALSE);
                messageDataBean.setMessage("Log not created");
            } else {
                messageDataBean.setIsSuccess(Boolean.TRUE);
                messageDataBean.setMessage("Log created successfully");
                clearTaskTrackDataBean();
            }
        } else {
//            System.out.println("in else ");
            if (taskTrackDataBean.getProjectId() != null) {
                trackId = taskTransformerBean.addTaskTrack(taskTrackDataBean);
                if (trackId == null) {
                    messageDataBean.setIsSuccess(Boolean.FALSE);
                    messageDataBean.setMessage("Log not created");
                } else {
                    messageDataBean.setIsSuccess(Boolean.TRUE);
                    messageDataBean.setMessage("Log created successfully");
                    clearTaskTrackDataBean();
                }
            } else {
                messageDataBean.setIsSuccess(Boolean.FALSE);
                messageDataBean.setMessage("Enter Either Valid Task or Project");
            }

        }

    }

    public List<ProjectMilestoneDataBean> retrieveMilestonesOfProject(Long projectId) throws UMUserManagementException {
        return taskTransformerBean.retrieveMilestoneOfProject(projectId);
    }

    public void retrieveMilestonesOfProjectByProjectId() throws UMUserManagementException {
        systemResultViewUtil.setMilestoneList(taskTransformerBean.retrieveMilestoneOfProject(systemResultViewUtil.getTaskDataBean().getProjectId()));
    }

    public void populateTaskTrack() throws UMUserManagementException, GenericDatabaseException {

        Long userId = systemResultViewUtil.getUserId();

        if (userId == null) {
            userId = systemResultSessionUtil.getUserId();
            systemResultViewUtil.setUserId(userId);
        }

        Long projectId = systemResultSessionUtil.getSelectedProjectId();

        List<TaskTrackDataBean> taskTrackDataBeans = taskTransformerBean.retrieveTaskTrackDetailsByUserAndProjectId(userId, projectId);
        if (taskTrackDataBeans != null) {
            systemResultViewUtil.setTaskTrkDataList(taskTrackDataBeans);
        }

    }

    public void retrieveWatcherListByTaskId() throws UMUserManagementException {
        String taskId = systemResultSessionUtil.getTaskIdForTaskView();
        List<WatcherDataBean> watcherDataBeanList = taskTransformerBean.retrieveWatcherListByTaskId(taskId);
        if (watcherDataBeanList != null) {
            systemResultViewUtil.setListOfWatchers(watcherDataBeanList);
        }
    }

    public void retrieveWatcherNameByString() throws GenericDatabaseException, UMUserManagementException {
        String expr = taskDataBean.getExpr();
        List<UserDataBean> tempUserDataBeanList = new ArrayList<>();
        List<UserDataBean> tempUserList = new ArrayList<>();
        tempUserList = systemResultViewUtil.getUserList();
        if (expr != null && !(expr.isEmpty())) {
            for (UserDataBean userDataBeanVar : systemResultViewUtil.getUserList()) {
                String name = null;
                if (userDataBeanVar.getLastName() != null) {
                    name = userDataBeanVar.getFirstName() + " " + userDataBeanVar.getLastName();
                } else {
                    name = userDataBeanVar.getFirstName();
                }

                if (name != null && name.toLowerCase().contains(expr.toLowerCase())) {
                    tempUserDataBeanList.add(userDataBeanVar);
                }
            }
            if (!tempUserDataBeanList.isEmpty()) {
                systemResultViewUtil.setUserList(tempUserDataBeanList);
            }
        } else {
            this.retrieveWatcherListForTask();
        }
    }

    public void addWatchersList() throws UMUserManagementException, GenericDatabaseException {
        List<Long> listOfWatcher = taskDataBean.getWatcherList();
        String taskId = systemResultViewUtil.getTaskDataBean().getTaskId();
        if (listOfWatcher != null && !(listOfWatcher.isEmpty())) {
            taskTransformerBean.addWatcherList(listOfWatcher, taskId);
            messageDataBean.setMessage("Watcher added successfully!");
            messageDataBean.setIsSuccess(Boolean.TRUE);
            retrieveWatcherListByTaskId();
        } else {
            messageDataBean.setMessage("There is some issue in adding watcher!");
            messageDataBean.setIsSuccess(Boolean.FALSE);
        }
    }

    public void deleteWatcherList() throws UMUserManagementException {
        try {
            taskTransformerBean.deleteWatcherList();
            messageDataBean.setIsSuccess(Boolean.TRUE);
            messageDataBean.setMessage("Watcher Deleted successfully.");
        } catch (Exception e) {
            messageDataBean.setIsSuccess(Boolean.FALSE);
            messageDataBean.setMessage("Some issue in deleting watcher!");
        }
        retrieveWatcherListByTaskId();
    }

    public void addCommentForTask() {
        taskTransformerBean.addCommentForTask(systemResultSessionUtil.getTaskIdForTaskView());
    }

    public void retrieveCommentListByTaskId() throws UMUserManagementException {
        String taskId = systemResultSessionUtil.getTaskIdForTaskView();
        List<TaskCommentDataBean> commentDataBeanList = taskTransformerBean.retrivecommentByTaskId(taskId);
        if (commentDataBeanList != null) {
            systemResultViewUtil.setListOfComments(commentDataBeanList);
        }
    }

    public void editComment() {
        Long taskCommentId = systemResultSessionUtil.getCommentId();
        taskTransformerBean.editComment(taskCommentId);
    }

}
