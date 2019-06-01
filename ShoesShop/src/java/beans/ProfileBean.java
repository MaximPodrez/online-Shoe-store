/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import com.query.ProfileEJB;
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
@ManagedBean(name = "profile")
@ViewScoped
public class ProfileBean {
    @ManagedProperty(value = "#{login}")
    LoginBean loginController;
    @EJB
    ProfileEJB profile;
    private String newUsername;
    private String lastPassword;
    private String newPassword;
    private String newEmail;
    
    public void changeUsername() throws IOException
    {
        profile.changeUsername(loginController.getUsername(), newUsername);
        loginController.setUsername(newUsername);
        FacesContext.getCurrentInstance().getExternalContext().redirect("profile.xhtml");
    }
    
    public void changePassword() throws IOException
    {
        if(profile.changePassword(loginController.getUsername(), lastPassword, newPassword))
        {
            loginController.setPassword(newPassword);
            FacesContext.getCurrentInstance().getExternalContext().redirect("profile.xhtml");
        }
    }
    
    public void changeEmail() throws IOException
    {
        profile.changeEmail(loginController.getUsername(), newEmail);
        loginController.setEmail(newEmail);
        FacesContext.getCurrentInstance().getExternalContext().redirect("profile.xhtml");
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getLastPassword() {
        return lastPassword;
    }

    public void setLastPassword(String lastPassword) {
        this.lastPassword = lastPassword;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public LoginBean getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginBean loginController) {
        this.loginController = loginController;
    }
}

