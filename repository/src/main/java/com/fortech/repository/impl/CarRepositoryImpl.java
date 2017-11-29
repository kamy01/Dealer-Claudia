package com.fortech.repository.impl;

import com.fortech.Car;
import com.fortech.entities.CarEntity;
import com.fortech.repository.CarRepository;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

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
        entity.setRegistrationDate(new java.sql.Date(car.getRegistrationDate().getTime()));

        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();

    }


    public List<Car> searchCar(Car car){

        System.out.println("search car method");

        List<CarEntity> carEntities = new ArrayList<CarEntity>();

        Query query = em.createNamedQuery("car.searchCar");

        query.setParameter("pMark", car.getMark());
        query.setParameter("pColor", car.getColor());
        query.setParameter("pCondition", car.getCondition());

        carEntities = (List<CarEntity>) query.getResultList();

        if(carEntities == null){
           System.out.println(" cars not found in db");
           return null;
        }

        List<Car> searchResult = new ArrayList<Car>();

        //mapare metoda primeste CarEntity returneaza Car
        for (CarEntity entity :carEntities) {

            Car c = new Car();
            c.setMark(entity.getMark());
            c.setColor(entity.getColor());
            c.setCondition(entity.getCondition());

            c.setName(entity.getName());
            c.setPrice(entity.getPrice());
            c.setRegistrationDate(entity.getRegistrationDate());

            searchResult.add(c);
        }

        return searchResult;

    }
}
