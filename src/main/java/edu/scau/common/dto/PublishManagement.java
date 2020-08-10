package edu.scau.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @description: 发布管理
 * @author: whj
 * @create: 2020-07-17 15:20
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublishManagement {
    private int id;//活动id或者组队id
    private int userId;//发布者id
    private String text;// 活动标题或组队内容
    private Timestamp publishTime;//发布时间
    private String date;//发布时间至今
    private int type;//活动为1 组队信息为2 活动证明为3
    private boolean select;
}
