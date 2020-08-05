package edu.scau;

import static org.junit.Assert.assertTrue;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import edu.scau.common.Service.impl.*;
import edu.scau.common.dto.ActivityManger;
import edu.scau.common.dto.Function;
import edu.scau.common.dto.PublishManagement;
import edu.scau.common.mapper.*;
import edu.scau.common.pojo.Association;
import edu.scau.common.pojo.group;
import edu.scau.common.utils.DateToStringUtil;
import edu.scau.common.utils.StringCompareUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AppTest 
{
    @Autowired
    private ScheduleMapper scheduleMapper;
    @Test
    public void Test()
    {
        System.out.println(scheduleMapper.getSchedule(1));
    }
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    public void Test1()
    {
        String s="aaaasddads";
        String ch="sda";
        System.out.println(s.indexOf(ch));
    }
}
