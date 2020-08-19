package edu.scau.common.Service;

import edu.scau.common.pojo.User;

/**
 * @description:
 * @auther:cyf
 * @create:2020/8/10 22:18
 **/
public interface UserService {
    User saveUser(User user);
    Integer updateUser(User user);
    User selectUserById(Integer id);
}
