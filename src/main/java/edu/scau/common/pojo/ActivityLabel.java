package edu.scau.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @auther:cyf
 * @create:2020/7/29 15:10
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityLabel {
    private Integer id;
    private Integer label_code;
    private Integer activity_id;
}
