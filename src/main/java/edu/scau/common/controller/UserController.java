package edu.scau.common.controller;

import edu.scau.common.Service.UserService;
import edu.scau.common.pojo.User;
import edu.scau.common.pojo.UserDetail;
import edu.scau.common.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @auther:cyf
 * @create:2020/8/7 14:50
 **/
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 这个用于保存易班接口返回的信息
     * @param user
     * @return
     */
    @PostMapping("/saveUser")
    public ApiResponse saveUser(@RequestBody @Validated User user){
        System.out.println(user.toString());
        Integer result = userService.saveUser(user);
        return result > 0 ?new ApiResponse(0,"success"):new ApiResponse(-1,"failed");

    }

    /**
     * 用于提交用户个人信息
     * @param user
     * @return
     */
    @PostMapping("/submitIdentityInformation")
    public ApiResponse submitIdentityInformation(@RequestBody @Validated User user){
        System.out.println(user.toString());
        Integer result = userService.updateUser(user);
        return result > 0?new ApiResponse(0,"success"):new ApiResponse(-1,"failed");

    }

    @GetMapping("/getStudentDetail")
    public ApiResponse getStudentDetail(@RequestParam("id")Integer id){
        User user = userService.selectUserById(id);
        System.out.println("当前登陆人： "+user.toString());

        return new ApiResponse(0,"success",user);
    }


}
