package com.stu.cloudlibrary.service;

import com.stu.cloudlibrary.model.User;
import com.stu.cloudlibrary.repository.UserRepository;
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

    // 注册功能
    public boolean register(User user) {
        if (userRepository.existsByName(user.getName())) {
            return false; // 如果用户名已存在
        }
        userRepository.save(user);
        return true;
    }
}
