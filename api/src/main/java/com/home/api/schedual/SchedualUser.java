package com.home.api.schedual;

import model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import util.ApiResponse;
import util.NoPagingResponse;

@FeignClient(value = "user")
@Service
public interface SchedualUser {

    @RequestMapping(value = "/api/login",method = RequestMethod.GET)
    NoPagingResponse login(@RequestParam("username") String username, @RequestParam("password") String password);

    @RequestMapping(value = "/api/account",method = RequestMethod.POST)
    NoPagingResponse register(@RequestBody User user);

    @RequestMapping(value = "/api/deleteUser/{userId}",method = RequestMethod.DELETE)
    NoPagingResponse deleteUser(@PathVariable("userId") String userId);

    @RequestMapping(value = "/api/account",method = RequestMethod.GET)
    ApiResponse getAllUser(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageNumber") Integer pageNumber);
}
