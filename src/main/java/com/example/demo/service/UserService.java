package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public  class UserService {
    //将dao层属性注入service层
    @Resource
    private UserMapper userMapper;
    //查询用户名密码，实现登录
    public User LoginIn(String name, String password) {
        return userMapper.getInfo(name,password);
    }
    //查询用户名，实现禁止相同用户名注册
    public User GatUser(String name) {
        return userMapper.wolfInfo(name);
    }
    //注入用户名密码，实现登录
    public void Insert(String name,String password){
        userMapper.saveInfo(name, password);
    }
    //查询id，实现通过id寻找用户
    public User GetUser(int id) {
        return userMapper.leafInfo(id);
    }
}
