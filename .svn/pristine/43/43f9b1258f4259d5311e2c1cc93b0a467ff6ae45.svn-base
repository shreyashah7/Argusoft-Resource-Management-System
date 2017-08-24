/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.argusoft.armms.core.impl;

import com.argusoft.armms.core.NotificationService;
import com.argusoft.armms.database.NotificationDao;
import com.argusoft.armms.model.SystemNotificationMaster;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * methods for performing crud operation on notification of the system
 * @author shreya
 * @since 04-APRIL-2014
 */
@Service("notificationService")
@Transactional
public class NotificationServiceImpl implements NotificationService{
    
    @Autowired
    private NotificationDao notificationDao;

    @Override
    public Long createNotification(SystemNotificationMaster systemNotificationMaster) {
        Long NotificationId = null;
        if (systemNotificationMaster != null) {
            systemNotificationMaster.setIsArchive(Boolean.FALSE);
            systemNotificationMaster.setCreatedOn(Calendar.getInstance().getTime());
            NotificationId = notificationDao.create(systemNotificationMaster);
        }
        return NotificationId;
    }

    @Override
    public void updateNotification(SystemNotificationMaster systemNotificationMaster) {
        if(systemNotificationMaster !=  null) {
            notificationDao.update(systemNotificationMaster);
        }
    }

    @Override
    public void deleteNotification(SystemNotificationMaster systemNotificationMaster) {
        if(systemNotificationMaster != null) {
            notificationDao.delete(systemNotificationMaster);
        }
    }

    @Override
    public List<SystemNotificationMaster> retrieveAllNotifications(Boolean isActive) {
        return notificationDao.retrieveAllNotifications(isActive);
    }

    @Override
    public SystemNotificationMaster retrieveNotificationById(Long NotificationId) {
        return  notificationDao.retrieveById(NotificationId);
    }

    @Override
    public List<SystemNotificationMaster> retrieveAllNotificationsByUserId(Long assignedId, Date onDate, String featureId, String featureType) {
        return notificationDao.retrieveAllNotificationsByUserId(assignedId, onDate, featureId, featureType);
    }
    
}
