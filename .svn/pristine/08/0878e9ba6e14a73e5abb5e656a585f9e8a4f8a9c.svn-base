/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.usermanagement.transformerbean;

import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import com.argusoft.armms.web.usermanagement.databean.UserAuthorizationDataBean;
import com.argusoft.generic.database.exception.GenericDatabaseException;
import com.argusoft.usermanagement.common.core.UMFeatureService;
import com.argusoft.usermanagement.common.core.UMRoleService;
import com.argusoft.usermanagement.common.database.UMRoleDao;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import com.argusoft.usermanagement.common.model.UMFeature;
import com.argusoft.usermanagement.common.model.UMRole;
import com.argusoft.usermanagement.common.model.UMRoleFeature;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * Bean for Loading menu and menuitems based on role of user logged in
 *
 * @author rajkumar
 * @since 08-APR-2014
 */
@ManagedBean(name = "menuTransformerBean")
@RequestScoped
public class MenuTransformerBean {

    @ManagedProperty("#{featureService}")
    private UMFeatureService featureService;

    @ManagedProperty(value = "#{loginDataBean}")
    private LoginDataBean loginDataBean;

    @ManagedProperty(value = "#{roleService}")
    private UMRoleService uMRoleService;

    public UMFeatureService getFeatureService() {
        return featureService;
    }

    public void setFeatureService(UMFeatureService featureService) {
        this.featureService = featureService;
    }

    public UMRoleService getuMRoleService() {
        return uMRoleService;
    }

    public void setuMRoleService(UMRoleService uMRoleService) {
        this.uMRoleService = uMRoleService;
    }

    public LoginDataBean getLoginDataBean() {
        return loginDataBean;
    }

    public void setLoginDataBean(LoginDataBean loginDataBean) {
        this.loginDataBean = loginDataBean;
    }

    /**
     * Load menu items based on role of user
     *
     * @param role_name
     * @throws UMUserManagementException
     * @throws com.argusoft.generic.database.exception.GenericDatabaseException
     */
    public void loadMenuBasedOnRole(String role_name) throws UMUserManagementException, GenericDatabaseException {
        
        Map<String, Set<UserAuthorizationDataBean>> menuWithMenuItem = new LinkedHashMap<>();
        Map<String, String> menu = new LinkedHashMap<>();
        List<String> itemAttributes = new ArrayList<>();
        Map<String, Object> criteria = new HashMap<>();
        criteria.put(UMRoleDao.NAME, role_name);
        UMRole uMRole = uMRoleService.retrieveRoles(criteria, null, null, null).get(0);
//        UMRole uMRole = uMRoleService.getRoleByRoleName(role_name, false, false);
        uMRole = uMRoleService.getRoleByRoleId(uMRole.getId(), true, false, false);
        Set<UMRoleFeature> uMRoleFeature = uMRole.getUMRoleFeatureSet();

        Map<Long,UMFeature> listOfFeatures=new HashMap<>();
        List<UMFeature> allFeatures=featureService.retrieveAllFeatures(Boolean.TRUE);
        for (UMFeature uMFeature : allFeatures) {
            listOfFeatures.put(uMFeature.getId(), uMFeature);
        }
        
        for (UMRoleFeature featureToAdd : uMRoleFeature) {
            if (featureToAdd.getIsActive()) {
                UMFeature menuItemFeature = featureToAdd.getFeature();
                if (menuItemFeature.getParent() == null) {
                    menu.put(menuItemFeature.getName(), menuItemFeature.getFeatureUrl());
                } else {
                    String menuName = (listOfFeatures.get(menuItemFeature.getParent().getId())).getName();

                    //Get Menu and MenuItems
                    if (menuWithMenuItem.keySet().contains(menuName)) {
                        menuWithMenuItem.get(menuName).add(convertFeatureToAuthenticationDataBean(menuItemFeature));
                    } else {
                        Set<UserAuthorizationDataBean> tempSet = new LinkedHashSet<>();
                        tempSet.add(convertFeatureToAuthenticationDataBean(menuItemFeature));

                        menuWithMenuItem.put(menuName, tempSet);
                    }
                }
                //Get itemAttributes
                String[] itemAttribs = featureToAdd.getPermission().getAttributes().replaceAll("#", "").split(",");
                for (String attribID : itemAttribs) {
                    itemAttributes.add(listOfFeatures.get(Long.parseLong(attribID)).getName());
                }
            }
        }
        loginDataBean.setMenus(menu);
        loginDataBean.setMenuWithMenuItem(menuWithMenuItem);
        loginDataBean.setItemAttributes(itemAttributes);
    }

    /**
     * conversion from feature object to data bean
     *
     * @param uMFeature
     * @return
     * @throws
     * com.argusoft.usermanagement.common.exception.UMUserManagementException
     */
    public UserAuthorizationDataBean convertFeatureToAuthenticationDataBean(UMFeature uMFeature) throws UMUserManagementException {
        UserAuthorizationDataBean userAuthorizationDataBean = new UserAuthorizationDataBean();

        userAuthorizationDataBean.setMenuID(uMFeature.getId());
        userAuthorizationDataBean.setMenuName(uMFeature.getName());
        userAuthorizationDataBean.setMenuType(uMFeature.getMenuType());
        userAuthorizationDataBean.setParent(featureService.getFeatureByFeatureId(uMFeature.getParent().getId()).getId());
        userAuthorizationDataBean.setFeatureUrl(uMFeature.getFeatureUrl());

        return userAuthorizationDataBean;
    }
}
