/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.core;

import com.argusoft.armms.model.*;
import com.argusoft.armms.model.TaskMaster;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author brijesh
 */
public interface TaskService {

    /**
     * add task detail while assigning task to user
     *
     * @author Brijesh
     * @param taskMaster Object
     * @return TaskId
     */
    public String addTask(TaskMaster task);

    /**
     * retrieve last TaskId of project by retrieving last Created Task Of
     * Project
     *
     * @author Brijesh
     * @param projectId
     * @return TaskId
     */
    public String retrieveLastTaskIdOfProject(Long projectId);

    /**
     * retrieveAllActiveTask method retrieves a list of all active tasks
     *
     * @author Brijesh
     */
    public List<TaskMaster> retrieveAllActiveTask();

    /**
     * addTaskTrack method creates TaskTrack object
     *
     * @param task Takes object of class TaskTrack for which task track has to
     * be created
     */
    public Long addTaskTrack(TaskTrack task);

    /**
     *
     * @param idFieldname
     * @param ids
     * @return
     */
    public List<TaskMaster> retrieveAllTaskByIds(String idFieldname, List<String> ids);

    /**
     *
     * @param taskdecline
     * @return
     */
    public Long addTaskDeclineDetail(TaskDeclineDetail taskdecline);

    /**
     * updateTask method update task object
     *
     * @author Brijesh
     * @param taskMaster
     */
    
    public void updateTask(TaskMaster taskMaster);
     /**
     *  retrieveTasksByMilestoneId method returns all the task related with
     * milestoneID
     * @author Shifa
     * @param milestoneId Takes value of milestone ID for which we want to fetch all
     * task
     * @return set of TaskMaster correspondence to miletsoneId
     */
    public List<TaskMaster> retrieveTasksByMilestoneId(Long milestoneId);

    /**
     * retrieveCompletedTasksByMilestonesId method returns all the completed
     * tasks related with projectID
     *
     * @author Shifa
     * @param projectId Takes value of milestone ID for which we want to fetch all
     * task
     * @return set of TaskMaster correspondence to projectId
     */
    public List<TaskMaster> retrieveCompletedTasksByProjectId(Long projectId);

    /**
     * retrieveTaskByTaskId method returns instance of class TestMaster by
     * searching Id
     *
     * @param Id Takes task id for which we want to get task
     * @return object of class taskMaster correspond to taskId
     */
    public TaskMaster retrieveTaskByTaskId(String Id);

    /**
     * retrieveTaskByUserId method returns instance of class TaskMaster by
     * searching Id
     *
     * @param userId Takes user id for which we want to get task
     * @return object of class taskMaster correspond to taskId
     */
    public List<TaskMaster> retrieveTaskByUserId(Long userId);

    /**
     * retrieveTaskByUserIds method returns instance of class TaskMaster by
     * searching Ids
     *
     * @param userIds Takes user id for which we want to get task
     * @return object of class taskMaster correspond to taskId
     */
    public List<TaskMaster> retrieveTaskByUserIds(List<Long> userIds);

    /**
     * retrieveTaskByUserIdAndProjectId method returns instance of class
     * TaskMaster by searching userId & projectId
     *
     * @param userId Takes user id for which we want to get task
     * @param projectId takes projectId
     * @return object of class taskMaster correspond to taskId
     */
    public List<TaskMaster> retrieveTaskByUserIdAndProjectId(Long projectId, Long userId);

    /**
     * to retrieve list of task working on a project
     *
     * @author Brijesh
     * @param projectId
     * @return
     */
    public List<TaskMaster> retrieveAllTaskOfProject(Long projectId);

    /**
     * addTaskAttachment method takes a object of taskattachment it returns a
     * taskid of add task
     *
     * @author Brijesh
     */
    public void addTaskAttachment(TaskAttachment taskAttchment);

    /**
     * deleteTaskAttachment method takes a taskid as param it will delete the
     * task of passed id
     */
    public void deleteTaskAttachment(Long id);

    /**
     * addtaskTechnology method add the technolgy for given taskid
     *
     * @author Brijesh
     * @param taskTechnologyDetail
     * @return taskTechnologyId of added technology
     */
    public void addTaskTechnology(TaskTechnologyDetail taskTechnologyDetail);

    /**
     * deleteTaskTechnology method will remove technology from given task
     *
     * @param TaskTechlogyId is the id of taskTechnology
     */
    public void deleteTaskTechnology(TaskTechnologyDetailPK taskTechnologyDetailPK);

    /**
     * retrieves a list of all the current tasks for which end time is not
     * stored
     *
     * @param currenttasktrck
     * @return
     */
    public List<TaskTrack> retrieveCurrentTaskTrack(Boolean currenttasktrck);

    /**
     * retrieves a list of all the current tasks by task id for which end time
     * is not stored for a particular task
     *
     * @param taskId
     * @return
     */
    public TaskTrack retrieveCurrentTaskTrackByTaskId(String taskId);

    /**
     * retrieveTaskTrackById method returns instance of class TaskTrack by
     * searching trackId
     *
     * @param trackId Takes track id for which we want to get task
     * @return object of class taskTrack correspond to trackId
     */
    public TaskTrack retrieveTaskTrackById(Long trackId);

    /**
     * updateTaskTrack method update TaskTrack object
     *
     * @param tasktrack Takes object of class TaskTrack for which Task has to be
     * created
     */
    public void updateTaskTrack(TaskTrack tasktrack);

    /**
     * Retrieve list of all TaskTrack
     *
     * @return list of TaskTrack
     */
    public List<TaskTrack> retrieveAllTaskTrack();

    /**
     * retrieveTasksForSpecificDaysById methods retrieves all the task for the
     * user and particular project
     *
     * @param currdate
     * @param xDaysAgo
     * @param projectId
     * @param userId
     * @param days
     * @return list of object of TaskMaster
     * @author shreya
     */
    public List<TaskMaster> retrieveTasksForSpecificDaysById(Date currdate, Date xDaysAgo, Long projectId, Long userId,List<Long> projectIds);

    /**
     * retrieveTaskByProjectId method returns all the resources related with
     * projectID
     *
     * @param projectId Takes value of project ID for which we want to fetch all
     * task
     * @return list of taskMaster correspondence to taskId
     */
    public List<TaskMaster> retrieveTaskByProjectId(Long projectId);

    /**
     * to retrieve all task of specified days from task master table table
     *
     * @param currdate
     * @param xDaysAgo configured in system Configuration table
     * @param userId for the user in that project.
     * @return list of object of class TaskMaster
     * @author shreya
     */
    public List<TaskMaster> retrieveAllTasksForSpecificDays(Date currdate, Date xDaysAgo, List<Long> projectIds,Long userId);

    /**
     * retrieve list of Tasks of particular user between start time and end time
     *
     * @author ravi
     * @param userId user id
     * @param startTime start time
     * @param endTime end time
     * @return list of tasks
     */
    public List<TaskMaster> retrieveTasksForIntervalById(long userId, Calendar startTime, Calendar endTime);   
    
    public List<TaskMaster> retrieveTasksForIntervalByIdForGantt(long userId, Calendar startTime, Calendar endTime);   

    /**
     * retrieveTaskDeclineDetailByTaskId method returns all the task decline
     * details related with taskId
     *
     * @param taskId Takes value of taskId for which we want to fetch all task
     * decline details
     * @return set of TaskDeclineDetail correspondence to taskId
     */
    public List<TaskDeclineDetail> retrieveTaskDeclineDetailByTaskId(String taskId);

    /**
     * retrieveIncompleteTask method returns all the incomplete task of the user
     *
     * @param userId
     * @return list of object of TaskMaster
     */
    public List<TaskMaster> retrieveIncompleteTask(Long userId);

    /**
     * to retrieve all task of specified days from task master table and project
     * of user table
     *
     * @author shreya
     * @param userId for the user in that project.
     * @param projectIds
     * @param startDate
     * @param endDate
     * @return list of object of class TaskMaster
     */
    public List<TaskMaster> retrieveTaskByProjectIdAndUserIdAndDates(Long userId, List<Long> projectIds, Date startDate, Date endDate);

    public List<TaskMaster> retrieveTasksOfProjectForCurrentMonth(Long projectId, Calendar startDate, Calendar endDate);

    /**
     * retrieve tasks attachment detail by task id provided in param
     *
     * @author ravi
     * @param taskId Task id
     * @return
     */
    public List<TaskAttachment> retrieveTaskAttachmentsByTaskId(String taskId);

    /**
     * retrieveAllTaskOfCurrentUserByDates retrieve all task detail of current
     * user between dates
     *
     * @author shreya
     * @param startDate
     * @param endDate
     * @param userId
     * @return list of object of TaskMaster
     */
    public List<TaskMaster> retrieveAllTaskOfCurrentUserByDates(Date startDate, Date endDate, Long userId,List<Long> projectIds);

    /**
     * retrieve all task with given filters
     *
     * @author ravi
     * @param startDate
     * @param endDate
     * @param assignedTo
     * @param taskPriority
     * @param projectId
     * @param status
     * @param createdBy
     * @return list of TaskMaster
     */
    public List<TaskMaster> retrieveTaskWithFilters(Date startDate, Date endDate, Long assignedTo, Long taskPriority, Long projectId, String status, Long createdBy);
    
    public List<TaskMaster> searchString(String searchString);

    public List<TaskTrack> retrieveTaskTrackDetailsByUserAndProjectId(Long userId,Long ProjectId);
}
