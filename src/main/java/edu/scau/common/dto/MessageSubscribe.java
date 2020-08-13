package edu.scau.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @description: 消息订阅
 * @author: whj
 * @create: 2020-08-12 20:30
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageSubscribe {
    private int activity_id;
    private String address;//地点
    private String title;//标题
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp startTime;//活动开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp endTime;//活动结束时间
    private String date;//活动时间转为字符串
    private long clockTime;//定时
    private String openId;//接受者开放id
    private Boolean isOpen;//是否开启消息订阅
}
