package edu.scau.common.Service.impl;

import edu.scau.common.Service.ScheduleService;
import edu.scau.common.dto.Schedule;
import edu.scau.common.mapper.ScheduleMapper;
import edu.scau.common.utils.DateToStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.sql.Timestamp;
import java.util.ArrayList;
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
        List<Schedule> schedule = scheduleMapper.getSchedule(userId);
        List<Schedule> schedules = new ArrayList<>();
        for (Schedule schedule1 : schedule) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            if(schedule1.getStartTime().after(timestamp)||schedule1.equals(timestamp)){
                String date= DateToStringUtil.dateToString(schedule1.getStartTime(),schedule1.getEndTime());
                if(timestamp.getYear()==schedule1.getStartTime().getYear()&&timestamp.getMonth()==schedule1.getStartTime().getMonth()&&timestamp.getDate()==schedule1.getStartTime().getDate()){
                    date=date+"(今天)";
                }
                schedule1.setDate(date);
                schedules.add(schedule1);
            }
        }
        return schedules;
    }
}
