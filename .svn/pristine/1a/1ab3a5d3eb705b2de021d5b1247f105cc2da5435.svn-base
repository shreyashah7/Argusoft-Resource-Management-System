/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.database.impl;

import org.springframework.stereotype.Repository;
import com.argusoft.armms.database.TaskMasterDao;
import static com.argusoft.armms.database.impl.ProjectMilestoneDaoImpl.PROJECT_ID;
import com.argusoft.armms.model.ProjectMilestone;
import com.argusoft.armms.model.ProjectResourceDetail;
import com.argusoft.armms.model.TaskMaster;
import com.argusoft.generic.database.common.impl.BaseAbstractGenericDao;
import org.hibernate.service.UnknownServiceException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.search.Query;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Synchronize;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.SearchException;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author brijesh
 */
@Repository
public class TaskMasterDaoImpl extends BaseAbstractGenericDao<TaskMaster, String> implements TaskMasterDao {

    public static final String ASSIGNED_TO = "assignedTo";
    public static final String TASK_STATUS = "taskStatus";
    public static final String COMPLETED = "Completed";
    public static final String NEW = "New";
    public static final String IN_PROGRESS = "In Progress";
    private static final String CREATED_ON = "createdOn";
    private static final String LAST_MODIFIED_ON = "lastModifiedOn";
    private static final String CREATED_BY = "createdBy";
    private static final String LAST_MODIFIED_BY = "lastModifiedBy";
    private static final String START_DATE = "startDate";
    private static final String END_DATE = "endDate";
    private static final String FOREIGN_KEY_PROJECT = "projectId.projectId";

    private static final String PROJECT_ID = "projectId";
    private static final String MILESTONE_ID = "milestoneId";

    private static final String TASK_ID = "taskId";
    private static final String USER_ID = "userId";
    public static final String ISACTIVE = "isActive";
    public static final String ISARCHIVE = "isArchive";
    private static final String TASK_PRIORITY = "taskPriority";
    private static final String IS_ACTIVE = "isActive";
    private static final String ACTUAL_END_DATE = "actualEndDate";

    @Override
    public List<TaskMaster> retrieveAllTaskOfProject(Long projectId) {

        List<Criterion> criterions = new LinkedList<Criterion>();
        criterions.add(Restrictions.eq(FOREIGN_KEY_PROJECT, projectId));
        List<TaskMaster> listOfTask = super.findByCriteriaList(criterions);
        return listOfTask;

    }

    @Override
    public String retrieveLastTaskIdOfProject(Long projectId) {

        DetachedCriteria subquery = DetachedCriteria.forClass(TaskMaster.class)
                .add(Restrictions.eq(FOREIGN_KEY_PROJECT, projectId))
                .setProjection(Projections.max(CREATED_ON).as(CREATED_ON));

        List result = getCurrentSession().createCriteria(TaskMaster.class)
                .add(Subqueries.propertiesIn(new String[]{CREATED_ON}, subquery))
                .setProjection(Projections.property(TASK_ID).as(TASK_ID))
                .list();
        if (result != null && !result.isEmpty()) {
            String taskId = result.get(0).toString();
            return taskId;
        }
        return null;

    }

    @Override
    public List<TaskMaster> retrieveAllTaskByUserId(Long userId) {

        List<Criterion> criterions = new LinkedList();

        criterions.add(Restrictions.eq(ASSIGNED_TO, userId));
        criterions.add(Restrictions.ne(TASK_STATUS, COMPLETED));
        criterions.add(Restrictions.eq(IS_ACTIVE, Boolean.TRUE));

        List<TaskMaster> listOfTask = super.findByCriteriaList(criterions);

        return listOfTask;

    }

    @Override
    public List<TaskMaster> retrieveTasksForSpecificDaysById(Date currdate, Date xDaysAgo, Long projectId, Long userId, List<Long> projectIds) {

        List<TaskMaster> taskMasterList = getCurrentSession().createCriteria(TaskMaster.class)
                .add(Restrictions.in(FOREIGN_KEY_PROJECT, projectIds))
                .add(Restrictions.eq(FOREIGN_KEY_PROJECT, projectId))
                .add(Restrictions.eq(ASSIGNED_TO, userId))
                .add(Restrictions.eq(TASK_STATUS, COMPLETED))
                .add(Restrictions.between(END_DATE, xDaysAgo, currdate))
                .add(Restrictions.disjunction()
                        .add(Restrictions.between(CREATED_ON, xDaysAgo, currdate))
                        .add(Restrictions.between(LAST_MODIFIED_ON, xDaysAgo, currdate)))
                .list();
        return taskMasterList;
    }

    @Override
    public List<TaskMaster> retrieveAllTasksForSpecificDays(Date currdate, Date xDaysAgo, List<Long> projectIds, Long userId) {

        List<TaskMaster> taskMasterList = getCurrentSession().createCriteria(TaskMaster.class)
                .add(Restrictions.in(FOREIGN_KEY_PROJECT, projectIds))
                .add(Restrictions.eq(ASSIGNED_TO, userId))
                .add(Restrictions.eq(TASK_STATUS, COMPLETED))
                .add(Restrictions.between(END_DATE, xDaysAgo, currdate))
                .add(Restrictions.disjunction()
                        .add(Restrictions.between(CREATED_ON, xDaysAgo, currdate))
                        .add(Restrictions.between(LAST_MODIFIED_ON, xDaysAgo, currdate)))
                .list();
        return taskMasterList;

    }

    @Override
    public List<TaskMaster> retrieveAllTaskByUserIdAndProjectId(Long projectId, Long userId) {
        List<Criterion> criterions = new LinkedList();
        criterions.add(Restrictions.eq(ASSIGNED_TO, userId));
        criterions.add(Restrictions.or(Restrictions.eq(TASK_STATUS, null), Restrictions.ne(TASK_STATUS, COMPLETED)));
        criterions.add(Restrictions.eq(IS_ACTIVE, Boolean.TRUE));
        if (projectId != null) {
            criterions.add(Restrictions.eq(FOREIGN_KEY_PROJECT, projectId));

        }
        List<TaskMaster> listOfTasks = super.findByCriteriaList(criterions);

        return listOfTasks;
    }

    @Override
    public List<TaskMaster> retrieveTasksForIntervalById(long userId, Calendar startTime, Calendar endTime) {

        Criteria c = getCurrentSession().createCriteria(TaskMaster.class);
        c.add(Restrictions.eq(IS_ACTIVE, Boolean.TRUE));
        c.add(Restrictions.eq(ASSIGNED_TO, userId));
        c.add(Restrictions.le(START_DATE, endTime.getTime()));
        c.add(Restrictions.ge(END_DATE, startTime.getTime()));
        List<TaskMaster> listOfTask = c.list();
        return listOfTask;
    }

    @Override
    public List<TaskMaster> retrieveTasksForIntervalByIdForGantt(long userId, Calendar startTime, Calendar endTime) {

        Criteria criteria = getCurrentSession().createCriteria(TaskMaster.class);

        Criterion dataOfThisMonth = Restrictions.and(Restrictions.eq(IS_ACTIVE, Boolean.TRUE),
                Restrictions.eq(ASSIGNED_TO, userId),
                Restrictions.le(START_DATE, endTime.getTime()),
                Restrictions.ge(END_DATE, startTime.getTime()));

        Criterion dataOfLaterActualEndDate = Restrictions.and(Restrictions.eq(IS_ACTIVE, Boolean.TRUE),
                Restrictions.eq(ASSIGNED_TO, userId),
                Restrictions.le(START_DATE, endTime.getTime()),
                Restrictions.ge(ACTUAL_END_DATE, startTime.getTime()));

        Criterion dataOfNullActualEndDate = Restrictions.and(Restrictions.eq(IS_ACTIVE, Boolean.TRUE),
                Restrictions.eq(ASSIGNED_TO, userId),
                Restrictions.le(START_DATE, endTime.getTime()),
                Restrictions.eq(ACTUAL_END_DATE, null));

//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
        criteria.add(Restrictions.or(dataOfThisMonth, dataOfLaterActualEndDate, dataOfNullActualEndDate));

        List<TaskMaster> listOfTask = criteria.list();

//        List<TaskMaster> newListOfTask = new ArrayList<TaskMaster>();
//
//        for (TaskMaster taskMaster : listOfTask) {
//            if (taskMaster.getActualEndDate() == null && taskMaster.getStartDate() != null && taskMaster.getEndDate() != null) {
//                if (taskMaster.getStartDate().getTime() > calendar.getTime().getTime()) {                                        
//                    taskMaster.setActualEndDate(calendar.getTime());
//                        newListOfTask.add(taskMaster);
//                } else {
//                    if (calendar.getTimeInMillis() < startTime.getTimeInMillis()) {
//
//                    } else {
//                        taskMaster.setActualEndDate(calendar.getTime());
//                        newListOfTask.add(taskMaster);
//                    }
//                }
//            } else  {
//                newListOfTask.add(taskMaster);
//            }
//        }
        return listOfTask;
    }

    @Override
    public List<TaskMaster> retrieveTaskByProjectId(Long projectId) {
        List<Criterion> criterions = new LinkedList();

        criterions.add(Restrictions.eq(FOREIGN_KEY_PROJECT, projectId));
        List<TaskMaster> task = super.findByCriteriaList(criterions);
        return task;
    }

    @Override
    public List<TaskMaster> retrieveTaskByProjectIdAndUserIdAndDates(Long userId, List<Long> projectIds, Date startDate, Date endDate) {

        Criteria c = getCurrentSession().createCriteria(TaskMaster.class);
        c.createAlias(PROJECT_ID, PROJECT_ID);
        if (projectIds != null && !(projectIds.isEmpty())) {
            System.out.println("projectIds------" + projectIds);
            c.add(Restrictions.in(FOREIGN_KEY_PROJECT, projectIds));
        }
        System.out.println("userId---------:" + userId);
        c.add(Restrictions.eq(ASSIGNED_TO, userId));
        c.add(Restrictions.between(START_DATE, startDate, endDate));
        List<TaskMaster> taskList = c.list();
        return taskList;

    }

    @Override
    public List<TaskMaster> retrieveTasksByUserIds(List<Long> userIDs) {
        List<TaskMaster> taskList;
        List<Criterion> criterions = new LinkedList();
        if (userIDs != null && !userIDs.isEmpty()) {
            criterions.add(Restrictions.in(ASSIGNED_TO, userIDs));
        }
        taskList = super.findByCriteriaList(criterions);
        return taskList;
    }

    @Override
    public List<TaskMaster> retrieveTasksOfProjectForCurrentMonth(Long projectId, Calendar startDate, Calendar endDate) {

        Criteria c = getCurrentSession().createCriteria(TaskMaster.class);
        c.add(Restrictions.eq(FOREIGN_KEY_PROJECT, projectId));
        c.add(Restrictions.between(CREATED_ON, startDate.getTime(), endDate.getTime()));

        List<TaskMaster> listOfTask = c.list();
        return listOfTask;
    }

    @Override
    public List<TaskMaster> retrieveAllTaskOfCurrentUserById(Date startDate, Date endDate, Long userId, List<Long> projectIds) {
        Date currDate = new Date();
        if (endDate == null) {
            endDate = new Date();
        }

        List<TaskMaster> taskMasterList = getCurrentSession().createCriteria(TaskMaster.class)
                .add(Restrictions.in(FOREIGN_KEY_PROJECT, projectIds))
                .add(Restrictions.eq(ISACTIVE, Boolean.TRUE))
                .add(Restrictions.disjunction()
                        .add(Restrictions.conjunction()
                                .add(Restrictions.ge(CREATED_ON, startDate))
                                .add(Restrictions.le(CREATED_ON, endDate)))
                        .add(Restrictions.conjunction()
                                .add(Restrictions.ge(LAST_MODIFIED_ON, startDate))
                                .add(Restrictions.le(LAST_MODIFIED_ON, endDate))))
                .add(Restrictions.disjunction()
                        .add(Restrictions.eq(ASSIGNED_TO, userId))
                        .add(Restrictions.eq(CREATED_BY, userId))
                        .add(Restrictions.eq(LAST_MODIFIED_BY, userId)))
                .list();
        return taskMasterList;
    }

    @Override
    public List<TaskMaster> retrieveTaskWithFilters(Date startDate, Date endDate, Long assignedTo, Long taskPriority, Long projectId, String status, Long createdBy) {
        List<TaskMaster> taskList;
        List<Criterion> criterions = new LinkedList();
        if (assignedTo != null) {
            criterions.add(Restrictions.eq(ASSIGNED_TO, assignedTo));
        }
        if (createdBy != null) {
            criterions.add(Restrictions.eq(CREATED_BY, createdBy));
        }
        if (status != null && !status.isEmpty()) {
            criterions.add(Restrictions.eq(TASK_STATUS, status));
        }
        if (taskPriority != null) {
            criterions.add(Restrictions.eq(TASK_PRIORITY, taskPriority));
        }
        if (projectId != null) {
            criterions.add(Restrictions.eq(FOREIGN_KEY_PROJECT, projectId));
        }

        if (startDate != null && endDate != null) {
            criterions.add(Restrictions.ge(START_DATE, startDate));
            criterions.add(Restrictions.le(END_DATE, endDate));
        } else {
            if (startDate != null) {
                criterions.add(Restrictions.eq(START_DATE, startDate));
            } 
            if (endDate != null){
                criterions.add(Restrictions.eq(END_DATE, endDate));
            }
        }

        criterions.add(Restrictions.eq(IS_ACTIVE, Boolean.TRUE));
        taskList = super.findByCriteriaList(criterions);

        return taskList;
    }

    @Override
    public List<TaskMaster> retrieveIncompleteTask(Long userId) {
        DetachedCriteria subquery = DetachedCriteria.forClass(ProjectResourceDetail.class)
                .setFetchMode(PROJECT_ID, FetchMode.JOIN)
                .add(Restrictions.eq(USER_ID, userId))
                .setProjection(Projections.property(FOREIGN_KEY_PROJECT).as(PROJECT_ID));
        List<TaskMaster> taskMasterList = getCurrentSession().createCriteria(TaskMaster.class)
                .add(Subqueries.propertiesIn(new String[]{PROJECT_ID}, subquery))
                .add(Restrictions.eq(ASSIGNED_TO, userId))
                .add(Restrictions.eq(ISACTIVE, Boolean.TRUE))
                .add(Restrictions.disjunction()
                        .add(Restrictions.eq(TASK_STATUS, NEW))
                        .add(Restrictions.eq(TASK_STATUS, IN_PROGRESS)))
                .list();
        return taskMasterList;
    }

    @Override
    public List<TaskMaster> searchString(String searchString) {

        Session currentSession = getCurrentSession();

        FullTextSession fullTextSession = Search.getFullTextSession(currentSession);

        List<TaskMaster> result = null;

        try {
            fullTextSession.createIndexer(TaskMaster.class).startAndWait();
        } catch (InterruptedException ex) {
            Logger.getLogger(TaskMasterDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        final QueryBuilder qb = fullTextSession.getSearchFactory()
                .buildQueryBuilder().forEntity(TaskMaster.class).get();

        Query luceneQuery;

        luceneQuery = qb
                .keyword()
                .onFields("taskId", "taskName", "taskDescription", "taskStatus")
                .matching(searchString)
                .createQuery();

        org.hibernate.Query fullTextQuery = fullTextSession.createFullTextQuery(luceneQuery);

        result = fullTextQuery.list();

        if (result == null) {
            result = new ArrayList<TaskMaster>();
        }
        return result;

    }

    @Override
    public List<TaskMaster> retrieveTaskByMilestoneId(Long milestoneId) {
        List<Criterion> criterions = new LinkedList();
        criterions.add(Restrictions.eq(MILESTONE_ID, milestoneId));
        List<TaskMaster> tasks = super.findByCriteriaList(criterions);
        return tasks;
    }

    @Override
    public List<TaskMaster> retrieveCompletedTaskByProjectId(Long projectId) {
        List<Criterion> criterions = new LinkedList();
        if (projectId != null) {
            criterions.add(Restrictions.eq(FOREIGN_KEY_PROJECT, projectId));
        }
        criterions.add(Restrictions.eq(TASK_STATUS, COMPLETED));
        List<TaskMaster> completedtask = super.findByCriteriaList(criterions);
        return completedtask;
    }
}
