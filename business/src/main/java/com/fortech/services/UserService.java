package com.fortech.services;

import com.fortech.User;

import javax.ejb.Remote;

@Remote
public interface UserService {
    String login(String username, String password);
    void register(User user);
}
