/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.util;

import java.io.File;

/**
 *
 * @author shreya
 */
public class SystemConstantUtil {

    public final static String SUCCESS = "SUCCESS";
    public final static String FAILURE = "FAILURE";

    public final static String CONNECTION_TYPE_DEFAULT = "Default";
    public final static String FILE_PATH_DATA = System.getProperty("user.home") + File.separator + "ARMMS" + File.separator + "Attachments" + File.separator;
    public static final String LOGOUT_URL = "login";
    public static final String AUTHENTICATED_SESSION = "AUTHENTICATED_SESSION";
    public static final String HOME_PAGE = "dashboard";
    public static final String ROLE_SADMIN = "ROLE_SADMIN";
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_USER_PAGE = "home";
    public static final String ACCESS_DENIED_PAGE = "accessDenied";
    public static final String JDBC_PROPERTY_PATH = System.getProperty("user.home") + File.separator + "argusoft" + File.separator + "jdbc" + File.separator + "jdbc.properties";
    public static final String HIBERNATE_PROPERTY_PATH = System.getProperty("user.home") + File.separator + "argusoft" + File.separator + "hibernate" + File.separator + "hibernate.properties";
    public static String EMAIL_PROPERTY_FILEPATH = System.getProperty("user.home") + File.separator + "armms" + File.separator + "properties" + File.separator + "email.properties";
    public static final String PRIORITYLOW = "Low";
    public static final String PRIORITYMEDIUM = "Medium";
    public static final String PRIORITYHIGH = "High";
    public static final String UPDATE_OPERATION = "U";
    public static final String CREATE_OPERATION = "C";
    public static final String ACTIVE = "Active";
    public static final String INACTIVE = "Inactive";
    public static final String INACTIVES = "InActive";
    public static final String SHOWALL = "Show All";
    public static final String IS_LOGIN = "IS_LOGIN";
    public static final String LATEST_UPDATE_X_DAYS = "LATEST_UPDATE_X_DAYS";
    public static final String LATEST_UPDATE_X_DAYS_DEFAULT_VALUE = "10";
    public static final String PROJ_URL = "PROJ_URL";
    public static final String PROJ_URL_DEFAULT_VALUE = "localhost:8089";
    public static final String TASK_END_PERIOD = "TASK_END_PERIOD";
    public static final String TASK_END_PERIOD_DEFAULT_VALUE = "7";
    public static final String INITIAL_CONFIGURATION_DONE = "Initial_Configuration_Done";
    public static final String ORGANIZATION_NAME = "Organization_Name";
    public static final String SVN_URL = "SVN_URL";
    public static final String INITIAL_CONFIGURATION_DEFAULT = "N";
    public static final String IN_PROGRESS = "In Progress";
    public static final String COMPLETED = "Completed";
    public static final String START = "Start";
    public static final String STOP = "Stop";
    public static final String DECLINE = "Decline";
    public static final String PROJECT = "Project";
    public static final String WATCHER = "Watcher";
    public static final String TASK = "Task";
    public static final String USER = "User";
    public static final String TECHNOLOGY = "T";
    public static final String TOOL = "L";
    public static final String BROWSER = "B";
    public static final String SERVER = "S";
    public static final String OPERATING_SYSTEM = "O";
    public static final String MENU_ITEM = "MenuItem";
    public static final String ITEM_ATTRIBUTE = "Item Attribute";
    public static final String MENU = "Menu";
    public final static String NOT_AVAILABLE = "Not available";
    public final static String NOTAVAILABLE = "N/A";
    public final static String NOT_APPLICABLE = "Not applicable";
    public static final String MAX_NO_OF_TASK = "Max no of tasks";
    public static final String MIN_NO_OF_TASK = "Min no of tasks";
    public static final String MAX_NO_OF_TASK_VALUE = "5";
    public static final String MIN_NO_OF_TASK_VALUE = "2";
    public static final String CREATED_TASKS = "Created";
    public static final String WAITING_TASKS = "Waiting";
    public static final String ASSIGNED_TASKS = "Assigned";
    public static final String COMPLETED_TASKS = "Completed";   
    
    public static final String REPOSITORY_SYNC_TIME = "repository_sync_time(in minutes)";
    public static final String REPOSITORY_SYNC_DEFAULT_TIME = "5";
    public static final String PASSWORD_DONT_MATCH = "Passwords do not match.";
    public static final String USERNAME_UNAVAILABLE = "Username already exist.";
    public static final String PROJECTNAME_UNAVAILABLE = "Project name already exist";
    public static final String PROJECTALIAS_UNAVAILABLE = "Project alias already exist.";
    public static final String EDIT_SUCCESSFUL = "Edit Successful";
    public static final String DOCUMENT_FILE_PATH = System.getProperty("user.home") + File.separator + "ARMMS" + File.separator + "Project_Attachments" + File.separator;
    public static final String DOCUMENT_FILE_PATH_NAME = "DOCUMENT_FILE_PATH_NAME";
    public static final String EXCEEDED_DAYS = "EXCEEDED_DAYS";
    public static final Integer EXCEEDED_DAYS_DEFAULT = 3;
    public static final String ON_TIME = "On Time";
    public static final String LATE = "Late";
    public static final String TOO_LATE = "Too Late";
    public static final String EARLY = "Early";
// Constants for security
    public static final String IS_AUTHENTICATED_ANONYMOUSLY = "IS_AUTHENTICATED_ANONYMOUSLY";
    public static final String IS_AUTHENTICATED_FULLY = "IS_AUTHENTICATED_FULLY";
    public static final String IS_AUTHENTICATED_REMEMBERED = "IS_AUTHENTICATED_REMEMBERED";
    //Features and permissions
    public static final String MANAGE = "Manage";
    public static final String ROLE = "Role";
    public static final String VIEW_ROLE = "view role";
    public static final String ADD_ROLE = "add role";
    public static final String DELETE_ROLE = "delete role";
    public static final String UPDATE_ROLE = "update role";
    public static final String FEATURE = "Feature";
    public static final String VIEW_FEATURE = "view feature";
    public static final String ADD_FEATURE = "add feature";
    public static final String DELETE_FEATURE = "delete feature";
    public static final String UPDATE_FEATURE = "update feature";
    public static final String VIEW_PROJECT = "view project";
    public static final String ADD_PROJECT = "add project";
    public static final String DELETE_PROJECT = "delete project";
    public static final String UPDATE_PROJECT = "update project";
    public static final String VIEW_USER = "view user";
    public static final String ADD_USER = "add user";
    public static final String DELETE_USER = "delete user";
    public static final String UPDATE_USER = "update user";
    public static final String TECHNOLOGY_FEATURE = "Technology";
    public static final String VIEW_TECHNOLOGY = "view technology";
    public static final String ADD_TECHNOLOGY = "add technology";
    public static final String DELETE_TECHNOLOGY = "delete technology";
    public static final String UPDATE_TECHNOLOGY = "update technology";
    public static final String REPORTS = "Reports";
    public static final String VIEW_REPORTS = "view report";
    public static final String DOWNLOAD_REPORTS = "download report";
    public static final String EMPLOYEE_PERFORMANCE_REPORT = "Employee Performance Report";
    public static final String DASHBOARD = "Dashboard";
    public static final String VIEW_DASHBOARD = "view dashboard";
    public static final String GANTT = "Gantt";
    public static final String VIEW_OWN_GANTT = "view own gantt";
    public static final String VIEW_OTHERS_GANTT = "view others gantt";
    public static final String CALENDAR = "Calendar";
    public static final String VIEW_OWN_CALENDAR = "view own calendar";
    public static final String VIEW_OTHERS_CALENDAR = "view others calendar";
    public static final String REPOSITORY = "Repository";
    public static final String VIEW_REPOSITORY = "view repository";
    public static final String DOCUMENTS = "Documents";
    public static final String VIEW_DOCUMENTS = "view documents";
    public static final String ADD_DOCUMENTS = "add documents";
    public static final String TASKS = "Tasks";
    public static final String VIEW_TASKS = "view tasks";
    public static final String ADD_TASKS = "add tasks";
    public static final String DELETE_TASKS = "delete tasks";
    public static final String UPDATE_TASKS = "update tasks";
    public static final String UPDATE_TASKS_LIMITED = "update limited fields";
    public static final String ACTIVITY = "Activity";
    public static final String VIEW_ACTIVITY = "view activity";
    public final static String PROFILE_PIC_PATH = System.getProperty("user.home") + File.separator + "ARMMS" + File.separator + "Profile Picture" + File.separator;

}
