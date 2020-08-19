package edu.scau;

import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.scau.common.Service.MessageSubscribeService;
import edu.scau.common.Service.impl.*;
import edu.scau.common.dto.MessageData;
import edu.scau.common.dto.MessageSubscribe;
import edu.scau.common.mapper.MessageSubscribeMapper;
import edu.scau.common.pojo.group;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AppTest 
{
    @Autowired
    private MessageSubscribeMapper messageSubscribeMapper;
    @Autowired
    private MessageSubscribeServiceImpl messageSubscribeService;
    @Test
    public void shouldAnswerWithTrue() throws JsonProcessingException {
        MessageData messageData = new MessageData();
        messageData.setThing2(new MessageData.Thing2("1"));
        messageData.setThing5(new MessageData.Thing5("1"));
        messageData.setThing6(new MessageData.Thing6("1"));
        MessageSubscribe messageSubscribe = new MessageSubscribe();
        messageSubscribe.setTouser("oERIq46F9wsvfrgD1V6PRsjltOD0");
        messageSubscribe.setTemplate_id("8nR52iQ_h-NDdUMLv5R_w40aOXGQgi--uThwLQOF6Qg");
        messageSubscribe.setData(messageData);
        System.out.println(messageSubscribe);
        JSONObject json = JSONObject.fromObject(messageSubscribe);
        String str = json.toString();
        System.out.println(str);
    }
    @Test
    public void test1() throws Exception {
        System.out.println(messageSubscribeService.sendSubscribeMessage());
    }
    @Test
    public void test2(){
        System.out.println(messageSubscribeMapper.getId(1));
    }
}
