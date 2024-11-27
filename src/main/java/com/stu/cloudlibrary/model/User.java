package com.stu.cloudlibrary.model;

import lombok.Data;

@Data
public class User {
    private Long id;        // 用户ID
    private String name;    // 用户名
    private String password;// 密码
    private String email;   // 邮箱
    private String role;    // 角色
    private String status;  // 状态（例如：激活、禁用）
}
