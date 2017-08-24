/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.database.impl;

import com.argusoft.armms.database.TaskCommentDao;
import com.argusoft.armms.model.TaskComment;
import com.argusoft.generic.database.common.impl.BaseAbstractGenericDao;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author shifa
 */
@Repository
public class TaskCommentDaoImpl extends BaseAbstractGenericDao<TaskComment, Long> implements TaskCommentDao {

    public static final String TASK_ID = "taskId.taskId";
    public static final String IS_ACTIVE = "isActive";

    @Override
    public List<TaskComment> retrieveTaskCommentByTaskId(String taskId) {
        List<Criterion> criterions = new LinkedList();
        criterions.add(Restrictions.eq(TASK_ID, taskId));
        criterions.add(Restrictions.eq(IS_ACTIVE, Boolean.TRUE));

        List<TaskComment> listOfTasks = super.findByCriteriaList(criterions);
        return listOfTasks;
    }
}
