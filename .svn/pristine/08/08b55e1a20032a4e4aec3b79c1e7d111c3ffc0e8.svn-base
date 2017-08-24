/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.database;

import com.argusoft.armms.model.SvnDetail;
import com.argusoft.generic.database.common.GenericDao;
import java.util.List;

/**
 *
 * @author ravi
 */
public interface SvnDetailsDao extends GenericDao<SvnDetail, Long> {

    /**
     * retrieve last updated revision number of particular project
     *
     * @param projectId project Id
     * @return last updated revision number
     */
    public Long retrieveLastupdatedRevisionNumber(Long projectId);

    /**
     *
     * @param projectId
     * @param flag true if you want to retrieve the collection of fileDetails
     * @return list of SvnDetail
     */
    public List<SvnDetail> retrieveListByProjectId(Long projectId, Boolean flag);

    /**
     *
     * @param id Record Id in database
     * @param flag true if you want to retrieve the collection of fileDetails
     * @return list of SvnDetail
     */
    public List<SvnDetail> retrieveListById(Long id, Boolean flag);

    /**
     *
     * @param taskId task id
     * @param flag true if you want to retrieve the collection of fileDetails
     * @return list of SvnDetail
     */
    public List<SvnDetail> retrieveListByTaskId(String taskId, Boolean flag);
    
    public List<SvnDetail> searchString(String searchString);
}
