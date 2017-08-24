/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.database;

import com.argusoft.armms.model.Project;
import com.argusoft.armms.model.ProjectResourceDetail;
import com.argusoft.generic.database.common.GenericDao;
import java.util.Date;
import java.util.List;

/**
 * Dao Interface for ProjectResource
 *
 * @author ravi
 * @since 04-MAR-2014
 */
public interface ProjectResourceDetailDao extends GenericDao<ProjectResourceDetail, Long> {

    public List<ProjectResourceDetail> retrieveResources(Long projectId);

    public List<Project> retieveAllActiveProjectsOfUser(long userId);

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
    public List<ProjectResourceDetail> retrieveResourceForSpecificDaysById(Date currdate, Date xDaysAgo, Long projectId, List<Long> projectIds);

    /**
     * to retrieve all resources of specified days from system Configuration
     * table
     *
     * @param currdate
     * @param xDaysAgo configured in system Configuration table
     * @param userId for the user in that project.
     * @return list of object of class ProjectResourceDetail
     */
    public List<ProjectResourceDetail> retrieveAllResourceForSpecificDays(Date currdate, Date xDaysAgo, List<Long> projectIds);

    public List<ProjectResourceDetail> getProjectResourceByProjectId(Long projectId);

    /**
     * retrieveAllResourcesActivityOfCurrentUserByDates retrieves all resources
     * of current user created or modified between dates
     *
     * @author shreya
     * @param startDate
     * @param endDate
     * @param userId
     * @return object of ProjectResourceDetail model
     */
    public List<ProjectResourceDetail> retrieveAllResourcesActivityOfCurrentUserByDates(Date startDate, Date endDate, Long userId,List<Long> projectIds);

    public List<ProjectResourceDetail> retrieveProjectResourcesByUserIds(List userIds, Long ProjectId);
}
