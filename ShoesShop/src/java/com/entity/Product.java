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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author maxim
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByIdProduct", query = "SELECT p FROM Product p WHERE p.productPK.idProduct = :idProduct"),
    @NamedQuery(name = "Product.findByIdBrend", query = "SELECT p FROM Product p WHERE p.productPK.idBrend = :idBrend"),
    @NamedQuery(name = "Product.findBySize", query = "SELECT p FROM Product p WHERE p.size = :size"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name = "Product.findBySeason", query = "SELECT p FROM Product p WHERE p.season = :season"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price"),
    @NamedQuery(name = "Product.findByPhoto", query = "SELECT p FROM Product p WHERE p.photo = :photo")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductPK productPK;
    @Column(name = "size")
    private Integer size;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "season")
    private String season;
    @Column(name = "price")
    private Integer price;
    @Size(max = 45)
    @Column(name = "photo")
    private String photo;

    public Product() {
    }

    public Product(ProductPK productPK) {
        this.productPK = productPK;
    }

    public Product(int idProduct, String idBrend) {
        this.productPK = new ProductPK(idProduct, idBrend);
    }

    public ProductPK getProductPK() {
        return productPK;
    }

    public void setProductPK(ProductPK productPK) {
        this.productPK = productPK;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productPK != null ? productPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productPK == null && other.productPK != null) || (this.productPK != null && !this.productPK.equals(other.productPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Product[ productPK=" + productPK + " ]";
    }
    
}
