/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.argusoft.armms.web.databean;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * For notification block
 * @author shreya
 */
@ManagedBean(name = "notificationDataBean")
@RequestScoped
public class NotificationDataBean {
    
    private Long notificationId;
    private String featureId;
    private String featureName;
    private String featureType;
    private String notificationSubject;
    private Date notificationOnDate;
    private Date lastModifiedOn;
    private Boolean isActive;
    private String featureDesc;
    private Integer listSize = new Integer(-1);
    private Boolean pollEnabled;
    private Integer count = new Integer(0);

    public NotificationDataBean() {
    }

    public NotificationDataBean(Long notificationId, String featureId, String featureName, String featureType, String notificationSubject, Date notificationOnDate, Date lastModifiedOn, Boolean isActive, String featureDesc) {
        this.notificationId = notificationId;
        this.featureId = featureId;
        this.featureName = featureName;
        this.featureType = featureType;
        this.notificationSubject = notificationSubject;
        this.notificationOnDate = notificationOnDate;
        this.lastModifiedOn = lastModifiedOn;
        this.isActive = isActive;
        this.featureDesc = featureDesc;
    }

    public String getFeatureDesc() {
        return featureDesc;
    }

    public void setFeatureDesc(String featureDesc) {
        this.featureDesc = featureDesc;
    }

    public Integer getListSize() {
        return listSize;
    }

    public void setListSize(Integer listSize) {
        this.listSize = listSize;
    }

    public Boolean isPollEnabled() {
        return pollEnabled;
    }

    public void setPollEnabled(Boolean pollEnabled) {
        this.pollEnabled = pollEnabled;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getFeatureType() {
        return featureType;
    }

    public void setFeatureType(String featureType) {
        this.featureType = featureType;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getNotificationSubject() {
        return notificationSubject;
    }

    public void setNotificationSubject(String notificationSubject) {
        this.notificationSubject = notificationSubject;
    }

    public Date getNotificationOnDate() {
        return notificationOnDate;
    }

    public void setNotificationOnDate(Date notificationOnDate) {
        this.notificationOnDate = notificationOnDate;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "NotificationDataBean{" + "notificationId=" + notificationId + ", featureId=" + featureId + ", featureName=" + featureName + ", featureType=" + featureType + ", notificationSubject=" + notificationSubject + ", notificationOnDate=" + notificationOnDate + ", lastModifiedOn=" + lastModifiedOn + ", isActive=" + isActive + ", featureDesc=" + featureDesc + '}';
    }
    
    
    
    
}
