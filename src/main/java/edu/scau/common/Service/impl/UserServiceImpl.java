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
    public User saveUser(User user) {
        System.out.println("now there is someone want to login in,let we check does he had logined");
        User id = userMapper.selectByYBId(user.getYb_userid());
        if (id != null)
        {
            System.out.println(id);
            return id;
        }
        else {
            Integer result = userMapper.insertGenerateId(user);
            System.out.println(result);
            return user;
        }

    }

    @Override
    public Integer updateUser(User user) {
        User user1 = userMapper.checkName(user.getStudentNumber());

        if (user1==null){System.out.println(user1.toString());
            userMapper.insert(user);
        }
        return userMapper.updateUser(user);
    }

    @Override
    public User selectUserById(Integer id) {
        return userMapper.selectById(id);
    }
}
