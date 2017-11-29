package com.fortech.repository.impl;

import com.fortech.User;
import com.fortech.entities.UserEntity;
import com.fortech.repository.UserRepository;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
@Remote(UserRepository.class)

public class UserRepositoryImpl implements UserRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
    private EntityManager em = emf.createEntityManager();

    public String find(String username, String password) {
        System.out.println("in find method");

        UserEntity user = new UserEntity();

        Query query = em.createNamedQuery("user.findUser");
        query.setParameter("prm1", username);
        user =(UserEntity) query.getSingleResult();

        if(user== null){return "";}

        return user.getUsername();
    }


    public void register(User user){
        System.out.println("in register method");

        UserEntity entity = new UserEntity();
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());
        entity.setEmail(user.getEmail());
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }
}
