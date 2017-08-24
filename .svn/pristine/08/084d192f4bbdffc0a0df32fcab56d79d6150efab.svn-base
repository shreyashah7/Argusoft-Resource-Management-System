/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.usermanagement.servicebean;

import com.argusoft.armms.web.security.WebSecurityUtil;
import com.argusoft.armms.web.usermanagement.databean.UserDataBean;
import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import com.argusoft.armms.web.usermanagement.databean.MessageDataBean;
import com.argusoft.armms.web.usermanagement.transformerbean.UserTransformerBean;
import com.argusoft.armms.web.util.SystemConstantUtil;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.generic.database.exception.GenericDatabaseException;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import java.io.File;
import java.io.FileOutputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

/**
 * This class is to perform CRUD operation for users.
 *
 * @author niharika
 */
@ManagedBean(name = "userServiceBean")
@RequestScoped
public class UserServiceBean {

    //  DataBean properties
    @ManagedProperty("#{userDataBean}")
    private UserDataBean userDataBean;

    @ManagedProperty("#{messageDataBean}")
    private MessageDataBean messageDataBean;
    //  Transformer properties
    @ManagedProperty("#{userTransformerBean}")
    private UserTransformerBean userTransformerBean;
    @ManagedProperty("#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;
    @ManagedProperty("#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;
    @ManagedProperty(value = "#{webSecurityUtil}")
    private WebSecurityUtil webSecurityUtil;
    //login properties
    @ManagedProperty("#{loginDataBean}")
    private LoginDataBean loginDataBean;

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

    public void roleList() throws UMUserManagementException {

        systemResultViewUtil.setRoleList(userTransformerBean.retrieveRoleList());

    }

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

    public LoginDataBean getLoginDataBean() {
        return loginDataBean;
    }

    public void setLoginDataBean(LoginDataBean loginDataBean) {
        this.loginDataBean = loginDataBean;
    }

    public UserDataBean getUserDataBean() {
        return userDataBean;
    }

    public void setUserDataBean(UserDataBean userDataBean) {
        this.userDataBean = userDataBean;
    }

    public UserTransformerBean getUserTransformerBean() {
        return userTransformerBean;
    }

    public void setUserTransformerBean(UserTransformerBean userTransformerBean) {
        this.userTransformerBean = userTransformerBean;
    }

    public String outcome() {
        return "pretty:editUserData";
    }

    public String navigateToHomePage() {
        return "pretty:dashboard";
    }

    /**
     * TO Change login Password
     *
     * @author Brijesh
     *
     */
    public void changePassword() {

        if (userDataBean.getNewPassword() != null && userDataBean.getRetypeNewPassword() != null) {
            if (userDataBean.getNewPassword().equals(userDataBean.getRetypeNewPassword())) {
                String result = userTransformerBean.changePassword(loginDataBean);
                if (result.equalsIgnoreCase(SystemConstantUtil.SUCCESS)) {
                    loginDataBean.setPassword(userDataBean.getNewPassword());
                    messageDataBean.setMessage("Password changed sucessfully...");
                    messageDataBean.setIsSuccess(Boolean.TRUE);

                } else {
                    messageDataBean.setMessage("Please check old password");
                    messageDataBean.setIsSuccess(Boolean.FALSE);

                }
            } else {
                messageDataBean.setMessage("Please confirm new password");
                messageDataBean.setIsSuccess(Boolean.FALSE);

            }
            userDataBean.setOldPassword(null);
            userDataBean.setNewPassword(null);
            userDataBean.setRetypeNewPassword(null);
        }

    }

    public void showUsers() throws UMUserManagementException {
        systemResultViewUtil.setUsers(userTransformerBean.retrieveUsersByType(SystemConstantUtil.ACTIVE));
    }

    public void showUsersByType() throws UMUserManagementException {

        systemResultViewUtil.setUsers(userTransformerBean.retrieveUsersByType(userDataBean.getShowType()));
        if (systemResultSessionUtil.getResult() != null) {
            if (systemResultSessionUtil.getResult().equals(SystemConstantUtil.SUCCESS)) {
                messageDataBean.setMessage("User added successfully.");
                messageDataBean.setIsSuccess(Boolean.TRUE);
            } else if (systemResultSessionUtil.getResult().equals(SystemConstantUtil.FAILURE)) {
                messageDataBean.setMessage("Unexpected error occured!");
                messageDataBean.setIsSuccess(Boolean.FALSE);
            } else if (systemResultSessionUtil.getResult().equals(SystemConstantUtil.EDIT_SUCCESSFUL)) {
                messageDataBean.setMessage("User record updated successfully.");
                messageDataBean.setIsSuccess(Boolean.TRUE);
            }

        }
        systemResultSessionUtil.setResult(null);

    }

    public void changeStatus(UserDataBean user) throws UMUserManagementException {

        String result;
        if (user.getIsActive() == true) {
            result = userTransformerBean.deactivate(user);

        } else {
            result = userTransformerBean.activate(user);

        }

        this.showUsersByType();
        systemResultSessionUtil.setResult(result);
        if (systemResultSessionUtil.getResult().equals(SystemConstantUtil.ACTIVE)) {
            messageDataBean.setMessage("User activated successfully.");
            messageDataBean.setIsSuccess(Boolean.TRUE);
        } else if (systemResultSessionUtil.getResult().equals(SystemConstantUtil.INACTIVE)) {
            messageDataBean.setMessage("User deactivated successfully.");
            messageDataBean.setIsSuccess(Boolean.TRUE);
        }

    }

    public String addNewUser() throws UMUserManagementException, GenericDatabaseException {
        systemResultViewUtil.setRoleList(null);
        String result = userTransformerBean.addNewUser(userDataBean);
        systemResultSessionUtil.setResult(result);
        webSecurityUtil.initializeUrlRoles();
        if (result != null) {
            return "pretty:userManagement";
        } else {
            return null;
        }
    }

    public void retrieveUserForUpdate() throws UMUserManagementException, GenericDatabaseException {
        UserDataBean userBean = userTransformerBean.retrieveUserForUpdate();
        //setting old values from one databean to another UserDataBean to show on edit page.
        userDataBean.setFirstName(userBean.getFirstName());
        userDataBean.setLastName(userBean.getLastName());
        userDataBean.setEmailId(userBean.getEmailId());
        userDataBean.setPhoneNum(userBean.getPhoneNum());
        userDataBean.setRoleId(userBean.getRoleId());
        userDataBean.setTskAllocation(userBean.getTskAllocation());
        userDataBean.setTskDeadline(userBean.getTskDeadline());
        userDataBean.setTskEnd(userBean.getTskEnd());
        userDataBean.setTskUpdate(userBean.getTskUpdate());
        userDataBean.setWatcherFlag(userBean.getWatcherFlag());
        userDataBean.setUserId(userBean.getUserId());
        userDataBean.setUserName(userBean.getUserName());
        systemResultViewUtil.setUser(userTransformerBean.retrieveUserForUpdate());

    }

    public void retrieveUserById() {
        Long userId = systemResultViewUtil.getUserId();
        userTransformerBean.retrieveUserByUserId(userId);
    }

    public String updateData() throws UMUserManagementException, GenericDatabaseException {
        String result = userTransformerBean.updateUserData(userDataBean);
        systemResultSessionUtil.setResult(result);
        webSecurityUtil.initializeUrlRoles();
        if (result != null) {
            return "pretty:userManagement";
        } else {
            return null;
        }
    }

    /**
     * retrieve LoggedIn userInfo for Edit purpose
     *
     * @author Brijesh
     * @throws com.argusoft.generic.database.exception.GenericDatabaseException
     */
    public void retrieveLoggedInUserInfo() throws GenericDatabaseException {
        this.userTransformerBean.retrieveLoggedInUserInfo(systemResultSessionUtil.getUserId());
    }

    /**
     * update LoggedIn userInfo after edit the Information
     *
     * @author Brijesh
     */
    public void updateLoggedInUserInfo() throws GenericDatabaseException {

        this.userTransformerBean.updateLoggedInUserInfo(userDataBean);
        messageDataBean.setMessage("Information updated successfully!");
        messageDataBean.setIsSuccess(Boolean.TRUE);

    }

    /**
     * update NotificationInfo of LoggedIn user
     *
     * @author Brijesh
     */
    public void updateNotificationInfo() throws UMUserManagementException, GenericDatabaseException {

        this.userTransformerBean.updateNotificationInfo(userDataBean);
        messageDataBean.setMessage("Information updated successfully!");
        messageDataBean.setIsSuccess(Boolean.TRUE);

    }

    /**
     * for upload profile picture
     *
     * @author Brijesh
     */
    public void fileUploadListener(FileUploadEvent event) throws Exception {

        UploadedFile item = event.getUploadedFile();
        systemResultViewUtil.setFileData(item.getData());
        systemResultViewUtil.setFileName(item.getName());

        if (systemResultViewUtil.getFileName() != null) {
            this.userDataBean.setDisplayImgFlag(Boolean.TRUE);
        } else {
            this.userDataBean.setDisplayImgFlag(Boolean.FALSE);
        }
        FileOutputStream outputStream = null;
        String filePath, folderPath;
        long timestamp = getTimeStamp();
        try {
            folderPath = SystemConstantUtil.PROFILE_PIC_PATH;
            filePath = folderPath + timestamp + "-" + systemResultViewUtil.getFileName();
            loginDataBean.setProfilePicturePath(filePath);
            loginDataBean.setProfilePicture(timestamp + "-" + systemResultViewUtil.getFileName());
            Boolean result = new File(folderPath).mkdirs();
            outputStream = new FileOutputStream(new File(filePath));
            outputStream.write(systemResultViewUtil.getFileData());
            outputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        userTransformerBean.updateProfilePicture();
        //saving the file on local machine.....
    }

    public long getTimeStamp() {
        return System.currentTimeMillis();
    }    

    public void addUserSkills() {
        Long userskillId = userTransformerBean.addUserSkills(userDataBean.getTechId(), userDataBean.getTotalExperience());
        if (userskillId != null) {
            userDataBean.setTechId(null);
            userDataBean.setTotalExperience(null);
            messageDataBean.setMessage("Information updated successfully!");
            messageDataBean.setIsSuccess(Boolean.TRUE);
        } else {
            messageDataBean.setMessage("unexpected error occure");
            messageDataBean.setIsSuccess(Boolean.FALSE);

        }
    }
public void retrieveAllActiveUsers() throws UMUserManagementException, GenericDatabaseException{
    systemResultViewUtil.setRetrieveUsers(userTransformerBean.retrieveUsers());
}
}
