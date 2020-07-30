package edu.scau.common.Service;

import edu.scau.common.dto.ActivityAndMessage;
import edu.scau.common.pojo.Activity;

/**
 * @description:
 * @auther:cyf
 * @create:2020/7/3 23:56
 **/
public interface ActivityService {

    Integer InsertActivity(Activity activity);
    ActivityAndMessage selectActivityById(Integer activityId,Integer userId);


}
