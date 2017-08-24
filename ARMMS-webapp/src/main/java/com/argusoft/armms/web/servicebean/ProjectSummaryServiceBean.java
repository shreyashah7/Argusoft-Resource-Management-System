/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.servicebean;

import com.argusoft.armms.web.databean.TaskDataBean;
import com.argusoft.armms.web.databean.TaskSummaryDataBean;
import com.argusoft.armms.web.transformerbean.ProjectSummaryTransformerBean;
import com.argusoft.armms.web.transformerbean.ProjectTransformerBean;
import com.argusoft.armms.web.usermanagement.databean.MessageDataBean;
import com.argusoft.armms.web.util.SystemConstantUtil;
import java.io.Serializable;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.generic.database.exception.GenericDatabaseException;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author brijesh
 */
@ManagedBean(name = "projectSummaryServiceBean")
@RequestScoped
public class ProjectSummaryServiceBean implements Serializable {

    @ManagedProperty(value = "#{projectSummaryTransformerBean}")
    private ProjectSummaryTransformerBean projectSummaryTransformerBean;
    @ManagedProperty(value = "#{taskDataBean}")
    private TaskDataBean taskDataBean;
    @ManagedProperty(value = "#{projectTransformerBean}")
    private ProjectTransformerBean projectTransformerBean;
    @ManagedProperty(value = "#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;
    @ManagedProperty(value = "#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;
    @ManagedProperty("#{messageDataBean}")
    private MessageDataBean messageDataBean;

    public MessageDataBean getMessageDataBean() {
        return messageDataBean;
    }

    public void setMessageDataBean(MessageDataBean messageDataBean) {
        this.messageDataBean = messageDataBean;
    }

    public SystemResultSessionUtil getSystemResultSessionUtil() {
        return systemResultSessionUtil;
    }

    public void setSystemResultSessionUtil(SystemResultSessionUtil systemResultSessionUtil) {
        this.systemResultSessionUtil = systemResultSessionUtil;
    }

    public TaskDataBean getTaskDataBean() {
        return taskDataBean;
    }

    public void setTaskDataBean(TaskDataBean taskDataBean) {
        this.taskDataBean = taskDataBean;
    }

    public ProjectTransformerBean getProjectTransformerBean() {
        return projectTransformerBean;
    }

    public void setProjectTransformerBean(ProjectTransformerBean projectTransformerBean) {
        this.projectTransformerBean = projectTransformerBean;
    }

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    public ProjectSummaryTransformerBean getProjectSummaryTransformerBean() {
        return projectSummaryTransformerBean;
    }

    public void setProjectSummaryTransformerBean(ProjectSummaryTransformerBean projectSummaryTransformerBean) {
        this.projectSummaryTransformerBean = projectSummaryTransformerBean;
    }

//    /**
//     * Retrieve List Of Active Project for display on comboBoxand by selecting
//     * any one project it will show Bar chart For selected Project
//     *
//     * @author Brijesh
//     * @throws UMUserManagementException
//     */
    public void init() throws UMUserManagementException {

        if (taskDataBean.getProjectId() == null || !taskDataBean.getProjectId().equals(systemResultSessionUtil.getSelectedProjectId())) {
            taskDataBean.setProjectId(systemResultSessionUtil.getSelectedProjectId());
        }
        this.drawChart();
    }

    int getNoOfDaysForCurrentMonth() {
        int actualDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int noOfDays = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
        Calendar.getInstance().set(Calendar.DAY_OF_MONTH, actualDay);
        return noOfDays;
    }

    /**
     * for rendering charts of different selected projects .
     */
    public void drawChart() {

        this.drawBarChartForTaskSummary();
        this.resourceStatusChartData();
        this.calculatePercentageCompletionOfProject();
    }

    /**
     * Draw Bar Chart For No Of Task Created in current Month Of Selected
     * Project.
     *
     * @author Brijesh
     */
    public void drawBarChartForTaskSummary() {

        int currMonth = Calendar.getInstance().get(Calendar.MONTH);
        int currYear = Calendar.getInstance().get(Calendar.YEAR);
        int noOfDaysCurrentMonth = this.getNoOfDaysForCurrentMonth();

        Calendar startDate = Calendar.getInstance();
        startDate.set(currYear, currMonth, 1, 0, 0, 0);
        Calendar endDate = Calendar.getInstance();
        endDate.set(currYear, currMonth, noOfDaysCurrentMonth, 23, 59, 59);

        Map<String, Integer> taskSummaryMap = new LinkedHashMap<>();
        if (taskDataBean.getProjectId() != null) {
            taskSummaryMap = projectSummaryTransformerBean.retrieveAllTaskOfProjectForCurrentMonth(taskDataBean.getProjectId(), startDate, endDate);
        }
        List<TaskSummaryDataBean> taskSummarylist = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : taskSummaryMap.entrySet()) {
            TaskSummaryDataBean summary = new TaskSummaryDataBean();
            summary.setName(entry.getKey());
            summary.setValue(entry.getValue());
            taskSummarylist.add(summary);
        }

        // convert List of TaskSummaryDataBean object into Jason Object 
        Gson gson = new GsonBuilder().create();
        String taskSummary = gson.toJson(taskSummarylist);
        systemResultViewUtil.setTaskSummary(taskSummary);

    }

    /**
     * resourceStatusChartData method manipulates the status of users by the
     * number of task assigned.
     *
     * @author Niharika
     */
    public void resourceStatusChartData() {
        if (taskDataBean.getProjectId() != null) {
            projectSummaryTransformerBean.resourceStatusChartData(taskDataBean.getProjectId());
        }
    }

    /**
     * calculatePercentageCompletionOfProject method calculates percentage
     * completion of each project
     *
     * @author Shifa
     */
    public void calculatePercentageCompletionOfProject() {
        if(taskDataBean.getProjectId() != null)
        {
        String result = projectSummaryTransformerBean.calculatePercentageCompletionOfProject();
        if (SystemConstantUtil.FAILURE.equalsIgnoreCase(result)) {
            messageDataBean.setIsSuccess(Boolean.FALSE);
            messageDataBean.setMessage(" No Projects");

        } else {
            messageDataBean.setIsSuccess(Boolean.TRUE);
        }
        }
    }

}
