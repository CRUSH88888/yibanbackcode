package edu.scau.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Association {      //社团组织
    private int id;
    private String name;//社团名字
    private String introduce;//介绍
    private String href;//公众号
    private String type;//组织,学术科技类,公益实践类,文化艺术类,体育竞技类
    private List<String> picture;
    public Association(String name, String introduce, String href, String type,List<String>picture){
        this.name=name;
        this.introduce=introduce;
        this.href=href;
        this.type=type;
        this.picture=picture;
    }
}

