/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.query;

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
public class MainPaigeEJB {
    @PersistenceContext(unitName = "ShoesShopPU")
    private EntityManager em;
    
    public List<String> images()
    {
       Product product = new Product();
       List<Product> k = em.createNamedQuery("Product.findAll", Product.class).getResultList();
       List<String> list = new ArrayList();
       for(int i = 0; i < k.size(); i++)
           list.add(k.get(i).getPhoto());
       return list;
    }
}
