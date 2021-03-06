/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import com.entity.Product;
import com.query.CatalogEJB;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author maxim
 */

@ManagedBean(name = "basket")
@ViewScoped
public class BasketBean {
    private List<Product> products;
    private Product selectedProduct;
    @ManagedProperty(value = "#{login}")
    LoginBean loginController;
    @EJB
    private CatalogEJB catalogEJB;
     
    @PostConstruct
    public void init() {
        products = catalogEJB.basketProducts(loginController.getUsername());
    }
    
    public void delete() throws IOException
    {
        catalogEJB.delete(selectedProduct, loginController.getUsername());
        //products = catalogEJB.basketProducts(loginController.getUsername());
        FacesContext.getCurrentInstance().getExternalContext().redirect("basket.xhtml");
    }
    
    public void delete(Product product) throws IOException
    {
        catalogEJB.delete(product, loginController.getUsername());
        //products = catalogEJB.basketProducts(loginController.getUsername());
        FacesContext.getCurrentInstance().getExternalContext().redirect("basket.xhtml");
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

    public LoginBean getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginBean loginController) {
        this.loginController = loginController;
    }
}
