package edu.scau.common.utils;

import java.sql.Timestamp;

/**
 * @description: 时间转字符串的工具类
 * @author: whj
 * @create: 2020-07-12 22:33
 **/
public class DateToStringUtil {
    public static String dateToString(Timestamp startTime,Timestamp endTime){
//        年份不同 显示：yyyy年mm月dd日
            if(startTime.getYear()!=endTime.getYear()){
                return toString(startTime,"year")+"-"+toString(endTime,"year");
            }
            else{
//                日期不同：mm月dd日-mm月dd日
                if(startTime.getDate()!=endTime.getDate()){
                    return toString(startTime,"month")+"-"+toString(endTime,"month");
                }
//                同一天但时间不同：mm月dd日 hh：mm-hh：mm
                else{
                    return toString(startTime,"month")+" "+toString(startTime,"hour")+"-"+toString(endTime,"hour");
                }
            }
    }
    public static String toString(Timestamp time, String str){
        String year=time.getYear()+1900+"";
        String month=time.getMonth()+1+"";
        String date=time.getDate()+"";
        String hour=time.getHours()+"";
        String minute=time.getMinutes()+"";
        if(time.getMonth()+1<10){
            month=0+month;
        }
        if(time.getDate()+1<10){
            date=0+date;
        }
        if(time.getHours()+1<10){
            hour=0+hour;
        }
        if(time.getMinutes()+1<10){
            minute=0+minute;
        }
        if(str=="year"){
            return year+"年"+month+"月"+date+"日";
        }
        else if(str=="month"){
            return month+"月"+date+"日";
        }
        else if(str=="hour"){
            return hour+":"+minute;
        }
        return null;
    }
}
