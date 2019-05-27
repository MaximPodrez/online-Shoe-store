/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author maxim
 */

@ManagedBean(name = "mainPaige")
@SessionScoped
public class MainPaigeBean {
    @ManagedProperty(value = "#{login}")
    LoginController loginController;
    
    public void logOut() throws IOException
    {
        loginController.setUsername(null);
        loginController.setPassword(null);
        FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
}
