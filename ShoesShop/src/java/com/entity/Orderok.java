/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author maxim
 */
@Entity
@Table(name = "orderok")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderok.findAll", query = "SELECT o FROM Orderok o"),
    @NamedQuery(name = "Orderok.findByIdOrder", query = "SELECT o FROM Orderok o WHERE o.idOrder = :idOrder"),
    @NamedQuery(name = "Orderok.removeOrder", query = "DELETE FROM Orderok o WHERE o.product = :product"),
    @NamedQuery(name = "Orderok.findByProduct", query = "SELECT o FROM Orderok o WHERE o.product = :product"),
})
public class Orderok implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "count")
    private Integer count;
    @JoinColumn(name = "id_login", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Login login;
    @JoinColumn(name = "id_product", referencedColumnName = "id_product")
    @ManyToOne(optional = false)
    private Product product;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_order")
    private int idOrder;

    public Orderok() {
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }
    

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.idOrder);
        hash = 61 * hash + Objects.hashCode(this.count);
        hash = 61 * hash + Objects.hashCode(this.login);
        hash = 61 * hash + Objects.hashCode(this.product);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Orderok other = (Orderok) obj;
        if (!Objects.equals(this.idOrder, other.idOrder)) {
            return false;
        }
        if (!Objects.equals(this.count, other.count)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        return Objects.equals(this.product, other.product);
    }

    @Override
    public String toString() {
        return "Orderok{" + "orderokPK=" + idOrder + ", count=" + count + ", login=" + login + ", product=" + product + '}';
    }
    
    
}
