package com.fortech.services;

import com.fortech.Car;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface CarService {
    void addCar(Car car);
    //List<Car> searchCar(Car car);
    List<Car> searchCar(List<String> properties);
}