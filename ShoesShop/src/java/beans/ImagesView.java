/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import com.query.MainPaigeEJB;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author maxim
 */
@ManagedBean
@SessionScoped
public class ImagesView {
    private List<String> images;
    @EJB
    MainPaigeEJB mainPage;
    
    @PostConstruct
    public void init() {
        images = mainPage.images();
    }
 
    public List<String> getImages() {
        return images;
    }
}
