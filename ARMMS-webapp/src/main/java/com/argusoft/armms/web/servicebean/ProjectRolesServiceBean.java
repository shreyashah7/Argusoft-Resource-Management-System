/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.servicebean;

import com.argusoft.armms.web.databean.ProjectRolesDataBean;
import com.argusoft.armms.web.transformerbean.ProjectRolesTransformerBean;
import com.argusoft.armms.web.usermanagement.databean.MessageDataBean;
import com.argusoft.armms.web.util.SystemConstantUtil;
import static com.argusoft.armms.web.util.SystemConstantUtil.ACTIVE;
import static com.argusoft.armms.web.util.SystemConstantUtil.INACTIVE;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * managing roles assigned in the project to the user
 *
 * @author shreya
 */
@ManagedBean(name = "projectRolesServiceBean")
@RequestScoped
public class ProjectRolesServiceBean {

    @ManagedProperty("#{projectRolesDataBean}")
    private ProjectRolesDataBean projectRolesDataBean;

    @ManagedProperty("#{messageDataBean}")
    private MessageDataBean messageDataBean;

    @ManagedProperty("#{projectRolesTransformerBean}")
    private ProjectRolesTransformerBean projectRolesTransformerBean;

    @ManagedProperty(value = "#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;

    @ManagedProperty(value = "#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;

    public ProjectRolesDataBean getProjectRolesDataBean() {
        return projectRolesDataBean;
    }

    public void setProjectRolesDataBean(ProjectRolesDataBean projectRolesDataBean) {
        this.projectRolesDataBean = projectRolesDataBean;
    }

    public MessageDataBean getMessageDataBean() {
        return messageDataBean;
    }

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    public SystemResultSessionUtil getSystemResultSessionUtil() {
        return systemResultSessionUtil;
    }

    public void setSystemResultSessionUtil(SystemResultSessionUtil systemResultSessionUtil) {
        this.systemResultSessionUtil = systemResultSessionUtil;
    }

    public void setMessageDataBean(MessageDataBean messageDataBean) {
        this.messageDataBean = messageDataBean;
    }

    public ProjectRolesTransformerBean getProjectRolesTransformerBean() {
        return projectRolesTransformerBean;
    }

    public void setProjectRolesTransformerBean(ProjectRolesTransformerBean projectRolesTransformerBean) {
        this.projectRolesTransformerBean = projectRolesTransformerBean;
    }

    /**
     * createRolesOfProject calls the method of TransformerBean for creating
     * roles
     *
     * @author shreya
     */
    public void createRolesOfProject() {
        Long projectRolesId = projectRolesTransformerBean.createRolesOfProject(projectRolesDataBean);
        if (projectRolesId != 0) {
            messageDataBean.setMessage("Role for Project Added successfully!");
            messageDataBean.setIsSuccess(Boolean.TRUE);
        }
        retrieveRoleOfProjectByType();
    }

    /**
     * updateRolesOfProject calls the method of TransformerBean for updating
     * roles
     *
     * @author shreya
     */
    public void updateRolesOfProject() {
        try {
            projectRolesTransformerBean.updateRolesOfProject(projectRolesDataBean);
            messageDataBean.setMessage("Role for Project Updated successfully!");
            messageDataBean.setIsSuccess(Boolean.TRUE);

        } catch (Exception e) {
            e.printStackTrace();
            messageDataBean.setMessage("Error in Updating Role !!!!");
            messageDataBean.setIsSuccess(Boolean.FALSE);
        }
        retrieveRoleOfProjectByType();
    }

    /**
     * retrieveRoleOfProjectByType calls the method of TransformerBean for
     * retrieving roles of specific status of isActive
     *
     * @author shreya
     */
    public void retrieveRoleOfProjectByType() {
        try {
            projectRolesDataBean.setStatus(systemResultViewUtil.getProjectRolesStatus());
            if (ACTIVE.equalsIgnoreCase(projectRolesDataBean.getStatus())) {
                systemResultViewUtil.setProjectRolesDataBeanList(projectRolesTransformerBean.retrieveAllRolesOfProject(Boolean.TRUE));

            } else if (INACTIVE.equalsIgnoreCase(projectRolesDataBean.getStatus())) {
                systemResultViewUtil.setProjectRolesDataBeanList(projectRolesTransformerBean.retrieveAllRolesOfProject(Boolean.FALSE));

            } else {
                systemResultViewUtil.setProjectRolesDataBeanList(projectRolesTransformerBean.retrieveAllRolesOfProject(null));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * changeStatus calls the method of TransformerBean of updating the status
     * by setting isActive according to the event
     *
     * @author shreya
     * @param projectRoleDataBean object from the page
     */
    public void changeStatus(ProjectRolesDataBean projectRoleDataBean) {
        try {
            if (projectRoleDataBean.getStatus().equals(SystemConstantUtil.ACTIVE)) {
                projectRoleDataBean.setStatus(SystemConstantUtil.INACTIVE);
            } else {
                projectRoleDataBean.setStatus(SystemConstantUtil.ACTIVE);
            }
            systemResultSessionUtil.setProjectRolesId(projectRoleDataBean.getProjectRolesId());
            projectRolesTransformerBean.updateRolesOfProject(projectRoleDataBean);
            messageDataBean.setMessage("Role for Project deactivated successfully!");
            messageDataBean.setIsSuccess(Boolean.TRUE);
        }catch(Exception e){
            messageDataBean.setMessage("Error in deactivating Role for Project!");
            messageDataBean.setIsSuccess(Boolean.TRUE);
        }
        retrieveRoleOfProjectByType();

    }

    /**
     * retrieveRoleOfProjectById calls the method of TransformerBean for
     * retrieving roles of specific id i.e PK in projectRoles table
     *
     * @author shreya
     */
    public void retrieveRoleOfProjectById() {
        projectRolesTransformerBean.retrieveRoleOfProjectById(projectRolesDataBean.getProjectRolesId());

    }

}
