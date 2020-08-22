package edu.scau.common.Service;

import edu.scau.common.dto.ActivityManger;

import java.util.List;
/**
 * @description:
 * @auther:whj
 * @create:2020/7/10 21:41
 **/
public interface ActivityCollectedService {
    List<ActivityManger> getCollectedActivity(int userId);
    Integer addActivity(int userId, int activityId);
    Integer deleteCollectedActivity(int userId,int activityId);
}
