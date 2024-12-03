package com.stu.cloudlibrary.controller;

import com.stu.cloudlibrary.model.Book;
import com.stu.cloudlibrary.service.BookService;
import com.stu.cloudlibrary.vo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ApiResponse<Map<String, Long>> borrowBook(@RequestParam Long bookId, @RequestParam String username) {
        boolean success = bookService.borrowBook(bookId, username);
        if (success) {
            Map<String, Long> data = new HashMap<>();
            data.put("bookId",bookId);
            return ApiResponse.success(data,"借阅成功");
        } else {
            return ApiResponse.failed("借阅失败，图书不可借");
        }
    }

    // 还书
    @PostMapping("/return")
    public ApiResponse<Map<String, Long>> returnBook(@RequestParam Long bookId) {
        boolean success = bookService.returnBook(bookId);  // 调用业务逻辑层还书方法

        if (success) {
            // 创建一个返回数据的 Map
            Map<String, Long> data = new HashMap<>();
            data.put("bookId", bookId);  // 将图书ID放入返回的数据中

            // 返回成功响应
            return ApiResponse.success(data, "还书成功");
        } else {
            // 返回失败响应
            return ApiResponse.failed("还书失败，图书未借出");
        }
    }



    // 根据ID查找图书
    @GetMapping("/{bookId}")
    public ApiResponse<Book> getBookById(@PathVariable Long bookId) {
        Book book = bookService.getBookById(bookId);
        if (book != null) {
            return ApiResponse.success(book);
        } else {
            return ApiResponse.failed("图书未找到");
        }
    }
}
