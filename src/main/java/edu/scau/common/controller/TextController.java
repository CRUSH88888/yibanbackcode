package edu.scau.common.controller;

import edu.scau.common.utils.ApiResponse;
import edu.scau.common.utils.FileUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @description: 测试
 * @author: whj
 * @create: 2020-08-08 12:21
 **/
@RestController
public class TextController {
    @PostMapping("text")
    public ApiResponse text(@RequestParam(value = "picture") MultipartFile[] picture) throws IOException {
        ArrayList<String> strings = new ArrayList<>();
        if(picture==null){
            return new ApiResponse(-1,"error");
        }
        for (MultipartFile multipartFile : picture) {
            strings.add(FileUtil.saveFile(multipartFile));
        }
        return new ApiResponse(0,"success",strings);
    }
}
