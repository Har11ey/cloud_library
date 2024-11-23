package com.stu.cloudlibrary.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.stu.cloudlibrary.model.User;
import com.stu.cloudlibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    // 用户登录接口
    @PostMapping("/login")
    public String login(@RequestParam String name, @RequestParam String password) {
        logger.info("用户尝试登录，name: {}, password: {}", name, password); // 这里可能收到合并后的值
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
