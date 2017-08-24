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
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * This is a handler class which is called when a user is not authorized to access the page which it is tryint access.
 * @author brijesh
 */
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    //  Other properties
    private static final Logger logger = Logger.getLogger(CustomAuthenticationSuccessHandler.class);

    /**
     * Method called when user tries to access some page and the access is denied.
     * @param request
     * @param response
     * @param accessDeniedException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        logger.info("----------------Access Denied handler---------------------------------------");
        response.sendRedirect(request.getContextPath()+"/"+SystemConstantUtil.ACCESS_DENIED_PAGE);
    }
}
