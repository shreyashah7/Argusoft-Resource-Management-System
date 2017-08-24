/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.database.impl;

import com.argusoft.armms.database.ProjectMilestoneDao;
import com.argusoft.armms.model.ProjectMilestone;
import com.argusoft.armms.model.ProjectResourceDetail;
import com.argusoft.generic.database.common.impl.BaseAbstractGenericDao;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ravi
 * @since 04-MAR-2014
 */
@Repository
public class ProjectMilestoneDaoImpl extends BaseAbstractGenericDao<ProjectMilestone, Long> implements ProjectMilestoneDao {

    public static final String ISACTIVE = "isActive";
    public static final String ISARCHIVE = "isArchive";
    public static final String PROJECT_ID = "projectId.projectId";
    public static final String USER_ID = "userId";
    public static final String PROJECT_ID_PROJECT_MASTER = "projectId.projectId";
    private static final String CREATED_ON = "createdOn";
    private static final String LAST_MODIFIED_ON = "lastModifiedOn";
    private static final String ACTUAL_END_DATE = "actualEndDate";
    private static final String LAST_MODIFIED_BY = "lastModifiedBy";
    private static final String CREATED_BY = "createdBy";

    @Override
    public List<ProjectMilestone> getMilestonesById(Long projectId) {
        List<Criterion> criterions = new LinkedList();
        criterions.add(Restrictions.eq(PROJECT_ID, projectId));
        List<ProjectMilestone> milestones = super.findByCriteriaList(criterions);
        return milestones;
    }

    @Override
    public List<ProjectMilestone> getAllActiveOrInactiveMilestones(Boolean active) {
        List<ProjectMilestone> milestonemaster;
        List<Criterion> criterions = new LinkedList<Criterion>();

        if (active != null) {
            criterions.add(Restrictions.eq(ISACTIVE, active));
        }
        milestonemaster = super.findByCriteriaList(criterions);
        return milestonemaster;
    }

    @Override
    public List<ProjectMilestone> retrieveMilestoneForSpecificDaysById(Date currdate, Date xDaysAgo, Long projectId, List<Long> projectIds) {
        
        List<ProjectMilestone> projectMilestoneList = getCurrentSession().createCriteria(ProjectMilestone.class)
                 .add(Restrictions.in(PROJECT_ID_PROJECT_MASTER, projectIds))
                .add(Restrictions.eq(PROJECT_ID_PROJECT_MASTER, projectId))
                .add(Restrictions.disjunction()
                        .add(Restrictions.between(CREATED_ON, xDaysAgo, currdate))
                        .add(Restrictions.between(LAST_MODIFIED_ON, xDaysAgo, currdate)))
                .list();

        return projectMilestoneList;
    }

    @Override
    public List<ProjectMilestone> retrieveAllMilestoneForSpecificDays(Date currdate, Date xDaysAgo, List<Long> projectIds) {
       
        List<ProjectMilestone> projectMilestoneList = getCurrentSession().createCriteria(ProjectMilestone.class)
                 .add(Restrictions.in(PROJECT_ID_PROJECT_MASTER, projectIds))
                .add(Restrictions.disjunction()
                        .add(Restrictions.between(CREATED_ON, xDaysAgo, currdate))
                        .add(Restrictions.between(LAST_MODIFIED_ON, xDaysAgo, currdate)))
                .list();
        return projectMilestoneList;

    }

    @Override
    public List<ProjectMilestone> getCompletedMilestonesByProjectId(Long projectId) {
        List<Criterion> criterions = new LinkedList();
        if (projectId != null) {
            criterions.add(Restrictions.eq(PROJECT_ID, projectId));
        }
        criterions.add(Restrictions.isNotNull(ACTUAL_END_DATE));
        List<ProjectMilestone> milestones = super.findByCriteriaList(criterions);
        return milestones;
    }

    @Override
    public List<ProjectMilestone> retrieveAllMilestonesActivityOfCurrentUserByDates(Date startDate, Date endDate, Long userId,List<Long> projectIds) {
        if(endDate == null){
            endDate = new Date();
        }
        
        List<ProjectMilestone> projectMilestoneList = getCurrentSession().createCriteria(ProjectMilestone.class)
                .add(Restrictions.in(PROJECT_ID_PROJECT_MASTER, projectIds))
                .add(Restrictions.eq(ISACTIVE, Boolean.TRUE))
                .add(Restrictions.eq(ISARCHIVE, Boolean.FALSE))
                .add(Restrictions.disjunction()
                        .add(Restrictions.conjunction()
                                .add(Restrictions.ge(CREATED_ON, startDate))
                                .add(Restrictions.le(CREATED_ON, endDate)))
                        .add(Restrictions.conjunction()
                                .add(Restrictions.ge(LAST_MODIFIED_ON, startDate))
                                .add(Restrictions.le(LAST_MODIFIED_ON, endDate))))
                .add(Restrictions.disjunction()
                        .add(Restrictions.eq(CREATED_BY, userId))
                        .add(Restrictions.eq(LAST_MODIFIED_BY, userId)))
                .list();
        return projectMilestoneList;
    }

}
