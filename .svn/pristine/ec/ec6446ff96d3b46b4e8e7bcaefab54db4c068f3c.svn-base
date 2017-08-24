/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.argusoft.armms.core;

import com.argusoft.armms.model.Watcher;
import java.util.List;

/**
 *
 * @author shreya
 */

public interface WatcherService {
    
    /**
     * addWatcher method takes a object of WatcherService it
     * @param watcher
     */ 
    public void addWatcher(Watcher watcher);
     
     /**
     * deleteWatcher  method takes a WatcherService as parameter
 it will delete the the WatcherService.
     * @param watcher
     */
     public void deleteWatcher(Watcher watcher);

    /**
     *retrieveWatcherById retrieves WatcherService by
 watchId
     * @param watchId
     * @return
     */
    public Watcher retrieveWatcherById(Long watchId);
    
    public List<Watcher> retrieveWatcherByTaskId(String taskId);
    
    public List<Watcher> retrieveAllWatcherByIds(String idFieldname, List<Long> ids);
}
