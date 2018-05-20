package com.home.api.api;

import com.home.api.schedual.SchedualHourse;
import model.BaseHourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.ApiResponse;
import util.NoPagingResponse;
import util.PageRequest;

@RestController
public class HourseController {

    @Autowired
    SchedualHourse schedualHourse;

    @RequestMapping("/api/hourse/{hourseId}")
    public NoPagingResponse getHourse(@PathVariable String hourseId){
        return schedualHourse.getHourse(hourseId);
    }

    @RequestMapping(value = "/api/update",method = RequestMethod.PUT)
    public NoPagingResponse update(@RequestBody BaseHourse hourse, String type){
        return schedualHourse.update(hourse,type);
    }

    @RequestMapping(value = "/api/delete/{hourseId}",method = RequestMethod.DELETE)
    public NoPagingResponse delete(@PathVariable("hourseId") String hourseId,@RequestParam("userId")String userId){
        return schedualHourse.delete(hourseId,userId);
    }

    @RequestMapping(value = "/api/front/hourses/{type}",method = RequestMethod.GET)
    ApiResponse getAllHourse(@PathVariable("type") String type, PageRequest page){
        return schedualHourse.getAllHourse(type,page.getPageSize(),page.getPageNumber());
    }
}
