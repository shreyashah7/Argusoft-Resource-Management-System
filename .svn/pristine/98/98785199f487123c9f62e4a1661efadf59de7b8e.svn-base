/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.argusoft.armms.web.usermanagement.databean;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author shreya
 */
@ManagedBean(name = "systemConfigurationDataBean")
@RequestScoped
public class SystemConfigurationDataBean implements Serializable{
    
    private String systemKey;
    private String keyValue;
    private Boolean isActive;
    private String status;
   

    public SystemConfigurationDataBean() {
    }

    public SystemConfigurationDataBean(String systemKey, String keyValue) {
        this.systemKey = systemKey;
        this.keyValue = keyValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSystemKey() {
        return systemKey;
    }

    public void setSystemKey(String systemKey) {
        this.systemKey = systemKey;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
