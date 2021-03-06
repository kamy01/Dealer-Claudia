import com.fortech.User;
import com.fortech.services.UserService;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class UserBean {

    private String username;
    private String password;

    private User user = new User();

    @EJB
    private UserService userService;

    public String login(){
        System.out.println("called login method");

        String userDB = userService.login(username, password);

        if (!userDB.isEmpty()){
            return "home.xhtml?faces-redirect=true";
        }
        else {
            FacesContext context= FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Wrong username/password"));
            context.getExternalContext().getFlash().setKeepMessages(true);
            return "login?faces-redirect=true";
        }

    }

    public String register(){
        System.out.println("called register method");
        userService.register(user);
        return "login?faces-redirect=true";
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {return username; }

    public String getPassword() {
        return password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}