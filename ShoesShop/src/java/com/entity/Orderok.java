/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    @NamedQuery(name = "Orderok.findByIdOrder", query = "SELECT o FROM Orderok o WHERE o.orderokPK.idOrder = :idOrder"),
    @NamedQuery(name = "Orderok.findByIdLogin", query = "SELECT o FROM Orderok o WHERE o.orderokPK.idLogin = :idLogin"),
    @NamedQuery(name = "Orderok.findByIdProduct", query = "SELECT o FROM Orderok o WHERE o.orderokPK.idProduct = :idProduct"),
    @NamedQuery(name = "Orderok.findByCount", query = "SELECT o FROM Orderok o WHERE o.count = :count")})
public class Orderok implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderokPK orderokPK;
    @Column(name = "count")
    private Integer count;

    public Orderok() {
    }

    public Orderok(OrderokPK orderokPK) {
        this.orderokPK = orderokPK;
    }

    public Orderok(int idOrder, String idLogin, int idProduct) {
        this.orderokPK = new OrderokPK(idOrder, idLogin, idProduct);
    }

    public OrderokPK getOrderokPK() {
        return orderokPK;
    }

    public void setOrderokPK(OrderokPK orderokPK) {
        this.orderokPK = orderokPK;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderokPK != null ? orderokPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderok)) {
            return false;
        }
        Orderok other = (Orderok) object;
        if ((this.orderokPK == null && other.orderokPK != null) || (this.orderokPK != null && !this.orderokPK.equals(other.orderokPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Orderok[ orderokPK=" + orderokPK + " ]";
    }
    
}
