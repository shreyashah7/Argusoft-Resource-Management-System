/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.usermanagement.servicebean;

import com.argusoft.armms.web.usermanagement.databean.FeatureDataBean;
import com.argusoft.armms.web.usermanagement.databean.MessageDataBean;
import com.argusoft.armms.web.usermanagement.transformerbean.FeatureTransformerBean;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.generic.database.exception.GenericDatabaseException;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/** 
 * Service bean for providing feature services
 * @author rajkumar
 * @since 08-APR-2014
 */
@ManagedBean(name = "featureServiceBean")
@RequestScoped
public class FeatureServiceBean {

    @ManagedProperty("#{featureTransformerBean}")
    private FeatureTransformerBean featureTransformerBean;

    @ManagedProperty("#{featureDataBean}")
    private FeatureDataBean featureDataBean;

    @ManagedProperty("#{messageDataBean}")
    private MessageDataBean messageDataBean;

    @ManagedProperty("#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    public MessageDataBean getMessageDataBean() {
        return messageDataBean;
    }

    public void setMessageDataBean(MessageDataBean messageDataBean) {
        this.messageDataBean = messageDataBean;
    }

    public FeatureTransformerBean getFeatureTransformerBean() {
        return featureTransformerBean;
    }

    public void setFeatureTransformerBean(FeatureTransformerBean featureTransformerBean) {
        this.featureTransformerBean = featureTransformerBean;
    }

    public FeatureDataBean getFeatureDataBean() {
        return featureDataBean;
    }

    public void setFeatureDataBean(FeatureDataBean featureDataBean) {
        this.featureDataBean = featureDataBean;
    }

    public void addFeature() {
        try {
            if (systemResultViewUtil.getCurrentSelectedFeature() == null) {
                featureTransformerBean.addFeature();
                messageDataBean.setIsSuccess(Boolean.TRUE);
                messageDataBean.setMessage("Feature added successfully");
            }else{
                featureTransformerBean.updateFeature();
                messageDataBean.setIsSuccess(Boolean.TRUE);
                messageDataBean.setMessage("Feature updated successfully");
            }
            retrieveAllFeatures();
        } catch (UMUserManagementException | GenericDatabaseException e) {
            e.printStackTrace();
            messageDataBean.setIsSuccess(Boolean.FALSE);
            messageDataBean.setMessage("Error while adding feature");
        }
    }

    public void retrieveAllFeatures() throws GenericDatabaseException {
        systemResultViewUtil.setListOfFeatures(featureTransformerBean.getAllFeatures());
        systemResultViewUtil.setListOfMenuMenuItemFeatures(featureTransformerBean.getAllMenuMenuitemFeatures());
    }

    public void retrievePermissions(Long featureID, Boolean retrievePermissionOrNot) throws UMUserManagementException, GenericDatabaseException {
        systemResultViewUtil.setCurrentSelectedFeature(featureID);

        if (retrievePermissionOrNot == true) {
            systemResultViewUtil.setListOfPermissionForFeature(featureTransformerBean.retrievePermissionSetOfFeature(featureID));
            systemResultViewUtil.setListOfChildFeature(featureTransformerBean.retrieveAllChildPermissionFeatures(featureID));

        }
        featureTransformerBean.getFeature();
    }
    public void prepareToAdd(){
        featureDataBean.setParent(null);
        featureDataBean.setName(null);
        featureDataBean.setMenuLable(null);
        featureDataBean.setDescription(null);
        featureDataBean.setPrecedence(null);
        featureDataBean.setMenuType(null);
        featureDataBean.setFeatureURL(null);
        featureDataBean.setWebserviceURL(null);
        featureDataBean.setSeqNo(null);
        featureDataBean.setCrud(null);
        featureDataBean.setActive(null);
        featureDataBean.setId(null);
        
        systemResultViewUtil.setListOfPermissionForFeature(null);
        systemResultViewUtil.setListOfChildFeature(null);
        systemResultViewUtil.setCurrentSelectedFeature(null);
    }
    public String getFeatureName(Long featureID) throws UMUserManagementException{
        return(featureTransformerBean.getFeatureName(featureID));
    }
}
