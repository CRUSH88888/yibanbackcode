package edu.scau.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @auther:cyf
 * @create:2020/7/29 13:42
 **/
public class LabelTransUtils {
    public static List<String> integerToString(List<Integer> integerLabels){
        List<String> stringLabels = new ArrayList<>();
        for (Integer i:integerLabels
             ) {
            switch (i){
                case (1):{
                    stringLabels.add("propagandaConference");break;
                }
                case (2):{
                    stringLabels.add("match");break;
                }
                case (3):{
                    stringLabels.add("volunteerActivities");break;
                }
                case (4):{
                    stringLabels.add("lecture");break;
                }
                case (5):{
                    stringLabels.add("movieFestival");break;
                }
                case (6):{
                    stringLabels.add("amusementActivity");break;
                }
                case (7):{
                    stringLabels.add("universityLevel");break;
                }
                case (8):{
                    stringLabels.add("collegeLevel");break;
                }
                case (9):{
                    stringLabels.add("extraPints");break;
                }case (10):{
                    stringLabels.add("volunteerTime");break;
                }
                case (11):{
                    stringLabels.add("other");break;
                }
            }
        }

        return stringLabels;
    }
    public static List<Integer> StringToInteger(List<String> stringLabel){
        List<Integer> integerLabels = new ArrayList<>();
        for (String s:stringLabel
        ) {
            switch (s){
                case ("propagandaConference"):{
                    integerLabels.add(1);
                    break;
                }
                case ("match"):{
                    integerLabels.add(2);break;
                }
                case ("volunteerActivities"):{
                    integerLabels.add(3);break;
                }
                case ("lecture"):{
                    integerLabels.add(4);break;
                }
                case ("movieFestival"):{
                    integerLabels.add(5);break;
                }
                case ("amusementActivity"):{
                    integerLabels.add(6);break;
                }
                case ("universityLevel"):{
                    integerLabels.add(7);break;
                }
                case ("collegeLevel"):{
                    integerLabels.add(8);break;
                }
                case ("extraPints"):{
                    integerLabels.add(9);break;
                }case ("volunteerTime"):{
                    integerLabels.add(10);break;
                }
                case ("other"):{
                    integerLabels.add(11);break;
                }
            }
        }
        return integerLabels;
    }
}
