package edu.scau.common.mapper;

import edu.scau.common.pojo.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description:
 * @author: whj
 * @create: 2020-07-24 22:19
 **/
@Mapper
public interface MessageMapper {
    List<Message> getMessages(int userId);
    Integer insertMessage(Message message);
    List<Integer> getUserId(int activityId);
}
