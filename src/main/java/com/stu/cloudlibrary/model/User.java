package com.stu.cloudlibrary.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data  // Lombok 自动生成 getter, setter, toString 等
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String password;

    private String email;
    private String role;
    private char status; // 'A' 激活，'I' 禁用
}
