/*
 * To change this license header, choose License Headers in ProjectMaster Properties.
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
import java.util.Date;
import java.util.List;

/**
 * Service interface for Project
 *
 * @author ravi
 * @since 04-MAR-2014
 */
public interface ProjectService {

    /**
     * createProjectMaster method creates ProjectMaster object
     *
     * @param project Takes object of class Project for which Project has to be
     * created
     * @return
     */
    public Long createProject(Project project);

    /**
     * updateProjectMaster method updates ProjectMaster Master object
     *
     * @param project Takes in the object of Project that has to be updated
     */
    public void updateProject(Project project);

    /**
     * updateProjectResource method updates ProjectResourceDetail object
     *
     * @param projectResourceDetail Takes in the object of Project that has to
     * be updated
     */
    public void updateProjectResource(ProjectResourceDetail projectResourceDetail);

    /**
     * isProjectExist method checks whether Project exist by Project Name
     *
     * @param projectName Takes in the name of Project
     * @return true if Project exists else false
     */
    public boolean isProjectExist(String projectName);

    /**
     * isProjectAliasExist method checks whether Project exist by Project Alias
     *
     * @param projectAlias Takes in the alias of Project
     * @return true if Project exists else false
     */
    public boolean isProjectALiasExist(String projectAlias);

    /**
     * updateProjectTechnology method updates ProjectTechnologyDetail object
     *
     * @param projectTechnologyDetail Takes in the object of
     * ProjectTechnologyDetail that has to be updated
     */
    public void updateProjectTechnology(ProjectTechnologyDetail projectTechnologyDetail);

    /**
     * deleteProjectMaster method deletes(archives) ProjectMaster already
     * created
     *
     * @param project Takes object of class Project which is to be deleted
     *
     */
    public void deleteProject(Project project);

    /**
     *
     * @param userId
     * @return
     */
    public List<Project> retieveAllActiveProjectsOfUser(long userId);

    /**
     * retrieveAllActiveProjects method retrieves List of all objects of Project
     *
     *
     *
     * @return List of object of Project
     */
    public List<Project> retrieveAllProjectByIds(String idFeildname, List<Long> ids);

    /**
     * getAllInActiveProjects method retrieves List of all objects of Project
     *
     *
     *
     * @return List of object of Project
     */
    /**
     * getAllProjects method retrieves List of all objects of Project
     *
     *
     *
     * @return List of object of TechnologyMaster
     */
    public List<Project> getAllProjects();

    /**
     * retrieveProjectById method returns instance of class Project by searching
     * Id
     *
     * @param projectId Takes project id for which we want to get project
     * @return object of class Project correspond to projectId
     */
    public Project retrieveProjectById(Long projectId);

    /**
     * Retrieve list of all projects
     *
     * @return list of project
     */
    public List<Project> retrieveProjects();

    /**
     * Retrieve list of active/inactive projects
     *
     * @param active if true then it retrieves active projects
     * @param active if false then it retrieves inactive projects
     * @param active if null then it retrieves all projects
     * @return list of project
     */
    public List<Project> retrieveActiveOrInactiveProjects(Boolean active);

    /**
     * Retrieve list of all project milestones
     *
     * @return list of projectmilestones
     */
    public List<ProjectMilestone> retrieveProjectMilestones();

    public List<ProjectMilestone> retrieveActiveOrInactiveProjectMilestones(Boolean active);

    /**
     * addMilestoneToProjectMaster method adds new milestone to project
     *
     * @param milestone Takes object of class ProjectMasterMilestone to created
     */
    public Long addMilestoneToProject(ProjectMilestone milestone);

    /**
     * Retrieve particular milestone from unique id
     *
     * @param projectMilestoneId
     * @return object of ProjectMasterMilestone
     */
    public ProjectMilestone retrieveProjectMilestoneById(Long projectMilestoneId);

    /**
     * Update details of ProjectMasterMilestone
     *
     * @param projectMilestone
     */
    public void updateProjectMilestone(ProjectMilestone projectMilestone);

    /**
     * retrieveMilestonesById method returns all the milestones related with
     * projectID
     *
     * @param projectId Takes value of project ID for which we want to fetch all
     * milestones
     * @return set of ProjectMilestone correspondence to projectId
     */
    public List<ProjectMilestone> retrieveMilestonesById(Long projectId);

    /**
     * retrieveCompletedMilestonesById method returns all the completed
     * milestones related with projectID
     *
     * @author Shifa
     * @param projectId Takes value of project ID for which we want to fetch all
     * milestones
     * @return set of ProjectMilestone correspondence to projectId
     */
    public List<ProjectMilestone> retrieveCompletedMilestonesById(Long projectId);

    /**
     * Deletes the milestone from project
     *
     * @param projectMilestone
     */
    public void deleteMilestone(ProjectMilestone projectMilestone);

    /**
     * add technology to a project.
     *
     * @param projectTechnologyDetail takes object of class
     * ProjectMasterTechnologyDetail
     * @return id of the technology added
     */
    public long addTechnologyToProject(ProjectTechnologyDetail projectTechnologyDetail);

    /**
     * add multiple technologies to a project.
     *
     * @param projectTechnologyDetail takes object list of
     * ProjectMasterTechnologyDetail
     */
    public void addTechnologiesToProject(List<ProjectTechnologyDetail> projectTechnologyDetail);

    /**
     * to get list of technology related project
     *
     * @param projectId
     * @return object list of ProjectMasterTechnologyDetail
     */
    public List<ProjectTechnologyDetail> retrieveTechnologies(Long projectId);

    /**
     * to delete technology from project
     *
     * @param projectTechnologyDetail object of ProjectMasterTechnologyDetail
     */
    public void deleteTechnologyFromProject(ProjectTechnologyDetail projectTechnologyDetail);

    /**
     * to delete list of technology related project
     *
     * @param projectTechnologyDetail
     */
    public void deleteTechnologiesFromProject(List<ProjectTechnologyDetail> projectTechnologyDetail);

    /**
     * to add a new resource
     *
     * @param projectResourceDetail object of ProjectMasterResourceDetail
     */
    public void addResourceToProject(ProjectResourceDetail projectResourceDetail);

    /**
     * to add multiple of resources to a project
     *
     * @param projectResourceDetails takes object list of
     * ProjectMasterResourceDetails
     */
    public void addResourcesToProject(List<ProjectResourceDetail> projectResourceDetails);

    /**
     * to retrieve list of resources working on a project
     *
     * @param projectId
     * @return
     */
    public List<ProjectResourceDetail> retrieveResources(Long projectId);

    /**
     * to delete a resource
     *
     * @param projectResourceDetails
     */
    public void deleteResourceFromProject(ProjectResourceDetail projectResourceDetails);

    /**
     * to delete list of resources
     *
     * @param projectResourceDetails
     */
    public void deleteResourcesFromProject(List<ProjectResourceDetail> projectResourceDetails);

    /**
     * retrieveProjectResourceByProjectId method returns all the resources
     * related with projectID
     *
     * @param projectId Takes value of project ID for which we want to fetch all
     * milestones
     * @return set of ProjectResourceDetail correspondence to projectId
     */
    public List<ProjectResourceDetail> retrieveProjectResourceByProjectId(Long projectId);

    /**
     * to retrieve all milestones of specified days from system Configuration
     * table
     *
     * @param currdate
     * @param xDaysAgo configured in system Configuration table
     * @param projectId to obtain milestone of that project only
     * @param userId for the user in that project.
     * @return list of object of class ProjectMilestone
     */
    public List<ProjectMilestone> retrieveMilestoneForSpecificDaysById(Date currdate, Date xDaysAgo, Long projectId, List<Long> projectIds);

    /**
     * to retrieve all project of specified days from system Configuration table
     *
     * @param currdate
     * @param xDaysAgo configured in system Configuration table
     * @param projectId to obtain project of that project only
     * @param userId for the user in that project.
     * @return list of object of class Project
     */
    public List<Project> retrieveProjectForSpecificDaysById(Date currdate, Date xDaysAgo, List<Long> projectIds, Long projectId);

    /**
     * to retrieve all project of specified days from system Configuration table
     *
     * @param currdate
     * @param xDaysAgo configured in system Configuration table
     * @param userId for the user in that project.
     * @return list of object of class Project
     */
    public List<Project> retrieveAllProjectForSpecificDays(Date currdate, Date xDaysAgo, List<Long> projectIds);

    /**
     * to retrieve all resource of specified days from system Configuration
     * table
     *
     * @param currdate
     * @param xDaysAgo configured in system Configuration table
     * @param projectId to obtain resource of that project only
     * @param userId for the user in that project.
     * @return list of object of class ProjectResourceDetail
     */
    public List<ProjectResourceDetail> retrieveResourceOfSpecificDaysById(Date currdate, Date xDaysAgo, Long projectId, List<Long> projectIds);

    /**
     * to retrieve all technology of specified days from system Configuration
     * table
     *
     * @param currdate
     * @param xDaysAgo configured in system Configuration table
     * @param projectId to obtain technology of that project only
     * @param userId for the user in that project.
     * @return list of object of class ProjectTechnologyDetail
     */
    public List<ProjectTechnologyDetail> retrieveTechnologyOfSpecificDaysById(Date currdate, Date xDaysAgo, Long projectId, List<Long> projectIds);

    /**
     * to retrieve all attachment of specified days from system Configuration
     * table
     *
     * @param currdate
     * @param xDaysAgo configured in system Configuration table
     * @param projectId to obtain attachment of that project only
     * @param userId for the user in that project.
     * @return list of object of class ProjectAttachment
     */
    public List<ProjectAttachment> retrieveAttachmentOfSpecificDaysById(Date currdate, Date xDaysAgo, Long projectId, List<Long> projectIds);

    /**
     * to retrieve all resources of specified days from system Configuration
     * table
     *
     * @param currdate
     * @param xDaysAgo configured in system Configuration table
     * @param userId for the user in that project.
     * @return list of object of class ProjectResourceDetail
     */
    public List<ProjectResourceDetail> retrieveAllResourceOfSpecificDays(Date currdate, Date xDaysAgo, List<Long> projectIds);

    /**
     * to retrieve all attachments of specified days from system Configuration
     * table
     *
     * @param currdate
     * @param xDaysAgo configured in system Configuration table
     * @param userId for the user in that project.
     * @return list of object of class ProjectAttachment
     */
    public List<ProjectAttachment> retrieveAllAttachmentOfSpecificDays(Date currdate, Date xDaysAgo, List<Long> projectIds);

    /**
     * to retrieve all Technology of specified days from system Configuration
     * table
     *
     * @param currdate
     * @param xDaysAgo configured in system Configuration table
     * @param userId for the user in that project.
     * @return list of object of class ProjectTechnologyDetail
     */
    public List<ProjectTechnologyDetail> retrieveAllTechnologyOfSpecificDays(Date currdate, Date xDaysAgo, List<Long> projectIds);

    /**
     * to retrieve all Milestone of specified days from system Configuration
     * table
     *
     * @param currdate
     * @param xDaysAgo configured in system Configuration table
     * @param userId for the user in that project.
     * @return list of object of class ProjectMilestone
     */
    public List<ProjectMilestone> retrieveAllMilestoneForSpecificDays(Date currdate, Date xDaysAgo, List<Long> projectIds);

    /**
     * to retrieve resource of particular project from PK of class
     * ProjectResourceDetail table
     *
     * @param resourceId for the PK of class ProjectResourceDetail
     * @return object of class ProjectResourceDetail
     */
    public ProjectResourceDetail retrieveProjectResourceById(Long resourceId);

    /**
     * to retrieve technology of particular project from PK of class
     * ProjectTechnologyDetail table
     *
     * @param techId for the PK of class ProjectResourceDetail
     * @return object of class ProjectTechnologyDetail
     */
    public ProjectTechnologyDetail retrieveProjectTechnologyById(Long techId);

    /**
     * retrieveProjectTechnologyByProjectId method returns all the resources
     * related with projectID
     *
     * @param projectId Takes value of project ID for which we want to fetch all
     * milestones
     * @return set of ProjectTechnologyDetail correspondence to projectId
     */
    public List<ProjectTechnologyDetail> retrieveProjectTechnologyByProjectId(Long projectId);

    /**
     * addProjectAttachment method takes a object of ProjectAttachment it
     * returns a projectAttachmentId of add task
     *
     * @author shreya
     * @param projectAttachments
     */
    public void addProjectAttachment(List<ProjectAttachment> projectAttachments);

    /**
     * deleteProjectAttachment method takes a projectAttachment as parameter it
     * will delete the
     *
     * @param projectAttachment
     * @author shreya
     */
    public void deleteProjectAttachment(ProjectAttachment projectAttachment);

    /**
     * retrieve project attachment detail by task id provided in parameter
     *
     * @author shreya
     * @param projectId projectId
     * @return list of object of ProjectAttachment model
     */
    public List<ProjectAttachment> retrieveProjectAttachmentsByProjectId(Long projectId);

    /**
     * retrieveProjectAttachmentById retrieves project attachment detail by
     * projectAttachmentId
     *
     * @author shreya
     * @param projectAttachmentId
     * @return object of ProjectAttachment model
     */
    public ProjectAttachment retrieveProjectAttachmentById(Long projectAttachmentId);

//    /**
//     * Method is used to add resources of project to ProjectResourceDetail To
//     * assign Role for Particular Project.
//     *
//     * @author Brijesh
//     * @param userProjectRoleDetails
//     */
//    public void addProjectResourceRoleDetail(List<UserProjectRoleDetail> userProjectRoleDetails);
    /**
     * retrieveAllResourcesActivityOfCurrentUserByDates retrieves all resources
     * of current user created or modified between dates
     *
     * @author shreya
     * @param startDate
     * @param endDate
     * @param userId
     * @param projectIds
     * @return object of ProjectResourceDetail model
     */
    public List<ProjectResourceDetail> retrieveAllResourcesActivityOfCurrentUserByDates(Date startDate, Date endDate, Long userId, List<Long> projectIds);

    /**
     * retrieveAllTechnologyActivityOfCurrentUserByDates retrieves all
     * technology of current user created or modified between dates
     *
     * @author shreya
     * @param startDate
     * @param endDate
     * @param userId
     * @return object of ProjectTechnologyDetail model
     */
    public List<ProjectTechnologyDetail> retrieveAllTechnologyActivityOfCurrentUserByDates(Date startDate, Date endDate, Long userId, List<Long> projectIds);

    /**
     * retrieveAllMilestonesActivityOfCurrentUserByDates retrieves all
     * milestones of current user created or modified between dates
     *
     * @author shreya
     * @param startDate
     * @param endDate
     * @param userId
     * @param projectIds
     * @return object of ProjectMilestone model
     */
    public List<ProjectMilestone> retrieveAllMilestonesActivityOfCurrentUserByDates(Date startDate, Date endDate, Long userId, List<Long> projectIds);

    /**
     * retrieveAllProjectAttachmentActivityOfCurrentUserByDates retrieves all
     * project attachment uploaded or deleted of current user created or
     * modified between dates
     *
     * @author shreya
     * @param startDate
     * @param endDate
     * @param userId
     * @return object of ProjectAttachment model
     */
    public List<ProjectAttachment> retrieveAllProjectAttachmentActivityOfCurrentUserByDates(Date startDate, Date endDate, Long userId, List<Long> projectIds);

    /**
     * createRolesOfProject method creates ProjectRoles object
     *
     * @param projectRoles object that has to be created
     * @author shreya
     * @return projectRolesId
     */
    public Long createRolesOfProject(ProjectRoles projectRoles);

    /**
     * updateRolesOfProject method updates ProjectRoles object
     *
     * @param projectRoles object that has to be updated
     * @author shreya
     */
    public void updateRolesOfProject(ProjectRoles projectRoles);

    /**
     * retrieveAllRolesOfProject method retrieves List of object of ProjectRoles
     *
     * @param isActive
     * @return List of object of ProjectRoles
     * @author shreya
     */
    public List<ProjectRoles> retrieveAllRolesOfProject(Boolean isActive);

    /**
     * deleteRoleOfProject method deletes the ProjectRoles object
     *
     * @param projectRoles object that has to be deleted
     * @author shreya
     */
    public void deleteRoleOfProject(ProjectRoles projectRoles);

    /**
     * retrieveRoleOfProjectById method retrieves object of ProjectRoles
     *
     * @param projectRolesId
     * @return object of ProjectRoles
     * @author shreya
     */
    public ProjectRoles retrieveRoleOfProjectById(Long projectRolesId);

    /**
     * Method is used to retrieve resources of project from
     * ProjectResourceDetail by userIds.
     *
     * @author Brijesh
     * @param projectId
     * @param userIds
     * @return
     */
    public List<ProjectResourceDetail> retrieveResourcesOfProjectByUserIds(List userIds, Long projectId);

    /**
     * @author niharika
     * @param techIds
     * @param projectId
     * @return
     */
    public List<ProjectTechnologyDetail> retrieveResourcesOfProjectByTechIds(List techIds, Long projectId);

    /**
     * Method is used to assign Role To Resources of project in
     * ProjectResourceDetail.
     *
     * @author Brijesh
     * @param userProjectRoleDetailsList
     */
    public void assignRoleToResourcesOfProject(List<ProjectResourceDetail> userProjectRoleDetailsList);

    /**
     * Method is used to retrieve resource of project from ProjectResourceDetail
     * by Id.
     *
     * @author Brijesh
     * @param id
     * @return
     */
    public ProjectResourceDetail retrieveProjectResourceByUserProjectRoleId(Long id);

    /**
     * Method is used to update resource of project in ProjectResourceDetail.
     *
     * @author Brijesh
     * @param userProjectRoleDetail
     * @return
     */
    public void updateProjectResourceRole(ProjectResourceDetail userProjectRoleDetail);

    /**
     * Method is used to Retrieve All Resources of project from
     * ProjectResourceDetail.
     *
     * @author Brijesh
     * @param
     * @return
     */
    public List<ProjectResourceDetail> retrieveAllUserProjectRoleDetail();

    public List<Project> searchString(String searchString);

    /**
     * retrieveProjectByprojectName method returns instance of class Project by
     * searching ProjectName
     *
     * @param projectId Takes project id for which we want to get project
     * @return object of class Project correspond to projectId
     */
    public Project retrieveProjectByName(String projectName);

}
