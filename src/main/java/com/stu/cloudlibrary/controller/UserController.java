package com.stu.cloudlibrary.controller;

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
    public Map<String, Object> login(@RequestParam String name, @RequestParam String password) {
        logger.info("用户尝试登录，name: {}, password: {}", name, password);

        Map<String, Object> response = new HashMap<>();
        boolean success = userService.login(name, password);

        if (success) {
            response.put("status", "success");
            response.put("message", "登录成功");
            response.put("username", name); // 返回用户名，供前端显示
        } else {
            response.put("status", "fail");
            response.put("message", "用户名或密码错误");
        }

        return response;
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

    // 注销接口
    @PostMapping("/logout")
    public String logout() {
        return "注销成功";
    }

}
