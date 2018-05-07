package com.home.hourse.repository;

import model.BaseHourse;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HourseRepository extends MongoRepository<BaseHourse,String> {

    <T extends BaseHourse> List<T> findByCreateByOrIsPublic(Sort sort, String userId, String state);

    <T extends BaseHourse> List<T> findByType(Sort sort,String status);
}
