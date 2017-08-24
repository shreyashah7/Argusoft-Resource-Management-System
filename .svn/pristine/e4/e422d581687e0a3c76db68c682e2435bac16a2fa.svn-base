/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.argusoft.armms.web.util;

import com.argusoft.usermanagement.common.core.UMSystemConfigurationService;
import com.argusoft.usermanagement.common.model.UMSystemConfiguration;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 * for the data to be used in application scope
 * @author shreya
 */
@ManagedBean(name = "systemPropertyUtil")
@ApplicationScoped
public class SystemPropertyUtil {

    @ManagedProperty(value = "#{systemConfigurationService}")
    private UMSystemConfigurationService systemConfigurationService;

    public UMSystemConfigurationService getSystemConfigurationService() {
        return systemConfigurationService;
    }

    public void setSystemConfigurationService(UMSystemConfigurationService systemConfigurationService) {
        this.systemConfigurationService = systemConfigurationService;
    }

    private final String serverTimeZone = Calendar.getInstance().getTimeZone().getID();
    private String projUrl;
    private String taskEndPeriod;
    private String initialConfigurationDone;
    private String organizationName;
    private String svnUrl;
    private String latestUpdateXDays; 
    
    {
        System.out.println("systemPropertyUtil Bean called---------->>>>");
    }
    
    public String getServerTimeZone() {
        return serverTimeZone;
    }

  

}


