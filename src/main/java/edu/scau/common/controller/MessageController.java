package edu.scau.common.controller;

import edu.scau.common.Service.impl.MessageServiceImpl;
import edu.scau.common.pojo.Message;
import edu.scau.common.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:留言
 * @author: whj
 * @create: 2020-07-28 21:37
 **/
@RestController
public class MessageController {
    @Autowired
    private MessageServiceImpl messageService;

    /**
     * 获取活动留言
     * @param userId
     * @return
     */
    @GetMapping("getMessages")
    public ApiResponse getMessages(@RequestParam("userId") int userId){
        List<Message> message = messageService.getMessages(userId);
        return message.isEmpty()==true?new ApiResponse(0,"empty"):new ApiResponse(0,"success",message);
    }

    /**
     * 获取具体留言并修改browsed
     * @param id
     * @return
     */
    @GetMapping("/getMessage")
    public ApiResponse getMessage(@RequestParam("id") int id){
        Message message = messageService.getMessage(id);
        return message==null?new ApiResponse(-1,"error"):new ApiResponse(0,"success",message);
    }
    /**
     * 添加留言
     * @param activityId
     * @param message
     * @return
     */
    @PostMapping("insertMessage")
    public ApiResponse insertMessage(@RequestParam("activityId") int activityId,
                                     @RequestParam("message") String message){
        Message message1 = new Message(activityId, message);
        Integer result = messageService.insertMessage(message1);
        return result>0?new ApiResponse(0,"success"):new ApiResponse(-1,"Server Error");
    }

}
