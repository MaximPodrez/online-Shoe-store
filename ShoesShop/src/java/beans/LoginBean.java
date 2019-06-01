/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import com.query.UserDataEJB;
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
public class LoginBean implements Serializable {

    private String username;
    private String password;
    private String email;
    @EJB
    private UserDataEJB query=new UserDataEJB();
    
    public void loginControl() throws IOException
    {
        if(query.loginControl(username, password))
        {
            email = query.email(username);
            FacesContext.getCurrentInstance().getExternalContext().redirect("mainPaige.xhtml");
        }
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
