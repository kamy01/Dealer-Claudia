package com.fortech.repository;

import com.fortech.Car;
import com.fortech.SearchCarCriteria;

import java.util.List;

public interface CarRepository {
    void addCar(Car car);
     List<Car> searchCar(SearchCarCriteria criteria);

}
