package edu.scau.common.controller;

import edu.scau.common.Service.impl.GroupServiceImpl;
import edu.scau.common.pojo.group;
import edu.scau.common.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: 组队controller
 * @author: whj
 * @create: 2020-07-22 20:44
 **/
@RestController
public class GroupController {
    @Autowired
    private GroupServiceImpl groupService;

    /**
     * 添加组队信息
     * @param id
     * @param activityId
     * @param userId
     * @param text
     * @return
     */
    @PostMapping("insertGroups")
    public ApiResponse insertGroups(@RequestParam(value = "activityId") int activityId,
                                    @RequestParam(value = "userId") int userId,
                                    @RequestParam(value = "text") String text) {
        group group = new group(activityId, userId, text);
        Integer result = groupService.insertGroups(group);
        return result>0?new ApiResponse(0,"success"):new ApiResponse(-1,"Server Error");
    }

    /**
     *  获取一个活动的组队信息
     * @param activityId
     * @return
     */
    @GetMapping("getGroups")
    public ApiResponse getGroups(@RequestParam(value = "activityId") int activityId) {
        List<group> groups = groupService.getGroups(activityId);
        return groups.isEmpty()==true?new ApiResponse(0,"empty"):new ApiResponse(0,"success",groups);
    }

}
