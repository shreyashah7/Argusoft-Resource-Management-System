/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.core.impl;

import com.argusoft.armms.core.EmailNotificationService;
import com.argusoft.armms.database.EmailNotificationDao;
import com.argusoft.armms.model.EmailNotification;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * methods for performing crud operations on email notification
 *
 * @author shreya
 */
@Service("emailNotificationService")
@Transactional
public class EmailNotificationServiceImpl implements EmailNotificationService {

    @Autowired
    private EmailNotificationDao emailNotificationDao;

    @Override
    public Long createEmailNotification(EmailNotification emailNotification) {
        Long create = this.emailNotificationDao.create(emailNotification);
        return create;
    }

    @Override
    public void updateEmailNotification(EmailNotification emailNotification) {
        this.emailNotificationDao.createOrUpdate(emailNotification);
    }

    @Override
    public EmailNotification retrieveEmailNotificationByUserId(Long Id) {
        return this.emailNotificationDao.retrieveEmailNotificationByUserId(Id);
    }

}
