/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.usermanagement.transformerbean;

import com.argusoft.armms.web.usermanagement.databean.SystemConfigurationDataBean;
import com.argusoft.armms.web.util.SystemConstantUtil;
import static com.argusoft.armms.web.util.SystemConstantUtil.ACTIVE;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.usermanagement.common.core.UMSystemConfigurationService;
import com.argusoft.usermanagement.common.model.UMSystemConfiguration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * methods for activity in systemConfigurations
 *
 * @author shreya
 */
@ManagedBean(name = "systemConfigurationTransformerBean")
@RequestScoped
public class SystemConfigurationTransformerBean {

    @ManagedProperty(value = "#{systemConfigurationService}")
    private UMSystemConfigurationService systemConfigurationService;

    @ManagedProperty(value = "#{systemConfigurationDataBean}")
    private SystemConfigurationDataBean systemConfigurationDataBeans;

    @ManagedProperty(value = "#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;

    public UMSystemConfigurationService getSystemConfigurationService() {
        return systemConfigurationService;
    }

    public void setSystemConfigurationService(UMSystemConfigurationService systemConfigurationService) {
        this.systemConfigurationService = systemConfigurationService;
    }

    public SystemConfigurationDataBean getSystemConfigurationDataBeans() {
        return systemConfigurationDataBeans;
    }

    public void setSystemConfigurationDataBeans(SystemConfigurationDataBean systemConfigurationDataBeans) {
        this.systemConfigurationDataBeans = systemConfigurationDataBeans;
    }

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    /**
     * retrieveSystemConfiguration method retrieves all active system
     * configuration
     *
     * @returmns the list of Object of SystemConfigurationDataBean
     * @author shreya
     */
    public List<SystemConfigurationDataBean> retrieveSystemConfigurations() {
        List<SystemConfigurationDataBean> systemConfigurationDataBeanList = new ArrayList<>();

        Map<String, String> systemConfigurationMainMap = systemConfigurationService.retrieveAllSystemConfigurations();
        if (systemConfigurationMainMap != null && !systemConfigurationMainMap.isEmpty()) {
            Map<String, String> systemConfigurationMap = new TreeMap<>(systemConfigurationMainMap);
            for (String key : systemConfigurationMap.keySet()) {
                String value = systemConfigurationMap.get(key);
                SystemConfigurationDataBean systemConfigurationDataBean = new SystemConfigurationDataBean();
                systemConfigurationDataBean.setSystemKey(key);
                systemConfigurationDataBean.setKeyValue(value);
                systemConfigurationDataBeanList.add(systemConfigurationDataBean);
            }
        }
        return systemConfigurationDataBeanList;
    }

    /**
     * retrieveSystemConfigurationByType method retrieves all system
     * configuration by passing the status(active=true,false or null)
     *
     * @returmns the list of Object of SystemConfigurationDataBean
     * @param status boolean value(true,false,null)
     * @author shreya
     */
    public List<SystemConfigurationDataBean> retrieveSystemConfigurationsByStatus(Boolean status) {
        List<SystemConfigurationDataBean> systemConfigurationDataBeanList = new ArrayList<>();
        List<UMSystemConfiguration> sysList = systemConfigurationService.retrieveAllSystemConfigurationsByStatus(status);
        if (sysList != null && !sysList.isEmpty()) {
            for (UMSystemConfiguration configValue : sysList) {
                SystemConfigurationDataBean systemConfigurationDataBean = new SystemConfigurationDataBean();
                systemConfigurationDataBean.setSystemKey(configValue.getSystemKey());
                systemConfigurationDataBean.setKeyValue(configValue.getKeyValue());
                systemConfigurationDataBean.setIsActive(configValue.getIsActive());
                systemConfigurationDataBeanList.add(systemConfigurationDataBean);
            }
        }
        return systemConfigurationDataBeanList;
    }

    /**
     * createSystemConfiguration method creates the key value pair in system
     * configuration table
     *
     * @param object of systemConfigurationDataBean
     * @returns response(success,failure)
     * @author shreya
     */
    public String createSystemConfiguration(SystemConfigurationDataBean systemConfigurationDataBean) {
        String response = SystemConstantUtil.FAILURE;
        UMSystemConfiguration systemConfiguration = convertSystemConfigurationDataBeanToSystemConfigurationModel(systemConfigurationDataBean, new UMSystemConfiguration());
        this.systemConfigurationService.createSystemConfiguration(systemConfiguration);
        response = SystemConstantUtil.SUCCESS;
        return response;
    }

    private UMSystemConfiguration convertSystemConfigurationDataBeanToSystemConfigurationModel(SystemConfigurationDataBean systemConfigurationDataBean, UMSystemConfiguration systemConfiguration) {
        System.out.println(systemConfigurationDataBean.getKeyValue() + systemConfigurationDataBean.getSystemKey());
        systemConfiguration.setKeyValue(systemConfigurationDataBean.getKeyValue());
        systemConfiguration.setSystemKey(systemConfigurationDataBean.getSystemKey());
        return systemConfiguration;
    }

    /**
     * updateSystemConfiguration method updates the value of a particular key.
     *
     * @param key in string and new value of that key in string
     * @author shreya
     */
    public void updateSystemConfiguration(String key, String newValue) {
        UMSystemConfiguration systemConfiguration = systemConfigurationService.retrieveSystemConfigurationByKey(key);
        if (systemConfiguration != null) {
            systemConfiguration.setKeyValue(newValue);
            if (ACTIVE.equalsIgnoreCase(systemConfigurationDataBeans.getStatus())) {
                systemConfiguration.setIsActive(Boolean.TRUE);
            } else {
                systemConfiguration.setIsActive(Boolean.FALSE);
            }
            systemConfigurationService.updateSystemConfiguration(systemConfiguration);
        }
    }

    /**
     * deleteSystemConfiguration method deletes the key value pair from the table
     * @param key in string
     * @author shreya
     */
    public void deleteSystemConfiguration(String key) {
        UMSystemConfiguration systemConfiguration = systemConfigurationService.retrieveSystemConfigurationByKey(key);
        if (systemConfiguration != null) {
            if (ACTIVE.equalsIgnoreCase(systemConfigurationDataBeans.getStatus())) {
                systemConfiguration.setIsActive(Boolean.TRUE);
            } else {
                systemConfiguration.setIsActive(Boolean.FALSE);
            }
            updateSystemConfiguration(systemResultViewUtil.getKey(), systemResultViewUtil.getValue());
        }
    }
}
