package edu.scau.common.Service.impl;

import edu.scau.common.Service.FunctionService;
import edu.scau.common.dto.ActivityManger;
import edu.scau.common.dto.Function;
import edu.scau.common.dto.Schedule;
import edu.scau.common.mapper.FunctionMapper;
import edu.scau.common.pojo.Information;
import edu.scau.common.utils.DateToStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: whj
 * @create: 2020-08-01 21:38
 **/
@Service
public class FunctionServiceImpl implements FunctionService {
    @Autowired
    private PublishManagementServiceImpl publishManagementService;
    @Autowired
    private MessageServiceImpl messageService;
    @Autowired(required = false)
    private FunctionMapper functionMapper;
    @Autowired
    private ActivityCollectedServiceImpl activityCollectedService;
    @Override
    public Function getFunction(int userId) {
        Function function = new Function();
        List<Schedule> scheduleList = functionMapper.getActivity();
        ArrayList<Schedule> schedules = new ArrayList<>();
        for (Schedule schedule : scheduleList) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            if(schedule.getStartTime().after(timestamp)||schedule.equals(timestamp)){
                if(functionMapper.getCollected(userId,schedule.getId())!=null){
                    schedule.setCollected(true);
                }
                String date= DateToStringUtil.dateToString(schedule.getStartTime(),schedule.getEndTime());
                schedule.setDate(date);
                schedules.add(schedule);
            }
        }
        function.setSchedules(schedules);
        List<Information> information = functionMapper.getInformation(userId);
        for (Information information1 : information) {
            information1.setDate(DateToStringUtil.publishTime(information1.getPublishTime()));
        }
        function.setInformation(information);
        function.setMessages(messageService.getMessages(userId));
        function.setPublishManagements(publishManagementService.getPublish(userId));
        return function;
    }
}
