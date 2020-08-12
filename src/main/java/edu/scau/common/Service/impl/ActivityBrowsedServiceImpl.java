package edu.scau.common.Service.impl;

import edu.scau.common.Service.ActivityBrowsedService;
import edu.scau.common.dto.IndexActivityStatus;
import edu.scau.common.mapper.ActivityBrowsedMapper;
import edu.scau.common.mapper.ActivityMapper;
import edu.scau.common.pojo.ActivityPicture;
import edu.scau.common.utils.DateToStringUtil;
import edu.scau.common.utils.LabelTransUtils;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @description:
 * @auther:cyf
 * @create:2020/7/3 22:06
 **/
@Service
public class ActivityBrowsedServiceImpl implements ActivityBrowsedService {
    @Autowired
    private ActivityBrowsedMapper activityBrowsedMapper;
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public List<IndexActivityStatus> selectActivityBrowsed(Integer userId) {
        List<IndexActivityStatus> statuses = activityBrowsedMapper.selectActivityBrowsed(userId);

        for (IndexActivityStatus s:statuses
             ) {
            List<ActivityPicture> pictures =activityMapper.selectPicture(s.getActivity().getId());
            s.getActivity().setPicUrl(pictures);
            s.getActivity().setDate(DateToStringUtil.dateToString(Timestamp.valueOf(s.getActivity().getStartTime()),Timestamp.valueOf(s.getActivity().getEndTime())));
            s.getActivity().setLabel(LabelTransUtils.integerToString(activityBrowsedMapper.selectLabels(s.getActivity().getId())));
            s.getActivity().setDayToNow(DateToStringUtil.publishTime(s.getActivity().getBuildingTime()));
        }

        return statuses;
    }

    @Override
    public Integer insertActivityBrowsed(Integer userId, Integer activityId) {
        Integer result = 0;
        result = activityBrowsedMapper.checkedActivityBrowsed(userId,activityId);
        if (result == null){
            activityBrowsedMapper.insertActivityBrowsed(userId,activityId);
        }
        return 1;
    }


}
