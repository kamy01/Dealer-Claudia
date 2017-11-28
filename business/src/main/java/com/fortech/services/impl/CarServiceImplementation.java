package com.fortech.services.impl;

import com.fortech.Car;
import com.fortech.repository.CarRepository;
import com.fortech.services.CarService;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CarServiceImplementation implements CarService {

    @EJB
    private CarRepository repository;

    public void addCar(Car car){
        repository.addCar(car);
        System.out.println("add CarEntity");

    }

}
