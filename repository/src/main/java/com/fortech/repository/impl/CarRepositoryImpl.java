package com.fortech.repository.impl;

import com.fortech.Car;
import com.fortech.entities.CarEntity;
import com.fortech.repository.CarRepository;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Stateless
@Remote(CarRepository.class)
public class CarRepositoryImpl implements CarRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
    private EntityManager em = emf.createEntityManager();


    public void addCar(Car car){

        CarEntity entity = new CarEntity();

        entity.setName(car.getName());
        entity.setMark(car.getMark());
        entity.setColor(car.getColor());
        entity.setPrice(car.getPrice());
        entity.setCondition(car.getCondition());
        entity.setRegistrationDate(car.getRegistrationDate());

        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();


    }
}
