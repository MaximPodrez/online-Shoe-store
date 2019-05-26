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
import javax.validation.constraints.Size;

/**
 *
 * @author maxim
 */
@Embeddable
public class OrderokPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_order")
    private int idOrder;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_login")
    private String idLogin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_product")
    private int idProduct;

    public OrderokPK() {
    }

    public OrderokPK(int idOrder, String idLogin, int idProduct) {
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

    public String getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(String idLogin) {
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
        hash += (idLogin != null ? idLogin.hashCode() : 0);
        hash += (int) idProduct;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderokPK)) {
            return false;
        }
        OrderokPK other = (OrderokPK) object;
        if (this.idOrder != other.idOrder) {
            return false;
        }
        if ((this.idLogin == null && other.idLogin != null) || (this.idLogin != null && !this.idLogin.equals(other.idLogin))) {
            return false;
        }
        if (this.idProduct != other.idProduct) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.OrderokPK[ idOrder=" + idOrder + ", idLogin=" + idLogin + ", idProduct=" + idProduct + " ]";
    }
    
}
