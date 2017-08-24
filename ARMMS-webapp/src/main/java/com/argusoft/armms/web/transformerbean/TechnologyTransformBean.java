/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.transformerbean;

import com.argusoft.armms.core.ProjectService;
import com.argusoft.armms.core.UserSkillsService;
import com.argusoft.armms.model.ProjectResourceDetail;
import com.argusoft.armms.model.ProjectTechnologyDetail;
import com.argusoft.armms.model.TechnologyMaster;
import com.argusoft.armms.web.databean.ProjectResourceDataBean;
import com.argusoft.armms.web.databean.TechnologyDataBean;
import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import com.argusoft.armms.web.util.SystemConstantUtil;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.usermanagement.common.core.UMSystemConfigurationService;
import com.argusoft.usermanagement.common.core.UMUserService;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import com.argusoft.usermanagement.common.model.UMSystemConfiguration;
import com.argusoft.usermanagement.common.model.UMUser;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author brijesh
 */
@ManagedBean(name = "technologyTransformBean")
@RequestScoped
public class TechnologyTransformBean {

    @ManagedProperty("#{userSkillsService}")
    private UserSkillsService userSkillsService;
    @ManagedProperty("#{loginDataBean}")
    private LoginDataBean loginDataBean;
    @ManagedProperty(value = "#{uMUserService}")
    private UMUserService uMUserService;
    @ManagedProperty(value = "#{technologyDataBean}")
    private TechnologyDataBean technologyDataBean;
    @ManagedProperty(value = "#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;
    @ManagedProperty(value = "#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;
    @ManagedProperty(value = "#{systemConfigurationService}")
    private UMSystemConfigurationService systemConfigurationService;
    @ManagedProperty(value = "#{userService}")
    private UMUserService userService;
    @ManagedProperty(value = "#{projectService}")
    private ProjectService projectService;
    List<TechnologyMaster> techList;

    public List<TechnologyMaster> getTechList() {
        techList = userSkillsService.retrieveTechnologies(Boolean.TRUE);
        return techList;
    }

    public void setTechList(List<TechnologyMaster> techList) {
        this.techList = techList;
    }

    public SystemResultSessionUtil getSystemResultSessionUtil() {
        return systemResultSessionUtil;
    }

    public void setSystemResultSessionUtil(SystemResultSessionUtil systemResultSessionUtil) {
        this.systemResultSessionUtil = systemResultSessionUtil;
    }

    public UMUserService getUserService() {
        return userService;
    }

    public void setUserService(UMUserService userService) {
        this.userService = userService;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public TechnologyDataBean getTechnologyDataBean() {
        return technologyDataBean;
    }

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    public UMSystemConfigurationService getSystemConfigurationService() {
        return systemConfigurationService;
    }

    public void setSystemConfigurationService(UMSystemConfigurationService systemConfigurationService) {
        this.systemConfigurationService = systemConfigurationService;
    }

    public void setTechnologyDataBean(TechnologyDataBean technologyDataBean) {
        this.technologyDataBean = technologyDataBean;
    }

    public UserSkillsService getUserSkillsService() {
        return userSkillsService;
    }

    public void setUserSkillsService(UserSkillsService userSkillsService) {
        this.userSkillsService = userSkillsService;
    }

    public UMUserService getuMUserService() {
        return uMUserService;
    }

    public void setuMUserService(UMUserService userService) {
        this.uMUserService = userService;
    }

    public LoginDataBean getLoginDataBean() {
        return loginDataBean;
    }

    public void setLoginDataBean(LoginDataBean loginDataBean) {
        this.loginDataBean = loginDataBean;
    }

    /**
     * add new Technology Detail while adding technology
     *
     * @author Brijesh
     * @param technologyDataBean
     */
    public Long addTechnology(TechnologyDataBean technologyDataBean) {
        technologyDataBean.setStatus(Boolean.TRUE);
        List<TechnologyMaster> technologyMastersList = userSkillsService.retrieveTechnologyByTechnologyName(technologyDataBean.getName());
        System.out.println("++++++technologyMastersList=====" + technologyMastersList);
        if (technologyMastersList == null || technologyMastersList.isEmpty()) {

            TechnologyMaster technologyMaster = new TechnologyMaster();
            technologyMaster.setCreatedBy(loginDataBean.getId());
            technologyMaster = convertTechnologyDataBeanToTechnologyModel(technologyDataBean, technologyMaster);
            Long Techid = userSkillsService.createTechnology(technologyMaster);
            return Techid;

        } else {
            return null;

        }
    }

    /**
     * convert TechnologyDataBean To TechnologyModel
     *
     * @author Brijesh
     * @param technologyDataBean
     * @param technologyMaster
     * @return TechnologyMaster Object
     */
    public TechnologyMaster convertTechnologyDataBeanToTechnologyModel(TechnologyDataBean technologyDataBean, TechnologyMaster technologyMaster) {
        if (technologyMaster == null) {
            technologyMaster = new TechnologyMaster();
        }
        try {
            technologyMaster.setTechType(technologyDataBean.getType());
            technologyMaster.setIsActive(technologyDataBean.getStatus());
            technologyMaster.setTechnologyName(technologyDataBean.getName());
            technologyMaster.setTechnologyDesc(technologyDataBean.getDescription());
            technologyMaster.setLastModifiedBy(loginDataBean.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return technologyMaster;
    }

    /**
     * convert TechnologyModel To TechnologyDataBean
     *
     * @author Brijesh
     * @param technologyMaster object
     * @return technologyDatabean Object
     */
    public TechnologyDataBean convertTechnologyModelToTechnologyDataBean(TechnologyMaster technologyMaster) {
        TechnologyDataBean technologyDataBean = new TechnologyDataBean();
        try {
            technologyDataBean.setName(technologyMaster.getTechnologyName());
            technologyDataBean.setDescription(technologyMaster.getTechnologyDesc());
            technologyDataBean.setType(technologyMaster.getTechType());
            technologyDataBean.setStatus(technologyMaster.getIsActive());
            technologyDataBean.setTechId(technologyMaster.getTechnologyId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return technologyDataBean;
    }

    /**
     * @author niharika retrieveTechnology gets all technology whose type is
     * Technology('T')
     * @return list of technology with type 'T' along with its id.
     */
    public List<ProjectResourceDataBean> retrieveTechnology() {
        List<ProjectResourceDataBean> techlist = new ArrayList<>();
        List<TechnologyMaster> technoList = this.getTechList();

        for (TechnologyMaster master : technoList) {
            if (master.getTechType().equalsIgnoreCase(SystemConstantUtil.TECHNOLOGY)) {
                ProjectResourceDataBean resourceDataBean = new ProjectResourceDataBean();
                resourceDataBean.setTechId(master.getTechnologyId());
                resourceDataBean.setTechnologyName(master.getTechnologyName());
                techlist.add(resourceDataBean);
            }
        }
        return techlist;
    }

    /**
     * retrieveTool gets all technology whose type is tool('L')
     *
     * @author niharika
     * @return list of technology with type 'L' along with its id.
     */
    public List<SelectItem> retrieveTool() {
        List<SelectItem> toollist = new ArrayList<>();
        List<TechnologyMaster> technoList = this.getTechList();
        for (TechnologyMaster master : technoList) {
            if (master.getTechType().equalsIgnoreCase(SystemConstantUtil.TOOL)) {
                SelectItem resourceDataBean = new SelectItem(master.getTechnologyId(), master.getTechnologyName());
                toollist.add(resourceDataBean);
            }
        }
        return toollist;
    }

    /**
     * retrieveServer gets all technology whose type is server('S')
     *
     * @author niharika
     * @return list of technology with type 'S' along with its id.
     */
    public List<SelectItem> retrieveServer() {
        List<TechnologyMaster> technoList = this.getTechList();
        List<SelectItem> serverlist = new ArrayList<>();
        for (TechnologyMaster master : technoList) {
            if (master.getTechType().equalsIgnoreCase(SystemConstantUtil.SERVER)) {
                SelectItem resourceDataBean = new SelectItem(master.getTechnologyId(), master.getTechnologyName());
                serverlist.add(resourceDataBean);
            }
        }
        return serverlist;
    }

    /**
     * retrieveOS gets all technology whose type is operating system('O')
     *
     * @author niharika
     * @return list of technology with type 'O' along with its id.
     */
    public List<SelectItem> retrieveOS() {
        List<TechnologyMaster> technoList = this.getTechList();
        List<SelectItem> OSlist = new ArrayList<>();
        for (TechnologyMaster master : technoList) {
            if (master.getTechType().equalsIgnoreCase(SystemConstantUtil.OPERATING_SYSTEM)) {
                SelectItem resourceDataBean = new SelectItem(master.getTechnologyId(), master.getTechnologyName());
                OSlist.add(resourceDataBean);
            }
        }
        return OSlist;
    }

    /**
     * retrieveBrowser gets all technology whose type is Browser('B')
     *
     * @author niharika
     * @return list of technology with type 'B' along with its id.
     */
    public List<SelectItem> retrieveBrowser() {

        List<TechnologyMaster> technoList = this.getTechList();
        List<SelectItem> Browserlist = new ArrayList<>();
        for (TechnologyMaster master : technoList) {

            if (master.getTechType().equalsIgnoreCase(SystemConstantUtil.BROWSER)) {
                SelectItem resourceDataBean = new SelectItem(master.getTechnologyId(), master.getTechnologyName());
                Browserlist.add(resourceDataBean);

            }

        }

        return Browserlist;
    }

    /**
     * retrieve List Of Technologies and Tool and Browser and Server according
     * to input parameter
     *
     * @author Brijesh
     * @param flag
     * @return list of TechnologyDataBean
     */
    public List<TechnologyDataBean> retrieveTechnologies(Boolean flag) {

        List<TechnologyMaster> technologyList = userSkillsService.retrieveTechnologies(flag);
        List<TechnologyDataBean> techlistDataBeans = new ArrayList<>();
        TechnologyDataBean technologyDataBean = new TechnologyDataBean();
        for (TechnologyMaster master : technologyList) {
            technologyDataBean = this.convertTechnologyModelToTechnologyDataBean(master);
            techlistDataBeans.add(technologyDataBean);
        }
        return techlistDataBeans;
    }

    public List<TechnologyDataBean> retrieveTechnologiesByTechnologyType(String TechnologyType) {

        List<TechnologyMaster> technologyList = userSkillsService.retrieveAllActiveTechnologiesByTechnologyType(TechnologyType);
        List<TechnologyDataBean> techlistDataBeans = new ArrayList<>();
        TechnologyDataBean technologyDataBean = new TechnologyDataBean();
        for (TechnologyMaster master : technologyList) {
            technologyDataBean = this.convertTechnologyModelToTechnologyDataBean(master);
            techlistDataBeans.add(technologyDataBean);
        }
        return techlistDataBeans;
    }

    /**
     * retrieve Tech Or Tool By Id
     *
     * @author Brijesh
     * @param techId
     * @return TechnologyDataBean Object
     */
    public TechnologyDataBean retrieveTechOrToolById(Long techId) {
        TechnologyMaster technologyMaster = new TechnologyMaster();
        technologyMaster = userSkillsService.retrieveTechnologyById(techId);
        systemResultViewUtil.setTechId(technologyMaster.getTechnologyId());
        technologyDataBean.setName(technologyMaster.getTechnologyName());
        technologyDataBean.setDescription(technologyMaster.getTechnologyDesc());
        technologyDataBean.setType(technologyMaster.getTechType());
        technologyDataBean.setStatus(technologyMaster.getIsActive());
        technologyDataBean.setTechId(technologyMaster.getTechnologyId());
        return technologyDataBean;
    }

    /**
     * update Tech Or Tool
     *
     * @author Brijesh
     * @param technologyDataBean
     */
    public void updateTechOrTool(TechnologyDataBean technologyDataBean) {
        TechnologyMaster technologyMaster = userSkillsService.retrieveTechnologyById(systemResultViewUtil.getTechId());
        technologyMaster = convertTechnologyDataBeanToTechnologyModel(technologyDataBean, technologyMaster);
        userSkillsService.updateTechnology(technologyMaster);
        systemResultViewUtil.setTechId(null);
    }

}
