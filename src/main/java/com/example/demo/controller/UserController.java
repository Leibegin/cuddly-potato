package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
@Slf4j
@Controller
public class UserController {
    //将Service注入Web层
    @Resource
    UserService userService;
    @Autowired
    //设定路径及展示界面
    @RequestMapping("/home")
    public String show(){
        return "home";
    }
    //实现登录 设定跳转方法
    @RequestMapping("/login")
    public String dsc(){
        return "login";
    }
    //与数据库进行比对，实现登录功能
    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String loginIn(String name,String password) {
        User user = userService.LoginIn(name, password);
        log.info("name:{}",name );
        log.info("password:{}",password);
        if(user != null){
            return "welcome";
        }else {
            return "error";
        }
    }
    //实现注册功能
    @RequestMapping("/signup")
    public String dsp(){
        return "signUp";
    }

    //利用Insert向数据库内添加数据 当账号在数据库已存在时报错
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(String name,String password) {
        User user = userService.GatUser(name);
        log.info("name:{}", name);
        log.info("password:{}", password);
        if (user != null) {
            return "wrong";
        }else {
            userService.Insert(name, password);
            return "success";
        }
    }
    //实现通过id查找用户功能
    @RequestMapping("/user")
    public String dsd() {return "user";}
    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
    public String getUser(Integer id, Model model) {
        User user = userService.GetUser(id);
        model.addAttribute("users",user);
        log.info("id:{}",id);
        if (user != null) {
            return "getUser";
        } else {
            return "false";
        }
    }

}