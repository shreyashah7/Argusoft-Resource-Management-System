/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.servicebean;

import com.argusoft.armms.model.Project;
import com.argusoft.armms.web.databean.FileUploadDataBean;
import com.argusoft.armms.web.databean.ProjectDataBean;
import com.argusoft.armms.web.transformerbean.ProjectTransformerBean;
import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import com.argusoft.armms.web.usermanagement.databean.MessageDataBean;
import com.argusoft.armms.web.usermanagement.transformerbean.UserTransformerBean;
import com.argusoft.armms.web.util.SystemConstantUtil;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.generic.database.exception.GenericDatabaseException;
import com.argusoft.usermanagement.common.core.UMSystemConfigurationService;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.springframework.util.CollectionUtils;

/**
 *
 * @author shifa
 */
@ManagedBean(name = "projectServiceBean")
@RequestScoped
public class ProjectServiceBean implements Serializable {

    /**
     * Creates a new instance of ProjectMasterServiceBean
     */
    @ManagedProperty(value = "#{projectTransformerBean}")
    private ProjectTransformerBean projectTransformerBean;
    @ManagedProperty(value = "#{projectDataBean}")
    private ProjectDataBean projectDataBean;
    @ManagedProperty(value = "#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;
    @ManagedProperty("#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;
    @ManagedProperty("#{messageDataBean}")
    private MessageDataBean messageDataBean;
    @ManagedProperty("#{loginDataBean}")
    private LoginDataBean loginDataBean;
    @ManagedProperty("#{fileUploadDataBean}")
    private FileUploadDataBean fileUploadDataBean;
    @ManagedProperty(value = "#{systemConfigurationService}")
    private UMSystemConfigurationService systemConfigurationService;
    @ManagedProperty("#{userTransformerBean}")
    private UserTransformerBean userTransformerBean;

    public UserTransformerBean getUserTransformerBean() {
        return userTransformerBean;
    }

    public void setUserTransformerBean(UserTransformerBean userTransformerBean) {
        this.userTransformerBean = userTransformerBean;
    }

    public LoginDataBean getLoginDataBean() {
        return loginDataBean;
    }

    public void setLoginDataBean(LoginDataBean loginDataBean) {
        this.loginDataBean = loginDataBean;
    }

    public MessageDataBean getMessageDataBean() {
        return messageDataBean;
    }

    public void setMessageDataBean(MessageDataBean messageDataBean) {
        this.messageDataBean = messageDataBean;
    }

    public UMSystemConfigurationService getSystemConfigurationService() {
        return systemConfigurationService;
    }

    public void setSystemConfigurationService(UMSystemConfigurationService systemConfigurationService) {
        this.systemConfigurationService = systemConfigurationService;
    }

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public FileUploadDataBean getFileUploadDataBean() {
        return fileUploadDataBean;
    }

    public void setFileUploadDataBean(FileUploadDataBean fileUploadDataBean) {
        this.fileUploadDataBean = fileUploadDataBean;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    public SystemResultSessionUtil getSystemResultSessionUtil() {
        return systemResultSessionUtil;
    }

    public void setSystemResultSessionUtil(SystemResultSessionUtil systemResultSessionUtil) {
        this.systemResultSessionUtil = systemResultSessionUtil;
    }

    public ProjectDataBean getProjectDataBean() {
        return projectDataBean;
    }

    public void setProjectDataBean(ProjectDataBean projectDataBean) {

        this.projectDataBean = projectDataBean;
    }

    public ProjectServiceBean() {
    }

    public ProjectTransformerBean getProjectTransformerBean() {
        return projectTransformerBean;
    }

    public void setProjectTransformerBean(ProjectTransformerBean projectTransformerBean) {
        this.projectTransformerBean = projectTransformerBean;
    }

    public void init() {
        if (systemResultViewUtil.getProjectId() == null || !systemResultViewUtil.getProjectId().equals(systemResultSessionUtil.getSelectedProjectId())) {
            systemResultViewUtil.setProjectId(systemResultSessionUtil.getSelectedProjectId());
        }

    }

    /**
     * retrieveProjectManagerList method retrieves the list of projectManagers
     *
     * @author Shifa
     */
    public void retrieveProjectManagerList() {
        try {
            systemResultViewUtil.setUserList(userTransformerBean.retrieveFullNameOfActiveUsers());

        } catch (UMUserManagementException ex) {
            Logger.getLogger(ProjectServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void retrieveAllActiveProjects() throws UMUserManagementException {

        systemResultViewUtil.setProjectList(projectTransformerBean.retrieveAllActiveAndInActiveProjects(Boolean.TRUE));
    }

    public void displayAllActiveProjects() throws UMUserManagementException {
            systemResultViewUtil.setProjectDataBeanList(projectTransformerBean.displayAllActiveProjects());
        }        

    /**
     * addProject method for adding new Project
     *
     * @author Shifa
     */
    public String addProject() throws UMUserManagementException {

        String result = projectTransformerBean.addProject();
        systemResultSessionUtil.setProjectResult(result);
        if (result != null) {
            return "pretty:manageProject";
        } else {
            return null;
        }

    }

    /**
     * retrieveProjectById method returns instance of class Project by searching
     * project Id
     *
     * @author Shifa
     */
    public void retrieveProjectById() throws UMUserManagementException {
        projectTransformerBean.retrieveProjectDetailByProjectId(systemResultSessionUtil.getProjectId());

    }

    /**
     * cleanDataBean method set all the properties of ProjectDatabean to null
     *
     * @author Shifa
     */
    public void cleanDataBean() {
        projectDataBean.setProjectName(null);
        projectDataBean.setProjectAlias(null);
        projectDataBean.setProjectDescription(null);
        projectDataBean.setProjectPriority(null);
        projectDataBean.setStartDate(null);
        projectDataBean.setEstimatedEndDate(null);
        projectDataBean.setProjectManagerName(null);
        projectDataBean.setAssignedTo(null);

    }

    /**
     * updateProject method for updating the Project
     *
     * @author Shifa
     */
    public String updateProject() throws UMUserManagementException {
        String result = projectTransformerBean.updateProject(projectDataBean);
        systemResultSessionUtil.setProjectResult(result);
        this.showProjectByType();
        return "pretty:manageProject";
    }

    public void deleteRecord(Project proj) {
        projectTransformerBean.deleteRecord(proj);
    }

    /**
     * changeStatus method for changing the status(active/inactive) of the
     * project
     *
     * @author Shifa
     */
    public void changeStatus(ProjectDataBean projectDataBean) throws UMUserManagementException {
        try {

            List<ProjectDataBean> projectList = systemResultViewUtil.getProjectList();
            if (SystemConstantUtil.ACTIVE.equals(projectDataBean.getStatus())) {
                projectDataBean.setStatus("InActive");
                messageDataBean.setMessage("Project Deactivated Successfully");
                messageDataBean.setIsSuccess(Boolean.TRUE);

            } else {
                projectDataBean.setStatus("Active");
                messageDataBean.setMessage("Project Activated Successfully");
                messageDataBean.setIsSuccess(Boolean.TRUE);

            }
            systemResultSessionUtil.setProjectId(projectDataBean.getProjectId());

            projectTransformerBean.updateProject(projectDataBean);
            this.showProjectByType();

        } catch (Exception E) {
            messageDataBean.setMessage("Error in changing status!!!!");
            messageDataBean.setIsSuccess(Boolean.FALSE);
        }
    }

    /**
     * showProjectByType method retrieves a list of projects on the basis of
     * type(active,inactive,all) selected.
     *
     * @author Shifa
     */
    public void showProjectByType() throws UMUserManagementException {
        if (SystemConstantUtil.ACTIVE.equals(systemResultViewUtil.getShowProjectType())) {
            systemResultViewUtil.setProjectList(projectTransformerBean.retrieveAllActiveAndInActiveProjects(Boolean.TRUE));
        }

        if (SystemConstantUtil.SHOWALL.equals(systemResultViewUtil.getShowProjectType())) {
            systemResultViewUtil.setProjectList(projectTransformerBean.retrieveAllActiveAndInActiveProjects(null));
        }
        if (SystemConstantUtil.INACTIVE.equals(systemResultViewUtil.getShowProjectType())) {
            systemResultViewUtil.setProjectList(projectTransformerBean.retrieveAllActiveAndInActiveProjects(Boolean.FALSE));
        }
    }

    public void displayMessageByType() throws UMUserManagementException {

        if (systemResultSessionUtil.getProjectResult() != null) {
            if (systemResultSessionUtil.getProjectResult().equals(SystemConstantUtil.SUCCESS)) {
                messageDataBean.setMessage("Project added successfully.");
                messageDataBean.setIsSuccess(Boolean.TRUE);
            } else if (systemResultSessionUtil.getProjectResult().equals(SystemConstantUtil.FAILURE)) {
                messageDataBean.setMessage("Unexpected error occured!");
                messageDataBean.setIsSuccess(Boolean.FALSE);
            } else if (systemResultSessionUtil.getProjectResult().equals(SystemConstantUtil.EDIT_SUCCESSFUL)) {
                messageDataBean.setMessage("Project updated successfully.");
                messageDataBean.setIsSuccess(Boolean.TRUE);
            }

        }
        systemResultSessionUtil.setProjectResult(null);

    }

    public void changeProject() {

        systemResultViewUtil.setProjectNames(projectTransformerBean.changeProject());
    }

    public void retieveAllActiveProjectsOfUser(long userId) throws UMUserManagementException, GenericDatabaseException {
        List<ProjectDataBean> ActiveProjectsOfUser = projectTransformerBean.retrieveAllActiveProjectsOfUser(userId);
        if (!ActiveProjectsOfUser.isEmpty()) {
            systemResultViewUtil.setListOfProjects(ActiveProjectsOfUser);
        }
    }

    public void addProjectAttachmentToList() {
        List<FileUploadDataBean> fileUploadDataBeans = systemResultViewUtil.getTempProjectAttachmentList();
        if (CollectionUtils.isEmpty(fileUploadDataBeans)) {
            fileUploadDataBeans = new ArrayList();
            FileUploadDataBean fileUploadVar = new FileUploadDataBean();
            fileUploadVar.setFileName(systemResultViewUtil.getFileName());
            fileUploadVar.setFilePath(systemResultViewUtil.getFilePath());
            fileUploadVar.setFileData(systemResultViewUtil.getFileData());
            fileUploadVar.setFileSize(systemResultViewUtil.getFileSize());
            fileUploadVar.setProjectId(fileUploadDataBean.getProjectId());
            fileUploadDataBeans.add(fileUploadVar);
            systemResultViewUtil.setTempProjectAttachmentList(fileUploadDataBeans);
        } else {
            FileUploadDataBean fileUploadVar = new FileUploadDataBean();
            fileUploadVar.setFileName(systemResultViewUtil.getFileName());
            fileUploadVar.setFilePath(systemResultViewUtil.getFilePath());
            fileUploadVar.setFileData(systemResultViewUtil.getFileData());
            fileUploadVar.setFileSize(systemResultViewUtil.getFileSize());
            fileUploadVar.setProjectId(fileUploadDataBean.getProjectId());
            fileUploadDataBeans.add(fileUploadVar);
            systemResultViewUtil.setTempProjectAttachmentList(fileUploadDataBeans);
        }

    }

    public void deleteProjectAttachmentToList() {
        int index = systemResultViewUtil.getRowIndex();
        systemResultViewUtil.getTempProjectAttachmentList().remove(index);

    }

    public void addProjectAttachment() throws FileNotFoundException, UMUserManagementException {

        FileOutputStream outputStream = null;
        String filePath;
        String path;
        String fileName;
        Project projectObj = projectTransformerBean.retrieveProjectById(systemResultViewUtil.getProjectId());
        String projectName = projectObj.getProjectAlias();
        try {
            path = SystemConstantUtil.DOCUMENT_FILE_PATH + projectName + File.separator;;
            Boolean result = new File(path).mkdirs();
            if (!CollectionUtils.isEmpty(systemResultViewUtil.getTempProjectAttachmentList())) {
                for (FileUploadDataBean fileVar : systemResultViewUtil.getTempProjectAttachmentList()) {
                    fileName = getTimeStamp() + "#" + fileVar.getFileName();
                    filePath = path + fileName;
                    outputStream = new FileOutputStream(filePath);
                    fileVar.setFileName(fileName);
                    outputStream.write(fileVar.getFileData());
                    outputStream.close();
                }
                projectTransformerBean.addProjectAttachment();
                systemResultViewUtil.setTempProjectAttachmentList(null);
                messageDataBean.setIsSuccess(Boolean.TRUE);
                messageDataBean.setMessage("Attachment Added Successfully");
                retrieveProjectAttachmentByProjectId();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void clearData() {
        if (systemResultViewUtil.getProjectId() == null) {
            messageDataBean.setMessage("Select Project");
            messageDataBean.setIsSuccess(Boolean.FALSE);
        }
        systemResultViewUtil.setTempProjectAttachmentList(null);

    }

    public void retrieveProjectAttachmentByProjectId() throws IOException, FileNotFoundException, UMUserManagementException {
        systemResultSessionUtil.setSelectedProjectId(systemResultViewUtil.getProjectId());
        systemResultViewUtil.setProjectAttachmentList(projectTransformerBean.retrieveProjectAttachmentByProjectId());
    }

    public void retieveAllActiveProjectsOfUser() throws UMUserManagementException, GenericDatabaseException {

        List<ProjectDataBean> retieveAllActiveProjects;
        retieveAllActiveProjects = new ArrayList<>();
        if (loginDataBean.getRole().equals("ROLE_SADMIN")) {
            retieveAllActiveProjects = projectTransformerBean.retrieveAllActiveAndInActiveProjects(Boolean.TRUE);
        } else {
            retieveAllActiveProjects = projectTransformerBean.retrieveAllActiveProjectsOfUser(loginDataBean.getId());
        }
        systemResultSessionUtil.setUserProjects(retieveAllActiveProjects);
        systemResultViewUtil.setListOfProjects(retieveAllActiveProjects);

    }

    public void retieveAllActiveProjectsOfUserForUserProfile() throws UMUserManagementException, GenericDatabaseException {

        if (systemResultSessionUtil.getUserId() == loginDataBean.getId()) {
            System.out.println("inside if-----");
            System.out.println("userId---->>>" + systemResultSessionUtil.getUserId());
            systemResultViewUtil.setListOfProjectsOfUser(projectTransformerBean.retrieveAllActiveProjectsOfUser(systemResultSessionUtil.getUserId()));
        } else {
            System.out.println("inside else-----");
            System.out.println("userId---->>>" + systemResultSessionUtil.getUserId());
            systemResultViewUtil.setListOfProjectsOfUser(projectTransformerBean.retrieveAllActiveProjectsOfUser(systemResultSessionUtil.getUserId()));

        }

    }

    public void deleteProjectAttachment() throws IOException, FileNotFoundException, UMUserManagementException {
        projectTransformerBean.deleteProjectAttachment();
        retrieveProjectAttachmentByProjectId();
        messageDataBean.setIsSuccess(Boolean.TRUE);
        messageDataBean.setMessage("Attachment Deleted Successfully");
    }

    public long getTimeStamp() {
        return System.currentTimeMillis();
    }

}
