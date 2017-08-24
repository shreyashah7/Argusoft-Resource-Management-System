/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.core;

import com.argusoft.armms.model.Project;
import com.argusoft.armms.model.SvnDetail;
import com.argusoft.armms.model.SvnFileDetails;
import com.argusoft.armms.model.TaskAttachment;
import com.argusoft.armms.model.TaskMaster;
import com.argusoft.generic.core.config.CoreApplicationConfig;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
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
 * @author ravi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {CoreApplicationConfig.class})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class SvnServiceTest {

    @Autowired
    SvnService svnService;
    @Autowired
    ProjectService projectService;

    @Autowired
    TaskService taskService;

    TaskMaster task = null;
    Project project = null;
    TaskAttachment taskAttachment = null;
    SvnDetail svnDetail = null;
    List<SvnFileDetails> svnFileDetails = null;

    public SvnServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        project = new Project();
        project.setProjectId(0L);
        project.setProjectName("ARMMS");
        project.setProjectAlias("ARMMS");
        project.setProjectDescription("Reseource ManangementTool");
        project.setProjectPriority("L");
        project.setStartDate(new Date());
        project.setEstimatedEndDate(new Date());
        project.setCreatedOn(new Date());
//        project.setProjectManager(1L);
        project.setIsActive(true);
        project.setIsArchive(false);
        project.setCreatedBy(1L);
        project.setSvnUrl("https://192.1.200.12/repos/ARMMS/");

        task = new TaskMaster();
        task.setTaskId("ARMMS-0");
        // task.setProjectId(task.getProjectId());
        task.setAssignedTo(1L);
        task.setCreatedBy(1L);
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.set(Calendar.DATE, 21);
        task.setEndDate(calendar.getTime());
        Calendar calendar1 = Calendar.getInstance();
        Date newDate = calendar1.getTime();
        calendar1.set(Calendar.DATE, 18);
        task.setStartDate(calendar1.getTime());
        task.setParentTaskId(task);
        task.setIsActive(Boolean.TRUE);
        task.setTaskName("Project Master");
        task.setTaskDescription("CRUD operation screens for Project module.");

        Long result = projectService.createProject(project);
        Project projectdetail = projectService.retrieveProjectById(result);
        task.setProjectId(projectdetail);

        String resultTask = taskService.addTask(task);

        svnDetail = new SvnDetail();
        svnDetail.setTaskId("ARMMS-0");
        svnDetail.setRevisionNo(0l);
        svnDetail.setCommiter("ravi");
        svnDetail.setComment("testing message");
        svnDetail.setCommitedOn(new Date());
        svnFileDetails = new ArrayList<SvnFileDetails>();
        for (int cnt = 1; cnt < 3; cnt++) {
            SvnFileDetails svnFileDetail = new SvnFileDetails();
            svnFileDetail.setFilePath("a/b/c.java");
            svnFileDetail.setChangeType("Folder");
            svnFileDetail.setPathType("File");
            svnFileDetails.add(svnFileDetail);
        }
        svnDetail.setSvnFileDetails(svnFileDetails);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addSvnData method, of class SvnService.
     */
    @Test
    public void testAddSvnData() {
//        System.out.println("addSvnData");

        List<SvnDetail> svnDetaillist = new ArrayList<SvnDetail>();

        svnDetaillist.add(svnDetail);

        svnService.addSvnData(svnDetaillist);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveLastupdatedRevisionNumber method, of class SvnService.
     */
    @Test
    public void testRetrieveLastupdatedRevisionNumber() {
        testAddSvnData();
        System.out.println("retrieveLastupdatedRevisionNumber");
        Long result = svnService.retrieveLastupdatedRevisionNumber(1l);
        System.out.println("latest updated revision number of project ::" + result);

    }

    /**
     * Test of retrieveListByProjectId method, of class SvnService.
     */
    @Test
    public void testRetrieveListByProjectId() {
        testAddSvnData();
        System.out.println("retrieveListByProjectId");
        List<SvnDetail> result = svnService.retrieveListByProjectId(0l, true);
        for (SvnDetail svnDetaildata : result) {
            System.out.println("svn detail:::" + svnDetaildata);
        }
    }

    /**
     * Test of retrieveListById method, of class SvnService.
     */
    @Test
    public void testRetrieveListById() {
        testAddSvnData();
        List<SvnDetail> result = svnService.retrieveListByTaskId("ARMMS-0", false);
        Long id = null;
        for (SvnDetail svnDetaildata : result) {
            System.out.println("svn detail:::" + svnDetaildata);
            System.out.println("svnDetaildata id::" + svnDetaildata.getId());
            id = svnDetaildata.getId();
        }
        System.out.println("retrieveListById");

        List<SvnDetail> listById = svnService.retrieveListById(id, true);
        for (SvnDetail svnDetaildata : listById) {
            System.out.println("svn detail:::" + svnDetaildata);
            System.out.println("svnDetaildata id::" + svnDetaildata.getId());
            List<SvnFileDetails> svnFileDetails1 = svnDetaildata.getSvnFileDetails();
            for (SvnFileDetails svnFileDetails : svnFileDetails1) {
                System.out.println("svnFileDetails::"+svnFileDetails);
            }
        }

    }

    /**
     * Test of retrieveListByTaskId method, of class SvnService.
     */
    @Test
    public void testRetrieveListByTaskId() {
        testAddSvnData();
        System.out.println("retrieveListByTaskId");
        String taskId = "";
        boolean flag = true;
        List<SvnDetail> result = svnService.retrieveListByTaskId("ARMMS-0", flag);
        for (SvnDetail svnDetaildata : result) {
            System.out.println("svn detail:::" + svnDetaildata);
        }
    }

}
