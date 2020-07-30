package edu.scau.common.Service.impl;

import edu.scau.common.Service.GroupService;
import edu.scau.common.mapper.GroupMapper;
import edu.scau.common.pojo.group;
import edu.scau.common.utils.DateToStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @description:
 * @author: whj
 * @create: 2020-07-18 21:58
 **/
@Service
public class GroupServiceImpl implements GroupService {
    @Autowired(required = false)
    private GroupMapper groupMapper;
    @Override
    public Integer insertGroups(group group) {
        group.setPublishTime(new Timestamp(System.currentTimeMillis()));
        return groupMapper.insertGroups(group);
    }

    @Override
    public List<group> getGroups(int activityId) {
        List<group> groups = groupMapper.getGroups(activityId);
        for (group group : groups) {
            group.setDate(DateToStringUtil.publishTime(group.getPublishTime()));
        }
        return groups;
    }

    @Override
    public group getGroup(int id) {
        group group = groupMapper.getGroup(id);
        group.setDate(DateToStringUtil.publishTime(group.getPublishTime()));
        return group;
    }
}
