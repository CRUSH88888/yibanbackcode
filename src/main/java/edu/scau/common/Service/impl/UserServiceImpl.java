package edu.scau.common.Service.impl;

import edu.scau.common.Service.UserService;
import edu.scau.common.mapper.UserMapper;
import edu.scau.common.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @auther:cyf
 * @create:2020/8/10 22:18
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer saveUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
