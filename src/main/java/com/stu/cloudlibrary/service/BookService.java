package com.stu.cloudlibrary.service;

import com.stu.cloudlibrary.model.Book;
import com.stu.cloudlibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // 查询最新的五本图书
    public List<Book> getLatestBooks() {
        return bookRepository.findTop5ByOrderByUploadTimeDesc(); // 以上传时间降序排列，取前五本
    }

    // 借阅图书
    public boolean borrowBook(Long bookId, String username) {
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book != null && book.getStatus().equals("available")) { // 确保图书是可借阅的
            book.setStatus("borrowed");
            book.setBorrower(username);
            book.setBorrowTime(System.currentTimeMillis()); // 设置借阅时间
            book.setReturnTime(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000); // 预计归还时间（7天后）
            bookRepository.save(book);
            return true;
        }
        return false;
    }
}
