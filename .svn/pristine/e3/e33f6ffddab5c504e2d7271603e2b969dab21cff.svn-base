/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.core.impl;

import com.argusoft.armms.core.TaskService;
import com.argusoft.armms.database.TaskMasterDao;
import com.argusoft.armms.database.TaskAttachmentDao;
import com.argusoft.armms.database.TaskDeclineDetailDao;
import com.argusoft.armms.database.TaskTechnologyDetailDao;
import com.argusoft.armms.database.TaskTrackDao;
import com.argusoft.armms.model.ProjectMilestone;
import com.argusoft.armms.model.TaskAttachment;
import com.argusoft.armms.model.TaskDeclineDetail;
import com.argusoft.armms.model.TaskMaster;
import com.argusoft.armms.model.TaskTechnologyDetail;
import com.argusoft.armms.model.TaskTechnologyDetailPK;
import com.argusoft.armms.model.TaskTrack;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author brijesh
 * @since 04-MAR-2014
 */
@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskMasterDao taskMasterdao;
    @Autowired
    TaskDeclineDetailDao taskdeclinedao;

    @Autowired
    TaskTrackDao taskTrackdao;

    @Autowired
    TaskAttachmentDao taskAttachmentdao;

    @Autowired
    TaskTechnologyDetailDao taskTechnologyDetaildao;

    @Override
    public String addTask(TaskMaster taskMaster) {
        Date CurrentDate = Calendar.getInstance().getTime();
        taskMaster.setCreatedOn(CurrentDate);
//        taskMaster.setLastModifiedOn(CurrentDate);
        taskMaster.setIsActive(Boolean.TRUE);
        return this.taskMasterdao.create(taskMaster);

    }

    @Override
    public String retrieveLastTaskIdOfProject(Long projectId) {

        return this.taskMasterdao.retrieveLastTaskIdOfProject(projectId);

    }

    @Override
    public Long addTaskTrack(TaskTrack taskTrack) {
        return this.taskTrackdao.create(taskTrack);

    }

    @Override
    public void updateTask(TaskMaster taskMaster) {
        Date CurrentDate = Calendar.getInstance().getTime();
        taskMaster.setLastModifiedOn(CurrentDate);
        this.taskMasterdao.update(taskMaster);
    }

    @Override
    public TaskMaster retrieveTaskByTaskId(String Id) {
        return this.taskMasterdao.retrieveById(Id);
    }

    @Override
    public void addTaskAttachment(TaskAttachment taskAttchment) {
        if (taskAttchment != null) {
            taskAttchment.setCreatedOn(Calendar.getInstance().getTime());
            taskAttchment.setIsActive(Boolean.TRUE);
        }
        this.taskAttachmentdao.create(taskAttchment);

    }

    @Override
    public List<TaskMaster> retrieveAllTaskOfProject(Long projectId) {
        return this.taskMasterdao.retrieveAllTaskOfProject(projectId);
    }

    @Override
    public void addTaskTechnology(TaskTechnologyDetail taskTechnologyDetail) {
        Date createdOn = Calendar.getInstance().getTime();
        if (taskTechnologyDetail.getCreatedOn() != null) {
            taskTechnologyDetail.setCreatedOn(createdOn);
        }
        if (taskTechnologyDetail.getLstModifiedOn() != null) {
            taskTechnologyDetail.setLstModifiedOn(createdOn);
        }

        taskTechnologyDetail.setIsActive(Boolean.TRUE);
        this.taskTechnologyDetaildao.create(taskTechnologyDetail);
    }

    @Override
    public void deleteTaskTechnology(TaskTechnologyDetailPK taskTechnologyDetailPK) {

        this.taskTechnologyDetaildao.deleteById(taskTechnologyDetailPK);
    }

    @Override
    public void deleteTaskAttachment(Long id) {
        this.taskAttachmentdao.deleteById(id);
    }

    @Override
    public List<TaskMaster> retrieveTaskByUserId(Long userId) {

        return taskMasterdao.retrieveAllTaskByUserId(userId);
    }

    @Override
    public List<TaskTrack> retrieveCurrentTaskTrack(Boolean currenttasktrck) {
        return this.taskTrackdao.retrieveCurrentTaskTrack(currenttasktrck);
    }

    @Override
    public TaskTrack retrieveTaskTrackById(Long trackId) {
        return (this.taskTrackdao.retrieveById(trackId));
    }

    @Override
    public void updateTaskTrack(TaskTrack tasktrack) {
        this.taskTrackdao.update(tasktrack);
    }

    @Override
    public List<TaskTrack> retrieveAllTaskTrack() {
        List<TaskTrack> result = this.taskTrackdao.retrieveAll();
        return result;
    }

    @Override
    public List<TaskMaster> retrieveTasksForSpecificDaysById(Date currdate, Date xDaysAgo, Long projectId, Long userId, List<Long> projectIds) {
        return taskMasterdao.retrieveTasksForSpecificDaysById(currdate, xDaysAgo, projectId, userId, projectIds);
    }

    @Override
    public List<TaskMaster> retrieveAllTasksForSpecificDays(Date currdate, Date xDaysAgo, List<Long> projectIds, Long userId) {
        return taskMasterdao.retrieveAllTasksForSpecificDays(currdate, xDaysAgo, projectIds, userId);
    }

    @Override
    public Long addTaskDeclineDetail(TaskDeclineDetail taskdecline) {
        Long create = null;
        try {
            create = taskdeclinedao.create(taskdecline);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return create;

    }

    @Override
    public List<TaskMaster> retrieveTaskByUserIdAndProjectId(Long projectId, Long userId) {
        return taskMasterdao.retrieveAllTaskByUserIdAndProjectId(projectId, userId);
    }

    @Override
    public List<TaskMaster> retrieveTasksForIntervalById(long userId, Calendar startTime, Calendar endTime) {
        return taskMasterdao.retrieveTasksForIntervalById(userId, startTime, endTime);
    }  
    
    @Override
    public List<TaskMaster> retrieveTasksForIntervalByIdForGantt(long userId, Calendar startTime, Calendar endTime) {
        return taskMasterdao.retrieveTasksForIntervalByIdForGantt(userId, startTime, endTime);
    }  
    
    @Override
    public List<TaskDeclineDetail> retrieveTaskDeclineDetailByTaskId(String taskId) {
        return taskdeclinedao.retrieveTaskDeclineDetailByTaskId(taskId);
    }

    @Override
    public TaskTrack retrieveCurrentTaskTrackByTaskId(String taskId) {
        return this.taskTrackdao.retrieveCurrentTaskTrackById(taskId);
    }

    @Override
    public List<TaskMaster> retrieveAllActiveTask() {
        List<TaskMaster> taskMasters = taskMasterdao.retrieveAll();
        List<TaskMaster> taskMasterList = new ArrayList();
        for (TaskMaster projectMasterVar : taskMasters) {
            if (projectMasterVar.getIsActive()) {
                taskMasterList.add(projectMasterVar);
            }
        }
        return taskMasterList;
    }

    public List<TaskMaster> retrieveAllTaskByIds(String idFieldname, List<String> ids) {
        return taskMasterdao.retriveByIds("taskId", ids);
    }

    @Override
    public List<TaskMaster> retrieveTaskByProjectId(Long projectId) {
        return taskMasterdao.retrieveTaskByProjectId(projectId);
    }

    @Override
    public List<TaskMaster> retrieveTaskByProjectIdAndUserIdAndDates(Long userId, List<Long> projectIds, Date startDate, Date endDate) {
        return taskMasterdao.retrieveTaskByProjectIdAndUserIdAndDates(userId, projectIds, startDate, endDate);
    }

    @Override
    public List<TaskMaster> retrieveTaskByUserIds(List<Long> userIDs) {
        return taskMasterdao.retrieveTasksByUserIds(userIDs);
    }

    @Override
    public List<TaskMaster> retrieveTasksOfProjectForCurrentMonth(Long projectId, Calendar startDate, Calendar endDate) {
        return taskMasterdao.retrieveTasksOfProjectForCurrentMonth(projectId, startDate, endDate);
    }

    @Override
    public List<TaskAttachment> retrieveTaskAttachmentsByTaskId(String taskId) {

        return taskAttachmentdao.retrieveAttachmentByTaskId(taskId);

    }

    @Override
    public List<TaskMaster> retrieveAllTaskOfCurrentUserByDates(Date startDate, Date endDate, Long userId, List<Long> projectIds) {
        return taskMasterdao.retrieveAllTaskOfCurrentUserById(startDate, endDate, userId, projectIds);
    }

    @Override
    public List<TaskMaster> retrieveIncompleteTask(Long userId) {
        return taskMasterdao.retrieveIncompleteTask(userId);
    }

    @Override
    public List<TaskMaster> retrieveTaskWithFilters(Date startDate, Date endDate, Long assignedTo, Long taskPriority, Long projectId, String status, Long createdBy) {
        return taskMasterdao.retrieveTaskWithFilters(startDate, endDate, assignedTo, taskPriority, projectId, status, createdBy);
    }

    @Override
    public List<TaskMaster> searchString(String searchString) {
        return taskMasterdao.searchString(searchString);
    }

    @Override
    public List<TaskMaster> retrieveTasksByMilestoneId(Long milestoneId) {
        return (taskMasterdao.retrieveTaskByMilestoneId(milestoneId));
    }

    @Override
    public List<TaskMaster> retrieveCompletedTasksByProjectId(Long projectId) {
        return this.taskMasterdao.retrieveCompletedTaskByProjectId(projectId);
    }

    @Override
    public List<TaskTrack> retrieveTaskTrackDetailsByUserAndProjectId(Long userId, Long projectId) {
        return taskTrackdao.retrieveTaskTrackDetailsByUserAndProjectId(userId, projectId);
    }

}
