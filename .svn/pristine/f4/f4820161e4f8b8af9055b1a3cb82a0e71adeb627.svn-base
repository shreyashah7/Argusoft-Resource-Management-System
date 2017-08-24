/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.handler;

import com.argusoft.armms.web.util.SystemConstantUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * This is the class to handle the event for successful authentication.
 *
 * @author brijesh
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    //  Other properties
    private static final Logger logger = Logger.getLogger(CustomAuthenticationSuccessHandler.class);

    /**
     * Method is called when successful authentication done
     *
     * @param request
     * @param response
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("---------------Custom Authentication Success Handler----------------");

        //        Setting Cookies to the user browser if remember me is enabled else removing existing cookies
        Cookie userIdCookie;
        Cookie passwordCookie;
        Cookie rememberMeCookie;

        if (request.getParameter("_spring_security_remember_me") != null) {

            userIdCookie = new Cookie("USERID", authentication.getName());
            passwordCookie = new Cookie("PASSWORD", request.getParameter("j_password"));
            rememberMeCookie = new Cookie("REMEMBERME", "true");

            int age = 3600 * 24 * 14;
            userIdCookie.setMaxAge(age);
            passwordCookie.setMaxAge(age);
            rememberMeCookie.setMaxAge(age);

            userIdCookie.setPath("/");
            passwordCookie.setPath("/");
            rememberMeCookie.setPath("/");
        } else {
            userIdCookie = new Cookie("USERID", "");
            passwordCookie = new Cookie("PASSWORD", "");
            rememberMeCookie = new Cookie("REMEMBERME", "false");

            userIdCookie.setMaxAge(0);
            passwordCookie.setMaxAge(0);
            rememberMeCookie.setMaxAge(0);

            userIdCookie.setPath("/");
            passwordCookie.setPath("/");
            rememberMeCookie.setPath("/");
        }
        response.addCookie(userIdCookie);
        response.addCookie(passwordCookie);
        response.addCookie(rememberMeCookie);

        response.sendRedirect(SystemConstantUtil.HOME_PAGE);
        HttpSession session = (HttpSession) request.getSession(true);
        session.setAttribute(SystemConstantUtil.AUTHENTICATED_SESSION, "true");
        System.out.println("======session id in success handler=====" + session.getId());
    }
}
