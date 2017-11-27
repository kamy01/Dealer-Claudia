package com.fortech.repository;

import com.fortech.User;

public interface UserRepository {
    public String find(String username, String password);
    public void register(User user);
}
