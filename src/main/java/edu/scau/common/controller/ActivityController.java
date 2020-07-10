package edu.scau.common.controller;

import edu.scau.common.Service.ActivityService;
import edu.scau.common.pojo.Activity;
import edu.scau.common.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @auther:cyf
 * @create:2020/7/3 23:59
 **/
@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;


    /**保存活动
     * 这个接口写完了，但是因为tomcat的配置问题不能用，等cyf修改
     * @param title
     * @param text
     * @param userId
     * @param startTime
     * @param endTime
     * @param label
     * @return
     */
    @PostMapping("/saveActivity")
    public ApiResponse saveActivity(@RequestParam("title") String title,
                                    @RequestParam("text") String text,
                                    @RequestParam("userId") Integer userId,
                                    @RequestParam("startTime")Date startTime,
                                    @RequestParam("endTime")Date endTime,
                                    @RequestParam("label[]")String[] label){
        List<String> labelList = new ArrayList<>();
        Collections.addAll(labelList,label);
        Activity activity = new Activity(title,text,userId, new java.sql.Date(startTime.getTime()), new java.sql.Date(endTime.getTime()),labelList);
        Integer result = activityService.InsertActivity(activity);
        return result>0?new ApiResponse(0,"success"):new ApiResponse(-1,"Server Error");
    }



}
