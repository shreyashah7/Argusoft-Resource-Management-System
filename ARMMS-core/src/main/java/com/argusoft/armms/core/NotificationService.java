/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.argusoft.armms.core;

import com.argusoft.armms.model.SystemNotificationMaster;
import java.util.Date;
import java.util.List;

/**
 * for notification in the system
 * @author shreya
 */
public interface NotificationService {
    
    /**
     * createNotification method creates an Object of Class Notification, by calling saveEntity method of its parent.
     * @param systemNotificationMaster Takes an Object of Class SystemNotificationMaster, which is to be created.
     * @return Returns the Long Object, which is PK of SystemNotificationMaster Class.
     */
    public Long createNotification(SystemNotificationMaster systemNotificationMaster);
    
    /**
     * updateNotification method updates an Object of Class SystemNotificationMaster, by calling updateEntity method of its parent.
     * @param SystemNotificationMaster Takes an Object of Class SystemNotificationMaster, which is to be updated.
     */
    public void updateNotification(SystemNotificationMaster SystemNotificationMaster);
    
    /**
     * deleteNotification method creates an Object of Class SystemNotificationMaster, by calling deleteEntity method of its parent.
     * @param SystemNotificationMaster Takes an Object of Class SystemNotificationMaster, which is to be deleted.
     */
    public void deleteNotification(SystemNotificationMaster SystemNotificationMaster);
    
    /**
     * retrieveAllNotifications method retrieves all SystemNotificationMaster Objects, by calling findAll method of its parent class.
     * @param isActive
     * @return Returns the List of Object of Class SystemNotificationMaster.
     */
    public List<SystemNotificationMaster> retrieveAllNotifications(Boolean isActive);
    
    /**
     * retrieveNotificationById method retrieves the SystemNotificationMaster Object, by calling getEntityById method of its parent.
     * @param NotificationId Takes PK of the SystemNotificationMaster.
     * @return Returns the Object of SystemNotificationMaster.
     */
    public SystemNotificationMaster retrieveNotificationById(Long NotificationId);
    /**
     * retrieveAllNotificationsByUserId method retrieves the SystemNotificationMaster Object, by calling retrieveAllNotificationsByUserId method of its serviceImpl.
     * @param assignedId Takes notification assignedTo id of the SystemNotificationMaster.
     * @param onDate Takes notification_on_date of the SystemNotificationMaster
     * @param featureId takes feature_id of SystemNotificationMaster
     * @param featureType takes feature_name of SystemNotificationMaster
     * @return Returns the List of Object of Class SystemNotificationMaster.
     */
    public List<SystemNotificationMaster> retrieveAllNotificationsByUserId(Long assignedId,Date onDate,String featureId,String featureType);
    
    
    
}
