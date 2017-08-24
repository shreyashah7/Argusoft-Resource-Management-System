/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.listener;

/**
 *
 * @author brijesh
 */
import com.argusoft.armms.web.util.SystemConstantUtil;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.util.StringUtils;

public class LoginErrorPhaseListener implements PhaseListener {

    private static final long serialVersionUID = -1216620620302322995L;

    @Override
    public void beforePhase(final PhaseEvent arg0) {
        Exception e = (Exception) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(
                "SPRING_SECURITY_LAST_EXCEPTION");
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        boolean isLogin = false;
        if (session != null && session.getAttribute(SystemConstantUtil.IS_LOGIN) != null && StringUtils.hasText(session.getAttribute(SystemConstantUtil.IS_LOGIN).toString()) && session.getAttribute(SystemConstantUtil.IS_LOGIN).toString().trim().equalsIgnoreCase("true")) {
            isLogin = true;
        }
        if (e instanceof BadCredentialsException) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(
                    "SPRING_SECURITY_LAST_EXCEPTION", null);
            if (isLogin) {
                FacesContext.getCurrentInstance().addMessage("errorMsg", new FacesMessage("The Username or Password you entered is incorrect"));
            }
        }
    }

    @Override
    public void afterPhase(final PhaseEvent arg0) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }
}
