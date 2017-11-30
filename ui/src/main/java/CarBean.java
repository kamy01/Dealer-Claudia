import com.fortech.Car;
import com.fortech.SearchCarCriteria;
import com.fortech.services.CarService;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class CarBean {
    private Car car = new Car();
    private List<SelectItem> colors;
    private List<SelectItem> conditions;
    private List<SelectItem> marks;
    private SearchCarCriteria criteria;

    private List<Car> cars;

    @EJB
    private CarService carService;

    @PostConstruct
    public void init() {
        cars = new ArrayList<Car>();
        colors = new ArrayList<SelectItem>();
        colors.add(new SelectItem("red", "red"));
        colors.add(new SelectItem("black", "black"));
        colors.add(new SelectItem("blue", "blue"));

        conditions = new ArrayList<SelectItem>();
        conditions.add(new SelectItem("new", "new"));
        conditions.add(new SelectItem("used", "used"));


        marks = new ArrayList<SelectItem>();
        SelectItemGroup germanCars = new SelectItemGroup("German Cars");
        germanCars.setSelectItems(new SelectItem[]{
                new SelectItem("BMW", "BMW"),
                new SelectItem("Mercedes", "Mercedes"),
                new SelectItem("Volkswagen", "Volkswagen")
        });

        SelectItemGroup americanCars = new SelectItemGroup("American Cars");
        americanCars.setSelectItems(new SelectItem[]{
                new SelectItem("Chrysler", "Chrysler"),
                new SelectItem("GM", "GM"),
                new SelectItem("Ford", "Ford")
        });

        marks.add(germanCars);
        marks.add(americanCars);

        criteria = new SearchCarCriteria();

    }

    public String addCar() {

        carService.addCar(car);
        //fara return ??
        return "addCar?faces-redirect=true";
    }

    public void searchCarAction() {

      cars=  carService.searchCar(criteria);
        System.out.println("search car method bean" +cars.size());

    }

    public void clearAll(){
        RequestContext.getCurrentInstance().reset("searchForm:searchPanel");
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }


    public List<SelectItem> getColors() {
        return colors;
    }

    public void setColors(List<SelectItem> colors) {
        this.colors = colors;
    }

    public List<SelectItem> getConditions() {
        return conditions;
    }

    public void setConditions(List<SelectItem> conditions) {
        this.conditions = conditions;
    }

    public List<SelectItem> getMarks() {
        return marks;
    }

    public void setMarks(List<SelectItem> marks) {
        this.marks = marks;
    }

    public SearchCarCriteria getCriteria() {
        return criteria;
    }

    public List<Car> getCars() {
        System.out.println("search car method get" +cars.size());
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void setCriteria(SearchCarCriteria criteria) {
        this.criteria = criteria;
    }
}
