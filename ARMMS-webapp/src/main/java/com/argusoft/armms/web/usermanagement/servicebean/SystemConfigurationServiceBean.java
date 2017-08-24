/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.usermanagement.servicebean;

import com.argusoft.armms.web.usermanagement.databean.MessageDataBean;
import com.argusoft.armms.web.usermanagement.databean.SystemConfigurationDataBean;
import com.argusoft.armms.web.usermanagement.transformerbean.SystemConfigurationTransformerBean;
import com.argusoft.armms.web.util.SystemConstantUtil;
import static com.argusoft.armms.web.util.SystemConstantUtil.*;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.springframework.util.StringUtils;

/**
 * methods for activity in systemConfigurations
 *
 * @author shreya
 */
@ManagedBean(name = "systemConfigurationServiceBean")
@RequestScoped
public class SystemConfigurationServiceBean {

    @ManagedProperty(value = "#{systemConfigurationDataBean}")
    private SystemConfigurationDataBean systemConfigurationDataBean;
    @ManagedProperty(value = "#{messageDataBean}")
    private MessageDataBean messageDataBean;
    @ManagedProperty(value = "#{systemConfigurationTransformerBean}")
    private SystemConfigurationTransformerBean systemConfigurationTransformerBean;
    @ManagedProperty(value = "#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;
    @ManagedProperty(value = "#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;

    public SystemConfigurationDataBean getSystemConfigurationDataBean() {
        return systemConfigurationDataBean;
    }

    public void setSystemConfigurationDataBean(SystemConfigurationDataBean systemConfigurationDataBean) {
        this.systemConfigurationDataBean = systemConfigurationDataBean;
    }

    public MessageDataBean getMessageDataBean() {
        return messageDataBean;
    }

    public void setMessageDataBean(MessageDataBean messageDataBean) {
        this.messageDataBean = messageDataBean;
    }

    public SystemConfigurationTransformerBean getSystemConfigurationTransformerBean() {
        return systemConfigurationTransformerBean;
    }

    public void setSystemConfigurationTransformerBean(SystemConfigurationTransformerBean systemConfigurationTransformerBean) {
        this.systemConfigurationTransformerBean = systemConfigurationTransformerBean;
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

    /**
     * retrieveSystemConfiguration method retrieves all active system
     * configuration sets the list in systemResultViewUtil
     *
     * @author shreya
     */
    public void retrieveSystemConfiguration() {
        try {
            systemResultViewUtil.setSystemConfigurationDataBeanList(systemConfigurationTransformerBean.retrieveSystemConfigurations());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * createSystemConfiguration method creates the key value pair in system
     * configuration table
     *
     * @author shreya
     */
    public void createSystemConfiguration() {
        try {
            if (systemConfigurationDataBean != null) {
                systemConfigurationTransformerBean.createSystemConfiguration(systemConfigurationDataBean);
            }
            messageDataBean.setMessage("SystemConfiguration Added Successfully !!!!");
            messageDataBean.setIsSuccess(Boolean.TRUE);
        } catch (Exception e) {
            System.out.println(e);
            messageDataBean.setMessage("SystemConfiguration already Exists");
            messageDataBean.setIsSuccess(Boolean.FALSE);
        }
        systemConfigurationDataBean.setKeyValue(null);
        systemConfigurationDataBean.setSystemKey(null);
        retrieveSystemConfigurationByType();

    }

    /**
     * updateSystemConfiguration method updates the value of a particular key.
     *
     * @author shreya
     */
    public void updateSystemConfiguration() {
        try {
            if (!StringUtils.hasText(systemResultViewUtil.getValue())) {
                messageDataBean.setMessage("Property Value Required !!!!");
                messageDataBean.setIsSuccess(Boolean.FALSE);
                return;
            }
            systemConfigurationTransformerBean.updateSystemConfiguration(systemResultViewUtil.getKey(), systemResultViewUtil.getValue());
            messageDataBean.setMessage("SystemConfiguration Updated Successfully !!!!");
            messageDataBean.setIsSuccess(Boolean.TRUE);
        } catch (Exception e) {
            messageDataBean.setMessage("Error in Updating SystemConfiguration !!!!");
            messageDataBean.setIsSuccess(Boolean.FALSE);
            retrieveSystemConfigurationByType();
        }
    }

    /**
     * deleteSystemConfiguration method deletes the key value pair from the
     * table
     *
     * @author shreya
     */
    public void deleteSystemConfiguration() {
        try {
            systemConfigurationTransformerBean.deleteSystemConfiguration(systemResultViewUtil.getKey());
            messageDataBean.setMessage("SystemConfiguration Deleted Successfully !!!!");
            messageDataBean.setIsSuccess(Boolean.TRUE);
        } catch (Exception e) {
            messageDataBean.setMessage("Error in Deleting SystemConfiguration !!!!");
            messageDataBean.setIsSuccess(Boolean.FALSE);

        }
        if (systemConfigurationDataBean.getStatus() == null) {
            retrieveSystemConfiguration();
        } else {
            retrieveSystemConfigurationByType();
        }
    }

    /**
     * retrieveSystemConfigurationByType method retrieves all system
     * configuration by passing the type(active=true,false or null)
     *
     * @author shreya
     */
    public void retrieveSystemConfigurationByType() {
        try {
            String status = systemResultViewUtil.getSysConfigStatus();
            if (ACTIVE.equalsIgnoreCase(status)) {
                systemResultViewUtil.setSystemConfigurationDataBeanList(systemConfigurationTransformerBean.retrieveSystemConfigurationsByStatus(Boolean.TRUE));
                if (systemResultViewUtil.getSystemConfigurationDataBeanList().isEmpty()) {
                }

            } else if (INACTIVE.equalsIgnoreCase(status)) {
                systemResultViewUtil.setSystemConfigurationDataBeanList(systemConfigurationTransformerBean.retrieveSystemConfigurationsByStatus(Boolean.FALSE));
                if (systemResultViewUtil.getSystemConfigurationDataBeanList().isEmpty()) {
                }

            } else {
                systemResultViewUtil.setSystemConfigurationDataBeanList(systemConfigurationTransformerBean.retrieveSystemConfigurationsByStatus(null));
                if (systemResultViewUtil.getSystemConfigurationDataBeanList().isEmpty()) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * changeStatus method retrieves changes the status of that system configuration by active=true or false
     * @author shreya
     */
    public void changeStatus() {
        try {
            List<SystemConfigurationDataBean> sysConfigList = systemResultViewUtil.getSystemConfigurationDataBeanList();
            Boolean value = systemResultViewUtil.getStatus();
            if (value.equals(Boolean.TRUE)) {
                systemConfigurationDataBean.setStatus(SystemConstantUtil.INACTIVE);
                systemConfigurationTransformerBean.deleteSystemConfiguration(systemResultViewUtil.getKey());
                messageDataBean.setMessage("Configuration Deactivated Successfully !!!!");
                messageDataBean.setIsSuccess(Boolean.TRUE);
            } else {
                systemConfigurationDataBean.setStatus(SystemConstantUtil.ACTIVE);
                systemConfigurationTransformerBean.deleteSystemConfiguration(systemResultViewUtil.getKey());
                messageDataBean.setMessage("Configuration Activated Successfully !!!!");
                messageDataBean.setIsSuccess(Boolean.TRUE);
            }
            retrieveSystemConfigurationByType();

        } catch (Exception e) {
            messageDataBean.setMessage("Error in Deletion!!!!");
            messageDataBean.setIsSuccess(Boolean.FALSE);

        }

    }

}
