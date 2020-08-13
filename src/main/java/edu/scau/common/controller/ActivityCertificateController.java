package edu.scau.common.controller;

import edu.scau.common.Service.ActivityBrowsedService;
import edu.scau.common.Service.ActivityCertificateService;
import edu.scau.common.Service.BrowsedService;
import edu.scau.common.Service.impl.BrowsedServiceImpl;
import edu.scau.common.dto.IndexActivityCertificate;
import edu.scau.common.pojo.ActivityCertificate;
import edu.scau.common.utils.ApiResponse;
import edu.scau.common.utils.LabelTransUtils;
import edu.scau.common.utils.PageUtil;
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
    @Autowired
    private BrowsedService browsedService;
    @Autowired
    private ActivityBrowsedService activityBrowsedService;

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

        List<String> labelString = LabelTransUtils.StringToString(labels);

        ActivityCertificate certificate = new ActivityCertificate(activityTitle,activityContent,files,labelString,userId);
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


    /**
     * 点击详情浏览
     * @param userId
     * @param certificateId
     * @return
     */
        @PostMapping("/browsedCertificate")
        public ApiResponse browsedCertificate( @RequestParam("userId")Integer userId,
                                               @RequestParam(value = "activityId",required = false,defaultValue = "-1") int activityId,
                                               @RequestParam(value = "certificateId",required = false,defaultValue = "-1") int certificateId){
            Integer result = 0;
            System.out.println(activityId  + certificateId);
            if (activityId != -1){
                result = activityBrowsedService.insertActivityBrowsed(userId,activityId);

            }
            else if (certificateId != -1){
                result = activityCertificateService.insertCertificateBrowsed(certificateId,userId);
            }
            if (result == 2){
                return new ApiResponse(0,"已经浏览过");
            }
            return result>0?new ApiResponse(0,"success"):new ApiResponse(-1,"Server Error");
        }

        @PostMapping("/getIndexCertificate")
        public ApiResponse getIndexCertificate(@RequestParam("userId")Integer userId){
            List<IndexActivityCertificate> indexActivityCertificates =
                    activityCertificateService.get(userId);
            return indexActivityCertificates != null ? new ApiResponse(0,"success",indexActivityCertificates):new ApiResponse(-1,"Server Error");
        }
        @PostMapping("/getCertificateById")
        public ApiResponse getCertificateById(@RequestParam("userId")Integer userId,
                                              @RequestParam("certificateId")Integer certificateId){

            return new ApiResponse(0,"success",activityCertificateService.selectCertificateById(certificateId,userId)) ;

        }
        @PostMapping("/getCollectedCertificate")
    public ApiResponse getCollectedCertificate(@RequestParam("userId")Integer userId){
            List<ActivityCertificate> certificates = activityCertificateService.selectCollectedCertificate(userId);
            return certificates != null ? new ApiResponse(0,"success",certificates):new ApiResponse(-1,"failed");
        }



}
