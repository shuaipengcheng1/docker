package com.example.dockertest.Controller;

import com.example.dockertest.Domain.User;
import com.example.dockertest.Service.UserService;
import com.example.dockertest.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class MainController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public Map<String,String> getMain(){
        Map<String,String> result = new HashMap<>();
        result.put("hello","world");
        return  result;
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public void addUser(){
        userService.addUser(new User("misaka","123", UUID.randomUUID().toString()));
    }
    @RequestMapping(value = "/findUser/{id}",method = RequestMethod.GET)
    public User findUser(@PathVariable String id){
        return  userService.findUser(id);
    }
}
