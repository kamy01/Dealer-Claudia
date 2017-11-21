package com.fortech.repository.impl;

import com.fortech.entities.UserEntity;
import com.fortech.repository.UserRepository;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Remote(UserRepository.class)
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext(name="myPU")
    EntityManager em;

    public String find(String username, String password) {
        UserEntity user = new UserEntity();

        Query query = em.createQuery("Select usr FROM USERENTITY usr WHERE usr.name = :prm1", UserEntity.class);
        query.setParameter("prm1",username);
        user =(UserEntity) query.getSingleResult();

        if(user== null)
        {
            return "";
        }
        return user.getName();
    }
}
