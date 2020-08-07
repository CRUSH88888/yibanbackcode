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
    private int userId;
    private String associationName;
    private boolean browsed;
    private List<String> pictureUrl;
}
