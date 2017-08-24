/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.core;

import com.argusoft.armms.model.SystemNotificationMaster;
import com.argusoft.generic.core.config.CoreApplicationConfig;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author shreya
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {CoreApplicationConfig.class})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class NotificationServiceTest {

    @Autowired
    NotificationService notificationService;
    SystemNotificationMaster notification;

    public NotificationServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of createNotification method, of class NotificationService.
     */
    @Before
    public void setUp() {
        notification = new SystemNotificationMaster();
        notification.setAssignedTo(1l);
        notification.setCreatedOn(new Date());
        notification.setExpiryDate(new Date());
        notification.setFeatureId("1");
        notification.setFeatureType("Task");
        notification.setIsActive(true);
        notification.setIsArchive(false);
        notification.setLastModifiedOn(new Date());
        notification.setNotificationOnDate(new Date());
        notification.setNotificationSubject("task1 is ending today");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testcreateNotification() {
        Long id = notificationService.createNotification(notification);
        assertNotNull("Not created", id);
    }

    /**
     * Test of updateNotification method, of class NotificationService.
     */
    @Test
    public void testUpdateNotification() {
        Long id = notificationService.createNotification(notification);
        SystemNotificationMaster systemNotificationMaster = notificationService.retrieveNotificationById(id);
        systemNotificationMaster.setNotificationId(1l);
        systemNotificationMaster.setIsActive(false);
        systemNotificationMaster.setCreatedOn(new Date());
        systemNotificationMaster.setAssignedTo(1l);
        systemNotificationMaster.setFeatureId("1");
        systemNotificationMaster.setFeatureType("Task");
        notificationService.updateNotification(systemNotificationMaster);
    }

    /**
     * Test of deleteNotification method, of class NotificationService.
     */
    @Test
    public void testDeleteNotification() {
        System.out.println("deleteNotification");
        SystemNotificationMaster SystemNotificationMaster = new SystemNotificationMaster();
        notificationService.deleteNotification(SystemNotificationMaster);
    }

    /**
     * Test of retrieveAllNotifications method, of class NotificationService.
     */
    @Test
    public void testRetrieveAllNotifications() {
        System.out.println("retrieveAllNotifications");
        Boolean isActive = true;
        List<SystemNotificationMaster> expResult = null;
        List<SystemNotificationMaster> result = notificationService.retrieveAllNotifications(isActive);
    }

    /**
     * Test of retrieveNotificationById method, of class NotificationService.
     */
    @Test
    public void testRetrieveNotificationById() {
        System.out.println("retrieveNotificationById");
        Long NotificationId = 1l;
        SystemNotificationMaster expResult = null;
        SystemNotificationMaster result = notificationService.retrieveNotificationById(NotificationId);
    }

    /**
     * Test of retrieveAllNotificationsByUserId method, of class
     * NotificationService.
     */
    @Test
    public void testRetrieveAllNotificationsByUserId() {
        System.out.println("retrieveAllNotificationsByUserId");
        Long assignedId = 1l;
        Date onDate = new Date();
        String featureId = "1";
        String featureType = "Task";
        List<SystemNotificationMaster> expResult = null;
        List<SystemNotificationMaster> result = notificationService.retrieveAllNotificationsByUserId(assignedId, onDate, featureId, featureType);
    }

}
