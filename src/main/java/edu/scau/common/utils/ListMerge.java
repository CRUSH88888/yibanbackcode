package edu.scau.common.utils;

import edu.scau.common.dto.ActivityManger;
import edu.scau.common.dto.ActivitySearch;

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
                if(activitySearches1.get(j).getLabel()!=null&&activitySearches.get(i).getLabel()!=null){
                    List<String> label = activitySearches.get(i).getLabel();
                    List<String> label1 = activitySearches1.get(j).getLabel();
                    for (String s : label1) {
                        label.add(s);
                    }
                    activitySearches.get(i).setLabel(label);
                }
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
    public static List<ActivityManger> listMerge2(List<ActivityManger> activityMangers,List<ActivityManger> activityMangers1){
        List<ActivityManger> activityMangers2 = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<activityMangers.size()&&j<activityMangers1.size()){
            System.out.println(activityMangers.get(i).getBuildTime());
            if(activityMangers.get(i).getBuildTime().after(activityMangers1.get(j).getBuildTime())){
                activityMangers2.add(activityMangers.get(i));
                i++;
            }else{
                activityMangers2.add(activityMangers1.get(j));
                j++;
            }
        }
        if(i!=activityMangers.size()){
            for(int a=i;a<activityMangers.size();a++){
                activityMangers2.add(activityMangers.get(a));
            }
        }else{
            for(int b=j;b<activityMangers1.size();b++){
                activityMangers2.add(activityMangers1.get(b));
            }
        }
        return activityMangers2;
    }
}
