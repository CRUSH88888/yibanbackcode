package edu.scau.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.scau.common.utils.DateToStringUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @description: 日程表及近期活动
 * @author: whj
 * @create: 2020-07-11 20:34
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    private int id;
    private String address;//地点
    private String title;//标题
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp startTime;//活动开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp endTime;//活动结束时间
    private String date;//活动时间转为字符串
    private Boolean collected;//是否被收藏
}
