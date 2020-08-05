package edu.scau.common.utils;

import edu.scau.common.dto.ActivityManger;
import edu.scau.common.dto.ActivitySearch;
import edu.scau.common.dto.PublishManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: list合并
 * @author: whj
 * @create: 2020-08-03 21:28
 **/
public class ListMerge {
    public static List<ActivitySearch> listMerge(List<ActivitySearch> activitySearches,List<ActivitySearch> activitySearches1){
        List<ActivitySearch> activitySearches2 = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<activitySearches.size()&&j<activitySearches1.size()){
            if(activitySearches.get(i).getId()==activitySearches1.get(j).getId()){
                activitySearches2.add(activitySearches.get(i));
                i++;
                j++;
            }
            else {
                if (activitySearches.get(i).getBuildTime().after(activitySearches1.get(j).getBuildTime())) {
                    activitySearches2.add(activitySearches.get(i));
                    i++;
                } else {
                    activitySearches2.add(activitySearches1.get(j));
                    j++;
                }
            }
        }
        if(i!=activitySearches.size()){
            for(int a=i;a<activitySearches.size();a++){
                activitySearches2.add(activitySearches.get(a));
            }
        }else{
            for(int b=j;b<activitySearches1.size();b++){
                activitySearches2.add(activitySearches1.get(b));
            }
        }
        return activitySearches2;
    }
}
