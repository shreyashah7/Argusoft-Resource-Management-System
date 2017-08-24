/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.database;

import com.argusoft.armms.model.EmailNotification;
import com.argusoft.generic.database.common.GenericDao;

/**
 * This class is used to perform CRUD operation on EmailNotification.
 *
 * @author niharika
 */
public interface EmailNotificationDao extends GenericDao<EmailNotification, Long> {

    /**
     * retrieveEmailNotificationByUserId method retrieves an Object of Class
     * EmailNotification by its userId
     *
     * @param Id Takes the id of user whose EmailNotification is required.
     * @return Returns object of EmailNotification.
     */
    public EmailNotification retrieveEmailNotificationByUserId(Long Id);

}
