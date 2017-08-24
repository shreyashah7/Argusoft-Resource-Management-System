package com.argusoft.armms.web.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.argusoft.armms.core.ProjectService;
import com.argusoft.armms.model.ProjectRoles;
import com.argusoft.generic.database.exception.GenericDatabaseException;
import com.argusoft.usermanagement.common.core.UMFeatureService;
import com.argusoft.usermanagement.common.core.UMRoleService;
import com.argusoft.usermanagement.common.core.UMSystemConfigurationService;
import com.argusoft.usermanagement.common.core.UMUserService;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import com.argusoft.usermanagement.common.model.UMFeature;
import com.argusoft.usermanagement.common.model.UMFeaturePermission;
import com.argusoft.usermanagement.common.model.UMRole;
import com.argusoft.usermanagement.common.model.UMRoleFeature;
import com.argusoft.usermanagement.common.model.UMSystemConfiguration;
import com.argusoft.usermanagement.common.model.UMUser;
import com.argusoft.usermanagement.common.model.UMUserContact;
import com.argusoft.usermanagement.common.model.UMUserRole;
import com.argusoft.usermanagement.common.model.UMUserRolePK;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.jasypt.util.password.BasicPasswordEncryptor;

/**
 *
 * @author shreya
 */
//For adding system configuration values at the time of Deployment if entry is not there
@Service
public class ApplicationPropertyInitializerToDb {

    @Autowired
    private UMSystemConfigurationService systemConfigurationService;

    @Autowired
    private UMRoleService uMRoleService;

    @Autowired
    private UMFeatureService featureService;

    @Autowired
    private UMUserService userService;
    
    @Autowired
    private ProjectService projectService;

    @Autowired
    private BasicPasswordEncryptor basicPasswordEncryptor;

    public BasicPasswordEncryptor getBasicPasswordEncryptor() {
        return basicPasswordEncryptor;
    }

    public void setBasicPasswordEncryptor(BasicPasswordEncryptor basicPasswordEncryptor) {
        this.basicPasswordEncryptor = basicPasswordEncryptor;
    }

    public UMUserService getUserService() {
        return userService;
    }

    public void setUserService(UMUserService userService) {
        this.userService = userService;
    }

    public UMRoleService getuMRoleService() {
        return uMRoleService;
    }

    public UMFeatureService getFeatureService() {
        return featureService;
    }

    public void setFeatureService(UMFeatureService featureService) {
        this.featureService = featureService;
    }

    public void setuMRoleService(UMRoleService uMRoleService) {
        this.uMRoleService = uMRoleService;
    }

    public UMSystemConfigurationService getSystemConfigurationService() {
        return systemConfigurationService;
    }

    public void setSystemConfigurationService(UMSystemConfigurationService systemConfigurationService) {
        this.systemConfigurationService = systemConfigurationService;
    }

    //Will be initiated at the time of deployment....
    @PostConstruct
    public void initProperties() {
        System.out.println("initProperties called---------->>>>");
        generateInitialSystemConfiguration();        
        createProjectRoleIfNotExist();
    }

    //For initializing the system configuration at deployment time if it is not there in Db.
    private void generateInitialSystemConfiguration() {
        Map<String, String> systemConfigurationMap = null;
        List<UMSystemConfiguration> systemList = new ArrayList<>();
        systemList = this.systemConfigurationService.retrieveAllSystemConfigurationsByStatus(null);
        if (systemList != null && !systemList.isEmpty()) {
            systemConfigurationMap = new HashMap<>();
            for (UMSystemConfiguration systemConfiguration : systemList) {
                systemConfigurationMap.put(systemConfiguration.getSystemKey(), systemConfiguration.getKeyValue());
            }
        }
        if (systemConfigurationMap == null) {
            systemConfigurationMap = new LinkedHashMap<>();
        }
        if (!systemConfigurationMap.containsKey(SystemConstantUtil.PROJ_URL)) {
            UMSystemConfiguration systemConfiguration = createSystemConfigurationObject(SystemConstantUtil.PROJ_URL, SystemConstantUtil.PROJ_URL_DEFAULT_VALUE);
            this.systemConfigurationService.createSystemConfiguration(systemConfiguration);
        }
        if (!systemConfigurationMap.containsKey(SystemConstantUtil.TASK_END_PERIOD)) {
            UMSystemConfiguration systemConfiguration = createSystemConfigurationObject(SystemConstantUtil.TASK_END_PERIOD, SystemConstantUtil.TASK_END_PERIOD_DEFAULT_VALUE);
            this.systemConfigurationService.createSystemConfiguration(systemConfiguration);
        }
        if (!systemConfigurationMap.containsKey(SystemConstantUtil.INITIAL_CONFIGURATION_DONE)) {
            UMSystemConfiguration systemConfiguration = createSystemConfigurationObject(SystemConstantUtil.INITIAL_CONFIGURATION_DONE, SystemConstantUtil.INITIAL_CONFIGURATION_DEFAULT);
            this.systemConfigurationService.createSystemConfiguration(systemConfiguration);
        }
        if (!systemConfigurationMap.containsKey(SystemConstantUtil.ORGANIZATION_NAME)) {
            UMSystemConfiguration systemConfiguration = createSystemConfigurationObject(SystemConstantUtil.ORGANIZATION_NAME, "Argusoft India Ltd");
            this.systemConfigurationService.createSystemConfiguration(systemConfiguration);
        }
        if (!systemConfigurationMap.containsKey(SystemConstantUtil.SVN_URL)) {
            UMSystemConfiguration systemConfiguration = createSystemConfigurationObject(SystemConstantUtil.SVN_URL, "https://192.1.200.12/repos/ARMMS");
            this.systemConfigurationService.createSystemConfiguration(systemConfiguration);
        }
        if (!systemConfigurationMap.containsKey(SystemConstantUtil.LATEST_UPDATE_X_DAYS)) {
            UMSystemConfiguration systemConfiguration = createSystemConfigurationObject(SystemConstantUtil.LATEST_UPDATE_X_DAYS, SystemConstantUtil.LATEST_UPDATE_X_DAYS_DEFAULT_VALUE);
            this.systemConfigurationService.createSystemConfiguration(systemConfiguration);
        }
        if (!systemConfigurationMap.containsKey(SystemConstantUtil.MAX_NO_OF_TASK)) {
            UMSystemConfiguration systemConfiguration = createSystemConfigurationObject(SystemConstantUtil.MAX_NO_OF_TASK, SystemConstantUtil.MAX_NO_OF_TASK_VALUE);
            this.systemConfigurationService.createSystemConfiguration(systemConfiguration);
        }
        if (!systemConfigurationMap.containsKey(SystemConstantUtil.MIN_NO_OF_TASK)) {
            UMSystemConfiguration systemConfiguration = createSystemConfigurationObject(SystemConstantUtil.MIN_NO_OF_TASK, SystemConstantUtil.MIN_NO_OF_TASK_VALUE);
            this.systemConfigurationService.createSystemConfiguration(systemConfiguration);
        }
    }

    //Creates a system Configuration object for setting the key and value in model...
    private UMSystemConfiguration createSystemConfigurationObject(String key, String value) {
        UMSystemConfiguration systemConfiguration = new UMSystemConfiguration();
        systemConfiguration.setSystemKey(key);
        systemConfiguration.setKeyValue(value);
        systemConfiguration.setIsActive(Boolean.TRUE);
        return systemConfiguration;
    }

    /**
     * @author rajkumar Creates a default role for SADMIN and USER if there is
     * no any role in system, Add predefined features and permission set in the
     * database and assign maximum permissions to the SuperAdmin role
     * @since 10-APR-2014
     */
    public void createRoleIfNotExist() throws UMUserManagementException, GenericDatabaseException {
        UMUser user = userService.getUserbyUserName("superadmin", false, false, false, false, false, null);

        if (user == null) {
            user = new UMUser();
            UMUserContact contact = new UMUserContact();

            user.setCreatedBy((long) 2);
            String encriptedPass = basicPasswordEncryptor.encryptPassword("argusadmin");
            user.setPassword(encriptedPass);
            user.setIsActive(true);
            user.setType("ROLE_SADMIN");
            user.setUserId("superadmin");
            user.setFirstName("Super");
            user.setLastName("Admin");
            user.setCreatedOn(Calendar.getInstance().getTime());

            contact.setFirstName("Super");
            contact.setLastName("Admin");
            contact.setCreatedBy(0);
            contact.setIsActive(true);
            contact.setIsArchive(false);
            contact.setMobileNumber("1111111111");
            contact.setEmailAddress("sadmin@argusoft.com");
            contact.setCreatedOn(Calendar.getInstance().getTime());
            contact.setUserobj(user);

            user.setContact(contact);

            Long sadminid = userService.createUser(user);

            //Creates SADMIN ROLE
            UMRole uMRole = new UMRole();

            uMRole.setName("ROLE_SADMIN");
            uMRole.setDescription("Role for super admin");
            uMRole.setCompany(1l);
            uMRole.setCreatedOn(new Date());
            uMRole.setCreatedBy(1l);
            uMRole.setIsActive(Boolean.TRUE);
            uMRole.setPrecedence(0);

            Long createdroleID = uMRoleService.createRole(uMRole);

            UMUserRole uMUserRole = new UMUserRole();
            UMUserRolePK uMUserRolePK = new UMUserRolePK();

            uMUserRolePK.setRole(createdroleID);
            uMUserRolePK.setUserobj(sadminid);

            uMUserRole.setIsActive(true);
            uMUserRole.setIsArchive(false);
            uMUserRole.setuMUserRolePK(uMUserRolePK);

            userService.createUserRole(uMUserRole);

            //Creating 'Manage' menu
            UMFeature uMFeature = new UMFeature();
            Long manageID = createFeature(SystemConstantUtil.MANAGE, "", null, SystemConstantUtil.MENU, uMFeature);

            //Creating 'Role' menuItem
            uMFeature = new UMFeature();
            Long roleID = createFeature(SystemConstantUtil.ROLE, "role", manageID, SystemConstantUtil.MENU_ITEM, uMFeature);

            //Creating 'view role' ItemAttribute
            uMFeature = new UMFeature();
            Long viewroleID = createFeature(SystemConstantUtil.VIEW_ROLE, null, roleID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'add role' ItemAttribute
            uMFeature = new UMFeature();
            Long addroleID = createFeature(SystemConstantUtil.ADD_ROLE, "manageRole", roleID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'delete role' ItemAttribute
            uMFeature = new UMFeature();
            Long deleteroleID = createFeature(SystemConstantUtil.DELETE_ROLE, "changeRoleToUser", roleID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'update role' ItemAttribute
            uMFeature = new UMFeature();
            Long updateroleID = createFeature(SystemConstantUtil.UPDATE_ROLE, "changePermissionToRole", roleID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating "minimum" permission set for role
            Long[] permissions = {viewroleID};
            UMFeaturePermission uMFeaturePermission = new UMFeaturePermission();
            Long roleminID = createPermissionSet("minimum", permissions, roleID, uMFeaturePermission);

            //Creating "maximum" permission set for role
            Long[] maxpermissions = {viewroleID, addroleID, deleteroleID, updateroleID};
            uMFeaturePermission = new UMFeaturePermission();
            Long rolemaxID = createPermissionSet("maximum", maxpermissions, roleID, uMFeaturePermission);

            //Creating 'Feature' menuItem
            uMFeature = new UMFeature();
            Long featureID = createFeature(SystemConstantUtil.FEATURE, "feature", manageID, SystemConstantUtil.MENU_ITEM, uMFeature);

            //Creating 'view feature' ItemAttribute
            uMFeature = new UMFeature();
            Long viewfeatureID = createFeature(SystemConstantUtil.VIEW_FEATURE, null, featureID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'add feature' ItemAttribute
            uMFeature = new UMFeature();
            Long addfeatureID = createFeature(SystemConstantUtil.ADD_FEATURE, null, featureID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'delete feature' ItemAttribute
            uMFeature = new UMFeature();
            Long deletefeatureID = createFeature(SystemConstantUtil.DELETE_FEATURE, null, featureID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'update feature' ItemAttribute
            uMFeature = new UMFeature();
            Long updatefeatureID = createFeature(SystemConstantUtil.UPDATE_FEATURE, null, featureID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating "minimum" permission set for feature
            Long[] featureminpermissions = {viewfeatureID};
            uMFeaturePermission = new UMFeaturePermission();
            Long featureminID = createPermissionSet("minimum", featureminpermissions, featureID, uMFeaturePermission);

            //Creating "maximum" permission set for feature
            Long[] featuremaxpermissions = {viewfeatureID, addfeatureID, deletefeatureID, updatefeatureID};
            uMFeaturePermission = new UMFeaturePermission();
            Long featuremaxID = createPermissionSet("maximum", featuremaxpermissions, featureID, uMFeaturePermission);

            //Creating 'Project' menuItem
            uMFeature = new UMFeature();
            Long projectID = createFeature(SystemConstantUtil.PROJECT, "manageProject", manageID, SystemConstantUtil.MENU_ITEM, uMFeature);

            //Creating 'view project' ItemAttribute
            uMFeature = new UMFeature();
            Long viewprojectID = createFeature(SystemConstantUtil.VIEW_PROJECT, null, projectID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'add project' ItemAttribute
            uMFeature = new UMFeature();
            Long addprojectID = createFeature(SystemConstantUtil.ADD_PROJECT, "addProject", projectID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'delete project' ItemAttribute
            uMFeature = new UMFeature();
            Long deleteprojectID = createFeature(SystemConstantUtil.DELETE_PROJECT, null, projectID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'update project' ItemAttribute
            uMFeature = new UMFeature();
            Long updateprojectID = createFeature(SystemConstantUtil.UPDATE_PROJECT, "editProject", projectID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating "minimum" permission set for project
            Long[] projectminpermissions = {viewprojectID};
            uMFeaturePermission = new UMFeaturePermission();
            Long projectminID = createPermissionSet("minimum", projectminpermissions, projectID, uMFeaturePermission);

            //Creating "maximum" permission set for project
            Long[] projectmaxpermissions = {viewprojectID, addprojectID, deleteprojectID, updateprojectID};
            uMFeaturePermission = new UMFeaturePermission();
            Long projectmaxID = createPermissionSet("maximum", projectmaxpermissions, projectID, uMFeaturePermission);

            //Creating 'User' menuItem
            uMFeature = new UMFeature();
            Long userID = createFeature(SystemConstantUtil.USER, "userManagement", manageID, SystemConstantUtil.MENU_ITEM, uMFeature);

            //Creating 'view user' ItemAttribute
            uMFeature = new UMFeature();
            Long viewuserID = createFeature(SystemConstantUtil.VIEW_USER, null, userID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'add user' ItemAttribute
            uMFeature = new UMFeature();
            Long adduserID = createFeature(SystemConstantUtil.ADD_USER, "addUser", userID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'delete user' ItemAttribute
            uMFeature = new UMFeature();
            Long deleteuserID = createFeature(SystemConstantUtil.DELETE_USER, null, userID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'update user' ItemAttribute
            uMFeature = new UMFeature();
            Long updateuserID = createFeature(SystemConstantUtil.UPDATE_USER, "editUserData", userID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating "minimum" permission set for user
            Long[] userminpermissions = {viewuserID};
            uMFeaturePermission = new UMFeaturePermission();
            Long userminID = createPermissionSet("minimum", userminpermissions, userID, uMFeaturePermission);

            //Creating "maximum" permission set for user
            Long[] usermaxpermissions = {viewuserID, adduserID, deleteuserID, updateuserID};
            uMFeaturePermission = new UMFeaturePermission();
            Long usermaxID = createPermissionSet("maximum", usermaxpermissions, userID, uMFeaturePermission);

            //Creating 'Technology' menuItem
            uMFeature = new UMFeature();
            Long techID = createFeature(SystemConstantUtil.TECHNOLOGY_FEATURE, "manageTechnology", manageID, SystemConstantUtil.MENU_ITEM, uMFeature);

            //Creating 'view technology' ItemAttribute
            uMFeature = new UMFeature();
            Long viewtechID = createFeature(SystemConstantUtil.VIEW_TECHNOLOGY, null, techID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'add technology' ItemAttribute
            uMFeature = new UMFeature();
            Long addtechID = createFeature(SystemConstantUtil.ADD_TECHNOLOGY, null, techID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'delete technology' ItemAttribute
            uMFeature = new UMFeature();
            Long deletetechID = createFeature(SystemConstantUtil.DELETE_TECHNOLOGY, null, techID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'update technology' ItemAttribute
            uMFeature = new UMFeature();
            Long updatetechID = createFeature(SystemConstantUtil.UPDATE_TECHNOLOGY, null, techID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating "minimum" permission set for technology
            Long[] techminpermissions = {viewtechID};
            uMFeaturePermission = new UMFeaturePermission();
            Long techminID = createPermissionSet("minimum", techminpermissions, techID, uMFeaturePermission);

            //Creating "maximum" permission set for technology
            Long[] techmaxpermissions = {viewtechID, addtechID, deletetechID, updatetechID};
            uMFeaturePermission = new UMFeaturePermission();
            Long techmaxID = createPermissionSet("maximum", techmaxpermissions, techID, uMFeaturePermission);

            //Creating 'Report' menu
            uMFeature = new UMFeature();
            Long reportID = createFeature(SystemConstantUtil.REPORTS, "", null, SystemConstantUtil.MENU, uMFeature);

            //Creating 'Employee Performance' menuItem
            uMFeature = new UMFeature();
            Long employeeperformanceID = createFeature(SystemConstantUtil.EMPLOYEE_PERFORMANCE_REPORT, "manageEmployeePerformanceReport", reportID, SystemConstantUtil.MENU_ITEM, uMFeature);

            //Creating 'view report' ItemAttribute
            uMFeature = new UMFeature();
            Long viewreportID = createFeature(SystemConstantUtil.VIEW_REPORTS, null, employeeperformanceID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'download report' ItemAttribute
            uMFeature = new UMFeature();
            Long downloadreportID = createFeature(SystemConstantUtil.DOWNLOAD_REPORTS, null, employeeperformanceID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating "minimum" permission set for report
            Long[] reportminpermissions = {viewreportID};
            uMFeaturePermission = new UMFeaturePermission();
            Long reportminID = createPermissionSet("minimum", reportminpermissions, employeeperformanceID, uMFeaturePermission);

            //Creating "maximum" permission set for report
            Long[] reportmaxpermissions = {viewreportID, downloadreportID};
            uMFeaturePermission = new UMFeaturePermission();
            Long reportmaxID = createPermissionSet("maximum", reportmaxpermissions, employeeperformanceID, uMFeaturePermission);

            //Creating 'Gantt' menu
            uMFeature = new UMFeature();
            Long ganttID = createFeature(SystemConstantUtil.GANTT, "ganttChart", null, SystemConstantUtil.MENU, uMFeature);

            //Creating 'view own gantt' ItemAttribute
            uMFeature = new UMFeature();
            Long viewganttID = createFeature(SystemConstantUtil.VIEW_OWN_GANTT, null, ganttID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'view others gantt' ItemAttribute
            uMFeature = new UMFeature();
            Long viewothersganttID = createFeature(SystemConstantUtil.VIEW_OTHERS_GANTT, null, ganttID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating "minimum" permission set for gantt
            Long[] ganttminpermissions = {viewganttID};
            uMFeaturePermission = new UMFeaturePermission();
            Long ganttminID = createPermissionSet("minimum", ganttminpermissions, ganttID, uMFeaturePermission);

            //Creating "maximum" permission set for gantt
            Long[] ganttmaxpermissions = {viewganttID, viewothersganttID};
            uMFeaturePermission = new UMFeaturePermission();
            Long ganttmaxID = createPermissionSet("maximum", ganttmaxpermissions, ganttID, uMFeaturePermission);

            //Creating 'Calendar' menu
            uMFeature = new UMFeature();
            Long calenderID = createFeature(SystemConstantUtil.CALENDAR, "calendar", null, SystemConstantUtil.MENU, uMFeature);

            //Creating 'view own calender' ItemAttribute
            uMFeature = new UMFeature();
            Long viewcalendarID = createFeature(SystemConstantUtil.VIEW_OWN_CALENDAR, null, calenderID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'view others calendar' ItemAttribute
            uMFeature = new UMFeature();
            Long viewotherscalendarID = createFeature(SystemConstantUtil.VIEW_OTHERS_CALENDAR, null, calenderID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating "minimum" permission set for calendar
            Long[] calendarminpermissions = {viewcalendarID};
            uMFeaturePermission = new UMFeaturePermission();
            Long calendarminID = createPermissionSet("minimum", calendarminpermissions, calenderID, uMFeaturePermission);

            //Creating "maximum" permission set for calendar
            Long[] calendarmaxpermissions = {viewcalendarID, viewotherscalendarID};
            uMFeaturePermission = new UMFeaturePermission();
            Long calendarmaxID = createPermissionSet("maximum", calendarmaxpermissions, calenderID, uMFeaturePermission);

            //Creating 'repository' menu
            uMFeature = new UMFeature();
            Long repositoryID = createFeature(SystemConstantUtil.REPOSITORY, "repository", null, SystemConstantUtil.MENU, uMFeature);

            //Creating 'view repository' ItemAttribute
            uMFeature = new UMFeature();
            Long viewrepositoryID = createFeature(SystemConstantUtil.VIEW_REPOSITORY, null, repositoryID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating "minimum" permission set for repository
            Long[] repositoryminpermissions = {viewrepositoryID};
            uMFeaturePermission = new UMFeaturePermission();
            Long repositoryminID = createPermissionSet("minimum", repositoryminpermissions, repositoryID, uMFeaturePermission);

            //Creating 'documents' menu
            uMFeature = new UMFeature();
            Long documentsID = createFeature(SystemConstantUtil.DOCUMENTS, "documents", null, SystemConstantUtil.MENU, uMFeature);

            //Creating 'view documents' ItemAttribute
            uMFeature = new UMFeature();
            Long viewdocumentsID = createFeature(SystemConstantUtil.VIEW_DOCUMENTS, null, documentsID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'add documents' ItemAttribute
            uMFeature = new UMFeature();
            Long adddocumentsID = createFeature(SystemConstantUtil.ADD_DOCUMENTS, null, documentsID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);
            
            //Creating 'delete documents' ItemAttribute
            uMFeature = new UMFeature();
            Long deletedocumentsID = createFeature("delete documents", null, documentsID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating "minimum" permission set for documents
            Long[] documentsminpermissions = {viewdocumentsID};
            uMFeaturePermission = new UMFeaturePermission();
            Long documentsminID = createPermissionSet("minimum", documentsminpermissions, documentsID, uMFeaturePermission);

            //Creating "maximum" permission set for documents
            Long[] documentsmaxpermissions = {viewdocumentsID, adddocumentsID,deletedocumentsID};
            uMFeaturePermission = new UMFeaturePermission();
            Long documentsmaxID = createPermissionSet("maximum", documentsmaxpermissions, documentsID, uMFeaturePermission);

            //Creating 'tasks' menu
            uMFeature = new UMFeature();
            Long tasksID = createFeature(SystemConstantUtil.TASKS, "ViewMultipleTask", null, SystemConstantUtil.MENU, uMFeature);

            //Creating 'view tasks' ItemAttribute
            uMFeature = new UMFeature();
            Long viewtasksID = createFeature(SystemConstantUtil.VIEW_TASKS, "TaskViewAndUpdate", tasksID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'add tasks' ItemAttribute
            uMFeature = new UMFeature();
            Long addtasksID = createFeature(SystemConstantUtil.ADD_TASKS, "createTask", tasksID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'delete tasks' ItemAttribute
            uMFeature = new UMFeature();
            Long deletetasksID = createFeature(SystemConstantUtil.DELETE_TASKS, null, tasksID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'update tasks' ItemAttribute
            uMFeature = new UMFeature();
            Long updatetasksID = createFeature(SystemConstantUtil.UPDATE_TASKS, null, tasksID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);
            
            //Creating 'update tasks limited' ItemAttribute
            uMFeature = new UMFeature();
            Long updatetasksLimitedID = createFeature(SystemConstantUtil.UPDATE_TASKS_LIMITED, null, tasksID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating "minimum" permission set for task
            Long[] tasksminpermissions = {viewtasksID};
            uMFeaturePermission = new UMFeaturePermission();
            Long tasksminID = createPermissionSet("minimum", tasksminpermissions, tasksID, uMFeaturePermission);

            //Creating "maximum" permission set for task
            Long[] tasksmaxpermissions = {viewtasksID, addtasksID, deletetasksID,updatetasksID,updatetasksLimitedID};
            uMFeaturePermission = new UMFeaturePermission();
            Long tasksmaxID = createPermissionSet("maximum", tasksmaxpermissions, tasksID, uMFeaturePermission);

            //Creating 'activity' menu
            uMFeature = new UMFeature();
            Long activityID = createFeature(SystemConstantUtil.ACTIVITY, "activity", null, SystemConstantUtil.MENU, uMFeature);

            //Creating 'view activity' ItemAttribute
            uMFeature = new UMFeature();
            Long viewactivityID = createFeature(SystemConstantUtil.VIEW_ACTIVITY, null, activityID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating "minimum" permission set for activity
            Long[] activityminpermissions = {viewactivityID};
            uMFeaturePermission = new UMFeaturePermission();
            Long activityminID = createPermissionSet("minimum", activityminpermissions, activityID, uMFeaturePermission);
//Creating 'User' menuItem
            uMFeature = new UMFeature();
            Long resourceID = createFeature("Project Resource", "projectResources", manageID, SystemConstantUtil.MENU_ITEM, uMFeature);

            //Creating 'view user' ItemAttribute
            uMFeature = new UMFeature();
            Long viewresourceID = createFeature("View resource", null, resourceID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);


            //Creating 'add user' ItemAttribute
            uMFeature = new UMFeature();
            Long addresourceID = createFeature("add resource", "addResourcesOfProject", resourceID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'delete user' ItemAttribute
            uMFeature = new UMFeature();
            Long deleteresourceID = createFeature("delete resource", null, resourceID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'update user' ItemAttribute
            uMFeature = new UMFeature();
            Long updateresourceID = createFeature("update resource", null, resourceID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating "minimum" permission set for user
            Long[] resourceminpermissions = {viewresourceID};
            uMFeaturePermission = new UMFeaturePermission();
            Long resourceminID = createPermissionSet("minimum", resourceminpermissions, resourceID, uMFeaturePermission);

            //Creating "maximum" permission set for user
            Long[] resourcemaxpermissions = {viewresourceID, addresourceID, deleteresourceID, updateresourceID};
            uMFeaturePermission = new UMFeaturePermission();
            Long resourcemaxID = createPermissionSet("maximum", resourcemaxpermissions, resourceID, uMFeaturePermission);
  
            //creating Role Feature entry for 'role'
            createRoleFeature(createdroleID, resourceID, resourcemaxID);



            //Creating 'tasks' menu
            uMFeature = new UMFeature();
            Long milestoneID = createFeature("Milestone", "milestone", manageID, SystemConstantUtil.MENU_ITEM, uMFeature);

            //Creating 'view tasks' ItemAttribute
            uMFeature = new UMFeature();
            Long viewmilestoneID = createFeature("view milestone", null, milestoneID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'add tasks' ItemAttribute
            uMFeature = new UMFeature();
            Long addmilestoneID = createFeature("add milestone", null, milestoneID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'delete tasks' ItemAttribute
            uMFeature = new UMFeature();
            Long deletemilestoneID = createFeature("delete milestone", null, milestoneID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'update tasks' ItemAttribute
            uMFeature = new UMFeature();
            Long updatemilestoneID = createFeature("update milestone", null, milestoneID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating "minimum" permission set for documents
            Long[] milestoneminpermissions = {viewmilestoneID};
            uMFeaturePermission = new UMFeaturePermission();
            Long milestoneminID = createPermissionSet("minimum", milestoneminpermissions, milestoneID, uMFeaturePermission);

            //Creating "maximum" permission set for documents
            Long[] milestonemaxpermissions = {viewmilestoneID, addmilestoneID, deletemilestoneID,updatemilestoneID};
            uMFeaturePermission = new UMFeaturePermission();
            Long milestonemaxID = createPermissionSet("maximum", milestonemaxpermissions, milestoneID, uMFeaturePermission);

            //Creating 'Project Role' menuItem
            uMFeature = new UMFeature();
            Long projectRoleID = createFeature("Project Role", "manageProjectRoles", manageID, SystemConstantUtil.MENU_ITEM, uMFeature);

            //Creating 'view project role' ItemAttribute
            uMFeature = new UMFeature();
            Long viewProjectRoleID = createFeature("view project role", null, projectRoleID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'add project role' ItemAttribute
            uMFeature = new UMFeature();
            Long addProjectRoleID = createFeature("add project role", null, projectRoleID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'delete project role' ItemAttribute
            uMFeature = new UMFeature();
            Long deleteProjectRoleID = createFeature("delete project role", null, projectRoleID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'update project role' ItemAttribute
            uMFeature = new UMFeature();
            Long updateProjectRoleID = createFeature("update project role", null, projectRoleID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating "minimum" permission set for role
            Long[] projectRoleMinPermissions = {viewProjectRoleID};
            uMFeaturePermission = new UMFeaturePermission();
            Long projectRoleMinID = createPermissionSet("minimum", projectRoleMinPermissions, projectRoleID, uMFeaturePermission);

            //Creating "maximum" permission set for role
            Long[] projectRoleMaxpermissions = {viewProjectRoleID, addProjectRoleID, deleteProjectRoleID, updateProjectRoleID};
            uMFeaturePermission = new UMFeaturePermission();
            Long projectRoleMaxID = createPermissionSet("maximum", projectRoleMaxpermissions, projectRoleID, uMFeaturePermission);

            
            //Creating 'System Configuration' menuItem
            uMFeature = new UMFeature();
            Long systemConfigID = createFeature("System configuration", "manageSystemConfiguration", manageID, SystemConstantUtil.MENU_ITEM, uMFeature);

            //Creating 'view system configuration' ItemAttribute
            uMFeature = new UMFeature();
            Long viewSystemConfigID = createFeature("view system configuration", null, systemConfigID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'add System Configuration' ItemAttribute
            uMFeature = new UMFeature();
            Long addSystemConfigID = createFeature("add system configuration", null, systemConfigID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'delete System Configuration' ItemAttribute
            uMFeature = new UMFeature();
            Long deleteSystemConfigID = createFeature("delete system configuration", null, systemConfigID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating 'update System Configuration' ItemAttribute
            uMFeature = new UMFeature();
            Long updateSystemConfigID = createFeature("update system configuration", null, systemConfigID, SystemConstantUtil.ITEM_ATTRIBUTE, uMFeature);

            //Creating "minimum" permission set for role
            Long[] systemConfigMinPermissions = {viewSystemConfigID};
            uMFeaturePermission = new UMFeaturePermission();
            Long systemConfigMinID = createPermissionSet("minimum", systemConfigMinPermissions, systemConfigID, uMFeaturePermission);

            //Creating "maximum" permission set for role
            Long[] systemConfigMaxpermissions = {viewSystemConfigID, addSystemConfigID, deleteSystemConfigID, updateSystemConfigID};
            uMFeaturePermission = new UMFeaturePermission();
            Long systemConfigMaxID = createPermissionSet("maximum", systemConfigMaxpermissions, systemConfigID, uMFeaturePermission);
            
            //creating Role Feature entry for 'project role'
            createRoleFeature(createdroleID, projectRoleID, projectRoleMaxID);
            
            //creating Role Feature entry for 'project role'
            createRoleFeature(createdroleID, systemConfigID, systemConfigMaxID);
            
            //creating Role Feature entry for 'role'
            createRoleFeature(createdroleID, milestoneID, milestonemaxID);
            //creating Role Feature entry for 'role'
            createRoleFeature(createdroleID, roleID, rolemaxID);

            //creating Role Feature entry for 'feature'
            createRoleFeature(createdroleID, featureID, featuremaxID);

            //creating Role Feature entry for 'project'
            createRoleFeature(createdroleID, projectID, projectmaxID);

            //creating Role Feature entry for 'user'
            createRoleFeature(createdroleID, userID, usermaxID);

            //creating Role Feature entry for 'technology'
            createRoleFeature(createdroleID, techID, techmaxID);

            //creating Role Feature entry for 'report'
            createRoleFeature(createdroleID, employeeperformanceID, reportmaxID);


            //creating Role Feature entry for 'gantt'
            createRoleFeature(createdroleID, ganttID, ganttmaxID);

            //creating Role Feature entry for 'calendar'
            createRoleFeature(createdroleID, calenderID, calendarmaxID);

            //creating Role Feature entry for 'repository'
            createRoleFeature(createdroleID, repositoryID, repositoryminID);

            //creating Role Feature entry for 'documents'
            createRoleFeature(createdroleID, documentsID, documentsmaxID);

            //creating Role Feature entry for 'tasks'
            createRoleFeature(createdroleID, tasksID, tasksmaxID);

            //creating Role Feature entry for 'tasks'
            createRoleFeature(createdroleID, activityID, activityminID);
        }
    }

    private Long createFeature(String featureName, String featureUrl, Long parent, String menuType, UMFeature uMFeature) throws UMUserManagementException {
        uMFeature.setName(featureName);
        uMFeature.setFeatureUrl(featureUrl);
        uMFeature.setPrecedence(0);
        uMFeature.setIsCrud(Boolean.TRUE);
        uMFeature.setIsActive(Boolean.TRUE);
        uMFeature.setPrecedence(0);
        if (parent != null) {
            uMFeature.setParent(featureService.getFeatureByFeatureId(parent));
        } else {
            uMFeature.setParentId(null);
        }
        uMFeature.setMenuType(menuType);
        return (featureService.createFeature(uMFeature));
    }

    private Long createPermissionSet(String name, Long[] attributes, Long featureID, UMFeaturePermission uMFeaturePermission) throws UMUserManagementException {
        uMFeaturePermission.setIsActive(true);
        uMFeaturePermission.setName(name);
        uMFeaturePermission.setFeature(featureService.getFeatureByFeatureId(featureID));
        uMFeaturePermission.setFeatureId(featureID);
        StringBuilder permissionSet = new StringBuilder();
        for (Long permission : attributes) {
            permissionSet.append("#").append(permission).append("#").append(",");
        }
        permissionSet.deleteCharAt(permissionSet.length() - 1);
        uMFeaturePermission.setAttributes(permissionSet.toString());
        uMFeaturePermission.setLastModifiedOn(new Date());

        return (featureService.createFeaturePermission(uMFeaturePermission));
    }

    private Long createRoleFeature(Long adminRoleID, Long featureID, Long permissionID) throws UMUserManagementException, GenericDatabaseException {
        UMRoleFeature uMRoleFeature = new UMRoleFeature();

        uMRoleFeature.setRole(uMRoleService.getRoleByRoleId(adminRoleID, false, false, false));
        uMRoleFeature.setFeature(featureService.getFeatureByFeatureId(featureID));
        uMRoleFeature.setPermission(featureService.retrieveFeaturePermissionById(permissionID, null));
        uMRoleFeature.setAllowToCreate(true);
        uMRoleFeature.setAllowToDelete(true);
        uMRoleFeature.setAllowToUpdate(true);
        uMRoleFeature.setIsActive(true);

        return (featureService.createRoleFeature(uMRoleFeature));
    }
    private void createProjectRoleIfNotExist(){
        if(projectService.retrieveAllRolesOfProject(Boolean.TRUE).isEmpty()){
            ProjectRoles projectRoles=new ProjectRoles();
            projectRoles.setProjectRoleName("ROLE_SADMIN");
            projectRoles.setProjectRoleDescription("Top Management");
            projectRoles.setIsActive(Boolean.TRUE);
            projectRoles.setIsArchive(Boolean.FALSE);
            projectService.createRolesOfProject(projectRoles);
            
            projectRoles =new ProjectRoles();
            projectRoles.setProjectRoleName("ROLE_MANAGER");
            projectRoles.setProjectRoleDescription("Manager");
            projectRoles.setIsActive(Boolean.TRUE);
            projectRoles.setIsArchive(Boolean.FALSE);
            projectService.createRolesOfProject(projectRoles);
            
            projectRoles =new ProjectRoles();
            projectRoles.setProjectRoleName("ROLE_TECHLEAD");
            projectRoles.setProjectRoleDescription("Tech lead");
            projectRoles.setIsActive(Boolean.TRUE);
            projectRoles.setIsArchive(Boolean.FALSE);
            projectService.createRolesOfProject(projectRoles);
            
            projectRoles =new ProjectRoles();
            projectRoles.setProjectRoleName("ROLE_PROGRAMMER_ANALYST");
            projectRoles.setProjectRoleDescription("Programmer analyst");
            projectRoles.setIsActive(Boolean.TRUE);
            projectRoles.setIsArchive(Boolean.FALSE);
            projectService.createRolesOfProject(projectRoles);
        }
    }
}
