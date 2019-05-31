/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.query;

import com.entity.Login;
import com.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
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
    
    public void changePassword(String username, String newPassword)
    {
        Login l = em.createNamedQuery("Login.findByUsername", Login.class).setParameter("username", username).getSingleResult();
        l.setPassword(newPassword);
    }
    
    public void changeEmail(String username, String email)
    {
        Login l = em.createNamedQuery("Login.findByUsername", Login.class).setParameter("username", username).getSingleResult();
        l.setEmail(email);
    }
}
