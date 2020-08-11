package edu.scau.common.Service;

import edu.scau.common.pojo.Authentication;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description: 认证
 * @author: whj
 * @create: 2020-08-07 15:48
 **/
public interface AuthenticationService {
    List<Authentication> getAuthentication(int userId);
    Integer deleteAuthentication(@Param("userId") int userId,@Param("level") int level,@Param("associationName") String associationName);
    List<String> updateAssociationAuthentication(@Param("userId") int userId);
    List<String> insertAssociationAuthentication(@Param("userId") int userId);
    Integer saveActivityAuthentication(@Param("userId") int userId);
}
