package com.home.hourse.service;

import com.home.hourse.repository.HourseRepository;
import model.BaseHourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import util.PageRequest;

import java.util.Date;

@Service
public class HourseServiceImpl implements HourseService {

    @Autowired
    HourseRepository hourseRepository;

    @Override
    public <T extends BaseHourse> T findById(String id) {
        return hourseRepository.findById(id);
    }

    @Override
    public void deleteById(String id,String userId){
        BaseHourse hourse = hourseRepository.findById(id);
        hourse.setIsDeleted("1");
        hourse.setUpdateBy(userId);
        hourseRepository.save(hourse);
    }

    @Override
    public <T extends BaseHourse> void update(T hourse){
        hourse.setUpdateDate(new Date());
        hourseRepository.save(hourse);
    }

    @Override
    public <T extends BaseHourse> void create(T hourse){
        hourseRepository.insert(hourse);
    }

    @Override
    public <T extends BaseHourse> Page<T> findByType(String type, PageRequest pageRequest){
        Sort sort = new Sort(Sort.Direction.DESC,"createDate");
        Pageable page = new org.springframework.data.domain.PageRequest(pageRequest.getPageNumber(),pageRequest.getPageSize(),sort);
        return hourseRepository.findByType(type,page);
    }
}
