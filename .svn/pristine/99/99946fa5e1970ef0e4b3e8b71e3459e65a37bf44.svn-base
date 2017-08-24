/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.usermanagement.servicebean;

import com.argusoft.armms.web.security.WebSecurityUtil;
import com.argusoft.armms.web.usermanagement.databean.FeatureDataBean;
import com.argusoft.armms.web.usermanagement.databean.MessageDataBean;
import com.argusoft.armms.web.usermanagement.databean.PermissionDataBean;
import com.argusoft.armms.web.usermanagement.databean.RoleDataBean;
import com.argusoft.armms.web.usermanagement.transformerbean.FeatureTransformerBean;
import com.argusoft.armms.web.usermanagement.transformerbean.PermissionTransformerBean;
import com.argusoft.armms.web.usermanagement.transformerbean.RoleTransformerBean;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.generic.database.exception.GenericDatabaseException;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import com.argusoft.usermanagement.common.model.UMFeature;
import com.argusoft.usermanagement.common.model.UMFeaturePermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.apache.commons.lang.ArrayUtils;
import org.apache.poi.hssf.record.FeatRecord;

/**
 * Service bean for role
 *
 * @author rajkumar
 * @since 08-APR-2014
 */
@ManagedBean(name = "roleServiceBean")
@RequestScoped
public class RoleServiceBean {

    @ManagedProperty("#{roleTransformerBean}")
    private RoleTransformerBean roleTransformerBean;

    @ManagedProperty("#{featureTransformerBean}")
    private FeatureTransformerBean featureTransformerBean;

    @ManagedProperty("#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;

    @ManagedProperty("#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;

    @ManagedProperty("#{permissionDataBean}")
    private PermissionDataBean permissionDataBean;

    @ManagedProperty("#{roleDataBean}")
    private RoleDataBean roleDataBean;

    @ManagedProperty("#{permissionTransformerBean}")
    private PermissionTransformerBean permissionTransformerBean;

    @ManagedProperty("#{messageDataBean}")
    private MessageDataBean messageDataBean;

    @ManagedProperty(value = "#{webSecurityUtil}")
    private WebSecurityUtil webSecurityUtil;

    public WebSecurityUtil getWebSecurityUtil() {
        return webSecurityUtil;
    }

    public void setWebSecurityUtil(WebSecurityUtil webSecurityUtil) {
        this.webSecurityUtil = webSecurityUtil;
    }

    public SystemResultSessionUtil getSystemResultSessionUtil() {
        return systemResultSessionUtil;
    }

    public void setSystemResultSessionUtil(SystemResultSessionUtil systemResultSessionUtil) {
        this.systemResultSessionUtil = systemResultSessionUtil;
    }

    public RoleDataBean getRoleDataBean() {
        return roleDataBean;
    }

    public void setRoleDataBean(RoleDataBean roleDataBean) {
        this.roleDataBean = roleDataBean;
    }

    public MessageDataBean getMessageDataBean() {
        return messageDataBean;
    }

    public void setMessageDataBean(MessageDataBean messageDataBean) {
        this.messageDataBean = messageDataBean;
    }

    public RoleTransformerBean getRoleTransformerBean() {
        return roleTransformerBean;
    }

    public PermissionTransformerBean getPermissionTransformerBean() {
        return permissionTransformerBean;
    }

    public void setPermissionTransformerBean(PermissionTransformerBean permissionTransformerBean) {
        this.permissionTransformerBean = permissionTransformerBean;
    }

    public FeatureTransformerBean getFeatureTransformerBean() {
        return featureTransformerBean;
    }

    public void setFeatureTransformerBean(FeatureTransformerBean featureTransformerBean) {
        this.featureTransformerBean = featureTransformerBean;
    }

    public void setRoleTransformerBean(RoleTransformerBean roleTransformerBean) {
        this.roleTransformerBean = roleTransformerBean;
    }

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    public PermissionDataBean getPermissionDataBean() {
        return permissionDataBean;
    }

    public void setPermissionDataBean(PermissionDataBean permissionDataBean) {
        this.permissionDataBean = permissionDataBean;
    }

    public void retrieveAllFeatures() throws UMUserManagementException, GenericDatabaseException {
        if (systemResultSessionUtil.getRoleIdToUpdate() != null) {
            roleTransformerBean.loadDataToUpdate();

        }
        systemResultViewUtil.setListOfFeatures(roleTransformerBean.retrieveAllMenuItems());
        if (!systemResultViewUtil.getListOfFeatures().isEmpty()) {
            systemResultViewUtil.setParentFeature(systemResultViewUtil.getListOfFeatures().get(0).getId());
            systemResultViewUtil.setParentFeatureName(systemResultViewUtil.getListOfFeatures().get(0).getName());
            retrievePermissionSetOfFeature(systemResultViewUtil.getParentFeature());
        }

    }

    public void retrievePermissionSetOfFeature(Long featureID) throws UMUserManagementException, GenericDatabaseException {
        systemResultViewUtil.setAddNew(false);
        systemResultViewUtil.setListOfPermissionForFeature(roleTransformerBean.retrievePermissionSetOfFeature(featureID));
        systemResultViewUtil.setParentFeatureName(featureTransformerBean.getFeatureById(featureID).getName());
        if (!systemResultViewUtil.getListOfPermissionForFeature().isEmpty()) {
            systemResultViewUtil.setListOfFeaturePermisssion(roleTransformerBean.retrieveFeatureAsPermissionSet(systemResultViewUtil.getListOfPermissionForFeature().get(0).getAttributes(), true));
        } else {
            systemResultViewUtil.setListOfFeaturePermisssion(new ArrayList<FeatureDataBean>());
        }
    }

    public void retrievePermissionByID(Long permissionID, Long featureID) throws UMUserManagementException, GenericDatabaseException {
        systemResultViewUtil.setAddNew(null);
        systemResultViewUtil.setListOfFeaturePermisssion(null);

        systemResultViewUtil.setListOfFeaturePermisssion(roleTransformerBean.retrievePermissionsetByID(permissionID, featureID));

        if (permissionID == 0l) {
            systemResultViewUtil.setAddNew(true);
        } else {
            systemResultViewUtil.setAddNew(false);
        }
    }

    public void addFeaturePermissionToSet(Long PermissionID) {
        try {
            //Checking permission for feature already exist or not
            List<Map<Long, String>> checkExistingList = systemResultViewUtil.getSelectedFeaturePermissionForRole();
            boolean flag = true;
            if (checkExistingList != null) {
                for (Map mapForpermission : checkExistingList) {
                    Long keyval = (Long) mapForpermission.keySet().iterator().next();
                    if (keyval == systemResultViewUtil.getParentFeature()) {
                        flag = false;
                        break;
                    }
                }
            }
            //If entry not exist for feature enter it
            if (flag) {
                //For adding new permission
                if (PermissionID == 0) {
                    String[] min_permission = roleTransformerBean.getMinimumPermissionAttributes(systemResultViewUtil.getParentFeature());

                    String[] permissions = systemResultViewUtil.getPermissionsSelected();
                    Object[] resultPermission = ArrayUtils.addAll(min_permission, permissions);
                    String[] resultPermissionSelected = Arrays.copyOf(resultPermission, resultPermission.length, String[].class);

                    PermissionID = permissionTransformerBean.addPermissionFromRole(systemResultViewUtil.getParentFeature(), resultPermissionSelected, roleDataBean.getPermissionName());
                    systemResultViewUtil.setListOfPermissionForFeature(roleTransformerBean.retrievePermissionSetOfFeature(systemResultViewUtil.getParentFeature()));
                }
                if (PermissionID != null) {
                    Map<Long, String> featurePermission = new LinkedHashMap<>();
                    UMFeature uMFeature = featureTransformerBean.getFeatureById(systemResultViewUtil.getParentFeature());
                    featurePermission.put(uMFeature.getId(), uMFeature.getName());

                    UMFeaturePermission uMFeaturePermission = permissionTransformerBean.getPermissionById(PermissionID);
                    featurePermission.put(uMFeaturePermission.getId(), uMFeaturePermission.getName());

                    if (systemResultViewUtil.getSelectedFeaturePermissionForRole() == null) {
                        systemResultViewUtil.setSelectedFeaturePermissionForRole(new ArrayList<Map<Long, String>>());
                    }

                    systemResultViewUtil.getSelectedFeaturePermissionForRole().add(featurePermission);

                    messageDataBean.setIsSuccess(Boolean.TRUE);
                    messageDataBean.setMessage("Permission added successfully");
                } else {
                    messageDataBean.setIsSuccess(Boolean.FALSE);
                    messageDataBean.setMessage("Permission name already exist");
                }
            } else {
                messageDataBean.setIsSuccess(Boolean.FALSE);
                messageDataBean.setMessage("Duplicate entry for feature, remove existing entry first then try again.");
            }

        } catch (GenericDatabaseException | UMUserManagementException e) {
            e.printStackTrace();
        }

    }

    public void addRole() {
        try {
            if (systemResultViewUtil.getSelectedFeaturePermissionForRole().isEmpty()) {
                messageDataBean.setIsSuccess(Boolean.FALSE);
                messageDataBean.setMessage("Select permissions for role");
            } else {
                roleTransformerBean.addRole();
                clearFormData();
                systemResultViewUtil.setListOfAllActiveRoles(roleTransformerBean.retrieveAllActiveRoles());
                messageDataBean.setIsSuccess(Boolean.TRUE);
                messageDataBean.setMessage("Role Added successfully");
            }
        } catch (UMUserManagementException | GenericDatabaseException e) {
            e.printStackTrace();
            messageDataBean.setIsSuccess(Boolean.FALSE);
            messageDataBean.setMessage("Error while adding role");
        }
    }

    public void retrieveAllRoles() throws GenericDatabaseException {
        roleTransformerBean.retrieveAllRoles();
    }

    public void removeFeaturePermissionFromList(Map<Long, String> mapToRemove) {
        systemResultViewUtil.getSelectedFeaturePermissionForRole().remove(mapToRemove);
    }

    public String updateRole(String roleName) throws GenericDatabaseException {
        roleTransformerBean.updateRole(roleName);
        return "manageRole?faces-redirect=true";
    }

    public String createRole() {
        systemResultSessionUtil.setRoleIdToUpdate(null);

        return "manageRole?faces-redirect=true";
    }

    public String updateRoleData() throws UMUserManagementException {
        try {
            roleTransformerBean.updateRoleData();
            clearFormData();
            webSecurityUtil.initializeUrlRoles();
            return "role?faces-redirect=true";
        } catch (GenericDatabaseException | UMUserManagementException e) {
            messageDataBean.setIsSuccess(Boolean.FALSE);
            messageDataBean.setMessage("Error while updating role");
            return "manageRole?faces-redirect=true";
        } finally {
            systemResultSessionUtil.setRoleIdToUpdate(null);

        }
    }

    private void clearFormData() {
        roleDataBean.setName(null);
        roleDataBean.setDescription(null);

        systemResultViewUtil.setSelectedFeaturePermissionForRole(null);
    }

    public String cancelEditing() {
        systemResultSessionUtil.setRoleIdToUpdate(null);

        return "role?faces-redirect=true";
    }

    public void retrieveAllActiveRoles() throws GenericDatabaseException {
        systemResultViewUtil.setListOfAllActiveRoles(roleTransformerBean.retrieveAllActiveRoles());
    }

    public void updateRoleFromPage(Long roleIDtoUpdate) throws UMUserManagementException, GenericDatabaseException {
        if (roleIDtoUpdate != null) {
            systemResultSessionUtil.setRoleIdToUpdate(roleIDtoUpdate);

            this.retrieveAllFeatures();
        } else {
            systemResultSessionUtil.setRoleIdToUpdate(null);
            clearFormData();
            systemResultViewUtil.setSelectedFeaturePermissionForRole(new ArrayList<Map<Long, String>>());
        }
    }

    public void checkDeleteRole() throws UMUserManagementException, GenericDatabaseException {
        roleTransformerBean.checkDeleteRole(systemResultSessionUtil.getRoleNameToRemove());
    }

    public void changeRole(Long user_Id) throws GenericDatabaseException, UMUserManagementException {
        roleTransformerBean.changeRole(user_Id);
    }

    public String removeRole() throws GenericDatabaseException {
        Boolean result = roleTransformerBean.checkForRoleAssociationWithUser(systemResultSessionUtil.getRoleNameToRemove());

        if (result) {
            webSecurityUtil.initializeUrlRoles();
            return "role?faces-redirect=true";
        } else {
            messageDataBean.setIsSuccess(false);
            messageDataBean.setMessage("Some users are still associated with role change role of that user first");

            return null;
        }
    }
}
