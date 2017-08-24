/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.transformerbean;

import com.argusoft.armms.core.ProjectService;
import com.argusoft.armms.core.TaskService;
import com.argusoft.armms.model.Project;
import com.argusoft.armms.model.ProjectAttachment;
import com.argusoft.armms.model.ProjectMilestone;
import com.argusoft.armms.model.ProjectResourceDetail;
import com.argusoft.armms.model.ProjectTechnologyDetail;
import com.argusoft.armms.model.TaskMaster;
import com.argusoft.armms.web.databean.FileUploadDataBean;
import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import com.argusoft.armms.web.databean.ProjectDataBean;
import com.argusoft.armms.web.reports.databean.EmployeePerformanceDataBean;
import com.argusoft.armms.web.usermanagement.databean.UserDataBean;
import com.argusoft.armms.web.util.SystemConstantUtil;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.generic.database.exception.GenericDatabaseException;
import com.argusoft.usermanagement.common.core.UMSystemConfigurationService;
import com.argusoft.usermanagement.common.core.UMUserService;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import com.argusoft.usermanagement.common.model.UMUser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.springframework.util.CollectionUtils;

/**
 *
 * @author shifa
 */
@ManagedBean(name = "projectTransformerBean")
@RequestScoped
public class ProjectTransformerBean {

    /**
     * Creates a new instance of ProjectTransformerBean
     */
    @ManagedProperty(value = "#{userService}")
    private UMUserService userService;
    @ManagedProperty(value = "#{fileUploadDataBean}")
    private FileUploadDataBean fileUploadDataBean;
    @ManagedProperty(value = "#{projectDataBean}")
    private ProjectDataBean projectDataBean;
    @ManagedProperty(value = "#{projectService}")
    private ProjectService projectService;
    @ManagedProperty(value = "#{taskService}")
    private TaskService taskService;
    @ManagedProperty(value = "#{loginDataBean}")
    private LoginDataBean loginDataBean;
    @ManagedProperty(value = "#{userDataBean}")
    private UserDataBean userDataBean;
    @ManagedProperty(value = "#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;
    @ManagedProperty(value = "#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;
    @ManagedProperty(value = "#{systemConfigurationService}")
    private UMSystemConfigurationService systemConfigurationService;
    @ManagedProperty("#{employeePerformanceDataBean}")
    private EmployeePerformanceDataBean employeePerformanceDataBean;
    @ManagedProperty(value = "#{projectResourceTransformerBean}")
    private ProjectResourceTransformerBean projectResourceTransformerBean;

    public ProjectResourceTransformerBean getProjectResourceTransformerBean() {
        return projectResourceTransformerBean;
    }

    public void setProjectResourceTransformerBean(ProjectResourceTransformerBean projectResourceTransformerBean) {
        this.projectResourceTransformerBean = projectResourceTransformerBean;
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public FileUploadDataBean getFileUploadDataBean() {
        return fileUploadDataBean;
    }

    public void setFileUploadDataBean(FileUploadDataBean fileUploadDataBean) {
        this.fileUploadDataBean = fileUploadDataBean;
    }

    public UserDataBean getUserDataBean() {
        return userDataBean;
    }

    public void setUserDataBean(UserDataBean userDataBean) {
        this.userDataBean = userDataBean;
    }

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public EmployeePerformanceDataBean getEmployeePerformanceDataBean() {
        return employeePerformanceDataBean;
    }

    public void setEmployeePerformanceDataBean(EmployeePerformanceDataBean employeePerformanceDataBean) {
        this.employeePerformanceDataBean = employeePerformanceDataBean;
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

    public LoginDataBean getLoginDataBean() {
        return loginDataBean;
    }

    public void setLoginDataBean(LoginDataBean loginDataBean) {
        this.loginDataBean = loginDataBean;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public ProjectTransformerBean() {
    }

    public ProjectDataBean getProjectDataBean() {
        return projectDataBean;
    }

    public void setProjectDataBean(ProjectDataBean projectDataBean) {

        this.projectDataBean = projectDataBean;
    }

    public UMUserService getUserService() {
        return userService;
    }

    public void setUserService(UMUserService userService) {
        this.userService = userService;
    }

    /**
     * convertProjectModelToProjectDataBean method convert model values into
     * databean values.
     *
     * @author Shifa
     */
    private ProjectDataBean convertProjectModelToProjectDataBean(Project project, ProjectDataBean projDataBean) {
        projDataBean.setProjectId(project.getProjectId());
        projDataBean.setProjectName(project.getProjectName());
        projDataBean.setProjectAlias(project.getProjectAlias());
        projDataBean.setProjectPriority(project.getProjectPriority());
        projDataBean.setProjectDescription(project.getProjectDescription());
        projDataBean.setCreatedBy(project.getCreatedBy());
        projDataBean.setCreatedOn(project.getCreatedOn());
        projDataBean.setStartDate(project.getStartDate());
        projDataBean.setEstimatedEndDate(project.getEstimatedEndDate());
//        projDataBean.setAssignedTo(project.getProjectManager());

        if (project.getSvnUrl() != null) {
            if (project.getSvnUrl().isEmpty()) {
                projDataBean.setSvnUrl(SystemConstantUtil.NOTAVAILABLE);
            } else {
                projDataBean.setSvnUrl(project.getSvnUrl());
            }
        }
        projDataBean.setIsActive(project.getIsActive());
        if (projDataBean.getIsActive()) {
            projDataBean.setStatus(SystemConstantUtil.ACTIVE);
        } else {
            projDataBean.setStatus(SystemConstantUtil.INACTIVE);
        }

        return projDataBean;

    }

    /**
     * convertProjectDataBeanToProjectModel method set model values fetching
     * values from databean.
     *
     * @author Shifa
     */
    public Project convertProjectDataBeanToProjectModel(ProjectDataBean projectDataBean, String operation, Project project) {
        if (project == null) {
            project = new Project();
        }
        try {

            if (projectDataBean.getStatus() != null) {
                if (SystemConstantUtil.INACTIVE.equalsIgnoreCase(projectDataBean.getStatus())) {
                    project.setIsActive(Boolean.FALSE);

                } else {
                    project.setIsActive(Boolean.TRUE);
                }
            }
//                else {
//
//                project.setIsActive(projectDataBean.getIsActive());
//            }
            project.setProjectAlias(projectDataBean.getProjectAlias());
            project.setProjectName(projectDataBean.getProjectName());
            project.setProjectDescription(projectDataBean.getProjectDescription());
            project.setProjectPriority(projectDataBean.getProjectPriority());
            project.setStartDate(projectDataBean.getStartDate());
            project.setEstimatedEndDate(projectDataBean.getEstimatedEndDate());
            project.setActualEndDate(projectDataBean.getActualEndDate());
//            project.setProjectManager(projectDataBean.getAssignedTo());
            project.setIsArchive(false);
            project.setCreatedOn(new Date());

            project.setSvnUrl(projectDataBean.getSvnUrl());

            project.setCreatedBy(loginDataBean.getId());
            if (operation != null && operation.equalsIgnoreCase(SystemConstantUtil.UPDATE_OPERATION)) {
                project.setLastModifiedOn(new Date());
                project.setLastModifiedBy(loginDataBean.getId());
            } else if (operation != null && operation.equalsIgnoreCase(SystemConstantUtil.CREATE_OPERATION)) {
                project.setCreatedOn(new Date());
                project.setCreatedBy(loginDataBean.getId());
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
        return project;
    }

    /**
     * addProject method for adding new Project
     *
     * @author Shifa
     */
    public String addProject() throws UMUserManagementException {
        try {
            systemResultViewUtil.setProjectNameExist(null);
            Boolean isProjectExist = projectService.isProjectExist(projectDataBean.getProjectName());
            Boolean isProjectAliasExist = projectService.isProjectALiasExist(projectDataBean.getProjectAlias());
            Project pm = new Project();
            if (isProjectExist.equals(Boolean.TRUE)) {
                systemResultViewUtil.setProjectNameExist(SystemConstantUtil.PROJECTNAME_UNAVAILABLE);
                return null;
            } else if (isProjectAliasExist.equals(Boolean.TRUE)) {
                systemResultViewUtil.setProjectAliasExist(SystemConstantUtil.PROJECTALIAS_UNAVAILABLE);
                return null;
            } else {
                pm.setProjectAlias(projectDataBean.getProjectAlias());
                pm.setProjectName(projectDataBean.getProjectName());
            }
            pm.setProjectDescription(projectDataBean.getProjectDescription());
            pm.setProjectPriority(projectDataBean.getProjectPriority());
            pm.setStartDate(projectDataBean.getStartDate());
            pm.setEstimatedEndDate(projectDataBean.getEstimatedEndDate());
            pm.setCreatedOn(new Date());
//            pm.setProjectManager(projectDataBean.getAssignedTo());
            pm.setIsActive(true);
            pm.setIsArchive(false);
            pm.setCreatedBy(loginDataBean.getId());
            pm.setSvnUrl(projectDataBean.getSvnUrl());
            projectService.createProject(pm);

            return SystemConstantUtil.SUCCESS;
        } catch (Exception e) {
            return SystemConstantUtil.FAILURE;
        }

    }

    /**
     * displayAllActiveProjects method retrieves all active project and adds a
     * static name All for displaying on the page in latest projects block
     *
     * @return Returns the List of Object of Class ProjectDataBean.
     * @author shreya
     */
    public List<ProjectDataBean> displayAllActiveProjects() throws UMUserManagementException {
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
        List<Project> projectdetail = projectService.retrieveActiveOrInactiveProjects(true);
        List<ProjectDataBean> projectlistDataBeans = new ArrayList<>();
        for (Project project : projectdetail) {
            ProjectDataBean projDataBean = new ProjectDataBean();
            projDataBean = convertProjectModelToProjectDataBean(project, projDataBean);
//            projDataBean.setProjectManagerName(userMap.get(project.getProjectManager()));
            projectlistDataBeans.add(projDataBean);
        }
        if (!projectlistDataBeans.isEmpty()) {
            ProjectDataBean projDataBean1 = new ProjectDataBean();
            projDataBean1.setProjectId(-1l);
            projDataBean1.setProjectName("All");
            projDataBean1.setCreatedOn(new Date());
            projDataBean1.setProjectAlias("All");
            projectlistDataBeans.add(projDataBean1);

        }
        return projectlistDataBeans;
    }

    /**
     * retrieveProjectById method retrieves project corresponding to project id
     *
     * @author Shifa
     */
    public ProjectDataBean retrieveProjectDetailByProjectId(long projectid) throws UMUserManagementException {
        List<UMUser> userlist = userService.getAllActiveUsers();
        Project project = new Project();
        Map<Long, String> userMap = new HashMap<>();
        for (UMUser userobj : userlist) {
            StringBuffer name = new StringBuffer();
            name.append(userobj.getFirstName());
            if (userobj.getLastName() != null) {
                name.append(" ").append(userobj.getLastName());
            }
            userMap.put(userobj.getId(), name.toString());
        }
        project = projectService.retrieveProjectById(projectid);
        projectDataBean.setProjectId(project.getProjectId());
        projectDataBean.setProjectName(project.getProjectName());
        projectDataBean.setProjectAlias(project.getProjectAlias());
        projectDataBean.setProjectDescription(project.getProjectDescription());
        projectDataBean.setProjectPriority(project.getProjectPriority());
        projectDataBean.setStartDate(project.getStartDate());
        projectDataBean.setEstimatedEndDate(project.getEstimatedEndDate());
        projectDataBean.setSvnUrl(project.getSvnUrl());
        if (project.getActualEndDate() != null) {
            projectDataBean.setActualEndDate(project.getActualEndDate());
        }
//        projectDataBean.setAssignedTo(project.getProjectManager());
//        projectDataBean.setProjectManagerName(userMap.get(project.getProjectManager()));

        Boolean result = project.getIsActive();
        if (result.equals(Boolean.TRUE)) {
            projectDataBean.setStatus(SystemConstantUtil.ACTIVE);
        } else {
            projectDataBean.setStatus(SystemConstantUtil.INACTIVE);
        }
        projectDataBean.setIsActive(project.getIsActive());

        return projectDataBean;
    }

    /**
     * updateProject method for updating the Project
     *
     * @author Shifa
     */
    public String updateProject(ProjectDataBean projectDataBean) {

        try {
            Project project = projectService.retrieveProjectById(systemResultSessionUtil.getProjectId());
            project = convertProjectDataBeanToProjectModel(projectDataBean, SystemConstantUtil.UPDATE_OPERATION, project);
            project.setProjectId(systemResultSessionUtil.getProjectId());
//            projectMaster.setProjectName(projectDataBean.getProjectName());
            if (projectDataBean.getStatus() != null) {
                if (SystemConstantUtil.INACTIVE.equalsIgnoreCase(projectDataBean.getStatus())) {
                    project.setIsActive(Boolean.FALSE);
                    // For inactivating all the milestones corresponding to that project if the project is inactivated.
                    List<ProjectMilestone> projectMilestonelist = projectService.retrieveMilestonesById(systemResultSessionUtil.getProjectId());
                    for (ProjectMilestone milestone : projectMilestonelist) {
                        milestone.setIsActive(Boolean.FALSE);
                        projectService.updateProjectMilestone(milestone);
                    }
                    //For inactivating all the resources corresponding to that project if the project is inactivated
                    List<ProjectResourceDetail> projectResourcelist = projectService.retrieveProjectResourceByProjectId(systemResultSessionUtil.getProjectId());
                    for (ProjectResourceDetail resource : projectResourcelist) {

                        resource.setIsActive(Boolean.FALSE);

                        projectService.updateProjectResource(resource);
                    }
                    //For inactivating all the technologies corresponding to that project if the project is inactivated
                    List<ProjectTechnologyDetail> projectTechnologylist = projectService.retrieveProjectTechnologyByProjectId(systemResultSessionUtil.getProjectId());
                    for (ProjectTechnologyDetail tech : projectTechnologylist) {

                        tech.setIsActive(Boolean.FALSE);

                        projectService.updateProjectTechnology(tech);
                    }
                    //     For inactivating all the task corresponding to that project if the project is inactivated
                    List<TaskMaster> tasklist = taskService.retrieveTaskByProjectId(systemResultSessionUtil.getProjectId());
                    for (TaskMaster task : tasklist) {
                        task.setIsActive(Boolean.FALSE);
                        taskService.updateTask(task);
                    }

                } else {
                    project.setIsActive(Boolean.TRUE);
                    List<ProjectMilestone> projectMilestonelist = projectService.retrieveMilestonesById(systemResultSessionUtil.getProjectId());
                    for (ProjectMilestone milestone : projectMilestonelist) {
                        milestone.setIsActive(Boolean.TRUE);
                        projectService.updateProjectMilestone(milestone);
                    }

                    List<ProjectResourceDetail> projectResourcelist = projectService.retrieveProjectResourceByProjectId(systemResultSessionUtil.getProjectId());
                    for (ProjectResourceDetail resource : projectResourcelist) {

                        resource.setIsActive(Boolean.TRUE);

                        projectService.updateProjectResource(resource);
                    }

                    List<ProjectTechnologyDetail> projectTechnologylist = projectService.retrieveProjectTechnologyByProjectId(systemResultSessionUtil.getProjectId());
                    for (ProjectTechnologyDetail tech : projectTechnologylist) {

                        tech.setIsActive(Boolean.TRUE);

                        projectService.updateProjectTechnology(tech);
                    }
                    List<TaskMaster> tasklist = taskService.retrieveTaskByProjectId(systemResultSessionUtil.getProjectId());
                    for (TaskMaster task : tasklist) {
                        task.setIsActive(Boolean.TRUE);
                        taskService.updateTask(task);
                    }

                }

            }

//                else {
//
//                project.setIsActive(projectDataBean.getIsActive());
//            }
            projectService.updateProject(project);
            systemResultSessionUtil.setSelectedProjectId(systemResultSessionUtil.getProjectId());
            systemResultSessionUtil.setProjectId(null);
            return SystemConstantUtil.EDIT_SUCCESSFUL;
        } catch (Exception E) {
            E.printStackTrace();
            return SystemConstantUtil.FAILURE;

        }

    }

    public void deleteRecord(Project projectmaster) {
        projectmaster.setIsActive(false);
        projectService.updateProject(projectmaster);

    }

    /**
     * retrieveAllActiveAndInActiveProjects method retrieves all the active &
     * inactive projects
     *
     * @author Shifa
     */
    public List<ProjectDataBean> retrieveAllActiveAndInActiveProjects(Boolean active) throws UMUserManagementException {

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

        List<Project> allprojectdetail;
        if (active != null) {
            if (active == true) {
                allprojectdetail = projectService.retrieveActiveOrInactiveProjects(true);
            } else {
                allprojectdetail = projectService.retrieveActiveOrInactiveProjects(false);
            }
        } else {
            allprojectdetail = projectService.retrieveActiveOrInactiveProjects(null);
        }
        List<ProjectDataBean> projectlistDataBeans = new ArrayList<>();
        for (Project project : allprojectdetail) {
            ProjectDataBean projDataBean = new ProjectDataBean();
            projDataBean = convertProjectModelToProjectDataBean(project, projDataBean);
//            projDataBean.setProjectManagerName(userMap.get(project.getProjectManager()));

            projectlistDataBeans.add(projDataBean);
        }
        return projectlistDataBeans;

    }

    public Project retrieveProjectById(Long projectId) {
        return projectService.retrieveProjectById(projectId);
    }

    /**
     * to retrieve active projects of particular user
     *
     * @author ravi
     * @param userId
     * @return list of ProjectDataBean
     */
    public List<ProjectDataBean> retrieveAllActiveProjectsOfUser(long userId) throws UMUserManagementException, GenericDatabaseException {

        List<ProjectDataBean> retieveAllActiveProjects = new ArrayList<>();
        UMUser user = userService.retrieveUserById(userId, null);
        if (user.getType().equals("ROLE_SADMIN")) {
            retieveAllActiveProjects = retrieveAllActiveAndInActiveProjects(Boolean.TRUE);
        } else {
            List<Project> ActiveProjectsOfUser = projectService.retieveAllActiveProjectsOfUser(userId);
            List<ProjectDataBean> activeProjects = new ArrayList<>();

            for (Project project : ActiveProjectsOfUser) {
                ProjectDataBean projectDataBean = new ProjectDataBean();
                projectDataBean.setProjectId(project.getProjectId());
                projectDataBean.setCreatedOn(project.getCreatedOn());
                if (project.getProjectAlias() == null) {
                    projectDataBean.setProjectAlias(project.getProjectName());
                } else {
                    projectDataBean.setProjectAlias(project.getProjectAlias());
                }
                projectDataBean.setSvnUrl(project.getSvnUrl());
                retieveAllActiveProjects.add(projectDataBean);
            }
        }
        return retieveAllActiveProjects;
    }

    /**
     * @return Returns the List of Object of Class ProjectDataBean.
     * @author shreya
     */
    public List<ProjectDataBean> changeProject() {
        Long userId = systemResultViewUtil.getUserId();
        List<ProjectDataBean> projectListDataBean = new ArrayList<>();
        if (userId != null) {
            List<Project> listOfAllActiveProjectsOfUser = projectService.retieveAllActiveProjectsOfUser(userId);

            for (Project projectMaster : listOfAllActiveProjectsOfUser) {
                ProjectDataBean projectDataBean = new ProjectDataBean();
                projectDataBean.setProjectId(projectMaster.getProjectId());
                projectDataBean.setProjectName(projectMaster.getProjectAlias());
                projectListDataBean.add(projectDataBean);
            }

        }
        return projectListDataBean;

    }

    /**
     * addProjectAttachment method adds list of project attachment in the table
     * ProjectAttachment
     *
     * @author shreya
     */
    public void addProjectAttachment() {
        Project project = projectService.retrieveProjectById(systemResultViewUtil.getProjectId());
        if (!CollectionUtils.isEmpty(systemResultViewUtil.getTempProjectAttachmentList())) {
            List<ProjectAttachment> projectAttachmentModelList = new ArrayList<>();
            for (FileUploadDataBean fileUploadBean : systemResultViewUtil.getTempProjectAttachmentList()) {
                ProjectAttachment projectAttachmentObj = new ProjectAttachment();
                projectAttachmentObj.setProjectAttachmentName(fileUploadBean.getFileName());
                projectAttachmentObj.setProjectAttachmentPath(project.getProjectAlias() + File.separator + fileUploadBean.getFileName());
                projectAttachmentObj.setProjectId(project);
                projectAttachmentObj.setProjectAttachmentSize(fileUploadBean.getFileSize());
                projectAttachmentObj.setUploadedBy(loginDataBean.getId());
                projectAttachmentObj.setCreatedOn(Calendar.getInstance().getTime());
                projectAttachmentObj.setIsActive(Boolean.TRUE);
                projectAttachmentModelList.add(projectAttachmentObj);
            }
            projectService.addProjectAttachment(projectAttachmentModelList);
        }

    }

    /**
     * retrieveProjectAttachmentByProjectId method retrieve all the project
     * attachment from projectId
     *
     * @return list of Object of FileUploadDataBean
     * @author shreya
     */
    public List<FileUploadDataBean> retrieveProjectAttachmentByProjectId() throws FileNotFoundException, IOException, UMUserManagementException {

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
        Long projectId = systemResultViewUtil.getProjectId();
        List<ProjectAttachment> uploadsList = projectService.retrieveProjectAttachmentsByProjectId(projectId);
        List<FileUploadDataBean> fileUploadsList = new ArrayList<>();
        for (ProjectAttachment projectAttachmentObj : uploadsList) {
            FileUploadDataBean fileUploadDataBeanVar = new FileUploadDataBean();
            String attachmentName = projectAttachmentObj.getProjectAttachmentName();
            String filename[] = attachmentName.split("#");
            fileUploadDataBeanVar.setFileName(filename[1]);
            String document_file_path = SystemConstantUtil.DOCUMENT_FILE_PATH + projectAttachmentObj.getProjectAttachmentPath();
            fileUploadDataBeanVar.setFilePath(document_file_path);
            fileUploadDataBeanVar.setFileSize(((projectAttachmentObj.getProjectAttachmentSize()) / 1024));
            fileUploadDataBeanVar.setFileSizeKb(((projectAttachmentObj.getProjectAttachmentSize()) / 1024) + " Kb");
            fileUploadDataBeanVar.setCreatedOn(projectAttachmentObj.getCreatedOn());
            fileUploadDataBeanVar.setUploadedByName(userMap.get(projectAttachmentObj.getUploadedBy()));
            fileUploadDataBeanVar.setUploadedBy(projectAttachmentObj.getUploadedBy());
            fileUploadDataBeanVar.setProjectId(projectAttachmentObj.getProjectId().getProjectId());
            fileUploadDataBeanVar.setProjectName(projectAttachmentObj.getProjectId().getProjectAlias());
            fileUploadDataBeanVar.setProjectAttachmentId(projectAttachmentObj.getProjectAttachmentId());
            fileUploadsList.add(fileUploadDataBeanVar);
        }
        return fileUploadsList;

    }

    /**
     * deleteProjectAttachment method deletes the project attachment from
     * passing Object of ProjectAttachment
     *
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws
     * com.argusoft.usermanagement.common.exception.UMUserManagementException
     * @author shreya
     */
    public void deleteProjectAttachment() throws IOException, FileNotFoundException, UMUserManagementException {
        Long projectAttachmentId = fileUploadDataBean.getProjectAttachmentId();
        ProjectAttachment projectAttachmentObj = projectService.retrieveProjectAttachmentById(projectAttachmentId);
        projectAttachmentObj.setLstModifiedBy(loginDataBean.getId());
        projectService.deleteProjectAttachment(projectAttachmentObj);
    }
}
