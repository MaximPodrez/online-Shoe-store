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
    LoginController loginController;
    @EJB
    ProfileEJB profile;
    private String newUsername;
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
        profile.changeEmail(loginController.getUsername(), newPassword);
        loginController.setPassword(newPassword);
        FacesContext.getCurrentInstance().getExternalContext().redirect("profile.xhtml");
    }
    
    public void changeEmail() throws IOException
    {
        profile.changeUsername(loginController.getUsername(), newEmail);
        loginController.setUsername(newEmail);
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

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
}

