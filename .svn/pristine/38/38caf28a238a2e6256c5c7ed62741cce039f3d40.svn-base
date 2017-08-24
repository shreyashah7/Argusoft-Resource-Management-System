/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.usermanagement.transformerbean;

import com.argusoft.armms.web.usermanagement.databean.FeatureDataBean;
import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import com.argusoft.armms.web.usermanagement.databean.PermissionDataBean;
import com.argusoft.armms.web.usermanagement.databean.RoleDataBean;
import com.argusoft.armms.web.usermanagement.databean.UserDataBean;
import com.argusoft.armms.web.util.SystemConstantUtil;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.generic.database.common.GenericDao.QueryOperators;
import com.argusoft.generic.database.exception.GenericDatabaseException;
import com.argusoft.usermanagement.common.core.UMFeatureService;
import com.argusoft.usermanagement.common.core.UMRoleService;
import com.argusoft.usermanagement.common.core.UMUserService;
import com.argusoft.usermanagement.common.database.UMFeatureDao;
import com.argusoft.usermanagement.common.database.UMFeaturePermissionDao;
import com.argusoft.usermanagement.common.database.UMRoleDao;
import com.argusoft.usermanagement.common.database.UMUserDao;
import com.argusoft.usermanagement.common.database.UMUserRoleDao;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import com.argusoft.usermanagement.common.model.UMFeature;
import com.argusoft.usermanagement.common.model.UMFeaturePermission;
import com.argusoft.usermanagement.common.model.UMRole;
import com.argusoft.usermanagement.common.model.UMRoleFeature;
import com.argusoft.usermanagement.common.model.UMUser;
import com.argusoft.usermanagement.common.model.UMUserRole;
import com.argusoft.usermanagement.common.model.UMUserRolePK;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.apache.commons.lang.ArrayUtils;

/**
 * Bean to performing role related actions
 *
 * @author rajkumar
 * @since 08-APR-2014
 */
@ManagedBean(name = "roleTransformerBean")
@RequestScoped
public class RoleTransformerBean {

    @ManagedProperty("#{featureService}")
    private UMFeatureService uMFeatureService;

    @ManagedProperty("#{roleService}")
    private UMRoleService roleService;

    @ManagedProperty("#{userService}")
    private UMUserService userService;

    @ManagedProperty("#{userTransformerBean}")
    private UserTransformerBean userTransformerBean;

    @ManagedProperty("#{roleDataBean}")
    private RoleDataBean roleDataBean;

    @ManagedProperty("#{permissionDataBean}")
    private PermissionDataBean permissionDataBean;

    @ManagedProperty("#{featureTransformerBean}")
    private FeatureTransformerBean featureTransformerBean;

    @ManagedProperty("#{permissionTransformerBean}")
    private PermissionTransformerBean permissionTransformerBean;

    @ManagedProperty("#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;

    @ManagedProperty("#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;

    @ManagedProperty("#{loginDataBean}")
    private LoginDataBean loginDataBean;

    public UMUserService getUserService() {
        return userService;
    }

    public void setUserService(UMUserService userService) {
        this.userService = userService;
    }

    public UserTransformerBean getUserTransformerBean() {
        return userTransformerBean;
    }

    public void setUserTransformerBean(UserTransformerBean userTransformerBean) {
        this.userTransformerBean = userTransformerBean;
    }

    public SystemResultSessionUtil getSystemResultSessionUtil() {
        return systemResultSessionUtil;
    }

    public void setSystemResultSessionUtil(SystemResultSessionUtil systemResultSessionUtil) {
        this.systemResultSessionUtil = systemResultSessionUtil;
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

    public RoleDataBean getRoleDataBean() {
        return roleDataBean;
    }

    public void setRoleDataBean(RoleDataBean roleDataBean) {
        this.roleDataBean = roleDataBean;
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

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    /**
     * retrieve all the parent features
     *
     * @return
     */
    public List<FeatureDataBean> retrieveAllFeature() throws GenericDatabaseException {
        List<String> ids = new ArrayList<>();
        ids.add(UMFeatureDao.PARENT);
        
        Map<String,Object> equals=new HashMap<>();
        equals.put(UMFeatureDao.IS_ACTIVE, Boolean.TRUE);
        
        Map<QueryOperators, Object> criteria = new HashMap<>();
        criteria.put(QueryOperators.IS_NULL, ids);
        criteria.put(QueryOperators.EQUAL, equals);
        
        List<UMFeature> uMFeatures =uMFeatureService.retrieveFeatures(null, criteria, null);
        
        List<FeatureDataBean> result = convertFeatureToFeatureDataBean(uMFeatures, false);
        return result;
    }

    /**
     * conversion from feature model to databean
     *
     * @param model
     * @param enableDisable
     * @return
     */
    public List<FeatureDataBean> convertFeatureToFeatureDataBean(List<UMFeature> model, Boolean enableDisable) {
        List<FeatureDataBean> result = new ArrayList<>();
        for (UMFeature uMFeature : model) {
            FeatureDataBean featureDataBean = new FeatureDataBean();
            featureDataBean.setId(uMFeature.getId());
            featureDataBean.setName(uMFeature.getName());
            featureDataBean.setEnableDisable(enableDisable);

            result.add(featureDataBean);
        }
        return result;
    }

    /**
     * retrieves permission set of feature
     *
     * @param featureID
     * @return
     * @throws com.argusoft.generic.database.exception.GenericDatabaseException
     */
    public List<PermissionDataBean> retrievePermissionSetOfFeature(Long featureID) throws GenericDatabaseException {
        Map<String, Object> criteria = new HashMap<>();
        criteria.put(UMFeaturePermissionDao.FEATURE + "." + UMFeatureDao.ID, featureID);
        criteria.put(UMFeaturePermissionDao.IS_ACTIVE, Boolean.TRUE);
        List<UMFeaturePermission> permissionSetOfFeature = uMFeatureService.retrieveFeaturePermissions(criteria, null, null, null);
        return (convertFeaturePermissionToFeaturePermissionDataBean(permissionSetOfFeature));
    }

    /**
     * convert feature permission to feature permission data bean
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
        if (!permissionByDataBean.isEmpty()) {
            systemResultViewUtil.setPermissionsSelected(permissionByDataBean.get(0).getAttributes());
        }
        return permissionByDataBean;
    }

    /**
     * retrieve all the permission from string array
     *
     * @param attributes
     * @param enableDisable
     * @return
     * @throws UMUserManagementException
     * @throws com.argusoft.generic.database.exception.GenericDatabaseException
     */
    public List<FeatureDataBean> retrieveFeatureAsPermissionSet(String[] attributes, Boolean enableDisable) throws UMUserManagementException, GenericDatabaseException {
        List<UMFeature> listOfPermission = new ArrayList<>();
        UMFeature uMFeature = new UMFeature();
        Map<String, Object> criteria = new HashMap<>();
        for (String attribute : attributes) {
            if (attribute != null) {
                criteria.put(UMFeatureDao.ID, Long.parseLong(attribute));
                uMFeature = (uMFeatureService.retrieveFeatures(criteria, null, null, null)).get(0);
                listOfPermission.add(uMFeature);
                criteria.clear();
            }

        }
        return (convertFeatureToFeatureDataBean(listOfPermission, enableDisable));
    }

    /**
     * Retrieves permissions by feature and permission ID
     *
     * @param permissionID
     * @param featureID
     * @return list of feature
     * @throws UMUserManagementException
     * @throws GenericDatabaseException
     */
    public List<FeatureDataBean> retrievePermissionsetByID(Long permissionID, Long featureID) throws UMUserManagementException, GenericDatabaseException {
        UMFeaturePermission permission = new UMFeaturePermission();
        if (permissionID == 0l) {
            Map<String, Object> criteria = new HashMap<>();
            criteria.put(UMFeaturePermissionDao.NAME, "minimum");
            criteria.put(UMFeaturePermissionDao.FEATURE + "." + UMFeatureDao.ID, featureID);
            permission = (uMFeatureService.retrieveFeaturePermissions(criteria, null, null, null)).get(0);
            String[] minimum_permission = permission.getAttributes().replaceAll("#", "").split(",");
            List<FeatureDataBean> allFeatureList = retrieveFeatureAsPermissionSet(minimum_permission, true);
            systemResultViewUtil.setPermissionsSelected(minimum_permission);

            criteria.put(UMFeaturePermissionDao.NAME, "maximum");
            criteria.put(UMFeaturePermissionDao.FEATURE + "." + UMFeatureDao.ID, featureID);
            permission = (uMFeatureService.retrieveFeaturePermissions(criteria, null, null, null)).get(0);
            String[] maximun_permission = permission.getAttributes().replaceAll("#", "").split(",");

            List<String> wordList = Arrays.asList(minimum_permission);
            List<String> wordList2 = Arrays.asList(maximun_permission);
            List<String> resultList = new ArrayList<>();
            for (String max_permission : wordList2) {
                if (!wordList.contains(max_permission)) {
                    resultList.add(max_permission);
                }
            }
            String[] permissionAsArray = resultList.toArray(resultList.toArray(new String[resultList.size()]));
            allFeatureList.addAll(retrieveFeatureAsPermissionSet(permissionAsArray, false));

            String[] permissionsSelected = systemResultViewUtil.getPermissionsSelected();
            permissionsSelected = (String[]) ArrayUtils.addAll(permissionsSelected, permissionAsArray);
            systemResultViewUtil.setPermissionsSelected(permissionsSelected);
            return allFeatureList;

        } else {

            permission = uMFeatureService.retrieveFeaturePermissionById(permissionID, false, false, false);
            systemResultViewUtil.setPermissionsSelected(permission.getAttributes().replaceAll("#", "").split(","));
        }
        return (retrieveFeatureAsPermissionSet(permission.getAttributes().replaceAll("#", "").split(","), true));

    }

    /**
     * Add role to database
     *
     * @throws UMUserManagementException
     * @throws com.argusoft.generic.database.exception.GenericDatabaseException
     */
    public void addRole() throws UMUserManagementException, GenericDatabaseException {
        UMRole uMRole = new UMRole();

        uMRole.setName(roleDataBean.getName());
        uMRole.setDescription(roleDataBean.getDescription());

        uMRole.setCreatedBy(loginDataBean.getId());
        uMRole.setCreatedOn(new Date());
        uMRole.setIsActive(Boolean.TRUE);
        uMRole.setPrecedence(1);

        Long result = roleService.createRole(uMRole);

        addRoleFeature(result);

    }

    /**
     * Add role feature object
     *
     * @param RoleID
     * @throws UMUserManagementException
     * @throws com.argusoft.generic.database.exception.GenericDatabaseException
     */
    public void addRoleFeature(Long RoleID) throws UMUserManagementException, GenericDatabaseException {
        List<Map<Long, String>> listOfPermissionFeature = systemResultViewUtil.getSelectedFeaturePermissionForRole();

        for (Map<Long, String> mapEntry : listOfPermissionFeature) {
            Set setOfKey = mapEntry.keySet();
            Object[] objectArrayOfKeys = setOfKey.toArray();
            Long[] Ids = Arrays.copyOf(objectArrayOfKeys, objectArrayOfKeys.length+1, Long[].class);
            UMRoleFeature uMRoleFeature = new UMRoleFeature();

            uMRoleFeature.setRole(getRoleById(RoleID));
            uMRoleFeature.setFeature(featureTransformerBean.getFeatureById(Ids[0]));
            if (Ids[1] == null) {
                uMRoleFeature.setPermission(permissionTransformerBean.getPermissionById(Ids[0]));
            } else {
                uMRoleFeature.setPermission(permissionTransformerBean.getPermissionById(Ids[1]));
            }
            uMRoleFeature.setAllowToCreate(true);
            uMRoleFeature.setAllowToDelete(true);
            uMRoleFeature.setAllowToUpdate(true);

            uMRoleFeature.setIsActive(true);

            roleService.createRoleFeature(uMRoleFeature);
        }
    }

    /**
     * get role data by ID
     *
     * @param roleId Id of role
     * @return object of role
     * @throws com.argusoft.generic.database.exception.GenericDatabaseException
     */
    public UMRole getRoleById(Long roleId) throws GenericDatabaseException {
        Map<String, Object> criteria = new HashMap<>();
        criteria.put(UMRoleDao.ID, roleId);
        return (roleService.retrieveRoles(criteria, null, null, null)).get(0);

    }

    /**
     * retrieve all roles
     *
     * @throws com.argusoft.generic.database.exception.GenericDatabaseException
     */
    public void retrieveAllRoles() throws GenericDatabaseException {
        Map<String, Object> criteria = new HashMap<>();
        criteria.put(UMRoleDao.IS_ACTIVE, Boolean.TRUE);
        List<UMRole> uMRole = roleService.retrieveRoles(criteria, null, null, null);
        Map<String, Map<String, String>> listOfRoleWithFeatureAndPermission = new HashMap<>();

        for (UMRole role : uMRole) {
            criteria.clear();
            criteria.put(UMRoleDao.ID, role.getId());
            List<String> required = new ArrayList<>();
            required.add(UMRoleDao.UM_ROLE_FEATURE_SET);
            UMRole uMRole1 = roleService.retrieveRoles(criteria, null, null, required).get(0);
            Set<UMRoleFeature> featureForRole = uMRole1.getUMRoleFeatureSet();
            Map<String, String> setOfFeatureRole = new HashMap<>();

            for (UMRoleFeature uMRoleFeature : featureForRole) {
                String temp = uMRoleFeature.getFeature().getName();
                String temp2 = uMRoleFeature.getPermission().getName();
                if (uMRoleFeature.getIsActive()) {
                    setOfFeatureRole.put(temp, temp2);
                }
            }

            listOfRoleWithFeatureAndPermission.put(role.getName(), setOfFeatureRole);
        }

        systemResultViewUtil.setListOfRoleFeaturePermission(listOfRoleWithFeatureAndPermission);
    }

    /**
     * Update role information
     *
     * @param roleName to update
     * @throws com.argusoft.generic.database.exception.GenericDatabaseException
     */
    public void updateRole(String roleName) throws GenericDatabaseException {
        Map<String, Object> criteria = new HashMap<>();
        criteria.put(UMRoleDao.NAME, roleName);
        List<String> required = new ArrayList<>();
        required.add(UMRoleDao.UM_ROLE_FEATURE_SET);
        UMRole uMRole = roleService.retrieveRoles(criteria, null, null, required).get(0);

        systemResultSessionUtil.setRoleIdToUpdate(uMRole.getId());
    }

    /**
     * Load data to update
     *
     * @throws UMUserManagementException
     * @throws com.argusoft.generic.database.exception.GenericDatabaseException
     */
    public void loadDataToUpdate() throws UMUserManagementException, GenericDatabaseException {
        RoleDataBean tempRoleDataBean = convertRoleModelToRoleDataBean(getRoleById(systemResultSessionUtil.getRoleIdToUpdate()));

        roleDataBean.setId(tempRoleDataBean.getId());
        roleDataBean.setName(tempRoleDataBean.getName());
        roleDataBean.setDescription(tempRoleDataBean.getDescription());
        roleDataBean.setPrecedence(tempRoleDataBean.getPrecedence());

        Map<String, Object> criteria = new HashMap<>();
        criteria.put(UMRoleDao.ID, roleDataBean.getId());
        List<String> required = new ArrayList<>();
        required.add(UMRoleDao.UM_ROLE_FEATURE_SET);
        UMRole tempUmRole = roleService.retrieveRoles(criteria, null, null, required).get(0);

        Set<UMRoleFeature> setOfRoleFeature = tempUmRole.getUMRoleFeatureSet();

        List<Map<Long, String>> tempSelectedFeaturePermissionForRole = new ArrayList<>();

        if (systemResultViewUtil.getSelectedFeaturePermissionForRole() == null) {
            systemResultViewUtil.setSelectedFeaturePermissionForRole(new ArrayList<Map<Long, String>>());
        }

        for (UMRoleFeature singleRoleFeature : setOfRoleFeature) {
            Map<Long, String> featurePermission = new LinkedHashMap<>();
            UMFeature uMFeature = singleRoleFeature.getFeature();
            featurePermission.put(uMFeature.getId(), uMFeature.getName());

            UMFeaturePermission uMFeaturePermission = singleRoleFeature.getPermission();

            featurePermission.put(uMFeaturePermission.getId(), uMFeaturePermission.getName());
            if (singleRoleFeature.getIsActive() == true) {
                tempSelectedFeaturePermissionForRole.add(featurePermission);
            }
        }
        systemResultViewUtil.setSelectedFeaturePermissionForRole(tempSelectedFeaturePermissionForRole);

    }

    /**
     * convert from role model to role data bean
     *
     * @param uMRole
     * @return converted roledatabean
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
     * Update role data
     *
     * @throws UMUserManagementException
     * @throws com.argusoft.generic.database.exception.GenericDatabaseException
     */
    public void updateRoleData() throws UMUserManagementException, GenericDatabaseException {
        Long roleIdToUpdate = systemResultSessionUtil.getRoleIdToUpdate();

        Map<String, Object> criteria = new HashMap<>();
        criteria.put(UMRoleDao.ID, roleIdToUpdate);
        List<String> required = new ArrayList<>();
        required.add(UMRoleDao.UM_ROLE_FEATURE_SET);
        UMRole roleToUpdate = roleService.retrieveRoles(criteria, null, null, required).get(0);

        roleToUpdate.setId(roleIdToUpdate);
        roleToUpdate.setName(roleDataBean.getName());
        roleToUpdate.setDescription(roleDataBean.getDescription());

        for (UMRoleFeature roleFeatureToDelete : roleToUpdate.getUMRoleFeatureSet()) {
            roleService.deleteRoleFeature(roleFeatureToDelete);
        }

        Set<UMRoleFeature> updatedSetOfFeaturesForRole = new LinkedHashSet<>();
        for (Map<Long, String> permissionToUpdate : systemResultViewUtil.getSelectedFeaturePermissionForRole()) {
            Object[] keys = permissionToUpdate.keySet().toArray();
            Long[] longKeys = Arrays.copyOf(keys, keys.length, Long[].class);

            UMRoleFeature instanceOfFeaturePermission = new UMRoleFeature();

            instanceOfFeaturePermission.setRole(roleToUpdate);
            instanceOfFeaturePermission.setFeature(featureTransformerBean.getFeatureById(longKeys[0]));
            instanceOfFeaturePermission.setPermission(permissionTransformerBean.getPermissionById(longKeys[1]));

            instanceOfFeaturePermission.setAllowToCreate(true);
            instanceOfFeaturePermission.setAllowToDelete(true);
            instanceOfFeaturePermission.setAllowToUpdate(true);
            instanceOfFeaturePermission.setIsActive(true);
            updatedSetOfFeaturesForRole.add(instanceOfFeaturePermission);
        }
        roleToUpdate.setUMRoleFeatureSet(updatedSetOfFeaturesForRole);
        roleService.updateRole(roleToUpdate);

    }

    /**
     * get minimum permission for feature
     *
     * @param featureID
     * @return String array of minimum permission
     * @throws com.argusoft.generic.database.exception.GenericDatabaseException
     */
    public String[] getMinimumPermissionAttributes(Long featureID) throws GenericDatabaseException {
        Map<String, Object> criteria = new HashMap<>();
        criteria.put(UMFeaturePermissionDao.NAME, "minimum");
        criteria.put(UMFeaturePermissionDao.FEATURE + "." + UMFeatureDao.ID, featureID);
        UMFeaturePermission permission = (uMFeatureService.retrieveFeaturePermissions(criteria, null, null, null)).get(0);
        String[] minimum_permission = permission.getAttributes().replaceAll("#", "").split(",");

        return minimum_permission;
    }

    /**
     * retrieving all menu items
     *
     * @return list of FeatureDataBean
     * @throws com.argusoft.generic.database.exception.GenericDatabaseException
     */
    public List<FeatureDataBean> retrieveAllMenuItems() throws GenericDatabaseException {

        Map<String, Object> criteria = new HashMap<>();
        List<String> menuAndMenuitem = new ArrayList<>();
        menuAndMenuitem.add(SystemConstantUtil.MENU_ITEM);
        menuAndMenuitem.add(SystemConstantUtil.MENU);
        criteria.put(UMFeatureDao.MENU_TYPE, menuAndMenuitem);
        criteria.put(UMFeatureDao.IS_ACTIVE, Boolean.TRUE);
        List<UMFeature> listOfMenuItems = uMFeatureService.retrieveFeatures(criteria, null, null, null);

        criteria.clear();
        menuAndMenuitem.add(SystemConstantUtil.MENU);
        List<UMFeature> listOfMenu = uMFeatureService.retrieveFeatures(criteria, null, null, null);
        List<UMFeature> listOfMenuWthMenuItems = new ArrayList<>();

        for (UMFeature uMFeature : listOfMenu) {
            criteria.clear();
            criteria.put(UMFeatureDao.PARENT + "." + UMFeatureDao.ID, uMFeature.getId());
            criteria.put(UMFeatureDao.MENU_TYPE, SystemConstantUtil.MENU_ITEM);
            if (!(uMFeatureService.retrieveFeatures(null, criteria, null, null, null).isEmpty())) {
                listOfMenuWthMenuItems.add(uMFeature);
            }
        }
        listOfMenuItems.removeAll(listOfMenuWthMenuItems);
        return (convertFeatureToFeatureDataBean(listOfMenuItems, Boolean.FALSE));
    }

    /**
     * retrieve all active roles
     *
     * @return list of RoleDataBean
     * @throws com.argusoft.generic.database.exception.GenericDatabaseException
     */
    public List<RoleDataBean> retrieveAllActiveRoles() throws GenericDatabaseException {
        List<RoleDataBean> listOfAllActiveRoles = new ArrayList<>();

        Map<String, Object> equalcriteria = new HashMap<>();
        Map<String, Object> greaterCriteria = new HashMap<>();

        equalcriteria.put(UMRoleDao.IS_ACTIVE, Boolean.TRUE);
        greaterCriteria.put(UMRoleDao.PRECEDENCE, 1);
        List<UMRole> listOfRoles = roleService.retrieveRoles(null, equalcriteria, null, greaterCriteria, null);
        for (UMRole uMRole : listOfRoles) {
            listOfAllActiveRoles.add(convertRoleModelToRoleDataBean(uMRole));
        }

        return listOfAllActiveRoles;
    }

    /**
     * Retrieves list of roles having permissionID as parameter
     *
     * @param permissionID
     * @return list of roledatabean having all roles associated with the
     * permission to delete
     */
    public List<RoleDataBean> retrirveAllRolesHavingPermission(Long permissionID) {
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

        return roleDataBeans;
    }

    /**
     * Check whether role is associated with any role or not
     *
     * @param role_name
     * @throws UMUserManagementException
     * @throws GenericDatabaseException
     */
    public void checkDeleteRole(String role_name) throws UMUserManagementException, GenericDatabaseException {
        systemResultViewUtil.setListOfAllActiveRoles(new ArrayList<RoleDataBean>());
        systemResultViewUtil.setListOfUsers(new ArrayList<UserDataBean>());

        //Retrieveing all active roles
        List<UMRole> activeUMRole = roleService.retrieveAllRoles(Boolean.TRUE);
        List<RoleDataBean> allActiveRoles = new ArrayList<>();
        for (UMRole uMRole : activeUMRole) {
            allActiveRoles.add(convertRoleModelToRoleDataBean(uMRole));
        }

        //Retrieveing users with role_name
        Map<String, Object> criteria = new HashMap<>();
        criteria.put(UMRoleDao.IS_ACTIVE, Boolean.TRUE);
        criteria.put(UMRoleDao.NAME, role_name);
        List<UMRole> uMRoles = roleService.retrieveRoles(criteria, null, null, null);

        criteria.clear();

        criteria.put(UMUserRoleDao.UM_USER_ROLE_PK + ".role", uMRoles.get(0).getId());
        criteria.put(UMUserRoleDao.IS_ACTIVE, Boolean.TRUE);
        List<String> required = new ArrayList<>();
        required.add(UMUserRoleDao.UM_USER);
        List<UMUserRole> userRoles = roleService.retrieveUserRoles(criteria, null, null, required);

        criteria.clear();

        List<UserDataBean> usersWithRoleNameToDelete = new ArrayList<>();
        List<Long> UserIds = new ArrayList<>();

        for (UMUserRole uMUser : userRoles) {
            UserIds.add(uMUser.getuMUser().getId());
        }
        criteria.put(UMUserDao.ID, UserIds);
        List<UMUser> listOfUsers = new ArrayList<>();

        if (!UserIds.isEmpty()) {
            listOfUsers = userService.retrieveUsers(criteria, null, null, null);

            for (UMUser uMUser : listOfUsers) {
                usersWithRoleNameToDelete.add(userTransformerBean.convertUMUserModelToUserManagementDataBean(uMUser, null, null));
            }

            systemResultViewUtil.setListOfAllActiveRoles(allActiveRoles);
            systemResultViewUtil.setListOfUsers(usersWithRoleNameToDelete);
            roleDataBean.setId(uMRoles.get(0).getId());
        }
    }

    /**
     * change role to the user
     *
     * @param user_Id
     * @throws GenericDatabaseException
     * @throws UMUserManagementException
     */
    public void changeRole(Long user_Id) throws GenericDatabaseException, UMUserManagementException {
        Long role_id = null;
        if (systemResultViewUtil.getRoleIdOfUserRole() == null) {
            for (RoleDataBean tempRoleDataBean : systemResultViewUtil.getListOfAllActiveRoles()) {
                if (tempRoleDataBean.getName().equals(systemResultSessionUtil.getRoleNameToRemove())) {
                    role_id = tempRoleDataBean.getId();
                }
            }
        }
        Map<String, Object> criteria = new HashMap<>();
        criteria.put(UMUserRoleDao.UM_USER_ROLE_PK + ".role", role_id);
        criteria.put(UMUserRoleDao.UM_USER_ROLE_PK + ".userobj", user_Id);
        List<String> require = new ArrayList<>();
        require.add(UMUserRoleDao.UM_USER);

        //Inactivate previous entry
        List<UMUserRole> uMUserRoles = roleService.retrieveUserRoles(criteria, null, null, require);
        userService.deleteUserRole(uMUserRoles.get(0));
        UMUserRole inactiveRole = uMUserRoles.get(0);

        UMUserRolePK uMUserRolePK = inactiveRole.getuMUserRolePK();

        uMUserRolePK.setRole(roleDataBean.getId());
        uMUserRolePK.setUserobj(user_Id);
        inactiveRole.setuMUserRolePK(uMUserRolePK);

        inactiveRole.setIsActive(true);
        inactiveRole.setIsArchive(false);

        userService.updateUserRole(inactiveRole);
        systemResultViewUtil.setRoleIdOfUserRole(roleDataBean.getId());
    }

    /**
     * Check if role name associated with any user
     *
     * @param role_name
     * @return
     * @throws GenericDatabaseException
     */
    public Boolean checkForRoleAssociationWithUser(String role_name) throws GenericDatabaseException {
        Long role_id = null;
        Map<String, Object> criteria = new HashMap<>();
        criteria.put(UMRoleDao.NAME, role_name);
        role_id = roleService.retrieveRoles(criteria, null, null, null).get(0).getId();

        criteria.clear();

        List<UMUserRole> userRoles = new ArrayList<>();
        if (!(role_id == null)) {
            criteria.put(UMUserRoleDao.UM_USER_ROLE_PK + ".role", role_id);
            criteria.put(UMUserRoleDao.IS_ACTIVE, Boolean.TRUE);

            userRoles = roleService.retrieveUserRoles(criteria, null, null, null);
        }
        if (userRoles.isEmpty()) {
            deleteRole(role_id);
            return true;
        } else {
            return false;
        }

    }

    /**
     * Deletes the role
     *
     * @param role_id
     * @throws GenericDatabaseException
     */
    public void deleteRole(Long role_id) throws GenericDatabaseException {
        Map<String, Object> criteria = new HashMap<>();
        criteria.put(UMRoleDao.ID, role_id);

        UMRole uMRole = roleService.retrieveRoles(criteria, null, null, null).get(0);
        roleService.deleteRole(uMRole);
    }
}
