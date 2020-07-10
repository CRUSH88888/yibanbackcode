package edu.scau.common.controller;

import edu.scau.common.Service.impl.ActivityCollectedServiceImpl;
import edu.scau.common.pojo.Activity;
import edu.scau.common.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @description:活动收藏接口
 * @auther:whj
 * @create:2020/7/10 21:42
 **/
@RestController
public class ActivityCollectedController {
    @Autowired
    private ActivityCollectedServiceImpl activityCollectedService;

    /**
     *查询收藏的活动
     * @param userId
     * @return
     */
    @PostMapping("/getCollectedActivity")
    public ApiResponse getCollectedActivity(@RequestParam("userId") int userId){
        List<Activity> collectedActivity = activityCollectedService.getCollectedActivity(userId);
        return collectedActivity.isEmpty()==true?new ApiResponse(0,"empty"):new ApiResponse(0,"success",activityCollectedService);
    }

    /**
     * 取消收藏活动
     * @param userId
     * @param activityId
     * @return
     */
    @PostMapping("/getCollectedActivity/deleteCollectedActivity")
    public ApiResponse deleteCollectedActivity(@RequestParam("userId") int userId,@RequestParam("activityId") int activityId){
        Integer result = activityCollectedService.deleteCollectedActivity(userId, activityId);
        return result>0?new ApiResponse(0,"success"):new ApiResponse(-1,"Delete Error");
    }
}
