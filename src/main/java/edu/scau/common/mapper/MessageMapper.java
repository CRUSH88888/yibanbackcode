package edu.scau.common.mapper;

import edu.scau.common.pojo.Message;

import java.util.List;

/**
 * @description:
 * @author: whj
 * @create: 2020-07-24 22:19
 **/
public interface MessageMapper {
    List<Message> getMessage(int activityId);
    Integer insertMessage(Message message);
}
