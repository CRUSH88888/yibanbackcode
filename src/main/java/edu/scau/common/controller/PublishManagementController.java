package edu.scau.common.controller;

import edu.scau.common.Service.impl.PublishManagementServiceImpl;
import edu.scau.common.dto.PublishManagement;
import edu.scau.common.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("/getPublish")
    public ApiResponse getPublish(int userId){
        List<PublishManagement> publish = publishManagementService.getPublish(userId);
        return publish.isEmpty()==true?new ApiResponse(0,"empty"):new ApiResponse(0,"success",publish);
    }
}
