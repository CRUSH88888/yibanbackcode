package edu.scau.common.Service;

import edu.scau.common.pojo.AuthenticationMessage;

/**
 * @description: 认证审核信息
 * @author: whj
 * @create: 2020-08-08 13:43
 **/
public interface AuthenticationMessageService {
    public Integer to_authentication(AuthenticationMessage authenticationMessage);
}
