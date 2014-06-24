/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kodcu.bean;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author hakdogan
 */

@ManagedBean
@RequestScoped
public class SpringSecurityBean implements Serializable {
    
    public String doLogin()  {
        
        try {
            
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            RequestDispatcher dispatcher = ((ServletRequest)context.getRequest()).getRequestDispatcher("/j_spring_security_check");

            dispatcher.forward((ServletRequest)context.getRequest(), (ServletResponse)context.getResponse());
            FacesContext.getCurrentInstance().responseComplete();
            
        } catch (ServletException | IOException ex) {
            Logger.getLogger(SpringSecurityBean.class.getName()).log(Level.SEVERE, null, ex);
        
        } finally {
            return null;
        }
    }

    public void authorizedUserControl(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(!authentication.getPrincipal().toString().equals("anonymousUser")){

            NavigationHandler nh =  FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
            nh.handleNavigation(FacesContext.getCurrentInstance(), null, "/member/index.xhtml?faces-redirect=true");

        }
    }
}

