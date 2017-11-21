package com.fortech.services.impl;


import com.fortech.repository.UserRepository;
import com.fortech.services.LoginService;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(LoginService.class)
public class LoginServiceImplementation implements LoginService {
    @EJB
    private UserRepository repository;

    public String login(String username, String password) {
        System.out.println("called login service");
        String user = repository.find(username, password);
        return user;
    }
}
