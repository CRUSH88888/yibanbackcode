package edu.scau.common.Service;

import edu.scau.common.pojo.group;

import java.util.List;

/**
 * @description: 组队信息
 * @author: whj
 * @create: 2020-07-18 21:57
 **/
public interface GroupService {
    Integer insertGroups(group group);
    List<group> getGroups(int activityId);
    group getGroup(int id);
}
