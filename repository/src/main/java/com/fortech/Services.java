package com.fortech;

import com.fortech.entities.UserEntity;

import javax.persistence.*;

public class Services {
    @PersistenceContext
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();


    public UserEntity addUser(String name, String password){
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setPassword(password);

        tx.begin();
        em.persist(user);
        tx.commit();
        return user;
    }


    public void removeUser( String username){
        UserEntity user = em.find(UserEntity.class, username);
        if(user!=null){
            tx.begin();
            em.remove(user);
            tx.commit();
        }
    }


    public UserEntity findUser( String username){
        return em.find(UserEntity.class, username);
    }



    public UserEntity updateUser(String name, String password){

        UserEntity result = findUser(name);
        result.setName(name);
        result.setPassword(password);

        return result;
    }










    /*

    public UserEntity findUserOld(String username) {

        String query = "SELECT u from user u where u.username = "+username;
        TypedQuery<UserEntity> typedQuery = em.createQuery(query, UserEntity.class);
        //List<UserEntity> results = typedQuery.getResultList();
        UserEntity result = typedQuery.getSingleResult();
        return result;

    }


    public void deleteUser(String name){

        String query = "delete from user u where u.username = name";
        em.createQuery(query).executeUpdate();
        //TypedQuery<UserEntity> typedQuery = em.createQuery(query, UserEntity.class);
        //List<UserEntity> results = typedQuery.getResultList();
        //return results;

    }
    */


}
