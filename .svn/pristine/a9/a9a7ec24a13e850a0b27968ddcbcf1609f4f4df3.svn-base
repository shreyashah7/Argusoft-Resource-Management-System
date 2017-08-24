/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.usermanagement.transformerbean;

import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.usermanagement.common.core.UMRoleService;
import com.argusoft.usermanagement.common.core.UMUserService;
import com.argusoft.usermanagement.common.database.UMUserRoleDao;
import com.argusoft.usermanagement.common.model.UMUser;
import com.argusoft.usermanagement.common.model.UMUserRole;
import com.argusoft.usermanagement.common.model.UMUserRole;
import static java.lang.reflect.Array.set;
import java.util.Calendar;
import java.util.Iterator;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.apache.log4j.Logger;

/**
 *
 * @author brijesh
 */
@ManagedBean(name = "loginTransformerBean")
@RequestScoped
public class LoginTransformerBean {

    //loginDataBean
    @ManagedProperty("#{loginDataBean}")
    private LoginDataBean loginDataBean;
    //  Core properties
    @ManagedProperty("#{userService}")
    private UMUserService userService;

    @ManagedProperty("#{roleService}")
    private UMRoleService roleService;

    @ManagedProperty(value = "#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;

    public SystemResultSessionUtil getSystemResultSessionUtil() {
        return systemResultSessionUtil;
    }

    public void setSystemResultSessionUtil(SystemResultSessionUtil systemResultSessionUtil) {
        this.systemResultSessionUtil = systemResultSessionUtil;
    }

    public UMRoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(UMRoleService roleService) {
        this.roleService = roleService;
    }

    private static final Logger logger = Logger.getLogger(LoginTransformerBean.class);

    public LoginDataBean getLoginDataBean() {
        return loginDataBean;
    }

    public void setLoginDataBean(LoginDataBean loginDataBean) {
        this.loginDataBean = loginDataBean;
    }

    public UMUserService getUserService() {
        return userService;
    }

    public void setUserService(UMUserService userService) {
        this.userService = userService;
    }

    /**
     * update LoggedIn User Info
     *
     * @author Brijesh
     */
    public void updateLoginData(String userId) {
        UMUser systemUser = this.retrieveSystemUser(userId);

        if (systemUser != null) {
            this.convertUserModelToLoginDataBean(systemUser);
            Calendar currentdate = Calendar.getInstance();
//            currentdate.setTime(SystemFunctionUtil.convertDateTimeToServerTimeZone(currentdate.getTime(), currentdate.getTimeZone().getID()));
            systemUser.setLastLoginOn(currentdate.getTime());
            this.updateSystemUser(systemUser);
        }
    }

    /**
     * Conversion method for LoginDataBean
     *
     * @author Brijesh
     * @param systemUser
     */
    private void convertUserModelToLoginDataBean(UMUser systemUser) {
        this.loginDataBean.setUserId(systemUser.getUserId());
//        this.loginDataBean.setRole(systemUser.getType());
        Iterator userRoles = systemUser.getUMUserRoleSet().iterator();
        while (userRoles.hasNext()) {
            UMUserRole uMUserRole = (UMUserRole) userRoles.next();
            if (uMUserRole.getIsActive()) {
                Long roleID = uMUserRole.getuMUserRolePK().getRole();
                String Role_name = roleService.getRoleByRoleId(roleID, false, false, false).getName();
                this.loginDataBean.setRole(Role_name);
                System.out.println("++++++user role++++" + loginDataBean.getRole());
            }
        }
        this.loginDataBean.setId(systemUser.getId());
        this.loginDataBean.setEmailId(systemUser.getEmailAddress());
        this.systemResultSessionUtil.setUserId(systemUser.getId());
        this.loginDataBean.setName(systemUser.getFirstName() + " " + systemUser.getLastName());

    }

    /**
     * Method to update user object
     *
     * @author Brijesh
     * @param systemUser Object
     */
    private void updateSystemUser(UMUser systemUser) {
        try {
            userService.updateUser(systemUser, false, false, false, false);
        } catch (Exception ex) {
            logger.error(ex);
        }
    }

    /**
     * Method to retrieve UMUser by id
     *
     * @author Brijesh
     * @param userId Id of the user
     * @return The user object if exist, otherwise null returned
     */
    private UMUser retrieveSystemUser(String userId) {
        UMUser systemUser = new UMUser();
        try {
            systemUser = userService.getUserbyUserName(userId, false, true, true, false, false, Boolean.TRUE);
        } catch (Exception ex) {
            logger.error(ex);
        }
        return systemUser;
    }

}
