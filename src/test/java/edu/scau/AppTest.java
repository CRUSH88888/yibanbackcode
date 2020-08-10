package edu.scau;

import static org.junit.Assert.assertTrue;

import edu.scau.common.Service.impl.*;
import edu.scau.common.mapper.AuthenticationMapper;
import edu.scau.common.mapper.AuthenticationMessageMapper;
import edu.scau.common.utils.SendMail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.UserDataHandler;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AppTest 
{
    @Autowired
    private SendMail sendMail;
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    public void test() throws IOException, MessagingException {
        sendMail.sendMail(null,"hhh");
    }


}
