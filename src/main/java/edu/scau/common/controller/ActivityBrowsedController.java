package edu.scau.common.controller;

import edu.scau.common.Service.ActivityBrowsedService;
import edu.scau.common.dto.IndexActivityStatus;
import edu.scau.common.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:首页的活动接口
 * @auther:cyf
 * @create:2020/7/3 22:07
 **/
@RestController
@RequestMapping("index")
public class ActivityBrowsedController {
    @Autowired
    private ActivityBrowsedService activityBrowsedService;

    /**
     * 首页的活动接口
     * @return
     */
    @GetMapping("/activity")
    public ApiResponse queryIndexActivity(@RequestParam("userId")Integer userId){
        List<IndexActivityStatus> activityStatuses = activityBrowsedService.selectActivityBrowsed(userId);
        return activityStatuses==null?new ApiResponse(-1,"Server Error"):new ApiResponse(0,"success",activityStatuses);

    }

}
