package com.example.dockertest.Dao;

import com.example.dockertest.Domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
//    查找
    public List<User> findUser(@Param("id") String id);
//    增加

    public int addUser(@Param("user") User user);

}
