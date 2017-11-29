package com.fortech.services.impl;

import com.fortech.Car;
import com.fortech.repository.CarRepository;
import com.fortech.services.CarService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CarServiceImplementation implements CarService {

    @EJB
    private CarRepository repository;

    public void addCar(Car car){
        repository.addCar(car);
        System.out.println("add new car");

    }

    public List<Car> searchCar(List<String> properties){
        repository.searchCar(properties);
        System.out.println("search a car");

        //return
    }

}
