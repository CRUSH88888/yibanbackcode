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
<<<<<<< HEAD
//    @Autowired
//    private FunctionServiceImpl functionService;
//    @Autowired
//    private FunctionMapper function;
//    @Autowired
//    private ActivityCollectedServiceImpl activityCollectedService;
//    @Autowired
//    private PublishManagementServiceImpl publishManagementService;
//    @Autowired
//    private BrowsedMapper browsedMapper;
//    @Autowired
//    private SearchMapper searchMapper;
//    @Test
//    public void test(){
//        System.out.println(functionService.getFunction(1));
//    }
//    @Test
//    public void test1(){
//        System.out.println(activityCollectedService.getCollectedActivity(1));
//    }
//    @Test
//    public void test3(){
//        int[] id={2};
//        int[] type={1};
//        System.out.println(publishManagementService.deletePublish(id,type));
//    }
//    @Test
//    public void test4(){
//        System.out.println(browsedMapper.getFootPrint(1));
//    }
//    @Test
//    public void test5(){
//        String s="是的按时打算";
//        char[] chars = s.toCharArray();
//        for (char aChar : chars) {
//            System.out.println(aChar+" ");
//        }
//    }
//    @Test
//    public void test6(){
//        String s1="羽协";
//        char[] chars = s1.toCharArray();
//        List<String> strings = searchMapper.searchAssociation(chars);
//        System.out.println(strings);
//    }
=======
    @Autowired
    private FunctionServiceImpl functionService;
    @Autowired
    private FunctionMapper function;
    @Autowired
    private ActivityCollectedServiceImpl activityCollectedService;
    @Autowired
    private PublishManagementServiceImpl publishManagementService;
    @Autowired
    private BrowsedMapper browsedMapper;
    @Autowired
    private SearchServiceImpl searchService;
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
    public void test4(){
        System.out.println(browsedMapper.getFootPrint(1));
    }
    @Test
    public void test5(){
        String s="是的按时打算";
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            System.out.println(aChar+" ");
        }
    }
    @Test
    public void test6(){
        List<ActivityManger> a = searchService.searchActivity("志愿");
        System.out.println(a);
    }
>>>>>>> e59c7d7b4cd35af1a629374a9729187320a28a78
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    public void test7()
    {
        System.out.println(StringCompareUtil.StringCompare("fas","adasfbiuibiaxxxs"));
    }
}
