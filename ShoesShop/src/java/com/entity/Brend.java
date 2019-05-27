/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "brend")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Brend.findAll", query = "SELECT b FROM Brend b"),
    @NamedQuery(name = "Brend.findByName", query = "SELECT b FROM Brend b WHERE b.name = :name"),
    @NamedQuery(name = "Brend.findByCountry", query = "SELECT b FROM Brend b WHERE b.country = :country"),
    @NamedQuery(name = "Brend.findByPhoto", query = "SELECT b FROM Brend b WHERE b.photo = :photo"),
    @NamedQuery(name = "Brend.findByIdBrend", query = "SELECT b FROM Brend b WHERE b.idBrend = :idBrend")})
public class Brend implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "country")
    private String country;
    @Size(max = 45)
    @Column(name = "photo")
    private String photo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_brend")
    private Integer idBrend;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brend")
    private Collection<Product> productCollection;

    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    public Brend() {
    }

    public Brend(Integer idBrend) {
        this.idBrend = idBrend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getIdBrend() {
        return idBrend;
    }

    public void setIdBrend(Integer idBrend) {
        this.idBrend = idBrend;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBrend != null ? idBrend.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Brend)) {
            return false;
        }
        Brend other = (Brend) object;
        if ((this.idBrend == null && other.idBrend != null) || (this.idBrend != null && !this.idBrend.equals(other.idBrend))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Brend[ idBrend=" + idBrend + " ]";
    }
    
}
