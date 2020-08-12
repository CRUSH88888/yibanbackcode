package edu.scau.common.controller;

import edu.scau.common.Service.impl.AuthenticationServiceImpl;
import edu.scau.common.utils.ApiResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: 认证接口
 * @author: whj
 * @create: 2020-08-07 16:05
 **/
@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationServiceImpl authenticationService;

    /**
     *  修改资料认证
     * @param userId
     * @return
     */
    @GetMapping("updateAssociationAuthentication")
    public ApiResponse updateAssociationAuthentication(@RequestParam("userId") int userId){
        List<String> strings = authenticationService.updateAssociationAuthentication(userId);
        return strings.isEmpty()==true?new ApiResponse(-1,"没有权限，请先认证"):new ApiResponse(0,"success",strings);
    }

    /**
     *添加资料认证
     * @param userId
     * @return
     */
    @GetMapping("insertAssociationAuthentication")
    public ApiResponse insertAssociationAuthentication(@RequestParam("userId") int userId){
        List<String> strings = authenticationService.insertAssociationAuthentication(userId);
        return strings.isEmpty()==true?new ApiResponse(-1,"没有权限，请先认证"):new ApiResponse(0,"success",strings);
    }

    /**
     *  发布活动资格
     * @param userId
     * @return
     */
    @GetMapping("saveActivityAuthentication")
    public ApiResponse saveActivityAuthentication(@RequestParam("userId") int userId){
        Integer result = authenticationService.saveActivityAuthentication(userId);
        return result>0?new ApiResponse(0,"success"):new ApiResponse(-1,"没有权限，请先认证");
    }

    /**
     *
     * @param userId
     * @param level
     * @param associationName
     * @return
     */
    @GetMapping("deleteAuthentication")
    public ApiResponse deleteAuthentication(@RequestParam("userId")int userId,
                                            @RequestParam("level")int level,
                                            @RequestParam("associationName")String associationName){
        Integer result = authenticationService.deleteAuthentication(userId, level, associationName);
        return result>0?new ApiResponse(0,"success"):new ApiResponse(-1,"delete error");
    }
}
