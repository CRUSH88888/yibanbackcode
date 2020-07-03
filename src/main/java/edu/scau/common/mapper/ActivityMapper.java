package edu.scau.common.mapper;

import edu.scau.common.pojo.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:与活动有关的mapper
 * @auther:cyf
 * @create:2020/7/3 23:31
 **/
@Mapper
public interface ActivityMapper {

    Integer insertActivity(Activity activity);
    Integer insertLabelOfActivity(@Param("label") List<String >label,@Param("activity_id") Integer activity_id);


}
