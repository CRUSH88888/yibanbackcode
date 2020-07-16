package edu.scau;

import static org.junit.Assert.assertTrue;

import edu.scau.common.Service.impl.ActivityCollectedServiceImpl;
import edu.scau.common.mapper.ScheduleMapper;
import edu.scau.common.utils.DateToStringUtil;
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
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test(){
        Timestamp timestamp = new Timestamp(2018-1900,5,17,22,1,0,0);
        String s = DateToStringUtil.publishTime(timestamp);
        System.out.println(s);
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
