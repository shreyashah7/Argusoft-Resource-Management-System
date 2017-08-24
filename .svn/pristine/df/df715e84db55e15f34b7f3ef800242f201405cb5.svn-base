/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.database;

import com.argusoft.armms.model.ProjectTechnologyDetail;
import com.argusoft.generic.database.common.GenericDao;
import java.util.Date;
import java.util.List;

/**
 * Dao Interface for ProjectTechnology
 *
 * @author ravi
 * @since 04-MAR-2014
 */
public interface ProjectTechnologyDetailDao extends GenericDao<ProjectTechnologyDetail, Long> {

    public List<ProjectTechnologyDetail> retrieveTechnologies(Long projectId);

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
    public List<ProjectTechnologyDetail> retrieveTechnologyForSpecificDaysById(Date currdate, Date xDaysAgo, Long projectId, List<Long> projectIds);

    /**
     * to retrieve all Technology of specified days from system Configuration
     * table
     *
     * @param currdate
     * @param xDaysAgo configured in system Configuration table
     * @param userId for the user in that project.
     * @return list of object of class ProjectTechnologyDetail
     */
    public List<ProjectTechnologyDetail> retrieveAllTechnologyForSpecificDays(Date currdate, Date xDaysAgo, List<Long> projectIds);

    public List<ProjectTechnologyDetail> getProjectTechnologyByProjectId(Long projectId);

    /**
     * retrieveAllTechnologyActivityOfCurrentUserByDates retrieves all
     * technology of current user created or modified between dates
     *
     * @author shreya
     * @param startDate
     * @param endDate
     * @param userId
     * @param projectIds
     * @return object of ProjectTechnologyDetail model
     */
    public List<ProjectTechnologyDetail> retrieveAllTechnologyActivityOfCurrentUserByDates(Date startDate, Date endDate, Long userId, List<Long> projectIds);

    public List<ProjectTechnologyDetail> retrieveProjecTechnologiesByTechnologyIds(List techIds, Long projectId);
}
