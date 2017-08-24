/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.database.impl;

import com.argusoft.armms.database.TechnologyDao;
import com.argusoft.armms.model.TechnologyMaster;
import com.argusoft.generic.database.common.impl.BaseAbstractGenericDao;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Dao Implementation for Technology
 *
 * @author niharika
 * @since 24-MAR-2014
 */
@Repository
public class TechnologyDaoImpl extends BaseAbstractGenericDao<TechnologyMaster, Long> implements TechnologyDao {

    /**
     * Long technologyId
     *
     */
    public final static String TECH_ID = "technologyId";
    /**
     * Boolean isActive
     */
    public final static String ISACTIVE = "isActive";
    public final static String TECH_TYPE = "techType";
    public final static String TECH_NAME = "technologyName";

    @Override
    public List<TechnologyMaster> retrieveAllTechnologies(Boolean active) {
        List<TechnologyMaster> techmaster;
        List<Criterion> criterions = new LinkedList<Criterion>();
        if (active != null) {
            criterions.add(Restrictions.eq(ISACTIVE, active));
        }

        techmaster = super.findByCriteriaList(criterions);
        return techmaster;
    }

    @Override
    public void deleteTechnology(Long id) {

        TechnologyMaster technologyMaster = retrieveById(id);
        technologyMaster.setIsActive(Boolean.FALSE);
        update(technologyMaster);

    }

    @Override
    public List<TechnologyMaster> retrieveTechnologiesByTechnologyList(List<Long> techIDs) {
        List<TechnologyMaster> technologyList;
        List<Criterion> criterions = new LinkedList();
        if (techIDs != null && !techIDs.isEmpty()) {
            criterions.add(Restrictions.in(TECH_ID, techIDs));
        }
        technologyList = super.findByCriteriaList(criterions);
        return technologyList;
    }

    @Override
    public List<TechnologyMaster> retrieveTechnologiesByTechnologyListAndTechnologyType(List<Long> techIDs, String technologytype) {
        List<TechnologyMaster> technologyList;
        List<Criterion> criterions = new LinkedList();
        if (techIDs != null && !techIDs.isEmpty()) {
            criterions.add(Restrictions.in(TECH_ID, techIDs));
            criterions.add(Restrictions.eq(TECH_TYPE, technologytype));
            criterions.add(Restrictions.eq(ISACTIVE, Boolean.TRUE));
        }
        technologyList = super.findByCriteriaList(criterions);
        return technologyList;
    }

    @Override
    public List<TechnologyMaster> retrieveAllActiveTechnologiesByTechnologyType(String techType) {
        List<TechnologyMaster> technologyList;
        List<Criterion> criterions = new LinkedList();
        criterions.add(Restrictions.eq(TECH_TYPE, techType));
        criterions.add(Restrictions.eq(ISACTIVE, Boolean.TRUE));

        technologyList = super.findByCriteriaList(criterions);
        return technologyList;
    }

    @Override
    public List<TechnologyMaster> retrieveTechnologiesByTechnologyName(String technologyName) {
        List<TechnologyMaster> technologyList = null;
        List<Criterion> criterions = new LinkedList();
        criterions.add(Restrictions.eq(TECH_NAME, technologyName));
        criterions.add(Restrictions.eq(ISACTIVE, Boolean.TRUE));

        technologyList = super.findByCriteriaList(criterions);

        return technologyList;
    }

}
