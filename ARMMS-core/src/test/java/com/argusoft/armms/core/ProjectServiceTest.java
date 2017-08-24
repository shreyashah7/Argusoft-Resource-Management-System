/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.core;

import com.argusoft.armms.model.Project;
import com.argusoft.armms.model.ProjectAttachment;
import com.argusoft.armms.model.ProjectMilestone;
import com.argusoft.armms.model.ProjectResourceDetail;
import com.argusoft.armms.model.ProjectRoles;
import com.argusoft.armms.model.ProjectTechnologyDetail;
//import com.argusoft.armms.model.UserProjectRoleDetail;
import com.argusoft.generic.core.config.CoreApplicationConfig;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
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
 * @author shreya
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {CoreApplicationConfig.class})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class ProjectServiceTest {

    @Autowired
    TaskService taskService;
    @Autowired
    ProjectService projectService;

    public ProjectServiceTest() {
    }
    Project project = null;

    ProjectMilestone milestone = null;
//    UserProjectRoleDetail userProjectRoleDetail = null;
//    List<UserProjectRoleDetail> userProjectRoleDetailsList = null;
    ProjectRoles projectRoles = null;
    ProjectAttachment projectAttachment = null;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        System.out.println("Inside setup method of testcase");

        project = new Project();
        project.setProjectId(0L);
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

        milestone = new ProjectMilestone();
        milestone.setMilestoneDescription("HKG desc");
        milestone.setMilestoneName("HKG-Analysis");
        milestone.setActualEndDate(new Date());
        milestone.setCreatedBy(1L);
        milestone.setCreatedOn(new Date());
        milestone.setEndDate(new Date());
        milestone.setIsActive(Boolean.TRUE);
        milestone.setIsArchive(Boolean.FALSE);
        milestone.setLastModifiedBy(1L);
        milestone.setStartDate(new Date());

//        userProjectRoleDetail = new UserProjectRoleDetail();
//        userProjectRoleDetail.setUserProjectRoleId(0L);
//        userProjectRoleDetail.setProjectRoleId(1L);
//        userProjectRoleDetail.setLastModifiedBy(1L);
//        userProjectRoleDetail.setCreatedBy(1L);
//        userProjectRoleDetail.setAssignedTo(1L);
//        userProjectRoleDetailsList = new ArrayList<UserProjectRoleDetail>();
//        userProjectRoleDetailsList.add(userProjectRoleDetail);
//
//        assertNotNull("++++++user size list++++", userProjectRoleDetailsList);

        projectRoles = new ProjectRoles();
        projectRoles.setProjectRoleName("Developer");
        projectRoles.setProjectRoleDescription("implementation section");
        projectRoles.setCreatedOn(new Date());
        projectRoles.setCreatedBy(1L);
        projectRoles.setLastModifiedOn(projectRoles.getCreatedOn());
        projectRoles.setLastModifiedBy(1L);
        projectRoles.setIsActive(Boolean.TRUE);
        projectRoles.setIsArchive(Boolean.FALSE);

        System.out.println("\nProject......\n" + projectRoles.toString());

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of retrieveProjectResourceByProjectId method, of class
     * ProjectService.
     */
    @Test
    public void testCreateProject() {

        Long result = projectService.createProject(project);
        System.out.println("\n++++++first test case++++++++\n");
        // TODO review the generated test code and remove the default call to fail.
        assertNotNull("Error in creating project in create Project method of ProjectServiceTest", result);
    }

    @Test
    public void testUpdateProject() {
        System.out.println("\n++++++second test case++++++++\n");
        Long result = projectService.createProject(project);
        assertNotNull("Error in creating Project in create Project method of ProjectServiceTest", result);

        Project projectdetail = projectService.retrieveProjectById(result);
        assertNotNull("Error in getting project by Id in Updateproject method of ProjectServiceTest", projectdetail);

        projectdetail.setProjectAlias("Updating ");
        if (project.getProjectId() != null) {
            projectService.updateProject(projectdetail);
        }
        Project project1 = projectService.retrieveProjectById(result);

        assertEquals("Error in updating user in UpdateUser method of UserServiceTest", project.getProjectAlias(), project1.getProjectAlias());
        System.out.println("Update");
        System.out.println("\n++++++second test case++++++++\n");
    }

    

    @Test
    public void testGetAllProjects() {
        Long result = projectService.createProject(project);
        assertNotNull("Error in creating project in createProject method of ProjectServiceTest", result);
        List<Project> projectList = projectService.getAllProjects();
        assertNotNull("Error in getting projectList of ProjectServiceTest", projectList);

    }

    @Test
    public void testRetrieveProjectById() {
        Long result = projectService.createProject(project);
        assertNotNull("Error in creating project in createProject method of ProjectServiceTest", result);
        Project projectListById = projectService.retrieveProjectById(result);
        assertNotNull("Error in getting project by Id of ProjectServiceTest", projectListById);
    }

//    /**
//     * Test of addMilestoneToProject method, of class ProjectService.
//     */
    @Test
    public void testAddMilestoneToProject() {
        System.out.println("----->addMilestoneToProject");
        Long result = projectService.addMilestoneToProject(milestone);
        assertNotNull("Error in creating milestone in addProjectMilestone method of ProjectServiceTest", result);

    }
//

    /**
     * Test of updateProjectMilestone method, of class ProjectService.
     */
    @Test
    public void testUpdateProjectMilestone() {
        System.out.println("------>updateProjectMilestone");
        Long result = projectService.addMilestoneToProject(milestone);
        assertNotNull("Error in creating milestone in addProjectMilestone method of ProjectServiceTest", result);

        ProjectMilestone tempMilestone = projectService.retrieveProjectMilestoneById(result);
        assertNotNull("Error in getting milestone by Id in Updatemilestone method of ProjectServiceTest", tempMilestone);

        tempMilestone.setMilestoneName("Temp Name");
        if (milestone.getProjectMilestoneId() != null) {
            projectService.updateProjectMilestone(tempMilestone);
        }
        ProjectMilestone tempMilestone1 = projectService.retrieveProjectMilestoneById(result);

        assertEquals("Error in updating user in UpdateUser method of UserServiceTest", tempMilestone.getMilestoneName(), tempMilestone1.getMilestoneName());
    }

    /**
     * Test of retrieveProjectMilestoneById method, of class ProjectService.
     */
    @Test
    public void testRetrieveProjectMilestoneById() {
        System.out.println("------->retrieveProjectMilestoneById");
        Long result = projectService.addMilestoneToProject(milestone);
        assertNotNull("Error in creating milestone in addProjectMilestone method of ProjectServiceTest", result);
        ProjectMilestone tempMilestone = projectService.retrieveProjectMilestoneById(result);
        assertNotNull("Error in getting milestone by Id in Updatemilestone method of ProjectServiceTest", tempMilestone);
    }

    /**
     * Test of retrieveMilestoneForSpecificDaysById method, of class
     * ProjectService.
     */
    @Test
    public void testRetrieveMilestoneForSpecificDaysById() {
        System.out.println("retrieveMilestoneForSpecificDaysById");
        Date currdate = new Date();
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -(5));
        Date xDaysAgo = cal.getTime();
        Long projectId = 1l;
        List<Project> projectdetail = projectService.retrieveActiveOrInactiveProjects(true);
        List<Long> projectIds = new ArrayList<Long>();
        for (Project project : projectdetail) {
            projectIds.add(project.getProjectId());
        }
        List<ProjectMilestone> expResult = null;
        List<ProjectMilestone> result = projectService.retrieveMilestoneForSpecificDaysById(currdate, xDaysAgo, projectId, projectIds);
    }

    /**
     * Test of retrieveProjectForSpecificDaysById method, of class
     * ProjectService.
     */
    @Test
    public void testRetrieveProjectForSpecificDaysById() {
        System.out.println("retrieveProjectForSpecificDaysById");
        Date currdate = new Date();
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -(5));
        Date xDaysAgo = cal.getTime();
        Long projectId = 1l;
        List<Project> projectdetail = projectService.retrieveActiveOrInactiveProjects(true);
        List<Long> projectIds = new ArrayList<Long>();
        for (Project project : projectdetail) {
            projectIds.add(project.getProjectId());
        }
        List<Project> expResult = null;
        List<Project> result = projectService.retrieveProjectForSpecificDaysById(currdate, xDaysAgo, projectIds, projectId);
    }
//    @Test

    public void testAddTechnologyToProject() {
        System.out.println("addTechnologyToProject");
        ProjectTechnologyDetail projectTechnologyDetail;
        projectTechnologyDetail = new ProjectTechnologyDetail(1L);
    }

    /**
     * Test of retrieveAllProjectForSpecificDays method, of class
     * ProjectService.
     */
    @Test
    public void testRetrieveAllProjectForSpecificDays() {
        System.out.println("retrieveAllProjectForSpecificDays");
        Date currdate = new Date();
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -(5));
        Date xDaysAgo = cal.getTime();
        List<Project> projectdetail = projectService.retrieveActiveOrInactiveProjects(true);
        List<Long> projectIds = new ArrayList<Long>();
        for (Project project : projectdetail) {
            projectIds.add(project.getProjectId());
        }
        List<Project> expResult = null;
        List<Project> result = projectService.retrieveAllProjectForSpecificDays(currdate, xDaysAgo, projectIds);

    }

    /**
     * Test of retrieveResourceOfSpecificDaysById method, of class
     * ProjectService.
     */
    @Test
    public void testRetrieveResourceOfSpecificDaysById() {
        System.out.println("retrieveResourceOfSpecificDaysById");
        Date currdate = new Date();
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -(5));
        Date xDaysAgo = cal.getTime();
        Long projectId = 1l;
        List<Project> projectdetail = projectService.retrieveActiveOrInactiveProjects(true);
        List<Long> projectIds = new ArrayList<Long>();
        for (Project project : projectdetail) {
            projectIds.add(project.getProjectId());
        }
        List<ProjectResourceDetail> expResult = null;
        List<ProjectResourceDetail> result = projectService.retrieveResourceOfSpecificDaysById(currdate, xDaysAgo, projectId, projectIds);
    }

    /**
     * Test of retrieveTechnologyOfSpecificDaysById method, of class
     * ProjectService.
     */
    @Test
    public void testRetrieveTechnologyOfSpecificDaysById() {
        System.out.println("retrieveTechnologyOfSpecificDaysById");
        Date currdate = new Date();
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -(5));
        Date xDaysAgo = cal.getTime();
        Long projectId = 1l;
       List<Project> projectdetail = projectService.retrieveActiveOrInactiveProjects(true);
        List<Long> projectIds = new ArrayList<Long>();
        for (Project project : projectdetail) {
            projectIds.add(project.getProjectId());
        }
        List<ProjectTechnologyDetail> expResult = null;
        List<ProjectTechnologyDetail> result = projectService.retrieveTechnologyOfSpecificDaysById(currdate, xDaysAgo, projectId, projectIds);
    }

    /**
     * Test of retrieveAllResourceOfSpecificDays method, of class
     * ProjectService.
     */
    @Test
    public void testRetrieveAllResourceOfSpecificDays() {
        System.out.println("retrieveAllResourceOfSpecificDays");
        Date currdate = new Date();
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -(5));
        Date xDaysAgo = cal.getTime();
        List<Project> projectdetail = projectService.retrieveActiveOrInactiveProjects(true);
        List<Long> projectIds = new ArrayList<Long>();
        for (Project project : projectdetail) {
            projectIds.add(project.getProjectId());
        }
        List<ProjectResourceDetail> expResult = null;
        List<ProjectResourceDetail> result = projectService.retrieveAllResourceOfSpecificDays(currdate, xDaysAgo, projectIds);

    }

    /**
     * Test of retrieveAllTechnologyOfSpecificDays method, of class
     * ProjectService.
     */
    @Test
    public void testRetrieveAllTechnologyOfSpecificDays() {
        System.out.println("retrieveAllTechnologyOfSpecificDays");
        Date currdate = new Date();
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -(5));
        Date xDaysAgo = cal.getTime();
       List<Project> projectdetail = projectService.retrieveActiveOrInactiveProjects(true);
        List<Long> projectIds = new ArrayList<Long>();
        for (Project project : projectdetail) {
            projectIds.add(project.getProjectId());
        }
        List<ProjectTechnologyDetail> expResult = null;
        List<ProjectTechnologyDetail> result = projectService.retrieveAllTechnologyOfSpecificDays(currdate, xDaysAgo, projectIds);

    }

    /**
     * Test of retrieveAllMilestoneForSpecificDays method, of class
     * ProjectService.
     */
    @Test
    public void testRetrieveAllMilestoneForSpecificDays() {
        System.out.println("retrieveAllMilestoneForSpecificDays");
        Date currdate = new Date();
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -(5));
        Date xDaysAgo = cal.getTime();
        List<Project> projectdetail = projectService.retrieveActiveOrInactiveProjects(true);
        List<Long> projectIds = new ArrayList<Long>();
        for (Project project : projectdetail) {
            projectIds.add(project.getProjectId());
        }
        List<ProjectMilestone> expResult = null;
        List<ProjectMilestone> result = projectService.retrieveAllMilestoneForSpecificDays(currdate, xDaysAgo, projectIds);
    }

    /**
     * Test of retrieveProjectResourceById method, of class ProjectService.
     */
    @Test
    public void testRetrieveProjectResourceById() {
        System.out.println("retrieveProjectResourceById");
        Long resourceId = 1l;
        ProjectResourceDetail expResult = null;
        ProjectResourceDetail result = projectService.retrieveProjectResourceById(resourceId);
    }

    /**
     * Test of retrieveProjectTechnologyById method, of class ProjectService.
     */
    @Test
    public void testRetrieveProjectTechnologyById() {
        System.out.println("retrieveProjectTechnologyById");
        Long techId = 1l;
        ProjectTechnologyDetail expResult = null;
        ProjectTechnologyDetail result = projectService.retrieveProjectTechnologyById(techId);
    }

    /**
     * Test of retrieveProjectTechnologyByProjectId method, of class
     * ProjectService.
     */
    @Test
    public void testRetrieveProjectTechnologyByProjectId() {
        System.out.println("retrieveProjectTechnologyByProjectId");
        Long projectId = 1l;
        List<ProjectTechnologyDetail> expResult = null;
        List<ProjectTechnologyDetail> result = projectService.retrieveProjectTechnologyByProjectId(projectId);
    }

    @Test
    public void testRetrieveAllMilestoneActivityByDates() {
        System.out.println("retrieveAllMilestoneForSpecificDays");
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -(5));
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        Date startDate = cal.getTime();

        assertNotNull("startDate", startDate);
        Calendar cal1 = GregorianCalendar.getInstance();
        cal1.set(Calendar.MINUTE, 59);
        cal1.set(Calendar.HOUR_OF_DAY, 24);
        cal1.set(Calendar.SECOND, 59);
        Date endDate = cal1.getTime();
        Long userId = 2l;
        List<Project> projectdetail = projectService.retrieveActiveOrInactiveProjects(true);
        List<Long> projectIds = new ArrayList<Long>();
        for (Project project : projectdetail) {
            projectIds.add(project.getProjectId());
        }
        List<ProjectMilestone> expResult = null;
        List<ProjectMilestone> result = projectService.retrieveAllMilestonesActivityOfCurrentUserByDates(startDate, endDate, userId,projectIds);
        assertNotNull("result:", result);
    }

    @Test
    public void testAddProjectResourceRoleDetail() {

        List<Project> projectList = projectService.retrieveProjects();
        if (projectList != null && !projectList.isEmpty()) {
            Project project = projectList.get(0);
//            userProjectRoleDetail.setProjectId(project);
//            projectService.addProjectResourceRoleDetail(userProjectRoleDetailsList);
            System.out.println("----->testAddProjectResourceRoleDetail--------->");
        }
    }

    @Test
    public void testRetrieveProjectResourceWithRoleByProjectId() {
//        List<UserProjectRoleDetail> userProjectRoleDetailsList = projectService.retrieveAllUserProjectRoleDetail();

//        if (userProjectRoleDetailsList != null && !userProjectRoleDetailsList.isEmpty()) {
//            UserProjectRoleDetail userProjectRoleDetail = userProjectRoleDetailsList.get(0);
//            List<UserProjectRoleDetail> userProjectRoleDetailsListOfProject = projectService.retrieveProjectResourceWithRoleByProjectId(userProjectRoleDetail.getProjectId().getProjectId());

            System.out.println("----->testRetrieveProjectResourceWithRole--------->");
//        }
    }

    @Test
    public void testRetrieveResourcesOfProjectByUserIds() {
//        List<UserProjectRoleDetail> userProjectRoleDetailsList = projectService.retrieveAllUserProjectRoleDetail();

//        if (userProjectRoleDetailsList != null && !userProjectRoleDetailsList.isEmpty()) {
//            Long projectId = userProjectRoleDetailsList.get(0).getProjectId().getProjectId();
//            List<UserProjectRoleDetail> userProjectRoleDetailsListOfProject = projectService.retrieveProjectResourceWithRoleByProjectId(projectId);

            List<Long> userIds = new ArrayList<Long>();
//            for (UserProjectRoleDetail userProjectRoleDetail : userProjectRoleDetailsListOfProject) {
//            userIds.add(userProjectRoleDetail.getAssignedTo());

//        }
//            projectService.retrieveResourcesOfProjectByUserIds(userIds, projectId);
            System.out.println("----->testRetrieveResourcesOfProjectByUserIds--------->");
//        }
    }

    @Test
    public void testAssignRoleToResourcesOfProject() {

//        List<UserProjectRoleDetail> userProjectRoleDetailsList = projectService.retrieveAllUserProjectRoleDetail();
//        if (userProjectRoleDetailsList != null && !userProjectRoleDetailsList.isEmpty()) {
//            UserProjectRoleDetail userProjectRoleDetail = userProjectRoleDetailsList.get(0);
//            System.out.println("\n++++user project role detail++++\n" + userProjectRoleDetail.toString());
//            userProjectRoleDetail.setProjectRoleId(1L);
//            projectService.assignRoleToResourcesOfProject(userProjectRoleDetailsList);
            System.out.println("----->testAssignRoleToResourcesOfProject--------->");
//        }
    }

    @Test
    public void testRetrieveProjectResourceByUserProjectRoleId() {
//        List<UserProjectRoleDetail> userProjectRoleDetailsList = projectService.retrieveAllUserProjectRoleDetail();
//        if (userProjectRoleDetailsList != null && !userProjectRoleDetailsList.isEmpty()) {
//            UserProjectRoleDetail userProjectRoleDetail = userProjectRoleDetailsList.get(0);
//            UserProjectRoleDetail userProjectRole = projectService.retrieveProjectResourceByUserProjectRoleId(userProjectRoleDetail.getUserProjectRoleId());
            System.out.println("----->testRetrieveProjectResourceByUserProjectRoleId--------->");
//        }
    }

    @Test
    public void testUpdateProjectResourceRoleById() {
//        List<UserProjectRoleDetail> userProjectRoleDetailsList = projectService.retrieveAllUserProjectRoleDetail();
//        if (userProjectRoleDetailsList != null && !userProjectRoleDetailsList.isEmpty()) {
//            UserProjectRoleDetail userProjectRoleDetail = userProjectRoleDetailsList.get(0);
//            assertNotNull("++++++last modify by before update++++++", userProjectRoleDetail.getLastModifiedOn());
//            userProjectRoleDetail.setLastModifiedOn(new Date());
//            assertNotNull("++++++last modify by after update++++++", userProjectRoleDetail.getLastModifiedOn());
//            projectService.updateProjectResourceRole(userProjectRoleDetail);
            System.out.println("----->testUpdateProjectResourceRoleById--------->");
//        }
    }

    /**
     * Test of retieveAllActiveProjectsOfUser method, of class ProjectService.
     */
    @Test
    public void testRetieveAllActiveProjectsOfUser() {
        System.out.println("retieveAllActiveProjectsOfUser");
        long userId = 1L;
        List<Project> expResult = null;
        List<Project> result = projectService.retieveAllActiveProjectsOfUser(userId);
        for (Project project1 : result) {
            System.out.println("projects : " + project1.getProjectAlias());
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of retrieveProjectResourceByProjectId method, of class
     * ProjectService.
     */
    @Test
    public void testRetrieveProjectResourceByProjectId() {
        System.out.println("retrieveProjectResourceByProjectId");
        Long projectId = 1l;
        List<ProjectResourceDetail> expResult = null;
        List<ProjectResourceDetail> result = projectService.retrieveProjectResourceByProjectId(projectId);
        for (ProjectResourceDetail projectResourceDetail : result) {
            System.out.println("resource : " + projectResourceDetail.getProjectResourceDetailId());
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of retrieveAttachmentOfSpecificDaysById method, of class
     * ProjectService.
     */
    @Test
    public void testRetrieveAttachmentOfSpecificDaysById() {
        System.out.println("retrieveAttachmentOfSpecificDaysById");

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        Date currdate = cal.getTime();
        Calendar cal1 = GregorianCalendar.getInstance();
        cal1.add(Calendar.DAY_OF_WEEK, -(5));
        cal1.set(Calendar.MINUTE, 59);
        cal1.set(Calendar.HOUR_OF_DAY, 23);
        cal1.set(Calendar.SECOND, 59);
        Date xDaysAgo = cal1.getTime();
        Long projectId = 1l;
       List<Project> projectdetail = projectService.retrieveActiveOrInactiveProjects(true);
        List<Long> projectIds = new ArrayList<Long>();
        for (Project project : projectdetail) {
            projectIds.add(project.getProjectId());
        }
        List<ProjectAttachment> expResult = null;
        List<ProjectAttachment> result = projectService.retrieveAttachmentOfSpecificDaysById(currdate, xDaysAgo, projectId, projectIds);
    }

    /**
     * Test of retrieveAllAttachmentOfSpecificDays method, of class
     * ProjectService.
     */
    @Test
    public void testRetrieveAllAttachmentOfSpecificDays() {
        System.out.println("retrieveAllAttachmentOfSpecificDays");
        Calendar cal = GregorianCalendar.getInstance();
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        Date currdate = cal.getTime();
        Calendar cal1 = GregorianCalendar.getInstance();
        cal1.add(Calendar.DAY_OF_WEEK, -(5));
        cal1.set(Calendar.MINUTE, 59);
        cal1.set(Calendar.HOUR_OF_DAY, 23);
        cal1.set(Calendar.SECOND, 59);
        Date xDaysAgo = cal1.getTime();
        List<Project> projectdetail = projectService.retrieveActiveOrInactiveProjects(true);
        List<Long> projectIds = new ArrayList<Long>();
        for (Project project : projectdetail) {
            projectIds.add(project.getProjectId());
        }
        List<ProjectAttachment> expResult = null;
        List<ProjectAttachment> result = projectService.retrieveAllAttachmentOfSpecificDays(currdate, xDaysAgo, projectIds);
        for (ProjectAttachment projectAttachment : result) {
            System.out.println("attachments : " + projectAttachment.getProjectAttachmentName());
        }
    }

    /**
     * Test of retrieveProjectAttachmentsByProjectId method, of class
     * ProjectService.
     */
    @Test
    public void testRetrieveProjectAttachmentsByProjectId() {
        System.out.println("retrieveProjectAttachmentsByProjectId");
        Long projectId = 1l;
        List<ProjectAttachment> expResult = null;
        List<ProjectAttachment> result = projectService.retrieveProjectAttachmentsByProjectId(projectId);
        for (ProjectAttachment projectAttachment : result) {
            System.out.println("attachment : " + projectAttachment.getProjectAttachmentName());
        }
    }

    /**
     * Test of retrieveProjectAttachmentById method, of class ProjectService.
     */
    @Test
    public void testRetrieveProjectAttachmentById() {
        System.out.println("retrieveProjectAttachmentById");
        Long projectAttachmentId = 1l;
        ProjectAttachment expResult = null;
        ProjectAttachment result = projectService.retrieveProjectAttachmentById(projectAttachmentId);
    }

    /**
     * Test of retrieveAllResourcesActivityOfCurrentUserByDates method, of class
     * ProjectService.
     */
    @Test
    public void testRetrieveAllResourcesActivityOfCurrentUserByDates() {
        System.out.println("retrieveAllResourcesActivityOfCurrentUserByDates");
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -(5));
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        Date startDate = cal.getTime();

        System.out.println("startDate" + startDate);
        Calendar cal1 = GregorianCalendar.getInstance();
        cal1.set(Calendar.MINUTE, 59);
        cal1.set(Calendar.HOUR_OF_DAY, 24);
        cal1.set(Calendar.SECOND, 59);
        Date endDate = cal1.getTime();
        Long userId = 1l;
        List<Project> projectdetail = projectService.retrieveActiveOrInactiveProjects(true);
        List<Long> projectIds = new ArrayList<Long>();
        for (Project project : projectdetail) {
            projectIds.add(project.getProjectId());
        }
        List<ProjectResourceDetail> expResult = null;
        List<ProjectResourceDetail> result = projectService.retrieveAllResourcesActivityOfCurrentUserByDates(startDate, endDate, userId,projectIds);
    }

    /**
     * Test of retrieveAllTechnologyActivityOfCurrentUserByDates method, of
     * class ProjectService.
     */
    @Test
    public void testRetrieveAllTechnologyActivityOfCurrentUserByDates() {
        System.out.println("retrieveAllTechnologyActivityOfCurrentUserByDates");
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -(5));
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        Date startDate = cal.getTime();

        System.out.println("startDate" + startDate);
        Calendar cal1 = GregorianCalendar.getInstance();
        cal1.set(Calendar.MINUTE, 59);
        cal1.set(Calendar.HOUR_OF_DAY, 24);
        cal1.set(Calendar.SECOND, 59);
        Date endDate = cal1.getTime();
        Long userId = 1l;
        List<Project> projectdetail = projectService.retrieveActiveOrInactiveProjects(true);
        List<Long> projectIds = new ArrayList<Long>();
        for (Project project : projectdetail) {
            projectIds.add(project.getProjectId());
        }
        List<ProjectTechnologyDetail> expResult = null;
        List<ProjectTechnologyDetail> result = projectService.retrieveAllTechnologyActivityOfCurrentUserByDates(startDate, endDate, userId,projectIds);
    }

    /**
     * Test of retrieveAllMilestonesActivityOfCurrentUserByDates method, of
     * class ProjectService.
     */
    @Test
    public void testRetrieveAllMilestonesActivityOfCurrentUserByDates() {
        System.out.println("retrieveAllMilestonesActivityOfCurrentUserByDates");
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -(5));
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        Date startDate = cal.getTime();

        System.out.println("startDate" + startDate);
        Calendar cal1 = GregorianCalendar.getInstance();
        cal1.set(Calendar.MINUTE, 59);
        cal1.set(Calendar.HOUR_OF_DAY, 24);
        cal1.set(Calendar.SECOND, 59);
        Date endDate = cal1.getTime();
        Long userId = 1l;
        List<Project> projectdetail = projectService.retrieveActiveOrInactiveProjects(true);
        List<Long> projectIds = new ArrayList<Long>();
        for (Project project : projectdetail) {
            projectIds.add(project.getProjectId());
        }
        List<ProjectMilestone> expResult = null;
        List<ProjectMilestone> result = projectService.retrieveAllMilestonesActivityOfCurrentUserByDates(startDate, endDate, userId,projectIds);
    }

    /**
     * Test of retrieveAllProjectAttachmentActivityOfCurrentUserByDates method,
     * of class ProjectService.
     */
    @Test
    public void testRetrieveAllProjectAttachmentActivityOfCurrentUserByDates() {
        System.out.println("retrieveAllProjectAttachmentActivityOfCurrentUserByDates");
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -(5));
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        Date startDate = cal.getTime();

        System.out.println("startDate" + startDate);
        Calendar cal1 = GregorianCalendar.getInstance();
        cal1.set(Calendar.MINUTE, 59);
        cal1.set(Calendar.HOUR_OF_DAY, 24);
        cal1.set(Calendar.SECOND, 59);
        Date endDate = cal1.getTime();
        Long userId = 1l;
        List<Project> projectdetail = projectService.retrieveActiveOrInactiveProjects(true);
        List<Long> projectIds = new ArrayList<Long>();
        for (Project project : projectdetail) {
            projectIds.add(project.getProjectId());
        }
        List<ProjectAttachment> expResult = null;
        List<ProjectAttachment> result = projectService.retrieveAllProjectAttachmentActivityOfCurrentUserByDates(startDate, endDate, userId,projectIds);
    }

    /**
     * Test of createRolesOfProject method, of class ProjectService.
     */
    @Test
    public void testCreateRolesOfProject() {
        System.out.println("createRolesOfProject");
        Long id = projectService.createRolesOfProject(projectRoles);
        assertNotNull("Not created", id);
    }

    /**
     * Test of updateRolesOfProject method, of class ProjectService.
     */
    @Test
    public void testUpdateRolesOfProject() {
        System.out.println("updateRolesOfProject");
        Long id = projectService.createRolesOfProject(projectRoles);
        ProjectRoles projectRolesMaster = projectService.retrieveRoleOfProjectById(id);
        projectRolesMaster.setProjectRoleId(1l);
        projectRolesMaster.setProjectRoleName("Tester");
        projectRolesMaster.setProjectRoleDescription("bug Analayser");
        projectRolesMaster.setIsActive(Boolean.FALSE);
        projectService.updateRolesOfProject(projectRolesMaster);

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of retrieveAllRolesOfProject method, of class ProjectService.
     */
    @Test
    public void testRetrieveAllRolesOfProject() {
        System.out.println("retrieveAllRolesOfProject");
        Boolean isActive = Boolean.TRUE;
        List<ProjectRoles> expResult = null;
        List<ProjectRoles> result = projectService.retrieveAllRolesOfProject(isActive);
    }

    /**
     * Test of retrieveRoleOfProjectById method, of class ProjectService.
     */
    @Test
    public void testRetrieveRoleOfProjectById() {
        System.out.println("retrieveRoleOfProjectById");
        Long projectRolesId = 1l;
        ProjectRoles expResult = null;
        ProjectRoles result = projectService.retrieveRoleOfProjectById(projectRolesId);
    }

}
