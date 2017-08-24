/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.usermanagement.transformerbean;

import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import com.argusoft.armms.web.usermanagement.databean.MessageDataBean;
import com.argusoft.armms.web.usermanagement.databean.PermissionDataBean;
import com.argusoft.armms.web.usermanagement.databean.RoleDataBean;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.generic.database.exception.GenericDatabaseException;
import com.argusoft.usermanagement.common.core.UMFeatureService;
import com.argusoft.usermanagement.common.core.UMRoleService;
import com.argusoft.usermanagement.common.database.UMFeaturePermissionDao;
import com.argusoft.usermanagement.common.database.UMRoleDao;
import com.argusoft.usermanagement.common.database.UMRoleFeatureDao;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import com.argusoft.usermanagement.common.model.UMFeaturePermission;
import com.argusoft.usermanagement.common.model.UMRole;
import com.argusoft.usermanagement.common.model.UMRoleFeature;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * Bean for performing permission related actions
 *
 * @author rajkumar
 * @since 08-APR-2014
 */
@ManagedBean(name = "permissionTransformerBean")
@RequestScoped
public class PermissionTransformerBean {

    @ManagedProperty(value = "#{permissionDataBean}")
    private PermissionDataBean permissionDataBean;

    @ManagedProperty("#{featureService}")
    private UMFeatureService uMFeatureService;

    @ManagedProperty("#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;

    @ManagedProperty("#{loginDataBean}")
    private LoginDataBean loginDataBean;

    @ManagedProperty("#{roleService}")
    private UMRoleService roleService;

    @ManagedProperty("#{messageDataBean}")
    private MessageDataBean messageDataBean;

    public MessageDataBean getMessageDataBean() {
        return messageDataBean;
    }

    public void setMessageDataBean(MessageDataBean messageDataBean) {
        this.messageDataBean = messageDataBean;
    }

    public UMRoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(UMRoleService roleService) {
        this.roleService = roleService;
    }

    public LoginDataBean getLoginDataBean() {
        return loginDataBean;
    }

    public void setLoginDataBean(LoginDataBean loginDataBean) {
        this.loginDataBean = loginDataBean;
    }

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    public UMFeatureService getuMFeatureService() {
        return uMFeatureService;
    }

    public void setuMFeatureService(UMFeatureService uMFeatureService) {
        this.uMFeatureService = uMFeatureService;
    }

    public PermissionDataBean getPermissionDataBean() {
        return permissionDataBean;
    }

    public void setPermissionDataBean(PermissionDataBean permissionDataBean) {
        this.permissionDataBean = permissionDataBean;
    }

    /**
     * retrieve permission by ID
     */
    public void retrievePermissionById() {
        if (permissionDataBean.getID() == null) {
            clearPermissionDataBean();
        } else {
            PermissionDataBean resultDataBean = convertFeaturePermissionToFeaturePermissionDataBean(uMFeatureService.retrieveFeaturePermissionById(permissionDataBean.getID(), false, false, false));

            permissionDataBean.setID(resultDataBean.getID());
            permissionDataBean.setName(resultDataBean.getName());
            permissionDataBean.setAttributes(resultDataBean.getAttributes());
        }
    }

    public UMFeaturePermission getPermissionById(Long permissionID) {

        return (uMFeatureService.retrieveFeaturePermissionById(permissionID, false, false, false));

    }

    /**
     * conversion from feature permission to permission data bean
     *
     * @param permissionModel
     * @return
     */
    public PermissionDataBean convertFeaturePermissionToFeaturePermissionDataBean(UMFeaturePermission permissionModel) {
        PermissionDataBean permissionByDataBean = new PermissionDataBean();

        permissionByDataBean.setID(permissionModel.getId());
        permissionByDataBean.setName(permissionModel.getName());
        permissionByDataBean.setAttributes(permissionModel.getAttributes().replaceAll("#", "").split(","));

        return permissionByDataBean;
    }

    /**
     * clearing permission bean
     */
    public void clearPermissionDataBean() {
        permissionDataBean.setID(null);
        permissionDataBean.setName(null);
        permissionDataBean.setAttributes(null);
    }

    /**
     * add permission to database
     *
     * @return
     * @throws UMUserManagementException
     */
    public Long addPermission() throws UMUserManagementException {
        List<UMFeaturePermission> uMFeaturePermissions = uMFeatureService.retrieveFeaturePermissionsByFeatureAndCompany(systemResultViewUtil.getCurrentSelectedFeature(), null, false, false, false);
        boolean flag = true;
        for (UMFeaturePermission uMFeaturePermission : uMFeaturePermissions) {
            if (uMFeaturePermission.getName().equalsIgnoreCase(permissionDataBean.getName())) {
                flag = false;
                break;
            }
        }
        if (flag) {
            UMFeaturePermission newPermission = convertPermissionDataBeanToPermissionModel(permissionDataBean);
            clearPermissionDataBean();
            return (uMFeatureService.createFeaturePermission(newPermission));
        } else {
            messageDataBean.setMessage("Permission name already exist");
            messageDataBean.setIsSuccess(false);
        }
        clearPermissionDataBean();
        return null;
    }

    /**
     * add permission: values retrieved from role page
     *
     * @param featureID
     * @param attributes
     * @param name
     * @return
     * @throws UMUserManagementException
     */
    public Long addPermissionFromRole(Long featureID, String[] attributes, String name) throws UMUserManagementException {
        systemResultViewUtil.setCurrentSelectedFeature(featureID);
        permissionDataBean.setAttributes(attributes);
        permissionDataBean.setName(name);

        List<UMFeaturePermission> uMFeaturePermissions = uMFeatureService.retrieveFeaturePermissionsByFeatureAndCompany(systemResultViewUtil.getCurrentSelectedFeature(), null, false, false, false);
        boolean flag = true;
        for (UMFeaturePermission uMFeaturePermission : uMFeaturePermissions) {
            if (uMFeaturePermission.getName().equalsIgnoreCase(permissionDataBean.getName())) {
                flag = false;
                break;
            }
        }
        if (flag) {
            UMFeaturePermission newPermission = convertPermissionDataBeanToPermissionModel(permissionDataBean);
            clearPermissionDataBean();
            return (uMFeatureService.createFeaturePermission(newPermission));

        } else {
            messageDataBean.setMessage("Permission name already exist");
            messageDataBean.setIsSuccess(false);
        }
        clearPermissionDataBean();
        return null;
    }

    /**
     * update data of permission
     *
     * @return
     * @throws UMUserManagementException
     */
    public Long updatePermission() throws UMUserManagementException {
        UMFeaturePermission updatedPermission = convertPermissionDataBeanToPermissionModel(permissionDataBean);

        uMFeatureService.updateFeaturePermission(updatedPermission);
        clearPermissionDataBean();
        clearPermissionDataBean();
        return 1l;
    }

    /**
     * conversion from permission data bean to model
     *
     * @param permissionDataBeanToConvert
     * @return
     * @throws UMUserManagementException
     */
    public UMFeaturePermission convertPermissionDataBeanToPermissionModel(PermissionDataBean permissionDataBeanToConvert) throws UMUserManagementException {
        UMFeaturePermission uMFeaturePermission = new UMFeaturePermission();

        StringBuilder nameBuilder = new StringBuilder();
        for (String n : permissionDataBean.getAttributes()) {
            nameBuilder.append("#").append(n).append("#").append(",");
        }

        nameBuilder.deleteCharAt(nameBuilder.length() - 1);

        uMFeaturePermission.setId(permissionDataBean.getID());
        uMFeaturePermission.setName(permissionDataBean.getName());
        uMFeaturePermission.setAttributes(nameBuilder.toString());
        uMFeaturePermission.setFeature(uMFeatureService.getFeatureByFeatureId(systemResultViewUtil.getCurrentSelectedFeature()));
        uMFeaturePermission.setLastModifiedBy(loginDataBean.getId());
        uMFeaturePermission.setLastModifiedOn(new Date());
        uMFeaturePermission.setIsActive(true);

        return uMFeaturePermission;
    }

    /**
     * Deletes the permission from permission ID
     *
     * @param permissionID to delete
     * @throws com.argusoft.generic.database.exception.GenericDatabaseException
     */
    public void deletePermission(Long permissionID) throws GenericDatabaseException {
        Map<String, Object> criteria = new HashMap<>();

        criteria.put(UMFeaturePermissionDao.ID, permissionID);

        UMFeaturePermission permissionToDelete = uMFeatureService.retrieveFeaturePermissions(criteria, null, null, null).get(0);
        permissionToDelete.setIsActive(false);
        permissionToDelete.setIsArchive(true);

        uMFeatureService.updateFeaturePermission(permissionToDelete);
    }

    /**
     * Converts UMRole To RoleDataBean
     *
     * @param uMRole
     * @return
     */
    public RoleDataBean convertRoleModelToRoleDataBean(UMRole uMRole) {
        RoleDataBean resultDataBean = new RoleDataBean();

        resultDataBean.setId(uMRole.getId());
        resultDataBean.setName(uMRole.getName());
        resultDataBean.setDescription(uMRole.getDescription());
        resultDataBean.setCompany(uMRole.getCompany());

        return resultDataBean;
    }

    /**
     * converts UMFeaturePermission to PermissionDataBean
     *
     * @param featurePermissionList
     * @return
     */
    public List<PermissionDataBean> convertListOfPermissionToPermissionDataBean(List<UMFeaturePermission> featurePermissionList) {
        List<PermissionDataBean> listOfPermissions = new ArrayList<>();

        for (UMFeaturePermission uMFeaturePermission : featurePermissionList) {
            PermissionDataBean permissionDataBean1 = new PermissionDataBean();

            permissionDataBean1.setID(uMFeaturePermission.getId());
            permissionDataBean1.setName(uMFeaturePermission.getName());

            listOfPermissions.add(permissionDataBean1);
        }

        return listOfPermissions;
    }

    /**
     * Get List of all roles having permission ID
     *
     * @param permissionID
     */
    public void getAllRoleHavingPermission(Long permissionID) {
        Long parentID = uMFeatureService.retrieveFeaturePermissionById(permissionID, true, false, false).getFeature().getId();
        systemResultViewUtil.setListOFpermissionWithSameFeature(convertListOfPermissionToPermissionDataBean(uMFeatureService.retrieveFeaturePermissionsByFeatureAndCompany(parentID, null, false, false, false)));
        List<UMRole> uMRole = roleService.getAllRole(Boolean.TRUE, null, null, null, true, false, false);
        List<RoleDataBean> roleDataBeans = new ArrayList<>();

        for (UMRole role : uMRole) {

            UMRole uMRole1 = roleService.getRoleByRoleId(role.getId(), true, false, false);
            Set<UMRoleFeature> uMRoleFeatures = uMRole1.getUMRoleFeatureSet();

            for (UMRoleFeature uMRoleFeature : uMRoleFeatures) {
                if (uMRoleFeature.getIsActive()) {
                    if (uMRoleFeature.getPermission().getId().equals(permissionID)) {
                        roleDataBeans.add(convertRoleModelToRoleDataBean(uMRole1));
                        break;
                    }
                }
            }
        }
        if (!roleDataBeans.isEmpty()) {
            systemResultViewUtil.setListOfRoleWithPermissionID(roleDataBeans);
            permissionDataBean.setID(permissionID);
        }
    }

    /**
     * Change Permission to role
     *
     * @param role_ID
     * @param permission_ID
     * @throws GenericDatabaseException
     */
    public void changePermission(Long role_ID, Long permission_ID) throws GenericDatabaseException {
        Map<String, Object> criteria = new HashMap<>();

        criteria.put(UMRoleFeatureDao.IS_ACTIVE, true);
        criteria.put(UMRoleFeatureDao.ROLE_SET + "." + UMRoleDao.ID, role_ID);
        criteria.put(UMRoleFeatureDao.PERMISSION_SET + "." + UMFeaturePermissionDao.ID, permission_ID);

        UMRoleFeature uMRoleFeatureToUpdate = roleService.retrieveRoleFeatures(criteria, null, null, null).get(0);

        uMRoleFeatureToUpdate.setPermission(uMFeatureService.retrieveFeaturePermissionById(permissionDataBean.getID(), false, false, false));

        roleService.updateRoleFeature(uMRoleFeatureToUpdate);

    }

    /**
     * Prepare to Remove the permission
     *
     * @param permission_ID
     * @throws GenericDatabaseException
     */
    public void removePermission(Long permission_ID) throws GenericDatabaseException {

        if (systemResultViewUtil.getListOfRoleWithPermissionID().isEmpty()) {
            deletePermission(permission_ID);
        } else {
            messageDataBean.setIsSuccess(Boolean.FALSE);
            messageDataBean.setMessage("Role with permission to delete exist please change them first");
        }
    }

    /**
     * Check if permission is associated with any role
     *
     * @param permissionID
     * @return
     */
    public Boolean checkForPermissionIsExistInRole(Long permissionID) {
        List<UMRole> uMRole = roleService.getAllRole(Boolean.TRUE, null, null, null, true, false, false);
        List<RoleDataBean> roleDataBeans = new ArrayList<>();

        for (UMRole role : uMRole) {
            UMRole uMRole1 = roleService.getRoleByRoleId(role.getId(), true, false, false);
            Set<UMRoleFeature> uMRoleFeatures = uMRole1.getUMRoleFeatureSet();

            for (UMRoleFeature uMRoleFeature : uMRoleFeatures) {
                if (uMRoleFeature.getPermission().getId() == permissionID) {
                    roleDataBeans.add(convertRoleModelToRoleDataBean(uMRole1));
                    break;
                }
            }
        }
        systemResultViewUtil.setListOfRoleWithPermissionID(roleDataBeans);
        if (roleDataBeans.isEmpty()) {
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }
}
