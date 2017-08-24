
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.core.impl;

import com.argusoft.armms.core.TaskCommentService;
import com.argusoft.armms.database.TaskCommentDao;
import com.argusoft.armms.model.TaskComment;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author shifa
 */
@Service("taskCommentService")
@Transactional
public class TaskCommentServiceImpl implements TaskCommentService {

    @Autowired
    private TaskCommentDao taskCommentDao;

    @Override
    public Long addComment(TaskComment comment) {

        Date currentDate = Calendar.getInstance().getTime();
        comment.setCreatedOn(currentDate);
        Long commentid = this.taskCommentDao.create(comment);
        return commentid;
    }

    @Override
    public List<TaskComment> retrieveTaskCommentByTaskId(String taskId) {
        return taskCommentDao.retrieveTaskCommentByTaskId(taskId);

    }

    @Override
    public TaskComment retrieveTaskCommentByCommentId(Long commentId) {
        return (taskCommentDao.retrieveById(commentId));
    }

}
