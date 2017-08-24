/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.core;

import com.argusoft.armms.core.impl.TaskServiceImpl;
import com.argusoft.armms.model.Project;
import com.argusoft.armms.model.TaskAttachment;
import com.argusoft.armms.model.TaskDeclineDetail;
import com.argusoft.armms.model.TaskMaster;
import com.argusoft.armms.model.TaskTechnologyDetail;
import com.argusoft.armms.model.TaskTrack;
import com.argusoft.armms.model.TechnologyMaster;
import com.argusoft.armms.model.TaskTechnologyDetailPK;
import com.argusoft.generic.core.config.CoreApplicationConfig;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class TaskServiceTest {

    @Autowired
    @Qualifier("taskService")
    TaskService taskService;
    @Autowired
    @Qualifier("projectService")
    ProjectService projectService;

    public TaskServiceTest() {
    }
    TaskMaster task = null;
    Project project = null;
    TaskTrack track = null;
    TaskDeclineDetail taskdecline = null;
    TaskAttachment taskAttachment = null;
    TaskTechnologyDetail taskTechnologyDetail = null;
    TechnologyMaster technologyMaster = null;
    TaskTechnologyDetailPK taskTechnologyDetailPK = null;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        task = new TaskMaster();
        task.setTaskId("ARMMS-0");
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
        task.setTaskPriority(1L);
        project = new Project();
        project.setProjectId(1L);
        project.setProjectName("ARMMS");
        project.setProjectAlias("Monitoring Tool");
        project.setProjectDescription("Reseource Manangement");
        project.setProjectPriority("L");
        project.setStartDate(new Date());
        project.setEstimatedEndDate(new Date());
        project.setCreatedOn(new Date());
//        project.setProjectManager(1L);
        project.setIsActive(true);
        project.setIsArchive(false);
        project.setCreatedBy(1L);
        this.taskAttachment = new TaskAttachment();
        taskAttachment.setTaskId("ARMMS-0");
        taskAttachment.setTaskAttachmentName("task attachment");
        taskAttachment.setUploadedBy(1l);
        taskAttachment.setAttachmentPath("home/tat");
        track = new TaskTrack();
        track.setTaskTrackId(0l);
        taskdecline = new TaskDeclineDetail();
        taskdecline.setTaskDeclineDetailId(0l);
        technologyMaster = new TechnologyMaster();
        technologyMaster.setTechnologyId(0L);
        technologyMaster.setTechnologyName("technology-0");
        technologyMaster.setTechnologyDesc("technology for testing");
        technologyMaster.setTechType("T");
        technologyMaster.setCreatedBy(1L);
        technologyMaster.setCreatedOn(new Date());
        technologyMaster.setIsActive(Boolean.TRUE);
        technologyMaster.setIsArchive(Boolean.FALSE);
        technologyMaster.setLastModifiedBy(1L);
        technologyMaster.setLastModifiedOn(new Date());
        taskTechnologyDetailPK = new TaskTechnologyDetailPK();
        taskTechnologyDetailPK.setTask_mstr(task);
        taskTechnologyDetailPK.setTech_mst(technologyMaster);
        taskTechnologyDetail = new TaskTechnologyDetail();
        taskTechnologyDetail.setTaskTechnologyDetailPK(taskTechnologyDetailPK);
        taskTechnologyDetail.setCreatedBy(1L);
        taskTechnologyDetail.setCreatedOn(new Date());
        taskTechnologyDetail.setIsActive(Boolean.TRUE);
        taskTechnologyDetail.setLastModifiedBy(1L);
        taskTechnologyDetail.setLstModifiedOn(new Date());

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testRetrieveTasksForSpecificDaysById() {
        System.out.println("retrieveTasksForSpecificDaysById");
        Date currdate = new Date();
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -(5));
        Date xDaysAgo = cal.getTime();
        Long projectId = 1l;
        Long userId = 1l;
        List<Project> projectdetail = projectService.retrieveActiveOrInactiveProjects(true);
        List<Long> projectIds = new ArrayList<Long>();
        for (Project project : projectdetail) {
            projectIds.add(project.getProjectId());
        }
        List<TaskMaster> expResult = null;
        List<TaskMaster> result = taskService.retrieveTasksForSpecificDaysById(currdate, xDaysAgo, projectId, userId,projectIds);
    }

    @Test
    public void testRetrieveTaskByProjectId() {
        System.out.println("retrieveTaskByProjectId");
        Long projectId = 1l;
        List<TaskMaster> expResult = null;
        List<TaskMaster> result = taskService.retrieveTaskByProjectId(projectId);
        assertNotNull("+++++++test retrieve tasks of projectId++++++", result.size());

    }

    @Test
    public void testRetrieveAllTasksForSpecificDays() {
        System.out.println("retrieveAllTasksForSpecificDays");
        Date currdate = new Date();
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -(5));
        Date xDaysAgo = cal.getTime();
        Long userId = 1l;
        List<Project> projectdetail = projectService.retrieveActiveOrInactiveProjects(true);
        List<Long> projectIds = new ArrayList<Long>();
        for (Project project : projectdetail) {
            projectIds.add(project.getProjectId());
        }
        List<TaskMaster> expResult = null;
        List<TaskMaster> result = taskService.retrieveAllTasksForSpecificDays(currdate, xDaysAgo,projectIds,userId);
    }

    @Test
    public void testAddTask() {
        Long result = projectService.createProject(project);
        Project projectdetail = projectService.retrieveProjectById(result);
        task.setProjectId(projectdetail);
        String result1 = taskService.addTask(task);
        assertNotNull("Error in adding task in addTask  method of TaskServiceTest", result1);

    }

    @Test
    public void testAddTaskTrack() {
        testAddTask();
        TaskMaster taskdetail = taskService.retrieveTaskByTaskId("ARMMS-0");
        track.setTaskId(taskdetail.getTaskId());
        Long result1 = taskService.addTaskTrack(track);
        assertNotNull("Error in adding tasktrack in addTaskTrack  method of TaskServiceTest", result1);

    }

    @Test
    public void testAddTaskDeclineDetail() {
        testAddTask();
        TaskMaster taskdetail = taskService.retrieveTaskByTaskId("ARMMS-0");
        taskdecline.setTaskId(taskdetail);
        taskdecline.setDeclineReason("I am ill");
        taskdecline.setIsActive(Boolean.TRUE);
        Long result2 = taskService.addTaskDeclineDetail(taskdecline);
        assertNotNull("Error in adding taskdecline in addTaskDeclineDetail  method of TaskServiceTest", result2);

    }

    @Test
    public void retrieveTaskTrackById() {
        testAddTask();
        TaskMaster taskdetail = taskService.retrieveTaskByTaskId("ARMMS-0");

        track.setTaskId(taskdetail.getTaskId());
        Long result1 = taskService.addTaskTrack(track);

        TaskTrack tasktrackListById = taskService.retrieveTaskTrackById(result1);
        assertNotNull("Error in getting task list by Id of taskServiceTest", tasktrackListById);

    }

    @Test
    public void testretrieveAllTaskTrack() {
        testAddTask();
        TaskMaster taskdetail = taskService.retrieveTaskByTaskId("ARMMS-0");
        track.setTaskId(taskdetail.getTaskId());
        Long result1 = taskService.addTaskTrack(track);

        List<TaskTrack> trackList = taskService.retrieveAllTaskTrack();
        assertNotNull("Error in getting projectList of ProjectServiceTest", trackList);

    }

    @Test
    public void testUpdateTaskTrack() {
        Long result = taskService.addTaskTrack(track);
        TaskTrack tasktrack = taskService.retrieveTaskTrackById(result);
        tasktrack.setTaskId("009");

        if (tasktrack.getTaskId() != null) {
            taskService.updateTaskTrack(tasktrack);
        }
        TaskTrack track1 = taskService.retrieveTaskTrackById(result);

        System.out.println("Update");

    }

    @Test
    public void retrieveTaskByUserIdAndProjectId() {
        Long results = projectService.createProject(project);
        Project project = projectService.retrieveProjectById(results);
        task.setProjectId(project);
        String result = taskService.addTask(task);
        Long result1 = projectService.createProject(project);
        Project projectdetail = projectService.retrieveProjectById(result1);
        assertNotNull("Error in creating task in task service test", result);
        List<TaskMaster> taskListById = taskService.retrieveTaskByUserIdAndProjectId(projectdetail.getProjectId(), -1L);
        assertNotNull("Error in getting task list by userId & projetc Idof taskServiceTest", taskListById);
    }

    @Test
    public void testRetrieveTaskByUserId() {
        Long results = projectService.createProject(project);
        Project projectdetail = projectService.retrieveProjectById(results);
        task.setProjectId(projectdetail);
        String result = taskService.addTask(task);
        assertNotNull("Error in creating task in task service test", result);
        List<TaskMaster> taskListById = taskService.retrieveTaskByUserId(-1L);
        assertNotNull("Error in getting task list by userId of taskServiceTest", taskListById);
    }

    @Test
    public void testUpdateTask() {
        taskService.addTask(task);
        TaskMaster taskMaster = taskService.retrieveTaskByTaskId(task.getTaskId());
        taskMaster.setTaskName("updated task");
        taskService.updateTask(taskMaster);
        System.out.println("++++++++++++updated task information++++++++++++");

    }

    @Test
    public void testRetrieveAllTaskOfProject() {
        Long projectId = 1l;

        List<TaskMaster> allTaskOfProject = taskService.retrieveAllTaskOfProject(projectId);

        for (TaskMaster taskMaster : allTaskOfProject) {
        }

    }

    @Test
    public void testAddTaskAttachment() {
        taskService.addTaskAttachment(taskAttachment);
        System.out.println("+++++task Attachment added+++++++++");
    }

    @Test
    public void testDeleteTaskAttachment() {
        taskService.addTaskAttachment(taskAttachment);
        List<TaskAttachment> attachment = taskService.retrieveTaskAttachmentsByTaskId(task.getTaskId());
        assertNotNull("+++++++++++list of task attachment of task++++++", attachment.size());
        taskService.deleteTaskAttachment(attachment.get(0).getTaskAttachmentId());
    }

    @Test
    public void testAddTaskTechnology() {
        taskService.addTaskTechnology(taskTechnologyDetail);
        System.out.println("\n+++++++++task technology added ++++++++++\n");
    }

    @Test
    public void testDeleteTaskTechnology() {
        taskService.deleteTaskTechnology(taskTechnologyDetailPK);
        System.out.println("++++++++++task technology deleted+++++++++++");
    }

    @Test
    public void testRetrieveTaskByProjectIdAndUserIdAndDates() {
        System.out.println("retrieveTaskByProjectIdAndUserIdAndDates");
        Long userId = 1l;
        List<Long> projectIds = new ArrayList<Long>();
        projectIds.add(1l);
        Date startDate = new Date();
        Date endDate = new Date();
        List<TaskMaster> expResult = null;
        List<TaskMaster> result = taskService.retrieveTaskByProjectIdAndUserIdAndDates(userId, projectIds, startDate, endDate);
    }

    @Test
    public void testRetrieveTaskByTaskId() {
        testAddTask();
        System.out.println("retrieveTaskByTaskId");
        String Id = "ARMMS-0";

        TaskMaster result = taskService.retrieveTaskByTaskId(Id);
        List<TaskAttachment> resultAttach = taskService.retrieveTaskAttachmentsByTaskId(Id);
        for (TaskAttachment taskAttachment : resultAttach) {
            System.out.println(taskAttachment.getTaskAttachmentId() + "::" + taskAttachment.getTaskAttachmentName());
        }
    }

    @Test
    public void testretrieveTasksForIntervalById() {
        testAddTask();
        System.out.println("retrieveTasksForIntervalById");

        long userId = 1l;

        Calendar endTime = Calendar.getInstance();
        endTime.set(Calendar.DATE, 21);
        Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.DATE, 16);

        assertNotNull("start::", startTime.getTime());
        assertNotNull("end::", endTime.getTime());

        List<TaskMaster> result = taskService.retrieveTasksForIntervalById(userId, startTime, endTime);

        for (TaskMaster taskMaster : result) {
            System.out.println(taskMaster.getTaskId() + "::" + taskMaster.getTaskName());
        }
    }

    @Test
    public void testretrieveTaskAttachmentsByTaskId() {
        testAddTask();
        System.out.println("retrieveTaskAttachmentsByTaskId");
        List<TaskAttachment> resultAttach = taskService.retrieveTaskAttachmentsByTaskId("ARMMS-0");
        for (TaskAttachment taskAttachment : resultAttach) {
            System.out.println(taskAttachment.getTaskAttachmentId() + "::" + taskAttachment.getTaskAttachmentName());
        }

    }

    @Test
    public void testRetrieveLastTaskIdOfPoject() {
        System.out.println("+++++++++testRetrieveLastTaskIdOfPoject++++++++++++++++++++++++++");
        List<TaskMaster> taskMastersList = taskService.retrieveAllActiveTask();
        if (taskMastersList != null && !taskMastersList.isEmpty()) {
            Long projectId = taskMastersList.get(0).getProjectId().getProjectId();
            String result = taskService.retrieveLastTaskIdOfProject(projectId);
            assertNotNull("+++++++test retrieve Last taskId of project++++++", result);
        }
    }

    int getNoOfDaysForCurrentMonth() {
        int actualDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int noOfDays = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
        Calendar.getInstance().set(Calendar.DAY_OF_MONTH, actualDay);
        return noOfDays;
    }

    @Test
    public void testRetrieveTasksOfPojectOfCurrentMonth() {
        System.out.println("+++++++++testRetrieveTasksOfPojectOfCurrentMonth++++++++++++++++++++++++++");
        Long projectId = 1l;
        int currMonth = Calendar.getInstance().get(Calendar.MONTH);
        int currYear = Calendar.getInstance().get(Calendar.YEAR);
        int noOfDaysCurrentMonth = this.getNoOfDaysForCurrentMonth();

        Calendar startDate = Calendar.getInstance();
        startDate.set(currYear, currMonth, 1, 0, 0, 0);
        Calendar endDate = Calendar.getInstance();
        endDate.set(currYear, currMonth, noOfDaysCurrentMonth, 23, 59, 59);

        List<TaskMaster> result = taskService.retrieveTasksOfProjectForCurrentMonth(projectId, startDate, endDate);

        assertNotNull("+++++++test retrieve Last taskId of project++++++", result.size());

    }

}
