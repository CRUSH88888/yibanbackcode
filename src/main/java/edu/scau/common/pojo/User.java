package edu.scau.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {         //用户信息
    private int id;
    private String studentNumber;//学号
    private String username;//用户名
    private String name;//真实名字
    private String grade;//年级学院
    private String major;//专业班级
    private String phoneNumber;//手机号码
    private String wechatNumber;//微信号码
    private Activity[] publishActivities;//发布的活动
    private Activity[] CollectionActivities;//收藏的活动
}
