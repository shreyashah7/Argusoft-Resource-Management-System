/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.database;

import com.argusoft.armms.model.TaskTrack;
import com.argusoft.generic.database.common.GenericDao;
import java.util.List;

/**
 *
 * @author brijesh
 */
public interface TaskTrackDao extends GenericDao<TaskTrack, Long> {

    /**
     * retrieves a list of all the current tasks for which end time is not
     * stored
     *
     * @param currenttasktrck
     * @return
     */
    public List<TaskTrack> retrieveCurrentTaskTrack(Boolean currenttasktrack);

    /**
     * retrieves a list of all the current tasks by task id for which end time
     * is not stored for a particular task
     *
     * @param taskId
     * @return
     */
    public TaskTrack retrieveCurrentTaskTrackById(String taskId);

    public List<TaskTrack> retrieveTaskTrackDetailsByUserAndProjectId(Long userId,Long projectId);
}
