package edu.scau.common.utils;

import com.sun.org.apache.xerces.internal.impl.io.UCSReader;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;

/**
 * @description:邮件发送
 * @author: whj
 * @create: 2020-08-07 20:48
 **/
@Component
@Async
public class SendMail {
    @Autowired
    private JavaMailSenderImpl javaMailSender;
    public void sendMail(MultipartFile[] picture,String text) throws MessagingException, IOException {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            //组装 开启多文件
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setSubject("易班反馈");
            mimeMessageHelper.setText(text);
            //附件
            if(picture!=null) {
                for (int i = 0; i < picture.length; i++) {
                    File file= new File(picture[i].getOriginalFilename());
                    FileUtils.copyInputStreamToFile(picture[i].getInputStream(),file);
                    mimeMessageHelper.addAttachment(i + ".jpg", picture[i]);
                }
            }
            mimeMessageHelper.setTo("yiban_snln@163.com");
            mimeMessageHelper.setFrom("yiban_snln@163.com");
            javaMailSender.send(mimeMessage);
    }
}
