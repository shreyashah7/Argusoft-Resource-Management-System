/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.argusoft.armms.web.usermanagement.databean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author shreya
 */
@ManagedBean(name = "messageDataBean")
@RequestScoped
public class MessageDataBean {
    
    private Long id;
    private String pageId;
    private String message;
    private Boolean isSuccess;
    private String message1;
    private Boolean isSuccess1;
    private Boolean hasRefreshBtn;
    private Boolean hasCancelBtn;
    

    public String getMessage1() {
        return message1;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public Boolean getIsSuccess1() {
        return isSuccess1;
    }

    public void setIsSuccess1(Boolean isSuccess1) {
        this.isSuccess1 = isSuccess1;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }        

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Boolean getHasCancelBtn() {
        return hasCancelBtn;
    }

    public void setHasCancelBtn(Boolean hasCancelBtn) {
        this.hasCancelBtn = hasCancelBtn;
    }

    public Boolean getHasRefreshBtn() {
        return hasRefreshBtn;
    }

    public void setHasRefreshBtn(Boolean hasRefreshBtn) {
        this.hasRefreshBtn = hasRefreshBtn;
    }  
    
}
