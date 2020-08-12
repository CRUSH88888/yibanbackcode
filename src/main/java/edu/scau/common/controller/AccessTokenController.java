package edu.scau.common.controller;

import com.mysql.cj.protocol.x.Notice;
import org.omg.IOP.Encoding;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;

/**
 * @description:
 * @auther:cyf
 * @create:2020/8/12 14:44
 **/
@RestController
public class AccessTokenController {

    private String AppId = "a1397db859458285";
    private String AppSecret = "eb2c65221a15c0b88f1f6b16c4926458";
    private String redirect_uri = "https://liveforjokes.icu";
    @PostMapping("getAccessToken")
    public String getAccessToken(){
            String codeUrl = "https://openapi.yiban.cn/oauth/authorize?client_id=a1397db859458285&redirect_uri=https://liveforjokes.icu";
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("success");
        Notice notice = restTemplate.getForObject(codeUrl,Notice.class);
        System.out.println(notice);
        return null;
    }
}
