package edu.scau.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @description: 日程表
 * @author: whj
 * @create: 2020-07-11 20:34
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    private String address;//地点
    private String title;//标题
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp startTime;//活动开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp endTime;//活动结束时间
}
