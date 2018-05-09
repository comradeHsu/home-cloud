package com.home.hourse.controller;

import com.home.hourse.service.HourseService;
import model.BaseHourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.NoPagingResponse;

import java.util.Date;

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

    @RequestMapping(value = "/api/update",method = RequestMethod.PUT)
    public NoPagingResponse update(@RequestBody BaseHourse hourse,String type){
        hourseService.update(hourse,type);
        return new NoPagingResponse(200,"success",hourse);
    }
}
