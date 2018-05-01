package com.home.api.api;

import com.home.api.schedual.NoPagingResponse;
import com.home.api.schedual.SchedualUser;
import com.home.api.schedual.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    SchedualUser schedualUser;

    @RequestMapping(value = "/api/login",method = RequestMethod.GET)
    public NoPagingResponse login(){
        return schedualUser.login("123","123");
    }
}
