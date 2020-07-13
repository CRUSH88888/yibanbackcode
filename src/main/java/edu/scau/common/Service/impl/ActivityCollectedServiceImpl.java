package edu.scau.common.Service.impl;

import edu.scau.common.Service.ActivityCollectedService;
import edu.scau.common.mapper.ActivityCollectedMapper;
import edu.scau.common.pojo.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @description:
 * @auther:whj
 * @create:2020/7/10 21:41
 **/
@Service
public class ActivityCollectedServiceImpl implements ActivityCollectedService {
    @Autowired
    private ActivityCollectedMapper activityCollectedMapper;

    @Override
    public List<Activity> getCollectedActivity(int userId) {
        return activityCollectedMapper.getCollectedActivity(userId);
    }

    @Override
    public Integer addActivity(int userId, int activityId) {
        int result = activityCollectedMapper.addActivity(userId, activityId);
        return result>0?1:0;
    }

    @Override
    public Integer deleteCollectedActivity(int userId, int activityId) {
        int result = activityCollectedMapper.deleteCollectedActivity(userId, activityId);
        return result>0?1:0;
    }
}
