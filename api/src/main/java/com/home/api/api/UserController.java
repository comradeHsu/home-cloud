package com.home.api.api;

import com.home.api.schedual.SchedualUser;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.NoPagingResponse;

@RestController
public class UserController {

    @Autowired
    SchedualUser schedualUser;

    @RequestMapping(value = "/api/login",method = RequestMethod.POST)
    public NoPagingResponse login(@RequestBody User user){
        return schedualUser.login(user.getUsername(),user.getPassword());
    }

    @RequestMapping(value = "/api/account",method = RequestMethod.POST)
    public NoPagingResponse register(@RequestBody User user){
        return schedualUser.register(user);
    }

    @RequestMapping(value = "/api/deleteUser/{userId}",method = RequestMethod.DELETE)
    public NoPagingResponse deleteUser(@PathVariable String userId){
        return schedualUser.deleteUser(userId);
    }
}
