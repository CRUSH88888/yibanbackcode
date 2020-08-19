package edu.scau.common.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp buildTime;//建立时间

    public AuthenticationMessage(int userId, String associationName, int level, List<String> pictureUrl) {
        this.userId = userId;
        this.associationName = associationName;
        this.level = level;
        this.pictureUrl = pictureUrl;
    }

    public AuthenticationMessage(int id, int userId, String associationName, int level) {
        this.id = id;
        this.userId = userId;
        this.associationName = associationName;
        this.browsed = browsed;
        this.level = level;
    }
}
