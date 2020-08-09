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
    private String yb_userid;//易班用户id",
    private String yb_username;//    "yb_username":"用户名",
    private String yb_usernick;//    "yb_usernick":"用户昵称",
    private String yb_sex;//    "yb_sex":"性别",
    private String yb_money;//    "yb_money":"持有网薪",
    private String yb_exp;//    "yb_exp":"经验值",
    private String yb_userhead;//    "yb_userhead":"用户头像",

}
