package edu.scau.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @description: 活动收藏,足迹，发布管理
 * @author: whj
 * @create: 2020-07-22 20:23
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityManger {
    private int id;//活动id
    private String title;//活动标题,组队信息，活动证明标题
    private Timestamp buildTime;//发布时间
    private String date;//发布时间至今
    private int type;//1:活动 2：活动证明 3：组队
    private boolean select;
}
