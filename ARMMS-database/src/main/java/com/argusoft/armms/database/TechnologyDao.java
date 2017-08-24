/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.database;

import com.argusoft.armms.model.TechnologyMaster;
import com.argusoft.generic.database.common.GenericDao;
import java.util.List;

/**
 * Dao Interface for Technology (master Table)
 *
 * @author shifa
 * @since 04-MAR-2014
 */
public interface TechnologyDao extends GenericDao<TechnologyMaster, Long> {

    /**
     * retrieve Technologies and Tool and Server etc..according to
     * Boolean(Active,InActive,All) selected from combo.
     *
     * @author brijesh
     * @param Boolean(true,false,null)
     */
    public List<TechnologyMaster> retrieveAllTechnologies(Boolean active);

    /**
     * set IsActive equal to false when any technology or tool is not require
     *
     * @author brijesh
     * @param id
     */
    public void deleteTechnology(Long id);

    /**
     * getAllTechnologies method retrieves List of all objects of
     * TechnologyMaster by list of id
     *
     * @author niharika
     *
     *
     * @param techIDs
     * @return List of object of TechnologyMaster
     */
    public List<TechnologyMaster> retrieveTechnologiesByTechnologyList(List<Long> techIDs);

    public List<TechnologyMaster> retrieveTechnologiesByTechnologyListAndTechnologyType(List<Long> techIDs, String technologytype);

    /**
     *
     * @param techType
     * @return
     */
    public List<TechnologyMaster> retrieveAllActiveTechnologiesByTechnologyType(String techType);

    /**
     *
     * @param technologyName
     * @return
     */
    public  List<TechnologyMaster> retrieveTechnologiesByTechnologyName(String technologyName);
}
