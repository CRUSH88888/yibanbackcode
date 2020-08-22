package edu.scau.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:消息订阅
 * @author: whj
 * @create: 2020-08-18 20:48
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageSubscribe {
    private String touser;//接受者openid
    private String template_id;//模板id
    private MessageData data;
}
