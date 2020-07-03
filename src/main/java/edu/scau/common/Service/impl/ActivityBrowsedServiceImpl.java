package edu.scau.common.Service.impl;

import edu.scau.common.Service.ActivityBrowsedService;
import edu.scau.common.dto.IndexActivityStatus;
import edu.scau.common.mapper.ActivityBrowsedMapper;
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
    public List<IndexActivityStatus> selectActivityBrowsed() {
        return activityBrowsedMapper.selectActivityBrowsed();
    }
}
