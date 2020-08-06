package edu.scau.common.utils;

import java.sql.Timestamp;

/**
 * @description: 时间转字符串的工具类
 * @author: whj
 * @create: 2020-07-12 22:33
 **/
public class DateToStringUtil {
    /**
     * 开始到结束的时间转换为字符串
     * @param startTime
     * @param endTime
     * @return
     */
    public static String dateToString(Timestamp startTime,Timestamp endTime){
          if(endTime==null){
              if(endTime.getMinutes()==0&&endTime.getHours()==0)
                  return toString(endTime,"month");
              else
                  return toString(endTime,"month")+" "+toString(endTime,"hour");

          }
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

    /**
     * 发布至今的时间
     * @param publishTime
     * @return
     */
    public static String publishTime(Timestamp publishTime){
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        long time = publishTime.getTime()/1000;//秒
        long time1 = currentTime.getTime()/1000;//秒
//        1分钟内
        if(time1-time<60){
            return "刚刚";
        }
//        1小时内
        else if(time1-time>=60&&time1-time<3600){
            long minute = time1 - time;
            minute/=60;
            return minute+"分钟前";
        }
//        1天内
        else if(time1-time>=3600&&time1-time<86400){
            long hour=(time1-time)/3600;
            return hour+"小时前";
        }
//        1个月内
        else if(time1-time>=86400&&time1-time<2592000){
            long day=(time1-time)/86400;
            return day+"天前";
        }
//        1年内
        else if(time1-time>=2592000&&time1-time<31536000){
            long month=(time1-time)/2592000;
            if(month<12){
                return month+"个月前";
            }
            else
                return "1年前";
        }
//        1年以上
        else{
            String year=publishTime.getYear()+1900+"";
            String month=publishTime.getMonth()+1+"";
            String date=publishTime.getDate()+"";
            return year+"-"+month+"-"+date;
        }
    }
}
