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
import java.util.ArrayList;
import java.util.Iterator;
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
    public Integer insertActivityBrowsed(Integer userId, Integer activityId) {
        ArrayList result = new ArrayList();
        result.add(Integer.valueOf(-1));
        List var6 = this.activityBrowsedMapper.checkedActivityBrowsed(userId, activityId);
        Iterator i = var6.iterator();

        while(i.hasNext()) {
            Integer i1 = (Integer)i.next();
            System.out.println(i1);
        }

        System.out.println("size " + var6.size());
        if(var6.size() == 0) {
            this.activityBrowsedMapper.insertActivityBrowsed(userId, activityId);
            System.out.println("1");
        } else if(var6.size() >= 1) {
            System.out.println("2");
            System.out.println(new Timestamp(System.currentTimeMillis()));

            for(int var7 = 1; var7 < var6.size(); ++var7) {
                System.out.println("delete: " + var6.get(var7));
                activityBrowsedMapper.deleteActivityBrowsed((Integer)var6.get(var7));
            }

           activityBrowsedMapper.updateActivityBrowsed(userId, activityId, new Timestamp(System.currentTimeMillis()));
        }

        return Integer.valueOf(1);
    }
}
