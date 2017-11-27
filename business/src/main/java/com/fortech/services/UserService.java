package com.fortech.services;

import com.fortech.User;

public interface UserService {
    String login(String username, String password);
    void register(User user);
}
