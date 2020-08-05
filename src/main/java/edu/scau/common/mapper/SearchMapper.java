package edu.scau.common.mapper;

import edu.scau.common.dto.ActivityManger;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 搜索
 * @author: whj
 * @create: 2020-08-02 20:46
 **/
@Mapper
public interface SearchMapper{
    List<String> searchAssociation(@Param("search")char[] search);
    List<ActivityManger> searchActivity(@Param("search")char[] search);
    List<ActivityManger> searchActivity2(int label);
}
