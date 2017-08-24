/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.argusoft.armms.database.impl;

import com.argusoft.armms.database.TaskDeclineDetailDao;
import com.argusoft.armms.model.TaskDeclineDetail;
import com.argusoft.armms.model.TaskMaster;
import com.argusoft.generic.database.common.impl.BaseAbstractGenericDao;
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
public class TaskDeclineDetailDaoImpl  extends BaseAbstractGenericDao<TaskDeclineDetail, Long>implements TaskDeclineDetailDao {
public static final String TASK_ID = "taskId.taskId";
    @Override
    public List<TaskDeclineDetail> retrieveTaskDeclineDetailByTaskId(String taskId) {
        List<Criterion> criterions = new LinkedList();
        criterions.add(Restrictions.eq(TASK_ID,taskId));
       
        List<TaskDeclineDetail> listOfTasks = super.findByCriteriaList(criterions);
        return listOfTasks;
    
       
       
    
    }

}
