/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.database.impl;

import com.argusoft.armms.database.ProjectAttachmentDao;
import static com.argusoft.armms.database.impl.ProjectMilestoneDaoImpl.PROJECT_ID;
import com.argusoft.armms.model.ProjectAttachment;
import com.argusoft.armms.model.ProjectResourceDetail;
import com.argusoft.generic.database.common.impl.BaseAbstractGenericDao;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

/**
 *
 * @author shreya
 */
@Repository
public class ProjectAttachmentDaoImpl extends BaseAbstractGenericDao<ProjectAttachment, Long> implements ProjectAttachmentDao {

    public static final String FOREIGN_KEY_PROJECT_ID = "projectId.projectId";
    public static final String IS_ACTIVE = "isActive";
    public static final String UPLOADED_BY = "uploadedBy";
    private static final String LAST_MODIFIED_ON = "lstModifiedOn";
    private static final String LAST_MODIFIED_BY = "lstModifiedBy";
    private static final String CREATED_ON = "createdOn";
    public static final String ISACTIVE = "isActive";
    public static final String ISARCHIVE = "isArchive";
    public static final String USER_ID = "userId";

    @Override
    public List<ProjectAttachment> retrieveAttachmentByProjectId(Long projectId) {
        List<Criterion> criterions = new LinkedList<Criterion>();
        if (projectId != null) {
            criterions.add(Restrictions.eq(FOREIGN_KEY_PROJECT_ID, projectId));
        }
        criterions.add(Restrictions.eq(IS_ACTIVE, Boolean.TRUE));
        List<ProjectAttachment> listOfProjectAttachments = super.findByCriteriaList(criterions);
        return listOfProjectAttachments;
    }

    @Override
    public List<ProjectAttachment> retrieveAllProjectAttachmentActivityOfCurrentUserByDates(Date startDate, Date endDate, Long userId,List<Long> projectIds) {
        if(endDate == null){
            endDate = new Date();
        }
        System.out.println(startDate+":end:"+endDate);
        List<ProjectAttachment> projectAttachmentList = getCurrentSession().createCriteria(ProjectAttachment.class)
                .add(Restrictions.in(FOREIGN_KEY_PROJECT_ID, projectIds))
                .add(Restrictions.eq(ISACTIVE, Boolean.TRUE))
                .add(Restrictions.disjunction()
                        .add(Restrictions.conjunction()
                                .add(Restrictions.ge(CREATED_ON, startDate))
                                .add(Restrictions.le(CREATED_ON, endDate)))
                        .add(Restrictions.conjunction()
                                .add(Restrictions.ge(LAST_MODIFIED_ON, startDate))
                                .add(Restrictions.le(LAST_MODIFIED_ON, endDate))))
                .add(Restrictions.disjunction()
                        .add(Restrictions.eq(UPLOADED_BY, userId))
                        .add(Restrictions.eq(LAST_MODIFIED_BY, userId)))
                .list();
        return projectAttachmentList;
    }

    @Override
    public List<ProjectAttachment> retrieveAttachmentOfSpecificDaysById(Date currdate, Date xDaysAgo, Long projectId, List<Long> projectIds) {
        
        List<ProjectAttachment> projectAttachmentList = getCurrentSession().createCriteria(ProjectAttachment.class)
                 .add(Restrictions.in(FOREIGN_KEY_PROJECT_ID, projectIds))
                .add(Restrictions.eq(FOREIGN_KEY_PROJECT_ID, projectId))
                .add(Restrictions.disjunction()
                        .add(Restrictions.between(CREATED_ON, xDaysAgo, currdate))
                        .add(Restrictions.between(LAST_MODIFIED_ON, xDaysAgo, currdate)))
                .list();

        return projectAttachmentList;
    }

    @Override
    public List<ProjectAttachment> retrieveAllAttachmentOfSpecificDays(Date currdate, Date xDaysAgo, List<Long> projectIds) {
        
        List<ProjectAttachment> projectAttachmentList = getCurrentSession().createCriteria(ProjectAttachment.class)
                .add(Restrictions.in(FOREIGN_KEY_PROJECT_ID, projectIds))
                .add(Restrictions.disjunction()
                        .add(Restrictions.between(CREATED_ON, xDaysAgo, currdate))
                        .add(Restrictions.between(LAST_MODIFIED_ON, xDaysAgo, currdate)))
                .list();
        return projectAttachmentList;
    }

}
