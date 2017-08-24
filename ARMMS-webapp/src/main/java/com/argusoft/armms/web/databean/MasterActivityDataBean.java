/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.argusoft.armms.web.databean;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 * for displaying latest update on the page.
 * @author shreya
 */
@ManagedBean(name = "masterActivityDataBean")
@RequestScoped
public class MasterActivityDataBean {
    
    private Date displayDate;
    private List<ActivityDataBean> activityDataBeanViewList;

    public Date getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(Date displayDate) {
        this.displayDate = displayDate;
    }

    public List<ActivityDataBean> getActivityDataBeanViewList() {
        return activityDataBeanViewList;
    }

    public void setActivityDataBeanViewList(List<ActivityDataBean> activityDataBeanViewList) {
        this.activityDataBeanViewList = activityDataBeanViewList;
    }

    @Override
    public String toString() {
        return "MasterActivityDataBean{" + "displayDate=" + displayDate + ", activityDataBeanViewList=" + activityDataBeanViewList + '}';
    }
    
}
