/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.query;

import com.entity.Orderok;
import com.entity.OrderokPK;
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
       Product product = new Product();
       List<Product> k = em.createNamedQuery("Product.findAll", Product.class).getResultList();
       /*List<Prod> list = new ArrayList();
        for (Product k1 : k) {
            int id = k1.getProductPK().getIdProduct();
            String brand = k1.getProductPK().getIdBrend();
            int size = k1.getSize();
            String name = k1.getName();
            String season = k1.getSeason();
            int price = k1.getPrice();
            String photo = k1.getPhoto();
            list.add(new Prod(id, brand, size, name, season, price, photo));
        }*/
       return k;
    }
    
    public List<Product> basketProducts(String username)
    {
       List<Orderok> k = em.createNamedQuery("Orderok.findByIdLogin", Orderok.class).setParameter("idLogin", username).getResultList();
       List<Integer> list;
       list = new ArrayList();
       for (Orderok k1 : k) {
           list.add(k1.getOrderokPK().getIdProduct());
       }
       List<Product> basketList;
       basketList = new ArrayList();
       for(int i = 0; i < list.size(); i++)
           basketList.add(em.createNamedQuery("Product.findByIdProduct", Product.class).setParameter("idProduct", list.get(i)).getSingleResult());
       return basketList;
    }
    
    public void addToBasket(int id, String username)
    {
        //Product prod = new Product();
        //Query q= em.createNamedQuery("Orderok.findByIdProduct", Orderok.class).setParameter("idProduct", id);
        List<Orderok> k = em.createNamedQuery("Orderok.findByIdProduct", Orderok.class).setParameter("idProduct", id).getResultList();
        
        //List<Orderr> prod = q.getResultList();
            
        if(k.isEmpty())
        {
            Orderok order = new Orderok();
            OrderokPK orderPK = new OrderokPK();
            orderPK.setIdLogin(username);
            orderPK.setIdProduct(id);
            order.setOrderokPK(orderPK);
            order.setCount(1);
            em.persist(order);
        }
    }
}
