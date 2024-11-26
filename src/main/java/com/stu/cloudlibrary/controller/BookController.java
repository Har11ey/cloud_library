package com.stu.cloudlibrary.controller;

import com.stu.cloudlibrary.model.Book;
import com.stu.cloudlibrary.service.BookService;
import com.stu.cloudlibrary.vo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // 获取最新的五本图书
    @GetMapping("/latest")
    public ApiResponse<List<Book>> getLatestBooks() {
        List<Book> books = bookService.getLatestBooks();
        return ApiResponse.success(books);
    }

    // 借阅图书
    @PostMapping("/borrow")
    public ApiResponse<String> borrowBook(@RequestParam Long bookId, @RequestParam String username) {
        boolean success = bookService.borrowBook(bookId, username);
        if (success) {
            return ApiResponse.success("借阅成功");
        } else {
            return ApiResponse.failed("借阅失败，图书不可借");
        }
    }
}
