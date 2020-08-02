package edu.scau.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @description: 足迹
 * @author: whj
 * @create: 2020-08-02 16:28
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FootPrint {
    private int activityId;//活动id
    private String title;//活动标题
    private Timestamp browsedTime;//浏览时间
    private String date;
}
