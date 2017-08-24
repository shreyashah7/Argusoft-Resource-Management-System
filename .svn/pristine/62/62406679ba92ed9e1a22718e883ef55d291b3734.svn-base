/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.database.impl;

import com.argusoft.armms.database.ProjectTechnologyDetailDao;
import com.argusoft.armms.model.ProjectTechnologyDetail;
import com.argusoft.generic.database.common.impl.BaseAbstractGenericDao;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ravi
 * @since 04-MAR-2014
 */
@Repository
public class ProjectTechnologyDetailDaoImpl extends BaseAbstractGenericDao<ProjectTechnologyDetail, Long> implements ProjectTechnologyDetailDao {

    public static final String PROJECT_ID = "projectId";
    public static final String USER_ID = "userId";
    public static final String TECHNOLOGY_ID = "technologyId";
    public static final String TECHNOLOGY_ID_TECHNOLOGY_MASTER = "technologyId.technologyId";
    public static final String PROJECT_ID_PROJECT_MASTER = "projectId.projectId";
    private static final String CREATED_ON = "createdOn";
    private static final String LAST_MODIFIED_ON = "lastModifiedOn";
    private static final String LAST_MODIFIED_BY = "lastModifiedBy";
    private static final String CREATED_BY = "createdBy";
    public static final String ISACTIVE = "isActive";
    public static final String ISARCHIVE = "isArchive";

    @Override
    public List<ProjectTechnologyDetail> retrieveTechnologies(Long projectId) {
        List<Criterion> criterions = new LinkedList();
        criterions.add(Restrictions.eq(PROJECT_ID_PROJECT_MASTER, projectId));
        criterions.add(Restrictions.eq(ISACTIVE, Boolean.TRUE));
        List<ProjectTechnologyDetail> technologies = super.findByCriteriaList(criterions);
        return technologies;
    }

    @Override
    public List<ProjectTechnologyDetail> retrieveTechnologyForSpecificDaysById(Date currdate, Date xDaysAgo, Long projectId, List<Long> projectIds) {
        
        List<ProjectTechnologyDetail> projectTechnologyList = getCurrentSession().createCriteria(ProjectTechnologyDetail.class)
                .setFetchMode(TECHNOLOGY_ID, FetchMode.JOIN)
                .add(Restrictions.in(PROJECT_ID_PROJECT_MASTER, projectIds))
                .add(Restrictions.eq(PROJECT_ID_PROJECT_MASTER, projectId))
                .add(Restrictions.disjunction()
                        .add(Restrictions.between(CREATED_ON, xDaysAgo, currdate))
                        .add(Restrictions.between(LAST_MODIFIED_ON, xDaysAgo, currdate)))
                .list();

        return projectTechnologyList;
    }

    @Override
    public List<ProjectTechnologyDetail> retrieveAllTechnologyForSpecificDays(Date currdate, Date xDaysAgo, List<Long> projectIds) {
        
        List<ProjectTechnologyDetail> projectAllTechnologyList = getCurrentSession().createCriteria(ProjectTechnologyDetail.class)
                .setFetchMode(TECHNOLOGY_ID, FetchMode.JOIN)
                .add(Restrictions.in(PROJECT_ID_PROJECT_MASTER, projectIds))
                .add(Restrictions.disjunction()
                        .add(Restrictions.between(CREATED_ON, xDaysAgo, currdate))
                        .add(Restrictions.between(LAST_MODIFIED_ON, xDaysAgo, currdate)))
                .list();
        return projectAllTechnologyList;
    }

    @Override
    public List<ProjectTechnologyDetail> getProjectTechnologyByProjectId(Long projectId) {
        List<Criterion> criterions = new LinkedList();
        criterions.add(Restrictions.eq(PROJECT_ID_PROJECT_MASTER, projectId));
        List<ProjectTechnologyDetail> technology = super.findByCriteriaList(criterions);
        return technology;
    }

    @Override
    public List<ProjectTechnologyDetail> retrieveAllTechnologyActivityOfCurrentUserByDates(Date startDate, Date endDate, Long userId,List<Long> projectIds) {
        if (endDate == null) {
            endDate = new Date();
        }
        
        List<ProjectTechnologyDetail> projectTechnologyList = getCurrentSession().createCriteria(ProjectTechnologyDetail.class)
                .setFetchMode(TECHNOLOGY_ID, FetchMode.JOIN)
                .add(Restrictions.in(PROJECT_ID_PROJECT_MASTER, projectIds))
                .add(Restrictions.eq(ISACTIVE, Boolean.TRUE))
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

        return projectTechnologyList;
    }

    @Override
    public List<ProjectTechnologyDetail> retrieveProjecTechnologiesByTechnologyIds(List techIds, Long projectId) {
        List<ProjectTechnologyDetail> projectTechnologyDetailList;
        List<Criterion> criterions = new LinkedList();
        if (techIds != null && !techIds.isEmpty()) {
            criterions.add(Restrictions.in(TECHNOLOGY_ID_TECHNOLOGY_MASTER, techIds));
            criterions.add(Restrictions.eq(PROJECT_ID_PROJECT_MASTER, projectId));
        }
        projectTechnologyDetailList = super.findByCriteriaList(criterions);
        return projectTechnologyDetailList;
    }

  
}
