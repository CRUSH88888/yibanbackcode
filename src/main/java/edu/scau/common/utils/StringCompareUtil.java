package edu.scau.common.utils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 字符串比较，模糊搜索
 * @author: whj
 * @create: 2020-08-03 20:18
 **/
public class StringCompareUtil {
    public static List<String> TextCompare(String search,String text){
        ArrayList<String> strings = new ArrayList<>();
        int i = text.indexOf(search);
        int searchLength = search.length();
        int textLength=text.length();
        if(i==0){
            strings.add("");
            strings.add(search);
            strings.add(text.substring(i+searchLength));
        }
        else{
            if(searchLength>=13){
                search="..."+search;
                strings.add("");
                strings.add(search);
                strings.add("");
            }
            else{
                if(textLength<=13){
                    strings.add(text.substring(0,i));
                    strings.add(search);
                    strings.add(text.substring(i+searchLength));
                }
                else{
                    int lengthBefore=(13-searchLength)/2;
                    int lengthAfter=13-lengthBefore-searchLength;
                    if(lengthAfter>textLength-i-1){
                        lengthBefore=13-(textLength-i-1)-searchLength;
                        strings.add("..."+text.substring(i-lengthBefore,i));
                        strings.add(search);
                        strings.add(text.substring(i+searchLength));
                    }
                    else{
                        if(i+1<lengthBefore){
                            strings.add(text.substring(0,i));
                            strings.add(search);
                            strings.add(text.substring(i+searchLength));
                        }
                        else{
                            strings.add("..."+text.substring(i-lengthBefore,i));
                            strings.add(search);
                            strings.add(text.substring(i+searchLength));
                        }
                    }
                }
            }
        }
        return strings;
    }
    public static List<Integer> labelCode(String search){
        List<Integer>  a= new ArrayList<>();
        if(StringCompare(search,"宣讲会")){
            a.add(1);
        }
        if(StringCompare(search,"比赛")){
            a.add(2);
        }
        if(StringCompare(search,"志愿活动")){
            a.add(3);
        }
        if(StringCompare(search,"讲座")){
            a.add(4);
        }
        if(StringCompare(search,"电影节")){
            a.add(5);
        }
        if(StringCompare(search,"娱乐活动")){
            a.add(6);
        }
        if(StringCompare(search,"校级")){
            a.add(7);
        }
        if(StringCompare(search,"院级")){
            a.add(8);
        }
        if(StringCompare(search,"综测加分")){
            a.add(9);
        }
        if(StringCompare(search,"志愿时")){
            a.add(10);
        }
        if(StringCompare(search,"其它")){
            a.add(11);
        }
        return a;
    }
    public static boolean StringCompare(String a,String b){
        char[] chars = a.toCharArray();
        char[] chars1 = b.toCharArray();
        int i=0;
        int j=0;
        while(i<chars.length&&j<chars1.length){
            if(chars[i]==chars1[j]) {
                i++;
            }
            j++;
        }
        if(i==chars.length){
            return true;
        }
        return false;
    }
}
