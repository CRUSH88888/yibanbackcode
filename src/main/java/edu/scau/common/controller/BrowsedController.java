package edu.scau.common.controller;

import edu.scau.common.Service.impl.BrowsedServiceImpl;
import edu.scau.common.dto.ActivityManger;
import edu.scau.common.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: whj
 * @create: 2020-08-02 17:11
 **/
@RestController
public class BrowsedController {
    @Autowired
    private BrowsedServiceImpl browsedService;
    @GetMapping("getBrowsed")
    public ApiResponse getBrowsed(@RequestParam("userId")int userId){
        List<ActivityManger> footPrint = browsedService.getFootPrint(userId);
        return footPrint.isEmpty()==true?new ApiResponse(0,"empty"):new ApiResponse(0,"success",footPrint);
    }
}
