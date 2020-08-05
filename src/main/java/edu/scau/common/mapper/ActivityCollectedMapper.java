package edu.scau.common.mapper;

import edu.scau.common.dto.ActivityManger;
import org.apache.ibatis.annotations.Mapper;
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
    Integer addActivity(int userId,int activityId);
    Integer deleteCollectedActivity(@Nullable Integer userId, int activityId);
}
