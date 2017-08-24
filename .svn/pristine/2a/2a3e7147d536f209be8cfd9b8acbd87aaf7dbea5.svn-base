/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.argusoft.armms.web.databean;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * for storing details of a specific SVN revision
 * @author ravi
 */
@ManagedBean(name = "svnDataBean")
@RequestScoped
public class SvnDataBean {
    
    private Long id;
    private Long projectId;
    private Long revisionNo;
    private String taskId;
    private Date commitedOn;
    private String comments;
    private String Commiter;
    private List<SvnFileDataBean> svnFileDataBeans;

    public List<SvnFileDataBean> getSvnFileDataBeans() {
        return svnFileDataBeans;
    }

    public void setSvnFileDataBeans(List<SvnFileDataBean> svnFileDataBeans) {
        this.svnFileDataBeans = svnFileDataBeans;
    }
    
    
    public Long getProjectId() {
        return projectId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
    
    public Long getRevisionNo() {
        return revisionNo;
    }

    public void setRevisionNo(Long revisionNo) {
        this.revisionNo = revisionNo;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Date getCommitedOn() {
        return commitedOn;
    }

    public void setCommitedOn(Date commitedOn) {
        this.commitedOn = commitedOn;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCommiter() {
        return Commiter;
    }

    public void setCommiter(String Commiter) {
        this.Commiter = Commiter;
    }

    @Override
    public String toString() {
        return "SvnDataBean{" + "projectId=" + projectId + ", revisionNo=" + revisionNo + ", taskId=" + taskId + ", commitedOn=" + commitedOn + ", comments=" + comments + ", Commiter=" + Commiter + '}';
    }

            
    
}
