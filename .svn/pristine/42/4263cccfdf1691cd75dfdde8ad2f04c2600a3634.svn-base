/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.transformerbean;

import com.argusoft.armms.core.ProjectService;
import com.argusoft.armms.core.SvnService;
import com.argusoft.armms.core.TaskService;
import com.argusoft.armms.core.UserSkillsService;
import com.argusoft.armms.model.Project;
import com.argusoft.armms.model.ProjectAttachment;
import com.argusoft.armms.model.ProjectMilestone;
import com.argusoft.armms.model.ProjectResourceDetail;
import com.argusoft.armms.model.ProjectTechnologyDetail;
import com.argusoft.armms.model.SvnDetail;
import com.argusoft.armms.model.TaskMaster;
import com.argusoft.armms.web.databean.ActivityDataBean;
import com.argusoft.armms.web.databean.MasterActivityDataBean;
import com.argusoft.armms.web.databean.ProjectDataBean;
import com.argusoft.armms.web.databean.ProjectMilestoneDataBean;
import com.argusoft.armms.web.databean.ProjectResourceDataBean;
import com.argusoft.armms.web.databean.TaskDataBean;
import com.argusoft.armms.web.databean.TechnologyDataBean;
import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import static com.argusoft.armms.web.util.SystemConstantUtil.LATEST_UPDATE_X_DAYS_DEFAULT_VALUE;
import static com.argusoft.armms.web.util.SystemConstantUtil.PROJECT;
import static com.argusoft.armms.web.util.SystemConstantUtil.TASK;
import static com.argusoft.armms.web.util.SystemFunctionUtil.convertToStartDate;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.generic.database.exception.GenericDatabaseException;
import com.argusoft.usermanagement.common.core.UMSystemConfigurationService;
import com.argusoft.usermanagement.common.core.UMUserService;
import com.argusoft.usermanagement.common.database.UMUserDao;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import com.argusoft.usermanagement.common.model.UMSystemConfiguration;
import com.argusoft.usermanagement.common.model.UMUser;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.hibernate.search.SearchException;

/**
 * methods for showing latest updates on the page and converting it into model
 * or databean
 *
 * @author shreya
 */
@ManagedBean(name = "activityTransformerBean")
@RequestScoped
public class ActivityTransformerBean {

    @ManagedProperty(value = "#{activityDataBean}")
    private ActivityDataBean activityDataBean;

    @ManagedProperty(value = "#{loginDataBean}")
    private LoginDataBean loginDataBean;

    @ManagedProperty(value = "#{taskService}")
    private TaskService taskService;

    @ManagedProperty(value = "#{projectService}")
    private ProjectService projectService;

    @ManagedProperty(value = "#{svnService}")
    private SvnService svnService;

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

    @ManagedProperty(value = "#{systemConfigurationService}")
    private UMSystemConfigurationService systemConfigurationService;

    @ManagedProperty(value = "#{userService}")
    private UMUserService userService;

    @ManagedProperty(value = "#{userSkillsService}")
    private UserSkillsService userSkillsService;

    @ManagedProperty(value = "#{taskDataBean}")
    private TaskDataBean taskDataBean;

    @ManagedProperty(value = "#{projectDataBean}")
    private ProjectDataBean projectDataBean;

    @ManagedProperty(value = "#{projectMilestoneDataBean}")
    private ProjectMilestoneDataBean projectMilestoneDataBean;

    @ManagedProperty(value = "#{projectResourceDataBean}")
    private ProjectResourceDataBean projectResourceDataBean;

    @ManagedProperty(value = "#{technologyDataBean}")
    private TechnologyDataBean technologyDataBean;

    @ManagedProperty(value = "#{masterActivityDataBean}")
    private MasterActivityDataBean masterActivityDataBean;

    public static final String MILESTONE = "Milestone";
    public static final String RESOURCE = "Project-Resource";
    public static final String TECHNOLOGY = "Project-Technology";
    public static final String ATTACHMENT = "Attachment";
    public static final String SVN = "SvnDetail";

    public ActivityDataBean getActivityDataBean() {
        return activityDataBean;
    }

    public void setActivityDataBean(ActivityDataBean activityDataBean) {
        this.activityDataBean = activityDataBean;
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

    public ProjectDataBean getProjectDataBean() {
        return projectDataBean;
    }

    public void setProjectDataBean(ProjectDataBean projectDataBean) {
        this.projectDataBean = projectDataBean;
    }

    public ProjectMilestoneDataBean getProjectMilestoneDataBean() {
        return projectMilestoneDataBean;
    }

    public void setProjectMilestoneDataBean(ProjectMilestoneDataBean projectMilestoneDataBean) {
        this.projectMilestoneDataBean = projectMilestoneDataBean;
    }

    public ProjectResourceDataBean getProjectResourceDataBean() {
        return projectResourceDataBean;
    }

    public void setProjectResourceDataBean(ProjectResourceDataBean projectResourceDataBean) {
        this.projectResourceDataBean = projectResourceDataBean;
    }

    public UserSkillsService getUserSkillsService() {
        return userSkillsService;
    }

    public void setUserSkillsService(UserSkillsService userSkillsService) {
        this.userSkillsService = userSkillsService;
    }

    public TechnologyDataBean getTechnologyDataBean() {
        return technologyDataBean;
    }

    public void setTechnologyDataBean(TechnologyDataBean technologyDataBean) {
        this.technologyDataBean = technologyDataBean;
    }

    public LoginDataBean getLoginDataBean() {
        return loginDataBean;
    }

    public void setLoginDataBean(LoginDataBean loginDataBean) {
        this.loginDataBean = loginDataBean;
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    public MasterActivityDataBean getMasterActivityDataBean() {
        return masterActivityDataBean;
    }

    public void setMasterActivityDataBean(MasterActivityDataBean masterActivityDataBean) {
        this.masterActivityDataBean = masterActivityDataBean;
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

    public UMSystemConfigurationService getSystemConfigurationService() {
        return systemConfigurationService;
    }

    public void setSystemConfigurationService(UMSystemConfigurationService systemConfigurationService) {
        this.systemConfigurationService = systemConfigurationService;
    }

    public UMUserService getUserService() {
        return userService;
    }

    public void setUserService(UMUserService userService) {
        this.userService = userService;
    }

    public SvnService getSvnService() {
        return svnService;
    }

    public void setSvnService(SvnService svnService) {
        this.svnService = svnService;
    }

    public ActivityDataBean convertTaskMasterModelToActivityDataBean(TaskMaster taskMasterElement, ActivityDataBean activityDataBeanVar) {
        if (activityDataBeanVar == null) {
            activityDataBeanVar = new ActivityDataBean();
        }
        activityDataBeanVar.setActivityId(taskMasterElement.getTaskId());
        activityDataBeanVar.setActivityName(taskMasterElement.getTaskName());
        if (taskMasterElement.getTaskDescription() != null) {
            activityDataBeanVar.setActivityDesc(taskMasterElement.getTaskDescription());
        } else {
            activityDataBeanVar.setActivityDesc("Not Specified");
        }
        activityDataBeanVar.setCreatedBy(taskMasterElement.getCreatedBy());
        activityDataBeanVar.setCreatedOn(taskMasterElement.getCreatedOn());
        activityDataBeanVar.setLastModifiedBy(taskMasterElement.getLastModifiedBy());
        activityDataBeanVar.setLastModifiedOn(taskMasterElement.getLastModifiedOn());
        activityDataBeanVar.setActivityType(TASK);
        activityDataBeanVar.setProjectId(taskMasterElement.getProjectId().getProjectId());
        activityDataBeanVar.setProjectName(taskMasterElement.getProjectId().getProjectAlias());
        return activityDataBeanVar;
    }

    public ActivityDataBean convertProjectModelToActivityDataBean(Project projectElement, ActivityDataBean activityDataBeanVar) {
        activityDataBeanVar.setActivityId(Long.toString(projectElement.getProjectId()));
        activityDataBeanVar.setActivityName(projectElement.getProjectName());
        activityDataBeanVar.setActivityDesc(projectElement.getProjectDescription());
        activityDataBeanVar.setCreatedBy(projectElement.getCreatedBy());
        activityDataBeanVar.setCreatedOn(projectElement.getCreatedOn());
        activityDataBeanVar.setLastModifiedBy(projectElement.getLastModifiedBy());
        activityDataBeanVar.setLastModifiedOn(projectElement.getLastModifiedOn());
        activityDataBeanVar.setActivityType(PROJECT);
//        activityDataBeanVar.setAssignedTo(projectElement.getProjectManager());
        activityDataBeanVar.setProjectId(projectElement.getProjectId());
        activityDataBeanVar.setProjectName(projectElement.getProjectAlias());
        return activityDataBeanVar;
    }

    public ActivityDataBean convertResourceModelToActivityDataBean(ProjectResourceDetail projectResourceDetailElement, ActivityDataBean activityDataBeanVar) {
        activityDataBeanVar.setActivityId(Long.toString(projectResourceDetailElement.getUserId()));
        if (projectResourceDetailElement.getLastModifiedOn() != null) {
            if (projectResourceDetailElement.getCreatedOn().before(projectResourceDetailElement.getLastModifiedOn())) {
                activityDataBeanVar.setActivityDesc("New user added");
            } else {
                activityDataBeanVar.setActivityDesc("user updated");
            }
        } else {
            activityDataBeanVar.setActivityDesc("New user added");
        }
        activityDataBeanVar.setActivityType(RESOURCE);
        activityDataBeanVar.setCreatedBy(projectResourceDetailElement.getCreatedBy());
        activityDataBeanVar.setCreatedOn(projectResourceDetailElement.getCreatedOn());
        activityDataBeanVar.setLastModifiedBy(projectResourceDetailElement.getLastModifiedBy());
        activityDataBeanVar.setLastModifiedOn(projectResourceDetailElement.getLastModifiedOn());
        activityDataBeanVar.setProjectId(projectResourceDetailElement.getProjectId().getProjectId());
        activityDataBeanVar.setProjectName(projectResourceDetailElement.getProjectId().getProjectAlias());
        return activityDataBeanVar;

    }

    public ActivityDataBean convertTechnologyModelToActivityDataBean(ProjectTechnologyDetail projectTechnologyDetailElement, ActivityDataBean activityDataBeanVar) {
        activityDataBeanVar.setActivityId(Long.toString(projectTechnologyDetailElement.getProjectTechnologyId()));
        activityDataBeanVar.setActivityName(projectTechnologyDetailElement.getTechnologyId().getTechnologyName());
        activityDataBeanVar.setActivityDesc(projectTechnologyDetailElement.getTechnologyId().getTechnologyDesc());
        activityDataBeanVar.setCreatedBy(projectTechnologyDetailElement.getCreatedBy());
        activityDataBeanVar.setCreatedOn(projectTechnologyDetailElement.getCreatedOn());
        activityDataBeanVar.setLastModifiedBy(projectTechnologyDetailElement.getLastModifiedBy());
        activityDataBeanVar.setLastModifiedOn(projectTechnologyDetailElement.getLastModifiedOn());
        activityDataBeanVar.setActivityType(TECHNOLOGY);
        activityDataBeanVar.setProjectId(projectTechnologyDetailElement.getProjectId().getProjectId());
        activityDataBeanVar.setProjectName(projectTechnologyDetailElement.getProjectId().getProjectAlias());
        return activityDataBeanVar;
    }

    public ActivityDataBean convertProjectMilestoneModelToActivityDataBean(ProjectMilestone projectMilestoneElement, ActivityDataBean activityDataBeanVar) {
        activityDataBeanVar.setActivityId(Long.toString(projectMilestoneElement.getProjectMilestoneId()));
        activityDataBeanVar.setActivityName(projectMilestoneElement.getMilestoneName());
        activityDataBeanVar.setActivityDesc(projectMilestoneElement.getMilestoneDescription());
        activityDataBeanVar.setCreatedBy(projectMilestoneElement.getCreatedBy());
        activityDataBeanVar.setCreatedOn(projectMilestoneElement.getCreatedOn());
        activityDataBeanVar.setLastModifiedBy(projectMilestoneElement.getLastModifiedBy());
        activityDataBeanVar.setLastModifiedOn(projectMilestoneElement.getLastModifiedOn());
        activityDataBeanVar.setProjectId(projectMilestoneElement.getProjectId().getProjectId());
        activityDataBeanVar.setProjectName(projectMilestoneElement.getProjectId().getProjectAlias());
        activityDataBeanVar.setActivityType(MILESTONE);
        return activityDataBeanVar;
    }

    public ActivityDataBean convertProjectAttachmentModelToActivityDataBean(ProjectAttachment projectAttachmentElement, ActivityDataBean activityDataBeanVar) {
        activityDataBeanVar.setActivityId(Long.toString(projectAttachmentElement.getProjectAttachmentId()));
        String filename[] = projectAttachmentElement.getProjectAttachmentName().split("#");
        activityDataBeanVar.setActivityName(filename[1]);
        activityDataBeanVar.setCreatedBy(projectAttachmentElement.getUploadedBy());
        activityDataBeanVar.setCreatedOn(projectAttachmentElement.getCreatedOn());
        activityDataBeanVar.setLastModifiedBy(projectAttachmentElement.getLstModifiedBy());
        activityDataBeanVar.setLastModifiedOn(projectAttachmentElement.getLstModifiedOn());
        activityDataBeanVar.setProjectId(projectAttachmentElement.getProjectId().getProjectId());
        activityDataBeanVar.setProjectName(projectAttachmentElement.getProjectId().getProjectAlias());
        activityDataBeanVar.setActivityType(ATTACHMENT);
        return activityDataBeanVar;
    }

    public ActivityDataBean convertsvnDetailModelToActivityDataBean(SvnDetail svnDetail, ActivityDataBean activityData) {
        activityData.setActivityId(Long.toString(svnDetail.getRevisionNo()));
        activityData.setCreatedByName(svnDetail.getCommiter());
        if (svnDetail.getComment() != null) {
            activityData.setActivityDesc(svnDetail.getComment());
        } else {
            activityData.setActivityDesc("Not Specified");
        }
        activityData.setActivityType(SVN);
        return activityData;
    }

    /**
     * retrieves all the list of activity for particular user and for particular
     * project returns list of masteractivityDatabean combining all activity
     *
     * @author shreya
     */
    public List<MasterActivityDataBean> retrieveActivityOfSpecificDaysById() throws UMUserManagementException, GenericDatabaseException {
        Date currdate = new Date();
        Long projectId = null;
        if (systemResultSessionUtil.getProjectsId() != null) {
            projectId = systemResultSessionUtil.getProjectsId();
        } else {
            projectId = systemResultSessionUtil.getSelectedProjectId();
        }
        String toDate;
        UMSystemConfiguration sysConfig = systemConfigurationService.retrieveSystemConfigurationByKey("x-days");
        if (sysConfig == null) {
            toDate = LATEST_UPDATE_X_DAYS_DEFAULT_VALUE;
        } else {
            toDate = sysConfig.getKeyValue();
        }
        Integer days = Integer.parseInt(toDate);
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -(days));
        Date xDaysAgo = cal.getTime();

        List<UMUser> userlist = userService.getAllActiveUsers();

//        Map<String, Object> equalCriteria = new HashMap<>();
//        equalCriteria.put(UMUserDao.IS_ACTIVE, true);
//        equalCriteria.put(UMUserDao.IS_ARCHIVE, false);
//        List<UMUser> userlist = userService.retrieveUsers(null, equalCriteria, null, null, null);
        Map<Long, String> userMap = new HashMap<>();
        for (UMUser userobj : userlist) {
            StringBuffer name = new StringBuffer();
            name.append(userobj.getFirstName());
            if (userobj.getLastName() != null) {
                name.append(" ").append(userobj.getLastName());
            }
            userMap.put(userobj.getId(), name.toString());
        }

        List<ProjectDataBean> retieveAllActiveProjects = new ArrayList<>();
        List<Long> projectIds = new ArrayList<>();
        Long userId = loginDataBean.getId();
        if (loginDataBean.getRole().equals("ROLE_SADMIN")) {
            retieveAllActiveProjects = projectTransformerBean.retrieveAllActiveAndInActiveProjects(Boolean.TRUE);
        } else {
            retieveAllActiveProjects = projectTransformerBean.retrieveAllActiveProjectsOfUser(loginDataBean.getId());
        }
        for (ProjectDataBean projectDataBean : retieveAllActiveProjects) {
            projectIds.add(projectDataBean.getProjectId());
        }
        if (!projectIds.equals(null) && !(projectIds.isEmpty())) {
            List<ActivityDataBean> activityDataBeanList = new ArrayList<>();

            List<ProjectAttachment> projectAttachmentList = projectService.retrieveAttachmentOfSpecificDaysById(currdate, xDaysAgo, projectId, projectIds);
            if (projectAttachmentList != null && !projectAttachmentList.isEmpty()) {
                for (ProjectAttachment projectAttachmentElement : projectAttachmentList) {
                    ActivityDataBean activityDataBeanVar = new ActivityDataBean();
                    activityDataBeanVar = convertProjectAttachmentModelToActivityDataBean(projectAttachmentElement, activityDataBeanVar);
                    activityDataBeanVar.setCreatedByName(userMap.get(projectAttachmentElement.getUploadedBy()));
                    if (projectAttachmentElement.getLstModifiedOn() != null) {
                        if ((projectAttachmentElement.getCreatedOn() == projectAttachmentElement.getLstModifiedOn())) {
                            activityDataBeanVar.setCreatedOrModifiedOn(projectAttachmentElement.getCreatedOn());
                            activityDataBeanVar.setCreatedOrModifiedBy(projectAttachmentElement.getUploadedBy());
                            activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectAttachmentElement.getUploadedBy()));
                        } else {
                            activityDataBeanVar.setCreatedOrModifiedOn(projectAttachmentElement.getLstModifiedOn());
                            activityDataBeanVar.setCreatedOrModifiedBy(projectAttachmentElement.getLstModifiedBy());
                            activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectAttachmentElement.getLstModifiedBy()));
                            activityDataBeanVar.setLastModifiedByName(userMap.get(projectAttachmentElement.getLstModifiedBy()));
                        }
                    } else {
                        activityDataBeanVar.setCreatedOrModifiedOn(projectAttachmentElement.getCreatedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(projectAttachmentElement.getUploadedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectAttachmentElement.getUploadedBy()));
                    }
                    activityDataBeanList.add(activityDataBeanVar);
                }
            }

            //----------->>>>retrieve task of specific days and storing in activity databean------>>>>
            List<TaskMaster> taskMasterList = taskService.retrieveTasksForSpecificDaysById(currdate, xDaysAgo, projectId, userId, projectIds);

            if (taskMasterList != null && !taskMasterList.isEmpty()) {
                for (TaskMaster taskMasterElement : taskMasterList) {
                    ActivityDataBean activityDataBeanVar = new ActivityDataBean();
                    activityDataBeanVar = convertTaskMasterModelToActivityDataBean(taskMasterElement, activityDataBeanVar);
                    activityDataBeanVar.setCreatedByName(userMap.get(taskMasterElement.getCreatedBy()));
                    if (taskMasterElement.getLastModifiedOn() != null) {
                        if ((taskMasterElement.getCreatedOn() == taskMasterElement.getLastModifiedOn())) {
                            activityDataBeanVar.setCreatedOrModifiedOn(taskMasterElement.getCreatedOn());
                            activityDataBeanVar.setCreatedOrModifiedBy(taskMasterElement.getCreatedBy());
                            activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(taskMasterElement.getCreatedBy()));
                        } else {
                            activityDataBeanVar.setCreatedOrModifiedOn(taskMasterElement.getLastModifiedOn());
                            activityDataBeanVar.setCreatedOrModifiedBy(taskMasterElement.getLastModifiedBy());
                            activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(taskMasterElement.getLastModifiedBy()));
                            activityDataBeanVar.setLastModifiedByName(userMap.get(taskMasterElement.getLastModifiedBy()));
                        }
                    } else {
                        activityDataBeanVar.setCreatedOrModifiedOn(taskMasterElement.getCreatedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(taskMasterElement.getCreatedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(taskMasterElement.getCreatedBy()));
                    }
                    activityDataBeanList.add(activityDataBeanVar);
                }
            }
            //----------->>>>retrieve projects of specific days and storing in activity databean------>>>>

            List<Project> projectList = projectService.retrieveProjectForSpecificDaysById(currdate, xDaysAgo, projectIds, projectId);
            for (Project projectElement : projectList) {

                ActivityDataBean activityDataBeanVar = new ActivityDataBean();
                activityDataBeanVar = convertProjectModelToActivityDataBean(projectElement, activityDataBeanVar);

                activityDataBeanVar.setCreatedByName(userMap.get(projectElement.getCreatedBy()));
//            activityDataBeanVar.setAssignedToName(userMap.get(projectElement.getProjectManager()));
                if (projectElement.getLastModifiedOn() != null) {
                    if ((projectElement.getCreatedOn().compareTo(projectElement.getLastModifiedOn())) == 0) {
                        activityDataBeanVar.setCreatedOrModifiedOn(projectElement.getCreatedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(projectElement.getCreatedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectElement.getCreatedBy()));
                    } else {
                        activityDataBeanVar.setCreatedOrModifiedOn(projectElement.getLastModifiedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(projectElement.getLastModifiedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectElement.getLastModifiedBy()));
                        activityDataBeanVar.setLastModifiedByName(userMap.get(projectElement.getLastModifiedBy()));
                    }
                } else {
                    activityDataBeanVar.setCreatedOrModifiedOn(projectElement.getCreatedOn());
                    activityDataBeanVar.setCreatedOrModifiedBy(projectElement.getCreatedBy());
                    activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectElement.getCreatedBy()));
                }

                activityDataBeanList.add(activityDataBeanVar);

            }
            //----------->>>>retrieve project Resource of specific days and storing in activity databean------>>>>

            List<ProjectResourceDetail> resourceDetailList = projectService.retrieveResourceOfSpecificDaysById(currdate, xDaysAgo, projectId, projectIds);

            for (ProjectResourceDetail projectResourceDetailElement : resourceDetailList) {

                ActivityDataBean activityDataBeanVar = new ActivityDataBean();
                activityDataBeanVar = convertResourceModelToActivityDataBean(projectResourceDetailElement, activityDataBeanVar);
                activityDataBeanVar.setActivityName(userMap.get(projectResourceDetailElement.getUserId()));
                activityDataBeanVar.setCreatedByName(userMap.get(projectResourceDetailElement.getCreatedBy()));
                if (projectResourceDetailElement.getLastModifiedOn() != null) {
                    if ((projectResourceDetailElement.getCreatedOn().compareTo(projectResourceDetailElement.getLastModifiedOn())) == 0) {
                        activityDataBeanVar.setCreatedOrModifiedOn(projectResourceDetailElement.getCreatedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(projectResourceDetailElement.getCreatedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectResourceDetailElement.getCreatedBy()));
                    } else {
                        activityDataBeanVar.setCreatedOrModifiedOn(projectResourceDetailElement.getLastModifiedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(projectResourceDetailElement.getLastModifiedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectResourceDetailElement.getLastModifiedBy()));
                        activityDataBeanVar.setLastModifiedByName(userMap.get(projectResourceDetailElement.getLastModifiedBy()));
                    }
                } else {
                    activityDataBeanVar.setCreatedOrModifiedOn(projectResourceDetailElement.getCreatedOn());
                    activityDataBeanVar.setCreatedOrModifiedBy(projectResourceDetailElement.getCreatedBy());
                    activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectResourceDetailElement.getCreatedBy()));
                }
                activityDataBeanList.add(activityDataBeanVar);
            }

//---------------->>>>retrieve project technology of specific days and storing in activity databean------>>>>
            List<ProjectTechnologyDetail> technologyDetailList = projectService.retrieveTechnologyOfSpecificDaysById(currdate, xDaysAgo, projectId, projectIds);

            for (ProjectTechnologyDetail projectTechnologyDetailElement : technologyDetailList) {
                ActivityDataBean activityDataBeanVar = new ActivityDataBean();
                activityDataBeanVar = convertTechnologyModelToActivityDataBean(projectTechnologyDetailElement, activityDataBeanVar);
                activityDataBeanVar.setCreatedByName(userMap.get(projectTechnologyDetailElement.getCreatedBy()));
                if (projectTechnologyDetailElement.getLastModifiedOn() != null) {
                    if ((projectTechnologyDetailElement.getCreatedOn().compareTo(projectTechnologyDetailElement.getLastModifiedOn())) == 0) {
                        activityDataBeanVar.setCreatedOrModifiedOn(projectTechnologyDetailElement.getCreatedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(projectTechnologyDetailElement.getCreatedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectTechnologyDetailElement.getCreatedBy()));
                    } else {
                        activityDataBeanVar.setCreatedOrModifiedOn(projectTechnologyDetailElement.getLastModifiedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(projectTechnologyDetailElement.getLastModifiedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectTechnologyDetailElement.getLastModifiedBy()));
                        activityDataBeanVar.setLastModifiedByName(userMap.get(projectTechnologyDetailElement.getLastModifiedBy()));
                    }
                } else {
                    activityDataBeanVar.setCreatedOrModifiedOn(projectTechnologyDetailElement.getCreatedOn());
                    activityDataBeanVar.setCreatedOrModifiedBy(projectTechnologyDetailElement.getCreatedBy());
                    activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectTechnologyDetailElement.getCreatedBy()));
                }
                activityDataBeanList.add(activityDataBeanVar);
            }

            //---------------->>>>retrieve project milestones of specific days and storing in activity databean------>>>>
            List<ProjectMilestone> projectMilestoneList = projectService.retrieveMilestoneForSpecificDaysById(currdate, xDaysAgo, projectId, projectIds);

            for (ProjectMilestone projectMilestoneElement : projectMilestoneList) {
                ActivityDataBean activityDataBeanVar = new ActivityDataBean();
                activityDataBeanVar = convertProjectMilestoneModelToActivityDataBean(projectMilestoneElement, activityDataBeanVar);
                activityDataBeanVar.setCreatedByName(userMap.get(projectMilestoneElement.getCreatedBy()));
                if (projectMilestoneElement.getLastModifiedOn() != null) {
                    if ((projectMilestoneElement.getCreatedOn().compareTo(projectMilestoneElement.getLastModifiedOn())) == 0) {
                        activityDataBeanVar.setCreatedOrModifiedOn(projectMilestoneElement.getCreatedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(projectMilestoneElement.getCreatedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectMilestoneElement.getCreatedBy()));
                    } else {
                        activityDataBeanVar.setCreatedOrModifiedOn(projectMilestoneElement.getLastModifiedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(projectMilestoneElement.getLastModifiedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectMilestoneElement.getLastModifiedBy()));
                        activityDataBeanVar.setLastModifiedByName(userMap.get(projectMilestoneElement.getLastModifiedBy()));
                    }
                } else {
                    activityDataBeanVar.setCreatedOrModifiedOn(projectMilestoneElement.getCreatedOn());
                    activityDataBeanVar.setCreatedOrModifiedBy(projectMilestoneElement.getCreatedBy());
                    activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectMilestoneElement.getCreatedBy()));
                }
                activityDataBeanList.add(activityDataBeanVar);
            }
            //--------------------------for sorting the list------
            if (activityDataBeanList != null && !activityDataBeanList.isEmpty()) {
                Collections.sort(activityDataBeanList, new Comparator() {

                    @Override
                    public int compare(Object o1, Object o2) {
                        ActivityDataBean label = (ActivityDataBean) o1;
                        ActivityDataBean labelTemp = (ActivityDataBean) o2;
                        return labelTemp.getCreatedOrModifiedOn().compareTo(label.getCreatedOrModifiedOn());
                    }
                });
            }
//------------for converting the list of all activity into masterActivityDataBean-----------------
            Map<Date, List<ActivityDataBean>> activityMap = new HashMap<>();
            List<ActivityDataBean> tempActivityBeanlist = null;
            for (ActivityDataBean activityDataBean : activityDataBeanList) {
                Date changeDate = activityDataBean.getCreatedOrModifiedOn();
                Calendar dateToCalendar = Calendar.getInstance();
                dateToCalendar.setTime(changeDate);
                dateToCalendar.set(Calendar.HOUR_OF_DAY, 0);
                dateToCalendar.set(Calendar.MINUTE, 0);
                dateToCalendar.set(Calendar.SECOND, 0);
                dateToCalendar.set(Calendar.MILLISECOND, 0);
                if (!activityMap.containsKey(dateToCalendar.getTime())) {
                    tempActivityBeanlist = new ArrayList();
                    tempActivityBeanlist.add(activityDataBean);
                    activityMap.put(dateToCalendar.getTime(), tempActivityBeanlist);

                } else {
                    List<ActivityDataBean> tempActivityDataBeanList = activityMap.get(dateToCalendar.getTime());
                    tempActivityDataBeanList.add(activityDataBean);
                    activityMap.put(dateToCalendar.getTime(), tempActivityDataBeanList);
                }
            }
            List<MasterActivityDataBean> masterActivityDataBeanList = new ArrayList();

            if (activityMap != null && !activityMap.isEmpty()) {

                for (Date DisplayDate : activityMap.keySet()) {
                    MasterActivityDataBean masterActivityDataBean = new MasterActivityDataBean();
                    masterActivityDataBean.setDisplayDate(DisplayDate);
                    masterActivityDataBean.setActivityDataBeanViewList(activityMap.get(DisplayDate));
                    masterActivityDataBeanList.add(masterActivityDataBean);
                }
            }
            if (masterActivityDataBeanList != null && !masterActivityDataBeanList.isEmpty()) {
                Collections.sort(masterActivityDataBeanList, new Comparator() {

                    @Override
                    public int compare(Object o1, Object o2) {
                        MasterActivityDataBean label = (MasterActivityDataBean) o1;
                        MasterActivityDataBean labelTemp = (MasterActivityDataBean) o2;
                        return labelTemp.getDisplayDate().compareTo(label.getDisplayDate());
                    }
                });
            }

            return masterActivityDataBeanList;
        } else {
            return null;
        }
    }

    /**
     * retrieves all the list of activity for particular user for all projects
     * passing current dates and x-days from system configuration returns list
     * of masteractivityDatabean combining all activity
     *
     * @author shreya
     */
    public List<MasterActivityDataBean> retrieveAllActivityOfSpecificDays() throws UMUserManagementException, GenericDatabaseException {
        Date currdate = new Date();
        String toDate;
        UMSystemConfiguration sysConfig = systemConfigurationService.retrieveSystemConfigurationByKey("x-days");
        if (sysConfig == null) {
            toDate = LATEST_UPDATE_X_DAYS_DEFAULT_VALUE;
        } else {
            toDate = sysConfig.getKeyValue();
        }
        Integer days = Integer.parseInt(toDate);
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -(days));
        Date xDaysAgo = cal.getTime();

        List<UMUser> userlist = userService.getAllActiveUsers();

        Map<Long, String> userMap = new HashMap<>();
        for (UMUser userobj : userlist) {
            StringBuffer name = new StringBuffer();
            name.append(userobj.getFirstName());
            if (userobj.getLastName() != null) {
                name.append(" ").append(userobj.getLastName());
            }
            userMap.put(userobj.getId(), name.toString());
        }

        List<ProjectDataBean> retieveAllActiveProjects = new ArrayList<>();;
        List<Long> projectIds = new ArrayList<>();
        Long userId = loginDataBean.getId();
        if (loginDataBean.getRole().equals("ROLE_SADMIN")) {
            retieveAllActiveProjects = projectTransformerBean.retrieveAllActiveAndInActiveProjects(Boolean.TRUE);
        } else {
            retieveAllActiveProjects = projectTransformerBean.retrieveAllActiveProjectsOfUser(loginDataBean.getId());
        }
        for (ProjectDataBean projectDataBean : retieveAllActiveProjects) {
            projectIds.add(projectDataBean.getProjectId());
        }
        if (projectIds != null && !(projectIds.isEmpty())) {
            List<ActivityDataBean> activityDataBeanList = new ArrayList<>();

            List<ProjectAttachment> projectAttachmentList = projectService.retrieveAllAttachmentOfSpecificDays(currdate, xDaysAgo, projectIds);
            if (projectAttachmentList != null && !projectAttachmentList.isEmpty()) {
                for (ProjectAttachment projectAttachmentElement : projectAttachmentList) {
                    ActivityDataBean activityDataBeanVar = new ActivityDataBean();
                    activityDataBeanVar = convertProjectAttachmentModelToActivityDataBean(projectAttachmentElement, activityDataBeanVar);
                    activityDataBeanVar.setCreatedByName(userMap.get(projectAttachmentElement.getUploadedBy()));
                    if (projectAttachmentElement.getLstModifiedOn() != null) {
                        if ((projectAttachmentElement.getCreatedOn() == projectAttachmentElement.getLstModifiedOn())) {
                            activityDataBeanVar.setCreatedOrModifiedOn(projectAttachmentElement.getCreatedOn());
                            activityDataBeanVar.setCreatedOrModifiedBy(projectAttachmentElement.getUploadedBy());
                            activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectAttachmentElement.getUploadedBy()));
                        } else {
                            activityDataBeanVar.setCreatedOrModifiedOn(projectAttachmentElement.getLstModifiedOn());
                            activityDataBeanVar.setCreatedOrModifiedBy(projectAttachmentElement.getLstModifiedBy());
                            activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectAttachmentElement.getLstModifiedBy()));
                            activityDataBeanVar.setLastModifiedByName(userMap.get(projectAttachmentElement.getLstModifiedBy()));
                        }
                    } else {
                        activityDataBeanVar.setCreatedOrModifiedOn(projectAttachmentElement.getCreatedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(projectAttachmentElement.getUploadedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectAttachmentElement.getUploadedBy()));
                    }

                    activityDataBeanList.add(activityDataBeanVar);
                }
            }

            // ----------------->>>>retrieve task of specific days and storing in activity databean------>>>>
            List<TaskMaster> taskMasterList = taskService.retrieveAllTasksForSpecificDays(currdate, xDaysAgo, projectIds, userId);

            if (taskMasterList != null && !taskMasterList.isEmpty()) {
                for (TaskMaster taskMasterElement : taskMasterList) {
                    ActivityDataBean activityDataBeanVar = new ActivityDataBean();
                    activityDataBeanVar = convertTaskMasterModelToActivityDataBean(taskMasterElement, activityDataBeanVar);
                    activityDataBeanVar.setCreatedByName(userMap.get(taskMasterElement.getCreatedBy()));
                    if (taskMasterElement.getLastModifiedOn() != null) {
                        if ((taskMasterElement.getCreatedOn() == taskMasterElement.getLastModifiedOn())) {
                            activityDataBeanVar.setCreatedOrModifiedOn(taskMasterElement.getCreatedOn());
                            activityDataBeanVar.setCreatedOrModifiedBy(taskMasterElement.getCreatedBy());
                            activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(taskMasterElement.getCreatedBy()));
                        } else {
                            activityDataBeanVar.setCreatedOrModifiedOn(taskMasterElement.getLastModifiedOn());
                            activityDataBeanVar.setCreatedOrModifiedBy(taskMasterElement.getLastModifiedBy());
                            activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(taskMasterElement.getLastModifiedBy()));
                            activityDataBeanVar.setLastModifiedByName(userMap.get(taskMasterElement.getLastModifiedBy()));
                        }
                    } else {
                        activityDataBeanVar.setCreatedOrModifiedOn(taskMasterElement.getCreatedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(taskMasterElement.getCreatedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(taskMasterElement.getCreatedBy()));
                    }
                    activityDataBeanList.add(activityDataBeanVar);
                }
            }
            //----------->>>>retrieve projects of specific days and storing in activity databean------>>>>

            List<Project> projectList = projectService.retrieveAllProjectForSpecificDays(currdate, xDaysAgo, projectIds);
            for (Project projectElement : projectList) {

                ActivityDataBean activityDataBeanVar = new ActivityDataBean();
                activityDataBeanVar = convertProjectModelToActivityDataBean(projectElement, activityDataBeanVar);
                activityDataBeanVar.setCreatedByName(userMap.get(projectElement.getCreatedBy()));
//            activityDataBeanVar.setAssignedToName(userMap.get(projectElement.getProjectManager()));
                if (projectElement.getLastModifiedOn() != null) {
                    if ((projectElement.getCreatedOn() == projectElement.getLastModifiedOn())) {
                        activityDataBeanVar.setCreatedOrModifiedOn(projectElement.getCreatedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(projectElement.getCreatedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectElement.getCreatedBy()));
                    } else {
                        activityDataBeanVar.setCreatedOrModifiedOn(projectElement.getLastModifiedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(projectElement.getLastModifiedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectElement.getLastModifiedBy()));
                        activityDataBeanVar.setLastModifiedByName(userMap.get(projectElement.getLastModifiedBy()));
                    }
                } else {
                    activityDataBeanVar.setCreatedOrModifiedOn(projectElement.getCreatedOn());
                    activityDataBeanVar.setCreatedOrModifiedBy(projectElement.getCreatedBy());
                    activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectElement.getCreatedBy()));
                }

                activityDataBeanList.add(activityDataBeanVar);

            }
            //----------->>>>retrieve project Resource of specific days and storing in activity databean------>>>>

            List<ProjectResourceDetail> resourceDetailList = projectService.retrieveAllResourceOfSpecificDays(currdate, xDaysAgo, projectIds);

            for (ProjectResourceDetail projectResourceDetailElement : resourceDetailList) {

                ActivityDataBean activityDataBeanVar = new ActivityDataBean();
                activityDataBeanVar.setActivityName(userMap.get(projectResourceDetailElement.getUserId()));
                activityDataBeanVar = convertResourceModelToActivityDataBean(projectResourceDetailElement, activityDataBeanVar);
                activityDataBeanVar.setCreatedByName(userMap.get(projectResourceDetailElement.getCreatedBy()));
                if (projectResourceDetailElement.getLastModifiedOn() != null) {
                    if ((projectResourceDetailElement.getCreatedOn().compareTo(projectResourceDetailElement.getLastModifiedOn())) == 0) {
                        activityDataBeanVar.setCreatedOrModifiedOn(projectResourceDetailElement.getCreatedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(projectResourceDetailElement.getCreatedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectResourceDetailElement.getCreatedBy()));
                    } else {
                        activityDataBeanVar.setCreatedOrModifiedOn(projectResourceDetailElement.getLastModifiedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(projectResourceDetailElement.getLastModifiedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectResourceDetailElement.getLastModifiedBy()));
                        activityDataBeanVar.setLastModifiedByName(userMap.get(projectResourceDetailElement.getLastModifiedBy()));
                    }
                } else {
                    activityDataBeanVar.setCreatedOrModifiedOn(projectResourceDetailElement.getCreatedOn());
                    activityDataBeanVar.setCreatedOrModifiedBy(projectResourceDetailElement.getCreatedBy());
                    activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectResourceDetailElement.getCreatedBy()));
                }

                activityDataBeanList.add(activityDataBeanVar);
            }
            //----------->>>>retrieve project technology of specific days and storing in activity databean------>>>>

            List<ProjectTechnologyDetail> technologyDetailList = projectService.retrieveAllTechnologyOfSpecificDays(currdate, xDaysAgo, projectIds);

            for (ProjectTechnologyDetail projectTechnologyDetailElement : technologyDetailList) {
                ActivityDataBean activityDataBeanVar = new ActivityDataBean();
                activityDataBeanVar = convertTechnologyModelToActivityDataBean(projectTechnologyDetailElement, activityDataBeanVar);
                activityDataBeanVar.setCreatedByName(userMap.get(projectTechnologyDetailElement.getCreatedBy()));
                if (projectTechnologyDetailElement.getLastModifiedOn() != null) {
                    if ((projectTechnologyDetailElement.getCreatedOn().compareTo(projectTechnologyDetailElement.getLastModifiedOn())) == 0) {
                        activityDataBeanVar.setCreatedOrModifiedOn(projectTechnologyDetailElement.getCreatedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(projectTechnologyDetailElement.getCreatedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectTechnologyDetailElement.getCreatedBy()));
                    } else {
                        activityDataBeanVar.setCreatedOrModifiedOn(projectTechnologyDetailElement.getLastModifiedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(projectTechnologyDetailElement.getLastModifiedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectTechnologyDetailElement.getLastModifiedBy()));
                        activityDataBeanVar.setLastModifiedByName(userMap.get(projectTechnologyDetailElement.getLastModifiedBy()));
                    }
                } else {
                    activityDataBeanVar.setCreatedOrModifiedOn(projectTechnologyDetailElement.getCreatedOn());
                    activityDataBeanVar.setCreatedOrModifiedBy(projectTechnologyDetailElement.getCreatedBy());
                    activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectTechnologyDetailElement.getCreatedBy()));
                }
                activityDataBeanList.add(activityDataBeanVar);
            }
            //----------->>>>retrieve project milestones of specific days and storing in activity databean------>>>>

            List<ProjectMilestone> projectMilestoneList = projectService.retrieveAllMilestoneForSpecificDays(currdate, xDaysAgo, projectIds);

            for (ProjectMilestone projectMilestoneElement : projectMilestoneList) {
                ActivityDataBean activityDataBeanVar = new ActivityDataBean();
                activityDataBeanVar = convertProjectMilestoneModelToActivityDataBean(projectMilestoneElement, activityDataBeanVar);
                activityDataBeanVar.setCreatedByName(userMap.get(projectMilestoneElement.getCreatedBy()));
                if (projectMilestoneElement.getLastModifiedOn() != null) {
                    if ((projectMilestoneElement.getCreatedOn().compareTo(projectMilestoneElement.getLastModifiedOn())) == 0) {
                        activityDataBeanVar.setCreatedOrModifiedOn(projectMilestoneElement.getCreatedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(projectMilestoneElement.getCreatedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectMilestoneElement.getCreatedBy()));
                    } else {
                        activityDataBeanVar.setCreatedOrModifiedOn(projectMilestoneElement.getLastModifiedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(projectMilestoneElement.getLastModifiedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectMilestoneElement.getLastModifiedBy()));
                        activityDataBeanVar.setLastModifiedByName(userMap.get(projectMilestoneElement.getLastModifiedBy()));
                    }
                } else {
                    activityDataBeanVar.setCreatedOrModifiedOn(projectMilestoneElement.getCreatedOn());
                    activityDataBeanVar.setCreatedOrModifiedBy(projectMilestoneElement.getCreatedBy());
                    activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectMilestoneElement.getCreatedBy()));
                }
                activityDataBeanList.add(activityDataBeanVar);
            }

            if (activityDataBeanList != null && !activityDataBeanList.isEmpty()) {
                Collections.sort(activityDataBeanList, new Comparator() {

                    @Override
                    public int compare(Object o1, Object o2) {
                        ActivityDataBean label = (ActivityDataBean) o1;
                        ActivityDataBean labelTemp = (ActivityDataBean) o2;
                        return labelTemp.getCreatedOrModifiedOn().compareTo(label.getCreatedOrModifiedOn());
                    }
                });
            }

            Map<Date, List<ActivityDataBean>> activityMap = new HashMap<>();
            List<ActivityDataBean> tempActivityBeanlist = null;
            for (ActivityDataBean activityDataBean : activityDataBeanList) {
                Date changeDate = activityDataBean.getCreatedOrModifiedOn();
                Date modifyDate = convertToStartDate(changeDate);
                if (!activityMap.containsKey(modifyDate)) {
                    tempActivityBeanlist = new ArrayList();
                    tempActivityBeanlist.add(activityDataBean);
                    activityMap.put(modifyDate, tempActivityBeanlist);

                } else {
                    List<ActivityDataBean> tempActivityDataBeanList = activityMap.get(modifyDate);
                    tempActivityDataBeanList.add(activityDataBean);
                    activityMap.put(modifyDate, tempActivityDataBeanList);
                }
            }

            List<MasterActivityDataBean> masterActivityDataBeanList = new ArrayList();

            if (activityMap != null && !activityMap.isEmpty()) {

                for (Date DisplayDate : activityMap.keySet()) {
                    MasterActivityDataBean masterActivityDataBean = new MasterActivityDataBean();
                    masterActivityDataBean.setDisplayDate(DisplayDate);
                    masterActivityDataBean.setActivityDataBeanViewList(activityMap.get(DisplayDate));
                    masterActivityDataBeanList.add(masterActivityDataBean);
                }
            }
            if (masterActivityDataBeanList != null && !masterActivityDataBeanList.isEmpty()) {
                Collections.sort(masterActivityDataBeanList, new Comparator() {

                    @Override
                    public int compare(Object o1, Object o2) {
                        MasterActivityDataBean label = (MasterActivityDataBean) o1;
                        MasterActivityDataBean labelTemp = (MasterActivityDataBean) o2;
                        return labelTemp.getDisplayDate().compareTo(label.getDisplayDate());
                    }
                });
            }
            return masterActivityDataBeanList;
        } else {
            return null;
        }
    }

    /**
     * retrieves details of activity for particular id of activity
     *
     * @author shreya
     */
    public String retrieveActivityById() throws UMUserManagementException {
        String activityId = systemResultSessionUtil.getActivityId();
        String activityType = systemResultSessionUtil.getActivityType();

        if (activityType.equalsIgnoreCase(TASK)) {
            systemResultSessionUtil.setTaskIdForTaskView(activityId);
            return "pretty:TaskViewAndUpdate";
        } else if (activityType.equalsIgnoreCase(PROJECT)) {
            return "pretty:manageProject";
        } else if (activityType.equalsIgnoreCase(TECHNOLOGY)) {
            return "pretty:manageTechnology";
        } else if (activityType.equalsIgnoreCase(MILESTONE)) {
            return "pretty:milestone";
        } else if (activityType.equalsIgnoreCase(ATTACHMENT)) {
            return "pretty:documents";
        } else if (activityType.equalsIgnoreCase(RESOURCE)) {
            return "pretty:userManagement";
        } else {
            return null;
        }

//            TaskMaster taskObj = taskService.retrieveTaskByTaskId(activityId);
//            taskDataBean.setTaskId(taskObj.getTaskId());
//            taskDataBean.setTaskName(taskObj.getTaskName());
//            taskDataBean.setTaskDescription(taskObj.getTaskDescription());
//        } else if (activityType.equalsIgnoreCase(PROJECT)) {
//
//            Long projectId = Long.parseLong(activityId);
//            Project projectObj = projectService.retrieveProjectById(projectId);
//            projectDataBean.setProjectId(projectObj.getProjectId());
//            projectDataBean.setProjectName(projectObj.getProjectName());
//            projectDataBean.setProjectDescription(projectObj.getProjectDescription());
//            projectDataBean.setProjectAlias(projectDataBean.getProjectAlias());
//
//        } else if (activityType.equalsIgnoreCase(TECHNOLOGY)) {
//
//            Long techId = Long.parseLong(activityId);
//            ProjectTechnologyDetail techObj = projectService.retrieveProjectTechnologyById(techId);
//            technologyDataBean.setTechId(techObj.getProjectTechnologyId());
//            technologyDataBean.setName(techObj.getTechnologyId().getTechnologyName());
//            technologyDataBean.setDescription(techObj.getTechnologyId().getTechnologyDesc());
//
//        } else if (activityType.equalsIgnoreCase(MILESTONE)) {
//
//            Long milestoneId = Long.parseLong(activityId);
//            ProjectMilestone projectMilestoneObj = projectService.retrieveProjectMilestoneById(milestoneId);
//            projectMilestoneDataBean.setProjectMilestoneId(projectMilestoneObj.getProjectMilestoneId());
//            projectMilestoneDataBean.setMilestoneName(projectMilestoneObj.getMilestoneName());
//            projectMilestoneDataBean.setMilestoneDesc(projectMilestoneObj.getMilestoneDescription());
//
//        } else {
//            List<UMUser> userlist = userService.getAllActiveUsers();
//
//            Map<Long, String> userMap = new HashMap<>();
//            for (UMUser userobj : userlist) {
//                StringBuffer name = new StringBuffer();
//                name.append(userobj.getFirstName());
//                if (userobj.getLastName() != null) {
//                    name.append(" ").append(userobj.getLastName());
//                }
//                userMap.put(userobj.getId(), name.toString());
//            }
//            Long resourceId = Long.parseLong(activityId);
//            ProjectResourceDetail resourceObj = projectService.retrieveProjectResourceById(resourceId);
//            projectResourceDataBean.setId(resourceObj.getProjectResourceDetailId());
//            projectResourceDataBean.setName(userMap.get(resourceObj.getUserId()));
//            if (resourceObj.getLastModifiedOn() == null) {
//                projectResourceDataBean.setResourceDesc("New User Added");
//            } else {
//                projectResourceDataBean.setResourceDesc("New User Updated");
//            }
//        }
    }

    public List<MasterActivityDataBean> retrieveActivityOfUser() throws UMUserManagementException, GenericDatabaseException {
        Date startDate = null;
        Date endDate = null;
        List<UMUser> userlist = userService.getAllActiveUsers();

        Map<Long, String> userMap = new HashMap<>();
        for (UMUser userobj : userlist) {
            StringBuffer name = new StringBuffer();
            name.append(userobj.getFirstName());
            if (userobj.getLastName() != null) {
                name.append(" ").append(userobj.getLastName());
            }
            userMap.put(userobj.getId(), name.toString());
        }
        Date tempStartDate = activityDataBean.getStartDate();
        if (tempStartDate == null) {
            Calendar cal = GregorianCalendar.getInstance();
            cal.add(Calendar.DAY_OF_YEAR, -(5));
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.SECOND, 0);
            startDate = cal.getTime();
        } else {
            Calendar calStartDate = Calendar.getInstance();
            calStartDate.set(Calendar.MINUTE, 0);
            calStartDate.set(Calendar.HOUR_OF_DAY, 0);
            calStartDate.set(Calendar.SECOND, 0);
            calStartDate.setTime(tempStartDate);
            startDate = calStartDate.getTime();
        }

        Date tempEndDate = activityDataBean.getEndDate();
        if (tempEndDate == null) {
            Calendar cal = GregorianCalendar.getInstance();
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.SECOND, 59);
            endDate = cal.getTime();
        } else {
            Calendar calEndDate = Calendar.getInstance();
            calEndDate.setTime(tempEndDate);
            calEndDate.set(Calendar.MINUTE, 59);
            calEndDate.set(Calendar.HOUR_OF_DAY, 23);
            calEndDate.set(Calendar.SECOND, 59);
            endDate = calEndDate.getTime();
        }
        Long userId = null;
        if (systemResultSessionUtil.getUserId() == loginDataBean.getId()) {
            userId = loginDataBean.getId();
        } else {
            userId = systemResultSessionUtil.getUserId();
        }
        List<Long> projectIds = new ArrayList<>();
        UMUser user = userService.retrieveUserById(userId, null);
        List<Project> retieveAllActiveProjects = new ArrayList<>();
        if (user.getType().equals("ROLE_SADMIN")) {
            retieveAllActiveProjects =projectService.retrieveActiveOrInactiveProjects(true);
        } else {
            retieveAllActiveProjects = projectService.retieveAllActiveProjectsOfUser(userId);
        }
        for (Project projectVar : retieveAllActiveProjects) {
            projectIds.add(projectVar.getProjectId());
        }
        if (projectIds != null && !(projectIds.isEmpty())) {
            List<ActivityDataBean> activityDataBeanList = new ArrayList<>();

            List<ProjectAttachment> projectAttachmentList = projectService.retrieveAllProjectAttachmentActivityOfCurrentUserByDates(startDate, endDate, userId, projectIds);
            if (projectAttachmentList != null && !projectAttachmentList.isEmpty()) {
                for (ProjectAttachment projectAttachmentElement : projectAttachmentList) {
                    ActivityDataBean activityDataBeanVar = new ActivityDataBean();
                    activityDataBeanVar = convertProjectAttachmentModelToActivityDataBean(projectAttachmentElement, activityDataBeanVar);
                    activityDataBeanVar.setCreatedByName(userMap.get(projectAttachmentElement.getUploadedBy()));
                    if (projectAttachmentElement.getLstModifiedOn() != null) {
                        if ((projectAttachmentElement.getCreatedOn().compareTo(projectAttachmentElement.getLstModifiedOn())) == 0) {
                            activityDataBeanVar.setCreatedOrModifiedOn(projectAttachmentElement.getCreatedOn());
                            activityDataBeanVar.setCreatedOrModifiedBy(projectAttachmentElement.getUploadedBy());
                            activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectAttachmentElement.getUploadedBy()));
                        } else {
                            activityDataBeanVar.setCreatedOrModifiedOn(projectAttachmentElement.getLstModifiedOn());
                            activityDataBeanVar.setCreatedOrModifiedBy(projectAttachmentElement.getLstModifiedBy());
                            activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectAttachmentElement.getLstModifiedBy()));
                            activityDataBeanVar.setLastModifiedByName(userMap.get(projectAttachmentElement.getLstModifiedBy()));
                        }
                    } else {
                        activityDataBeanVar.setCreatedOrModifiedOn(projectAttachmentElement.getCreatedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(projectAttachmentElement.getUploadedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectAttachmentElement.getUploadedBy()));
                    }
                    activityDataBeanList.add(activityDataBeanVar);
                }
            }

            List<TaskMaster> taskMasterList = taskService.retrieveAllTaskOfCurrentUserByDates(startDate, endDate, userId, projectIds);
            if (taskMasterList != null && !taskMasterList.isEmpty()) {
                for (TaskMaster taskMasterElement : taskMasterList) {
                    ActivityDataBean activityDataBeanVar = new ActivityDataBean();
                    activityDataBeanVar = convertTaskMasterModelToActivityDataBean(taskMasterElement, activityDataBeanVar);
                    activityDataBeanVar.setCreatedByName(userMap.get(taskMasterElement.getCreatedBy()));
                    if (taskMasterElement.getLastModifiedOn() != null) {
                        if ((taskMasterElement.getCreatedOn().compareTo(taskMasterElement.getLastModifiedOn())) == 0) {
                            activityDataBeanVar.setCreatedOrModifiedOn(taskMasterElement.getCreatedOn());
                            activityDataBeanVar.setCreatedOrModifiedBy(taskMasterElement.getCreatedBy());
                            activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(taskMasterElement.getCreatedBy()));
                        } else {
                            activityDataBeanVar.setCreatedOrModifiedOn(taskMasterElement.getLastModifiedOn());
                            activityDataBeanVar.setCreatedOrModifiedBy(taskMasterElement.getLastModifiedBy());
                            activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(taskMasterElement.getLastModifiedBy()));
                            activityDataBeanVar.setLastModifiedByName(userMap.get(taskMasterElement.getLastModifiedBy()));
                        }
                    } else {
                        activityDataBeanVar.setCreatedOrModifiedOn(taskMasterElement.getCreatedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(taskMasterElement.getCreatedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(taskMasterElement.getCreatedBy()));
                    }
                    activityDataBeanList.add(activityDataBeanVar);
                }
            }

            List<ProjectMilestone> projectMilestoneList = projectService.retrieveAllMilestonesActivityOfCurrentUserByDates(startDate, endDate, userId, projectIds);
            if (projectMilestoneList != null && !projectMilestoneList.isEmpty()) {
                for (ProjectMilestone projectMilestoneElement : projectMilestoneList) {
                    ActivityDataBean activityDataBeanVar = new ActivityDataBean();
                    activityDataBeanVar = convertProjectMilestoneModelToActivityDataBean(projectMilestoneElement, activityDataBeanVar);
                    activityDataBeanVar.setCreatedByName(userMap.get(projectMilestoneElement.getCreatedBy()));
                    if (projectMilestoneElement.getLastModifiedOn() != null) {
                        if ((projectMilestoneElement.getCreatedOn().compareTo(projectMilestoneElement.getLastModifiedOn())) == 0) {
                            activityDataBeanVar.setCreatedOrModifiedOn(projectMilestoneElement.getCreatedOn());
                            activityDataBeanVar.setCreatedOrModifiedBy(projectMilestoneElement.getCreatedBy());
                            activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectMilestoneElement.getCreatedBy()));
                        } else {
                            activityDataBeanVar.setCreatedOrModifiedOn(projectMilestoneElement.getLastModifiedOn());
                            activityDataBeanVar.setCreatedOrModifiedBy(projectMilestoneElement.getLastModifiedBy());
                            activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectMilestoneElement.getLastModifiedBy()));
                            activityDataBeanVar.setLastModifiedByName(userMap.get(projectMilestoneElement.getLastModifiedBy()));
                        }
                    } else {
                        activityDataBeanVar.setCreatedOrModifiedOn(projectMilestoneElement.getCreatedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(projectMilestoneElement.getCreatedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectMilestoneElement.getCreatedBy()));
                    }
                    activityDataBeanList.add(activityDataBeanVar);
                }
            }

            List<ProjectResourceDetail> projectResourceList = projectService.retrieveAllResourcesActivityOfCurrentUserByDates(startDate, endDate, userId, projectIds);
            if (projectResourceList != null && !projectResourceList.isEmpty()) {
                for (ProjectResourceDetail projectResourceDetailElement : projectResourceList) {
                    ActivityDataBean activityDataBeanVar = new ActivityDataBean();
                    activityDataBeanVar.setActivityName(userMap.get(projectResourceDetailElement.getUserId()));
                    activityDataBeanVar = convertResourceModelToActivityDataBean(projectResourceDetailElement, activityDataBeanVar);
                    activityDataBeanVar.setCreatedByName(userMap.get(projectResourceDetailElement.getCreatedBy()));
                    if (projectResourceDetailElement.getLastModifiedOn() != null) {
                        if ((projectResourceDetailElement.getCreatedOn().compareTo(projectResourceDetailElement.getLastModifiedOn())) == 0) {
                            activityDataBeanVar.setCreatedOrModifiedOn(projectResourceDetailElement.getCreatedOn());
                            activityDataBeanVar.setCreatedOrModifiedBy(projectResourceDetailElement.getCreatedBy());
                            activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectResourceDetailElement.getCreatedBy()));
                        } else {
                            activityDataBeanVar.setCreatedOrModifiedOn(projectResourceDetailElement.getLastModifiedOn());
                            activityDataBeanVar.setCreatedOrModifiedBy(projectResourceDetailElement.getLastModifiedBy());
                            activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectResourceDetailElement.getLastModifiedBy()));
                            activityDataBeanVar.setLastModifiedByName(userMap.get(projectResourceDetailElement.getLastModifiedBy()));
                        }
                    } else {
                        activityDataBeanVar.setCreatedOrModifiedOn(projectResourceDetailElement.getCreatedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(projectResourceDetailElement.getCreatedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectResourceDetailElement.getCreatedBy()));
                    }
                    activityDataBeanList.add(activityDataBeanVar);
                }
            }

            List<ProjectTechnologyDetail> projectTechnologyList = projectService.retrieveAllTechnologyActivityOfCurrentUserByDates(startDate, endDate, userId, projectIds);
            if (projectTechnologyList != null && !projectTechnologyList.isEmpty()) {
                for (ProjectTechnologyDetail projectTechnologyDetailElement : projectTechnologyList) {
                    ActivityDataBean activityDataBeanVar = new ActivityDataBean();
                    activityDataBeanVar = convertTechnologyModelToActivityDataBean(projectTechnologyDetailElement, activityDataBeanVar);
                    if (projectTechnologyDetailElement.getLastModifiedOn() != null) {
                        if ((projectTechnologyDetailElement.getCreatedOn().compareTo(projectTechnologyDetailElement.getLastModifiedOn())) == 0) {
                            activityDataBeanVar.setCreatedOrModifiedOn(projectTechnologyDetailElement.getCreatedOn());
                            activityDataBeanVar.setCreatedOrModifiedBy(projectTechnologyDetailElement.getCreatedBy());
                            activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectTechnologyDetailElement.getCreatedBy()));
                        } else {
                            activityDataBeanVar.setCreatedOrModifiedOn(projectTechnologyDetailElement.getLastModifiedOn());
                            activityDataBeanVar.setCreatedOrModifiedBy(projectTechnologyDetailElement.getLastModifiedBy());
                            activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectTechnologyDetailElement.getLastModifiedBy()));
                            activityDataBeanVar.setLastModifiedByName(userMap.get(projectTechnologyDetailElement.getLastModifiedBy()));
                        }
                    } else {
                        activityDataBeanVar.setCreatedOrModifiedOn(projectTechnologyDetailElement.getCreatedOn());
                        activityDataBeanVar.setCreatedOrModifiedBy(projectTechnologyDetailElement.getCreatedBy());
                        activityDataBeanVar.setCreatedOrModifiedByName(userMap.get(projectTechnologyDetailElement.getCreatedBy()));
                    }
                    activityDataBeanList.add(activityDataBeanVar);
                }
            }

            if (activityDataBeanList != null && !activityDataBeanList.isEmpty()) {
                Collections.sort(activityDataBeanList, new Comparator() {

                    @Override
                    public int compare(Object o1, Object o2) {
                        ActivityDataBean label = (ActivityDataBean) o1;
                        ActivityDataBean labelTemp = (ActivityDataBean) o2;
                        return labelTemp.getCreatedOrModifiedOn().compareTo(label.getCreatedOrModifiedOn());
                    }
                });
            }
            Map<Date, List<ActivityDataBean>> activityMap = new HashMap<>();
            List<ActivityDataBean> tempActivityBeanlist = null;
            for (ActivityDataBean activityDataBean : activityDataBeanList) {
                Date changeDate = activityDataBean.getCreatedOrModifiedOn();
                Date modifyDate = convertToStartDate(changeDate);
                if (!activityMap.containsKey(modifyDate)) {
                    tempActivityBeanlist = new ArrayList();
                    tempActivityBeanlist.add(activityDataBean);
                    activityMap.put(modifyDate, tempActivityBeanlist);

                } else {
                    List<ActivityDataBean> tempActivityDataBeanList = activityMap.get(modifyDate);
                    tempActivityDataBeanList.add(activityDataBean);
                    activityMap.put(modifyDate, tempActivityDataBeanList);
                }
            }

            List<MasterActivityDataBean> masterActivityDataBeanList = new ArrayList();

            if (activityMap != null && !activityMap.isEmpty()) {

                for (Date DisplayDate : activityMap.keySet()) {
                    MasterActivityDataBean masterActivityDataBean = new MasterActivityDataBean();
                    masterActivityDataBean.setDisplayDate(DisplayDate);
                    masterActivityDataBean.setActivityDataBeanViewList(activityMap.get(DisplayDate));
                    masterActivityDataBeanList.add(masterActivityDataBean);
                }
            }
            if (masterActivityDataBeanList != null && !masterActivityDataBeanList.isEmpty()) {
                Collections.sort(masterActivityDataBeanList, new Comparator() {

                    @Override
                    public int compare(Object o1, Object o2) {
                        MasterActivityDataBean label = (MasterActivityDataBean) o1;
                        MasterActivityDataBean labelTemp = (MasterActivityDataBean) o2;
                        return labelTemp.getDisplayDate().compareTo(label.getDisplayDate());
                    }
                });
            }
            return masterActivityDataBeanList;
        } else {
            return null;
        }
    }

    public List<ActivityDataBean> searchString(String searchString) throws UMUserManagementException, SearchException {
        List<ActivityDataBean> activityDataBeanList = new ArrayList<>();

        List<TaskMaster> tasks = taskService.searchString(searchString);

        for (TaskMaster taskMaster : tasks) {
            ActivityDataBean activityData = new ActivityDataBean();
            activityData = convertTaskMasterModelToActivityDataBean(taskMaster, activityData);
            activityDataBeanList.add(activityData);
        }

        List<SvnDetail> svnDetails = svnService.searchString(searchString);

        for (SvnDetail svnDetail : svnDetails) {
            ActivityDataBean activityData = new ActivityDataBean();
            activityData = convertsvnDetailModelToActivityDataBean(svnDetail, activityData);
            activityDataBeanList.add(activityData);
        }

        List<Project> projects = projectService.searchString(searchString);

        for (Project project : projects) {
            ActivityDataBean activityData = new ActivityDataBean();
            activityData = convertProjectModelToActivityDataBean(project, activityData);
            activityDataBeanList.add(activityData);
        }

        return activityDataBeanList;

    }

}
