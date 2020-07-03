package edu.scau.common.Service.impl;

import edu.scau.common.Service.ActivityService;
import edu.scau.common.mapper.ActivityMapper;
import edu.scau.common.pojo.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @auther:cyf
 * @create:2020/7/3 23:56
 **/
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;


    @Override
    public Integer InsertActivity(Activity activity) {
        Integer activityId = activityMapper.insertActivity(activity);
        Integer result = activityMapper.insertLabelOfActivity(activity.getLabel(),activityId);

        return result>0?1:0;
    }
}
