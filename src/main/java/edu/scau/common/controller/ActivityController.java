package edu.scau.common.controller;

import edu.scau.common.Service.ActivityService;
import edu.scau.common.pojo.Activity;
import edu.scau.common.utils.ApiResponse;
import edu.scau.common.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
     * 这里的保存图片只需要调用FileUtil的保存文件，返回文件在服务器上的路径
     * @param title
     * @param text
     * @param userId
     * @param startTime
     * @param endTime
     * @param label
     * @return
     */
    @PostMapping("/saveActivity")
    public ApiResponse saveActivity(@RequestParam("address") String address,
                                    @RequestParam("title") String title,
                                    @RequestParam("text") String text,
                                    @RequestParam("userId") Integer userId,
                                    @RequestParam(value = "startTime",required = false) String startTime,
                                    @RequestParam(value ="endTime" ,required = false)String endTime,
                                    @RequestParam(value ="label[]",required = false)String[] label,
                                    @RequestParam(value ="picture",required = false)MultipartFile picture) throws IOException, ParseException {
        String picUrl = "http://8.129.172.254:8080/images/春节finally.jpg";
//                FileUtil.saveFile(picture);
        List<String> labelList = new ArrayList<>();

        for (String s:label
             ) {
            labelList.add(s);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Activity activity = new Activity(address,title,text,userId, Timestamp.valueOf(startTime),Timestamp.valueOf(endTime), labelList,picUrl);
        Integer result = activityService.InsertActivity(activity);
        return result>0?new ApiResponse(0,"success"):new ApiResponse(-1,"Server Error");
    }



}
