package edu.scau;

import static org.junit.Assert.assertTrue;

import edu.scau.common.Service.impl.*;
import edu.scau.common.utils.SendMail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AppTest 
{
//<<<<<<< HEAD
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
//=======

//>>>>>>> e59c7d7b4cd35af1a629374a9729187320a28a78
    @Autowired
    private SearchServiceImpl searchService;
    @Autowired
    private SendMail sendMail;
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    public void Test1()
    {
        System.out.println(sendMail);
    }
}
