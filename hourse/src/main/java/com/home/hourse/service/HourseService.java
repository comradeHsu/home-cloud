package com.home.hourse.service;

import model.BaseHourse;

public interface HourseService {

    <T extends BaseHourse> T findById(String id);

    void deleteById(String id,String userId);

    <T extends BaseHourse> void update(T hourse);

    <T extends BaseHourse> void create(T hourse);
}
