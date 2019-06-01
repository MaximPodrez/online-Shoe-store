/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import com.query.UserDataEJB;
import java.io.IOException;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author maxim
 */
@ManagedBean(name = "registration")
@ViewScoped
public class RegistrationBean {
    @ManagedProperty(value = "#{login}")
    LoginBean loginController;
    @EJB
    UserDataEJB query;
    private String username;
    private String password;
    private String password1;
    private String email;
    
    public void registrat() throws IOException
    {
        if(query.registrControl(username, password, password1, email))
        {
            loginController.setUsername(username);
            loginController.setPassword(password);
            loginController.setEmail(email);
            FacesContext.getCurrentInstance().getExternalContext().redirect("mainPaige.xhtml");
        }
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

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    public LoginBean getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginBean loginController) {
        this.loginController = loginController;
    }
}

