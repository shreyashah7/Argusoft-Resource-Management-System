/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.argusoft.armms.database;

import com.argusoft.armms.model.SystemNotificationMaster;
import com.argusoft.generic.database.common.GenericDao;
import java.util.Date;
import java.util.List;

/**
 * methods for notification crud operation in database
 * @author shreya
 */

public interface NotificationDao extends GenericDao<SystemNotificationMaster, Long>{

   /**
     * retrieveAllNotifications method retrieves all SystemNotificationMaster Objects, by calling findAll method of its parent class.
     * @param isActive
     * @return Returns the List of Object of Class SystemNotificationMaster.
     */
    public List<SystemNotificationMaster> retrieveAllNotifications(Boolean isActive);
    
    /**
     * retrieveAllNotificationsByUserId method retrieves the SystemNotificationMaster Object, by calling retrieveAllNotificationsByUserId method of its serviceImpl.
     * @param assignedId Takes notification assignedTo id of the SystemNotificationMaster.
     * @param onDate Takes notification_on_date of the SystemNotificationMaster
     * @param featureId takes feature_id of SystemNotificationMaster
     * @param featureType takes feature_name of SystemNotificationMaster
     * @return Returns the List of Object of Class SystemNotificationMaster.
     */
    public List<SystemNotificationMaster> retrieveAllNotificationsByUserId(Long assignedId, Date onDate, String featureId, String featureType);
    
   
}
