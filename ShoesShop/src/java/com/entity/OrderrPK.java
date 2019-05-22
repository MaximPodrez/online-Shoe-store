/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author maxim
 */
@Embeddable
public class OrderrPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_order")
    private int idOrder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_login")
    private int idLogin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_product")
    private int idProduct;

    public OrderrPK() {
    }

    public OrderrPK(int idOrder, int idLogin, int idProduct) {
        this.idOrder = idOrder;
        this.idLogin = idLogin;
        this.idProduct = idProduct;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOrder;
        hash += (int) idLogin;
        hash += (int) idProduct;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderrPK)) {
            return false;
        }
        OrderrPK other = (OrderrPK) object;
        if (this.idOrder != other.idOrder) {
            return false;
        }
        if (this.idLogin != other.idLogin) {
            return false;
        }
        if (this.idProduct != other.idProduct) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.OrderrPK[ idOrder=" + idOrder + ", idLogin=" + idLogin + ", idProduct=" + idProduct + " ]";
    }
    
}
