package edu.scau.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class group {        //组队
    private int id;
    private int activityId;//活动id
    private int userId;//用户
    private String text;//组队信息
    private Timestamp publishTime;//发布时间
    private String date;//发布时间到查询时 例：几分钟前
    public group(int id, int activityId, int userId, String text) {
        this.id = id;
        this.activityId = activityId;
        this.userId = userId;
        this.text = text;
    }
}
