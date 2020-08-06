package edu.scau.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @description: 活动收藏
 * @author: whj
 * @create: 2020-07-22 20:23
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityManger {
    private int id;//活动id
    private String title;//活动标题
    private String address;//地点
    private Timestamp buildTime;//发布时间
    private String date;//发布时间至今
}
