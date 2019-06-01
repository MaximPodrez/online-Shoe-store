/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.query;

import com.entity.Login;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author maxim
 */
@Stateless
@LocalBean
public class ProfileEJB {
    @PersistenceContext(unitName = "ShoesShopPU")
    private EntityManager em;
    
    public void changeUsername(String username, String newUsername)
    {
        Login l = em.createNamedQuery("Login.findByUsername", Login.class).setParameter("username", username).getSingleResult();
        l.setUsername(newUsername);
    }
    
    public boolean changePassword(String username, String lastPassword, String newPassword)
    {
        if(newPassword.equals(""))
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Invalidate new password!\nTry again."));
            return false;
        }
        Login l = em.createNamedQuery("Login.findByUsername", Login.class).setParameter("username", username).getSingleResult();
        if(l.getPassword().equals(lastPassword))
        {
            l.setPassword(newPassword);
            return true;
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Wrong password!"));
        return false;
    }
    
    public void changeEmail(String username, String email)
    {
        Login l = em.createNamedQuery("Login.findByUsername", Login.class).setParameter("username", username).getSingleResult();
        l.setEmail(email);
    }
}
