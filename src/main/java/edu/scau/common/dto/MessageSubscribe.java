package edu.scau.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: whj
 * @create: 2020-08-18 20:48
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageSubscribe {
    private String touser;
    private String template_id;
    private MessageData data;
}
