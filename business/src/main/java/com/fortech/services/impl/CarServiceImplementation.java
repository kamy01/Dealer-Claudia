package com.fortech.services.impl;

import com.fortech.Car;
import com.fortech.SearchCarCriteria;
import com.fortech.repository.CarRepository;
import com.fortech.services.CarService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CarServiceImplementation implements CarService {

    @EJB
    private CarRepository repository;

    public void addCar(Car car){
        repository.addCar(car);
        System.out.println("add new car");

    }

    public List<Car> searchCar(SearchCarCriteria criteria){



        System.out.println("search a car");

        return  repository.searchCar(criteria);
    }

}
