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
                List<String> strings1 = new ArrayList<>();
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
            activitySearch.setType(1);
        }
        List<ActivitySearch> activitySearches2 = searchMapper.searchCertificateByTitle(chars);
        for (int i = 0; i < integers.size(); i++) {
            List<ActivitySearch> activitySearches3 = searchMapper.searchCertificateByLabel(integers.get(i));
            for (ActivitySearch activitySearch : activitySearches3) {
                List<String> strings1 = new ArrayList<>();
                strings1.add(strings.get(i));
                activitySearch.setLabel(strings1);
            }
            activitySearches2 = ListMerge.listMerge(activitySearches2, activitySearches3);
        }
        for (ActivitySearch activitySearch : activitySearches2) {
            activitySearch.setType(2);
        }
        List<ActivitySearch> activitySearches3 = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<activitySearches1.size()&&j<activitySearches2.size()){
            if(activitySearches1.get(i).getBuildTime().after(activitySearches2.get(j).getBuildTime())){
                activitySearches3.add(activitySearches1.get(i));
                i++;
            }else{
                activitySearches3.add(activitySearches2.get(j));
                j++;
            }
        }
        if(i!=activitySearches1.size()){
            for(int a=i;a<activitySearches1.size();a++){
                activitySearches3.add(activitySearches1.get(a));
            }
        }else{
            for(int b=j;b<activitySearches2.size();b++){
                activitySearches3.add(activitySearches2.get(b));
            }
        }
        for (ActivitySearch activitySearch : activitySearches3) {
            activitySearch.setDate(DateToStringUtil.publishTime(activitySearch.getBuildTime()));
        }
        return activitySearches3;
    }
}
