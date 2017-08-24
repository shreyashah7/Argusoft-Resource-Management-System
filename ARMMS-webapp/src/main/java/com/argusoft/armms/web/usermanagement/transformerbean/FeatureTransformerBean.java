/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.usermanagement.transformerbean;

import com.argusoft.armms.web.usermanagement.databean.FeatureDataBean;
import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import com.argusoft.armms.web.usermanagement.databean.PermissionDataBean;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.generic.database.common.GenericDao.QueryOperators;
import com.argusoft.generic.database.exception.GenericDatabaseException;
import com.argusoft.usermanagement.common.core.UMFeatureService;
import com.argusoft.usermanagement.common.database.UMFeatureDao;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import com.argusoft.usermanagement.common.model.UMFeature;
import com.argusoft.usermanagement.common.model.UMFeaturePermission;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * Bean for performing feature related functions
 *
 * @author rajkumar
 * @since 08-APR-2014
 */
@ManagedBean(name = "featureTransformerBean")
@RequestScoped
public class FeatureTransformerBean {

    @ManagedProperty("#{featureDataBean}")
    private FeatureDataBean featureDataBean;

    @ManagedProperty("#{featureService}")
    private UMFeatureService featureService;

    @ManagedProperty("#{loginDataBean}")
    private LoginDataBean loginDataBean;

    @ManagedProperty("#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    public LoginDataBean getLoginDataBean() {
        return loginDataBean;
    }

    public void setLoginDataBean(LoginDataBean loginDataBean) {
        this.loginDataBean = loginDataBean;
    }

    public UMFeatureService getFeatureService() {
        return featureService;
    }

    public void setFeatureService(UMFeatureService featureService) {
        this.featureService = featureService;
    }

    public FeatureDataBean getFeatureDataBean() {
        return featureDataBean;
    }

    public void setFeatureDataBean(FeatureDataBean featureDataBean) {
        this.featureDataBean = featureDataBean;
    }

    /**
     * Adding feature to database
     *
     * @throws
     * com.argusoft.usermanagement.common.exception.UMUserManagementException
     */
    public void addFeature() throws UMUserManagementException {
        UMFeature uMFeature = convertFeatureDataBeanToFeatureModel(featureDataBean);
        featureService.createFeature(uMFeature);
        clearFeatureData();
    }

    /**
     * conversion from databean to model
     *
     * @param featureData
     * @return UMFeature object
     * @throws
     * com.argusoft.usermanagement.common.exception.UMUserManagementException
     */
    public UMFeature convertFeatureDataBeanToFeatureModel(FeatureDataBean featureData) throws UMUserManagementException {
        UMFeature uMFeature = new UMFeature();

        uMFeature.setName(featureData.getName());
        if (featureData.getParent() != null) {
            uMFeature.setParent(featureService.getFeatureByFeatureId(featureData.getParent()));
        } else {
            uMFeature.setParent(null);
        }
        uMFeature.setDescription(featureData.getDescription());
        uMFeature.setMenuLabel(featureData.getMenuLable());
        uMFeature.setPrecedence(featureData.getPrecedence());
        uMFeature.setMenuType(featureData.getMenuType());
        uMFeature.setFeatureUrl(featureData.getFeatureURL());
        uMFeature.setWebserviceUrl(featureData.getWebserviceURL());
        uMFeature.setSeqNo(featureData.getSeqNo());
        uMFeature.setIsCrud(featureData.getCrud());
        uMFeature.setIsActive(featureData.getActive());
        uMFeature.setCreatedBy(loginDataBean.getId());

        return uMFeature;
    }

    /**
     * clearing featureDataBean
     */
    public void clearFeatureData() {
        featureDataBean.setActive(null);
        featureDataBean.setCrud(null);
        featureDataBean.setDescription(null);
        featureDataBean.setEnableDisable(null);
        featureDataBean.setFeatureURL(null);
        featureDataBean.setId(null);
        featureDataBean.setMenuLable(null);
        featureDataBean.setMenuType(null);
        featureDataBean.setName(null);
        featureDataBean.setParent(null);
        featureDataBean.setPrecedence(null);
        featureDataBean.setSeqNo(null);
        featureDataBean.setWebserviceURL(null);
    }

    /**
     * Getting all parent features
     *
     * @return
     */
    public List<FeatureDataBean> getAllFeatures() throws GenericDatabaseException {
        List<String> ids = new ArrayList<>();
        ids.add(UMFeatureDao.PARENT);
        
        Map<String,Object> equals=new HashMap<>();
        equals.put(UMFeatureDao.IS_ACTIVE, Boolean.TRUE);
        
        Map<QueryOperators, Object> criteria = new HashMap<>();
        criteria.put(QueryOperators.IS_NULL, ids);
        criteria.put(QueryOperators.EQUAL, equals);
        
        return (convertFeatureDataBeanToFeatureModel(featureService.retrieveFeatures(null, criteria, null)));
    }

    /**
     * get all menu and menuitems to show in parent dropdown list
     *
     * @return
     * @throws com.argusoft.generic.database.exception.GenericDatabaseException
     */
    public List<FeatureDataBean> getAllMenuMenuitemFeatures() throws GenericDatabaseException {
        List<String> MenutypesRequired = new ArrayList<>();
        MenutypesRequired.add("Menu");
        MenutypesRequired.add("MenuItem");
        return (convertFeatureDataBeanToFeatureModel(featureService.retrieveAllFeaturesByListOfMenuType(MenutypesRequired, null, true, false)));
    }

    /**
     * converting from list of UMFeature to List of databean
     *
     * @param uMFeature
     * @return
     */
    public List<FeatureDataBean> convertFeatureDataBeanToFeatureModel(List<UMFeature> uMFeature) {
        List<FeatureDataBean> result = new ArrayList<>();

        for (UMFeature uMFeature1 : uMFeature) {
            FeatureDataBean featureDataBean1 = new FeatureDataBean();

            featureDataBean1.setId(uMFeature1.getId());
            featureDataBean1.setName(uMFeature1.getName());
            featureDataBean1.setDescription(uMFeature1.getDescription());
            featureDataBean1.setFeatureURL(uMFeature1.getFeatureUrl());
            featureDataBean1.setWebserviceURL(uMFeature1.getWebserviceUrl());
            featureDataBean1.setActive(uMFeature1.getIsActive());
            featureDataBean1.setCrud(uMFeature1.getIsCrud());
            featureDataBean1.setMenuLable(uMFeature1.getMenuLabel());
            featureDataBean1.setMenuType(uMFeature1.getMenuType());

            result.add(featureDataBean1);
        }
        return result;
    }

    /**
     * retrieve all child features from parent feature ID
     *
     * @param parentFeatureId
     * @return list of child features
     * @throws com.argusoft.generic.database.exception.GenericDatabaseException
     * @throws
     * com.argusoft.usermanagement.common.exception.UMUserManagementException
     */
    public List<FeatureDataBean> retrieveAllChildFeatures(Long parentFeatureId) throws GenericDatabaseException, UMUserManagementException {

        return (convertFeatureDataBeanToFeatureModel(featureService.retrieveFeaturesByParentByCompany(parentFeatureId, null)));
    }

    public List<FeatureDataBean> retrieveAllChildPermissionFeatures(Long parentFeatureId) throws GenericDatabaseException, UMUserManagementException {
        Map<String, Object> searchQuery = new HashMap<>();
        searchQuery.put(UMFeatureDao.PARENT, featureService.getFeatureByFeatureId(parentFeatureId));
        List<UMFeature> allFeatures = featureService.retrieveFeatures(searchQuery, null, null, null);
        return (convertFeatureDataBeanToFeatureModel(allFeatures));
    }

    /**
     * retrieve all permission object for feature
     *
     * @param featureID
     * @return
     */
    public List<PermissionDataBean> retrievePermissionSetOfFeature(Long featureID) {
        List<UMFeaturePermission> permissionSetOfFeature = featureService.retrieveFeaturePermissionsByFeatureAndCompany(featureID, null, false, false, false);
        return (convertFeaturePermissionToFeaturePermissionDataBean(permissionSetOfFeature));
    }

    /**
     * conversion from feature permission object to data bean
     *
     * @param permissionSetOfFeature
     * @return
     */
    public List<PermissionDataBean> convertFeaturePermissionToFeaturePermissionDataBean(List<UMFeaturePermission> permissionSetOfFeature) {
        List<PermissionDataBean> permissionByDataBean = new ArrayList<>();
        for (UMFeaturePermission uMFeaturePermission : permissionSetOfFeature) {
            PermissionDataBean result = new PermissionDataBean();

            result.setID(uMFeaturePermission.getId());
            result.setName(uMFeaturePermission.getName());
            result.setAttributes(uMFeaturePermission.getAttributes().replaceAll("#", "").split(","));

            permissionByDataBean.add(result);
        }
        return permissionByDataBean;
    }

    /**
     * retrieve feature by ID
     *
     * @throws UMUserManagementException
     */
    public void getFeature() throws UMUserManagementException {
        UMFeature featureToUpdate = featureService.getFeatureByFeatureId(systemResultViewUtil.getCurrentSelectedFeature());

        featureDataBean.setName(featureToUpdate.getName());
        if (featureToUpdate.getParent() != null) {
            featureDataBean.setParent(featureService.getFeatureByFeatureId(featureToUpdate.getParent().getId()).getId());
        } else {
            featureDataBean.setParent(null);
        }
        featureDataBean.setMenuLable(featureToUpdate.getMenuLabel());
        featureDataBean.setDescription(featureToUpdate.getDescription());
        featureDataBean.setPrecedence(featureToUpdate.getPrecedence());
        featureDataBean.setMenuType(featureToUpdate.getMenuType());
        featureDataBean.setFeatureURL(featureToUpdate.getFeatureUrl());
        featureDataBean.setWebserviceURL(featureToUpdate.getWebserviceUrl());
        featureDataBean.setSeqNo(featureToUpdate.getSeqNo());
        featureDataBean.setCrud(featureToUpdate.getIsCrud());
        featureDataBean.setActive(featureToUpdate.getIsActive());

    }

    /**
     * update feature data
     *
     * @throws UMUserManagementException
     */
    public void updateFeature() throws UMUserManagementException {
        UMFeature featureToUpdate = featureService.getFeatureByFeatureId(systemResultViewUtil.getCurrentSelectedFeature());

        featureToUpdate.setId(systemResultViewUtil.getCurrentSelectedFeature());
        featureToUpdate.setName(featureDataBean.getName());
        featureToUpdate.setDescription(featureDataBean.getDescription());
        if (featureDataBean.getParent() != null) {
            featureToUpdate.setParent(featureService.getFeatureByFeatureId(featureDataBean.getParent()));
        } else {
            featureDataBean.setParent(null);
        }
        featureToUpdate.setMenuLabel(featureDataBean.getMenuLable());
        featureToUpdate.setPrecedence(featureDataBean.getPrecedence());
        featureToUpdate.setMenuType(featureDataBean.getMenuType());
        featureToUpdate.setFeatureUrl(featureDataBean.getFeatureURL());
        featureToUpdate.setWebserviceUrl(featureDataBean.getWebserviceURL());
        featureToUpdate.setSeqNo(featureDataBean.getSeqNo());
        featureToUpdate.setIsCrud(featureDataBean.getCrud());
        featureToUpdate.setIsActive(featureDataBean.getActive());
        featureToUpdate.setIsArchive(Boolean.FALSE);
        featureToUpdate.setModifiedOn(new Date());

        featureService.updateFeature(featureToUpdate);
        clearFeatureData();
    }

    /**
     * get feature by ID
     *
     * @param featureID
     * @return
     * @throws UMUserManagementException
     */
    public UMFeature getFeatureById(Long featureID) throws UMUserManagementException {
        return (featureService.getFeatureByFeatureId(featureID));
    }

    public String getFeatureName(Long featureID) throws UMUserManagementException {
        return (featureService.getFeatureByFeatureId(featureID).getName());
    }

}
