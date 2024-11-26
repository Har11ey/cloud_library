package com.stu.cloudlibrary.repository;

import com.stu.cloudlibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    // 查询最新的五本图书，按上架时间降序排列
    List<Book> findTop5ByOrderByUploadTimeDesc();
}
