package edu.scau.common.controller;

import edu.scau.common.Service.impl.ScheduleServiceImpl;
import edu.scau.common.dto.Schedule;
import edu.scau.common.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: whj
 * @create: 2020-07-11 21:35
 **/
@RestController
public class ScheduleController {
    @Autowired
    private ScheduleServiceImpl scheduleService;
    /**
     * 获取日程表
     * @param userId
     * @return
     */
    @GetMapping("/getSchedule")
    public ApiResponse getSchedule(@RequestParam("userId") int userId){
        List<Schedule> schedule = scheduleService.getSchedule(userId);
        return schedule.isEmpty()==true?new ApiResponse(0,"empty"):new ApiResponse(0,"success",schedule);
    }
}
