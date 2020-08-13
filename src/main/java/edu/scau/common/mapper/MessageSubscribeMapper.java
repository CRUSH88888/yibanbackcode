package edu.scau.common.mapper;

import edu.scau.common.dto.MessageSubscribe;
import edu.scau.common.dto.Schedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description: 消息订阅
 * @author: whj
 * @create: 2020-08-12 20:29
 **/
@Mapper
public interface MessageSubscribeMapper {
    MessageSubscribe getMessageSubscribe(@Param("userId") int userId);
    MessageSubscribe getActivity(@Param("activityId")int activityId);
    Integer addClockId(@Param("userId") int userId,
                       @Param("activityId") int activityId,
                       @Param("clockId") String clockId);
    Integer updateClock(@Param("userId") int userId,
                        @Param("activityId") int activityId,
                        @Param("clockId") String clockId);
    Integer insertOpenId(@Param("userId") int userId,
                         @Param("openId")String openId);
    Integer updateOpen(@Param("userId") int userId);
    Integer deleteClockId(@Param("userId") int userId,
                          @Param("activityId") int activityId);
    String getClockId(@Param("userId") int userId,
                      @Param("activityId") int activityId);
}
