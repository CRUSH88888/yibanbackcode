package edu.scau.common.controller;

import edu.scau.common.Service.ActivityCertificateService;
import edu.scau.common.pojo.ActivityCertificate;
import edu.scau.common.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @auther:cyf
 * @create:2020/8/9 21:37
 **/
@RestController
@RequestMapping("/certificate")
public class ActivityCertificateController {
    @Autowired
    private ActivityCertificateService activityCertificateService;

    @PostMapping("saveActivityCertificate")
    public ApiResponse saveActivityCertificate(@RequestParam("activityTitle")String activityTitle,
                                               @RequestParam("activityContent")String activityContent,
                                               @RequestParam("userId")Integer userId,
                                               @RequestParam("fileUrl")String[] fileUrl,
                                               @RequestParam("label")String[] label){
        List<String> files = new ArrayList<>();
        List<String> labels = new ArrayList<>();
        for (String s:fileUrl
             ) {
            files.add(s);
        }
        for (String s:label
             ) {
            labels.add(s);
        }

        ActivityCertificate certificate = new ActivityCertificate(activityTitle,activityContent,files,labels,userId);
        activityCertificateService.save(certificate);
        return new  ApiResponse(0,"success");
    }

    /**
     * 别想改，给爷死
     * @param activityTitle
     * @param activityContent
     * @param fileUrl
     * @param label
     * @return
     */
    @PostMapping("updateCertificate")
    public ApiResponse updateCertificate(@RequestParam("activityTitle")String activityTitle,
                                         @RequestParam("activityContent")String activityContent,
                                         @RequestParam("fileUrl")String[] fileUrl,
                                         @RequestParam("label")String[] label){
        List<String> files = new ArrayList<>();
        List<String> labels = new ArrayList<>();
        for (String s:fileUrl
        ) {
            files.add(s);
        }
        for (String s:label
        ) {
            labels.add(s);
        }

        ActivityCertificate certificate = new ActivityCertificate(activityTitle,activityContent,files,labels);

        return null;
    }
//    collectedCertificate
    @PostMapping("/{path}")
    public ApiResponse collectedCertificate(@PathVariable("path") String path,
                                            @RequestParam("userId")Integer userId,
                                            @RequestParam("certificateId")Integer certificateId){

        if ("collectedCertificate".equals(path)) {
            return new ApiResponse(activityCertificateService.collectedCertificate(userId, certificateId), "look result");
        }else if ("deleteCertificate".equals(path)){
            return new ApiResponse(activityCertificateService.deleteCollectedCertificate(userId,certificateId),"look the return code");
        }else {
            return new ApiResponse(-1,"路径错误");
        }

        }



}
