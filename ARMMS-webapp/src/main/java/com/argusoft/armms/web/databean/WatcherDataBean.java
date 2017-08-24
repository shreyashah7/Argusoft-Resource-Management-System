/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.argusoft.armms.web.databean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author shreya
 */
@ManagedBean(name = "watcherDataBean")
@RequestScoped
public class WatcherDataBean {
    
    private Long watchId;
    private Long watcherId;
    private String watcherName;
    private String taskId;

    public Long getWatchId() {
        return watchId;
    }

    public void setWatchId(Long watchId) {
        this.watchId = watchId;
    }

    public Long getWatcherId() {
        return watcherId;
    }

    public void setWatcherId(Long watcherId) {
        this.watcherId = watcherId;
    }

    public String getWatcherName() {
        return watcherName;
    }

    public void setWatcherName(String watcherName) {
        this.watcherName = watcherName;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "WatcherDataBean{" + "watchId=" + watchId + ", watcherId=" + watcherId + ", watcherName=" + watcherName + ", taskId=" + taskId + '}';
    }

    
}
