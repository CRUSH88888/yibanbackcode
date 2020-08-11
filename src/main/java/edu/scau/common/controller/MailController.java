package edu.scau.common.controller;

import edu.scau.common.utils.ApiResponse;
import edu.scau.common.utils.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

/**
 * @description: 意见反馈
 * @author: whj
 * @create: 2020-08-07 20:54
 **/
@RestController
public class MailController {
    @Autowired
    private SendMail sendMail;
    @GetMapping("sendMail")
    public ApiResponse sendMail(@RequestParam(value = "picture",required = false) List<String> picture,
                                @RequestParam("text")String text) throws MessagingException, IOException {
        sendMail.sendMail(picture, text);
        return new ApiResponse(0,"success");
    }
}
