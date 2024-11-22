package com.stu.cloudlibrary.repository;

import com.stu.cloudlibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);
    boolean existsByName(String name);
}
