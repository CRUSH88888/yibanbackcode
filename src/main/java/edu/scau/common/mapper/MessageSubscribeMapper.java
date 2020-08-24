package edu.scau.common.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description: 消息订阅mapper
 * @author: whj
 * @create: 2020-08-18 22:58
 **/
@Mapper
public interface MessageSubscribeMapper {
    List<Integer> getUserId();
    String getOpenId(int userId);
    Boolean getIsOpen(int userId);
    Integer getId(int userId);
    Integer insertOpenId(@Param("userId")int userId,@Param("openId")String openId);
    Integer updateOpen(@Param("userId")int userId);
    List<Integer> getActivityId(@Param("userId")int userId);//授权的活动
    Integer insertMessageSubscribeAllow(@Param("userId")int userId,@Param("activityId")int activityId);
    Integer getMessageSubscribeAllowId(@Param("userId")int userId,@Param("activityId")int activityId);
    Integer deleteMessageSubscribeAllow(@Param("userId")int userId,@Param("activityId")int activityId);
}
