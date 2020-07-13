package edu.scau.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Association {      //社团组织
    private int id;
    private String name;//社团名字
    private String introduce;//介绍
    private String href;//公众号
    private int type;//社团类型，1组织,2学术科技类,3公益实践类,4文化艺术类,5体育竞技类
}
