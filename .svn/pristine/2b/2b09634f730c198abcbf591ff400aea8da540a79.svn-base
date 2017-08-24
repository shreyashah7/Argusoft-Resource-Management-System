/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.util;

import com.argusoft.armms.model.ProjectMilestone;
import com.argusoft.armms.web.databean.ActivityDataBean;
import com.argusoft.armms.web.databean.TechnologyDataBean;
import com.argusoft.armms.web.usermanagement.databean.RoleDataBean;
import com.argusoft.armms.web.databean.ProjectDataBean;
import com.argusoft.armms.web.databean.ProjectMilestoneDataBean;
import com.argusoft.armms.web.databean.DayDataBean;
import com.argusoft.armms.web.databean.FileUploadDataBean;
import com.argusoft.armms.web.databean.FolderDataBean;
import com.argusoft.armms.web.databean.SvnDataBean;
import com.argusoft.armms.web.databean.MasterActivityDataBean;
import com.argusoft.armms.web.databean.NotificationDataBean;
import com.argusoft.armms.web.databean.ProjectResourceDataBean;
import com.argusoft.armms.web.databean.ProjectRolesDataBean;
import com.argusoft.armms.web.databean.TaskAttachmentDataBean;
import com.argusoft.armms.web.databean.TaskCommentDataBean;
import com.argusoft.armms.web.databean.TaskDataBean;
import com.argusoft.armms.web.databean.TaskTrackDataBean;
import com.argusoft.armms.web.databean.WatcherDataBean;
import com.argusoft.armms.web.usermanagement.databean.FeatureDataBean;
import com.argusoft.armms.web.usermanagement.databean.PermissionDataBean;
import com.argusoft.armms.web.reports.databean.EmployeePerformanceDataBean;
import com.argusoft.armms.web.usermanagement.databean.SystemConfigurationDataBean;
import com.argusoft.armms.web.usermanagement.databean.UserDataBean;
import com.argusoft.usermanagement.common.model.UMFeaturePermission;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.richfaces.model.UploadedFile;

/**
 * for the data to be stored in view scope
 *
 * @author shreya
 */
@ManagedBean(name = "systemResultViewUtil")
@ViewScoped
public class SystemResultViewUtil implements Serializable {

    private String fileName;
    private byte[] fileData;
    private String filePath;
    private Long userId;
    private String showType;
    private String ProjectRolesStatus = "Active";
    private String showProjectType = "Active";
    private String sysConfigStatus = "Active";
    private String key;
    private String value;
    private Boolean status;
    private String showMilestoneType = SystemConstantUtil.ACTIVE;
    private boolean showall = false;
    private String showAllStatus;
    private String confirmpassword;
    private Long projectRolesId;
    private List<ProjectResourceDataBean> manageProjectResource;
    private List<ProjectResourceDataBean> projectResourceTech;
    private List<SelectItem> projectResourceTool;
    private List<SelectItem> projectResourceServer;
    private List<SelectItem> projectResourceOS;
    private List<SelectItem> projectResourceBrowser;
    private List<RoleDataBean> roleList;
    private Long projectId;
    private List<TechnologyDataBean> technologyList;
    private List<ProjectDataBean> projectList;
    private List<UserDataBean> userList;
    private List<TaskDataBean> taskForUserList;
    private List<TaskDataBean> taskForUserAndProjectList;
    private List<ProjectMilestoneDataBean> projectMilestoneDetails;
    private List<ProjectDataBean> projectNames;
    private List<UserDataBean> users;
    private UserDataBean user;
    private boolean showDropdown;
    private List<SystemConfigurationDataBean> SystemConfigurationDataBeanList;
    private List<SelectItem> priorityList;
    List<List<DayDataBean>> calendarDataList = new ArrayList<>();
    private String nextMonthName;
    private String prevMonthName;
    private List listOfyears;
    private List<UserDataBean> listOfUsers;
    private List<Long> techIdsofProject;
    private long UserIdForCalendar;
    private String taskidForTaskDecline;
    private String taskStatus;
    private Long ProjectIdForTask;
    private Long totaltaskduration;
    private Map<Integer, String> colorMap;
    private List<SelectItem> projectMapList;
    private String totalWork;
    List<SvnDataBean> svnDataList;
    private List<ProjectDataBean> listOfProjects;
    private List<TaskDataBean> taskDataBeanList;
    private List<ProjectDataBean> projectDataBeanList;
    private List<ProjectResourceDataBean> resourceOrTechnologyList;
    private List<ActivityDataBean> activityDataBeanList;
    private List<MasterActivityDataBean> masterActivityDataBean;
    private String taskAttachmentPath;
    private List<TaskAttachmentDataBean> taskAttachments;
    private String userName;
    private String projectDataForChart;
    private String projectErrorMessage;
    private List<FeatureDataBean> listOfFeatures;
    private List<PermissionDataBean> listOfPermissionForFeature;
    private List<FeatureDataBean> listOfFeaturePermisssion;
    private List<FeatureDataBean> listOfChildFeature;
    private String[] permissionsSelected;
    private Boolean addNew;
    private Long parentFeature;
    private Long currentSelectedFeature;
    private List<Map<Long, String>> selectedFeaturePermissionForRole = new ArrayList<>();
    Map<String, Map<String, String>> listOfRoleFeaturePermission;
    private List<FeatureDataBean> listOfMenuMenuItemFeatures;
    private List<RoleDataBean> listOfAllActiveRoles;
    private String parentFeatureName;
    private List<PermissionDataBean> listOFpermissionWithSameFeature;
    private List<RoleDataBean> listOfRoleWithPermissionID = new ArrayList<>();
    private List<UMFeaturePermission> permissionsToAdd;
    private UploadedFile uploadedFile;
    private String projectAttachmentPath;
    private List<FileUploadDataBean> tempProjectAttachmentList;
    private List<FileUploadDataBean> projectAttachmentList;
    private Long fileSize;
    private Integer rowIndex;
    private Long roleIdOfUserRole;
    private List<ProjectResourceDataBean> projectResourceList;
    private List<Long> selectedList;
    private Long roleType;
    private List<ProjectRolesDataBean> projectRolesDataBeanList;
    private Long roleMemberId;
    private String taskSummary;
    private Integer maxYAxis;
    private Long techId;
    private List<TaskDataBean> listOfTasksForUser;
    public Map mapOfTasksForUser = new HashMap<>();
    public Date currentDate = new Date();
    public String userNameUnavailable;
    private String projectNameExist;
    private String projectAliasExist;
    public List<TaskTrackDataBean> taskTrkDataList;
    public List<ProjectMilestoneDataBean> milestoneList;
    public List<Long> allResourcesOfProject;
    public List<ProjectResourceDataBean> allProjectResources;
    private Integer initialSize = new Integer(-1);
    private Integer count = new Integer(0);
    private List<NotificationDataBean> NotificationList;
    private List<FolderDataBean> dataList = new ArrayList();
    private TaskDataBean taskDataBean;
    private Boolean flag;
    private String extension;
    private List<EmployeePerformanceDataBean> employeePerformanceList;
    private String messageProjectSummary = null;
    private List<ProjectDataBean> listOfProjectsOfUser;
    private List<WatcherDataBean> listOfWatchers;
    private List<TaskCommentDataBean> listOfComments;
    private List<FileUploadDataBean> tempTaskAttachmentList;
    private List<FileUploadDataBean> TaskAttachmentList;
    private List<UserDataBean> retrieveUsers;

    public List<FileUploadDataBean> getTempTaskAttachmentList() {
        return tempTaskAttachmentList;
    }

    public void setTempTaskAttachmentList(List<FileUploadDataBean> tempTaskAttachmentList) {
        this.tempTaskAttachmentList = tempTaskAttachmentList;
    }

    public List<UserDataBean> getRetrieveUsers() {
        return retrieveUsers;
    }

    public void setRetrieveUsers(List<UserDataBean> retrieveUsers) {
        this.retrieveUsers = retrieveUsers;
    }

    public List<FileUploadDataBean> getTaskAttachmentList() {
        return TaskAttachmentList;
    }

    public void setTaskAttachmentList(List<FileUploadDataBean> TaskAttachmentList) {
        this.TaskAttachmentList = TaskAttachmentList;
    }

    public List<ProjectDataBean> getListOfProjectsOfUser() {
        return listOfProjectsOfUser;
    }

    public void setListOfProjectsOfUser(List<ProjectDataBean> listOfProjectsOfUser) {
        this.listOfProjectsOfUser = listOfProjectsOfUser;
    }

    public List<ProjectMilestoneDataBean> getMilestoneList() {
        return milestoneList;
    }

    public void setMilestoneList(List<ProjectMilestoneDataBean> milestoneList) {
        this.milestoneList = milestoneList;
    }

    public List<WatcherDataBean> getListOfWatchers() {
        return listOfWatchers;
    }

    public void setListOfWatchers(List<WatcherDataBean> listOfWatchers) {
        this.listOfWatchers = listOfWatchers;
    }

    public List<TaskTrackDataBean> getTaskTrkDataList() {
        return taskTrkDataList;
    }

    public void setTaskTrkDataList(List<TaskTrackDataBean> taskTrkDataList) {
        this.taskTrkDataList = taskTrkDataList;
    }

    public List<ProjectResourceDataBean> getAllProjectResources() {
        return allProjectResources;
    }

    public void setAllProjectResources(List<ProjectResourceDataBean> allProjectResources) {
        this.allProjectResources = allProjectResources;
    }

    public List<Long> getAllResourcesOfProject() {
        return allResourcesOfProject;
    }

    public void setAllResourcesOfProject(List<Long> allResourcesOfProject) {
        this.allResourcesOfProject = allResourcesOfProject;
    }

    public String getUserNameUnavailable() {
        return userNameUnavailable;
    }

    public void setUserNameUnavailable(String userNameUnavailable) {
        this.userNameUnavailable = userNameUnavailable;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Map getMapOfTasksForUser() {
        return mapOfTasksForUser;
    }

    public void setMapOfTasksForUser(Map mapOfTasksForUser) {
        this.mapOfTasksForUser = mapOfTasksForUser;
    }

    public List<TaskDataBean> getListOfTasksForUser() {
        return listOfTasksForUser;
    }

    public void setListOfTasksForUser(List<TaskDataBean> listOfTasksForUser) {
        this.listOfTasksForUser = listOfTasksForUser;
    }

    public Long getTechId() {
        return techId;
    }

    public void setTechId(Long techId) {
        this.techId = techId;
    }

    public Long getRoleMemberId() {
        return roleMemberId;
    }

    public void setRoleMemberId(Long roleMemberId) {
        this.roleMemberId = roleMemberId;
    }

    public Long getRoleType() {
        return roleType;
    }

    public void setRoleType(Long roleType) {
        this.roleType = roleType;
    }

    public List<ProjectRolesDataBean> getProjectRolesDataBeanList() {
        return projectRolesDataBeanList;
    }

    public void setProjectRolesDataBeanList(List<ProjectRolesDataBean> projectRolesDataBeanList) {
        this.projectRolesDataBeanList = projectRolesDataBeanList;
    }

    public List<Long> getSelectedList() {
        return selectedList;
    }

    public void setSelectedList(List<Long> selectedList) {
        this.selectedList = selectedList;
    }

    public List<ProjectResourceDataBean> getProjectResourceList() {
        return projectResourceList;
    }

    public void setProjectResourceList(List<ProjectResourceDataBean> projectResourceList) {
        this.projectResourceList = projectResourceList;
    }

    public String getProjectErrorMessage() {
        return projectErrorMessage;
    }

    public Long getUserId() {
        return userId;
    }

    public String getProjectRolesStatus() {
        return ProjectRolesStatus;
    }

    public void setProjectRolesStatus(String ProjectRolesStatus) {
        this.ProjectRolesStatus = ProjectRolesStatus;
    }

    public List<FileUploadDataBean> getProjectAttachmentList() {
        return projectAttachmentList;
    }

    public void setProjectAttachmentList(List<FileUploadDataBean> projectAttachmentList) {
        this.projectAttachmentList = projectAttachmentList;
    }

    public Long getProjectRolesId() {
        return projectRolesId;
    }

    public void setProjectRolesId(Long projectRolesId) {
        this.projectRolesId = projectRolesId;
    }

    public Integer getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getProjectAttachmentPath() {
        return projectAttachmentPath;
    }

    public List<FileUploadDataBean> getTempProjectAttachmentList() {
        return tempProjectAttachmentList;
    }

    public void setTempProjectAttachmentList(List<FileUploadDataBean> tempProjectAttachmentList) {
        this.tempProjectAttachmentList = tempProjectAttachmentList;
    }

    public void setProjectAttachmentPath(String projectAttachmentPath) {
        this.projectAttachmentPath = projectAttachmentPath;
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setProjectErrorMessage(String projectErrorMessage) {
        this.projectErrorMessage = projectErrorMessage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProjectDataForChart() {
        return projectDataForChart;
    }

    public Integer getMaxYAxis() {
        return maxYAxis;
    }

    public void setMaxYAxis(Integer maxYAxis) {
        this.maxYAxis = maxYAxis;
    }

    public String getTaskSummary() {
        return taskSummary;
    }

    public void setTaskSummary(String taskSummary) {
        this.taskSummary = taskSummary;
    }

    public void setProjectDataForChart(String projectDataForChart) {
        this.projectDataForChart = projectDataForChart;
    }

    private Map<String, Double> projectCompletionMap;

    public String getTaskAttachmentPath() {
        return taskAttachmentPath;
    }

    public void setTaskAttachmentPath(String taskAttachmentPath) {
        this.taskAttachmentPath = taskAttachmentPath;
    }

    public Map<String, Double> getProjectCompletionMap() {
        return projectCompletionMap;
    }

    public void setProjectCompletionMap(Map<String, Double> projectCompletionMap) {
        this.projectCompletionMap = projectCompletionMap;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public List<EmployeePerformanceDataBean> getEmployeePerformanceList() {
        return employeePerformanceList;
    }

    public void setEmployeePerformanceList(List<EmployeePerformanceDataBean> employeePerformanceList) {
        this.employeePerformanceList = employeePerformanceList;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(Integer initialSize) {
        this.initialSize = initialSize;
    }

    public TaskDataBean getTaskDataBean() {
        return taskDataBean;
    }

    public void setTaskDataBean(TaskDataBean taskDataBean) {
        this.taskDataBean = taskDataBean;
    }

    public List<RoleDataBean> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleDataBean> roleList) {
        this.roleList = roleList;
    }

    public String getTotalWork() {
        return totalWork;
    }

    public void setTotalWork(String totalWork) {
        this.totalWork = totalWork;
    }

    public List<SelectItem> getProjectMapList() {
        return projectMapList;
    }

    public void setProjectMapList(List<SelectItem> projectMapList) {
        this.projectMapList = projectMapList;
    }

    public Long getTotaltaskduration() {
        return totaltaskduration;
    }

    public void setTotaltaskduration(Long totaltaskduration) {
        this.totaltaskduration = totaltaskduration;
    }

    public Long getProjectIdForTask() {
        return ProjectIdForTask;
    }

    public void setProjectIdForTask(Long ProjectIdForTask) {
        this.ProjectIdForTask = ProjectIdForTask;
    }

    public List<TaskDataBean> getTaskForUserAndProjectList() {
        return taskForUserAndProjectList;
    }

    public void setTaskForUserAndProjectList(List<TaskDataBean> taskForUserAndProjectList) {
        this.taskForUserAndProjectList = taskForUserAndProjectList;
    }

    public String getTaskidForTaskDecline() {
        return taskidForTaskDecline;
    }

    public void setTaskidForTaskDecline(String taskidForTaskDecline) {
        this.taskidForTaskDecline = taskidForTaskDecline;
    }

    public List<TaskDataBean> getTaskForUserList() {
        return taskForUserList;
    }

    public void setTaskForUserList(List<TaskDataBean> taskForUserList) {
        this.taskForUserList = taskForUserList;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public List<ProjectDataBean> getListOfProjects() {
        return listOfProjects;
    }

    public void setListOfProjects(List<ProjectDataBean> listOfProjects) {
        this.listOfProjects = listOfProjects;
    }

    public List<NotificationDataBean> getNotificationList() {
        return NotificationList;
    }

    public void setNotificationList(List<NotificationDataBean> NotificationList) {
        this.NotificationList = NotificationList;
    }

    public List<FolderDataBean> getDataList() {
        return dataList;
    }

    public void setDataList(List<FolderDataBean> dataList) {
        this.dataList = dataList;
    }

    public List<SvnDataBean> getSvnDataList() {
        return svnDataList;
    }

    public void setSvnDataList(List<SvnDataBean> svnDataList) {
        this.svnDataList = svnDataList;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public List<ProjectResourceDataBean> getResourceOrTechnologyList() {
        return resourceOrTechnologyList;
    }

    public void setResourceOrTechnologyList(List<ProjectResourceDataBean> resourceOrTechnologyList) {
        this.resourceOrTechnologyList = resourceOrTechnologyList;
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

    public List<ProjectDataBean> getProjectDataBeanList() {
        return projectDataBeanList;
    }

    public void setProjectDataBeanList(List<ProjectDataBean> projectDataBeanList) {
        this.projectDataBeanList = projectDataBeanList;
    }

    public List<ProjectMilestoneDataBean> getProjectMilestoneDetails() {
        return projectMilestoneDetails;
    }

    public void setProjectMilestoneDetails(List<ProjectMilestoneDataBean> projectMilestoneDetails) {
        this.projectMilestoneDetails = projectMilestoneDetails;
    }

    public List<ProjectDataBean> getProjectNames() {
        return projectNames;
    }

    public void setProjectNames(List<ProjectDataBean> projectNames) {
        this.projectNames = projectNames;
    }

    public UserDataBean getUser() {
        return user;
    }

    public void setUser(UserDataBean user) {
        this.user = user;
    }

    public Long getProjectId() {

        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public List<UserDataBean> getUsers() {
        return users;
    }

    public void setUsers(List<UserDataBean> users) {
        this.users = users;
    }

    public long getUserIdForCalendar() {
        return UserIdForCalendar;
    }

    public void setUserIdForCalendar(long UserIdForCalendar) {
        this.UserIdForCalendar = UserIdForCalendar;
    }

    public List<UserDataBean> getListOfUsers() {
        return listOfUsers;
    }

    public void setListOfUsers(List<UserDataBean> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    public List getListOfyears() {
        return listOfyears;
    }

    public void setListOfyears(List listOfyears) {
        this.listOfyears = listOfyears;
    }

    public String getNextMonthName() {
        return nextMonthName;
    }

    public void setNextMonthName(String nextMonthName) {
        this.nextMonthName = nextMonthName;
    }

    public String getPrevMonthName() {
        return prevMonthName;
    }

    public void setPrevMonthName(String prevMonthName) {
        this.prevMonthName = prevMonthName;
    }

    public List<List<DayDataBean>> getCalendarDataList() {
        return calendarDataList;
    }

    public void setCalendarDataList(List<List<DayDataBean>> calendarDataList) {
        this.calendarDataList = calendarDataList;
    }

    public List<UserDataBean> getUserList() {
        return userList;
    }

    public void setUserList(List<UserDataBean> userList) {
        this.userList = userList;
    }

    public Map<Integer, String> getColorMap() {
        if (colorMap == null) {
            colorMap = new HashMap();
            colorMap.put(0, "red");
            colorMap.put(1, "blue");
            colorMap.put(2, "orange");
            colorMap.put(3, "green");
            colorMap.put(4, "pink");
            colorMap.put(5, "yellow");
            colorMap.put(6, "magenta");
            colorMap.put(7, "black");
            colorMap.put(8, "purple");

        }
        return colorMap;
    }

    public void setColorMap(Map<Integer, String> colorMap) {
        this.colorMap = colorMap;
    }

    public List<SelectItem> getPriorityList() {
        if (priorityList == null) {
            priorityList = new ArrayList<SelectItem>();
            priorityList.add(new SelectItem(SystemConstantUtil.PRIORITYLOW, "Low"));
            priorityList.add(new SelectItem(SystemConstantUtil.PRIORITYMEDIUM, "Medium"));
            priorityList.add(new SelectItem(SystemConstantUtil.PRIORITYHIGH, "High"));
        }
        return priorityList;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSysConfigStatus() {
        return sysConfigStatus;
    }

    public void setSysConfigStatus(String sysConfigStatus) {
        this.sysConfigStatus = sysConfigStatus;
    }

    public void setPriorityList(List<SelectItem> priorityList) {
        this.priorityList = priorityList;
    }

    public List<ProjectDataBean> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<ProjectDataBean> projectList) {
        this.projectList = projectList;
    }

    public boolean isShowall() {
        return showall;
    }

    public void setShowall(boolean showall) {
        this.showall = showall;
    }

    public boolean isShowDropdown() {
        return showDropdown;
    }

    public void setShowDropdown(boolean showDropdown) {
        this.showDropdown = showDropdown;
    }

    public String getShowAllStatus() {
        return showAllStatus;
    }

    public void setShowAllStatus(String showAllStatus) {
        this.showAllStatus = showAllStatus;
    }

    public List<TechnologyDataBean> getTechnologyList() {
        return technologyList;
    }

    public void setTechnologyList(List<TechnologyDataBean> technologyList) {
        this.technologyList = technologyList;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public List<SystemConfigurationDataBean> getSystemConfigurationDataBeanList() {
//        System.out.println("SystemConfigurationDataBeanList....*****"+SystemConfigurationDataBeanList);
        return SystemConfigurationDataBeanList;
    }

    public void setSystemConfigurationDataBeanList(List<SystemConfigurationDataBean> SystemConfigurationDataBeanList) {
        this.SystemConfigurationDataBeanList = SystemConfigurationDataBeanList;
    }

    public List<TaskDataBean> getTaskDataBeanList() {
        return taskDataBeanList;
    }

    public void setTaskDataBeanList(List<TaskDataBean> taskDataBeanList) {
        this.taskDataBeanList = taskDataBeanList;
    }

    public void downloadFile() {

        System.out.println("Called");

        String filePath = getFilePath();
        String fileName = getFileName();
        byte[] bytes = this.readFileContentFromFilePath(filePath);

        if (bytes != null) {
            FacesContext faces = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) faces.getExternalContext().getResponse();
            response.setContentLength(bytes.length);
            response.setContentType("application/force-download");
            response.setHeader("Content-disposition", "inline; filename=" + fileName + "");
            try {
                ServletOutputStream out;
                out = response.getOutputStream();
                out.write(bytes);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            faces.responseComplete();
        }
    }

    private byte[] readFileContentFromFilePath(String filePath) {

        byte contents[] = null;
        try {
            if (filePath != null) {
                java.io.File file = new java.io.File(filePath);
                if (file.exists()) {
                    InputStream inputStream = new FileInputStream(file); // Get the size of the file
                    long length = file.length();
                    if (length > Integer.MAX_VALUE) {
                    }
                    contents = new byte[(int) length];
                    int offset = 0;
                    int numRead = 0;
                    while (offset < contents.length && (numRead = inputStream.read(contents, offset, contents.length - offset)) >= 0) {
                        offset += numRead;
                    }
                    if (offset < contents.length) {
                        throw new IOException("Could not completely read file " + file.getName());
                    }
                    inputStream.close();
                } else {
                    System.out.println("File Not Found");
                }
            }
        } catch (Exception exception) {
            System.out.println("Exception is " + exception.getMessage());
        }
        return contents;
    }

    public String getShowMilestoneType() {
        return showMilestoneType;
    }

    public void setShowMilestoneType(String showMilestoneType) {
        this.showMilestoneType = showMilestoneType;
    }

    public String getShowProjectType() {
        return showProjectType;
    }

    public void setShowProjectType(String showProjectType) {
        this.showProjectType = showProjectType;
    }

    public List<FeatureDataBean> getListOfFeatures() {
        return listOfFeatures;
    }

    public void setListOfFeatures(List<FeatureDataBean> listOfFeatures) {
        this.listOfFeatures = listOfFeatures;
    }

    public List<PermissionDataBean> getListOfPermissionForFeature() {
        return listOfPermissionForFeature;
    }

    public void setListOfPermissionForFeature(List<PermissionDataBean> listOfPermissionForFeature) {
        this.listOfPermissionForFeature = listOfPermissionForFeature;
    }

    public List<FeatureDataBean> getListOfFeaturePermisssion() {
        return listOfFeaturePermisssion;
    }

    public void setListOfFeaturePermisssion(List<FeatureDataBean> listOfFeaturePermisssion) {
        this.listOfFeaturePermisssion = listOfFeaturePermisssion;
    }

    public String[] getPermissionsSelected() {
        return permissionsSelected;
    }

    public void setPermissionsSelected(String[] permissionsSelected) {
        this.permissionsSelected = permissionsSelected;
    }

    public Boolean getAddNew() {
        return addNew;
    }

    public void setAddNew(Boolean addNew) {
        this.addNew = addNew;
    }

    public Long getParentFeature() {
        return parentFeature;
    }

    public void setParentFeature(Long parentFeature) {
        this.parentFeature = parentFeature;
    }

    public List<FeatureDataBean> getListOfChildFeature() {
        return listOfChildFeature;
    }

    public void setListOfChildFeature(List<FeatureDataBean> listOfChildFeature) {
        this.listOfChildFeature = listOfChildFeature;
    }

    public Long getCurrentSelectedFeature() {
        return currentSelectedFeature;
    }

    public void setCurrentSelectedFeature(Long currentSelectedFeature) {
        this.currentSelectedFeature = currentSelectedFeature;
    }

    public List<Map<Long, String>> getSelectedFeaturePermissionForRole() {
        return selectedFeaturePermissionForRole;
    }

    public void setSelectedFeaturePermissionForRole(List<Map<Long, String>> selectedFeaturePermissionForRole) {
        this.selectedFeaturePermissionForRole = selectedFeaturePermissionForRole;
    }

    public List<FeatureDataBean> getListOfMenuMenuItemFeatures() {
        return listOfMenuMenuItemFeatures;
    }

    public void setListOfMenuMenuItemFeatures(List<FeatureDataBean> listOfMenuMenuItemFeatures) {
        this.listOfMenuMenuItemFeatures = listOfMenuMenuItemFeatures;
    }

    public Map<String, Map<String, String>> getListOfRoleFeaturePermission() {
        return listOfRoleFeaturePermission;
    }

    public void setListOfRoleFeaturePermission(Map<String, Map<String, String>> listOfRoleFeaturePermission) {
        this.listOfRoleFeaturePermission = listOfRoleFeaturePermission;
    }

    public List<RoleDataBean> getListOfAllActiveRoles() {
        return listOfAllActiveRoles;
    }

    public void setListOfAllActiveRoles(List<RoleDataBean> listOfAllActiveRoles) {
        this.listOfAllActiveRoles = listOfAllActiveRoles;
    }

    public String getParentFeatureName() {
        return parentFeatureName;
    }

    public void setParentFeatureName(String parentFeatureName) {
        this.parentFeatureName = parentFeatureName;
    }

    public List<PermissionDataBean> getListOFpermissionWithSameFeature() {
        return listOFpermissionWithSameFeature;
    }

    public void setListOFpermissionWithSameFeature(List<PermissionDataBean> listOFpermissionWithSameFeature) {
        this.listOFpermissionWithSameFeature = listOFpermissionWithSameFeature;
    }

    public List<RoleDataBean> getListOfRoleWithPermissionID() {
        return listOfRoleWithPermissionID;
    }

    public void setListOfRoleWithPermissionID(List<RoleDataBean> listOfRoleWithPermissionID) {
        this.listOfRoleWithPermissionID = listOfRoleWithPermissionID;
    }

    public List<UMFeaturePermission> getPermissionsToAdd() {
        return permissionsToAdd;
    }

    public void setPermissionsToAdd(List<UMFeaturePermission> permissionsToAdd) {
        this.permissionsToAdd = permissionsToAdd;
    }

    public List<ProjectResourceDataBean> getManageProjectResource() {
        return manageProjectResource;
    }

    public void setManageProjectResource(List<ProjectResourceDataBean> manageProjectResource) {
        this.manageProjectResource = manageProjectResource;
    }

    public List<ProjectResourceDataBean> getProjectResourceTech() {
        return projectResourceTech;
    }

    public void setProjectResourceTech(List<ProjectResourceDataBean> projectResourceTech) {
        this.projectResourceTech = projectResourceTech;
    }

    public List<SelectItem> getProjectResourceTool() {
        return projectResourceTool;
    }

    public void setProjectResourceTool(List<SelectItem> projectResourceTool) {
        this.projectResourceTool = projectResourceTool;
    }

    public List<SelectItem> getProjectResourceServer() {
        return projectResourceServer;
    }

    public void setProjectResourceServer(List<SelectItem> projectResourceServer) {
        this.projectResourceServer = projectResourceServer;
    }

    public List<SelectItem> getProjectResourceOS() {
        return projectResourceOS;
    }

    public void setProjectResourceOS(List<SelectItem> projectResourceOS) {
        this.projectResourceOS = projectResourceOS;
    }

    public List<SelectItem> getProjectResourceBrowser() {
        return projectResourceBrowser;
    }

    public void setProjectResourceBrowser(List<SelectItem> projectResourceBrowser) {
        this.projectResourceBrowser = projectResourceBrowser;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getMessageProjectSummary() {
        return messageProjectSummary;
    }

    public void setMessageProjectSummary(String messageProjectSummary) {
        this.messageProjectSummary = messageProjectSummary;
    }

    public List<TaskAttachmentDataBean> getTaskAttachments() {
        return taskAttachments;
    }

    public void setTaskAttachments(List<TaskAttachmentDataBean> taskAttachments) {
        this.taskAttachments = taskAttachments;
    }

    public Long getRoleIdOfUserRole() {
        return roleIdOfUserRole;
    }

    public void setRoleIdOfUserRole(Long roleIdOfUserRole) {
        this.roleIdOfUserRole = roleIdOfUserRole;
    }

    public List<TaskCommentDataBean> getListOfComments() {
        return listOfComments;
    }

    public void setListOfComments(List<TaskCommentDataBean> listOfComments) {
        this.listOfComments = listOfComments;
    }

    public List<Long> getTechIdsofProject() {
        return techIdsofProject;
    }

    public void setTechIdsofProject(List<Long> techIdsofProject) {
        this.techIdsofProject = techIdsofProject;
    }

    public String getProjectNameExist() {
        return projectNameExist;
    }

    public void setProjectNameExist(String projectNameExist) {
        this.projectNameExist = projectNameExist;
    }

    public String getProjectAliasExist() {
        return projectAliasExist;
    }

    public void setProjectAliasExist(String projectAliasExist) {
        this.projectAliasExist = projectAliasExist;
    }

}
