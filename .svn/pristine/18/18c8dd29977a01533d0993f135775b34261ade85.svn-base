/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.core.impl;

import com.argusoft.armms.core.WatcherService;
import com.argusoft.armms.database.WatcherDao;
import com.argusoft.armms.model.Watcher;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 *
 * @author shreya
 */
@Service("watcherService")
@Transactional
public class WatcherServiceImpl implements WatcherService {

    @Autowired
    WatcherDao watcherDao;

    @Override
    public void addWatcher(Watcher watcher) {
        if (watcher != null) {
            watcher.setCreatedOn(Calendar.getInstance().getTime());
            watcher.setIsActive(Boolean.TRUE);
        }
        this.watcherDao.create(watcher);
    }

    @Override
    public void deleteWatcher(Watcher watcher) {
        watcher.setIsActive(Boolean.FALSE);
        watcher.setLstModifiedOn(Calendar.getInstance().getTime());
        watcherDao.update(watcher);
    }

    @Override
    public Watcher retrieveWatcherById(Long watchId) {
        return (watcherDao.retrieveById(watchId));
    }

    @Override
    public List<Watcher> retrieveWatcherByTaskId(String taskId) {
        return watcherDao.retrieveWatcherByTaskId(taskId);
    }

    @Override
    public List<Watcher> retrieveAllWatcherByIds(String idFieldname, List<Long> ids) {
        return watcherDao.retriveByIds("watchId", ids);
    }

}
