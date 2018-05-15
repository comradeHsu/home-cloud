package com.home.api.api;

import com.home.api.schedual.SchedualHourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HourseController {

    @Autowired
    SchedualHourse schedualHourse;
}
