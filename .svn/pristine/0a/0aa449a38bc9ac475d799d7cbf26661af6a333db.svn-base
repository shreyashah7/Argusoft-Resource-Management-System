/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.util;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.util.StringUtils;

/**
 *
 * @author mmodi
 */
@ManagedBean(name = "userAppUtil")
@ApplicationScoped
public class UserAppUtil {

//    SvnRepositoryScheduler demoScheduler = new SvnRepositoryScheduler();
    
    private Map<String, UserAppData> users;

    public UserAppUtil() {
        users = new HashMap<String, UserAppData>();
    }

    public boolean addUser(String userID, String type, HttpSession session) {
        boolean result = false;
        if (StringUtils.hasText(userID) && StringUtils.hasText(type) && session != null) {
            UserAppData userAppData = new UserAppData(userID, type, Status.ONLINE, session);
            users.put(userID, userAppData);
            Logger.getLogger(UserAppUtil.class.getName()).log(Level.INFO, "Add user into UserList : {0} Total Users {1}", new Object[]{userID, users.size()});
            result = true;
        }
        return result;
    }

    /**
     * @param userID  */
    public boolean removeUser(String userID) {
        boolean result = false;
        if (StringUtils.hasText(userID)) {
            Logger.getLogger(UserAppUtil.class.getName()).log(Level.INFO, "Removing user from UserList : {0} Total Users {1}", new Object[]{userID, users.size()});
            if (users.containsKey(userID)) {
                try {
                    HttpSession session = (HttpSession) users.get(userID).getHttpSession();
                    if (session != null) {
                        Logger.getLogger(UserAppUtil.class.getName()).log(Level.INFO, "Invalidationg session : {0}", session.getId());
                        session.invalidate();
                    }
                } catch (IllegalStateException ise) {
                    Logger.getLogger(UserAppUtil.class.getName()).log(Level.INFO, "IllegalStateException : Error invalidating user session");
                }
                users.remove(userID);
                result = true;
            }
        }
        return result;
    }

    /**
     * @param userID  */
    public boolean isSameUserSession(String userID, String sessionId) {
        boolean result = false;
        if (StringUtils.hasText(userID) && StringUtils.hasText(sessionId)) {
            Logger.getLogger(UserAppUtil.class.getName()).log(Level.INFO, "Verifying user session from UserList : {0} Total Users {1}", new Object[]{userID, users.size()});
            if (users.containsKey(userID)) {
                try {
                    HttpSession session = (HttpSession) users.get(userID).getHttpSession();
                    if (session != null && session.getId().equalsIgnoreCase(sessionId)) {
                        Logger.getLogger(UserAppUtil.class.getName()).log(Level.INFO, "same session : {0}", session.getId());
                        result = true;
                    }
                } catch (IllegalStateException ise) {
                    Logger.getLogger(UserAppUtil.class.getName()).log(Level.INFO, "IllegalStateException : Error invalidating user session");
                }
            }
        }
        return result;
    }

    public String retrieveUserStatus(String userID) {
        String status = Status.OFFLINE.getValue();
        if (StringUtils.hasText(userID)) {
            if (users.containsKey(userID)) {
                status = users.get(userID).getStatus().getValue();
            }
        }
        return status;
    }
    
    public Date retrieveUserLoggedInTime(String userID) {
        Date loggedInTime = null;
        if (StringUtils.hasText(userID)) {
            if (users.containsKey(userID)) {
                loggedInTime = users.get(userID).getLoggedInOn();
            }
        }
        return loggedInTime;
    }
    
    public HttpSession retrieveUserSession(String userID) {
        HttpSession httpSession = null;
        if(StringUtils.hasText(userID) && users.containsKey(userID)) {
            httpSession = users.get(userID).getHttpSession();
        }
        return httpSession;
    }

    public boolean updateUserStatusToBusy(String userID) {
        boolean result = false;
        if (StringUtils.hasText(userID)) {
            if (users.containsKey(userID)) {
                UserAppData userAppData = users.get(userID);
                userAppData.setStatus(Status.BUSY);
                users.put(userID, userAppData);
                result = true;
            }
        }
        return result;
    }

    public boolean updateUserStatusToOnline(String userID) {
        boolean result = false;
        if (StringUtils.hasText(userID)) {
            if (users.containsKey(userID)) {
                UserAppData userAppData = users.get(userID);
                userAppData.setStatus(Status.ONLINE);
                users.put(userID, userAppData);
                result = true;
            }
        }
        return result;
    }

    public List<String> retrieveOnlineUsersByType(String type) {
        List<String> userList = new LinkedList<String>();
        if (StringUtils.hasText(type)) {
            for (String userID : users.keySet()) {
                UserAppData userAppData = users.get(userID);
                if (userAppData != null
                        && (userAppData.getType() == null || userAppData.getType().equalsIgnoreCase(type.trim()))
                        && userAppData.getStatus().equals(Status.ONLINE)) {
                    userList.add(userID);
                }
            }
        }
        return userList;
    }

    public List<String> listUsers() {
        List<String> userList = new LinkedList<String>();
        for (String userID : users.keySet()) {
            userList.add(userID);
        }
        return userList;
    }

    public boolean isUserInList(String userID) {
        return users.containsKey(userID);
    }

    private enum Status {
        
        ONLINE("ONLINE"), BUSY("BUSY"), OFFLINE("BUSY");
        private String status;

        Status(String s) {
            status = s;
        }

        public String getValue() {
            return status;
        }
    }

    private class UserAppData {

        private String userId;
        private String type;
        private Status status;
        private Date loggedInOn;
        private HttpSession httpSession;

        public UserAppData(String userId, String type, Status status, HttpSession httpSession) {
            this.userId = userId;
            this.type = type;
            this.status = status;
            this.loggedInOn = new Date();
            this.httpSession = httpSession;
        }

        public Date getLoggedInOn() {
            return loggedInOn;
        }

        public void setLoggedInOn(Date loggedInOn) {
            this.loggedInOn = loggedInOn;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public HttpSession getHttpSession() {
            return httpSession;
        }

        public void setHttpSession(HttpSession httpSession) {
            this.httpSession = httpSession;
        }
    }
}