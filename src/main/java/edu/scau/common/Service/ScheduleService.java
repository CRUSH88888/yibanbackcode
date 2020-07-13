package edu.scau.common.Service;

import edu.scau.common.dto.Schedule;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description: 日程表的service
 * @author: whj
 * @create: 2020-07-11 21:20
 **/
public interface ScheduleService {
    List<Schedule> getSchedule(int userId);
}
