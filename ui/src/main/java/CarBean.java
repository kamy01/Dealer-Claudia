import com.fortech.Car;
import com.fortech.services.CarService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.HashMap;
import java.util.Map;

@ManagedBean
@RequestScoped
public class CarBean {
    private Car car =  new Car();
    private Map<String,String> colors;
    private Map<String,String> conditions;
    @EJB
    private CarService carService;

    @PostConstruct
    public void init() {
        colors = new HashMap<String, String>();
        colors.put("red", "red");
        colors.put("black", "black");
        colors.put("blue", "blue");

        conditions = new HashMap<String, String>();
        conditions.put("new", "new");
        conditions.put("used", "used");
    }

    public String addCar(){

        carService.addCar(car);
        //fara ??
        return "addCar?faces-redirect=true";
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Map<String, String> getColors() {
        return colors;
    }

    public void setColors(Map<String, String> colors) {
        this.colors = colors;
    }

    public Map<String, String> getConditions() {
        return conditions;
    }

    public void setConditions(Map<String, String> conditions) {
        this.conditions = conditions;
    }
}
