/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import com.query.MainPaigeEJB;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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
    LoginBean loginController;
    private List<String> images;
    @EJB
    MainPaigeEJB mainPage;
    
    @PostConstruct
    public void init() {
        images = mainPage.images();
    }
    
    public String validateName(String name)
    {
        return name.substring(0, name.indexOf("."));
    }
 
    public List<String> getImages() {
        return images;
    }
    
    public void logOut() throws IOException
    {
        loginController.setUsername(null);
        loginController.setPassword(null);
        FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
    }

    public LoginBean getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginBean loginController) {
        this.loginController = loginController;
    }
}
