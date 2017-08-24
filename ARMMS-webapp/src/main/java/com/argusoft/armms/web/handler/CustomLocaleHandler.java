///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package com.argusoft.armms.web.handler;
//
//import com.argusoft.scope.web.usermanagement.databean.LoginDataBean;
//import com.sun.faces.application.view.MultiViewHandler;
//import java.util.Locale;
//import javax.faces.context.FacesContext;
//import javax.servlet.http.HttpSession;
//
///**
// * This class is used to change the locale as per user. It will change the default locale to the user specified one.
// * @author brijesh
// */
//public class CustomLocaleHandler extends MultiViewHandler {
//
//    /**
//     * Method to define locale of the user from the user's preferred language
//     * @param context
//     * @return 
//     */
//    @Override
//    public Locale calculateLocale(FacesContext context) {
//        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
//        if(session != null) {
//            LoginDataBean loginDataBean = (LoginDataBean) session.getAttribute("loginDataBean");
//            if(loginDataBean != null && loginDataBean.getPreferredLanguage() != null) {               
//                return new Locale(loginDataBean.getPreferredLanguage());
//            }
//        }
//        return super.calculateLocale(context);
//    }
//
//
//
//
//}
