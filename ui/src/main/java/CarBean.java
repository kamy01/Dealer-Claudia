import com.fortech.Car;
import com.fortech.services.CarService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CarBean {
    private Car car =  new Car();

    @EJB
    private CarService carService;

    public void addCar(){
        carService.addCar(car);
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
