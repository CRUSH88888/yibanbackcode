package edu.scau.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

/**
 * @description: 活动搜索类
 * @author: whj
 * @create: 2020-08-04 21:31
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivitySearch {
    private int id;//活动id
    private String title;//活动标题
    private Timestamp buildTime;//发布时间
    private String searchBefore;
    private String search;
    private String searchAfter;
    private List<String> label;
    private String date;//发布时间至今
    private int type;//1：活动 2：活动证明
}
