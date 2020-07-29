package edu.scau.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 留言
 * @author: whj
 * @create: 2020-07-24 22:13
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private int id;
    private int activityId;//活动id
    private int userId;//用户id
    private boolean browsed;//是否已看
    private String text;//留言内容
    public Message(int activityId,String text){
        this.activityId=activityId;
        this.text=text;
    }
}
