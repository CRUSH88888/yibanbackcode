package edu.scau.common.controller;

import edu.scau.common.Service.impl.PublishManagementServiceImpl;
import edu.scau.common.dto.ActivityManger;
import edu.scau.common.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: 发布管理
 * @author: whj
 * @create: 2020-07-17 16:28
 **/
@RestController
public class PublishManagementController {
    @Autowired
    private PublishManagementServiceImpl publishManagementService;

    /**
     *获得发布的活动或组队信息
     * @param userId
     * @return
     */
    @GetMapping("/getPublish")
    public ApiResponse getPublish(@RequestParam("userId") int userId){
        List<ActivityManger> publish = publishManagementService.getPublish(userId);
        return publish.isEmpty()==true?new ApiResponse(0,"empty"):new ApiResponse(0,"success",publish);
    }

    /**
     *
     * @param id
     * @param type
     * @return
     */
    @GetMapping("/deletePublish")
    public ApiResponse deletePublish(@RequestParam(value = "id") int[] id,
                                     @RequestParam(value = "type") int[] type){
        Integer result=publishManagementService.deletePublish(id,type);
        return result>0?new ApiResponse(0,"success"):new ApiResponse(-1,"Delete Error");
    }
}
