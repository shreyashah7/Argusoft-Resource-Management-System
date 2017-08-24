/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.transformerbean;

import com.argusoft.armms.core.ProjectService;
import com.argusoft.armms.core.UserSkillsService;
import com.argusoft.armms.model.Project;
import com.argusoft.armms.model.ProjectResourceDetail;
import com.argusoft.armms.model.ProjectRoles;
import com.argusoft.armms.model.ProjectTechnologyDetail;
import com.argusoft.armms.model.TechnologyMaster;
//import com.argusoft.armms.model.UserProjectRoleDetail;
import com.argusoft.armms.web.databean.ProjectResourceDataBean;
import com.argusoft.armms.web.databean.ProjectRolesDataBean;
import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import com.argusoft.armms.web.util.SystemConstantUtil;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.generic.database.common.GenericDao.QueryOperators;
import com.argusoft.generic.database.exception.GenericDatabaseException;
import com.argusoft.usermanagement.common.core.UMSystemConfigurationService;
import com.argusoft.usermanagement.common.core.UMUserService;
import com.argusoft.usermanagement.common.database.UMUserDao;
import com.argusoft.usermanagement.common.model.UMUser;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author niharika
 */
@ManagedBean(name = "projectResourceTransformerBean")
@RequestScoped
public class ProjectResourceTransformerBean {

    @ManagedProperty("#{userSkillsService}")
    private UserSkillsService userSkillsService;
    @ManagedProperty("#{loginDataBean}")
    private LoginDataBean loginDataBean;
    @ManagedProperty(value = "#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;
    @ManagedProperty(value = "#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;
    @ManagedProperty(value = "#{systemConfigurationService}")
    private UMSystemConfigurationService systemConfigurationService;
    @ManagedProperty(value = "#{userService}")
    private UMUserService userService;
    @ManagedProperty(value = "#{projectService}")
    private ProjectService projectService;
    @ManagedProperty(value = "#{projectResourceDataBean}")
    private ProjectResourceDataBean projectResourceDataBean;

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

    public LoginDataBean getLoginDataBean() {
        return loginDataBean;
    }

    public void setLoginDataBean(LoginDataBean loginDataBean) {
        this.loginDataBean = loginDataBean;
    }

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

    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * @author Brijesh
     * @param resourceDataBean
     * @param userIDs
     * @param roleType
     * @return
     * @throws GenericDatabaseException
     */
    public String addResourcesToProject(ProjectResourceDataBean resourceDataBean, List<Long> userIDs, Long roleType) throws GenericDatabaseException {
        Project project = projectService.retrieveProjectById(systemResultViewUtil.getProjectId());
        List<ProjectResourceDetail> resourceDetails = new ArrayList<>();
        Map<QueryOperators, Object> criteria = new HashMap<>();
        Map<String, Object> in = new HashMap<>();
        Map<String, Object> equal = new HashMap<>();

        in.put(UMUserDao.ID, userIDs);
        criteria.put(QueryOperators.IN, in);

        equal.put(UMUserDao.IS_ACTIVE, Boolean.TRUE);
        criteria.put(QueryOperators.EQUAL, equal);

        List<UMUser> userDetails = userService.retrieveUsers(null, criteria, null);

        if ((userIDs != null && !userIDs.isEmpty())) {
            for (UMUser user : userDetails) {
                ProjectResourceDetail resource = new ProjectResourceDetail();
                resource.setCreatedBy(loginDataBean.getId());
                resource.setCreatedOn(new Date());
                resource.setIsActive(user.getIsActive());
                resource.setIsArchive(user.getIsArchive());
                resource.setProjectId(project);
                resource.setUserId(user.getId());
                resource.setStartDate(project.getStartDate());
                resource.setEndDate(project.getEstimatedEndDate());
                if (roleType == null) {
                    resource.setProjectRoleId(-1l);
                } else {
                    resource.setProjectRoleId(roleType);
                }
                resource.setLastModifiedBy(loginDataBean.getId());
                resourceDetails.add(resource);
            }
            projectService.addResourcesToProject(resourceDetails);
            return SystemConstantUtil.SUCCESS;
        } else {
            return SystemConstantUtil.FAILURE; //to check if no resource is selected.
        }
    }

    /**
     * Method Is used to Retrieve Resources which are allocated to Project and
     * add the resources which have selected Role Type in one List
     *
     * @author Brijesh
     * @param projectId
     * @param roleType
     * @return
     * @throws GenericDatabaseException
     */
    public List<ProjectResourceDataBean> retrieveResourcesOfProjectByRoleType(Long projectId, Long roleType) throws GenericDatabaseException {

        List<ProjectResourceDataBean> allProjectResourceDataBeanList = new ArrayList<>();
        List<UMUser> uMUsersList = userService.retrieveUsers(null, null, null);
        for (UMUser uMUser : uMUsersList) {
            ProjectResourceDataBean projectResourceDataBean = new ProjectResourceDataBean();
            projectResourceDataBean.setUserId(uMUser.getId());
            projectResourceDataBean.setUserName(uMUser.getFirstName() + " " + uMUser.getLastName());
            allProjectResourceDataBeanList.add(projectResourceDataBean);
        }
        if (projectId != null) {

            List<ProjectResourceDetail> projectRoleDetailList = projectService.retrieveProjectResourceByProjectId(projectId);
            List userIds = new ArrayList<>();

            Map<Long, ProjectResourceDataBean> map = new HashMap();

            for (ProjectResourceDetail projectRoleDetail : projectRoleDetailList) {
                ProjectResourceDataBean projectResourceDataBean = new ProjectResourceDataBean();
                projectResourceDataBean.setProjectResourceId(projectRoleDetail.getProjectResourceDetailId());
                projectResourceDataBean.setRoleType(projectRoleDetail.getProjectRoleId());
                if (projectRoleDetail.getProjectRoleId().equals(-1l)) {
                    projectResourceDataBean.setRoleName("MEMBER");
                } else {
                    projectResourceDataBean.setRoleName(this.retrieveRoleNameById(projectRoleDetail.getProjectRoleId()));
                }
                userIds.add(projectRoleDetail.getUserId());
                map.put(projectRoleDetail.getUserId(), projectResourceDataBean);
            }

            Map<QueryOperators, Object> criteria = new HashMap<>();
            Map<String, Object> in = new HashMap<>();
            Map<String, Object> equal = new HashMap<>();

            in.put(UMUserDao.ID, userIds);
            criteria.put(QueryOperators.IN, in);

            equal.put(UMUserDao.IS_ACTIVE, Boolean.TRUE);
            criteria.put(QueryOperators.EQUAL, equal);

            List<UMUser> uMUsers = userService.retrieveUsers(null, criteria, null);
            List<ProjectResourceDataBean> projectResourceDataBeanList = new ArrayList<>();
            for (UMUser uMUser : uMUsers) {
                if (map.containsKey(uMUser.getId())) {
                    ProjectResourceDataBean projectResourceDataBean = map.get(uMUser.getId());
                    projectResourceDataBean.setUserId(uMUser.getId());
                    projectResourceDataBean.setUserName(uMUser.getFirstName() + " " + uMUser.getLastName());
                    projectResourceDataBeanList.add(projectResourceDataBean);
                }
            }
            List<Long> SelectedUsers = new ArrayList<>();

            if (roleType == null) {
                for (ProjectResourceDataBean projectResource : projectResourceDataBeanList) {
                    SelectedUsers.add(projectResource.getUserId());
                }
                systemResultViewUtil.setSelectedList(SelectedUsers);
                projectResourceDataBean.setUserIds(SelectedUsers);

            } else {

                for (ProjectResourceDataBean projectResource : projectResourceDataBeanList) {
                    if (projectResource.getRoleType().equals(roleType)) {
                        SelectedUsers.add(projectResource.getUserId());
                    }
                }
                systemResultViewUtil.setSelectedList(SelectedUsers);
                projectResourceDataBean.setUserIds(SelectedUsers);
            }

            return allProjectResourceDataBeanList;
        }
        return null;
    }

    /**
     * Method Is used to Retrieve Resources which are allocated to Project
     *
     * @author Brijesh
     * @param projectId
     * @return
     * @throws GenericDatabaseException
     */
    public List<ProjectResourceDataBean> retrieveAllResourcesOfProject(Long projectId) throws GenericDatabaseException {
        List<ProjectResourceDataBean> allProjectResourceDataBeanList = new ArrayList<>();

        Map<QueryOperators, Object> criterias = new HashMap<>();
        Map<String, Object> eq = new HashMap<>();

        eq.put(UMUserDao.IS_ACTIVE, Boolean.TRUE);
        criterias.put(QueryOperators.EQUAL, eq);
        List<UMUser> uMUsersList = userService.retrieveUsers(null, criterias, null);
        for (UMUser uMUser : uMUsersList) {
            ProjectResourceDataBean projectResourceDataBean = new ProjectResourceDataBean();
            projectResourceDataBean.setUserId(uMUser.getId());
            projectResourceDataBean.setUserName(uMUser.getFirstName() + " " + uMUser.getLastName());
            allProjectResourceDataBeanList.add(projectResourceDataBean);
        }
        systemResultViewUtil.setAllProjectResources(allProjectResourceDataBeanList);
        List<ProjectResourceDataBean> projectResourceDataBeanList = new ArrayList<>();
        if (projectId != null) {
            List<ProjectResourceDetail> projectRoleDetailList = projectService.retrieveProjectResourceByProjectId(projectId);

            List userIds = new ArrayList<>();

            Map<Long, ProjectResourceDataBean> map = new HashMap();

            for (ProjectResourceDetail projectRoleDetail : projectRoleDetailList) {
                ProjectResourceDataBean projectResourceDataBean = new ProjectResourceDataBean();
                projectResourceDataBean.setProjectResourceId(projectRoleDetail.getProjectResourceDetailId());
                projectResourceDataBean.setRoleType(projectRoleDetail.getProjectRoleId());
                if (projectRoleDetail.getProjectRoleId().equals(-1l)) {
                    projectResourceDataBean.setRoleName("MEMBER");
                } else {
                    projectResourceDataBean.setRoleName(this.retrieveRoleNameById(projectRoleDetail.getProjectRoleId()));
                }
                projectResourceDataBean.setAssignedBy(this.retrieveLastModifyNameById(projectRoleDetail.getLastModifiedBy()));
                userIds.add(projectRoleDetail.getUserId());
                map.put(projectRoleDetail.getUserId(), projectResourceDataBean);
            }

            Map<QueryOperators, Object> criteria = new HashMap<>();
            Map<String, Object> in = new HashMap<>();
            Map<String, Object> equal = new HashMap<>();

            in.put(UMUserDao.ID, userIds);
            criteria.put(QueryOperators.IN, in);

            equal.put(UMUserDao.IS_ACTIVE, Boolean.TRUE);
            criteria.put(QueryOperators.EQUAL, equal);

            List<UMUser> uMUsers = userService.retrieveUsers(null, criteria, null);

            for (UMUser uMUser : uMUsers) {
                if (map.containsKey(uMUser.getId())) {
                    ProjectResourceDataBean projectResourceDataBean = map.get(uMUser.getId());
                    projectResourceDataBean.setUserId(uMUser.getId());
                    projectResourceDataBean.setUserName(uMUser.getFirstName() + " " + uMUser.getLastName());
                    projectResourceDataBeanList.add(projectResourceDataBean);
                }
            }
            List<Long> SelectedUsers = new ArrayList<>();
            for (ProjectResourceDataBean projectResource : projectResourceDataBeanList) {
                SelectedUsers.add(projectResource.getUserId());
            }
            systemResultViewUtil.setAllResourcesOfProject(SelectedUsers);
            systemResultViewUtil.setSelectedList(SelectedUsers);
            projectResourceDataBean.setUserIds(SelectedUsers);
        }
        return projectResourceDataBeanList;
    }

    /**
     * Method is used to assign role to selected resources of project.
     * @param projectId
     * @param userIds
     * @param techIds
     * @param roleType
     * @return success/failure
     * @throws com.argusoft.generic.database.exception.GenericDatabaseException
     */
    public String assignResourcesOfProject(Long projectId, List<Long> userIds, List<Long> techIds, Long roleType) throws GenericDatabaseException {
        List<Long> unSelectedList = new ArrayList<>();
        List<Long> unselectedTech = new ArrayList<>();
        List<Long> newResourcesList = new ArrayList<>();
        ProjectResourceDataBean resourceDataBean = new ProjectResourceDataBean();
        if (userIds != null && !userIds.isEmpty()) {
            for (Long userId : userIds) {
                if (!systemResultViewUtil.getAllResourcesOfProject().contains(userId)) {
                    newResourcesList.add(userId);
                }

            }
            this.addResourcesToProject(resourceDataBean, newResourcesList, roleType);
            List<ProjectResourceDetail> userProjectRoleDetailsList = projectService.retrieveResourcesOfProjectByUserIds(userIds, projectId);
            for (ProjectResourceDetail userProjectRoleDetail : userProjectRoleDetailsList) {
                userProjectRoleDetail.setProjectRoleId(roleType);
            }
            projectService.assignRoleToResourcesOfProject(userProjectRoleDetailsList);
            if (systemResultViewUtil.getSelectedList() != null && !systemResultViewUtil.getSelectedList().isEmpty()) {
                for (Long selecetedUser : systemResultViewUtil.getSelectedList()) {
                    if (!userIds.contains(selecetedUser)) {
                        unSelectedList.add(selecetedUser);
                    }
                }
                if (!unSelectedList.isEmpty()) {
                    List<ProjectResourceDetail> ProjectResourceDetailList = projectService.retrieveResourcesOfProjectByUserIds(unSelectedList, projectId);
                    projectService.deleteResourcesFromProject(ProjectResourceDetailList);
                    this.retrieveAllResourcesOfProject(projectId);
                }

            }
             if (systemResultViewUtil.getTechIdsofProject() != null && !systemResultViewUtil.getTechIdsofProject().isEmpty()) {
                for (Long selectedTech : systemResultViewUtil.getTechIdsofProject()) {
                    if (!techIds.contains(selectedTech)) {
                        unselectedTech.add(selectedTech);
                    }
                }
                if (!unselectedTech.isEmpty()) {
                    List<ProjectTechnologyDetail> ProjectTechnologyDetailList = projectService.retrieveResourcesOfProjectByTechIds(unselectedTech, projectId);
                    projectService.deleteTechnologiesFromProject(ProjectTechnologyDetailList);
//                    this.retrieveAllResourcesOfProject(projectId);
                }

            }
            if (techIds != null && !techIds.isEmpty()) {
                List<Long> existingTechIds = new ArrayList<>();
                List<Long> newTechIds = new ArrayList<>();
                List<ProjectTechnologyDetail> techDetails = projectService.retrieveTechnologies(projectId);
                if (techDetails != null && !techDetails.isEmpty()) {
                    for (ProjectTechnologyDetail prjTech : techDetails) {
                        //preparing list of existing technology in  technology detail.
                        existingTechIds.add(prjTech.getTechnologyId().getTechnologyId());
                    }
                    for (Long techid : techIds) {
                        if (!existingTechIds.contains(techid)) {
                            //preparing list of unadded technology to project
                            newTechIds.add(techid);
                        }
                    }
                    this.addTechnologiestoProject(newTechIds, projectId);

                } else {
                    this.addTechnologiestoProject(techIds, projectId);
                }
            }

            return SystemConstantUtil.SUCCESS;
        } else {
            if (systemResultViewUtil.getSelectedList() != null && !systemResultViewUtil.getSelectedList().isEmpty()) {
                System.out.println("+++++++++inside if loop++++++" + systemResultViewUtil.getSelectedList().size());

                List<ProjectResourceDetail> ProjectResourceDetailList = projectService.retrieveResourcesOfProjectByUserIds(systemResultViewUtil.getSelectedList(), projectId);
                projectService.deleteResourcesFromProject(ProjectResourceDetailList);
                this.retrieveAllResourcesOfProject(projectId);
                return SystemConstantUtil.SUCCESS;
            } else {
                return SystemConstantUtil.FAILURE;
            }

        }

    }

    /**
     * adds technologies to project whose tech_id is passed.
     *
     * @author Niharika
     * @param techIds
     * @param projectId
     */
    public void addTechnologiestoProject(List<Long> techIds, Long projectId) {
        Project project = projectService.retrieveProjectById(projectId);
        if ((techIds != null && !techIds.isEmpty())) {
            List<ProjectTechnologyDetail> techDetails = new ArrayList<>();
            List<TechnologyMaster> techMasterList = userSkillsService.retrieveTechnologiesByTechnologylist(techIds);
            for (TechnologyMaster techMaster : techMasterList) {
                ProjectTechnologyDetail techDetail = new ProjectTechnologyDetail();
                techDetail.setProjectId(project);
                techDetail.setCreatedBy(loginDataBean.getId());
                techDetail.setCreatedOn(Calendar.getInstance().getTime());
                techDetail.setTechnologyId(techMaster);
                techDetail.setIsActive(techMaster.getIsActive());
                techDetails.add(techDetail);
            }
            projectService.addTechnologiesToProject(techDetails);
        }
    }

    /**
     * Method is used to retrieve project resources from userProjectRoleDetail
     * Table to change the role type of that resources.
     *
     * @author Brijesh Patel
     * @param id
     * @return
     */
    public ProjectResourceDataBean retrieveProjectResourceById(Long id) {

        ProjectResourceDetail userProjectRoleDetail = projectService.retrieveProjectResourceByUserProjectRoleId(id);

        ProjectResourceDataBean projectResourceDataBean = new ProjectResourceDataBean();
        projectResourceDataBean.setProjectResourceId(userProjectRoleDetail.getProjectResourceDetailId());
        projectResourceDataBean.setRoleType(userProjectRoleDetail.getProjectRoleId());
        if (userProjectRoleDetail.getProjectRoleId().equals(-1l)) {
            projectResourceDataBean.setRoleName("MEMBER");
        } else {
            projectResourceDataBean.setRoleName(this.retrieveRoleNameById(userProjectRoleDetail.getProjectRoleId()));
        }
        return projectResourceDataBean;
    }

    /**
     * Method is used to update resource detail of project
     *
     * @author Brijesh Patel
     * @param resourceDataBean
     */
    public void updateProjectResourceById(ProjectResourceDataBean resourceDataBean) {

        ProjectResourceDetail userProjectRoleDetail = projectService.retrieveProjectResourceByUserProjectRoleId(projectResourceDataBean.getProjectResourceId());
        userProjectRoleDetail.setProjectRoleId(projectResourceDataBean.getRoleType());
        userProjectRoleDetail.setLastModifiedBy(loginDataBean.getId());
        projectService.updateProjectResourceRole(userProjectRoleDetail);
    }

    /**
     * Method is used to retrieve id of ROLE_MEMBER from project_roles Table
     *
     * @author Brijesh Patel
     * @return
     */
    public Long retrieveRoleMemberIdOfProjectRoles() {
        List<ProjectRoles> projectRoleseList = projectService.retrieveAllRolesOfProject(Boolean.TRUE);
        Long roleMemberId = null;
        if (projectRoleseList != null && !projectRoleseList.isEmpty()) {
            for (ProjectRoles projectRole : projectRoleseList) {
                if (projectRole.getProjectRoleName().equalsIgnoreCase("ROLE_MEMBER")) {
                    roleMemberId = projectRole.getProjectRoleId();
                }

            }
        }

        return roleMemberId;
    }

    /**
     * Method is used to retrieve Role Name By RoleId
     *
     * @author Brijesh Patel
     * @param id
     * @return
     */
    public String retrieveRoleNameById(Long id) {
        ProjectRoles projectRole = projectService.retrieveRoleOfProjectById(id);
        String roleName = projectRole.getProjectRoleDescription();
        return roleName;
    }

    /**
     * Method is used to retrieve LastModifyName By LastModifyId
     *
     * @author Brijesh Patel
     * @param id
     * @return
     * @throws GenericDatabaseException
     */
    public String retrieveLastModifyNameById(Long id) throws GenericDatabaseException {
        UMUser user = userService.retrieveUserById(id, null);
        String lastModifyByName = user.getFirstName() + " " + user.getLastName();
        return lastModifyByName;
    }

    /**
     * Method is used to Retrieve All Projet Roles
     *
     * @author Brijesh Patel
     * @return
     */
    public List<ProjectRolesDataBean> retrieveAllProjectRoles() {
        List<ProjectRoles> projectRoleseList = projectService.retrieveAllRolesOfProject(Boolean.TRUE);
        List<ProjectRolesDataBean> projectRolesDataBeanList = new ArrayList<>();
        for (ProjectRoles projectRole : projectRoleseList) {
            ProjectRolesDataBean projectRolesDataBean = new ProjectRolesDataBean();
            projectRolesDataBean.setProjectRolesId(projectRole.getProjectRoleId());
            projectRolesDataBean.setProjectRolesName(projectRole.getProjectRoleName());
            projectRolesDataBean.setProjectRolesDescription(projectRole.getProjectRoleDescription());
            projectRolesDataBeanList.add(projectRolesDataBean);

        }

        return projectRolesDataBeanList;

    }

    /**
     * retrieveAllTechnologiesOfProject gets all technologies and divides them
     * by type.
     *
     * @author Niharika
     * @param projectId
     */
    public void retrieveAllTechnologiesOfProject(Long projectId) {
        List<Long> techs = new ArrayList<>();
        List<Long> tools = new ArrayList<>();
        List<Long> OS = new ArrayList<>();
        List<Long> browser = new ArrayList<>();
        List<Long> server = new ArrayList<>();
        List<Long> allTechs = new ArrayList<>();
        List<ProjectTechnologyDetail> techDetails = projectService.retrieveTechnologies(projectId);
        for (ProjectTechnologyDetail technology : techDetails) {
            allTechs.add(technology.getTechnologyId().getTechnologyId());
            if (technology.getTechnologyId().getTechType().equals(SystemConstantUtil.TECHNOLOGY)) {
                techs.add(technology.getTechnologyId().getTechnologyId());
            }
            if (technology.getTechnologyId().getTechType().equals(SystemConstantUtil.TOOL)) {
                tools.add(technology.getTechnologyId().getTechnologyId());
            }
            if (technology.getTechnologyId().getTechType().equals(SystemConstantUtil.OPERATING_SYSTEM)) {
                OS.add(technology.getTechnologyId().getTechnologyId());
            }
            if (technology.getTechnologyId().getTechType().equals(SystemConstantUtil.BROWSER)) {
                browser.add(technology.getTechnologyId().getTechnologyId());
            }
            if (technology.getTechnologyId().getTechType().equals(SystemConstantUtil.SERVER)) {
                server.add(technology.getTechnologyId().getTechnologyId());
            }
        }
        projectResourceDataBean.setTechIds(techs);
        projectResourceDataBean.setToolIds(tools);
        projectResourceDataBean.setOsIds(OS);
        projectResourceDataBean.setBrowserIds(browser);
        projectResourceDataBean.setServerIds(server);
        systemResultViewUtil.setTechIdsofProject(allTechs);

    }
}
