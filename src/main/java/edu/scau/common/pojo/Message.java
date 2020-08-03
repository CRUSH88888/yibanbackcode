package edu.scau.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;
import java.util.List;

/**
 * @description:
 * @auther:cyf
 * @create:2020/7/29 18:40
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Integer id;
    private Integer activityId;

    private String message;
    /**
     * 浏览
      */
    private Boolean browsed;
    private Integer userId;
}
