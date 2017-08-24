/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.argusoft.armms.database.impl;

import com.argusoft.armms.database.WatcherDao;
import com.argusoft.armms.model.Watcher;
import com.argusoft.generic.database.common.impl.BaseAbstractGenericDao;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author shreya
 */
@Repository
public class WatcherDaoImpl extends BaseAbstractGenericDao<Watcher, Long> implements WatcherDao {

    public static final String IS_ACTIVE = "isActive";
    private static final String LAST_MODIFIED_ON = "lstModifiedOn";
    private static final String LAST_MODIFIED_BY = "lstModifiedBy";
    private static final String CREATED_ON = "createdOn";
    public static final String FOREIGN_KEY_TASK_ID = "taskId.taskId";
    public static final String WATCHER_ID = "watcherId";
    
    @Override
    public List<Watcher> retrieveWatcherByTaskId(String taskId) {
        List<Criterion> criterions = new LinkedList<Criterion>();
        if (taskId != null) {
            criterions.add(Restrictions.eq(FOREIGN_KEY_TASK_ID, taskId));
        }
        criterions.add(Restrictions.eq(IS_ACTIVE, Boolean.TRUE));
        List<Watcher> listOfWatchers = super.findByCriteriaList(criterions);
        return listOfWatchers;
    }
    
}
