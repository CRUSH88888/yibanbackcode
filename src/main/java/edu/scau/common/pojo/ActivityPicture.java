package edu.scau.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @auther:cyf
 * @create:2020/8/3 21:00
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityPicture {
    private Integer id;
    private String picUrl;

    public ActivityPicture(String picUrl) {
        this.picUrl = picUrl;
    }
}
