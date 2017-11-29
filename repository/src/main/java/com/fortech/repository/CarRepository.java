package com.fortech.repository;

import com.fortech.Car;

import java.util.List;

public interface CarRepository {
    void addCar(Car car);
     //List<Car> searchCar();
     List<Car> searchCar(List<String> properties);

}
