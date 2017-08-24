/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.argusoft.armms.database.impl;

import com.argusoft.armms.database.EmailNotificationDao;
import com.argusoft.armms.model.EmailNotification;
import com.argusoft.generic.database.common.impl.BaseAbstractGenericDao;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * This class is used to perform CRUD operation on EmailNotification.
 *
 * @author niharika
 */
@Repository
public class EmailNotificationDaoImpl extends BaseAbstractGenericDao<EmailNotification, Long> implements EmailNotificationDao {

    /**
     * Long user
     * 
     */
    public static final String USER_ID = "user";
    
        @Override
        public EmailNotification retrieveEmailNotificationByUserId(Long Id) {
         List<Criterion> criterions = new LinkedList<Criterion>();
        if (Id != null) {
            criterions.add(Restrictions.eq(USER_ID, Id));
        }
        EmailNotification emailNotification = super.findEntityByCriteriaList(criterions);

        return emailNotification;
    }
    
    
}
