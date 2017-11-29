package com.fortech.services;

import com.fortech.Car;
import com.fortech.SearchCarCriteria;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface CarService {
    void addCar(Car car);
    List<Car> searchCar(SearchCarCriteria criteria);
}