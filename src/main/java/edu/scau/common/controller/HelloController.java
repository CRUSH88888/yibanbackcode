package edu.scau.common.controller;


import edu.scau.common.utils.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @auther:cyf
 * @create:2020/7/2 19:20
 **/
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/world")
    public ApiResponse hello(){
        return new ApiResponse(-1,"hello");
    }
}
