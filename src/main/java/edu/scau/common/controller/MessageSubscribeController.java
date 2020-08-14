package edu.scau.common.controller;

import edu.scau.common.mapper.MessageSubscribeMapper;
import edu.scau.common.utils.ApiResponse;
import edu.scau.common.utils.HttpUtil;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 消息订阅相关接口
 * @author: whj
 * @create: 2020-08-12 21:34
 **/
@RestController
public class MessageSubscribeController {
    @Autowired(required = false)
    private MessageSubscribeMapper messageSubscribeMapper;

    /**
     * 添加时钟编号
     * @param userId
     * @param activityId
     * @param clockId
     * @return
     */
    @PostMapping("addClockId")
    @Transactional
    public ApiResponse addClockId(@RequestParam("userId") int userId,
                                  @RequestParam("activityId") int activityId,
                                  @RequestParam("clockId") String clockId){
        Integer result=1;
        if(messageSubscribeMapper.updateClock(userId,activityId,clockId)==0)
        result = messageSubscribeMapper.addClockId(userId, activityId, clockId);
        return result>0?new ApiResponse(0,"success"):new ApiResponse(-1,"Server Error");

    }

    /**
     * 添加openid
     * @param userId
     * @param code
     * @return
     */
    @PostMapping("insertOpenId")
    public ApiResponse insertOpenId(@RequestParam("userId") int userId,
                                    @RequestParam("code")String code) throws Exception {
        String result= HttpUtil.doGet("https://api.weixin.qq.com/sns/jscode2session?appid="
                + "wx3ba5b3cafbcbd958" + "&secret="
                + "13c3597b68a04f2b65270413e38a5989" + "&js_code="
                + code
                + "&grant_type=authorization_code");
        JSONObject jsonObject = JSONObject.fromObject(result);
        String openid = (String) jsonObject.get("openid");
        Integer result1 = messageSubscribeMapper.insertOpenId(userId, openid);
        return result1>0?new ApiResponse(0,"success"):new ApiResponse(-1,"Server Error");
    }

    /**
     * 取消订阅和开启订阅 默认一开始是关闭的
     * @param userId
     * @return
     */
    @PostMapping("updateOpen")
    public ApiResponse updateOpen(@RequestParam("userId") int userId){
        Integer result = messageSubscribeMapper.updateOpen(userId);
        return result>0?new ApiResponse(0,"success"):new ApiResponse(-1,"Update Error");
    }
}
