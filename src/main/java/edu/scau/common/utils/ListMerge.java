package edu.scau.common.utils;

import edu.scau.common.dto.ActivityManger;
import edu.scau.common.dto.PublishManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: list合并
 * @author: whj
 * @create: 2020-08-03 21:28
 **/
public class ListMerge {
    public static List<ActivityManger> listMerge(List<ActivityManger> activityMangers,List<ActivityManger> activityMangers1){
        List<ActivityManger> activityMangers2 = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<activityMangers.size()&&j<activityMangers1.size()){
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
