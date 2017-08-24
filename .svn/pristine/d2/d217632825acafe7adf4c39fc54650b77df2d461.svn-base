/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.servicebean;

import com.argusoft.armms.web.transformerbean.NotificationTransformerBean;
import com.argusoft.armms.web.usermanagement.databean.MessageDataBean;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * methods for displaying notifications on the page
 *
 * @author shreya
 */
@ManagedBean(name = "notificationServiceBean")
@RequestScoped
public class NotificationServiceBean {

    @ManagedProperty("#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;

    @ManagedProperty("#{messageDataBean}")
    private MessageDataBean messageDataBean;

    @ManagedProperty("#{notificationTransformerBean}")
    private NotificationTransformerBean notificationTransformerBean;

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    public NotificationTransformerBean getNotificationTransformerBean() {
        return notificationTransformerBean;
    }

    public MessageDataBean getMessageDataBean() {
        return messageDataBean;
    }

    public void setMessageDataBean(MessageDataBean messageDataBean) {
        this.messageDataBean = messageDataBean;
    }

    public void setNotificationTransformerBean(NotificationTransformerBean notificationTransformerBean) {
        this.notificationTransformerBean = notificationTransformerBean;
    }

    /**
     * retrieves all notification for particular user sets the list in
     * systemResultViewUtil
     *
     * @author shreya
     */
    public void retrieveAllNotificationsByUserId() throws UMUserManagementException {
        systemResultViewUtil.setNotificationList(notificationTransformerBean.retrieveAllNotificationsByUserId());
    }

    /**
     * returns the details of that notification on clicking it
     *
     * @author shreya
     */
    public void displayNotificationById(Long notificationId) throws UMUserManagementException {
        notificationTransformerBean.displayNotificationById(notificationId);
    }

    /**
     * delete that notification from the list
     * @author shreya
     */
    public void deActivateNotificationById() {
        try {
            notificationTransformerBean.deActivateNotificationById();
            messageDataBean.setIsSuccess(Boolean.TRUE);
            messageDataBean.setMessage("Notification removed");
            retrieveAllNotificationsByUserId();
        } catch (UMUserManagementException ex) {
            Logger.getLogger(NotificationServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
