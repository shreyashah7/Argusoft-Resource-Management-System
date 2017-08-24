/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.database;

import com.argusoft.armms.model.Project;
import com.argusoft.generic.database.common.GenericDao;
import java.util.Date;
import java.util.List;

/**
 * Dao Interface for Project (master Table)
 *
 * @author ravi
 * @since 04-MAR-2014
 */
public interface ProjectDao extends GenericDao<Project, Long> {

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

    public List<Project> searchString(String searchString);

    public Project retrieveprojectByProjectName(String projectName);

    public Project retrieveprojectByProjectAlias(String projectAlias);

    /**
     * to retrieve all active or inactive projects
     *
     * @param active
     *
     * @return list of object of class Project
     */
    public List<Project> retrieveAllActiveOrInactiveProjects(Boolean active);
}
