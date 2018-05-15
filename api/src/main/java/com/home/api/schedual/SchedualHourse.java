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
    NoPagingResponse login(@PathVariable("hourseId") String hourseId);

    @RequestMapping(value = "/api/update",method = RequestMethod.PUT)
    NoPagingResponse update(@RequestBody BaseHourse hourse, @RequestParam("type")String type);

    @RequestMapping(value = "/api/delete/{hourseId}",method = RequestMethod.DELETE)
    NoPagingResponse delete(@PathVariable("hourseId") String hourseId,@RequestParam("userId")String userId);

    @RequestMapping("/api/front/hourses/{type}")
    ApiResponse getAllHourse(@PathVariable("type") String type, PageRequest pageRequest);
}
