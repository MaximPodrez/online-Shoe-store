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
@Table(name = "order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderr.findAll", query = "SELECT o FROM Orderr o"),
    @NamedQuery(name = "Orderr.findByIdOrder", query = "SELECT o FROM Orderr o WHERE o.orderrPK.idOrder = :idOrder"),
    @NamedQuery(name = "Orderr.findByIdLogin", query = "SELECT o FROM Orderr o WHERE o.orderrPK.idLogin = :idLogin"),
    @NamedQuery(name = "Orderr.findByIdProduct", query = "SELECT o FROM Orderr o WHERE o.orderrPK.idProduct = :idProduct"),
    @NamedQuery(name = "Orderr.findByCount", query = "SELECT o FROM Orderr o WHERE o.count = :count")})
public class Orderr implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderrPK orderrPK;
    @Column(name = "count")
    private Integer count;

    public Orderr() {
    }

    public Orderr(OrderrPK orderrPK) {
        this.orderrPK = orderrPK;
    }

    public Orderr(int idOrder, int idLogin, int idProduct) {
        this.orderrPK = new OrderrPK(idOrder, idLogin, idProduct);
    }

    public OrderrPK getOrderrPK() {
        return orderrPK;
    }

    public void setOrderrPK(OrderrPK orderrPK) {
        this.orderrPK = orderrPK;
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
        hash += (orderrPK != null ? orderrPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderr)) {
            return false;
        }
        Orderr other = (Orderr) object;
        if ((this.orderrPK == null && other.orderrPK != null) || (this.orderrPK != null && !this.orderrPK.equals(other.orderrPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Orderr[ orderrPK=" + orderrPK + " ]";
    }
    
}
