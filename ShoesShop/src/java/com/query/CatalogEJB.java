/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.query;

import com.entity.Login;
import com.entity.Orderok;
import com.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author maxim
 */

@Stateless
@LocalBean
public class CatalogEJB {
    @PersistenceContext(unitName = "ShoesShopPU")
    private EntityManager em;
    
    public List<Product> products()
    {
       List<Product> k = em.createNamedQuery("Product.findAll", Product.class).getResultList();
       return k;
    }
    
    public List<Product> basketProducts(String username)
    {
       Login log = em.createNamedQuery("Login.findByUsername", Login.class).setParameter("username", username).getSingleResult();
       List<Orderok> list;
       List<Product> basketList = new ArrayList();
       list = log.getOrderCollection();
       for(int i = 0; i < list.size(); i++)
           basketList.add(list.get(i).getProduct());
       return basketList;
    }
    
    public void delete(Product product, String username)
    {
        //em.createQuery("delete from orderok where id_product = " + product.getProductPK().getIdProduct()).executeUpdate();
        //Query query = em.createNamedQuery("Orderok.removeOrder");
        //query.setParameter("product", product);
        //query.executeUpdate();
        Login log = em.createNamedQuery("Login.findByUsername", Login.class).setParameter("username", username).getSingleResult();
        List<Orderok> list;
        list = log.getOrderCollection();
        for(int i = 0; i < list.size(); i++)
        {
            if(log.getOrderCollection().get(i).getProduct().getName().equals(product.getName()) && log.getOrderCollection().get(i).getProduct().getSizzze() == product.getSizzze())
                log.getOrderCollection().remove(i);
        }
    }
    
    public void addToBasket(Product product, String username)
    {
        List<Orderok> k = em.createNamedQuery("Orderok.findByProduct", Orderok.class).setParameter("product", product).getResultList();
        int p = 0;
        Login log = em.createNamedQuery("Login.findByUsername", Login.class).setParameter("username", username).getSingleResult();
        for(int i = 0; i < log.getOrderCollection().size(); i++)
        {
            if(log.getOrderCollection().get(i).getProduct().getName().equals(product.getName()) && log.getOrderCollection().get(i).getProduct().getSizzze() == product.getSizzze()) {
                p++;
                break;
            }
        }
            
        if(p == 0)
        {
            Orderok order = new Orderok();
            order.setCount(1);
            order.setLogin(log);
            order.setProduct(product);
            
            //em.persist(order);
             log.getOrderCollection().add(order);
            
        }
    }
    
    public void update(Product product, String username)
    {
        Login log = em.createNamedQuery("Login.findByUsername", Login.class).setParameter("username", username).getSingleResult();
        Orderok order = em.createNamedQuery("Orderok.findByProduct", Orderok.class).setParameter("product", product).getSingleResult();
        log.getOrderCollection().add(order);
    }
}
