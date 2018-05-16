package com.home.hourse.service;

import model.BaseHourse;
import org.springframework.data.domain.Page;
import util.PageRequest;

public interface HourseService {

    <T extends BaseHourse> T findById(String id);

    void deleteById(String id,String userId);

    <T extends BaseHourse> void update(T hourse);

    <T extends BaseHourse> void create(T hourse);

    <T extends BaseHourse> Page<T> findByType(String type, PageRequest pageRequest);

    <T extends BaseHourse> Page<T> findByUser(String userId, String title,PageRequest pageRequest);
}
