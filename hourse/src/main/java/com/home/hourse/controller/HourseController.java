package com.home.hourse.controller;

import com.home.hourse.service.HourseService;
import model.BaseHourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.NoPagingResponse;

@RestController
public class HourseController {

    @Autowired
    HourseService hourseService;

    @RequestMapping("/api/hourse/{hourseId}")
    public NoPagingResponse getHourse(@PathVariable String hourseId){
        NoPagingResponse response = null;
        BaseHourse hourse = hourseService.findById(hourseId);
        if(hourse == null){
            response = new NoPagingResponse(201,"fail",null);
        } else {
            response = new NoPagingResponse(200,"success",hourse);
        }
        return response;
    }
}
