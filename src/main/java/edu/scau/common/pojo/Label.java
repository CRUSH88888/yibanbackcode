package edu.scau.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Label {        //标签
    private int activityId;             //活动id
    private Boolean propagandaConference;//宣讲会
    private Boolean match;              //比赛
    private Boolean volunteerActivities;//志愿活动
    private Boolean lecture;//讲座
    private Boolean movieFestival;//电影节
    private Boolean amusementActivity;//娱乐活动
    private Boolean universityLevel;//校级
    private Boolean collegeLevel;//院级
    private Boolean extraPints;//综测加分
    private Boolean volunteerTime;//志愿活动
    private Boolean other;//其它
}
