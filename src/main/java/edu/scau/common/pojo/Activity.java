package edu.scau.common.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {    //活动
    private int id;
    private String address;//地点
    private String title;//标题
    private String text;//正文
    private Integer userId;//发布者
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp startTime;//活动开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp endTime;//活动结束时间
    private List<String> label;//标签
    private String date;

    public Activity( String title, String text, Integer userId, Timestamp startTime, Timestamp endTime, List<String> label) {
        this.title = title;
        this.text = text;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.label = label;
    }
}
