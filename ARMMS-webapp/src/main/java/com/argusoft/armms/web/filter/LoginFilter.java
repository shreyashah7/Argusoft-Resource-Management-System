/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.filter;

import com.argusoft.armms.web.usermanagement.databean.LoginDataBean;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author brijesh
 */
@WebFilter(filterName = "loginFilter")
public class LoginFilter implements Filter {

    private FilterConfig filterconfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterconfig = filterconfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httprequest = (HttpServletRequest) request;
        HttpServletResponse httpresponse = (HttpServletResponse) response;

        HttpSession session = (HttpSession) httprequest.getSession(true);
        System.out.println("====session Id in login filter======" + session.getId());
        LoginDataBean loginDataBean = (LoginDataBean) session.getAttribute("loginDataBean");
        String loginURL = httprequest.getContextPath() + "/dashboard";
        if (loginDataBean != null && loginDataBean.getIsLoggedin()) {
            httpresponse.sendRedirect(loginURL);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.print("Existing from loginFilter");
    }

}
