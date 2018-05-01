package com.home.user.controller;

import com.home.user.model.User;
import com.home.user.service.UserService;
import com.home.user.util.NoPagingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping(value = "/api/login",method = RequestMethod.GET)
    public NoPagingResponse getUser(String username, String password){
        User userData = service.getUser(username,password);
        if(userData == null){
            return new NoPagingResponse(201,"fail",null);
        }
        return new NoPagingResponse(200,"success",userData);
    }
}
