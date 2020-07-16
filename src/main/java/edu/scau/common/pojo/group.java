package edu.scau.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class group {        //组队
    private int activityId;//活动id
    private int userId;//用户
    private String text;//组队信息
    private Timestamp publishTime;//发布时间
}
