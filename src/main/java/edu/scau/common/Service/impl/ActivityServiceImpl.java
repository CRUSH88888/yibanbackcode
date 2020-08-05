package edu.scau.common.Service.impl;

import edu.scau.common.Service.ActivityService;
import edu.scau.common.dto.ActivityAndMessage;
import edu.scau.common.mapper.ActivityBrowsedMapper;
import edu.scau.common.mapper.ActivityMapper;
import edu.scau.common.pojo.Activity;
import edu.scau.common.pojo.ActivityPicture;
import edu.scau.common.pojo.Label;
import edu.scau.common.pojo.Message;
import edu.scau.common.utils.DateToStringUtil;
import edu.scau.common.utils.LabelTransUtils;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Integer activityId = activityMapper.insertActivity(activity);
        List<ActivityPicture> pictures = activity.getPicUrl();
        for (ActivityPicture a: pictures
             ) {
            activityMapper.insertActivityPicture(a.getPicUrl(),activityId);
        }
        List<String> labels = activity.getLabel();
        List<Integer> integerLabel = LabelTransUtils.StringToInteger(labels);
        Integer result  = 0;
        for (Integer i:integerLabel
             ) {

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

        activity.setLabel(LabelTransUtils.integerToString(labels));

        activityAndMessage.getActivity().setDate(DateToStringUtil.dateToString(activityAndMessage.getActivity().getStartTime(), activityAndMessage.getActivity().getEndTime()));
        List<Message> messages = activityMapper.selectMessage(activityId,userId);
        activityAndMessage.setMessage(messages);



        return activityAndMessage;
    }
}
