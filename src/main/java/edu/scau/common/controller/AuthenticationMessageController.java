package edu.scau.common.controller;

import edu.scau.common.Service.impl.AuthenticationMessageServiceImpl;
import edu.scau.common.pojo.AuthenticationMessage;
import edu.scau.common.utils.ApiResponse;
import edu.scau.common.utils.FileUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:认证信息
 * @author: whj
 * @create: 2020-08-08 15:53
 **/
@RestController
public class AuthenticationMessageController {
    @Autowired(required = false)
    private AuthenticationMessageServiceImpl authenticationMessageService;

    /**
     *
     * @param userId
     * @param associationName
     * @param level
     * @param picture
     * @return
     * @throws IOException
     */
    @PostMapping("sendAuthenticationMessage")
    public ApiResponse sendAuthenticationMessage(@RequestParam("userId")int userId,
                                                 @RequestParam("associationName")String associationName,
                                                 @RequestParam("level") int level,
                                                 @RequestParam(value = "picture",required = false)List<String> picture)  {
        AuthenticationMessage authenticationMessage = new AuthenticationMessage(userId, associationName, level, picture);
        Integer result = authenticationMessageService.to_authentication(authenticationMessage);
        if(result==1){
            return new ApiResponse(1,"success");
        }
        else if(result==0){
            return new ApiResponse(0,"server error");
        }
        else{
            return new ApiResponse(-1,"认证失败");
        }
    }

    /**
     * 获取审核信息
     * @return
     */
    @GetMapping("getAuthenticationMessage")
    public ApiResponse getAuthenticationMessage(){
        List<AuthenticationMessage> authenticationMessage = authenticationMessageService.getAuthenticationMessage();
        return authenticationMessage.isEmpty()==true?new ApiResponse(0,"empty"):new ApiResponse(0,"success",authenticationMessage);
    }

    /**
     * 获取详细审核信息
     * @param id
     * @return
     */
    @GetMapping("getAuthenticationMessageById")
    public ApiResponse getAuthenticationMessageById(@RequestParam("id") int id){
        AuthenticationMessage authenticationMessageById = authenticationMessageService.getAuthenticationMessageById(id);
        return authenticationMessageById==null?new ApiResponse(0,"empty"):new ApiResponse(0,"success",authenticationMessageById);
    }
    @GetMapping("fail")
    public ApiResponse fail(@RequestParam("information") String information,
                            @RequestParam("id") int id){
        Integer fail = authenticationMessageService.fail(information,id);
        return fail>0?new ApiResponse(0,"success"):new ApiResponse(-1,"error");

    }
    @GetMapping("success")
    public ApiResponse success(@RequestParam("id") int id){
        Integer success = authenticationMessageService.success(id);
        return success>0?new ApiResponse(0,"success"):new ApiResponse(-1,"error");
    }
}
