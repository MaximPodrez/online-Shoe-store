/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import com.entity.Product;
import com.query.CatalogEJB;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author maxim
 */

@ManagedBean(name = "basket")
@SessionScoped
public class BasketBean {
    private List<Product> products;
    private Product selectedProduct;
    @ManagedProperty(value = "#{login}")
    LoginController loginController;
    @EJB
    private CatalogEJB catalogEJB;
     
    @PostConstruct
    public void init() {
        products = catalogEJB.basketProducts(loginController.getUsername());
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
}
