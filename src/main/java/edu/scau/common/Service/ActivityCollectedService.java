package edu.scau.common.Service;

import edu.scau.common.pojo.Activity;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @description:
 * @auther:whj
 * @create:2020/7/10 21:41
 **/
public interface ActivityCollectedService {
    List<Activity> getCollectedActivity(int userId);
    Integer addActivity(int userId,int activityId);
    Integer deleteCollectedActivity(int userId,int activityId);
}
