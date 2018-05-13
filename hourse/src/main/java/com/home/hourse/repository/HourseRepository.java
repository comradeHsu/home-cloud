package com.home.hourse.repository;

import com.fasterxml.jackson.databind.ser.Serializers;
import model.BaseHourse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HourseRepository extends MongoRepository<BaseHourse,String> {

    <T extends BaseHourse> List<T> findByCreateByOrIsPublic(Sort sort, String userId, String state);

    <T extends BaseHourse> List<T> findByType(Sort sort,String status);

    <T extends BaseHourse> T findById(String id);

    <T extends BaseHourse> Page<T> findByType(String type, Pageable page);
}
