package edu.scau.common.mapper;

import edu.scau.common.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @description:
 * @auther:cyf
 * @create:2020/8/10 22:17
 **/
@Mapper
public interface UserMapper extends MySqlMapper<User>, BaseMapper<User> {
//    @Select("select * from user where student_number = #{student_number}")
    User checkName(String student_number);
    Integer updateUser(User user);
    User selectById(Integer id);
    List<User> selectByYBId(String yb_userid);
    Integer insertGenerateId(User user);
    Integer deleteUserById(Integer id);


}
