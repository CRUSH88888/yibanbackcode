package edu.scau.common.Service.impl;

import edu.scau.common.Service.SearchService;
import edu.scau.common.dto.ActivityManger;
import edu.scau.common.dto.ActivitySearch;
import edu.scau.common.mapper.SearchMapper;
import edu.scau.common.utils.DateToStringUtil;
import edu.scau.common.utils.LabelTransUtils;
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
    public List<ActivitySearch> searchActivity(String search) {
        char[] chars = search.toCharArray();
        List<ActivitySearch> activitySearches1 = searchMapper.searchActivityByTitle(chars);
        List<Integer> integers = StringCompareUtil.labelCode(search);
        List<String> strings = LabelTransUtils.integerToString(integers);
        for (int i = 0; i < integers.size(); i++) {
            List<ActivitySearch> activitySearches = searchMapper.searchActivityByLabel(integers.get(i));
            for (ActivitySearch activitySearch : activitySearches) {
                ArrayList<String> strings1 = new ArrayList<>();
                strings1.add(strings.get(i));
                activitySearch.setLabel(strings1);
            }
            activitySearches1 = ListMerge.listMerge(activitySearches1, activitySearches);
        }
        List<ActivitySearch> activitySearches = searchMapper.searchActivityByText(search);
        for (ActivitySearch activitySearch : activitySearches) {
            List<String> strings1 = StringCompareUtil.TextCompare(search, activitySearch.getSearch());
            activitySearch.setSearchBefore(strings1.get(0));
            activitySearch.setSearch(strings1.get(1));
            activitySearch.setSearchAfter(strings1.get(2));
        }
        activitySearches1 = ListMerge.listMerge(activitySearches1, activitySearches);
        for (ActivitySearch activitySearch : activitySearches1) {
            activitySearch.setDate(DateToStringUtil.publishTime(activitySearch.getBuildTime()));
        }
        return activitySearches1;
    }
}
