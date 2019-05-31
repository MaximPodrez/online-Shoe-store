/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.query;

import com.entity.Comment;
import com.entity.Login;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
public class CommentEJB {
    @PersistenceContext(unitName = "ShoesShopPU")
    private EntityManager em;
    
    public List<Comment> comments(String username)
    {
        List<Comment> comment = em.createNamedQuery("Comment.findAll", Comment.class).getResultList();
        return comment;
    }
    
    public void add(String comment, String username)
    {
        Login log = em.createNamedQuery("Login.findByUsername", Login.class).setParameter("username", username).getSingleResult();
        Comment comm = new Comment();
        comm.setComment(comment);
        comm.setLogin(log);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 
        comm.setDatte(format.format(calendar.getTime()));
        log.getCommentCollection().add(comm);
    }
}

