package com.tang.goods.mapper;

import com.tang.goods.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*
 *文件名: UserMapper
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/13 13:22
 *描述: 这是一个示例
 */
@Mapper
public interface UserMapper {
    List<User> getAllUsers();
    User findUser(User user);
}
