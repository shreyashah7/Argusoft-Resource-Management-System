/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.argusoft.armms.web.usermanagement.databean;

import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Data Bean for menu related authentication
 * @author rajkumar
 * @since 08-APR-2014
 */
@ManagedBean(name = "userAuthorizationDataBean")
@SessionScoped
public class UserAuthorizationDataBean {
    private Long menuID;
    private String menuName;
    private Long parent;
    private String menuType;
    private String featureUrl;

    public String getFeatureUrl() {
        return featureUrl;
    }

    public void setFeatureUrl(String featureUrl) {
        this.featureUrl = featureUrl;
    }
    
    public Long getMenuID() {
        return menuID;
    }

    public void setMenuID(Long menuID) {
        this.menuID = menuID;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.menuID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserAuthorizationDataBean other = (UserAuthorizationDataBean) obj;
        if (!Objects.equals(this.menuID, other.menuID)) {
            return false;
        }
        return true;
    }

    
    
}
