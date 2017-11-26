package com.fortech.repository.impl;

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
        UserEntity user = new UserEntity();

        Query query = em.createQuery("Select usr FROM user usr WHERE usr.name = :prm1", UserEntity.class);
        query.setParameter("prm1",username);
        user =(UserEntity) query.getSingleResult();

        if(user== null)
        {
            return "";
        }
        return user.getName();
    }
}
