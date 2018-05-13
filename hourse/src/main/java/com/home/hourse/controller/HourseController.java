package com.home.hourse.controller;

import com.home.hourse.service.HourseService;
import model.BaseHourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.ApiResponse;
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
        hourse.setType(type);
        hourseService.update(hourse);
        return new NoPagingResponse(200,"success",hourse);
    }

    @RequestMapping(value = "/api/delete/{hourseId}",method = RequestMethod.DELETE)
    public NoPagingResponse delete(@PathVariable String hourseId,String userId){
        BaseHourse hourse = hourseService.findById(hourseId);
        hourse.setIsDeleted("1");
        hourse.setUpdateBy(userId);
        hourseService.update(hourse);
        return new NoPagingResponse(200,"success",hourse);
    }

    @RequestMapping("/api/front/hourses/{type}")
    public ApiResponse getAllHourse(@PathVariable String type,Integer pageSize,Integer pageNumber){
        return new ApiResponse(200,"success",null);
    }
}
