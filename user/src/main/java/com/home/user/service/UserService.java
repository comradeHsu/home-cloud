package com.home.user.service;


import model.User;

public interface UserService {

    public User getUser(String username, String password);

    public User getUser(String username);

    public User insert(User user);

    public void deleteById(String userId);
}
