import com.fortech.services.LoginService;
import com.sun.faces.action.RequestMapping;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestMapping
public class LoginBean {
    private String name;
    private String password;
    private List<String> countries;

    @EJB
    private LoginService loginService;

    @PostConstruct
    public void test()
    {
        countries = new ArrayList<String>();
        countries.add("Romania,test");
        System.out.println("Post Construct");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {

        return name;
    }

    public String getPassword() {
        return password;
    }


    public String login(String username, String password){
        System.out.println("called login method");

        String user = loginService.login(username, password);

        return "succes";

    }
}