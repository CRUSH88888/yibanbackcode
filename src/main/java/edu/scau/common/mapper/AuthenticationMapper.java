package edu.scau.common.mapper;

import edu.scau.common.pojo.Authentication;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * @description: 认证相关接口
 * @author: whj
 * @create: 2020-08-06 22:19
 **/
@Mapper
public interface AuthenticationMapper {
    List<Authentication> getAuthentication(int userId);
    Integer deleteAuthentication(@Param("userId") int userId,@Param("level") int level,@Param("associationName") String associationName);
    List<String> AssociationAuthentication(@Param("userId") int userId);
    Integer getAssociationId(@Param("associationName") String associationName);
    List<Integer> getId(@Param("userId") int userId);
    Integer updateAssociationName(@Param("oldName") String oldName,@Param("newName")String newName);
    List<Integer> getLevel(int userId);
    List<Integer> getUserId();
    Integer getUserIdByName(String associationName);
}
