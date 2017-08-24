/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.usermanagement.databean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author brijesh
 */
@ManagedBean(name = "loginDataBean")
@SessionScoped
public class LoginDataBean implements Serializable {

    private String name;
    private String userId;
    private String password;
    private boolean rememberMe;
    private Date lastLoginDateTime;
    private String timezone;
    private String role;
    private boolean isLoggedin;
    private String profilePicture;
    private Long id;
    private boolean isActive;
    private Map<String, Set<UserAuthorizationDataBean>> menuWithMenuItem = new HashMap<>();
    private List<String> itemAttributes;
    private Map<String, String> menus = new HashMap<>();
    private String emailId;
    private String profilePicturePath;

    public String getProfilePicturePath() {
        return profilePicturePath;
    }

    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Map<String, String> getMenus() {
        return menus;
    }

    public void setMenus(Map<String, String> menus) {
        this.menus = menus;
    }

    public Map<String, Set<UserAuthorizationDataBean>> getMenuWithMenuItem() {
        return menuWithMenuItem;
    }

    public void setMenuWithMenuItem(Map<String, Set<UserAuthorizationDataBean>> menuWithMenuItem) {
        this.menuWithMenuItem = menuWithMenuItem;
    }

    public List<String> getItemAttributes() {
        return itemAttributes;
    }

    public void setItemAttributes(List<String> itemAttributes) {
        this.itemAttributes = itemAttributes;
    }

    public boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
//        System.out.println("+++remember me++"+rememberMe);
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        System.out.println("\nsystemUser Id:" + id);
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
//         System.out.println("Name:"+name);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
//        System.out.println("\n++++set by cookie Password:"+ password);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
//        System.out.println("\n System UMUser Role:"+ role);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getLastLoginDateTime() {
        return lastLoginDateTime;
    }

    public void setLastLoginDateTime(Date lastLoginDateTime) {
        this.lastLoginDateTime = lastLoginDateTime;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public boolean getIsLoggedin() {
        return isLoggedin;
    }

    public void setIsLoggedin(boolean isLoggedin) {
        this.isLoggedin = isLoggedin;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
