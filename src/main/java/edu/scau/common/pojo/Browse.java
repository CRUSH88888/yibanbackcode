package edu.scau.common.pojo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @description:记录用户看过的活动
 * @auther:cyf
 * @create:2020/7/3 18:14
 **/
@Data
public class Browse {

    /*
    主键
     */
    private Integer id;
    /*
    是否浏览过
     */
    private Boolean isBrowsed;
    /*
    活动id
     */
    private Integer activityId;
    /*
        用户id
     */
    private Integer userId;
    private Timestamp browsedTime;//浏览的时候的时间

    public Browse(Integer activityId, Integer userId, Timestamp browsedTime) {
        this.activityId = activityId;
        this.userId = userId;
        this.browsedTime = browsedTime;
    }
}
