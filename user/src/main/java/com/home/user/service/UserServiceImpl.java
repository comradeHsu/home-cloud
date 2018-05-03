package com.home.user.service;


import com.home.user.repository.UserRepository;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User insert(User user) {
        return userRepository.insert(user);
    }

    @Override
    public void deleteById(String userId) {
        userRepository.delete(userId);
    }
}
