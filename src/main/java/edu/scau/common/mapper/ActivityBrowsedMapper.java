package edu.scau.common.mapper;

import edu.scau.common.dto.IndexActivityStatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @auther:cyf
 * @create:2020/7/3 18:42
 **/
@Mapper
public interface ActivityBrowsedMapper {
    List<IndexActivityStatus> selectActivityBrowsed(Integer userId);
    List<Integer> selectLabels(Integer activityId);

    Integer checkedActivityBrowsed(@Param("userId") Integer userId, @Param("activityId") Integer activityId);
    Integer insertActivityBrowsed(@Param("userId")Integer userId,@Param("activityId")Integer activityId);
}
