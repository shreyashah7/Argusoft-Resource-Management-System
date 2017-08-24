/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.argusoft.armms.core;

import com.argusoft.armms.model.EmailNotification;
import java.util.List;
import org.eclipse.persistence.annotations.ReturnInsert;

/**
 * methods for email Notification onto database
 * @author shreya
 */
public interface EmailNotificationService {
    
    /**
     * createEmailNotification method creates an Object of Class
     * EmailNotification, by calling saveEntity method of its parent.
     *
     * @param emailNotification Takes an Object of Class EmailNotification, which is
     * to be created.
     * @return Returns the Long Object, which is PK of EmailNotification Class.
     */
    public Long createEmailNotification(EmailNotification emailNotification);
    
    /**
     * updateEmailNotification method creates an Object of Class
     * EmailNotification, by calling saveEntity method of its parent.
     *
     * @param emailNotification Takes an Object of Class EmailNotification, which is
     * to be created.
     */
    public void updateEmailNotification(EmailNotification emailNotification);
    /**
     * @author niharika
     * retrieveEmailNotificationByUserId method retrieves an Object of Class
     * EmailNotification by its userId
     *
     * @param Id Takes the id of user whose EmailNotification is required.
     * @return Returns object of EmailNotification.
     */
    public EmailNotification retrieveEmailNotificationByUserId(Long Id);
    
    
    
}
