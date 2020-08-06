package edu.scau.common.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @description: 认证相关接口
 * @author: whj
 * @create: 2020-08-06 22:19
 **/
public interface AuthenticationMapper {
    Integer insertAuthenticationMapper(@Param("userId") int userId);
}
