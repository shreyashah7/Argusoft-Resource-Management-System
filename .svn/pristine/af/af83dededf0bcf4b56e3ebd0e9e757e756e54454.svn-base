/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.usermanagement.databean;

import com.fasterxml.jackson.databind.util.Comparators;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class is to perform CRUD operation on user.
 *
 * @author niharika
 */
@ManagedBean(name = "userDataBean")
@RequestScoped
public class UserDataBean implements Serializable, Comparable<UserDataBean> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;
    private String role;
    private String userName;
    private String password;
    private String emailId;
    private String showType;
    private String confirmPassword;
    private String phoneNum;
    private String message;
    private Boolean tskAllocation;
    private Boolean tskUpdate;
    private Boolean tskDeadline;
    private Boolean tskEnd;
    private Boolean isActive;
    private Boolean address;
    private String ProfilePicture;
    private Long roleId;
    private String oldPassword;
    private String newPassword;
    private String retypeNewPassword;
    private Date lastLoggedInTime;
    private Date createdOn;
    private Boolean displayImgFlag;
    private Boolean taskAllocationFlag;
    private Boolean watcherFlag;
    private Double totalExperience;
    private List<UserSkillDataBean> expList;
    private List usefulTechnologies;
    private Long techId;

    public Long getTechId() {
        return techId;
    }

    public void setTechId(Long techId) {
        this.techId = techId;
    }

    public List<UserSkillDataBean> getExpList() {
        return expList;
    }

    public void setExpList(List<UserSkillDataBean> expList) {
        this.expList = expList;
    }

    public List getUsefulTechnologies() {
        return usefulTechnologies;
    }

    public void setUsefulTechnologies(List usefulTechnologies) {
        this.usefulTechnologies = usefulTechnologies;
    }

    public Double getTotalExperience() {
        return totalExperience;
    }

    public void setTotalExperience(Double totalExperience) {
        this.totalExperience = totalExperience;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getWatcherFlag() {
        return watcherFlag;
    }

    public void setWatcherFlag(Boolean watcherFlag) {
        this.watcherFlag = watcherFlag;
    }

    public Boolean isTaskAllocationFlag() {
        return taskAllocationFlag;
    }

    public void setTaskAllocationFlag(Boolean taskAllocationFlag) {
        this.taskAllocationFlag = taskAllocationFlag;
    }

    public UserDataBean() {
    }

    public String getProfilePicture() {
        return ProfilePicture;
    }

    public void setProfilePicture(String ProfilePicture) {
        this.ProfilePicture = ProfilePicture;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getLastLoggedInTime() {
        return lastLoggedInTime;
    }

    public void setLastLoggedInTime(Date lastLoggedInTime) {
        this.lastLoggedInTime = lastLoggedInTime;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getRetypeNewPassword() {
        return retypeNewPassword;
    }

    public void setRetypeNewPassword(String retypeNewPassword) {
        this.retypeNewPassword = retypeNewPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getTskAllocation() {
        return tskAllocation;
    }

    public void setTskAllocation(Boolean tskAllocation) {
        this.tskAllocation = tskAllocation;
    }

    public Boolean getTskUpdate() {
        return tskUpdate;
    }

    public void setTskUpdate(Boolean tskUpdate) {
        this.tskUpdate = tskUpdate;
    }

    public Boolean getTskDeadline() {
        return tskDeadline;
    }

    public void setTskDeadline(Boolean tskDeadline) {
        this.tskDeadline = tskDeadline;
    }

    public Boolean getTskEnd() {
        return tskEnd;
    }

    public void setTskEnd(Boolean tskEnd) {
        this.tskEnd = tskEnd;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getAddress() {
        return address;
    }

    public void setAddress(Boolean address) {
        this.address = address;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Boolean getDisplayImgFlag() {
        return displayImgFlag;
    }

    public void setDisplayImgFlag(Boolean displayImgFlag) {
        this.displayImgFlag = displayImgFlag;
    }

    @Override
    public String toString() {
        return "UserDataBean{" + "userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role + ", userName=" + userName + ", password=" + password + ", emailId=" + emailId + ", showType=" + showType + ", confirmPassword=" + confirmPassword + ", phoneNum=" + phoneNum + ", message=" + message + ", tskAllocation=" + tskAllocation + ", tskUpdate=" + tskUpdate + ", tskDeadline=" + tskDeadline + ", tskEnd=" + tskEnd + ", isActive=" + isActive + ", address=" + address + ", ProfilePicture=" + ProfilePicture + ", roleId=" + roleId + ", oldPassword=" + oldPassword + ", newPassword=" + newPassword + ", retypeNewPassword=" + retypeNewPassword + ", lastLoggedInTime=" + lastLoggedInTime + ", createdOn=" + createdOn + ", displayImgFlag=" + displayImgFlag + ", taskAllocationFlag=" + taskAllocationFlag + ", watcherFlag=" + watcherFlag + ", totalExperience=" + totalExperience + ", expList=" + expList + ", usefulTechnologies=" + usefulTechnologies + '}';
    }

    @Override
    public int compareTo(UserDataBean o) {
        return Comparators.FIRST_NAME.compare(this, o);
    }

    public static class Comparators {

        public static Comparator<UserDataBean> FIRST_NAME = new Comparator<UserDataBean>() {
            @Override
            public int compare(UserDataBean o1, UserDataBean o2) {
                return o1.firstName.compareTo(o2.firstName);
            }
        };
        public static Comparator<UserDataBean> EXP_IN_MAX_OF_USEFUL_TECH = new Comparator<UserDataBean>() {
            @Override
            public int compare(UserDataBean o1, UserDataBean o2) {

                Long experienceO1 = 0l;

                for (UserSkillDataBean exp1 : o1.expList) {
                    if (o1.usefulTechnologies.contains(exp1.techid)) {
                        experienceO1++;
                    }
                }
                Long experienceO2 = 0l;

                for (UserSkillDataBean exp2 : o2.expList) {
                    if (o2.usefulTechnologies.contains(exp2.techid)) {

                        experienceO2++;
                    }
                }
//                System.out.println("user : "+o1.firstName + " Tech experience : "+experienceO1);
//                System.out.println("user : "+o2.firstName + " Tech experience : "+experienceO2);
                return (int) (experienceO2 - experienceO1);
            }
        };
        public static Comparator<UserDataBean> EXPERIENCE = new Comparator<UserDataBean>() {
            @Override
            public int compare(UserDataBean o1, UserDataBean o2) {

                Double experienceO1 = 0d;

                for (UserSkillDataBean exp1 : o1.expList) {
                    if (o1.usefulTechnologies.contains(exp1.techid)) {
//                        System.out.println("user :" + o1.firstName+" techId : "+exp1.techid);
                        experienceO1 = experienceO1 + exp1.experience;
                    }
                }
                Double experienceO2 = 0d;

                for (UserSkillDataBean exp2 : o2.expList) {
                    if (o2.usefulTechnologies.contains(exp2.techid)) {
//                         System.out.println("user :" + o2.firstName+" techId : "+exp2.techid);
                        experienceO2 = experienceO2 + exp2.experience;
                    }
                }
//                System.out.println("user : "+o1.firstName + " experience : "+experienceO1);
//                System.out.println("user : "+o2.firstName + " experience : "+experienceO2);
                return (int) (experienceO2 - experienceO1);
            }
        };
        public static Comparator<UserDataBean> NAME_AND_EXPERIENCE = new Comparator<UserDataBean>() {
            @Override
            public int compare(UserDataBean o1, UserDataBean o2) {
                int i = o1.totalExperience.compareTo(o2.totalExperience);
                if (i == 0) {
                    i = o1.firstName.compareTo(o2.firstName);
                }
                return i;
            }
        };
        public static Comparator<UserDataBean> NAME_EXPERIENCE_AND_TECH = new Comparator<UserDataBean>() {
            @Override
            public int compare(UserDataBean o1, UserDataBean o2) {

                int i = EXP_IN_MAX_OF_USEFUL_TECH.compare(o1, o2);
                if (i == 0) {
                    i = EXPERIENCE.compare(o1, o2);
                }
                if (i == 0) {
                    i = FIRST_NAME.compare(o1, o2);
                }
                return i;
            }
        };

    }

}
