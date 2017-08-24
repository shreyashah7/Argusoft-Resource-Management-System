/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.transformerbean;

import com.argusoft.armms.core.ProjectService;
import com.argusoft.armms.core.TaskService;
import com.argusoft.armms.model.Project;
import com.argusoft.armms.model.ProjectResourceDetail;
import com.argusoft.armms.model.TaskMaster;
import com.argusoft.armms.web.databean.ProjectDataBean;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import com.argusoft.armms.web.util.SystemConstantUtil;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.usermanagement.common.core.UMSystemConfigurationService;
import com.argusoft.usermanagement.common.model.UMSystemConfiguration;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Calendar;
import java.util.HashMap;
import org.springframework.util.CollectionUtils;

/**
 *
 * @author brijesh
 */
@ManagedBean(name = "projectSummaryTransformerBean")
@RequestScoped
public class ProjectSummaryTransformerBean {

    @ManagedProperty("#{taskService}")
    private TaskService taskService;
    @ManagedProperty(value = "#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;
    @ManagedProperty(value = "#{projectService}")
    private ProjectService projectService;
    @ManagedProperty(value = "#{projectDataBean}")
    private ProjectDataBean projectDataBean;
    @ManagedProperty(value = "#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;
    @ManagedProperty(value = "#{systemConfigurationService}")
    private UMSystemConfigurationService systemConfigurationService;

    public UMSystemConfigurationService getSystemConfigurationService() {
        return systemConfigurationService;
    }

    public void setSystemConfigurationService(UMSystemConfigurationService systemConfigurationService) {
        this.systemConfigurationService = systemConfigurationService;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public SystemResultSessionUtil getSystemResultSessionUtil() {
        return systemResultSessionUtil;
    }

    public void setSystemResultSessionUtil(SystemResultSessionUtil systemResultSessionUtil) {
        this.systemResultSessionUtil = systemResultSessionUtil;
    }

    public ProjectDataBean getProjectDataBean() {
        return projectDataBean;
    }

    public void setProjectDataBean(ProjectDataBean projectDataBean) {
        this.projectDataBean = projectDataBean;
    }

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * retrieve All Task Of Project For CurrentMonth and than sort them into
     * Four List CreatedTask, WaitingTask, AssignedTask, CompletedTask
     *
     * @author Brijesh
     * @param projectId ,startDate,endDate
     */
    public Map<String, Integer> retrieveAllTaskOfProjectForCurrentMonth(Long projectId, Calendar startDate, Calendar endDate) {
        Map<String, Integer> taskSummary = new LinkedHashMap<>();
        List<TaskMaster> listOfCreatedTaskOfProject = taskService.retrieveTasksOfProjectForCurrentMonth(projectId, startDate, endDate);
        systemResultViewUtil.setMaxYAxis(listOfCreatedTaskOfProject.size());
        List<TaskMaster> listOfWaitingTask = new ArrayList<>();
        List<TaskMaster> listOfAssignedTask = new ArrayList<>();
        List<TaskMaster> listOfCompletedTask = new ArrayList<>();

        taskSummary.put(SystemConstantUtil.CREATED_TASKS, listOfCreatedTaskOfProject.size());

        for (TaskMaster master : listOfCreatedTaskOfProject) {
            if (master.getAssignedTo() == null) {
                listOfWaitingTask.add(master);
                taskSummary.put(SystemConstantUtil.WAITING_TASKS, listOfWaitingTask.size());
            }
            if (master.getAssignedTo() != null) {
                listOfAssignedTask.add(master);
                taskSummary.put(SystemConstantUtil.ASSIGNED_TASKS, listOfAssignedTask.size());
            }
            if (SystemConstantUtil.COMPLETED.equals(master.getTaskStatus()) && master.getAssignedTo() != null) {
                listOfCompletedTask.add(master);
                taskSummary.put(SystemConstantUtil.COMPLETED_TASKS, listOfCompletedTask.size());

            }

        }
        return taskSummary;

    }

    /**
     * resourceStatusChartData method manipulates the status of users by the
     * number of task assigned.
     *
     * @author Niharika
     */
    public void resourceStatusChartData(Long projectId) {
        List<ProjectResourceDetail> resources = projectService.retrieveProjectResourceByProjectId(projectId);
        List<Long> userIds = new ArrayList<>();
        Long overBooked = 0L, underBooked = 0L, normal = 0L, unavailable = 0L;

        UMSystemConfiguration systemconfig = systemConfigurationService.retrieveSystemConfigurationByKey(SystemConstantUtil.MAX_NO_OF_TASK);
        Long maxTask = Long.parseLong(systemconfig.getKeyValue());
        UMSystemConfiguration systemconfiguration = systemConfigurationService.retrieveSystemConfigurationByKey(SystemConstantUtil.MIN_NO_OF_TASK);
        Long minTask = Long.parseLong(systemconfiguration.getKeyValue());
        if (resources != null && !resources.isEmpty()) {
            for (ProjectResourceDetail resource : resources) {
                Long userid = resource.getUserId();
                userIds.add(userid);
            }
            List<TaskMaster> taskList = taskService.retrieveTaskByUserIds(userIds);

            Map<Long, List<TaskMaster>> userTasklistmap = new HashMap();
            for (TaskMaster task : taskList) {
                if (userTasklistmap.containsKey(task.getAssignedTo())) {
                    userTasklistmap.get(task.getAssignedTo()).add(task);
                } else {
                    List<TaskMaster> newtask = new ArrayList<>();
                    newtask.add(task);
                    userTasklistmap.put(task.getAssignedTo(), newtask);
                }

            }
            //to count for users who have not been allocated task.
            for (Long userid : userIds) {
                if (!userTasklistmap.containsKey(userid)) {
                    underBooked++;
                }
            }
            for (Map.Entry<Long, List<TaskMaster>> entry : userTasklistmap.entrySet()) {
                if (entry.getValue().size() > maxTask) {
                    overBooked++;
                }
                if (entry.getValue().size() < minTask) {
                    underBooked++;
                }
                if (entry.getValue().size() <= maxTask && entry.getValue().size() >= minTask) {
                    normal++;
                }

            }
            projectDataBean.setOverBooked(overBooked);
            projectDataBean.setUnderbooked(underBooked);
            projectDataBean.setNormal(normal);
            projectDataBean.setUnavailable(unavailable);
            systemResultViewUtil.setMessageProjectSummary(null);

        } else {
            projectDataBean.setOverBooked(0L);
            projectDataBean.setUnderbooked(0L);
            projectDataBean.setNormal(0L);
            projectDataBean.setUnavailable(0L);

            systemResultViewUtil.setMessageProjectSummary("No resources allocated for current project .");
        }
    }

    /**
     * calculatePercentageCompletionOfProject method calculates percentage
     * completion of each project
     *
     * @author Shifa
     */
    public String calculatePercentageCompletionOfProject() {

        Map< String, Double> projectMap = new HashMap();
        List<Project> activeProjects = projectService.retrieveActiveOrInactiveProjects(true);
        List<TaskMaster> totaltask = taskService.retrieveAllActiveTask();
        if (CollectionUtils.isEmpty(activeProjects) || CollectionUtils.isEmpty(totaltask)) {
            systemResultViewUtil.setProjectErrorMessage("No Active projects or task ");

            return SystemConstantUtil.FAILURE;
        } else {
            Map<Long, List<TaskMaster>> TotalTaskOfProject = new HashMap();
            Map<Long, List<TaskMaster>> CompletedTaskOfProject = new HashMap();

            for (TaskMaster taskmaster : totaltask) {
                if (TotalTaskOfProject.containsKey(taskmaster.getProjectId().getProjectId())) {
                    TotalTaskOfProject.get(taskmaster.getProjectId().getProjectId()).add(taskmaster);
                } else {
                    List<TaskMaster> proj_task = new ArrayList<>();
                    proj_task.add(taskmaster);
                    TotalTaskOfProject.put(taskmaster.getProjectId().getProjectId(), proj_task);
                }
            }
            List<TaskMaster> completedTasks = taskService.retrieveCompletedTasksByProjectId(null);
            for (TaskMaster task : completedTasks) {
                if (CompletedTaskOfProject.containsKey(task.getProjectId().getProjectId())) {
                    CompletedTaskOfProject.get(task.getProjectId().getProjectId()).add(task);
                } else {
                    List<TaskMaster> proj_completed_task = new ArrayList<>();
                    proj_completed_task.add(task);
                    CompletedTaskOfProject.put(task.getProjectId().getProjectId(), proj_completed_task);
                }
            }
            for (Project project : activeProjects) {

                double completed_percent = 0.0;
                List totalTaskByid = TotalTaskOfProject.get(project.getProjectId());

                if (!CollectionUtils.isEmpty(totalTaskByid) && totalTaskByid.size() > 0) {
                    double total_task_count = totalTaskByid.size();
                    List completedTaskByid = CompletedTaskOfProject.get(project.getProjectId());

                    double completed_task_count;
                    if (!CollectionUtils.isEmpty(completedTaskByid) && completedTaskByid.size() > 0) {
                        completed_task_count = completedTaskByid.size();
                    } else {
                        completed_task_count = 0.0;
                    }
                    completed_percent = (completed_task_count / total_task_count);
                    projectMap.put(project.getProjectAlias(), completed_percent);
                    List<ProjectDataBean> projectMapList = new ArrayList<>();
                    for (Map.Entry<String, Double> entry : projectMap.entrySet()) {
                        ProjectDataBean projects = new ProjectDataBean();
                        projects.setCompletion(entry.getValue());
                        projects.setProject(entry.getKey());
                        projectMapList.add(projects);
                    }
                    Gson gson = new GsonBuilder().create();
                    String json = gson.toJson(projectMapList);
                    systemResultViewUtil.setProjectDataForChart(json);

                }
            }
            return SystemConstantUtil.SUCCESS;
        }
    }

}
