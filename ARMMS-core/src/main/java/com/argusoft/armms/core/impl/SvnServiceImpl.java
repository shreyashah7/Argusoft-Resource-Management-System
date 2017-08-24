/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.core.impl;

import com.argusoft.armms.core.SvnService;
import com.argusoft.armms.database.SvnDetailsDao;
import com.argusoft.armms.model.SvnDetail;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service implementation for SVN
 *
 * @author ravi
 */
@Service("svnService")
@Transactional
public class SvnServiceImpl implements SvnService {

    @Autowired
    private SvnDetailsDao svnDetailsDao;

    @Override
    public void addSvnData(List<SvnDetail> svnDetails) {
        this.svnDetailsDao.saveOrUpdateAll(svnDetails);
    }

    @Override
    public Long retrieveLastupdatedRevisionNumber(Long projectId) {
        return this.svnDetailsDao.retrieveLastupdatedRevisionNumber(projectId);
    }

    @Override
    public List<SvnDetail> retrieveListByProjectId(Long projectId, boolean flag) {
        return this.svnDetailsDao.retrieveListByProjectId(projectId, flag);
    }

    @Override
    public List<SvnDetail> retrieveListById(Long id, boolean flag) {
        return this.svnDetailsDao.retrieveListById(id, flag);
    }

    @Override
    public List<SvnDetail> retrieveListByTaskId(String taskId, boolean flag) {
        return this.svnDetailsDao.retrieveListByTaskId(taskId, flag);
    }

    @Override
    public List<SvnDetail> searchString(String searchString) {
        return svnDetailsDao.searchString(searchString);
    }

}
