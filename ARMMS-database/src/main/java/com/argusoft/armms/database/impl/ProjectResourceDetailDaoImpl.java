/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.database.impl;

import com.argusoft.armms.database.ProjectResourceDetailDao;
import com.argusoft.armms.model.Project;
import com.argusoft.armms.model.ProjectResourceDetail;
import com.argusoft.generic.database.common.impl.BaseAbstractGenericDao;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Property;
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
public class ProjectResourceDetailDaoImpl extends BaseAbstractGenericDao<ProjectResourceDetail, Long> implements ProjectResourceDetailDao {

    public static final String PROJECT_ID = "projectId";
    public static final String USER_ID = "userId";
    public static final String PROJECT_ID_PROJECT_MASTER = "projectId.projectId";
    private static final String CREATED_ON = "createdOn";
    private static final String LAST_MODIFIED_ON = "lastModifiedOn";
    private static final String LAST_MODIFIED_BY = "lastModifiedBy";
    private static final String CREATED_BY = "createdBy";
    public static final String ISACTIVE = "isActive";
    public static final String ISARCHIVE = "isArchive";
    public static final String ASSIGNED_TO = "assignedTo";

    @Override
    public List<ProjectResourceDetail> retrieveResources(Long projId) {
        List<Criterion> criterions = new LinkedList();
        criterions.add(Restrictions.eq(PROJECT_ID, projId));
        List<ProjectResourceDetail> resources = super.findByCriteriaList(criterions);
        return resources;
    }

    @Override
    public List<ProjectResourceDetail> retrieveResourceForSpecificDaysById(Date currdate, Date xDaysAgo, Long projectId, List<Long> projectIds) {
        
        List<ProjectResourceDetail> projectResourceList = getCurrentSession().createCriteria(ProjectResourceDetail.class)
                .add(Restrictions.in(PROJECT_ID_PROJECT_MASTER, projectIds))
                .add(Restrictions.eq(PROJECT_ID_PROJECT_MASTER, projectId))
                .add(Restrictions.disjunction()
                        .add(Restrictions.between(CREATED_ON, xDaysAgo, currdate))
                        .add(Restrictions.between(LAST_MODIFIED_ON, xDaysAgo, currdate)))
                .list();
        return projectResourceList;
    }

    @Override
    public List<ProjectResourceDetail> retrieveAllResourceForSpecificDays(Date currdate, Date xDaysAgo, List<Long> projectIds) {
       
        List<ProjectResourceDetail> projectAllResourceList = getCurrentSession().createCriteria(ProjectResourceDetail.class)
                .add(Restrictions.in(PROJECT_ID_PROJECT_MASTER, projectIds))
                .add(Restrictions.disjunction()
                        .add(Restrictions.between(CREATED_ON, xDaysAgo, currdate))
                        .add(Restrictions.between(LAST_MODIFIED_ON, xDaysAgo, currdate)))
                .list();
        return projectAllResourceList;
    }

    @Override
    public List<Project> retieveAllActiveProjectsOfUser(long userId) {
        DetachedCriteria subquery = DetachedCriteria.forClass(ProjectResourceDetail.class)
                .add(Restrictions.eq(USER_ID, userId))
                .setProjection(Projections.property(PROJECT_ID_PROJECT_MASTER).as(PROJECT_ID));
        List<Project> result = getCurrentSession().createCriteria(Project.class)
                .add(Property.forName(PROJECT_ID).in(subquery))
                .list();
        
        return result;
    }

    @Override
    public List<ProjectResourceDetail> getProjectResourceByProjectId(Long projectId) {
        List<Criterion> criterions = new LinkedList();
        criterions.add(Restrictions.eq(PROJECT_ID_PROJECT_MASTER, projectId));
        criterions.add(Restrictions.eq(ISACTIVE, Boolean.TRUE));
        List<ProjectResourceDetail> projectResource = super.findByCriteriaList(criterions);
        return projectResource;
    }

    @Override
    public List<ProjectResourceDetail> retrieveAllResourcesActivityOfCurrentUserByDates(Date startDate, Date endDate, Long userId,List<Long> projectIds) {
        Date currDate = new Date();
        if (endDate == null) {
            endDate = new Date();
        }
        List<ProjectResourceDetail> projectResourceList = getCurrentSession().createCriteria(ProjectResourceDetail.class)
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
        return projectResourceList;
    }

    @Override
    public List<ProjectResourceDetail> retrieveProjectResourcesByUserIds(List userIds, Long projectId) {

        List<ProjectResourceDetail> userProjectRoleDetailList;
        List<Criterion> criterions = new LinkedList();
        if (userIds != null && !userIds.isEmpty()) {
            criterions.add(Restrictions.in(USER_ID, userIds));
            criterions.add(Restrictions.eq(PROJECT_ID_PROJECT_MASTER, projectId));
        }
        userProjectRoleDetailList = super.findByCriteriaList(criterions);
        return userProjectRoleDetailList;
    }
}
