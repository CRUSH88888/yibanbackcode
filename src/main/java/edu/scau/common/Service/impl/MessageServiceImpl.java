package edu.scau.common.Service.impl;

import edu.scau.common.Service.MessageService;
import edu.scau.common.mapper.MessageMapper;
import edu.scau.common.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return messageMapper.getMessages(userId);
    }

    @Override
    @Transactional
    public Integer insertMessage(Message message) {
        List<Integer> userId = messageMapper.getUserId(message.getActivityId());
        Integer result=0;
        for (Integer integer : userId) {
            message.setUserId(integer);
            message.setBrowsed(false);
            result = messageMapper.insertMessage(message);
        }
        return result;
    }

    @Override
    @Transactional
    public Message getMessage(int id) {
        Message message = messageMapper.getMessage(id);
        if(!message.getBrowsed()){
            messageMapper.updateMessage(id);
        }
        return message;
    }
}
