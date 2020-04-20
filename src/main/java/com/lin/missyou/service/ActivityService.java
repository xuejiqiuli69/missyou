/**
 * @作者 leokkzhang
 * @创建时间 2020/4/20 23:45
 */
package com.lin.missyou.service;

import com.lin.missyou.model.Activity;
import com.lin.missyou.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public Activity getByName(String name){
        return activityRepository.findOneByName(name);
    }
}
