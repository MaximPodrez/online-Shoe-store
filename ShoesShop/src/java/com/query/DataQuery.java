/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.query;

import com.entity.Login;
import java.io.Serializable;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author maxim
 */


@Stateless
@LocalBean 
public class DataQuery {
    // EntityManagerFactory emf;
    @PersistenceContext(unitName = "ShoesShopPU")
    private EntityManager em;
    
    //public DataQuery() {
      //  emf = Persistence.createEntityManagerFactory("MyFirstJSFApplicationPU");
        //em = emf.createEntityManager();
       // em.getTransaction().begin();
    //}
    
    public boolean loginControl(String username, String password)
    {        
        try{
            Login l;
           
            Query q= em.createNamedQuery("Login.control", Login.class);
          
            q.setParameter("username", username).setParameter("password", password);
           
            l=(Login)q.getSingleResult();
         
            //List<Login> k = em.createNamedQuery("Login.control", Login.class).setParameter("username", username).setParameter("password", password).getResultList();
            return l != null;
        }
        catch(Exception e)
        {
           return false;
        }
    }
    
    public boolean registrControl(String username, String password, String password1, String email)
    {        
        try{
            Login l;
           
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
    
}
