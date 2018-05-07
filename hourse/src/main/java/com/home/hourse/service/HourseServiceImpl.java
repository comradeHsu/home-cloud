package com.home.hourse.service;

import com.home.hourse.repository.HourseRepository;
import model.BaseHourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public <T extends BaseHourse> void update(T hourse,String type){
        hourse.setUpdateDate(new Date());
        hourse.setType(type);
        hourseRepository.save(hourse);
    }
}
