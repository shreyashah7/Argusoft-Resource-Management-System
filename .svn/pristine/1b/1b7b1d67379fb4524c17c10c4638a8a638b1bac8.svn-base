/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.usermanagement.servicebean;

import com.argusoft.armms.web.usermanagement.databean.MessageDataBean;
import com.argusoft.armms.web.usermanagement.databean.PermissionDataBean;
import com.argusoft.armms.web.usermanagement.transformerbean.PermissionTransformerBean;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.generic.database.exception.GenericDatabaseException;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * Bean for providing service for permission
 *
 * @author rajkumar
 * @since 08-APR-2014
 */
@ManagedBean(name = "permissionServiceBean")
@RequestScoped
public class PermissionServiceBean {

    @ManagedProperty(value = "#{permissionTransformerBean}")
    private PermissionTransformerBean permissionTransformerBean;

    @ManagedProperty(value = "#{permissionDataBean}")
    private PermissionDataBean permissionDataBean;

    @ManagedProperty("#{messageDataBean}")
    private MessageDataBean messageDataBean;

    @ManagedProperty("#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;

    public SystemResultSessionUtil getSystemResultSessionUtil() {
        return systemResultSessionUtil;
    }

    public void setSystemResultSessionUtil(SystemResultSessionUtil systemResultSessionUtil) {
        this.systemResultSessionUtil = systemResultSessionUtil;
    }

    public MessageDataBean getMessageDataBean() {
        return messageDataBean;
    }

    public void setMessageDataBean(MessageDataBean messageDataBean) {
        this.messageDataBean = messageDataBean;
    }

    public PermissionDataBean getPermissionDataBean() {
        return permissionDataBean;
    }

    public void setPermissionDataBean(PermissionDataBean permissionDataBean) {
        this.permissionDataBean = permissionDataBean;
    }

    public PermissionTransformerBean getPermissionTransformerBean() {
        return permissionTransformerBean;
    }

    public void setPermissionTransformerBean(PermissionTransformerBean permissionTransformerBean) {
        this.permissionTransformerBean = permissionTransformerBean;
    }

    public void retrievePermissionById() {
        permissionTransformerBean.retrievePermissionById();
    }

    public void addOrUpdatePermission() throws UMUserManagementException {

        if (permissionDataBean.getID() == null) {
            try {
                Long result = permissionTransformerBean.addPermission();

                if (result != null) {
                    messageDataBean.setIsSuccess(Boolean.TRUE);
                    messageDataBean.setMessage("Permission added successfully");
                }
            } catch (UMUserManagementException e) {
                e.printStackTrace();

                messageDataBean.setIsSuccess(Boolean.FALSE);
                messageDataBean.setMessage("Some error while adding Permission");
            }
        } else {
            try {
                Long result = permissionTransformerBean.updatePermission();

                if (result != null) {
                    messageDataBean.setIsSuccess(Boolean.TRUE);
                    messageDataBean.setMessage("Permission updated successfully");
                }

            } catch (UMUserManagementException e) {
                e.printStackTrace();

                messageDataBean.setIsSuccess(Boolean.FALSE);
                messageDataBean.setMessage("Some error while updating Permission");
            }
        }
    }

    public void deletePermission() {
        permissionTransformerBean.getAllRoleHavingPermission(systemResultSessionUtil.getPermissionIDToRemove());
    }

    public void changePermission(Long role_ID) throws GenericDatabaseException {
        permissionTransformerBean.changePermission(role_ID, systemResultSessionUtil.getPermissionIDToRemove());
    }

    public String removePermission() throws GenericDatabaseException {

        Boolean result = permissionTransformerBean.checkForPermissionIsExistInRole(systemResultSessionUtil.getPermissionIDToRemove());
        if (!result) {
            permissionTransformerBean.removePermission(systemResultSessionUtil.getPermissionIDToRemove());
            return "manageRole?faces-redirect=true";
        }else{
            messageDataBean.setIsSuccess(Boolean.FALSE);
            messageDataBean.setMessage("Permission can't be removed change permissions for all role");
        }
        return null;
    }
}
