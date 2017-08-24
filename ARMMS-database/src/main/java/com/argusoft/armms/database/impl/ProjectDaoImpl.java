/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.database.impl;

import com.argusoft.armms.database.ProjectDao;
import com.argusoft.armms.model.Project;
import com.argusoft.armms.model.ProjectResourceDetail;
import com.argusoft.armms.model.TaskMaster;
import com.argusoft.generic.database.common.impl.BaseAbstractGenericDao;
import com.argusoft.generic.database.config.SQLDatabaseApplicationConfig;
import org.hibernate.service.UnknownServiceException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.web.WebAppConfiguration;
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
 * @since 04-MAR-2014
 */
@Repository
public class ProjectDaoImpl extends BaseAbstractGenericDao<Project, Long> implements ProjectDao {

    private static final String CREATED_ON = "createdOn";
    private static final String LAST_MODIFIED_ON = "lastModifiedOn";
    private static final String FOREIGN_KEY_PROJECT = "projectId.projectId";
    private static final String PROJECT_ID = "projectId";
    private static final String USER_ID = "userId";
    private static final String PROJECT_NAME = "projectName";
    private static final String PROJECT_ALIAS = "projectAlias";
    public static final String ISACTIVE = "isActive";

    @Override
    public List<Project> retrieveProjectForSpecificDaysById(Date currdate, Date xDaysAgo, List<Long> projectIds, Long projectId) {

        List<Project> projectList = getCurrentSession().createCriteria(Project.class)
                .add(Restrictions.in(PROJECT_ID, projectIds))
                .add(Restrictions.eq(PROJECT_ID, projectId))
                .add(Restrictions.disjunction()
                        .add(Restrictions.between(CREATED_ON, xDaysAgo, currdate))
                        .add(Restrictions.between(LAST_MODIFIED_ON, xDaysAgo, currdate)))
                .list();
        return projectList;
    }

    @Override
    public List<Project> retrieveAllProjectForSpecificDays(Date currdate, Date xDaysAgo, List<Long> projectIds) {

        List<Project> projectList = getCurrentSession().createCriteria(Project.class)
                .add(Restrictions.in(PROJECT_ID, projectIds))
                .add(Restrictions.disjunction()
                        .add(Restrictions.between(CREATED_ON, xDaysAgo, currdate))
                        .add(Restrictions.between(LAST_MODIFIED_ON, xDaysAgo, currdate)))
                .list();
        return projectList;
    }

    @Override
    public List<Project> searchString(String searchString) {
        Session currentSession = getCurrentSession();

        FullTextSession fullTextSession = Search.getFullTextSession(currentSession);

        try {
            fullTextSession.createIndexer(Project.class).startAndWait();
        } catch (InterruptedException ex) {
            Logger.getLogger(TaskMasterDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        final QueryBuilder qb = fullTextSession.getSearchFactory()
                .buildQueryBuilder().forEntity(Project.class).get();

        Query luceneQuery = qb
                .keyword()
                .onFields("projectName", "projectAlias", "projectDescription")
                .matching(searchString)
                .createQuery();

        org.hibernate.Query fullTextQuery = fullTextSession.createFullTextQuery(luceneQuery);

        List<Project> result = fullTextQuery.list();

        if (result == null) {
            result = new ArrayList<Project>();
        }

        return result;

    }

    @Override
    public Project retrieveprojectByProjectName(String projectName) {
        List<Criterion> criterions = new LinkedList<Criterion>();
        criterions.add(Restrictions.eq(PROJECT_NAME, projectName));
        List<Project> projectList = super.findByCriteriaList(criterions);
        Project project = new Project();
        if (!projectList.isEmpty()) {
            project = projectList.get(0);
        }
        return project;
    }

    @Override
    public List<Project> retrieveAllActiveOrInactiveProjects(Boolean active) {
        List<Project> projectmaster;
        List<Criterion> criterions = new LinkedList<Criterion>();
        if (active != null) {
            criterions.add(Restrictions.eq(ISACTIVE, active));
        }
        projectmaster = super.findByCriteriaList(criterions);
        return projectmaster;
    }

    @Override
    public Project retrieveprojectByProjectAlias(String projectAlias) {
        List<Criterion> criterions = new LinkedList<Criterion>();
        criterions.add(Restrictions.eq(PROJECT_ALIAS, projectAlias));
        List<Project> projectList = super.findByCriteriaList(criterions);
        Project project = new Project();
        if (!projectList.isEmpty()) {
            project = projectList.get(0);
        }
        return project;
    }

}
