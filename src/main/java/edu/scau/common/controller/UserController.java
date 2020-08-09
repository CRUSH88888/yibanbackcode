package edu.scau.common.controller;

import edu.scau.common.pojo.User;
import edu.scau.common.utils.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @auther:cyf
 * @create:2020/8/7 14:50
 **/
@RestController
public class UserController {

    @PostMapping("/saveUser")
    public ApiResponse saveUser(@RequestParam("user")User user){
        System.out.println(user.toString());
        return new ApiResponse(0,"success");
    }


}
