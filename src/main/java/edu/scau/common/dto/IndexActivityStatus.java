package edu.scau.common.dto;

import edu.scau.common.pojo.Activity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @auther:cyf
 * @create:2020/7/3 18:37
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexActivityStatus {
    Integer id;
    /*
    首页的某个活动
     */
    private Activity activity;
    /*
    这个活动是否查看过
     */
    private Boolean browsed;
}
