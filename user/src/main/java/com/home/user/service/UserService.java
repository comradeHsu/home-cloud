package com.home.user.service;


import model.User;

public interface UserService {

    public User getUser(String username, String password);
}
