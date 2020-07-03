package edu.scau.common.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {    //活动
    private int id;
    private String title;//标题
    private String text;//正文
    private Integer userId;//发布者
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;//活动开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;//活动结束时间
    private List<String> label;//标签

    public Activity( String title, String text, Integer userId, Date startTime, Date endTime, List<String> label) {
        this.title = title;
        this.text = text;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.label = label;
    }
}