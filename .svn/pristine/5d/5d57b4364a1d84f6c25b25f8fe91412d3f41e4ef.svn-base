/*
 * To change this license header, choose License Headers in ProjectMaster Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.core.impl;

import com.argusoft.armms.core.ProjectService;
import com.argusoft.armms.database.ProjectAttachmentDao;
import com.argusoft.armms.database.ProjectDao;
import com.argusoft.armms.database.ProjectMilestoneDao;
import com.argusoft.armms.database.ProjectResourceDetailDao;
import com.argusoft.armms.database.ProjectRolesDao;
import com.argusoft.armms.database.ProjectTechnologyDetailDao;
//import com.argusoft.armms.database.UserProjectRoleDetailDao;
import com.argusoft.armms.model.Project;
import com.argusoft.armms.model.ProjectAttachment;
import com.argusoft.armms.model.ProjectMilestone;
import com.argusoft.armms.model.ProjectResourceDetail;
import com.argusoft.armms.model.ProjectRoles;
import com.argusoft.armms.model.ProjectTechnologyDetail;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 *
 * @author ravi
 * @since 04-MAR-2014
 */
@Service("projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    public ProjectTechnologyDetailDao projectTechnologyDetailDao;

    @Autowired
    private ProjectResourceDetailDao projectResourceDetailDao;

    @Autowired
    private ProjectDao projectMasterDao;

    @Autowired
    private ProjectMilestoneDao projectMilestoneDao;

    @Autowired
    ProjectAttachmentDao projectAttachmentDao;

    @Autowired
    ProjectRolesDao projectRolesDao;

//    @Autowired
//    UserProjectRoleDetailDao userProjectRoleDetailDao;
    public ProjectTechnologyDetailDao getProjectTechnologyDetailDao() {
        return projectTechnologyDetailDao;
    }

    public void setProjectTechnologyDetailDao(ProjectTechnologyDetailDao projectTechnologyDetailDao) {
        this.projectTechnologyDetailDao = projectTechnologyDetailDao;
    }

    public ProjectResourceDetailDao getProjectResourceDetailDao() {
        return projectResourceDetailDao;
    }

    public void setProjectResourceDetailDao(ProjectResourceDetailDao projectResourceDetailDao) {
        this.projectResourceDetailDao = projectResourceDetailDao;
    }

    public ProjectDao getProjectMasterDao() {
        return projectMasterDao;
    }

    public void setProjectMasterDao(ProjectDao projectMasterDao) {
        this.projectMasterDao = projectMasterDao;
    }

    public ProjectMilestoneDao getProjectMilstoneDao() {
        return projectMilestoneDao;
    }

    public void setProjectMilstoneDao(ProjectMilestoneDao projectMilestoneDao) {
        this.projectMilestoneDao = projectMilestoneDao;
    }

    @Override
    public long addTechnologyToProject(ProjectTechnologyDetail projectTechnologyDetail) {
        Date currentDate = Calendar.getInstance().getTime();
        projectTechnologyDetail.setCreatedOn(currentDate);
//        projectTechnologyDetail.setLastModifiedOn(currentDate);
        Long create = this.projectTechnologyDetailDao.create(projectTechnologyDetail);
        return create;
    }

    @Override
    public void addTechnologiesToProject(List<ProjectTechnologyDetail> projectTechnologyDetails) {
        Date currentDate = Calendar.getInstance().getTime();
        for (ProjectTechnologyDetail projectTechnologyDetail : projectTechnologyDetails) {
            projectTechnologyDetail.setCreatedOn(currentDate);
//            projectTechnologyDetail.setLastModifiedOn(currentDate);
        }
        this.projectTechnologyDetailDao.saveOrUpdateAll(projectTechnologyDetails);
    }

    @Override
    public List<ProjectTechnologyDetail> retrieveTechnologies(Long projectId) {
        List<ProjectTechnologyDetail> allTechnologies = this.projectTechnologyDetailDao.retrieveTechnologies(projectId);
        return allTechnologies;
    }

    @Override
    public void deleteTechnologyFromProject(ProjectTechnologyDetail projectTechnologyDetail) {
        projectTechnologyDetail.setLastModifiedOn(Calendar.getInstance().getTime());
        this.projectTechnologyDetailDao.delete(projectTechnologyDetail);
    }

    @Override
    public void deleteTechnologiesFromProject(List<ProjectTechnologyDetail> projectTechnologyDetails) {
        Date currentDate = Calendar.getInstance().getTime();
        for (ProjectTechnologyDetail projectTechnologyDetail : projectTechnologyDetails) {
            projectTechnologyDetail.setLastModifiedOn(currentDate);
        }
        this.projectTechnologyDetailDao.deleteAll(projectTechnologyDetails);
    }

    @Override
    public void addResourceToProject(ProjectResourceDetail projectResourceDetail) {
        Date currentDate = Calendar.getInstance().getTime();
        projectResourceDetail.setCreatedOn(currentDate);
//        projectResourceDetail.setLastModifiedOn(currentDate);
        this.projectResourceDetailDao.create(projectResourceDetail);
    }

    @Override
    public void addResourcesToProject(List<ProjectResourceDetail> projectResourceDetails) {
        Date currentDate = Calendar.getInstance().getTime();

        for (ProjectResourceDetail projectResourceDetail : projectResourceDetails) {
            if (projectResourceDetail.getCreatedOn() == null) {
                projectResourceDetail.setCreatedOn(currentDate);
            }
            if (projectResourceDetail.getLastModifiedOn() == null) {
                projectResourceDetail.setLastModifiedOn(currentDate);
            }
        }
        this.projectResourceDetailDao.saveOrUpdateAll(projectResourceDetails);
    }

    @Override
    public List<ProjectResourceDetail> retrieveResources(Long projectId) {
        List<ProjectResourceDetail> result = this.projectResourceDetailDao.retrieveResources(projectId);
        return result;
    }

    @Override
    public void deleteResourceFromProject(ProjectResourceDetail projectResourceDetails) {
        projectResourceDetails.setLastModifiedOn(Calendar.getInstance().getTime());
        this.projectResourceDetailDao.delete(projectResourceDetails);
    }

    @Override
    public void deleteResourcesFromProject(List<ProjectResourceDetail> projectResourceDetails) {
        this.projectResourceDetailDao.deleteAll(projectResourceDetails);
    }

    @Override
    public Long createProject(Project project) {
        Date currentDate = Calendar.getInstance().getTime();
        project.setCreatedOn(currentDate);
//        project.setLastModifiedOn(currentDate);
        Long projectid = this.projectMasterDao.create(project);
        return projectid;
    }

    @Override
    public void deleteProject(Project project) {
        project.setLastModifiedOn(Calendar.getInstance().getTime());
        this.projectMasterDao.delete(project);
    }

    @Override
    public Project retrieveProjectById(Long projectId) {
        return (this.projectMasterDao.retrieveById(projectId));
    }

    @Override
    public Long addMilestoneToProject(ProjectMilestone milestone) {
        if (milestone.getStartDate() == null) {
            milestone.setStartDate(Calendar.getInstance().getTime());
        }
        milestone.setCreatedOn(Calendar.getInstance().getTime());
        milestone.setIsActive(Boolean.TRUE);
        milestone.setIsArchive(Boolean.FALSE);

        return (projectMilestoneDao.create(milestone));
    }

    @Override
    public List<ProjectMilestone> retrieveMilestonesById(Long projectId) {
        return this.projectMilestoneDao.getMilestonesById(projectId);
    }

    @Override
    public List<Project> retrieveProjects() {

        List<Project> result = this.projectMasterDao.retrieveAll();
        return result;
    }

    @Override
    public List<ProjectMilestone> retrieveProjectMilestones() {
        List<ProjectMilestone> projectMilestones = projectMilestoneDao.retrieveAll();

        return projectMilestones;
    }

    @Override
    public void deleteMilestone(ProjectMilestone projectMilestone) {
        projectMilestone.setIsActive(Boolean.FALSE);
        projectMilestoneDao.update(projectMilestone);
    }

    @Override
    public ProjectMilestone retrieveProjectMilestoneById(Long projectMilestoneId) {
        return (projectMilestoneDao.retrieveById(projectMilestoneId));
    }

    @Override
    public void updateProjectMilestone(ProjectMilestone projectMilestone) {
        projectMilestoneDao.update(projectMilestone);
    }

    @Override
    public List<Project> getAllProjects() {
        List<Project> allProjectDetail = projectMasterDao.retrieveAll();

        return allProjectDetail;
    }

    @Override
    public void updateProject(Project project) {

        projectMasterDao.update(project);
    }

    @Override
    public List<ProjectMilestone> retrieveActiveOrInactiveProjectMilestones(Boolean active) {
        return (projectMilestoneDao.getAllActiveOrInactiveMilestones(active));
    }

    @Override
    public List<ProjectMilestone> retrieveMilestoneForSpecificDaysById(Date currdate, Date xDaysAgo, Long projectId, List<Long> projectIds) {
        return projectMilestoneDao.retrieveMilestoneForSpecificDaysById(currdate, xDaysAgo, projectId, projectIds);
    }

    @Override
    public List<Project> retrieveProjectForSpecificDaysById(Date currdate, Date xDaysAgo, List<Long> projectIds, Long projectId) {
        return projectMasterDao.retrieveProjectForSpecificDaysById(currdate, xDaysAgo, projectIds, projectId);
    }

    @Override
    public List<ProjectResourceDetail> retrieveResourceOfSpecificDaysById(Date currdate, Date xDaysAgo, Long projectId, List<Long> projectIds) {
        return projectResourceDetailDao.retrieveResourceForSpecificDaysById(currdate, xDaysAgo, projectId, projectIds);
    }

    @Override
    public List<ProjectTechnologyDetail> retrieveTechnologyOfSpecificDaysById(Date currdate, Date xDaysAgo, Long projectId, List<Long> projectIds) {
        return projectTechnologyDetailDao.retrieveTechnologyForSpecificDaysById(currdate, xDaysAgo, projectId, projectIds);
    }

    @Override
    public List<ProjectResourceDetail> retrieveAllResourceOfSpecificDays(Date currdate, Date xDaysAgo, List<Long> projectIds) {
        return projectResourceDetailDao.retrieveAllResourceForSpecificDays(currdate, xDaysAgo, projectIds);
    }

    @Override
    public List<ProjectTechnologyDetail> retrieveAllTechnologyOfSpecificDays(Date currdate, Date xDaysAgo, List<Long> projectIds) {
        return projectTechnologyDetailDao.retrieveAllTechnologyForSpecificDays(currdate, xDaysAgo, projectIds);
    }

    @Override
    public List<ProjectMilestone> retrieveAllMilestoneForSpecificDays(Date currdate, Date xDaysAgo, List<Long> projectIds) {
        return projectMilestoneDao.retrieveAllMilestoneForSpecificDays(currdate, xDaysAgo, projectIds);
    }

    @Override
    public ProjectResourceDetail retrieveProjectResourceById(Long resourceId) {
        return (projectResourceDetailDao.retrieveById(resourceId));

    }

    @Override
    public ProjectTechnologyDetail retrieveProjectTechnologyById(Long techId) {
        return (projectTechnologyDetailDao.retrieveById(techId));
    }

    @Override
    public List<Project> retrieveAllProjectForSpecificDays(Date currdate, Date xDaysAgo, List<Long> projectIds) {
        return projectMasterDao.retrieveAllProjectForSpecificDays(currdate, xDaysAgo, projectIds);
    }

    @Override
    public List<Project> retieveAllActiveProjectsOfUser(long userId) {
        return projectResourceDetailDao.retieveAllActiveProjectsOfUser(userId);
    }

    @Override
    public List<Project> retrieveAllProjectByIds(String idFeildname, List<Long> ids) {
        return projectMasterDao.retriveByIds("projectId", ids);
    }

    @Override
    public List<ProjectResourceDetail> retrieveProjectResourceByProjectId(Long projectId) {
        return projectResourceDetailDao.getProjectResourceByProjectId(projectId);
    }

    @Override
    public List<ProjectTechnologyDetail> retrieveProjectTechnologyByProjectId(Long projectId) {
        return projectTechnologyDetailDao.getProjectTechnologyByProjectId(projectId);
    }

    @Override
    public void updateProjectResource(ProjectResourceDetail projectResourceDetail) {
        projectResourceDetailDao.update(projectResourceDetail);
    }

    @Override
    public void updateProjectTechnology(ProjectTechnologyDetail projectTechnologyDetail) {
        projectTechnologyDetailDao.update(projectTechnologyDetail);
    }

    @Override
    public List<ProjectMilestone> retrieveCompletedMilestonesById(Long projectId) {
        return this.projectMilestoneDao.getCompletedMilestonesByProjectId(projectId);
    }

    @Override
    public void addProjectAttachment(List<ProjectAttachment> projectAttachments) {
        if (!CollectionUtils.isEmpty(projectAttachments)) {
            System.out.println("projectAttachments in service------>>:" + projectAttachments);
            System.out.println("projectAttachments size in service------>>:" + projectAttachments.size());
            this.projectAttachmentDao.createOrUpdateAll(projectAttachments);
        }
    }

    @Override
    public void deleteProjectAttachment(ProjectAttachment projectAttachment) {
        projectAttachment.setIsActive(Boolean.FALSE);
        projectAttachment.setLstModifiedOn(Calendar.getInstance().getTime());
        projectAttachmentDao.update(projectAttachment);

    }

    @Override
    public List<ProjectAttachment> retrieveProjectAttachmentsByProjectId(Long projectId) {
        return projectAttachmentDao.retrieveAttachmentByProjectId(projectId);
    }

    @Override
    public ProjectAttachment retrieveProjectAttachmentById(Long projectAttachmentId) {
        return (projectAttachmentDao.retrieveById(projectAttachmentId));
    }

//    @Override
//    public void addProjectResourceRoleDetail(List<UserProjectRoleDetail> userProjectRoleDetails) {
//        for (UserProjectRoleDetail userProjectRoleDetail : userProjectRoleDetails) {
//            if (userProjectRoleDetail.getCreatedOn() == null) {
//                userProjectRoleDetail.setCreatedOn(Calendar.getInstance().getTime());
//            }
//            if (userProjectRoleDetail.getLastModifiedOn() == null) {
//                userProjectRoleDetail.setLastModifiedOn(Calendar.getInstance().getTime());
//            }
//            this.userProjectRoleDetailDao.create(userProjectRoleDetail);
//
//        }
//    }
    @Override
    public void assignRoleToResourcesOfProject(List<ProjectResourceDetail> userProjectRoleDetailList) {
        this.projectResourceDetailDao.updateAll(userProjectRoleDetailList);
    }

    @Override
    public ProjectResourceDetail retrieveProjectResourceByUserProjectRoleId(Long id) {
        ProjectResourceDetail userProjectRoleDetail = this.projectResourceDetailDao.retrieveById(id);
        return userProjectRoleDetail;
    }

    @Override
    public void updateProjectResourceRole(ProjectResourceDetail userProjectRoleDetail) {
        if (userProjectRoleDetail.getLastModifiedOn() == null) {
            userProjectRoleDetail.setLastModifiedOn(Calendar.getInstance().getTime());
        }
        projectResourceDetailDao.update(userProjectRoleDetail);
    }

    @Override
    public List<ProjectResourceDetail> retrieveAllResourcesActivityOfCurrentUserByDates(Date startDate, Date endDate, Long userId, List<Long> projectIds) {
        return projectResourceDetailDao.retrieveAllResourcesActivityOfCurrentUserByDates(startDate, endDate, userId, projectIds);
    }

    @Override
    public List<ProjectTechnologyDetail> retrieveAllTechnologyActivityOfCurrentUserByDates(Date startDate, Date endDate, Long userId, List<Long> projectIds) {
        return projectTechnologyDetailDao.retrieveAllTechnologyActivityOfCurrentUserByDates(startDate, endDate, userId, projectIds);
    }

    @Override
    public List<ProjectMilestone> retrieveAllMilestonesActivityOfCurrentUserByDates(Date startDate, Date endDate, Long userId, List<Long> projectIds) {
        return projectMilestoneDao.retrieveAllMilestonesActivityOfCurrentUserByDates(startDate, endDate, userId, projectIds);
    }

    @Override
    public List<ProjectAttachment> retrieveAllProjectAttachmentActivityOfCurrentUserByDates(Date startDate, Date endDate, Long userId, List<Long> projectIds) {
        return projectAttachmentDao.retrieveAllProjectAttachmentActivityOfCurrentUserByDates(startDate, endDate, userId, projectIds);
    }

    @Override
    public Long createRolesOfProject(ProjectRoles projectRoles) {
        projectRoles.setIsArchive(false);
        if (projectRoles.getCreatedOn() == null) {
            projectRoles.setCreatedOn(Calendar.getInstance().getTime());
        }
        if (projectRoles.getLastModifiedOn() == null) {
            projectRoles.setLastModifiedOn(Calendar.getInstance().getTime());
        }
        projectRoles.setLastModifiedOn(projectRoles.getCreatedOn());
        Long projectRolesId = projectRolesDao.create(projectRoles);
        return projectRolesId;
    }

    @Override
    public void updateRolesOfProject(ProjectRoles projectRoles) {
        projectRolesDao.update(projectRoles);
    }

    @Override
    public List<ProjectRoles> retrieveAllRolesOfProject(Boolean status) {
        return projectRolesDao.retrieveAllRolesOfProject(status);
    }

    @Override
    public void deleteRoleOfProject(ProjectRoles projectRoles) {
        projectRolesDao.update(projectRoles);
    }

    @Override
    public ProjectRoles retrieveRoleOfProjectById(Long projectRolesId) {
        return projectRolesDao.retrieveById(projectRolesId);
    }

    @Override
    public List<ProjectResourceDetail> retrieveAllUserProjectRoleDetail() {
        return projectResourceDetailDao.retrieveAll();

    }

    @Override
    public List<ProjectAttachment> retrieveAttachmentOfSpecificDaysById(Date currdate, Date xDaysAgo, Long projectId, List<Long> projectIds) {
        return projectAttachmentDao.retrieveAttachmentOfSpecificDaysById(currdate, xDaysAgo, projectId, projectIds);
    }

    @Override
    public List<ProjectAttachment> retrieveAllAttachmentOfSpecificDays(Date currdate, Date xDaysAgo, List<Long> projectIds) {
        return projectAttachmentDao.retrieveAllAttachmentOfSpecificDays(currdate, xDaysAgo, projectIds);
    }

    @Override
    public List<Project> searchString(String searchString) {
        return projectMasterDao.searchString(searchString);
    }

    @Override
    public Project retrieveProjectByName(String projectName) {
        return projectMasterDao.retrieveprojectByProjectName(projectName);
    }

    @Override
    public List<ProjectResourceDetail> retrieveResourcesOfProjectByUserIds(List userIds, Long projectId) {
        return projectResourceDetailDao.retrieveProjectResourcesByUserIds(userIds, projectId);
    }

    @Override
    public List<Project> retrieveActiveOrInactiveProjects(Boolean active) {
        return (projectMasterDao.retrieveAllActiveOrInactiveProjects(active));

    }

    @Override
    public List<ProjectTechnologyDetail> retrieveResourcesOfProjectByTechIds(List techIds, Long projectId) {
        return projectTechnologyDetailDao.retrieveProjecTechnologiesByTechnologyIds(techIds, projectId);
    }

    @Override
    public boolean isProjectExist(String projectName) {
        Project project = projectMasterDao.retrieveprojectByProjectName(projectName);
        if (project.getProjectName() != null) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }

    }

    @Override
    public boolean isProjectALiasExist(String projectAlias) {
        Project project = projectMasterDao.retrieveprojectByProjectAlias(projectAlias);
        if (project.getProjectAlias() != null) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    
}