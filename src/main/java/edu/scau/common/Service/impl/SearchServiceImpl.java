package edu.scau.common.Service.impl;

import edu.scau.common.Service.SearchService;
import edu.scau.common.dto.ActivityManger;
import edu.scau.common.mapper.SearchMapper;
import edu.scau.common.utils.DateToStringUtil;
import edu.scau.common.utils.ListMerge;
import edu.scau.common.utils.StringCompareUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: whj
 * @create: 2020-08-02 23:14
 **/
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired(required = false)
    private SearchMapper searchMapper;
    @Override
    public List<String> searchAssociation(String search) {
        char[] chars = search.toCharArray();
        List<String> strings = searchMapper.searchAssociation(chars);
        return strings;
    }

    @Override
    public List<ActivityManger> searchActivity(String search) {
//        char[] chars = search.toCharArray();
//        List<ActivityManger> activityMangers1 = searchMapper.searchActivity(chars);
//        List<Integer> labels = StringCompareUtil.labelCode(search);
//        for (Integer label : labels) {
//            activityMangers1= ListMerge.listMerge(activityMangers1,searchMapper.searchActivity2(label));
//        }
//        for (ActivityManger activityManger : activityMangers1) {
//            activityManger.setDate(DateToStringUtil.publishTime(activityManger.getBuildTime()));
//        }
//        return activityMangers1;
        return null;
    }
}
