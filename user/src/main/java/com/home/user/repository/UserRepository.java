package com.home.user.repository;


import model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);
}
