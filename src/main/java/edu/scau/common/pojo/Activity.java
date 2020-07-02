package edu.scau.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {    //活动
    private int id;
    private String title;//标题
    private String text;//正文
    private String userId;//发布者
    private Date startTime;//活动开始时间
    private Date endTime;//活动结束时间
    private Label label;//标签
}
