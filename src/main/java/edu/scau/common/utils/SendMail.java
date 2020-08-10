package edu.scau.common.utils;

import com.sun.org.apache.xerces.internal.impl.io.UCSReader;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

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
    public void sendMail(List<String> picture, String text) throws MessagingException, IOException {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            //组装 开启多文件
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setSubject("易班反馈");
            mimeMessageHelper.setText(text);
            if(picture!=null)
        for (int i = 0; i < picture.size(); i++) {
            HttpURLConnection conn = null;
            URL url = new URL(picture.get(i));
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(20 * 1000);
            final ByteArrayOutputStream output = new ByteArrayOutputStream();
            IOUtils.copy(conn.getInputStream(),output);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(output.toByteArray());
            MockMultipartFile aaa = new MockMultipartFile("aaa", byteArrayInputStream);
            mimeMessageHelper.addAttachment(i+1+".jpg",aaa);
        }
        mimeMessageHelper.setTo("yiban_snln@163.com");
            mimeMessageHelper.setFrom("yiban_snln@163.com");
            javaMailSender.send(mimeMessage);
    }
}
