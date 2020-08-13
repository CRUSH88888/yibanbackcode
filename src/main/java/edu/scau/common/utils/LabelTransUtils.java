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
                    stringLabels.add("宣讲会");break;
                }
                case (2):{
                    stringLabels.add("比赛");break;
                }
                case (3):{
                    stringLabels.add("志愿活动");break;
                }
                case (4):{
                    stringLabels.add("讲座");break;
                }
                case (5):{
                    stringLabels.add("电影节");break;
                }
                case (6):{
                    stringLabels.add("娱乐活动");break;
                }
                case (7):{
                    stringLabels.add("校级");break;
                }
                case (8):{
                    stringLabels.add("院级");break;
                }
                case (9):{
                    stringLabels.add("综测加分");break;
                }case (10):{
                    stringLabels.add("志愿时");break;
                }
                case (11):{
                    stringLabels.add("其它");break;
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
                case ("宣讲会"):{
                    integerLabels.add(1);
                    break;
                }
                case ("比赛"):{
                    integerLabels.add(2);break;
                }
                case ("志愿活动"):{
                    integerLabels.add(3);break;
                }
                case ("讲座"):{
                    integerLabels.add(4);break;
                }
                case ("电影节"):{
                    integerLabels.add(5);break;
                }
                case ("娱乐活动"):{
                    integerLabels.add(6);break;
                }
                case ("校级"):{
                    integerLabels.add(7);break;
                }
                case ("院级"):{
                    integerLabels.add(8);break;
                }
                case ("综测加分"):{
                    integerLabels.add(9);break;
                }case ("志愿时"):{
                    integerLabels.add(10);break;
                }
                case ("其它"):{
                    integerLabels.add(11);break;
                }
            }
        }
        return integerLabels;
    }
    public static List<String> StringToString(List<String> stringLabel){
        List<String> integerLabels = new ArrayList<>();
        for (String s:stringLabel
        ) {
            switch (s){
                case ("宣讲会"):{
                    integerLabels.add("1");
                    break;
                }
                case ("比赛"):{
                    integerLabels.add("2");break;
                }
                case ("志愿活动"):{
                    integerLabels.add("3");break;
                }
                case ("讲座"):{
                    integerLabels.add("4");break;
                }
                case ("电影节"):{
                    integerLabels.add("5");break;
                }
                case ("娱乐活动"):{
                    integerLabels.add("6");break;
                }
                case ("校级"):{
                    integerLabels.add("7");break;
                }
                case ("院级"):{
                    integerLabels.add("8");break;
                }
                case ("综测加分"):{
                    integerLabels.add("9");break;
                }case ("志愿时"):{
                    integerLabels.add("10");break;
                }
                case ("其它"):{
                    integerLabels.add("11");break;
                }
            }
        }
        return integerLabels;
    }
    public static List<String> numStringTranToString(List<String> stringLabel){
        List<String> numString = new ArrayList<>();
        for (String s:stringLabel
        ) {
            switch (s){
                case ("1"):{
                    numString.add("宣讲会");
                    break;
                }
                case ("2"):{
                    numString.add("比赛");break;
                }
                case ("3"):{
                    numString.add("志愿活动");break;
                }
                case ("4"):{
                    numString.add("讲座");break;
                }
                case ("5"):{
                    numString.add("电影节");break;
                }
                case ("6"):{
                    numString.add("娱乐活动");break;
                }
                case ("7"):{
                    numString.add("校级");break;
                }
                case ("8"):{
                    numString.add("院级");break;
                }
                case ("9"):{
                    numString.add("综测加分");break;
                }case ("10"):{
                    numString.add("志愿时");break;
                }
                case ("11"):{
                    numString.add("其它");break;
                }
            }
        }
        return numString;
    }
}
