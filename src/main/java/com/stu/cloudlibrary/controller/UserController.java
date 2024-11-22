package com.stu.cloudlibrary.controller;

import com.stu.cloudlibrary.model.User;
import com.stu.cloudlibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // 用户登录接口
    @PostMapping("/login")
    public String login(@RequestParam String name, @RequestParam String password) {
        boolean success = userService.login(name, password);
        if (success) {
            return "登录成功";
        }
        return "用户名或密码错误";
    }

    // 用户注册接口
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        boolean success = userService.register(user);
        if (success) {
            return "注册成功";
        }
        return "注册失败";
    }
}
