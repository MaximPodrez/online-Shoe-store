/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.query;

import com.entity.Login;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author maxim
 */


@Stateless
@LocalBean 
public class DataQuery {
    @PersistenceContext(unitName = "ShoesShopPU")
    private EntityManager em;
    
    public boolean loginControl(String username, String password)
    {        
        try{
            List<Login> l;
           
            Query q= em.createNamedQuery("Login.findByUsername", Login.class).setParameter("username", username);//.setParameter("password", password);
            
            l = q.getResultList();
            
            if(l.isEmpty())
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Wrong username!"));
                return false;
            }
            
            if(!l.get(0).getPassword().equals(password))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Wrong password!"));
                return false;
            }
         
            return true;
        }
        catch(Exception e)
        {
           return false;
        }
    }
    
    public boolean registrControl(String username, String password, String password1, String email)
    {        
        try{
            
            if(username.equals(""))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Invalidate name!"));
                return false;
            }
            else if(password.equals(""))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Invalidate password!"));
                return false;
            }
            
            Query q= em.createNamedQuery("Login.findByUsername", Login.class);
          
            q.setParameter("username", username);
           
            List<Object> list = q.getResultList();
            
            if(list.isEmpty())
            {
                if(password.equals(password1))
                {
                    Login log = new Login();
                    log.setUsername(username);
                    log.setPassword(password);
                    log.setEmail(email);
                    em.persist(log);
                    return true;
                }
                else
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Different passwords! Try again."));
                    return false;
                }
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "This name is busy!"));
                return false;
            }
        }
        catch(Exception e)
        {
           return false;
        }
    }
    
    public String email(String username)
    {
        Login l = em.createNamedQuery("Login.findByUsername", Login.class).setParameter("username", username).getSingleResult();
        return l.getEmail();
    }
    
}
