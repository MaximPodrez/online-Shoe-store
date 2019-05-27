/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @NamedQuery(name = "Product.findByIdProduct", query = "SELECT p FROM Product p WHERE p.idProduct = :idProduct"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name = "Product.findBySeason", query = "SELECT p FROM Product p WHERE p.season = :season"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price"),
    @NamedQuery(name = "Product.findByPhoto", query = "SELECT p FROM Product p WHERE p.photo = :photo")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "sizze")
    private Integer sizzze;
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
    @JoinColumn(name = "id_brend", referencedColumnName = "id_brend")
    @ManyToOne(optional = false)
    private Brend brend;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Orderok> orderCollection;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;

    public Product() {
    }

    public Product(Integer sizzze, String name, String season, Integer price, String photo, Brend brend, List<Orderok> orderCollection, int idProduct) {
        this.sizzze = sizzze;
        this.name = name;
        this.season = season;
        this.price = price;
        this.photo = photo;
        this.brend = brend;
        this.orderCollection = orderCollection;
        this.idProduct = idProduct;
    }

    public Integer getSizzze() {
        return sizzze;
    }

    public void setSizzze(Integer sizzze) {
        this.sizzze = sizzze;
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

    public Brend getBrend() {
        return brend;
    }

    public void setBrend(Brend brend) {
        this.brend = brend;
    }

    public List<Orderok> getOrderCollection() {
        return orderCollection;
    }

    public void setOrderCollection(List<Orderok> orderCollection) {
        this.orderCollection = orderCollection;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    //@Override
    //public int hashCode() {
    //    int hash = 3;
    //    hash = 53 * hash + Objects.hashCode(this.sizzze);
    //    hash = 53 * hash + Objects.hashCode(this.name);
    //    hash = 53 * hash + Objects.hashCode(this.season);
    //    hash = 53 * hash + Objects.hashCode(this.price);
    //    hash = 53 * hash + Objects.hashCode(this.photo);
    //    hash = 53 * hash + Objects.hashCode(this.brend);
    //    hash = 53 * hash + Objects.hashCode(this.orderCollection);
    //    hash = 53 * hash + this.idProduct;
    //    return hash;
    //}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.sizzze, other.sizzze)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.season, other.season)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.photo, other.photo)) {
            return false;
        }
        if (!Objects.equals(this.brend, other.brend)) {
            return false;
        }
        if (!Objects.equals(this.orderCollection, other.orderCollection)) {
            return false;
        }
        if (this.idProduct != other.idProduct) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "sizzze=" + sizzze + ", name=" + name + ", season=" + season + ", price=" + price + ", photo=" + photo + ", brend=" + brend + ", orderCollection=" + orderCollection + ", idProduct=" + idProduct + '}';
    }
    

    

    

     
}
