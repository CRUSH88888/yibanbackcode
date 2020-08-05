package edu.scau.common.mapper;

import edu.scau.common.dto.FootPrint;
import edu.scau.common.pojo.Browse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description: 浏览、足迹mapper
 * @author: whj
 * @create: 2020-08-02 16:25
 **/
@Mapper
public interface BrowsedMapper {
    Integer insertBrowsed(Browse browse);
    List<FootPrint> getFootPrint(int userId);
    Integer deleteBrowsed(int activityId);
}
