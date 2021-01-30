package com.jackhance.rest.controller;

import com.alibaba.fastjson.JSON;
import com.jackhance.rest.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回响应体
 * <p>
 * 设置后就不会去寻找视图页面，而是直接输出字符串
 * <p>
 * 设置方式：
 * 1. @Controller + @ResponseBody
 * 2. @RestController
 */
// @Controller
@RestController
public class UserController {

    @RequestMapping("/j1")
    //    @ResponseBody
    public String json1() {
        User user = new User(1, "小王", 24);
        return JSON.toJSONString(user);
    }

    @RequestMapping("/j2")
    //    @ResponseBody
    public String json2() {
        User user1 = new User(1, "小王", 24);
        User user2 = new User(2, "小王", 24);
        User user3 = new User(3, "小王", 24);
        User user4 = new User(4, "小王", 24);
        List<User> users = new ArrayList<>(4);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        return JSON.toJSONString(users);
    }
}
