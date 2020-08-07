package edu.scau.common.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import javax.persistence.Transient;
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
    private String date;
    private List<String> label;//标签
    /*
    二维码或其他照片的地址
     */
   @Transient
    private List<ActivityPicture> picUrl;
    private String dayToNow;
    private Timestamp buildingTime;
    /**
     * 某个用户查询时是否已经收藏过
     */
    private Boolean collected;

    public Activity( String address,String title, String text, Integer userId, Timestamp startTime, Timestamp endTime, List<String> label,List<ActivityPicture> picUrl
    ,Timestamp buildingTime) {
        this.address = address;
        this.title = title;
        this.text = text;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.label = label;
        this.picUrl = picUrl;
        this.buildingTime = buildingTime;
    }
    public Activity( String address,String title, String text, Integer userId, Timestamp startTime, Timestamp endTime, List<String> label,List<ActivityPicture> picUrl) {
        this.address = address;
        this.title = title;
        this.text = text;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.label = label;
        this.picUrl = picUrl;

    }

    public Activity(String address, String title, String text, Integer userId, List<String> label, List<ActivityPicture> picUrl
            ,Timestamp buildingTime) {
        this.address = address;
        this.title = title;
        this.text = text;
        this.userId = userId;
        this.label = label;
        this.picUrl = picUrl;
        this.buildingTime = buildingTime;
    }

    public Activity( String address, String title, String text, Integer userId, Timestamp startTime, Timestamp endTime, String date, List<String> label,  String dayToNow, Timestamp buildingTime, Boolean collected) {
        this.address = address;
        this.title = title;
        this.text = text;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.label = label;
        this.dayToNow = dayToNow;
        this.buildingTime = buildingTime;
        this.collected = collected;
    }
}
