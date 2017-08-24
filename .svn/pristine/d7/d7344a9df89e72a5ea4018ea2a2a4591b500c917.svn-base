/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.database;

import com.argusoft.armms.model.ProjectAttachment;
import com.argusoft.generic.database.common.GenericDao;
import java.util.Date;
import java.util.List;

/**
 * Dao methods for project Attachments
 *
 * @author shreya
 */
public interface ProjectAttachmentDao extends GenericDao<ProjectAttachment, Long> {

    /**
     * returns list of attachments related to particular task
     *
     * @author ravi
     * @param projectId
     * @return list of object of ProjectAttachment
     */
    public List<ProjectAttachment> retrieveAttachmentByProjectId(Long projectId);

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
    public List<ProjectAttachment> retrieveAllProjectAttachmentActivityOfCurrentUserByDates(Date startDate, Date endDate, Long userId,List<Long> projectIds);

    /**
     * to retrieve all attachment of specified days from system Configuration
     * table
     *
     * @param currdate
     * @param xDaysAgo configured in system Configuration table
     * @param projectId to obtain attachment of that project only
     * @param projectIds
     * @param userId for the user in that project.
     * @return list of object of class ProjectAttachment
     */
    public List<ProjectAttachment> retrieveAttachmentOfSpecificDaysById(Date currdate, Date xDaysAgo, Long projectId, List<Long> projectIds);

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

}
