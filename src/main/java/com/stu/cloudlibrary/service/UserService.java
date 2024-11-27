package com.stu.cloudlibrary.service;

import com.stu.cloudlibrary.mapper.UserMapper;
import com.stu.cloudlibrary.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    // 用户登录验证
    public boolean login(String username, String password) {
        User user = userMapper.findByUsername(username);
        return user != null && user.getPassword().equals(password); // 检查用户名和密码是否匹配
    }

    // 用户注册
    public boolean register(User user) {
        // 检查用户名是否已存在
        User existingUser = userMapper.findByUsername(user.getName());
        if (existingUser != null) {
            return false; // 用户已存在
        }
        int rowsAffected = userMapper.register(user);
        return rowsAffected > 0; // 注册成功
    }
}
