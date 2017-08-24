/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.core;

import com.argusoft.armms.model.TaskComment;
import java.util.List;

/**
 *
 * @author shifa
 */
public interface TaskCommentService {

    /**
     * addComment method creates Comment object
     *
     * @param comment Takes object of class Comment created
     * @return
     */
    public Long addComment(TaskComment comment);

    /**
     * retrieveTaskCommentByTaskId method returns instance of class TaskComment
     * by searching Id
     *
     * @param taskId Takes task id for which we want to get taskComment
     * @return object of class TaskComment correspond to taskId
     */
    public List<TaskComment> retrieveTaskCommentByTaskId(String taskId);

    /**
     * retrieveTaskCommentByCommentId method returns instance of class
     * TaskComment by searching Id
     *
     * @param commentId Takes comment id for which we want to get taskComment
     * @return object of class TaskComment correspond to taskId
     */
    public TaskComment retrieveTaskCommentByCommentId(Long commentId);

}
