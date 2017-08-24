/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this featurePermissionlate file, choose Tools | Templates
 * and open the featurePermissionlate in the editor.
 */
package com.argusoft.armms.web.security;

import com.argusoft.armms.web.util.ApplicationPropertyInitializerToDb;
import com.argusoft.armms.web.util.SystemConstantUtil;
import com.argusoft.generic.database.common.GenericDao.QueryOperators;
import com.argusoft.generic.database.exception.GenericDatabaseException;
import com.argusoft.usermanagement.common.core.UMFeatureService;
import com.argusoft.usermanagement.common.core.UMRoleService;
import com.argusoft.usermanagement.common.core.serviceimpl.UMFeatureServiceImpl;
import com.argusoft.usermanagement.common.database.UMFeatureDao;
import com.argusoft.usermanagement.common.database.UMRoleFeatureDao;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import com.argusoft.usermanagement.common.model.UMFeature;
import com.argusoft.usermanagement.common.model.UMFeaturePermission;
import com.argusoft.usermanagement.common.model.UMRoleFeature;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * This class provides roles corresponding to feature URL
 *
 * @author shifa
 */
@Service("webSecurityUtil")
public class WebSecurityUtil {

    private UrlPatternKeyedMap FeatureUrlRoles;
    private Map<String, String> UrlBindingMap;
    @Autowired
    private UMFeatureService umFeatureService;
    @Autowired
    private UMRoleService uMRoleService;
    @Autowired
    private ApplicationPropertyInitializerToDb propertyInitializer;

    @PostConstruct
    public void init() {
        try {
            propertyInitializer.createRoleIfNotExist();
        } catch (GenericDatabaseException e) {
            e.printStackTrace();
        } catch (UMUserManagementException ex) {
            ex.printStackTrace();
        }
        //  Initializing authorities with url for access control (Authorization)
        try {
            this.initializeUrlRoles();
        } catch (GenericDatabaseException e) {
            e.printStackTrace();
        }
        this.initializeUrlBindingMap();

    }

    public UrlPatternKeyedMap getFeatureUrlRoles() {
        return FeatureUrlRoles;
    }

    public Map<String, String> getUrlBindingMap() {
        return UrlBindingMap;
    }

    private void initializeUrlBindingMap() {
        UrlBindingMap = new HashMap();
        UrlBindingMap.put("/pages/secure/dashboard.xhtml", "dashboard");
        UrlBindingMap.put("/pages/secure/role.xhtml", "role");
        UrlBindingMap.put("/pages/secure/feature.xhtml", "feature");
        UrlBindingMap.put("/pages/secure/projects.xhtml", "projects");
        UrlBindingMap.put("/pages/secure/manageProject.xhtml", "manageProject");
        UrlBindingMap.put("/pages/secure/addProject.xhtml", "addProject");
        UrlBindingMap.put("/pages/secure/editProject.xhtml", "editProject");
        UrlBindingMap.put("/pages/secure/userManagement.xhtml", "userManagement");
        UrlBindingMap.put("/pages/secure/manageTechnology.xhtml", "manageTechnology");
        UrlBindingMap.put("/pages/secure/manageEmployeePerformanceReport.xhtml", "manageEmployeePerformanceReport");
        UrlBindingMap.put("/pages/secure/ganttChart.xhtml", "ganttChart");
        UrlBindingMap.put("/pages/secure/calendar.xhtml", "calendar");
        UrlBindingMap.put("/pages/secure/SvnRepository.xhtml", "repository");
        UrlBindingMap.put("/pages/secure/documents.xhtml", "documents");
        UrlBindingMap.put("/pages/secure/TaskViewAndUpdate.xhtml", "TaskViewAndUpdate");
        UrlBindingMap.put("/pages/secure/addUser.xhtml", "addUser");
        UrlBindingMap.put("/pages/secure/manageRole.xhtml", "manageRole");
        UrlBindingMap.put("/pages/secure/editUserData.xhtml", "editUserData");
        UrlBindingMap.put("/pages/secure/activity.xhtml", "activity");
        UrlBindingMap.put("/pages/secure/userProfile.xhtml", "userProfile");
        UrlBindingMap.put("/pages/secure/ViewMultipleTask.xhtml", "ViewMultipleTask");
        UrlBindingMap.put("/pages/secure/changeRoleToUser.xhtml", "changeRoleToUser");
        UrlBindingMap.put("/pages/secure/changePermissionToRole.xhtml", "changePermissionToRole");
        UrlBindingMap.put("/pages/secure/manageMyProfile.xhtml", "manageMyProfile");
        UrlBindingMap.put("/pages/secure/createTask.xhtml", "createTask");
        UrlBindingMap.put("/pages/secure/addResourcesOfProject.xhtml", "addResourcesOfProject");
        UrlBindingMap.put("/pages/secure/manageSystemConfiguration.xhtml", "manageSystemConfiguration");

        UrlBindingMap.put("/pages/secure/milestone.xhtml", "milestone");
    }

    public void initializeUrlRoles() throws GenericDatabaseException {
        Map<String, Set<String>> featureUrlAndRoleMap = retrieveFeatureUrlAndRoleIdsMap();
        if (!CollectionUtils.isEmpty(featureUrlAndRoleMap)) {
            FeatureUrlRoles = new UrlPatternKeyedMap();
            for (Map.Entry<String, Set<String>> entry : featureUrlAndRoleMap.entrySet()) {
                String url = entry.getKey();
                Set<String> roleSet = entry.getValue();
                String roles = roleSet.toString();
                if (roles.contains(SystemConstantUtil.IS_AUTHENTICATED_FULLY)) {
                    roles = SystemConstantUtil.IS_AUTHENTICATED_FULLY;
                } else if (roles.contains(SystemConstantUtil.IS_AUTHENTICATED_ANONYMOUSLY)) {
                    roles = SystemConstantUtil.IS_AUTHENTICATED_ANONYMOUSLY;

                } else {
                    roles = roles.replace("[", "").replace("]", "").replace(" ", "");
                }
                FeatureUrlRoles.put(url, roles);

            }
            FeatureUrlRoles.put("userProfile", SystemConstantUtil.IS_AUTHENTICATED_FULLY);
            FeatureUrlRoles.put("manageMyProfile", SystemConstantUtil.IS_AUTHENTICATED_FULLY);

        }
    }

    public Map<String, Set<String>> retrieveFeatureUrlAndRoleIdsMap() throws GenericDatabaseException {
        List<String> require1 = new ArrayList<>();
        require1.add(UMFeatureDao.UM_ROLE_FEATURE_SET);
        require1.add(UMFeatureDao.UM_FEATURE_PERMISSION_SET);
        // The below commented code is because actually they need to be used but since they are not functioning properly for time being depracated method is used
//        List<UMFeature> uMFeatures = umFeatureService.retrieveFeatures(null, null, require1);
        List<UMFeature> uMFeatures = umFeatureService.retrieveAllFeatures(Boolean.TRUE, false, true, true, false, false);
//        List<UMFeature> uMFeatures = umFeatureService.retrieveAllFeatures(Boolean.TRUE);
        Map<String, Set<String>> featureUrlAndRoleIdsSetMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(uMFeatures)) {
            //map of all features with featureId as key
            Map<Long, UMFeature> featuremap = new HashMap<>();
            for (UMFeature uMFeature : uMFeatures) {
                featuremap.put(uMFeature.getId(), uMFeature);
            }
            for (UMFeature uMFeature : uMFeatures) {
                if (!uMFeature.getMenuType().equals(SystemConstantUtil.ITEM_ATTRIBUTE)) {
                    Set<String> roleIdSet = null;
                    if (!CollectionUtils.isEmpty(uMFeature.getuMRoleFeatureSet())) {
                        for (UMRoleFeature uMRoleFeature : uMFeature.getuMRoleFeatureSet()) {
                            if (uMRoleFeature.getIsActive()) {
                                if (roleIdSet == null) {
                                    roleIdSet = new HashSet<>();
                                }
                                switch (uMRoleFeature.getRole().getName()) {
                                    case SystemConstantUtil.IS_AUTHENTICATED_ANONYMOUSLY:
                                        roleIdSet.add(SystemConstantUtil.IS_AUTHENTICATED_ANONYMOUSLY);
                                        break;
                                    case SystemConstantUtil.IS_AUTHENTICATED_FULLY:
                                        roleIdSet.add(SystemConstantUtil.IS_AUTHENTICATED_FULLY);
                                        break;
                                    case SystemConstantUtil.IS_AUTHENTICATED_REMEMBERED:
                                        roleIdSet.add(SystemConstantUtil.IS_AUTHENTICATED_REMEMBERED);
                                        break;
                                    default:
                                        roleIdSet.add(uMRoleFeature.getRole().getId().toString());
                                }
                            }
                        }
                    }
                    if (!CollectionUtils.isEmpty(roleIdSet)) {
                        if (uMFeature.getFeatureUrl() != null && !uMFeature.getMenuType().equals(SystemConstantUtil.ITEM_ATTRIBUTE)) {
                            Set<String> featureUrlRoleSet = featureUrlAndRoleIdsSetMap.get(uMFeature.getFeatureUrl());
                            if (featureUrlRoleSet == null) {
                                featureUrlRoleSet = new HashSet<>(roleIdSet);
                                featureUrlAndRoleIdsSetMap.put(uMFeature.getFeatureUrl(), featureUrlRoleSet);
                            } else {
                                featureUrlRoleSet.addAll(roleIdSet);
                            }
                        }
                        if (!CollectionUtils.isEmpty(uMFeature.getuMFeaturePermissionSet())) {
                            for (UMFeaturePermission uMFeaturePermission : uMFeature.getuMFeaturePermissionSet()) {
                                for (String featureId : uMFeaturePermission.getAttributes().split(",")) {
                                    featureId = featureId.replace("#", "");
                                    try {
                                        UMFeature permissionSetFeature = featuremap.get(Long.parseLong(featureId));

                                        if (permissionSetFeature.getFeatureUrl() != null) {
                                            Set<String> featureUrlRoleSet = featureUrlAndRoleIdsSetMap.get(permissionSetFeature.getFeatureUrl());

                                            if (featureUrlRoleSet == null) {
                                                featureUrlRoleSet = new HashSet<>();
                                                for (UMFeaturePermission featurePermission : uMFeature.getuMFeaturePermissionSet()) {
                                                    for (String permissionId : featurePermission.getAttributes().split(",")) {
                                                        permissionId = permissionId.replaceAll("#", "");

                                                        if ((Long.parseLong(permissionId)) == permissionSetFeature.getId()) {
                                                            Long permissionIdMatched = featurePermission.getId();

                                                            Map<String, Object> equal = new HashMap<>();

                                                            equal.put(UMRoleFeatureDao.PERMISSION_ID + "." + UMRoleFeatureDao.ID, permissionIdMatched);
                                                            equal.put(UMRoleFeatureDao.IS_ACTIVE, Boolean.TRUE);
                                                            Map<QueryOperators, Object> criteria = new HashMap<>();
                                                            criteria.put(QueryOperators.EQUAL, equal);
                                                            List<String> require = new ArrayList<>();
                                                            require.add(UMRoleFeatureDao.ROLE_SET);
                                                            List<UMRoleFeature> rolefeatures = uMRoleService.retrieveRoleFeatures(null, criteria, require);
                                                            if (rolefeatures != null) {
                                                                for (Iterator<UMRoleFeature> iterator = rolefeatures.iterator(); iterator.hasNext();) {
                                                                    UMRoleFeature featurePermissionRoleFeature = iterator.next();
                                                                    featureUrlRoleSet.add(featurePermissionRoleFeature.getRole().getId().toString());
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                featureUrlAndRoleIdsSetMap.put(permissionSetFeature.getFeatureUrl(), featureUrlRoleSet);
                                            } else {
                                                featureUrlRoleSet.addAll(roleIdSet);
                                            }
                                        }
                                    } catch (NumberFormatException e) {
                                        Logger.getLogger(UMFeatureServiceImpl.class.getName()).log(Level.SEVERE, null, e);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return featureUrlAndRoleIdsSetMap;
    }
}
