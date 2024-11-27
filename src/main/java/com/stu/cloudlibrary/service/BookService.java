package com.stu.cloudlibrary.service;

import com.stu.cloudlibrary.mapper.BookMapper;
import com.stu.cloudlibrary.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    // 获取最新的五本图书
    public List<Book> getLatestBooks() {
        return bookMapper.findLatestBooks(); // 获取最新的五本图书
    }

    // 借阅图书
    public boolean borrowBook(Long bookId, String username) {
        // 获取当前时间和预计归还时间
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime returnTime = now.plusDays(7);

        // 格式化时间为 yyyy-MM-dd-HH-mm 格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
        String borrowTime = now.format(formatter);  // 借阅时间
        String returnTimeStr = returnTime.format(formatter); // 预计归还时间

        // 调用 Mapper 进行借阅操作
        int rowsAffected = bookMapper.borrowBook(bookId, username, borrowTime, returnTimeStr);
        return rowsAffected > 0;  // 如果影响的行数大于0，表示借阅成功
    }

    // 还书
    public boolean returnBook(Long bookId) {
        int rowsAffected = bookMapper.returnBook(bookId);
        return rowsAffected > 0;  // 如果影响的行数大于0，表示还书成功
    }

    // 根据ID查找图书
    public Book getBookById(Long bookId) {
        return bookMapper.findById(bookId);
    }
}
