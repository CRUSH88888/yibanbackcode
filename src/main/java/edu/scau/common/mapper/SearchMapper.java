package edu.scau.common.mapper;

import edu.scau.common.dto.ActivitySearch;
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
    List<ActivitySearch> searchActivityByTitle(@Param("search")char[] search);
    List<ActivitySearch> searchActivityByLabel(int label);
    List<ActivitySearch> searchActivityByText(@Param("search")char[] search);
}
