package com.msr.service;

import com.msr.pojo.User;

public interface UserService {
    User findByName(String username);

    void register(String username, String password);
}