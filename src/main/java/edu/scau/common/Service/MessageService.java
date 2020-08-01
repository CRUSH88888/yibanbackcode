package edu.scau.common.Service;

import edu.scau.common.pojo.Message;

import java.util.List;

/**
 * @description: 留言
 * @author: whj
 * @create: 2020-07-28 16:42
 **/
public interface MessageService {
    List<Message> getMessages(int userId);
    Integer insertMessage(Message message);
    Message getMessage(int id);
}
