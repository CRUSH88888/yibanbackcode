package edu.scau.common.Service.impl;

import edu.scau.common.Service.ActivityService;
import edu.scau.common.dto.ActivityAndMessage;
import edu.scau.common.mapper.ActivityBrowsedMapper;
import edu.scau.common.mapper.ActivityMapper;
import edu.scau.common.pojo.Activity;
import edu.scau.common.pojo.Label;
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

        List<Integer> labels= activityBrowsedMapper.selectLabels(activityId);
        ActivityAndMessage activityAndMessage = activityMapper.selectActivityById(activityId,userId);
        activityAndMessage.getActivity().setLabel(LabelTransUtils.integerToString(labels));
        return activityAndMessage;
    }
}
