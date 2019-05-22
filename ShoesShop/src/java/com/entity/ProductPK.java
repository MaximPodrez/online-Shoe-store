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
public class ProductPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "id_brend")
    private String idBrend;

    public ProductPK() {
    }

    public ProductPK(int idProduct, String idBrend) {
        this.idProduct = idProduct;
        this.idBrend = idBrend;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getIdBrend() {
        return idBrend;
    }

    public void setIdBrend(String idBrend) {
        this.idBrend = idBrend;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProduct;
        hash += (idBrend != null ? idBrend.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductPK)) {
            return false;
        }
        ProductPK other = (ProductPK) object;
        if (this.idProduct != other.idProduct) {
            return false;
        }
        if ((this.idBrend == null && other.idBrend != null) || (this.idBrend != null && !this.idBrend.equals(other.idBrend))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.ProductPK[ idProduct=" + idProduct + ", idBrend=" + idBrend + " ]";
    }
    
}
