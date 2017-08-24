/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.argusoft.armms.database;
import com.argusoft.armms.model.TaskAttachment;
import com.argusoft.generic.database.common.GenericDao;
import java.util.List;
/**
 * Dao for task attachments 
 * @author brijesh
 * @since 04-MAR-2014
 */
public interface TaskAttachmentDao extends GenericDao<TaskAttachment, Long> {

    /**
     * returns list of attachments related to particular task
     * @author ravi
     * @param taskId 
     * @return list of Attachments
     */
    public List<TaskAttachment> retrieveAttachmentByTaskId(String taskId);
    
}
