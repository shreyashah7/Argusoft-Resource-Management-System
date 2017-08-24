/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.usermanagement.servicebean;

import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import com.argusoft.armms.web.usermanagement.transformerbean.MenuTransformerBean;
import com.argusoft.generic.database.exception.GenericDatabaseException;
import com.argusoft.usermanagement.common.core.UMRoleService;
import com.argusoft.usermanagement.common.core.UMUserService;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * Bean for providing service for menu 
 * @author rajkumar
 * @since 08-APR-2014
 */
@ManagedBean(name = "menuServiceBean")
@RequestScoped
public class MenuServiceBean {

    @ManagedProperty(value = "#{loginDataBean}")
    private LoginDataBean loginDataBean;

    @ManagedProperty(value = "#{userService}")
    private UMUserService userService;

    @ManagedProperty(value = "#{roleService}")
    private UMRoleService uMRoleService;

    @ManagedProperty(value = "#{menuTransformerBean}")
    private MenuTransformerBean menuTransformerBean;

    public UMRoleService getuMRoleService() {
        return uMRoleService;
    }

    public MenuTransformerBean getMenuTransformerBean() {
        return menuTransformerBean;
    }

    public void setMenuTransformerBean(MenuTransformerBean menuTransformerBean) {
        this.menuTransformerBean = menuTransformerBean;
    }

    public void setuMRoleService(UMRoleService uMRoleService) {
        this.uMRoleService = uMRoleService;
    }

    public UMUserService getUserService() {
        return userService;
    }

    public void setUserService(UMUserService userService) {
        this.userService = userService;
    }

    public LoginDataBean getLoginDataBean() {
        return loginDataBean;
    }

    public void setLoginDataBean(LoginDataBean loginDataBean) {
        this.loginDataBean = loginDataBean;
    }

    public void loadMenuBasedOnRole() throws UMUserManagementException, GenericDatabaseException {
        menuTransformerBean.loadMenuBasedOnRole(loginDataBean.getRole());
    }
}
