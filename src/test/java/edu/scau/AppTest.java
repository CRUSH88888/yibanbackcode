package edu.scau;

import static org.junit.Assert.assertTrue;

import edu.scau.common.Service.impl.ActivityCollectedServiceImpl;
import edu.scau.common.Service.impl.FunctionServiceImpl;
import edu.scau.common.Service.impl.GroupServiceImpl;
import edu.scau.common.Service.impl.PublishManagementServiceImpl;
import edu.scau.common.dto.Function;
import edu.scau.common.dto.PublishManagement;
import edu.scau.common.mapper.FunctionMapper;
import edu.scau.common.mapper.PublishManagementMapper;
import edu.scau.common.mapper.ScheduleMapper;
import edu.scau.common.pojo.group;
import edu.scau.common.utils.DateToStringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.List;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AppTest 
{
    @Autowired
    private FunctionServiceImpl functionService;
    @Autowired
    private FunctionMapper function;
    @Autowired
    private ActivityCollectedServiceImpl activityCollectedService;
    @Autowired
    private PublishManagementServiceImpl publishManagementService;
    @Test
    public void test(){
        System.out.println(functionService.getFunction(1));
    }
    @Test
    public void test1(){
        System.out.println(activityCollectedService.getCollectedActivity(1));
    }
    @Test
    public void test3(){
        int[] id={2};
        int[] type={1};
        System.out.println(publishManagementService.deletePublish(id,type));
    }
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
