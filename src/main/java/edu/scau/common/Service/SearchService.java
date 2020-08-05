package edu.scau.common.Service;

import edu.scau.common.dto.ActivityManger;
import edu.scau.common.dto.ActivitySearch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description: 搜索功能
 * @author: whj
 * @create: 2020-08-02 23:13
 **/
public interface SearchService {
    List<String> searchAssociation(String search);
    List<ActivitySearch> searchActivity(String search);
}
