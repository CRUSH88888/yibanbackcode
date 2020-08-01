package edu.scau.common.controller;

import edu.scau.common.Service.InformationService;
import edu.scau.common.Service.impl.InformationServiceImpl;
import edu.scau.common.pojo.Information;
import edu.scau.common.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: whj
 * @create: 2020-08-01 23:20
 **/
@RestController
public class InformationController {
    @Autowired
    private InformationServiceImpl informationService;
    /**
     * 获取所有消息
     * @param userId
     * @return
     */
    @GetMapping("/getInformations")
    public ApiResponse getInformations(@RequestParam("userId") int userId){
        List<Information> information = informationService.getInformation(userId);
        return information.isEmpty()==true?new ApiResponse(0,"empty"):new ApiResponse(0,"success",information);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/getInformation")
    public ApiResponse getInformation(@RequestParam("id") int id){
        Information informationById = informationService.getInformationById(id);
        return informationById==null?new ApiResponse(0,"empty"):new ApiResponse(0,"success",informationById);
    }
}
