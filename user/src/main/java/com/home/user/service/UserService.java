package com.home.user.service;

import com.home.user.model.User;

public interface UserService {

    public User getUser(String username, String password);
}
