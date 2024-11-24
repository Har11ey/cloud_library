package com.stu.cloudlibrary.controller;

import com.stu.cloudlibrary.vo.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.stu.cloudlibrary.model.User;
import com.stu.cloudlibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    // 用户登录接口
    @PostMapping("/login")
    public ApiResponse<String> login(@RequestParam String name, @RequestParam String password) {
        logger.info("用户尝试登录，name: {}, password: {}", name, password);

        boolean success = userService.login(name, password);

        if (success) {
            return ApiResponse.success("登录成功");
        } else {
            return ApiResponse.failed("用户名或密码错误！");
        }
    }

    // 用户注册接口
    @PostMapping("/register")
    public ApiResponse<String> register(@RequestBody User user) {
        logger.info("用户尝试注册，用户信息: {}", user);

        boolean success = userService.register(user);

        if (success) {
            return ApiResponse.success("注册成功");
        } else {
            return ApiResponse.failed("注册失败");
        }
    }


    // 注销接口
    @PostMapping("/logout")
    public String logout() {
        return "注销成功";
    }

}
