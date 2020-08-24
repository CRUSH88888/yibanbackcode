package edu.scau.common.Service.impl;

import edu.scau.common.Service.ActivityService;
import edu.scau.common.dto.ActivityAndMessage;
import edu.scau.common.mapper.ActivityBrowsedMapper;
import edu.scau.common.mapper.ActivityMapper;
import edu.scau.common.mapper.BrowsedMapper;
import edu.scau.common.mapper.MessageMapper;
import edu.scau.common.pojo.*;
import edu.scau.common.utils.DateToStringUtil;
import edu.scau.common.utils.LabelTransUtils;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @auther:cyf
 * @create:2020/7/3 23:56
 **/
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private ActivityBrowsedMapper activityBrowsedMapper;
    @Autowired
    private BrowsedMapper browsedMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Data
    @NoArgsConstructor
    public class temp{
        private String label;
        private Integer activityId;

        public temp(String label, Integer activityId) {
            this.label = label;
            this.activityId = activityId;
        }
    }


    @Override
    public Integer InsertActivity(Activity activity) {
         activityMapper.insertActivity(activity);
        Integer activityId = activity.getId();
        System.out.println(activityId);
        List<ActivityPicture> pictures = activity.getPicUrl();
        for (ActivityPicture a: pictures
             ) {
            System.out.println(a);
            activityMapper.insertActivityPicture(a.getPicUrl(),activityId);
        }
        List<String> labels = activity.getLabel();
        for (String s:labels
             ) {
            System.out.println("labels: "+s);
        }
        List<Integer> integerLabel = LabelTransUtils.StringToInteger(labels);
        Integer result  = 0;
        for (Integer i:integerLabel
             ) {
            System.out.println(i);
             result += activityMapper.insertLabelOfActivity(i,activityId);

        }
        return result==labels.size()?1:0;



    }

    @Override
    public ActivityAndMessage selectActivityById(Integer activityId,Integer userId) {

        List<ActivityPicture> pictures = activityMapper.selectPicture(activityId);
        List<Integer> labels= activityBrowsedMapper.selectLabels(activityId);
        Integer collectedResult = activityMapper.checkCollectedByActivityIdAndUserId(activityId,userId);
        ActivityAndMessage activityAndMessage = new ActivityAndMessage();
        System.out.println(collectedResult);

        Activity activity = activityMapper.selectActivityById(activityId);
        activityAndMessage.setActivity(activity);
        if (collectedResult != null){
            activityAndMessage.getActivity().setCollected(true);
        }
//        activityAndMessage.getActivity().setCollected(false);
        activityAndMessage.getActivity().setPicUrl(pictures);
        browsedMapper.insertBrowsed(new Browse(activityId,userId,new Timestamp(System.currentTimeMillis())));
        activity.setLabel(LabelTransUtils.integerToString(labels));
        activityAndMessage.getActivity().setDate(DateToStringUtil.dateToString(Timestamp.valueOf(activityAndMessage.getActivity().getStartTime()), Timestamp.valueOf(activityAndMessage.getActivity().getEndTime())));
        List<Message> messages = activityMapper.selectMessage(activityId,userId);
        activityAndMessage.setMessage(messages);
        messageMapper.updateMessage(activityId,userId);


        return activityAndMessage;
    }
}
