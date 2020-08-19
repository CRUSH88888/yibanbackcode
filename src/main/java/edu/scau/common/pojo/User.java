package edu.scau.common.pojo;

import lombok.*;

/**
 * 用于用户填写个人信息时的类
 */
@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@NonNull
@Builder
public class User {         //用户信息
    private Integer id;
    private String studentNumber;//学号
    private String username;//用户名
    private String name;//真实名字
    private String grade;//年级学院
    private String major;//专业班级
    private String phoneNumber;//手机号码
    private String wechatNumber;//微信号码

    private String yb_username;//易班用户名
    private String yb_userid;//易班用户id"
    private String yb_realname;//真实姓名
    private String yb_sex;//    "yb_sex":"性别",
    private String yb_userhead;//    "yb_userhead":"用户头像",
    private String yb_identity;//"用户身份"//枚举，学生、老师、辅导员、未认证

    private Integer level;

//    private Activity[] publishActivities;//发布的活动
//    private Activity[] CollectionActivities;//收藏的活动

    public User( Integer id,  String studentNumber, String username, String name, String grade, String major, String phoneNumber, String wechatNumber) {
        this.id = id;
        this.studentNumber = studentNumber;
        this.username = username;
        this.name = name;
        this.grade = grade;
        this.major = major;
        this.phoneNumber = phoneNumber;
        this.wechatNumber = wechatNumber;
    }

    /**
     * 用于/user/me
     * 用于获取当前用户基本信息
     * @param yb_userid
     * @param yb_sex
     * @param yb_userhead
     */
    public User(String yb_userid, String yb_sex,   String yb_userhead) {
        this.yb_userid = yb_userid;
        this.yb_sex = yb_sex;
        this.yb_userhead = yb_userhead;
    }

    /**
     * 这个用于/user/real_me
     *  获取当前用户实名信息。
     * @param id
     * @param yb_realname
     * @param yb_identity
     */
    public User(Integer id,  String yb_realname,String yb_identity) {
        this.id = id;
        this.yb_realname = yb_realname;
        this.yb_identity = yb_identity;
    }

    public User(String studentNumber, String username, String name, String grade, String major, String phoneNumber, String wechatNumber, String yb_username, String yb_userid, String yb_realname, String yb_sex, String yb_userhead, String yb_identity) {

        this.studentNumber = studentNumber;
        this.username = username;
        this.name = name;
        this.grade = grade;
        this.major = major;
        this.phoneNumber = phoneNumber;
        this.wechatNumber = wechatNumber;
        this.yb_username = yb_username;
        this.yb_userid = yb_userid;
        this.yb_realname = yb_realname;
        this.yb_sex = yb_sex;
        this.yb_userhead = yb_userhead;
        this.yb_identity = yb_identity;

    }
    public User(String studentNumber, String username, String name, String grade, String major, String phoneNumber, String wechatNumber, String yb_username, String yb_userid, String yb_realname, String yb_sex, String yb_userhead) {

        this.studentNumber = studentNumber;
        this.username = username;
        this.name = name;
        this.grade = grade;
        this.major = major;
        this.phoneNumber = phoneNumber;
        this.wechatNumber = wechatNumber;
        this.yb_username = yb_username;
        this.yb_userid = yb_userid;
        this.yb_realname = yb_realname;
        this.yb_sex = yb_sex;
        this.yb_userhead = yb_userhead;

    }

    public User() {
    }

    public User(Integer id, String studentNumber, String username, String name, String grade, String major, String phoneNumber, String wechatNumber, String yb_username, String yb_userid, String yb_realname, String yb_sex, String yb_userhead, String yb_identity, Integer level) {
        this.id = id;
        this.studentNumber = studentNumber;
        this.username = username;
        this.name = name;
        this.grade = grade;
        this.major = major;
        this.phoneNumber = phoneNumber;
        this.wechatNumber = wechatNumber;
        this.yb_username = yb_username;
        this.yb_userid = yb_userid;
        this.yb_realname = yb_realname;
        this.yb_sex = yb_sex;
        this.yb_userhead = yb_userhead;
        this.yb_identity = yb_identity;
        this.level = level;
    }
}
