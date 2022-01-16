package com.tang.goods.service;


import com.tang.goods.entity.User;
import com.tang.goods.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *文件名: UserService
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/13 13:19
 *描述: 这是一个示例
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public List<User> getAllUsers(){
        return userMapper.getAllUsers();
    }

    public User findUser(User user){
        return userMapper.findUser(user);
    }
}
