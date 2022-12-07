package com.example.dockertest.Service;

import com.example.dockertest.Domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    //    查找
    public User findUser(@Param("id") String id);
//    增加

    public boolean addUser(@Param("user") User user);
}
