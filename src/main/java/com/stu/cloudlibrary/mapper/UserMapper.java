package com.stu.cloudlibrary.mapper;

import com.stu.cloudlibrary.model.User;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserMapper {

    // 根据用户名查询用户
    @Select("SELECT * FROM user WHERE name = #{name}")
    User findByUsername(String name);

    // 注册用户
    @Insert("INSERT INTO user (name, password, email, role, status) " +
            "VALUES (#{name}, #{password}, #{email}, #{role}, #{status})")
    int register(User user);

    // 更新用户状态（例如激活或禁用）
    @Update("UPDATE user SET status = #{status} WHERE id = #{id}")
    int updateStatus(Long id, String status);
}
