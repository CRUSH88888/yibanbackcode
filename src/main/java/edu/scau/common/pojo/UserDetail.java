package edu.scau.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:用于保存易班用户信息的中间类
 * @auther:cyf
 * @create:2020/8/7 15:25
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDetail {
    private Integer id;
    private String yb_username;//用户名",
    private String yb_userid;//易班用户id"
    private String yb_realname;//真实姓名
    private String yb_sex;//    "yb_sex":"性别",
    private String yb_userhead;//    "yb_userhead":"用户头像",
    private String yb_identity;//"用户身份"//枚举，学生、老师、辅导员、未认证

    /**
     * 用于/user/me
     * 用于获取当前用户基本信息
     * @param yb_userid
     * @param yb_sex
     * @param yb_userhead
     */
    public UserDetail(String yb_username,String yb_userid, String yb_sex,   String yb_userhead) {
        this.yb_username = yb_username;
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
    public UserDetail(Integer id,  String yb_realname,String yb_identity) {
        this.id = id;
        this.yb_realname = yb_realname;
        this.yb_identity = yb_identity;
    }
}
