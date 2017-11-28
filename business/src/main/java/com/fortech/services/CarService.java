package com.fortech.services;

import com.fortech.Car;

import javax.ejb.Remote;

@Remote
public interface CarService {
    void addCar(Car car);
}