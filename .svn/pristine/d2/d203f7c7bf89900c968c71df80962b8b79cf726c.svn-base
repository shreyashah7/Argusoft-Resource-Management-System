/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.servicebean;

import com.argusoft.armms.web.databean.TechnologyDataBean;
import com.argusoft.armms.web.transformerbean.TechnologyTransformBean;
import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import com.argusoft.armms.web.usermanagement.databean.MessageDataBean;
import com.argusoft.armms.web.util.SystemConstantUtil;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author niharika
 */
@ManagedBean(name = "technologyServiceBean")
@RequestScoped
public class TechnologyServiceBean implements Serializable {

    @ManagedProperty(value = "#{technologyDataBean}")
    private TechnologyDataBean technologyDataBean;
    @ManagedProperty(value = "#{technologyTransformBean}")
    private TechnologyTransformBean technologyTransformBean;
    @ManagedProperty(value = "#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;
    @ManagedProperty(value = "#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;
    @ManagedProperty(value = "#{messageDataBean}")
    private MessageDataBean messageDataBean;
    @ManagedProperty(value = "#{loginDataBean}")
    private LoginDataBean loginDataBean;

    public LoginDataBean getLoginDataBean() {
        return loginDataBean;
    }

    public void setLoginDataBean(LoginDataBean loginDataBean) {
        this.loginDataBean = loginDataBean;
    }

    public MessageDataBean getMessageDataBean() {
        return messageDataBean;
    }

    public void setMessageDataBean(MessageDataBean messageDataBean) {
        this.messageDataBean = messageDataBean;
    }

    public SystemResultSessionUtil getSystemResultSessionUtil() {
        return systemResultSessionUtil;
    }

    public void setSystemResultSessionUtil(SystemResultSessionUtil systemResultSessionUtil) {
        this.systemResultSessionUtil = systemResultSessionUtil;
    }

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    public TechnologyDataBean getTechnologyDataBean() {
        return technologyDataBean;
    }

    public void setTechnologyDataBean(TechnologyDataBean technologyDataBean) {
        this.technologyDataBean = technologyDataBean;
    }

    public TechnologyTransformBean getTechnologyTransformBean() {
        return technologyTransformBean;
    }

    public void setTechnologyTransformBean(TechnologyTransformBean technologyTransformBean) {
        this.technologyTransformBean = technologyTransformBean;
    }

    /**
     * @author Brijesh Add Technology or Tool Or Browser Or Server Detail
     */
    public void addTechnologyOrTool() {

        Long techId = technologyTransformBean.addTechnology(technologyDataBean);

        if (techId != null) {
            messageDataBean.setMessage("Technology Added successfully");
            messageDataBean.setIsSuccess(Boolean.TRUE);
            retrieveTechnologiesByType();
        } else {
            messageDataBean.setMessage("Technology Already Exist");
            messageDataBean.setIsSuccess(Boolean.FALSE);

        }
    }

    /**
     * @author Niharika retrieveTechByCategory retrieves all tech by type .
     *
     */
    public void retrieveTechByCategory() {
        systemResultViewUtil.setProjectResourceOS(technologyTransformBean.retrieveOS());
        systemResultViewUtil.setProjectResourceBrowser(technologyTransformBean.retrieveBrowser());
        systemResultViewUtil.setProjectResourceServer(technologyTransformBean.retrieveServer());
        systemResultViewUtil.setProjectResourceTool(technologyTransformBean.retrieveTool());
        systemResultViewUtil.setProjectResourceTech(technologyTransformBean.retrieveTechnology());
    }

    /**
     * @author Brijesh retrieve List Of Technologies and Tool and Browser and
     * Server and save to SystemResultVieweUtil to display on page
     */
    public void retrieveAllActiveTechnology() {
        systemResultViewUtil.setTechnologyList(technologyTransformBean.retrieveTechnologies(Boolean.TRUE));
    }

    /**
     * @author Brijesh Display Technologies And Tool By selecting option
     * according to that it will display Active or InActive or all Technologies.
     */
    public void retrieveTechnologiesByType() {
        technologyDataBean.setShowType(systemResultViewUtil.getShowAllStatus());
        if (technologyDataBean.getShowType() == null) {
            systemResultViewUtil.setTechnologyList(technologyTransformBean.retrieveTechnologies(Boolean.TRUE));
        }
        if (SystemConstantUtil.ACTIVE.equals(technologyDataBean.getShowType())) {
            systemResultViewUtil.setTechnologyList(technologyTransformBean.retrieveTechnologies(Boolean.TRUE));

        }
        if (SystemConstantUtil.INACTIVE.equals(technologyDataBean.getShowType())) {
            systemResultViewUtil.setTechnologyList(technologyTransformBean.retrieveTechnologies(Boolean.FALSE));

        }
        if (SystemConstantUtil.SHOWALL.equals(technologyDataBean.getShowType())) {
            systemResultViewUtil.setTechnologyList(technologyTransformBean.retrieveTechnologies(null));

        }

    }

    /**
     * @author Brijesh retrieve Technology Or Tool By Id for edit technology or
     * tool
     */
    public void retrieveTechOrToolById() {
        technologyTransformBean.retrieveTechOrToolById(technologyDataBean.getTechId());

    }

    /**
     * @author Brijesh update Technology Or Tool after edit detail
     */
    public void updateTechnologyOrTool() {

        technologyTransformBean.updateTechOrTool(technologyDataBean);
        if (true) {
            messageDataBean.setMessage("Data Updated Successfully");
            messageDataBean.setIsSuccess(Boolean.TRUE);
        }
        retrieveTechnologiesByType();
    }

    /**
     * @author Brijesh
     * @param technologyDatabean Change the Status Of the Technology. if it is
     * Active than change it to Inctive and vice versa.
     */
    public void changeTechnologyStatus(TechnologyDataBean technologyDataBean) {

        if (technologyDataBean.getStatus()) {
            technologyDataBean.setStatus(Boolean.FALSE);
        } else {
            technologyDataBean.setStatus(Boolean.TRUE);
        }
        systemResultViewUtil.setTechId(technologyDataBean.getTechId());

        technologyTransformBean.updateTechOrTool(technologyDataBean);
        retrieveTechnologiesByType();

    }

    public void retrieveAllActiveTechnologybyTechnologyType() {
        String techType = "T";
        systemResultViewUtil.setTechnologyList(technologyTransformBean.retrieveTechnologiesByTechnologyType(techType));
    }
}
