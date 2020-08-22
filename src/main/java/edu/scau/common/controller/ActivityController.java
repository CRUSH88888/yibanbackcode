package edu.scau.common.controller;

import edu.scau.common.Service.ActivityService;
import edu.scau.common.pojo.Activity;
import edu.scau.common.pojo.ActivityPicture;
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
    public ApiResponse saveActivityTest(@RequestParam("address") String address,
                                    @RequestParam("title") String title,
                                    @RequestParam("text") String text,
                                    @RequestParam("userId") Integer userId,
                                    @RequestParam(value = "startTime",required = false) String startTime,
                                    @RequestParam(value ="endTime" ,required = false)String endTime,
                                    @RequestParam(value ="label",required = false)String[] label,
                                    @RequestParam(value ="picture",required = false)String[] picture) throws IOException, ParseException {

        List<String> labels = new ArrayList<>();
        for (String s:label
        ) {
            System.out.println("labels: "+s);
            labels.add(s);
        }
        List<ActivityPicture> pics = new ArrayList<>();
        for (String s:picture
        ) {
            System.out.println("pic: "+s);
            pics.add(new ActivityPicture(s));
        }

        Activity activity = new Activity(address,title,text,userId,startTime,endTime,labels,pics);
        Integer result =  activityService.InsertActivity(activity);
        System.out.println(result);
        return result > 0?new ApiResponse(0,"success"):new ApiResponse(-1,"server error");

    }
    public ApiResponse saveActivity(@RequestParam("address") String address,
                                    @RequestParam("title") String title,
                                    @RequestParam("text") String text,
                                    @RequestParam("userId") Integer userId,
                                    @RequestParam(value = "startTime",required = false) String startTime,
                                    @RequestParam(value ="endTime" ,required = false)String endTime,
                                    @RequestParam(value ="label[]",required = false)String[] label,
                                    @RequestParam(value ="picture",required = false)MultipartFile[] picture) throws IOException, ParseException {
        List<ActivityPicture> picUrl = new ArrayList<>();
        if(picture != null ||picture.length != 0)
        {
//            Activity activity = new Activity(address,title,text,userId,startTime,endTime,labelList);

        for (MultipartFile m:picture
             ) {
            System.out.println(m.isEmpty());
            if (!m.isEmpty() && "".equals(m.getOriginalFilename()) ){
            System.out.println("."+m.getOriginalFilename()+".");
            picUrl.add(new ActivityPicture(FileUtil.saveFile(m)));
            }
        }
        }else {
            picUrl = null;
        }
        List<String> labelList = new ArrayList<>();

        for (String s:label
             ) {
            labelList.add(s);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Activity activity = new Activity(address,title,text,userId, startTime,endTime, labelList,picUrl);
        Integer result = activityService.InsertActivity(activity);
        return new ApiResponse(0,"success");
//        return result>0?new ApiResponse(0,"success"):new ApiResponse(-1,"Server Error");
    }

    @PostMapping("/queryActivityById")
    public ApiResponse queryActivityById(@RequestParam("activityId")Integer activityId,
                                             @RequestParam("userId")Integer UserId){

            return new ApiResponse(0,"success", activityService.selectActivityById(activityId,UserId));
    }

}
