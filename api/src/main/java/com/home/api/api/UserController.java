package com.home.api.api;

import com.home.api.schedual.SchedualUser;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import util.NoPagingResponse;

@RestController
public class UserController {

    @Autowired
    SchedualUser schedualUser;

    @RequestMapping(value = "/api/login",method = RequestMethod.POST)
    public NoPagingResponse login(@RequestBody User user){
        return schedualUser.login(user.getUsername(),user.getPassword());
    }
}
