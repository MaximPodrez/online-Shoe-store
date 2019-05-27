/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import com.query.DataQuery;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author maxim
 */
@ManagedBean(name = "login")
@SessionScoped
public class LoginController implements Serializable {

    private String username;
    private String password;
    @EJB
    private DataQuery query=new DataQuery();
    
    public String loginControl()
    {
        if(query.loginControl(username, password))
            return "mainPaige.xhtml?faces-redirect=true";
        return "wrongLogin.xhtml?faces-redirect=true";
    }
    
    public String email()
    {
        return query.email(username);
    }
    
    public String registration()
    {
        return "registration.xhtml?faces-redirect=true";
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
    
}
