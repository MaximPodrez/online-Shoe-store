/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author maxim
 */
@Entity
@Table(name = "login")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Login.control", query = "SELECT l FROM Login l WHERE l.username= :username and l.password = :password"),
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),
    @NamedQuery(name = "Login.findByUsername", query = "SELECT l FROM Login l WHERE l.username = :username"),
    @NamedQuery(name = "Login.findByPassword", query = "SELECT l FROM Login l WHERE l.password = :password")})
public class Login implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "username")
    private String username;
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "login", orphanRemoval = true)
    private List<Orderok> orderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "login", orphanRemoval = true)
    private List<Comment> commentCollection;

    public Login() {
    }

    public Login(String username) {
        this.username = username;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Orderok> getOrderCollection() {
        return orderCollection;
    }

    public void setOrderCollection(List<Orderok> orderCollection) {
        this.orderCollection = orderCollection;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(List<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }
    
    

//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 53 * hash + Objects.hashCode(this.username);
//        hash = 53 * hash + Objects.hashCode(this.password);
//        hash = 53 * hash + Objects.hashCode(this.orderCollection);
//        return hash;
//    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Login other = (Login) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.orderCollection, other.orderCollection)) {
            return false;
        }
        return Objects.equals(this.commentCollection, other.commentCollection);
    }

    @Override
    public String toString() {
        return "Login{" + "username=" + username + ", email=" + email + ", password=" + password + ", orderCollection=" + orderCollection + ", commentCollection=" + commentCollection + '}';
    }
}
