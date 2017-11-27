package com.fortech.services.impl;


import com.fortech.User;
import com.fortech.repository.UserRepository;
import com.fortech.services.UserService;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(UserService.class)
public class UserServiceImplementation implements UserService {
    @EJB
    private UserRepository repository;

    public String login(String username, String password) {
        System.out.println("called login service");
        String user = repository.find(username, password);
        return user;
    }

    public void register(User user) {
        repository.register(user);
        System.out.println("User");
    }
}
