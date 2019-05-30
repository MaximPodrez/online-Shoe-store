/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import com.entity.Comment;
import com.query.CommentEJB;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author maxim
 */
@ManagedBean(name = "comment")
@ViewScoped
public class CommentBean {
    private String comment;
    private List<Comment> comments;
    @ManagedProperty(value = "#{login}")
    LoginController loginController;
    @EJB
    private CommentEJB commentEJB;
     
    @PostConstruct
    public void init() {
        comments = commentEJB.comments(loginController.getUsername());
    }
    
    public void addComment() throws IOException
    {
        if(comment.equals(""))
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Please, write something!"));
        else
        {   
            commentEJB.add(comment, loginController.getUsername());
            FacesContext.getCurrentInstance().getExternalContext().redirect("review.xhtml");
        }
    }
    
    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    
    
}
