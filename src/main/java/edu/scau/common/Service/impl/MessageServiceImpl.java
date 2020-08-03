package edu.scau.common.Service.impl;

import edu.scau.common.Service.MessageService;
import edu.scau.common.mapper.MessageMapper;
import edu.scau.common.pojo.Message;
import edu.scau.common.utils.DateToStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * @description:
 * @author: whj
 * @create: 2020-07-28 16:47
 **/
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired(required = false)
    private MessageMapper messageMapper;
    @Override
    public List<Message> getMessages(int userId) {
        List<Message> messages = messageMapper.getMessages(userId);
        for (Message message : messages) {
            message.setDate(DateToStringUtil.publishTime(message.getPublishTime()));
        }
        return messages;
    }

    @Override
    @Transactional
    public Integer insertMessage(Message message) {
        List<Integer> userId = messageMapper.getUserId(message.getActivityId());
        Integer result=0;
        for (Integer integer : userId) {
            message.setUserId(integer);
            message.setBrowsed(false);
            message.setPublishTime(new Timestamp(System.currentTimeMillis()));
            result = messageMapper.insertMessage(message);
        }
        return result;
    }

}
