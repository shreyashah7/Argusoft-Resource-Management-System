/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.argusoft.armms.database.impl;

import org.springframework.stereotype.Repository;
import com.argusoft.armms.database.TaskAttachmentDao;
import com.argusoft.armms.model.TaskAttachment;
import com.argusoft.generic.database.common.impl.BaseAbstractGenericDao;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * 
 * @author brijesh
 */
@Repository
public class TaskAttachmentDaoImpl extends BaseAbstractGenericDao<TaskAttachment, Long> implements TaskAttachmentDao {

    public static final String TASK_ID = "taskId";
    
    @Override
    public List<TaskAttachment> retrieveAttachmentByTaskId(String taskId) {
        List<Criterion> criterions = new LinkedList<Criterion>();
        criterions.add(Restrictions.eq(TASK_ID, taskId));
        List<TaskAttachment> listOfTaskAttachments = super.findByCriteriaList(criterions);
        return listOfTaskAttachments;        
        
    }

    
    
}
