/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.argusoft.armms.core;

import com.argusoft.armms.model.SvnDetail;
import java.util.List;

/**
 * Service interface for SVN
 * @author ravi
 */
public interface SvnService {
    
    /**add the list of data to database
     * @author ravi
     * @param svnDetails list of object of SvnDetail  
     */
    public void addSvnData(List<SvnDetail> svnDetails);

    /**
     * @author ravi
     * @param projectId  
     * @return returns last updated revision number
     */
    public Long retrieveLastupdatedRevisionNumber(Long projectId);

    /**
     * @author ravi
     * @param projectId  
     * @param flag true if you want to retrieve the collection of fileDetails
     * @return list of SvnDetail
     */
    public List<SvnDetail> retrieveListByProjectId(Long projectId,boolean flag);    

    /**
     * @author ravi
     * @param id Record Id in database
     * @param flag true if you want to retrieve the collection of fileDetails
     * @return list of SvnDetail
     */
    public List<SvnDetail> retrieveListById(Long id, boolean flag);
    
    /**
     * @author ravi
     * @param taskId task id
     * @param flag true if you want to retrieve the collection of fileDetails
     * @return list of SvnDetail
     */
    public List<SvnDetail> retrieveListByTaskId(String taskId,boolean flag);    
    
    public List<SvnDetail> searchString(String searchString);
}
