package edu.scau.common.Service.impl;

import edu.scau.common.Service.ActivityBrowsedService;
import edu.scau.common.dto.IndexActivityStatus;
import edu.scau.common.mapper.ActivityBrowsedMapper;
import edu.scau.common.utils.DateToStringUtil;
import edu.scau.common.utils.LabelTransUtils;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Override
    public List<IndexActivityStatus> selectActivityBrowsed(Integer userId) {
        List<IndexActivityStatus> statuses = activityBrowsedMapper.selectActivityBrowsed(userId);
        for (IndexActivityStatus s:statuses
             ) {
            s.getActivity().setDate(DateToStringUtil.dateToString(s.getActivity().getStartTime(),s.getActivity().getEndTime()));
            s.getActivity().setLabel(LabelTransUtils.integerToString(activityBrowsedMapper.selectLabels(s.getActivity().getId())));
            s.getActivity().setDayToNow(DateToStringUtil.publishTime(s.getActivity().getBuildingTime()));
        }

        return statuses;
    }
}
