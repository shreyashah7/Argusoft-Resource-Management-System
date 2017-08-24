/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.database.impl;

import com.argusoft.armms.database.TaskTrackDao;
import com.argusoft.armms.model.TaskTrack;
import com.argusoft.generic.database.common.impl.BaseAbstractGenericDao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author brijesh
 */
@Repository
public class TaskTrackDaoImpl extends BaseAbstractGenericDao<TaskTrack, Long> implements TaskTrackDao {

    public static final String ENDTIME = "endTime";
    public static final String TASK_ID = "taskId";
    public static final String Log_BY = "logBy";
    public static final String PROJECT_ID = "projectId.projectId";

    @Override
    public List<TaskTrack> retrieveCurrentTaskTrack(Boolean currenttasktrack) {
        List<Criterion> criterions = new LinkedList();

        if (currenttasktrack == Boolean.TRUE) {

            criterions.add(Restrictions.isNull(ENDTIME));
        }
        List<TaskTrack> tasktrack = super.findByCriteriaList(criterions);

        return tasktrack;
    }

    @Override
    public TaskTrack retrieveCurrentTaskTrackById(String taskId) {
        List<Criterion> criterions = new LinkedList();

        criterions.add(Restrictions.eq(TASK_ID, taskId));
        criterions.add(Restrictions.isNull(ENDTIME));

        TaskTrack tasktrack = super.findEntityByCriteriaList(criterions);

        return tasktrack;

    }

    @Override
    public List<TaskTrack> retrieveTaskTrackDetailsByUserAndProjectId(Long userId,Long projectId) {
        List<Criterion> criterions = new LinkedList();
        System.out.println("userId"+userId+projectId);
        if (userId != null) {

            criterions.add(Restrictions.eq(Log_BY, userId));
        }

        if (projectId != null) {

            criterions.add(Restrictions.eq(PROJECT_ID, projectId));
        }

        List<TaskTrack> tasktrack = new ArrayList<TaskTrack>();
        
        
        tasktrack = super.findByCriteriaList(criterions);
                
        return tasktrack;
    }
}
