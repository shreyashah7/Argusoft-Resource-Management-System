/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.core;

import com.argusoft.armms.model.EmailNotification;
import com.argusoft.generic.core.config.CoreApplicationConfig;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author niharika
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {CoreApplicationConfig.class})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class EmailNotificationServiceTest {

    @Autowired
    EmailNotificationService emailNotificationService;
    EmailNotification emailNotification;
    public EmailNotificationServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createEmailNotification method, of class
     * EmailNotificationService.
     */
    @Test
    public void testCreateEmailNotification() {
        System.out.println("createEmailNotification");
        Long emailNotifid = 1L;
        emailNotification = new EmailNotification();
        emailNotification.setAssignedTaskUpdateMail(true);

        emailNotification.setLastModifiedBy((long) 2);
        emailNotification.setLastModifiedOn(new Date());
        emailNotification.setProjectAssignedMail(true);
        emailNotification.setTaskAllocationMail(true);
        emailNotification.setTaskDeadlineWarningMail(true);
        emailNotification.setTaskEndRemainderMail(true);
        emailNotification.setUser((long) emailNotifid);

        emailNotificationService.createEmailNotification(emailNotification);

    }

     /**
     * Test of updateEmailNotification method, of class
     * EmailNotificationService.
     */
    @Test
    public void testUpdateEmailNotification() {
        System.out.println("updateEmailNotification");
        Long emailNotifid = 1L;
        emailNotification = new EmailNotification();
        emailNotification.setAssignedTaskUpdateMail(false);

        emailNotification.setLastModifiedBy((long) 2);
        emailNotification.setLastModifiedOn(new Date());
        emailNotification.setProjectAssignedMail(true);
        emailNotification.setTaskAllocationMail(false);
        emailNotification.setTaskDeadlineWarningMail(true);
        emailNotification.setTaskEndRemainderMail(false);
        emailNotification.setUser((long) emailNotifid);

        emailNotificationService.updateEmailNotification(emailNotification);

    }
    /**
     * Test of retrieveEmailNotificationByUserId method, of class
     * EmailNotificationService.
     */
    @Test
    public void testRetrieveEmailNotificationByUserId() {
        System.out.println("RetrieveEmailNotificationByUserId");
        Long userid = 1L;
        EmailNotification emailNotifications = emailNotificationService.retrieveEmailNotificationByUserId(userid);

    }

}
