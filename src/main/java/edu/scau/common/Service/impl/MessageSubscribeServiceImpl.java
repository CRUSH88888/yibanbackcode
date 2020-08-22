package edu.scau.common.Service.impl;

import com.alibaba.fastjson.JSON;
import edu.scau.common.Service.MessageSubscribeService;
import edu.scau.common.dto.MessageData;
import edu.scau.common.dto.MessageSubscribe;
import edu.scau.common.dto.Schedule;
import edu.scau.common.mapper.MessageSubscribeMapper;
import edu.scau.common.mapper.ScheduleMapper;
import edu.scau.common.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: whj
 * @create: 2020-08-18 23:29
 **/
@Service
public class MessageSubscribeServiceImpl implements MessageSubscribeService {
    @Autowired(required = false)
    private MessageSubscribeMapper messageSubscribeMapper;
    @Autowired(required = false)
    private ScheduleMapper scheduleMapper;
    @Override
    public List<String> sendSubscribeMessage() throws Exception {
        List<String> results = new ArrayList<>();
        List<Integer> userIds = messageSubscribeMapper.getUserId();
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        Timestamp afterTimestamp=new Timestamp(System.currentTimeMillis()+86400000);
        for (Integer userId : userIds) {
            if(messageSubscribeMapper.getIsOpen(userId)!=null&&messageSubscribeMapper.getIsOpen(userId)){
                List<Integer> activityId = messageSubscribeMapper.getActivityId(userId);
                List<Schedule> schedule = scheduleMapper.getSchedule(userId);
                if(schedule!=null&&activityId!=null) {
                    for (Integer integer : activityId) {
                        for (Schedule schedule1 : schedule) {
                            if(schedule1.getId()==integer){
                                if(schedule1.getStartTime().after(currentTimestamp)&&schedule1.getStartTime().before(afterTimestamp)){
                                    MessageData messageData = new MessageData();
                                    messageData.setThing2(new MessageData.Thing2(schedule1.getTitle()));
                                    messageData.setThing5(new MessageData.Thing5(schedule1.getDate()));
                                    messageData.setThing6(new MessageData.Thing6(schedule1.getAddress()));
                                    MessageSubscribe messageSubscribe = new MessageSubscribe();
                                    messageSubscribe.setData(messageData);
                                    messageSubscribe.setTemplate_id("8nR52iQ_h-NDdUMLv5R_w40aOXGQgi--uThwLQOF6Qg");
                                    messageSubscribe.setTouser(messageSubscribeMapper.getOpenId(userId));
                                    String s = JSON.toJSONString(messageSubscribe);
                                    String s1 = HttpUtil.doPostJson("https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=" + HttpUtil.getAccessToken(), s);
                                    results.add(s1);
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
        return results;
    }

}
