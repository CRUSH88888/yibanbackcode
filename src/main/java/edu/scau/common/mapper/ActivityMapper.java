package edu.scau.common.mapper;

import edu.scau.common.dto.ActivityAndMessage;
import edu.scau.common.pojo.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;
import java.util.Map;

/**
 * @description:与活动有关的mapper
 * @auther:cyf
 * @create:2020/7/3 23:31
 **/
@Mapper
public interface ActivityMapper extends MySqlMapper<Activity> {

    Integer insertActivity(Activity activity);
    Integer insertLabelOfActivity(@Param("label") Integer label,@Param("activityId") Integer activityId);

    ActivityAndMessage selectActivityById(@Param("activityId") Integer activityId,@Param("userId") Integer userId);

}
