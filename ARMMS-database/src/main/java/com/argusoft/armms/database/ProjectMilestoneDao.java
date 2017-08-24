/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.database;

import com.argusoft.armms.model.ProjectMilestone;
import com.argusoft.generic.database.common.GenericDao;
import java.util.Date;
import java.util.List;

/**
 * Dao Interface for ProjectMilestone
 *
 * @author ravi
 * @since 04-MAR-2014
 */
public interface ProjectMilestoneDao extends GenericDao<ProjectMilestone, Long> {

    /**
     * Get list of milestone by project ID
     *
     * @param projectId
     * @return list of milestones
     */
    public List<ProjectMilestone> getMilestonesById(Long projectId);

    /**
     *
     * @param active
     * @return
     */
    public List<ProjectMilestone> getAllActiveOrInactiveMilestones(Boolean active);

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
     * Get list of completed milestones by project ID
     *
     * @param projectId
     * @return list of completed milestones corresponding to projectId
     */
    public List<ProjectMilestone> getCompletedMilestonesByProjectId(Long projectId);

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
    public List<ProjectMilestone> retrieveAllMilestonesActivityOfCurrentUserByDates(Date startDate, Date endDate, Long userId,List<Long> projectIds);
}
