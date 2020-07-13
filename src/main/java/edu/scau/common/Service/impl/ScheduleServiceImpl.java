package edu.scau.common.Service.impl;

import edu.scau.common.Service.ScheduleService;
import edu.scau.common.dto.Schedule;
import edu.scau.common.mapper.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.List;

/**
 * @description:
 * @author: whj
 * @create: 2020-07-11 21:31
 **/
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired(required = false)
    private ScheduleMapper scheduleMapper;

    @Override
    public List<Schedule> getSchedule(int userId) {
        return scheduleMapper.getSchedule(userId);
    }
}
