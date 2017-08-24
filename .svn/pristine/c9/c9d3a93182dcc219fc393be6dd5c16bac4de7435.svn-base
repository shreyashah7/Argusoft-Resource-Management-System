/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.database;

import com.argusoft.armms.model.TaskMaster;
import com.argusoft.generic.database.common.GenericDao;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author brijesh
 * @since 04-MAR-2014
 */
public interface TaskMasterDao extends GenericDao<TaskMaster, String> {

    /**
     * to retrieve list of task working on a project
     *
     * @author Brijesh
     * @param projectId
     * @return List of taskMaster Object
     */
    public List<TaskMaster> retrieveAllTaskOfProject(Long projectId);

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
     * retrieveTaskByUserId method returns instance of class TaskMaster by
     * searching Id
     *
     * @param userId Takes user id for which we want to get task
     * @return object of class taskMaster correspond to taskId
     */
    public List<TaskMaster> retrieveAllTaskByUserId(Long userId);

    /**
     * retrieveAllTaskByUserIdAndProjectId method returns instance of class
     * TaskMaster by searching userId & projectId
     *
     * @param userId Takes user id for which we want to get task
     * @param projectId takes projectId
     * @return object of class taskMaster correspond to taskId
     */
    public List<TaskMaster> retrieveAllTaskByUserIdAndProjectId(Long projectId, Long userId);

    /**
     * retrieveTasksForSpecificDaysById methods retrieves all the task for the
     * user and particular project
     *
     * @param currdate
     * @param xDaysAgo
     * @param projectId
     * @param userId
     * @param days
     * @return
     */
    public List<TaskMaster> retrieveTasksForSpecificDaysById(Date currdate, Date xDaysAgo, Long projectId, Long userId, List<Long> projectIds);

    /**
     * retrieveIncompleteTask method returns all the incomplete task of the user
     *
     * @param userId
     * @return list of object of TaskMaster
     */
    public List<TaskMaster> retrieveIncompleteTask(Long userId);

    /**
     * to retrieve all task of specified days from task master table table
     *
     * @param currdate
     * @param xDaysAgo configured in system Configuration table
     * @param userId for the user in that project.
     * @return list of object of class TaskMaster
     */
    public List<TaskMaster> retrieveAllTasksForSpecificDays(Date currdate, Date xDaysAgo, List<Long> projectIds, Long userIds);

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
     * retrieveTaskByProjectId method returns all the resources related with
     * projectID
     *
     * @param projectId Takes value of project ID for which we want to fetch all
     * task
     * @return list of taskMaster correspondence to taskId
     */
    public List<TaskMaster> retrieveTaskByProjectId(Long projectId);
    /**
     * retrieveTaskByMilestoneId method returns all the task related with
     * milestoneID
     *
     * @param milestoneId Takes value of milestone ID for which we want to fetch
     * all task
     * @return list of taskMaster correspondence to milestoneId
     */
    public List<TaskMaster> retrieveTaskByMilestoneId(Long milestoneId);

    /**
     * Get list of completed task by project ID
     *
     * @param projectId
     * @return list of completed task corresponding to projectId
     */
    public List<TaskMaster> retrieveCompletedTaskByProjectId(Long projectId);

    /**
     * to retrieve all task of specified days from task master table and project
     * of user table
     *
     * @param userId for the user in that project.
     * @param projectIds
     * @param startDate
     * @param endDate
     * @return list of object of class TaskMaster
     */
    public List<TaskMaster> retrieveTaskByProjectIdAndUserIdAndDates(Long userId, List<Long> projectIds, Date startDate, Date endDate);

    public List<TaskMaster> retrieveTasksByUserIds(List<Long> userIDs);

    public List<TaskMaster> retrieveTasksOfProjectForCurrentMonth(Long projectId, Calendar startDate, Calendar endDate);

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
    public List<TaskMaster> retrieveAllTaskOfCurrentUserById(Date startDate, Date endDate, Long userId, List<Long> projectIds);

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
}
