package edu.scau.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @description: 认证
 * @author: whj
 * @create: 2020-08-07 15:36
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authentication {
    private int id;
    private int userId; //用户id
    private int level;//用户权限 1:工作人员 2：负责人 3：管理员
    private Timestamp authenticationTime;//认证时间
    private String associationName;//认证社团名称
}
