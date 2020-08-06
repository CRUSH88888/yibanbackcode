package edu.scau.common.mapper;

import edu.scau.common.dto.ActivityManger;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;
/**
 * @description:活动收藏的mapper
 * @auther:whj
 * @create:2020/7/10/21:40
 **/
@Mapper
public interface ActivityCollectedMapper {
    List<ActivityManger> getCollectedActivity(int userId);
    Integer getACollectedActivity(@Param("userId") int userId, @Param("activityId")int activityId );
    Integer addActivity(@Param("userId") int userId, @Param("activityId")int activityId);
    Integer deleteCollectedActivity(@Param("userId")@Nullable Integer userId, @Param("activityId")int activityId);
}
