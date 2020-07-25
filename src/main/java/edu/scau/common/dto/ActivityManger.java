package edu.scau.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @description: 近期活动以及活动收藏
 * @author: whj
 * @create: 2020-07-22 20:23
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityManger {
    private int id;//活动id
    private String title;//活动标题
    private Timestamp buildTime;//发布时间
    private String date;//发布时间至今
    private boolean collected;//是否被收藏，查询收藏活动时默认忽略这个
}
