/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.usermanagement.servicebean;

import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import com.argusoft.armms.web.usermanagement.databean.MessageDataBean;
import com.argusoft.armms.web.usermanagement.transformerbean.LoginTransformerBean;
import com.argusoft.armms.web.util.SystemConstantUtil;
import com.argusoft.armms.web.util.UserAppUtil;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author brijesh
 */
@ManagedBean(name = "springSecurityLoginServiceBean")
@RequestScoped
public class LoginServiceBean {

    @ManagedProperty("#{loginDataBean}")
    private LoginDataBean loginDataBean;
    @ManagedProperty("#{menuServiceBean}")
    private MenuServiceBean menuServiceBean;
    @ManagedProperty("#{loginTransformerBean}")
    private LoginTransformerBean loginTransformerBean;
    @ManagedProperty("#{userAppUtil}")
    private UserAppUtil userAppUtil;

    public MenuServiceBean getMenuServiceBean() {
        return menuServiceBean;
    }

    public void setMenuServiceBean(MenuServiceBean menuServiceBean) {
        this.menuServiceBean = menuServiceBean;
    }

    public UserAppUtil getUserAppUtil() {
        return userAppUtil;
    }

    public void setUserAppUtil(UserAppUtil userAppUtil) {
        this.userAppUtil = userAppUtil;
    }

    public LoginTransformerBean getLoginTransformerBean() {
        return loginTransformerBean;
    }

    public void setLoginTransformerBean(LoginTransformerBean loginTransformerBean) {
        this.loginTransformerBean = loginTransformerBean;
    }

    public LoginDataBean getLoginDataBean() {
        return loginDataBean;
    }

    public void setLoginDataBean(LoginDataBean loginDataBean) {
        this.loginDataBean = loginDataBean;
    }

    protected final Log logger = LogFactory.getLog(getClass());

    /**
     *
     * Redirects the login request directly to spring security check. Leave this
     * method as it is to properly support spring security.
     *
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public void doLogin() throws ServletException, IOException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

        FacesContext facesContext = FacesContext.getCurrentInstance();

        //  code for successful authenticated users
        try {
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            session.setAttribute(SystemConstantUtil.IS_LOGIN, "true");

            loginDataBean.setUserId(loginDataBean.getUserId().toLowerCase());
            String userId = this.loginDataBean.getUserId();

            if (userId != null && !userId.trim().equalsIgnoreCase("")) {
                RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_check?j_username=" + loginDataBean.getUserId() + "&j_password=" + loginDataBean.getPassword());
                dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
                FacesContext.getCurrentInstance().responseComplete();

//                this.loginDataBean.setIsLoggedin(false);
            }

            session = (HttpSession) facesContext.getExternalContext().getSession(true);

            String sessionAuthentication = (String) session.getAttribute(SystemConstantUtil.AUTHENTICATED_SESSION);

            if (sessionAuthentication != null && sessionAuthentication.trim().equalsIgnoreCase("true")) {

                if (userId == null) {
                    userId = (String) session.getAttribute("SPRING_SECURITY_LAST_USERNAME");
                }

                if (userId != null) {
                    userId = userId.trim();
                }
                //  update user's last login information

                this.loginTransformerBean.updateLoginData(userId);
                menuServiceBean.loadMenuBasedOnRole();
                if (this.userAppUtil.isUserInList(userId) && !this.userAppUtil.isSameUserSession(userId, session.getId())) {
                    this.userAppUtil.removeUser(userId);
                }

                if (!this.userAppUtil.isUserInList(userId)) {
                    this.userAppUtil.addUser(userId, this.loginDataBean.getRole(), session);
                }

                this.loginDataBean.setIsLoggedin(true);

            }
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        }

    }

    public void doLogout() {
//        System.out.println("Do logout called>>>>>>>>");
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_logout");
        try {
            dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
        } catch (ServletException ex) {
            logger.error(ex);
        } catch (IOException ex) {
            logger.error(ex);
        }

        FacesContext.getCurrentInstance().responseComplete();
        this.loginDataBean.setIsLoggedin(false);
        String userId = this.loginDataBean.getUserId();
        if (userId != null && !userId.trim().equalsIgnoreCase("") && this.userAppUtil.isUserInList(userId)) {
            this.userAppUtil.removeUser(userId);
        }

    }

    public void checkCookie() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String cookieName = null;
        Cookie cookie[] = ((HttpServletRequest) facesContext.getExternalContext().getRequest()).getCookies();

        if (cookie != null && cookie.length > 0) {
            for (int i = 0; i < cookie.length; i++) {
                cookieName = cookie[i].getName();
                if (cookieName.equals("USERID")) {
                    this.loginDataBean.setUserId(cookie[i].getValue());
                } else if (cookieName.equals("PASSWORD")) {
                    this.loginDataBean.setPassword(cookie[i].getValue());
                } else if (cookieName.equals("REMEMBERME")) {
                    this.loginDataBean.setRememberMe(Boolean.parseBoolean(cookie[i].getValue()));
                }
            }
            logger.info("Cookie Found");
        } else {
            logger.info("Cannot find any cookie");
        }
    }

}
