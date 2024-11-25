package com.stu.cloudlibrary.service;

import com.stu.cloudlibrary.controller.UserController;
import com.stu.cloudlibrary.model.User;
import com.stu.cloudlibrary.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 登录验证
    public boolean login(String name, String password) {
        User user = userRepository.findByName(name);
        return user != null && user.getPassword().equals(password);
    }
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    // 注册功能
    public boolean register(User user) {
        boolean exists = userRepository.existsByName(user.getName());
        if (exists) {
            logger.info("用户名已存在: {}", user.getName());
            return false; // 如果用户名已存在
        }
        userRepository.save(user);
        logger.info("用户注册成功: {}", user);
        return true;
    }

}
