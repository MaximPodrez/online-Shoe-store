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
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author maxim
 */

@ManagedBean(name = "catalog")
@SessionScoped
public class CatalogBean {
    private List<Product> products;
    private Product selectedProduct;
    @ManagedProperty(value = "#{login}")
    LoginBean loginController;

    public LoginBean getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginBean loginController) {
        this.loginController = loginController;
    }
    @EJB
    private CatalogEJB catalogEJB;
     
    @PostConstruct
    public void init() {
        products = catalogEJB.products();
    }
    
    public void addToBasket() throws IOException
    {
        catalogEJB.addToBasket(selectedProduct, loginController.getUsername());
        //catalogEJB.update(selectedProduct, loginController.getUsername());
        FacesContext.getCurrentInstance().getExternalContext().redirect("catalog.xhtml");
    }
    
    public void addToBasket(Product prod) throws IOException
    {
        catalogEJB.addToBasket(prod, loginController.getUsername());
        //catalogEJB.update(selectedProduct, loginController.getUsername());
        FacesContext.getCurrentInstance().getExternalContext().redirect("catalog.xhtml");
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

    
}
