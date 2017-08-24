/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.database.impl;

import com.argusoft.armms.database.SvnDetailsDao;
import com.argusoft.armms.model.SvnDetail;
import com.argusoft.armms.model.SvnFileDetails;
import com.argusoft.generic.database.common.impl.BaseAbstractGenericDao;
import org.hibernate.service.UnknownServiceException;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.Session;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.search.Query;
import java.util.ArrayList;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ravi
 */
@Repository
public class SvnDetailsDaoImpl extends BaseAbstractGenericDao<SvnDetail, Long> implements SvnDetailsDao {

    public static final String ID = "id";
    public static final String TASK_ID = "taskId";
    public static final String PROJECT_ID = "projectId";
    public static final String REVISION_NO = "revisionNo";

    @Override
    public Long retrieveLastupdatedRevisionNumber(Long projectId) {
        List detailList = getCurrentSession().createCriteria(SvnDetail.class)
                .add(Restrictions.eq(PROJECT_ID, projectId))
                .setProjection(Projections.max(REVISION_NO))
                .list();
//        System.out.println("detaillist::::"+detailList);

        if (detailList.get(0) != null) {
            return (Long) detailList.get(0);
        }
        return 0l;
    }

    @Override
    public List<SvnDetail> retrieveListByProjectId(Long projectId, Boolean flag) {
        List<Criterion> criterions = new LinkedList();
        criterions.add(Restrictions.eq(PROJECT_ID, projectId));
        List<SvnDetail> svnDetails = super.findByCriteriaList(criterions);

        if (flag) {
            if (svnDetails != null && !svnDetails.isEmpty()) {
                for (SvnDetail svnDetail : svnDetails) {
                    svnDetail.getSvnFileDetails();
                }
            }
        }
        return svnDetails;
    }

    @Override
    public List<SvnDetail> retrieveListById(Long id, Boolean flag) {
//        System.out.println("in method retrieveList by Id");
        List<Criterion> criterions = new LinkedList();
        criterions.add(Restrictions.eq(ID, id));
        List<SvnDetail> svnDetails = super.findByCriteriaList(criterions);
        if (flag) {
            if (svnDetails != null && !svnDetails.isEmpty()) {
                for (SvnDetail svnDetail : svnDetails) {
                    svnDetail.getSvnFileDetails();
                }
            }
        }
        System.out.println("--file detail in dao--" + svnDetails.get(0).getSvnFileDetails().size());
        return svnDetails;
    }

    @Override
    public List<SvnDetail> retrieveListByTaskId(String taskId, Boolean flag) {
        List<Criterion> criterions = new LinkedList();
        criterions.add(Restrictions.eq(TASK_ID, taskId));
        List<SvnDetail> svnDetails = super.findByCriteriaList(criterions);

        if (flag) {
            if (svnDetails != null && !svnDetails.isEmpty()) {
                for (SvnDetail svnDetail : svnDetails) {
                    List<SvnFileDetails> svnFileDetails = svnDetail.getSvnFileDetails();
                    svnFileDetails.size();
                }
            }
        }
        return svnDetails;
    }

    @Override
    public List<SvnDetail> searchString(String searchString) {
        Session currentSession = getCurrentSession();

        FullTextSession fullTextSession = Search.getFullTextSession(currentSession);

        try {
            fullTextSession.createIndexer(SvnDetail.class).startAndWait();
        } catch (InterruptedException ex) {
            Logger.getLogger(TaskMasterDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        final QueryBuilder qb = fullTextSession.getSearchFactory()
                .buildQueryBuilder().forEntity(SvnDetail.class).get();

        Query luceneQuery = qb
                .keyword()
                .onFields("commiter", "comment")
                .matching(searchString)
                .createQuery();

        org.hibernate.Query fullTextQuery = fullTextSession.createFullTextQuery(luceneQuery);

        List<SvnDetail> result = fullTextQuery.list();

        if (result == null) {
            result = new ArrayList<SvnDetail>();
        }

        return result;

    }

}
