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
    private int userId;//发布者id
    private String text;//互动标题或组队内容
    private Timestamp publishTime;//发布时间
    private String date;//发布时间至今
}
