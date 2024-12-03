package com.stu.cloudlibrary.controller;

import com.stu.cloudlibrary.model.User;
import com.stu.cloudlibrary.service.UserService;
import com.stu.cloudlibrary.vo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // 用户登录
    @PostMapping("/login")
    public ApiResponse<Map<String, String>> login(@RequestParam String username, @RequestParam String password) {

        boolean success = userService.login(username, password);

        if (success) {
            Map<String, String> data = new HashMap<>();
            data.put("username", username);

            ApiResponse<Map<String, String>> response = ApiResponse.success(data, "登录成功");
            return response;

        } else {
            return ApiResponse.failed("用户名或密码错误！");
        }
    }

    // 用户注册接口
    @PostMapping("/register")
    public ApiResponse<String> register(@RequestBody User user) {

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
