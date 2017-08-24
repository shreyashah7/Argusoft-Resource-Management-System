/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.security;

import com.argusoft.usermanagement.common.constants.UMUserManagementConstants;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;

/**
 * Performs security handling of HTTP resources via a filter implementation.
 *
 * The SecurityMetadataSource required by this security interceptor is of type
 * FilterInvocationSecurityMetadataSource.
 *
 * @author shifa
 */
public class ArmmsSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private WebSecurityUtil webSecurityutil;

    public WebSecurityUtil getWebSecurityutil() {
        return webSecurityutil;
    }

    public void setWebSecurityutil(WebSecurityUtil webSecurityutil) {
        this.webSecurityutil = webSecurityutil;
    }

    @Override
    public List<ConfigAttribute> getAttributes(Object object) {
        List<ConfigAttribute> attributes;
        FilterInvocation filter = (FilterInvocation) object;
        String httpUrl = filter.getRequestUrl();
        String httpMethod = filter.getRequest().getMethod();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String roles = "ROLE_UNDEFINED";
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        boolean isApiResource = antPathMatcher.match("/pages/secure/**", httpUrl);
        if (isApiResource) {
            if (webSecurityutil.getFeatureUrlRoles() != null) {
                try {
                    String httpBindingUrl = webSecurityutil.getUrlBindingMap().get(httpUrl);
                    if (httpBindingUrl != null) {
                        Object keyRoles = webSecurityutil.getFeatureUrlRoles().get(httpBindingUrl);
                        if (keyRoles != null) {
                            roles = keyRoles.toString();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            roles = UMUserManagementConstants.IS_AUTHENTICATED_ANONYMOUSLY;
        }

        if (antPathMatcher.match("/pages/secure/documents.xhtml?rf_fu_uid**", httpUrl)) {
            roles = UMUserManagementConstants.IS_AUTHENTICATED_FULLY;
        } else if (antPathMatcher.match("/pages/secure/manageMyProfile.xhtml?rf_fu_uid**", httpUrl)) {
            roles = UMUserManagementConstants.IS_AUTHENTICATED_FULLY;
        } else if (antPathMatcher.match("/pages/secure/projectResources.xhtml", httpUrl)) {
            roles = UMUserManagementConstants.IS_AUTHENTICATED_FULLY;
        } else if (antPathMatcher.match("/pages/secure/projectSummary.xhtml", httpUrl)) {
            roles = UMUserManagementConstants.IS_AUTHENTICATED_FULLY;
        } else if (antPathMatcher.match("/pages/secure/spentTime.xhtml", httpUrl)) {
            roles = UMUserManagementConstants.IS_AUTHENTICATED_FULLY;
        } else if (antPathMatcher.match("/pages/secure/folderStructure.xhtml", httpUrl)) {
            roles = UMUserManagementConstants.IS_AUTHENTICATED_FULLY;
        } else if (antPathMatcher.match("/pages/secure/search.xhtml", httpUrl)) {
            roles = UMUserManagementConstants.IS_AUTHENTICATED_FULLY;
        } else if (antPathMatcher.match("/pages/secure/createTask.xhtml?rf_fu_uid**", httpUrl)) {
            roles = UMUserManagementConstants.IS_AUTHENTICATED_FULLY;
        } else if (antPathMatcher.match("/pages/secure/manageProjectRoles.xhtml", httpUrl)) {
            roles = UMUserManagementConstants.IS_AUTHENTICATED_FULLY;
        } else if (antPathMatcher.match("/pages/secure/logTimeDetails.xhtml", httpUrl)) {
            roles = UMUserManagementConstants.IS_AUTHENTICATED_FULLY;
        } else if (antPathMatcher.match("/pages/secure/dashboard.xhtml", httpUrl)) {
            roles = UMUserManagementConstants.IS_AUTHENTICATED_FULLY;
        }
        attributes = SecurityConfig.createListFromCommaDelimitedString(roles);
        return attributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
