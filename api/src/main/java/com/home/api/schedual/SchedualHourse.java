package com.home.api.schedual;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;

@FeignClient(value = "hourse")
@Service
public interface SchedualHourse {
}
