package com.home.user.controller;

import com.home.user.service.UserService;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import util.NoPagingResponse;

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

    @RequestMapping(value = "/api/account",method = RequestMethod.POST)
    public NoPagingResponse addUser(User user){
        if(user.getType() == null || (user.getType() != 1 && user.getType() != 0)){
            return new NoPagingResponse(202,"error","未指定用户类型");
        }
        User userOld = service.getUser(user.getUsername());
        if(userOld != null){
            return new NoPagingResponse(201,"fail","账号已存在");
        }
        User userNew = service.insert(user);
        return new NoPagingResponse(200,"success",userNew);
    }

    @RequestMapping(value = "/api/deleteUser/{userId}",method = RequestMethod.DELETE)
    public NoPagingResponse deleteUser(@PathVariable String userId){
        service.deleteById(userId);
        return new NoPagingResponse(200,"success",null);
    }
}
