package edu.scau.common.mapper;

import edu.scau.common.pojo.group;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description: 组队
 * @author: whj
 * @create: 2020-07-18 21:23
 **/
@Mapper
public interface GroupMapper {
    Integer insertGroups(group group);
    List<group> getGroups(int activityId);
    group getGroup(int id);
}
