package edu.scau.common.controller;

import edu.scau.common.Service.impl.ActivityCollectedServiceImpl;
import edu.scau.common.dto.ActivityManger;
import edu.scau.common.pojo.Activity;
import edu.scau.common.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("/getCollectedActivity")
    public ApiResponse getCollectedActivity(@RequestParam("userId") int userId){
        List<ActivityManger> collectedActivity = activityCollectedService.getCollectedActivity(userId);
        return collectedActivity.isEmpty()==true?new ApiResponse(0,"empty"):new ApiResponse(0,"success",collectedActivity);
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

    /**
     * 收藏活动
     * @param userId
     * @param activityId
     * @return
     */
    @PostMapping("/addActivity")
    public ApiResponse addActivity(@RequestParam("userId") int userId,@RequestParam("activityId") int activityId){
        Integer result = activityCollectedService.addActivity(userId, activityId);
        return result>0?new ApiResponse(0,"success"):new ApiResponse(-1,"Server Error");
    }
}
