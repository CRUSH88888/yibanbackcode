package edu.scau.common.mapper;

import edu.scau.common.pojo.Authentication;
import edu.scau.common.pojo.AuthenticationMessage;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * @description: 认证信息
 * @author: whj
 * @create: 2020-08-07 23:12
 **/
@Mapper
public interface AuthenticationMessageMapper {
    Integer insertAuthenticationMessage(AuthenticationMessage authenticationMessage);
    Integer insertPicture(@Param("picture") String picture,@Param("authenticationId") int authenticationId);
    Integer getAuthenticationId(@Param("userId") int userId, @Param("associationName") String associationName, @Param("buildTime")Timestamp buildTime);
    String getName(int userId);
    String getRealName(int userId);
    List<AuthenticationMessage> getAuthenticationMessage();
    AuthenticationMessage getAuthenticationMessageById(int id);
    List<String> getPicture(int authenticationId);
    Integer insertAuthentication(Authentication authentication);
    Integer updateAuthentication(int id);
}
