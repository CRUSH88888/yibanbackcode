package edu.scau.common.mapper;

import edu.scau.common.dto.ActivityAndMessage;
import edu.scau.common.pojo.Activity;
import edu.scau.common.pojo.ActivityPicture;
import edu.scau.common.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

    Activity selectActivityById(@Param("activityId") Integer activityId);

//    @Select("select message from activity_message where activity_id = #{activityId} and user_id = #{userId}")
    List<Message> selectMessage(@Param("activityId") Integer activityId, @Param("userId") Integer userId);
    List<ActivityPicture> selectPicture(@Param("activityId") Integer activityId);
    Integer insertActivityPicture(@Param("picUrl") String pictures,@Param("activityId") Integer activityId);

    Integer checkCollectedByActivityIdAndUserId(@Param("activityId") Integer activityId, @Param("userId") Integer userId);
}
