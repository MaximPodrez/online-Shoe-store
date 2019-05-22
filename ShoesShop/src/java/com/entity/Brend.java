/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "Brend.findByPhoto", query = "SELECT b FROM Brend b WHERE b.photo = :photo")})
public class Brend implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "country")
    private String country;
    @Size(max = 45)
    @Column(name = "photo")
    private String photo;

    public Brend() {
    }

    public Brend(String name) {
        this.name = name;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Brend)) {
            return false;
        }
        Brend other = (Brend) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Brend[ name=" + name + " ]";
    }
    
}
