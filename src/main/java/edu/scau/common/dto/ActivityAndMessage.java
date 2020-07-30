package edu.scau.common.dto;

import edu.scau.common.pojo.Activity;
import edu.scau.common.pojo.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @auther:cyf
 * @create:2020/7/30 11:50
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityAndMessage {
    private Activity activity;
    private Message message;
}
