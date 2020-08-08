package edu.scau.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description: 认证信息
 * @author: whj
 * @create: 2020-08-07 22:22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationMessage {
    private int id;
    private int userId;//认证者的id
    private String associationName;//认证社团名称
    private boolean browsed;//是否已审核
    private int level;//认证权限
    private List<String> pictureUrl;

    public AuthenticationMessage(int userId, String associationName, int level, List<String> pictureUrl) {
        this.userId = userId;
        this.associationName = associationName;
        this.level = level;
        this.pictureUrl = pictureUrl;
    }
}
