import com.fortech.Car;
import com.fortech.services.CarService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagedBean
@RequestScoped
public class CarBean {
    private Car car =  new Car();
    private Map<String,String> colors;
    private Map<String,String> conditions;
    private List<SelectItem> marks;
    private List<String> selectedMarks;
    private List<String> selectedColors;
    private List<String> selectedConditions;

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

        marks = new ArrayList<SelectItem>();
        SelectItemGroup germanCars = new SelectItemGroup("German Cars");
        germanCars.setSelectItems(new SelectItem[] {
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

    }

    public String addCar(){

        carService.addCar(car);
        //fara return ??
        return "addCar?faces-redirect=true";
    }

    public void searchCarAction() {

        //carService.searchCar();

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

    public List<SelectItem> getMarks() {
        return marks;
    }

    public void setMarks(List<SelectItem> marks) {
        this.marks = marks;
    }

    public CarService getCarService() {
        return carService;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;

    }
    public String[] getSelectedMarks() {
        return selectedMarks;
    }

    public void setSelectedMarks(String[] selectedMarks) {
        this.selectedMarks = selectedMarks;
    }

    public String[] getSelectedColors() {
        return selectedColors;
    }

    public void setSelectedColors(String[] selectedColors) {
        this.selectedColors = selectedColors;
    }

    public String[] getSelectedConditions() {
        return selectedConditions;
    }

    public void setSelectedConditions(String[] selectedConditions) {
        this.selectedConditions = selectedConditions;
    }
}
