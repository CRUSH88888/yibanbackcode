package edu.scau.common.Service.impl;

import edu.scau.common.Service.ActivityCollectedService;
import edu.scau.common.dto.ActivityManger;
import edu.scau.common.dto.MessageSubscribe;
import edu.scau.common.dto.Schedule;
import edu.scau.common.mapper.ActivityCollectedMapper;
import edu.scau.common.mapper.MessageSubscribeMapper;
import edu.scau.common.pojo.Activity;
import edu.scau.common.utils.DateToStringUtil;
import edu.scau.common.utils.ListMerge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
/**
 * @description:
 * @auther:whj
 * @create:2020/7/10 21:41
 **/
@Service
public class ActivityCollectedServiceImpl implements ActivityCollectedService {
    @Autowired(required = false)
    private ActivityCollectedMapper activityCollectedMapper;
    @Autowired(required = false)
    private MessageSubscribeMapper messageSubscribeMapper;
    @Override
    public List<ActivityManger> getCollectedActivity(int userId) {
        List<ActivityManger> collectedActivity = activityCollectedMapper.getCollectedActivity(userId);
        List<ActivityManger> certificate = activityCollectedMapper.getCertificate(userId);
        for (ActivityManger activityManger : collectedActivity) {
            activityManger.setType(1);
        }
        for (ActivityManger activityManger : certificate) {
            activityManger.setType(2);
        }
        List<ActivityManger> activityMangers = ListMerge.listMerge2(collectedActivity, certificate);
        for (ActivityManger activityManger : activityMangers) {
            activityManger.setDate(DateToStringUtil.publishTime(activityManger.getBuildTime()));
        }
        return activityMangers;
    }

    @Override
    @Transactional
    public MessageSubscribe addActivity(int userId, int activityId) {
        Integer result=1;
        if(activityCollectedMapper.getACollectedActivity(userId,activityId)==null)
        result = activityCollectedMapper.addActivity(userId, activityId);
        MessageSubscribe messageSubscribe = messageSubscribeMapper.getMessageSubscribe(userId);
        MessageSubscribe activity = messageSubscribeMapper.getActivity(activityId);
        activity.setIsOpen(messageSubscribe.getIsOpen());
        activity.setOpenId(messageSubscribe.getOpenId());
        activity.setDate(DateToStringUtil.dateToString(activity.getStartTime(),activity.getEndTime()));
        activity.setClockTime(activity.getStartTime().getTime()-(new Timestamp(System.currentTimeMillis()).getTime())-3600000);
        if(activity!=null&&result>0){
            return activity;
        }
        return null;
    }

    @Override
    @Transactional
    public Integer deleteCollectedActivity(int userId, int activityId) {
        Integer result = activityCollectedMapper.deleteCollectedActivity(userId, activityId);
        result+= messageSubscribeMapper.deleteClockId(userId, activityId);
        return result==2?1:0;
    }
}
