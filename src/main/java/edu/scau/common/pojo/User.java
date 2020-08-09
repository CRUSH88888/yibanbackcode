package edu.scau.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于用户填写个人信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {         //用户信息
    private int id;
    private String yb_userid;
    private String studentNumber;//学号
    private String username;//用户名
    private String name;//真实名字
    private String grade;//年级学院
    private String major;//专业班级
    private String phoneNumber;//手机号码
    private String wechatNumber;//微信号码
    private Activity[] publishActivities;//发布的活动
    private Activity[] CollectionActivities;//收藏的活动

    public User( String yb_userid, String studentNumber, String username, String name, String grade, String major, String phoneNumber, String wechatNumber, Activity[] publishActivities, Activity[] collectionActivities) {
        this.yb_userid = yb_userid;
        this.studentNumber = studentNumber;
        this.username = username;
        this.name = name;
        this.grade = grade;
        this.major = major;
        this.phoneNumber = phoneNumber;
        this.wechatNumber = wechatNumber;
        this.publishActivities = publishActivities;
        CollectionActivities = collectionActivities;
    }
}
