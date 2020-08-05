package edu.scau.common.controller;

import edu.scau.common.Service.impl.FunctionServiceImpl;
import edu.scau.common.dto.Function;
import edu.scau.common.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 功能页面的controller
 * @author: whj
 * @create: 2020-08-01 22:42
 **/
@RestController
public class FunctionController {
    @Autowired
    private FunctionServiceImpl functionService;

    /**
     * 获取功能页面：近期活动，消息中心，留言，发布管理
     * @param userId
     * @return
     */
    @GetMapping("/getFunction")
    public ApiResponse getFunction(@RequestParam("userId") int userId){
        Function function = functionService.getFunction(userId);
        return function==null?new ApiResponse(0,"empty"):new ApiResponse(0,"success",function);
    }
}
