package com.home.api.schedual;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user")
@Service
public interface SchedualUser {

    @RequestMapping(value = "/api/login",method = RequestMethod.GET)
    NoPagingResponse login(@RequestParam("username") String username, @RequestParam("password") String password);
}
