package edu.scau.common.mapper;

import edu.scau.common.pojo.Authentication;
import edu.scau.common.pojo.AuthenticationMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description: 认证信息
 * @author: whj
 * @create: 2020-08-07 23:12
 **/
@Mapper
public interface AuthenticationMessageMapper {
    Integer insertAuthenticationMessage(AuthenticationMessage authenticationMessage);
    Integer insertPicture(@Param("picture") String picture,@Param("authenticationId") int authenticationId);
    Integer getAuthenticationId(@Param("userId") int userId,@Param("associationName") String associationName);
    String getName(int userId);
    String getUserName(int userId);
}
