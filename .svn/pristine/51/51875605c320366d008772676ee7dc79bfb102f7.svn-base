/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.handler;

import com.argusoft.armms.web.util.SystemConstantUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * This class is used to customize the logout behavior.
 * @author brijesh
 */
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    //  Other properties
    private static final Logger logger = Logger.getLogger(CustomLogoutSuccessHandler.class);

    /**
     * Method is called when successful logout done
     * @param request
     * @param response
     * @param authentication
     * @throws IOException
     * @throws ServletException 
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("------------------Custom Logout Success Handler------------------");
        response.sendRedirect(SystemConstantUtil.LOGOUT_URL);
    }
}
