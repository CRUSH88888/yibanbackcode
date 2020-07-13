package edu.scau.common.mapper;

import edu.scau.common.dto.Schedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description: 日程表的mapper
 * @author: whj
 * @create: 2020-07-11 20:37
 **/
@Mapper
public interface ScheduleMapper {
    List<Schedule> getSchedule(int userId);
}
