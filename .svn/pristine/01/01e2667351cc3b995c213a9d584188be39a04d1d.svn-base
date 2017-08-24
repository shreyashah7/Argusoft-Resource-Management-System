/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.usermanagement.transformerbean;

import com.argusoft.armms.core.EmailNotificationService;
import com.argusoft.armms.core.UserSkillsService;
import com.argusoft.armms.model.EmailNotification;
import com.argusoft.armms.model.TechnologyMaster;
import com.argusoft.armms.model.UserSkillSet;
import com.argusoft.armms.web.transformerbean.ProjectTransformerBean;
import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import com.argusoft.armms.web.usermanagement.databean.RoleDataBean;
import com.argusoft.armms.web.usermanagement.databean.UserDataBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import com.argusoft.armms.web.util.SystemConstantUtil;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.email.common.core.EmailService;
import com.argusoft.email.common.model.Email;
import com.argusoft.generic.database.exception.GenericDatabaseException;
import com.argusoft.usermanagement.common.core.UMRoleService;
import com.argusoft.usermanagement.common.model.UMRole;
import com.argusoft.usermanagement.common.core.UMUserService;
import com.argusoft.usermanagement.common.database.UMRoleDao;
import com.argusoft.usermanagement.common.database.UMUserDao;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import com.argusoft.usermanagement.common.model.UMUser;
import com.argusoft.usermanagement.common.model.UMUserContact;
import com.argusoft.usermanagement.common.model.UMUserRole;
import com.argusoft.usermanagement.common.model.UMUserRolePK;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import org.jasypt.util.password.BasicPasswordEncryptor;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.SelectItem;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.CollectionUtils;

/**
 * This class is to perform CRUD operation for user.
 *
 * @author niharika
 */
@ManagedBean(name = "userTransformerBean")
@RequestScoped
@EnableAsync
public class UserTransformerBean {

    //  Service Injections    
    @ManagedProperty(value = "#{userDataBean}")
    private UserDataBean userDataBean;
    @ManagedProperty(value = "#{emailService}")
    private EmailService emailService;
    @ManagedProperty(value = "#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;
    @ManagedProperty(value = "#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;
    @ManagedProperty(value = "#{userService}")
    UMUserService userService;
    @ManagedProperty(value = "#{emailNotificationService}")
    EmailNotificationService emailNotificationService;

    @ManagedProperty(value = "#{loginDataBean}")
    private LoginDataBean loginDataBean;
    @ManagedProperty(value = "#{roleService}")
    UMRoleService roleService;
    @ManagedProperty(value = "#{userSkillsService}")
    private UserSkillsService userSkillsService;

    @ManagedProperty(value = "#{basicPasswordEncryptor}")
    private BasicPasswordEncryptor basicPasswordEncryptor;

    public UserSkillsService getUserSkillsService() {
        return userSkillsService;
    }

    public void setUserSkillsService(UserSkillsService userSkillsService) {
        this.userSkillsService = userSkillsService;
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

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    public void setUserService(UMUserService userService) {
        this.userService = userService;
    }

    public EmailNotificationService getEmailNotificationService() {
        return emailNotificationService;
    }

    public void setEmailNotificationService(EmailNotificationService emailNotificationService) {
        this.emailNotificationService = emailNotificationService;
    }

    public LoginDataBean getLoginDataBean() {
        return loginDataBean;
    }

    public void setLoginDataBean(LoginDataBean loginDataBean) {
        this.loginDataBean = loginDataBean;
    }

    public UMRoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(UMRoleService roleService) {
        this.roleService = roleService;
    }

    public BasicPasswordEncryptor getBasicPasswordEncryptor() {
        return basicPasswordEncryptor;
    }

    public void setBasicPasswordEncryptor(BasicPasswordEncryptor basicPasswordEncryptor) {
        this.basicPasswordEncryptor = basicPasswordEncryptor;
    }

    public EmailService getEmailService() {
        return emailService;
    }

    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    public UserDataBean getUserDataBean() {
        return userDataBean;
    }

    public void setUserDataBean(UserDataBean userDataBean) {
        this.userDataBean = userDataBean;
    }

//        String subject = "testing";
//        StringBuilder message = new StringBuilder();
//
//        String from = "rparikh@argusoft.com";
//        String to[] = new String[]{"rparikh@gmail.com"};
//
//        message.append("Testing Email..");
//        message.append("Testing Email for email service checking");
//        sendMail(subject, message.toString(), from, to);
    /**
     * @author ravi
     * @param subject subject of mail
     * @param message message to be sended
     * @param from email id of sender
     * @param to email id of receiver
     */
    public void sendMail(String subject, String message, String from, String[] to) {

        Email email = new Email();
        email.setSubject(subject);
        email.setMessageBody(message);
        email.setFrom(from);
        email.setTo(to);
        email.setIsSecure(Boolean.TRUE);
        email.setConnectionType(SystemConstantUtil.CONNECTION_TYPE_DEFAULT);
        System.out.println("=====before usermanagment send mail method========");
        emailService.sendMail(email);
        System.out.println("=====before usermanagment send mail method========");
    }

    /**
     * @author ravi
     * @return All available users
     * @throws UMUserManagementException
     */
    public List<UserDataBean> retrieveUsers() throws UMUserManagementException, GenericDatabaseException {
        List<UMUser> users;
        users = userService.retrieveUsers(null, null, null);
        //by ravi date- 13-4-2014(transforming usermodels to data beans)
        List<UserDataBean> userDataBeans = new ArrayList<>();
        UserDataBean userDataBean;
        if (!CollectionUtils.isEmpty(users)) {
            for (UMUser user : users) {
                userDataBean = new UserDataBean();
                userDataBean.setUserId(user.getId());
                userDataBean.setFirstName(user.getFirstName());
                userDataBean.setUserName(user.getFirstName() + " " + user.getLastName());
                userDataBeans.add(userDataBean);
            }
        }
        return userDataBeans;
    }

    /**
     * retrieveUsersByType shows list of all users by type.
     *
     * @param type shows active for active users and inactive for inactive
     * users.
     * @throws UMUserManagementException
     */
    public List<UserDataBean> retrieveUsersByType(String type) throws UMUserManagementException {
        List<UMUser> users = new ArrayList<>();
        if (type != null) {
            if (type.equalsIgnoreCase(SystemConstantUtil.SHOWALL)) {
                users = userService.retrieveUsersBySearchString(null, null, null, null, null, null, false, false, false, false);
            } else if (type.equalsIgnoreCase(SystemConstantUtil.INACTIVE)) {
                List<UMUser> tempUsers = new ArrayList<>();
                tempUsers = userService.retrieveUsersBySearchString(null, null, null, null, null, null, false, false, false, false);
                if (!CollectionUtils.isEmpty(tempUsers)) {
                    for (UMUser user : tempUsers) {
                        if (!user.getIsActive()) {
                            users.add(user);
                        }
                    }
                }

            } else if (type.equalsIgnoreCase(SystemConstantUtil.ACTIVE)) {
                users = userService.retrieveUsersBySearchString(null, Boolean.TRUE, null, null, null, null, false, false, false, false);
            }
        } else {
            users = userService.retrieveUsersBySearchString(null, Boolean.TRUE, null, null, null, null, false, false, false, false);
        }
        List<UserDataBean> userListDataBeans = new ArrayList<>();
        if (!CollectionUtils.isEmpty(users)) {
            for (UMUser user : users) {
                if (loginDataBean.getId() != user.getId() && !user.getUserId().equalsIgnoreCase("superadmin")) {
                    UserDataBean userDataBeanObj = new UserDataBean();
                    userDataBeanObj.setFirstName(user.getFirstName());
                    userDataBeanObj.setLastName(user.getLastName());
                    userDataBeanObj.setEmailId(user.getEmailAddress());
                    userDataBeanObj.setPhoneNum(user.getMobileNumber());
                    userDataBeanObj.setRole(user.getType());
                    userDataBeanObj.setUserId(user.getId());
                    userDataBeanObj.setUserName(user.getUserId());
                    userDataBeanObj.setIsActive(user.getIsActive());
                    userListDataBeans.add(userDataBeanObj);
                }
            }
        }
        return userListDataBeans;
    }

    /**
     * retrieveAllActiveUsers method retrieves the list of active users
     *
     * @author Shifa
     */
    public List<UserDataBean> retrieveFullNameOfActiveUsers() throws UMUserManagementException {

//        List<UMUser> userList = userService.retrieveUsersBySearchString(null, Boolean.TRUE, null, null, null, null, false, false, false, false);
        Map<String, Object> equalCriteria = new HashMap<>();
        equalCriteria.put(UMUserDao.IS_ACTIVE, true);
        equalCriteria.put(UMUserDao.IS_ARCHIVE, false);
        List<UMUser> userList = new ArrayList<>();
        try {
            userList = userService.retrieveUsers(null, equalCriteria, null, null, null);

        } catch (GenericDatabaseException ex) {
            Logger.getLogger(ProjectTransformerBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        Map<Long, String> userMap = new HashMap<>();
        for (UMUser userobj : userList) {
            StringBuffer name = new StringBuffer();
            name.append(userobj.getFirstName());
            if (userobj.getLastName() != null) {
                name.append(" ").append(userobj.getLastName());
            }
            userMap.put(userobj.getId(), name.toString());
        }

        List<UserDataBean> userListDataBeans = new ArrayList<>();
        for (UMUser user : userList) {
            UserDataBean userDataBeanObj = new UserDataBean();
            userDataBeanObj.setUserName(userMap.get(user.getId()));
            userDataBeanObj.setUserId(user.getId());
            userListDataBeans.add(userDataBeanObj);
        }
        return userListDataBeans;
    }

    public List<RoleDataBean> retrieveRoleList() throws UMUserManagementException {
        List<UMRole> roles;
        roles = roleService.retrieveAllRoles(Boolean.TRUE);
        List<RoleDataBean> roleList = new ArrayList<>();
        for (UMRole role : roles) {
            RoleDataBean Role = new RoleDataBean();
            Role.setId(role.getId());
            Role.setName(role.getName());
            roleList.add(Role);
        }
        systemResultViewUtil.setRoleList(roleList);
        return roleList;
    }

    public String deactivate(UserDataBean userBean) throws UMUserManagementException {
        UMUser user = userService.getUserbyId(systemResultSessionUtil.getId(), false, false, false, false);
        user.setIsActive(false);
        userService.updateUser(user, false, false, false, false);
        userBean.setIsActive(user.getIsActive());
        return SystemConstantUtil.INACTIVE;

    }

    public String activate(UserDataBean userBean) throws UMUserManagementException {
        UMUser user = userService.getUserbyId(systemResultSessionUtil.getId(), false, false, false, false);
        user.setIsActive(true);
        userService.updateUser(user, false, false, false, false);

        userBean.setIsActive(user.getIsActive());
        return SystemConstantUtil.ACTIVE;

    }

    public String addNewUser(UserDataBean userDataBean) throws UMUserManagementException, GenericDatabaseException {

        systemResultViewUtil.setConfirmpassword(null);
        systemResultViewUtil.setUserNameUnavailable(null);
        if (userDataBean.getConfirmPassword() != null && !userDataBean.getConfirmPassword().equals(userDataBean.getPassword())) {
            systemResultViewUtil.setConfirmpassword(SystemConstantUtil.PASSWORD_DONT_MATCH);
            return null;
        } else {
            Boolean isUserExist = userService.isUserExist(userDataBean.getUserName());
            UMUser user = new UMUser();
            UMUserContact contact = new UMUserContact();
            EmailNotification email = new EmailNotification();
            UMUserRole role = new UMUserRole();
            UMUserRolePK roleKey = new UMUserRolePK();
            //map to get role by its id.
            Map<String, Object> equal = new HashMap<>();
            Long id = userDataBean.getRoleId();
            equal.put(UMRoleDao.ID, id);
            List<UMRole> systemRole = roleService.retrieveRoles(equal, null, null, null);
            user.setFirstName(userDataBean.getFirstName());
            user.setLastName(userDataBean.getLastName());
            user.setType(systemRole.get(0).getName());
            if (!isUserExist) {
                user.setUserId(userDataBean.getUserName());
            } else {
                systemResultViewUtil.setUserNameUnavailable(SystemConstantUtil.USERNAME_UNAVAILABLE);
                return null;
            }
            user.setPassword(basicPasswordEncryptor.encryptPassword(userDataBean.getPassword()));
            user.setEmailAddress(userDataBean.getEmailId());
            user.setIsActive(true);
            user.setIsArchive(false);
            user.setCreatedBy(loginDataBean.getId());
            user.setMobileNumber(userDataBean.getPhoneNum());
            user.setCreatedOn(Calendar.getInstance().getTime());
            contact.setFirstName(userDataBean.getFirstName());
            contact.setLastName(userDataBean.getLastName());
            contact.setCreatedBy(loginDataBean.getId());
            contact.setIsActive(true);
            contact.setIsArchive(false);
            contact.setMobileNumber(userDataBean.getPhoneNum());
            contact.setEmailAddress(userDataBean.getEmailId());
            contact.setCreatedOn(Calendar.getInstance().getTime());
            contact.setUserobj(user);
            email.setUser(user.getId());
            user.setContact(contact);
            Long userid = userService.createUser(user);
            email.setUser(user.getId());
            email.setAssignedTaskUpdateMail(userDataBean.getTskUpdate());
            email.setProjectAssignedMail(true);
            email.setTaskDeadlineWarningMail(userDataBean.getTskDeadline());
            email.setTaskEndRemainderMail(userDataBean.getTskEnd());
            email.setTaskAllocationMail(userDataBean.getTskAllocation());
            email.setWatchMail(userDataBean.getWatcherFlag());
            roleKey.setRole(systemRole.get(0).getId());
            roleKey.setUserobj(userid);
            role.setIsActive(true);
            role.setIsArchive(false);
            role.setuMUserRolePK(roleKey);
            role.setuMUser(user);
            userService.createUserRole(role);
            emailNotificationService.createEmailNotification(email);
            String msg;
            if (userid != null) {
                msg = SystemConstantUtil.SUCCESS;
            } else {
                msg = SystemConstantUtil.FAILURE;
            }
            return msg;
        }
    }

    public String updateUserData(UserDataBean userDataBean) throws UMUserManagementException {

        UMUser user = userService.getUserbyId(systemResultSessionUtil.getId(), true, false, true, false);
        UMUserContact contact = user.getContact();
        EmailNotification email = emailNotificationService.retrieveEmailNotificationByUserId(user.getId());
        Set<UMUserRole> userRoles = user.getUMUserRoleSet();
        if (systemResultViewUtil.getRoleList() != null) {
            for (RoleDataBean role : systemResultViewUtil.getRoleList()) {
                if (((long) role.getId()) == userDataBean.getRoleId()) {
                    user.setType(role.getName());
                }
            }
        }
        user.setFirstName(userDataBean.getFirstName());
        user.setLastName(userDataBean.getLastName());
        user.setEmailAddress(userDataBean.getEmailId());
        user.setMobileNumber(userDataBean.getPhoneNum());
        user.setModifiedBy(loginDataBean.getId());
        contact.setFirstName(userDataBean.getFirstName());
        contact.setLastName(userDataBean.getLastName());
        contact.setModifiedBy(loginDataBean.getId());
        contact.setIsActive(true);
        contact.setIsArchive(false);
        contact.setModifiedOn(Calendar.getInstance().getTime());
        contact.setMobileNumber(userDataBean.getPhoneNum());
        contact.setEmailAddress(userDataBean.getEmailId());
        contact.setCreatedOn(Calendar.getInstance().getTime());
        email.setUser(user.getId());
        email.setAssignedTaskUpdateMail(userDataBean.getTskUpdate());
        email.setProjectAssignedMail(true);
        email.setTaskDeadlineWarningMail(userDataBean.getTskDeadline());
        email.setTaskEndRemainderMail(userDataBean.getTskEnd());
        email.setTaskAllocationMail(userDataBean.getTskAllocation());
        email.setWatchMail(userDataBean.getWatcherFlag());
        Boolean flag = false;
        UMUserRole newRole = new UMUserRole();
        UMUserRolePK tempPK = new UMUserRolePK(user.getId(), userDataBean.getRoleId());
        for (UMUserRole oldRole : userRoles) {
            if (oldRole.getuMUserRolePK().equals(tempPK)) {
                oldRole.setIsActive(true);
                oldRole.setIsArchive(false);
                flag = true;
            } else {
                oldRole.setIsActive(false);
                oldRole.setIsArchive(true);
            }
            userService.updateUserRole(oldRole);
        }
        if (!flag) {
            newRole.setIsActive(true);
            newRole.setIsArchive(false);
            newRole.setuMUser(user);
            newRole.setuMUserRolePK(tempPK);
            userService.createUserRole(newRole);
        }
        userService.updateUser(user, false, false, false, false);
        userService.updateUserContact(contact);
        emailNotificationService.updateEmailNotification(email);
        systemResultSessionUtil.setId(null);
        return SystemConstantUtil.EDIT_SUCCESSFUL;
    }

    /**
     * method is used for changing the current login password
     *
     * @author Brijesh
     * @param loginDataBean
     * @return True If Password Change Successfully
     */
    public String changePassword(LoginDataBean loginDataBean) {
        String result = SystemConstantUtil.FAILURE;
        String userId = loginDataBean.getUserId();
        try {
            if (userDataBean.getOldPassword().equals(loginDataBean.getPassword())) {
                String encriptedNewPassword = basicPasswordEncryptor.encryptPassword(userDataBean.getNewPassword());
                String pass = userService.resetPassword(userId, encriptedNewPassword);
                if (pass != null) {
                    result = SystemConstantUtil.SUCCESS;
                }
            }
        } catch (UMUserManagementException e) {
            e.printStackTrace();
        }
        return result;
    }

    public UserDataBean convertUMUserModelToUserManagementDataBean(UMUser user, UserDataBean userDataBean, EmailNotification email) {
        if (userDataBean == null) {
            userDataBean = new UserDataBean();
        }
        userDataBean.setFirstName(user.getFirstName());
        userDataBean.setLastName(user.getLastName());
        userDataBean.setUserName(user.getUserId());
        userDataBean.setPassword(user.getPassword());
        userDataBean.setEmailId(user.getEmailAddress());
        userDataBean.setUserId(user.getId());
        userDataBean.setRole(user.getType());
        userDataBean.setLastLoggedInTime(user.getLastLoginOn());
        userDataBean.setCreatedOn(user.getCreatedOn());
        userDataBean.setPhoneNum(user.getMobileNumber());
        userDataBean.setProfilePicture(user.getCustom2());
        if (email != null) {
            userDataBean.setTskAllocation(email.getTaskAllocationMail());
            userDataBean.setTskDeadline(email.getTaskDeadlineWarningMail());
            userDataBean.setTskEnd(email.getTaskEndRemainderMail());
            userDataBean.setTskUpdate(email.getAssignedTaskUpdateMail());
            userDataBean.setWatcherFlag(email.getWatchMail());
        }
        return userDataBean;
    }

    public UMUser retrieveUserByUserId(Long userId) {
        UMUser user = null;
        try {
            user = userService.getUserbyId(userId, true, false, true, false);

        } catch (UMUserManagementException ex) {
            Logger.getLogger(UserTransformerBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public UserDataBean retrieveUserForUpdate() throws GenericDatabaseException {
        UserDataBean userDataBean = null;

        if (systemResultSessionUtil.getId() != null) {

            UMUser uMUser = this.retrieveUserByUserId(systemResultSessionUtil.getId());
            Map<String, Object> equal = new HashMap<>();
            //map to get role by name.
            String roleName = uMUser.getType();
            equal.put(UMRoleDao.NAME, roleName);
            List<UMRole> systemRole = roleService.retrieveRoles(equal, null, null, null);
            UMRole uMRole = systemRole.get(0);
            EmailNotification email = emailNotificationService.retrieveEmailNotificationByUserId(uMUser.getId());
            userDataBean = this.convertUMUserModelToUserManagementDataBean(uMUser, userDataBean, email);
            userDataBean.setRoleId(uMRole.getId());
        }
        return userDataBean;
    }

    /**
     * Method is used for retrieve LoggedIn User Info
     *
     * @author Brijesh
     * @param id
     * @param userId
     */
    public void retrieveLoggedInUserInfo(Long id) throws GenericDatabaseException {
        UserDataBean dataBean = null;
        UMUser uMUser = null;

        uMUser = userService.retrieveUserById(id, null);
        dataBean = this.convertUMUserModelToUserManagementDataBean(uMUser, dataBean, null);

        this.retrieveNotificationInfo(id);
        this.userDataBean.setFirstName(dataBean.getFirstName());
        this.userDataBean.setLastName(dataBean.getLastName());
        this.userDataBean.setUserName(dataBean.getFirstName() + " " + dataBean.getLastName());
        this.userDataBean.setEmailId(dataBean.getEmailId());
        this.userDataBean.setPhoneNum(dataBean.getPhoneNum());
        this.userDataBean.setLastLoggedInTime(dataBean.getLastLoggedInTime());
        this.userDataBean.setCreatedOn(dataBean.getCreatedOn());
        this.loginDataBean.setProfilePicture(dataBean.getProfilePicture());
        if (dataBean.getProfilePicture() != null) {
            this.userDataBean.setDisplayImgFlag(Boolean.TRUE);
        } else {
            this.userDataBean.setDisplayImgFlag(Boolean.FALSE);
        }
        loginDataBean.setProfilePicturePath(SystemConstantUtil.PROFILE_PIC_PATH + loginDataBean.getProfilePicture());
    }

    /**
     * Method is used for update LoggedIn User Info
     *
     * @author Brijesh
     * @param userDataBean
     */
    public void updateLoggedInUserInfo(UserDataBean userDataBean) throws GenericDatabaseException {
        try {
            UMUser user = userService.retrieveUserById(loginDataBean.getId(), null);
            user.setFirstName(userDataBean.getFirstName());
            user.setLastName(userDataBean.getLastName());
            user.setEmailAddress(userDataBean.getEmailId());
            user.setMobileNumber(userDataBean.getPhoneNum());
            user.setModifiedBy(loginDataBean.getId());
            user.setModifiedOn(new Date());
            userService.updateUser(user, false, false, false, false);
            loginDataBean.setName(userDataBean.getFirstName() + " " + userDataBean.getLastName());
        } catch (UMUserManagementException e) {
            e.printStackTrace();
        }

    }

    /**
     * Change Profile Picture of LoggedIn User
     *
     * @author Brijesh
     */
    public void updateProfilePicture() throws GenericDatabaseException {
        try {
            UMUser user = userService.retrieveUserById(loginDataBean.getId(), null);
            user.setCustom2(loginDataBean.getProfilePicture());
            userService.updateUser(user, false, false, false, false);
        } catch (UMUserManagementException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * update NotificationInfo Of LoggedIn User
     *
     * @author Brijesh
     * @param userDataBean
     * @throws UMUserManagementException
     */
    public void updateNotificationInfo(UserDataBean userDataBean) throws UMUserManagementException, GenericDatabaseException {
        EmailNotification emailNotification = emailNotificationService.retrieveEmailNotificationByUserId(loginDataBean.getId());
        if (emailNotification == null) {
            emailNotification = new EmailNotification();
            UMUser user = userService.retrieveUserById(loginDataBean.getId(), null);
            emailNotification.setUser(user.getId());
        }
        emailNotification.setAssignedTaskUpdateMail(userDataBean.getTskUpdate());
        emailNotification.setProjectAssignedMail(true);
        emailNotification.setTaskDeadlineWarningMail(userDataBean.getTskDeadline());
        emailNotification.setTaskEndRemainderMail(userDataBean.getTskEnd());
        emailNotification.setTaskAllocationMail(userDataBean.getTskAllocation());
        emailNotification.setWatchMail(userDataBean.getWatcherFlag());
        emailNotification.setLastModifiedBy(loginDataBean.getId());
        emailNotification.setLastModifiedOn(Calendar.getInstance().getTime());
        emailNotificationService.updateEmailNotification(emailNotification);

    }

    /**
     * retrieve NoitificationInfo of LoggedIN User
     *
     * @author Brijesh
     * @param id
     */
    public void retrieveNotificationInfo(Long id) {
        EmailNotification emailNotification = emailNotificationService.retrieveEmailNotificationByUserId(id);
        if (emailNotification != null) {
            this.userDataBean.setTskAllocation(emailNotification.getTaskAllocationMail());
            this.userDataBean.setTskDeadline(emailNotification.getTaskDeadlineWarningMail());
            this.userDataBean.setTskEnd(emailNotification.getTaskEndRemainderMail());
            this.userDataBean.setTskUpdate(emailNotification.getAssignedTaskUpdateMail());
            this.userDataBean.setWatcherFlag(emailNotification.getWatchMail());
        } else {
            this.userDataBean.setTskAllocation(Boolean.TRUE);
            this.userDataBean.setTskDeadline(Boolean.TRUE);
            this.userDataBean.setTskEnd(Boolean.TRUE);
            this.userDataBean.setTskUpdate(Boolean.TRUE);
            this.userDataBean.setWatcherFlag(Boolean.TRUE);
        }
    }

    public Long addUserSkills(Long techId, Double totalExperience) {
        TechnologyMaster technologyMaster = userSkillsService.retrieveTechnologyById(techId);
        UserSkillSet userSkillSet = new UserSkillSet();
        userSkillSet.setCreatedBy(loginDataBean.getId());
        userSkillSet.setExperience(totalExperience);
        userSkillSet.setIsActive(true);
        userSkillSet.setLastModifiedBy(loginDataBean.getId());
        userSkillSet.setUserId(loginDataBean.getId());
        userSkillSet.setTechnologyId(technologyMaster);

        Long userskillId = userSkillsService.createUserSkill(userSkillSet);
        return userskillId;
    }

}
