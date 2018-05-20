package com.home.api.schedual;

import model.BaseHourse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import util.ApiResponse;
import util.NoPagingResponse;
import util.PageRequest;

@FeignClient(value = "hourse")
@Service
public interface SchedualHourse {

    @RequestMapping(value = "/api/hourse/{hourseId}",method = RequestMethod.GET)
    NoPagingResponse getHourse(@PathVariable("hourseId") String hourseId);

    @RequestMapping(value = "/api/update",method = RequestMethod.PUT)
    NoPagingResponse update(@RequestBody BaseHourse hourse, @RequestParam("type")String type);

    @RequestMapping(value = "/api/delete/{hourseId}",method = RequestMethod.DELETE)
    NoPagingResponse delete(@PathVariable("hourseId") String hourseId,@RequestParam("userId")String userId);

    @RequestMapping(value = "/api/front/hourses/{type}",method = RequestMethod.GET)
    ApiResponse getAllHourse(@PathVariable("type") String type, @RequestParam("pageSize") Integer pageSize, @RequestParam("pageNumber") Integer pageNumbert);
}
