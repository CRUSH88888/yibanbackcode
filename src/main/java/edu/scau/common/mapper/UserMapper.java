package edu.scau.common.mapper;

import edu.scau.common.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @description:
 * @auther:cyf
 * @create:2020/8/10 22:17
 **/
@Mapper
public interface UserMapper extends MySqlMapper<User>, BaseMapper<User> {
    Integer updateUser(User user);

}
