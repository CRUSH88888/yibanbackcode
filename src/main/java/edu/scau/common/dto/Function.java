package edu.scau.common.dto;

import edu.scau.common.pojo.Information;
import edu.scau.common.pojo.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description: 功能页面
 * @author: whj
 * @create: 2020-08-01 21:28
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Function {
    private List<Schedule> schedules;//近期活动
    private List<Information> information;//信息中心
    private List<Message> messages;//留言
    private List<PublishManagement> publishManagements;//发布管理
}
