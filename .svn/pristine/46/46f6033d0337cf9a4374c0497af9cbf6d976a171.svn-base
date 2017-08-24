/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.servicebean;

import com.argusoft.armms.web.databean.ActivityDataBean;
import com.argusoft.armms.web.transformerbean.ActivityTransformerBean;
import com.argusoft.armms.web.transformerbean.ProjectMilestoneTransformerBean;
import com.argusoft.armms.web.transformerbean.ProjectResourceTransformerBean;
import com.argusoft.armms.web.transformerbean.ProjectTransformerBean;
import com.argusoft.armms.web.transformerbean.TaskTransformerBean;
import com.argusoft.armms.web.usermanagement.databean.MessageDataBean;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.generic.database.exception.GenericDatabaseException;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.apache.lucene.analysis.StopAnalyzer;
import org.hibernate.search.SearchException;

/**
 * methods for showing latest updates on the page
 *
 * @author shreya
 */
@ManagedBean(name = "activityServiceBean")
@RequestScoped
public class ActivityServiceBean {

    @ManagedProperty(value = "#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;

    @ManagedProperty(value = "#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;

    @ManagedProperty(value = "#{taskTransformerBean}")
    private TaskTransformerBean taskTransformerBean;

    @ManagedProperty(value = "#{projectTransformerBean}")
    private ProjectTransformerBean projectTransformerBean;

    @ManagedProperty(value = "#{projectResourceTransformerBean}")
    private ProjectResourceTransformerBean projectResourceTransformerBean;

    @ManagedProperty(value = "#{projectMilestoneTransformerBean}")
    private ProjectMilestoneTransformerBean projectMilestoneTransformerBean;

    @ManagedProperty(value = "#{activityTransformerBean}")
    private ActivityTransformerBean activityTransformerBean;

    @ManagedProperty(value = "#{messageDataBean}")
    private MessageDataBean messageDataBean;

    public SystemResultSessionUtil getSystemResultSessionUtil() {
        return systemResultSessionUtil;
    }

    public void setSystemResultSessionUtil(SystemResultSessionUtil systemResultSessionUtil) {
        this.systemResultSessionUtil = systemResultSessionUtil;
    }

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    public TaskTransformerBean getTaskTransformerBean() {
        return taskTransformerBean;
    }

    public void setTaskTransformerBean(TaskTransformerBean taskTransformerBean) {
        this.taskTransformerBean = taskTransformerBean;
    }

    public ProjectTransformerBean getProjectTransformerBean() {
        return projectTransformerBean;
    }

    public void setProjectTransformerBean(ProjectTransformerBean projectTransformerBean) {
        this.projectTransformerBean = projectTransformerBean;
    }

    public ProjectResourceTransformerBean getProjectResourceTransformerBean() {
        return projectResourceTransformerBean;
    }

    public void setProjectResourceTransformerBean(ProjectResourceTransformerBean projectResourceTransformerBean) {
        this.projectResourceTransformerBean = projectResourceTransformerBean;
    }

    public ProjectMilestoneTransformerBean getProjectMilestoneTransformerBean() {
        return projectMilestoneTransformerBean;
    }

    public void setProjectMilestoneTransformerBean(ProjectMilestoneTransformerBean projectMilestoneTransformerBean) {
        this.projectMilestoneTransformerBean = projectMilestoneTransformerBean;
    }

    public ActivityTransformerBean getActivityTransformerBean() {
        return activityTransformerBean;
    }

    public void setActivityTransformerBean(ActivityTransformerBean activityTransformerBean) {
        this.activityTransformerBean = activityTransformerBean;
    }

    public MessageDataBean getMessageDataBean() {
        return messageDataBean;
    }

    public void setMessageDataBean(MessageDataBean messageDataBean) {
        this.messageDataBean = messageDataBean;
    }

    public void init() throws UMUserManagementException, GenericDatabaseException {
        if (systemResultSessionUtil.getSelectedProjectId() != null && !systemResultSessionUtil.getSelectedProjectId().equals(-1l)) {
            this.retrieveActivityOfSpecificDaysById(systemResultSessionUtil.getSelectedProjectId());
        } else {
            this.retrieveAllActivityOfSpecificDays();
        }

    }

    /**
     * retrieve all activity from different table and generates a single list of
     * all for particular project
     *
     * @author shreya
     */
    public void retrieveActivityOfSpecificDaysById(Long projectId) throws UMUserManagementException, GenericDatabaseException {
        systemResultSessionUtil.setProjectsId(projectId);
        systemResultSessionUtil.setSelectedProjectId(projectId);
        if (projectId == -1) {
            systemResultSessionUtil.setMasterActivityDataBean(activityTransformerBean.retrieveAllActivityOfSpecificDays());
            if (systemResultSessionUtil.getMasterActivityDataBean() == null || systemResultSessionUtil.getMasterActivityDataBean().isEmpty()) {
                messageDataBean.setMessage("No Activity Found for recent project");
                messageDataBean.setIsSuccess(Boolean.FALSE);
            }
        } else {
            systemResultSessionUtil.setMasterActivityDataBean(activityTransformerBean.retrieveActivityOfSpecificDaysById());
            if (systemResultSessionUtil.getMasterActivityDataBean() == null || systemResultSessionUtil.getMasterActivityDataBean().isEmpty()) {
                messageDataBean.setMessage("No Activity Found for recent project");
                messageDataBean.setIsSuccess(Boolean.FALSE);
            }
        }
//        systemResultSessionUtil.setProjectsId(null);
    }

    public String projectSummaryOutcome(Long projectId) throws UMUserManagementException {
        systemResultSessionUtil.setSelectedProjectId(projectId);
        systemResultSessionUtil.setProjectsId(projectId);
        systemResultSessionUtil.setProjectIdForProjectSummary(projectId);
        return "pretty:activity";
    }

    /**
     * retrieve all activity from different table and generates a single list of
     * all containing task of every project
     *
     * @author shreya
     */
    public void retrieveAllActivityOfSpecificDays() throws UMUserManagementException, GenericDatabaseException {

        if (systemResultSessionUtil.getSelectedProjectId() == null || systemResultSessionUtil.getSelectedProjectId().equals(-1l)) {
            systemResultSessionUtil.setMasterActivityDataBean(activityTransformerBean.retrieveAllActivityOfSpecificDays());
            if (systemResultSessionUtil.getMasterActivityDataBean() == null || systemResultSessionUtil.getMasterActivityDataBean().isEmpty()) {
                messageDataBean.setMessage("No Activity Found for recent project");
                messageDataBean.setIsSuccess(Boolean.FALSE);

            }
        } else {
            systemResultSessionUtil.setMasterActivityDataBean(activityTransformerBean.retrieveActivityOfSpecificDaysById());
//            systemResultSessionUtil.setProjectsId(null);
        }

    }

    /**
     * retrieve details of particular activity by their id returns to detail
     * page of that activity
     *
     * @author shreya
     */
    public String retrieveActivityById() throws UMUserManagementException {
        return (activityTransformerBean.retrieveActivityById());

    }

    public void retrieveActivityOfUser() throws UMUserManagementException, GenericDatabaseException {
        systemResultViewUtil.setMasterActivityDataBean(activityTransformerBean.retrieveActivityOfUser());
    }

    public String redirectToProjectSummaryPage() {
        if (systemResultSessionUtil.getSelectedProjectId() == null) {
            systemResultSessionUtil.setSelectedProjectId(systemResultSessionUtil.getProjectsId());
        }
        return "pretty:projectSummary";

    }

    /**
     * @author ravi for searching in webSite
     */
    public void searchString() {
        String searchString = systemResultSessionUtil.getSearchString();
        List<ActivityDataBean> searchResult = new ArrayList<>();

        if (!searchString.equals("")) {

            Set stopwords = StopAnalyzer.ENGLISH_STOP_WORDS_SET;

            Set searchSet = new HashSet();

            String[] split = searchString.split(" ");

            searchSet.addAll(Arrays.asList(split));

            List searchList = new ArrayList(searchSet);

            searchList.removeAll(stopwords);

            searchString = "";

            for (Object search : searchList) {
                searchString = searchString + " " + search.toString();
            }

            if (searchString.equals("")) {
                systemResultViewUtil.setActivityDataBeanList(searchResult);
                messageDataBean.setMessage("Search Text should not include :: " + "a, an, and, are, as, at, be, but, by, for, if, in, into, is, it, no, not, of, on, or, such, that, the, their, then, there, these, they, this, to, was, will, with");
                return;
            }

            try {
                searchResult = activityTransformerBean.searchString(searchString);
            } catch (UMUserManagementException | SearchException ex) {
                Logger.getLogger(ActivityServiceBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (searchResult.isEmpty()) {
                messageDataBean.setMessage("No results for " + searchString);
            }
            systemResultViewUtil.setActivityDataBeanList(searchResult);
        } else {
            systemResultViewUtil.setActivityDataBeanList(searchResult);
            messageDataBean.setMessage("please enter search String");
        }

    }

}
