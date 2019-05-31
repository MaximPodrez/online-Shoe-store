/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import com.query.DataQuery;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author maxim
 */
@ManagedBean(name = "login")
@SessionScoped
public class LoginController implements Serializable {

    private String username;
    private String password;
    private String password1;
    private String email;
    @EJB
    private DataQuery query=new DataQuery();
    
    public void loginControl() throws IOException
    {
        if(query.loginControl(username, password))
        {
            email = query.email(username);
            FacesContext.getCurrentInstance().getExternalContext().redirect("mainPaige.xhtml");
        }
    }
    
    public void registrat() throws IOException
    {
        if(query.registrControl(username, password, password1, email))
            FacesContext.getCurrentInstance().getExternalContext().redirect("profile.xhtml");
    }
    
    public String eml()
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

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword1() {
        return password1;
    }

    public String getEmail() {
        return email;
    }
}
