/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.database.impl;

import com.argusoft.armms.database.NotificationDao;
import com.argusoft.armms.model.SystemNotificationMaster;
import com.argusoft.generic.database.common.impl.BaseAbstractGenericDao;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.persistence.internal.oxm.schema.model.Restriction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author shreya
 */
@Repository
public class NotificationDaoImpl extends BaseAbstractGenericDao<SystemNotificationMaster, Long> implements NotificationDao {

    private static final String IS_ACTIVE = "isActive";
    private static final String IS_ARCHIVE = "isArchive";
    private static final String NOTIFICATION_ON_DATE = "notificationOnDate";
    private static final String EXPIRY_DATE = "expiryDate";
    private static final String FEATURE_ID = "featureId";
    private static final String FEATURE_TYPE = "featureType";
    private static final String CREATED_ON = "createdOn";
    private static final String LAST_MODIFIED_ON = "lastModifiedOn";
     private static final String ASSIGNED_TO ="assignedTo";

    @Override
    public List<SystemNotificationMaster> retrieveAllNotifications(Boolean isActive) {
        List<SystemNotificationMaster> notificationList = null;
        List<Criterion> criterions = new LinkedList<Criterion>();
        if (isActive != null) {
            criterions.add(Restrictions.eq(IS_ACTIVE, Boolean.TRUE));
        }
        criterions.add(Restrictions.eq(IS_ARCHIVE, Boolean.FALSE));
        notificationList = super.findByCriteriaList(criterions);
        return notificationList;
    }

    @Override
    public List<SystemNotificationMaster> retrieveAllNotificationsByUserId(Long assignedId, Date onDate, String featureId, String featureType) {
        List<SystemNotificationMaster> notificationList = null;
        List<Criterion> criterions = new LinkedList<Criterion>();
        criterions.add(Restrictions.eq(IS_ACTIVE, Boolean.TRUE));
        if (assignedId != null) {
            criterions.add(Restrictions.eq(ASSIGNED_TO, assignedId));
        }
        if (onDate != null) {
            criterions.add(Restrictions.conjunction()
                    .add(Restrictions.le(NOTIFICATION_ON_DATE, onDate))
                    .add(Restrictions.disjunction()
                            .add(Restrictions.ge(EXPIRY_DATE, onDate))
                            .add(Restrictions.eq(EXPIRY_DATE, null))));
        }
        if (featureId != null) {
            criterions.add(Restrictions.eq(FEATURE_ID, featureId));
        }
        if (featureType != null) {
            criterions.add(Restrictions.eq(FEATURE_TYPE, featureType));
        }
        criterions.add(Restrictions.eq(IS_ARCHIVE, Boolean.FALSE));
        notificationList = super.findByCriteriaList(criterions);
        return notificationList;
    }

}
