package edu.scau.common.controller;

import edu.scau.common.Service.impl.MessageSubscribeServiceImpl;
import edu.scau.common.mapper.MessageSubscribeMapper;
import edu.scau.common.utils.ApiResponse;
import edu.scau.common.utils.HttpUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: 消息订阅相关接口
 * @author: whj
 * @create: 2020-08-12 21:34
 **/
@RestController
public class MessageSubscribeController {
    @Autowired(required = false)
    private MessageSubscribeMapper messageSubscribeMapper;
    @Autowired
    private MessageSubscribeServiceImpl messageSubscribeService;

    /**
     * 获取订阅状态
     * @param userId
     * @return
     */
    @GetMapping("getIsOpen")
    public ApiResponse getIsOpen(@RequestParam("userId")int userId){
        Boolean isOpen = messageSubscribeMapper.getIsOpen(userId);
        return new ApiResponse(1,"success",isOpen);
    }
    /**
     * 上传添加openid
     * @param userId
     * @param code
     * @return
     */
    @PostMapping("insertOpenId")
    public ApiResponse insertOpenId(@RequestParam("userId") int userId,
                                    @RequestParam("code")String code) throws Exception {
        String result= HttpUtil.doGet("https://api.weixin.qq.com/sns/jscode2session?appid="
                + HttpUtil.APPID + "&secret="
                + HttpUtil.APPSECRET + "&js_code="
                + code
                + "&grant_type=authorization_code");
        JSONObject jsonObject = JSONObject.fromObject(result);
        String openid = (String) jsonObject.get("openid");
        Integer result1=1;
        if(messageSubscribeMapper.getId(userId)==null)
        result1 = messageSubscribeMapper.insertOpenId(userId, openid);
        return result1>0?new ApiResponse(0,"success"):new ApiResponse(-1,"Server Error");
    }

    /**
     * 取消订阅和开启订阅 默认一开始是开启的
     * @param userId
     * @return
     */
    @PostMapping("updateOpen")
    public ApiResponse updateOpen(@RequestParam("userId") int userId){
        Integer result = messageSubscribeMapper.updateOpen(userId);
        return result>0?new ApiResponse(0,"success"):new ApiResponse(-1,"Update Error");
    }

    /**
     *添加授权
     * @param userId
     * @param activityId
     * @return
     */
    @PostMapping("insertMessageSubscribeAllow")
    public ApiResponse insertMessageSubscribeAllow(@RequestParam("userId")int userId,
                                                   @RequestParam("activityId")int activityId){
        Integer result=1;
        if(messageSubscribeMapper.getMessageSubscribeAllowId(userId,activityId)!=null)
        result = messageSubscribeMapper.insertMessageSubscribeAllow(userId, activityId);
        return result>0?new ApiResponse(0,"success"):new ApiResponse(-1,"Server Error");
    }

//    /**
//     *
//     * @return
//     * @throws Exception
//     */
//    @GetMapping("MessageSubscribe")
//    public ApiResponse MessageSubscribe() throws Exception{
//        List<String> strings = messageSubscribeService.sendSubscribeMessage();
//        return new ApiResponse(1,"success",strings);
//    }
}
