package edu.scau.common.Service.impl;

import edu.scau.common.Service.FunctionService;
import edu.scau.common.dto.ActivityManger;
import edu.scau.common.dto.Function;
import edu.scau.common.mapper.FunctionMapper;
import edu.scau.common.pojo.Information;
import edu.scau.common.utils.DateToStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<ActivityManger> activityMangers = functionMapper.getActivity();
        List<ActivityManger> collectedActivity = activityCollectedService.getCollectedActivity(userId);
        for (ActivityManger activityManger : activityMangers) {
            activityManger.setCollected(false);
            for (ActivityManger manger : collectedActivity) {
                if(activityManger.getId()==manger.getId()){
                    activityManger.setCollected(true);
                    break;
                }
            }
        }
        function.setActivityMangers(activityMangers);
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
