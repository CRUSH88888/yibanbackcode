package edu.scau.common.Service.impl;

import edu.scau.common.Service.ActivityCollectedService;
import edu.scau.common.dto.ActivityManger;
import edu.scau.common.mapper.ActivityCollectedMapper;
import edu.scau.common.pojo.Activity;
import edu.scau.common.utils.DateToStringUtil;
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
    @Autowired(required = false)
    private ActivityCollectedMapper activityCollectedMapper;

    @Override
    public List<ActivityManger> getCollectedActivity(int userId) {
        List<ActivityManger> collectedActivity = activityCollectedMapper.getCollectedActivity(userId);
        for (ActivityManger activityManger : collectedActivity) {
            activityManger.setDate(DateToStringUtil.publishTime(activityManger.getBuildTime()));
        }
        return collectedActivity;
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
